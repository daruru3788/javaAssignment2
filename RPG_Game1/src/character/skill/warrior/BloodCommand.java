package character.skill.warrior;

import character.Character;
import character.skill.Skill;

public class BloodCommand implements Skill {
	public String getName() {
		return "피의 지배";
	}

	public int getMpCost() {
		return 0;
	}

	public void use(Character user, Character target) {
		int damage = target.maxHp / 10;
		int blood = (damage < user.maxHp - user.hp) ? damage : (user.maxHp - user.hp);
		target.hp -= damage;
		user.hp += blood;

		System.out.printf("%s가 %s에게 %d의 피해를 주었다.\n%s는 %d만큼 회복했다.\n", user.name, target.name, damage, user.name, blood);
	}
}