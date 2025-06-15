package map.weaponShop;

import java.util.ArrayList;
import java.util.List;

import character.hero.Hero;
import character.hero.Job;

public class WeaponShop {
        private List<Weapon> warriorWeapons = new ArrayList<>();
        private List<Weapon> archerWeapons = new ArrayList<>();
        private List<Weapon> mageWeapons = new ArrayList<>();

        public WeaponShop() {
                // Warrior weapons
                warriorWeapons.add(new Weapon("낡은 검", 100, 5, 0));
                warriorWeapons.add(new Weapon("청동 도끼", 300, 10, 0));
                warriorWeapons.add(new Weapon("마검", 1000, 15, 5));

                // Archer weapons
                archerWeapons.add(new Weapon("낡은 활", 100, 4, 0));
                archerWeapons.add(new Weapon("롱 보우", 300, 8, 0));
                archerWeapons.add(new Weapon("엘븐 보우", 1000, 12, 3));

                // Mage weapons
                mageWeapons.add(new Weapon("낡은 지팡이", 100, 2, 5));
                mageWeapons.add(new Weapon("마나 스태프", 400, 3, 10));
                mageWeapons.add(new Weapon("대마도사 지팡이", 1000, 5, 15));
        }

        private List<Weapon> getWeaponList(Job job) {
                switch (job.getJobName()) {
                case "전사":
                        return warriorWeapons;
                case "궁수":
                        return archerWeapons;
                case "마법사":
                        return mageWeapons;
                default:
                        return new ArrayList<>();
                }
        }

        public void showWeaponList(Job job) {
                List<Weapon> list = getWeaponList(job);
                for (int i = 0; i < list.size(); i++) {
                        Weapon w = list.get(i);
                        System.out.printf("%d. %s (공격력 +%d, 특수공격 +%d) - %d골드%n",
                                        i + 1, w.getName(), w.getPower(), w.getSpAttack(), w.getPrice());
                }
        }

        public void buyWeapon(Hero hero, int index) {
                List<Weapon> list = getWeaponList(hero.getJob());
                if (index < 0 || index >= list.size()) {
                        System.out.println("잘못된 번호입니다.");
                        return;
                }

                Weapon w = list.get(index);
                if (hero.money < w.getPrice()) {
                        System.out.println("골드가 부족합니다.");
                        return;
                }

                hero.money -= w.getPrice();
                w.equip(hero, w);
                System.out.printf("%s을(를) 구매하여 장착했습니다.%n", w.getName());
        }
}