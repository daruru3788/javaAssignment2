package character;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import character.spirit.Spirit;
import map.weaponShop.Weapon;

public class Character {
	public String name;
	public int hp, mp, level, power, defense, money, experience, spAttack, maxMp, maxHp;
	public Weapon weapon = null;

	private double evasionChance = 0.0;
	private Random rand = new Random();

	public void setEvasion(double chance) {
		this.evasionChance = chance;
	}

	public boolean tryEvade() {
		if (rand.nextDouble() < evasionChance) {
			this.evasionChance = 0.0;
			return true;
		}
		return false;
	}

	public List<Spirit> spirits = new ArrayList<>();

	public void onTurnEnd(Character user, Character target) {
		for (Spirit sp : spirits) {
			sp.attack(user, target);
		}
	}

	public void recoverMp(int amount) {
		mp += amount;
		if (mp > maxMp) {
			mp = maxMp;
		}
	}

	public boolean checkDeath() {
		if (this.hp < 0)
			return true;
		return false;
	}
}
