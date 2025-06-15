package character.job;

import character.hero.Job;
import character.skill.warrior.BloodCommand;
import character.skill.warrior.DrainSlash;
import character.skill.warrior.Duel;
import character.skill.warrior.FireStrike;

public class Warrior extends Job {
	public Warrior() {
		super("전사", 180, 0, 35, 25, 10);
	}

	protected void initSkills() {
		skills.add(new DrainSlash());
		skills.add(new FireStrike());
		skills.add(new Duel());
		skills.add(new BloodCommand());
	}
}
