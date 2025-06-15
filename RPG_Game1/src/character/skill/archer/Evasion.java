package character.skill.archer;

import character.Character;
import character.skill.Skill;

public class Evasion implements Skill {
	public String getName() {
		return "회피 준비";
	}

	public int getMpCost() {
		return 10;
	}

	public void use(Character user, Character target) {
		user.setEvasion(0.75);
		System.out.printf("%s가 회피 자세를 취했다.\n", user.name);
	}
}
