package character.skill.archer;

import character.Character;
import character.skill.Skill;

public class PiercingArrow implements Skill {
	public String getName() {
		return "관통 사격";
	}

	public int getMpCost() {
		return 15;
	}

	public void use(Character user, Character target) {
		int damage = user.power + target.defense * 2;

		target.hp -= damage - target.defense;

		System.out.printf("%s가 %s에게 %d의 피해를 줬다.\n", user.name, target.name, damage);
	}
}
