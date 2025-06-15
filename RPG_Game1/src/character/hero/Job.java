package character.hero;

import java.util.ArrayList;
import java.util.List;

import character.skill.Skill;

public abstract class Job {
	private String jobName;
	private int baseHp, baseMp, basePower, baseDefense, baseSpAttack;
	protected List<Skill> skills = new ArrayList<>();

	public void addSkill(Skill skill) {
		skills.add(skill);
	}

	public Job(String jobName, int baseHp, int baseMp, int basePower, int baseDefense, int baseSpAttack) {
		this.jobName = jobName;
		this.baseHp = baseHp;
		this.baseMp = baseMp;
		this.basePower = basePower;
		this.baseDefense = baseDefense;
		this.baseSpAttack = baseSpAttack;
		initSkills();
	}

	protected abstract void initSkills();

	public String getJobName() {
		return jobName;
	}

	public int getBaseHp() {
		return baseHp;
	}

	public int getBaseMp() {
		return baseMp;
	}

	public int getBasePower() {
		return basePower;
	}

	public int getBaseDefense() {
		return baseDefense;
	}

	public int getBaseSpAttack() {
		return baseSpAttack;
	}

	public List<Skill> getSkills() {
		return skills;
	}
}
