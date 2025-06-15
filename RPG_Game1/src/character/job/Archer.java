package character.job;

import character.hero.Job;
import character.skill.archer.ArrowShot;
import character.skill.archer.MultiShot;

public class Archer extends Job {

	public Archer() {
		super("궁수", 110, 70, 25, 15, 20);
	}

	protected void initSkills() {
		skills.add(new ArrowShot());
		skills.add(new MultiShot());
	}
}
