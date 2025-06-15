package Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import character.hero.Hero;
import character.job.Archer;
import character.job.Mage;
import character.job.Warrior;
import character.monster.Bear;
import character.monster.Dingo;
import character.monster.Monster;
import character.monster.Racoon;
import character.monster.WildCat;
import character.skill.Skill;
import map.PotionShop;
import map.mission.Mission;
import map.mission.MissionBoard;
import map.weaponShop.WeaponShop;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        // 영웅 생성
        System.out.print("영웅의 이름을 입력하세요 : ");
        String name = s.next();
        System.out.println();
        System.out.println("1. 전사");
        System.out.println("2. 궁수");
        System.out.println("3. 마법사");
        System.out.println();
        System.out.print("직업의 번호를 입력하세요 : ");
        int jobNum = s.nextInt();

        Hero hero;
        switch (jobNum) {
        case 2:
            hero = new Hero(name, new Archer());
            break;
        case 3:
            hero = new Hero(name, new Mage());
            break;
        case 1:
        default:
            hero = new Hero(name, new Warrior());
            break;
        }

        List<Mission> missions = new ArrayList<>();
        WeaponShop weaponShop = new WeaponShop();
        PotionShop potionShop = new PotionShop();

        boolean running = true;
        while (running) {
            // 레벨에 맞는 신규 미션 생성
            Mission newMission = MissionBoard.createMission(hero);
            if (newMission != null && missions.stream().noneMatch(m -> m.getDescription().equals(newMission.getDescription()))) {
                missions.add(newMission);
                System.out.println("새로운 미션이 추가되었습니다: " + newMission.getDescription());
            }

            System.out.println();
            System.out.println("1. 사냥터");
            System.out.println("2. 미션 조회");
            System.out.println("3. 무기 상점");
            System.out.println("4. 포션 상점");
            System.out.println("5. 종료");
            System.out.print("메뉴 선택: ");
            int menu = s.nextInt();

            switch (menu) {
            case 1:
                hunt(hero, missions, s);
                if (hero.checkDeath()) {
                    System.out.println("영웅이 쓰러졌습니다. 게임을 종료합니다.");
                    running = false;
                }
                break;
            case 2:
                showMissions(missions);
                break;
            case 3:
                weaponShop.showWeaponList(hero.getJob());
                System.out.print("구매할 번호 입력(0: 취소) : ");
                int w = s.nextInt();
                if (w > 0)
                    weaponShop.buyWeapon(hero, w - 1);
                break;
            case 4:
                potionShop.showPotionList();
                System.out.print("구매할 번호 입력(0: 취소) : ");
                int p = s.nextInt();
                if (p > 0)
                    potionShop.buyPotion(hero, p - 1);
                break;
            case 5:
                running = false;
                break;
            default:
                System.out.println("잘못된 입력입니다.");
            }
        }
        s.close();
    }

    /** 사냥 진행 */
    private static void hunt(Hero hero, List<Mission> missions, Scanner s) {
        Monster[] monsters = { new Racoon(), new WildCat(), new Dingo(), new Bear() };
        System.out.println("사냥할 몬스터를 선택하세요.");
        for (int i = 0; i < monsters.length; i++) {
            System.out.printf("%d. %s (HP %d)%n", i + 1, monsters[i].name, monsters[i].hp);
        }
        System.out.print("번호 입력: ");
        int num = s.nextInt();
        if (num < 1 || num > monsters.length) {
            System.out.println("잘못된 번호입니다.");
            return;
        }

        Monster monster = monsters[num - 1];
        while (monster.hp > 0 && hero.hp > 0) {
            List<Skill> skills = hero.getJob().getSkills();
            System.out.println("\n스킬 선택");
            for (int i = 0; i < skills.size(); i++) {
                Skill sk = skills.get(i);
                System.out.printf("%d. %s (MP %d)%n", i + 1, sk.getName(), sk.getMpCost());
            }
            System.out.print("선택: ");
            int idx = s.nextInt();
            if (idx < 1 || idx > skills.size()) {
                System.out.println("잘못된 번호입니다.");
                continue;
            }

            Skill skill = skills.get(idx - 1);
            if (hero.mp < skill.getMpCost()) {
                System.out.println("마나가 부족합니다.");
                continue;
            }
            hero.mp -= skill.getMpCost();
            skill.use(hero, monster);
            hero.onTurnEnd(hero, monster);

            if (monster.checkDeath())
                break;

            if (!hero.tryEvade()) {
                monster.attack(monster, hero);
            } else {
                System.out.println("공격을 회피했습니다!");
            }
            hero.onTurnEnd(monster, hero);
        }

        if (hero.hp <= 0)
            return;

        System.out.printf("%s를 처치했습니다!%n", monster.name);
        monster.giveRewards(hero);
        hero.hp = hero.maxHp;
        hero.mp = hero.maxMp;

        // 레벨업 체크
        while (hero.experience >= hero.level * 100) {
            hero.level++;
            System.out.printf("레벨이 %d이(가) 되었습니다!%n", hero.level);
        }

        for (Mission m : missions) {
            m.recordKill(monster.name);
            if (m.isComplete()) {
                m.giveReward(hero);
            }
        }
    }

    /** 미션 목록 출력 */
    private static void showMissions(List<Mission> missions) {
        if (missions.isEmpty()) {
            System.out.println("진행 중인 미션이 없습니다.");
            return;
        }
        for (Mission m : missions) {
            System.out.printf("%s : %d/%d%s%n", m.getDescription(), m.getProgress(),
                    m.getTargetCount(), m.isComplete() ? " (완료)" : "");
        }
    }
}
