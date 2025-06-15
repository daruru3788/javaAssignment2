package map.mission;

import character.hero.Hero;
import character.job.Archer;
import character.job.Mage;
import character.job.Warrior;
import character.skill.archer.Evasion;
import character.skill.archer.PiercingArrow;
import character.skill.mage.ElementalExplode;
import character.skill.mage.ElementalSummon;
import character.skill.warrior.BloodCommand;
import character.skill.warrior.Duel;

/**
 * 레벨에 따라 미션을 생성하여 돌려주는 클래스.
 */
public class MissionBoard {
    /**
     * 영웅의 레벨에 맞는 미션을 반환한다. 미션이 없으면 null 반환.
     */
    public static Mission createMission(Hero hero) {
        int level = hero.level;
        if (level == 3) {
            if (hero.getJob() instanceof Warrior) {
                return new Mission("살쾡이 3마리 처치", "살쾡이", 3, 100, 80, new Duel());
            } else if (hero.getJob() instanceof Archer) {
                return new Mission("너구리 3마리 처치", "너구리", 3, 100, 80, new Evasion());
            } else if (hero.getJob() instanceof Mage) {
                return new Mission("들개 3마리 처치", "들개", 3, 100, 80, new ElementalSummon());
            }
        } else if (level == 5) {
            if (hero.getJob() instanceof Warrior) {
                return new Mission("곰 1마리 처치", "곰", 1, 200, 200, new BloodCommand());
            } else if (hero.getJob() instanceof Archer) {
                return new Mission("들개 2마리 처치", "들개", 2, 200, 200, new PiercingArrow());
            } else if (hero.getJob() instanceof Mage) {
                return new Mission("곰 1마리 처치", "곰", 1, 200, 200, new ElementalExplode());
            }
        }
        return null;
    }
}