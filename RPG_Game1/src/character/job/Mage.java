package character.job;

import character.hero.Job;
import character.skill.mage.FireBall;
import character.skill.mage.Meditation;

public class Mage extends Job {
	public Mage() {
		super("마법사", 80, 130, 10, 8, 30);
	}

	protected void initSkills() {
		skills.add(new Meditation());
		skills.add(new FireBall());
	}
}
