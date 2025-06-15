package character.hero;

import character.Character;

public class Hero extends Character {
	public String userName;
	Job job;

	public Hero(String userName, Job job) {
		this.userName = userName;
		this.job = job;

		this.name = job.getJobName();
		this.hp = job.getBaseHp();
		this.mp = job.getBaseMp();
		this.power = job.getBasePower();
		this.defense = job.getBaseDefense();
		this.spAttack = job.getBaseSpAttack();
		this.maxMp = job.getBaseMp();
		this.maxHp = job.getBaseHp();

		this.level = 1;
		this.money = 0;
		this.experience = 0;
	}

	public Job getJob() {
		return job;
	}
}
