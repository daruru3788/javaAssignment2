package map.mission;

import character.hero.Hero;
import character.skill.Skill;

/**
 * 간단한 퀘스트 정보를 저장하는 클래스.
 * 지정된 몬스터를 일정 횟수 처치하면 완료된다.
 */
public class Mission {
    private String description;
    private String targetName;
    private int targetCount;
    private int progress;
    private int rewardGold;
    private int rewardExp;
    private Skill rewardSkill;
    private boolean rewardGiven;

    public Mission(String description, String targetName, int targetCount,
                    int rewardGold, int rewardExp, Skill rewardSkill) {
        this.description = description;
        this.targetName = targetName;
        this.targetCount = targetCount;
        this.rewardGold = rewardGold;
        this.rewardExp = rewardExp;
        this.rewardSkill = rewardSkill;
    }

    /** 미션 설명 반환 */
    public String getDescription() {
        return description;
    }

    /** 목표 이름 반환 */
    public String getTargetName() {
        return targetName;
    }

    /** 현재 진행도 반환 */
    public int getProgress() {
        return progress;
    }

    /** 필요 처치 수 반환 */
    public int getTargetCount() {
        return targetCount;
    }

    /** 몬스터 처치 기록 */
    public void recordKill(String monsterName) {
        if (rewardGiven) return;
        if (monsterName.equals(targetName)) {
            progress++;
        }
    }

    /** 완료 여부 확인 */
    public boolean isComplete() {
        return progress >= targetCount;
    }

    /** 보상 지급 */
    public void giveReward(Hero hero) {
        if (rewardGiven || !isComplete()) {
            return;
        }
        hero.money += rewardGold;
        hero.experience += rewardExp;
        if (rewardSkill != null) {
            hero.getJob().addSkill(rewardSkill);
            System.out.printf("새로운 스킬 %s을(를) 배웠습니다.%n", rewardSkill.getName());
        }
        System.out.printf("미션 완료! %d 골드와 %d 경험치를 획득했습니다.%n",
                rewardGold, rewardExp);
        rewardGiven = true;
    }
}