package character.spirit;

import character.Character;

public abstract class Spirit {
	protected String name;
	protected int damage;

	public Spirit(String name, int damage) {
		this.name = name;
		this.damage = damage;
	}

	public String getname() {
		return name;
	}

	public void attack(Character user, Character target) {
		target.hp -= damage;
		System.out.printf("%s의 정령 %s가 %s에게 %d의 피해를 주었다.%n", user.name, name, target.name, damage);
	}

	public void explode(Character user, Character target) {
	}
}
