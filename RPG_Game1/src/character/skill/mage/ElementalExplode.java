package character.skill.mage;

import character.Character;
import character.skill.Skill;
import character.spirit.Spirit;

public class ElementalExplode implements Skill {
	public String getName() {
		return "원소 발산";
	}

	public int getMpCost() {
		return 30;
	}

	public void use(Character user, Character target) {
		for (Spirit sp : user.spirits) {
			sp.explode(user, target);
		}
		user.spirits.clear();
	}
}
