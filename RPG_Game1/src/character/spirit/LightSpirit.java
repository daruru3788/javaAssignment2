package character.spirit;

import character.Character;

public class LightSpirit extends Spirit {
	public LightSpirit(Character user) {
		super("빛의 정령", user.spAttack / 2);
	}

	public void explode(Character user, Character target) {
		int HpRegen = (40 > user.maxHp - user.hp) ? user.maxHp - user.hp : 40;
		int damage = this.damage - target.defense;
		target.hp -= damage;
		user.mp += HpRegen;
		System.out.printf("빛의 정령이 폭발하며 %s의 체력을 %d 회복시키고,\n%s에게 %d 만큼의 피해를 주었습니다.", user.name, HpRegen, target.name,
				damage);
	}
}
