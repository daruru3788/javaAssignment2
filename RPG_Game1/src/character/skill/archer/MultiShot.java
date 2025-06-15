package character.skill.archer;

import character.Character;
import character.skill.Skill;

public class MultiShot implements Skill {
	public String getName() {
		return "연속 사격";
	}

	public int getMpCost() {
		return 10;
	}

	public void use(Character user, Character target) {
		int damage = user.power - target.defense;

		if (damage <= 0) {
			System.out.printf("%s의 공격은 막혔다.\n", user.name);
			return;
		}

		for (int i = 1; i <= 3; i++) {
			target.hp -= damage;
			System.out.printf("%s의 %d번째 사격으로 %s에게 %d의 피해를 주었다.\n", user.name, i, target.name, damage);
		}
	}
}
