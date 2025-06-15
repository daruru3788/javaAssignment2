package character.skill.warrior;

import character.Character;
import character.skill.Skill;

public class FireStrike implements Skill {
	public String getName() {
		return "화염 강타";
	}

	public int getMpCost() {
		return 0;
	}

	public void use(Character user, Character target) {
		user.hp -= 10;
		int damage = user.power * 3 - target.defense;

		target.hp -= damage;
		System.out.printf("%s의 공격으로 %s에게 %d 만큼의 피해를 주었다.\n 반동으로 %s도 10의 피해를 입었다.\n", user.name, target.name, damage,
				user.name);
	}
}
