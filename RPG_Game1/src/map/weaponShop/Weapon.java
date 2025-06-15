package map.weaponShop;

import character.Character;

public class Weapon {
	protected int price, power, spAttack;
	protected String name, ableClass;

	public Weapon(String name, int price, int power, int spAttack) {
		this.name = name;
		this.price = price;
		this.power = power;
		this.spAttack = spAttack;
	}

	public void equip(Character user, Weapon weapon) {
			if (user.weapon != null) {
					user.power -= user.weapon.power;
					user.spAttack -= user.weapon.spAttack;
			}
			user.power += weapon.power;
			user.spAttack += weapon.spAttack;
			user.weapon = weapon;
	}

	public int getPrice() {
			return price;
	}

	public String getName() {
			return name;
	}

	public int getPower() {
			return power;
	}

	public int getSpAttack() {
			return spAttack;
	}
}
