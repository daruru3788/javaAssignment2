package character.skill.warrior;

import character.Character;
import character.skill.Skill;

public class DrainSlash implements Skill {
	public String getName() {
		return "흡혈 베기";
	}

	public int getMpCost() {
		return 0;
	}

	public void use(Character user, Character target) {
		int damage = user.power + 5;

		int hpRegen = 15;

		if (damage - target.defense < 0) {
			System.out.printf("%s의 공격이 막혔다,\n %d의 체력을 흡수했다.\n", user.name, hpRegen);
			return;
		}
		target.hp -= damage - target.defense;

		System.out.printf("%s가 %s에게 %d의 피해를 주고,\n %d의 체력을 흡수했다.\n", user.name, target.name, damage, hpRegen);
	}
}
