package character.skill.warrior;

import character.Character;
import character.skill.Skill;

public class Duel implements Skill {
	public String getName() {
		return "결투 신청";
	}

	public int getMpCost() {
		return 0;
	}

	public void use(Character user, Character target) {
		int stolen_hp, stolen_defense, stolen_power;
		stolen_hp = target.maxHp / 10;
		stolen_defense = target.defense / 10;
		stolen_power = target.power / 10;

		target.hp -= stolen_hp;
		target.defense -= stolen_defense;
		target.power -= stolen_power;

		user.hp -= 20;

		System.out.printf(
				"%s는 %s에게 결투를 신청했다.\n%d만큼의 체력을 빼앗았다.\n%d만큼의 방어력을 빼앗았다\n%d만큼의 힘을 빼앗았다.\n반동으로 %s는 20만큼의 피해를 입었다.\n",
				user.name, target.name, stolen_hp, stolen_defense, stolen_power, user.name);
	}
}
