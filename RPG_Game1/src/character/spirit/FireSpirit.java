package character.spirit;

import character.Character;

public class FireSpirit extends Spirit {
	public FireSpirit(Character user) {
		super("불의 정령", user.spAttack * 2);
	}

	public void explode(Character user, Character target) {
		int damage = this.damage * 2 - user.defense;
		target.hp -= damage;

		System.out.printf("불의 정령이 폭발하며 %s에게 %d의 피해를 주었습니다.\n", target.name, damage);
	}
}
