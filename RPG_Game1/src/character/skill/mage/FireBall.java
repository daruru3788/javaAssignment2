package character.skill.mage;

import character.Character;
import character.skill.Skill;

public class FireBall implements Skill {
	public String getName() {
		return "파이어볼";
	}

	public int getMpCost() {
		return 20;
	}

	public void use(Character user, Character target) {
		int damage = user.spAttack * 2 - target.defense;

		if (damage < 0) {
			System.out.printf("%s의 공격은 막혔다.\n", user.name);
			return;
		}

		target.hp -= damage;
		System.out.printf("%s가 %s에게 %d의 피해를 주었다.\n", user.name, target.name, damage);
	}
}
