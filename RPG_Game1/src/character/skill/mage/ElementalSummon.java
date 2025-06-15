package character.skill.mage;

import java.util.Random;

import character.Character;
import character.skill.Skill;
import character.spirit.FireSpirit;
import character.spirit.LightSpirit;
import character.spirit.ManaSpirit;

public class ElementalSummon implements Skill {
	Random rand = new Random();

	public String getName() {
		return "정령 소환";
	}

	public int getMpCost() {
		return 20;
	}

	public void use(Character user, Character target) {
		for (int i = 0; i < 2; i++) {
			int rand_int = rand.nextInt(2);
			switch (rand_int) {
			case 0:
				user.spirits.add(new FireSpirit(user));
				System.out.println("불의 정령을 소환했습니다.");
			case 1:
				user.spirits.add(new ManaSpirit(user));
				System.out.println("마나 정령을 소환했습니다.");
			case 2:
				user.spirits.add(new LightSpirit(user));
				System.out.println("빛의 정령을 소환했습니다.");
			}
		}
	}
}
