package character.spirit;

import character.Character;

public class ManaSpirit extends Spirit {
	public ManaSpirit(Character user) {
		super("마나 정령", user.spAttack);
	}

	public void explode(Character user, Character target) {
		int MpRegen = (40 > user.maxMp - user.mp) ? user.maxMp - user.mp : 40;
		int damage = this.damage - target.defense;
		target.hp -= damage;
		user.mp += MpRegen;
		System.out.printf("마나 정령이 폭발하며 %s의 마나를 %d 회복시키고,\n%s에게 %d 만큼의 피해를 주었습니다.", user.name, MpRegen, target.name,
				damage);
	}
}
