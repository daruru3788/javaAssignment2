package character.monster;

import character.Character;

public class Monster extends Character {
	private int expReward;
	private int goldReward;

	public void attack(Character user, Character target) {
		int damage = user.power - target.defense;
		if (damage <= 0) {
			System.out.printf("%s의 공격은 막혔다.\n", user.name);
			return;
		}

		target.hp -= damage;
		System.out.printf("%s의 공격으로 %s에게 %d의 피해를 주었다.\n", user.name, target.name, damage);
	}

	public Monster(String name, int hp, int power, int defense, int expReward, int goldReward) {
		this.name = name;
		this.hp = hp;
		this.power = power;
		this.defense = defense;
		this.expReward = expReward;
		this.goldReward = goldReward;
	}

	public void giveRewards(Character user) {
		user.experience += this.expReward;
		user.money += this.goldReward;
		System.out.printf("%s가 %d의 경험치와 %d 골드를 획득했다.\n", user.name, this.expReward, this.goldReward);
	}
}
