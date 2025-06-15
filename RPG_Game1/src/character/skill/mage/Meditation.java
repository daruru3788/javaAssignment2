package character.skill.mage;

import character.Character;
import character.skill.Skill;

public class Meditation implements Skill {
	public String getName() {
		return "명상";
	}

	public int getMpCost() {
		return 0;
	}

	public void use(Character user, Character target) {
		int MpRegen = (30 > user.maxMp - user.mp) ? user.maxMp - user.mp : 30;

		user.mp += MpRegen;
		System.out.printf("%s가 명상으로 마나를 %d 회복했습니다.\n", user.name, MpRegen);
	}
}
