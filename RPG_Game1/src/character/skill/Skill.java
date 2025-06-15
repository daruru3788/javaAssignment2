package character.skill;

import character.Character;

public interface Skill {
	String getName();

	int getMpCost();

	void use(Character user, Character target);
}
