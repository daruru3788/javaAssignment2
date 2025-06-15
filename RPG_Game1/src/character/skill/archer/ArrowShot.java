package character.skill.archer;

import character.Character;
import character.skill.Skill;

public class ArrowShot implements Skill {
	public String getName() {
		return "화살 사격";
	}

	public int getMpCost() {
		return 0;
	}

	public void use(Character user, Character target) {
		int damage = user.power + 5;

		int mpRegen = 10;
		user.recoverMp(mpRegen);

		if (damage - target.defense < 0) {
			System.out.printf("%s의 공격이 막혔다,\n %d의 마나를 회복했다.\n", user.name, mpRegen);
			return;
		}
		target.hp -= damage - target.defense;

		System.out.printf("%s가 %s에게 %d의 피해를 주고,%n %d의 마나를 회복했다.\n", user.name, target.name, damage, mpRegen);
	}
}
