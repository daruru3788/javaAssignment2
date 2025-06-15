package map;

import java.util.ArrayList;
import java.util.List;

import character.hero.Hero;

/**
 * 능력치를 상승시키는 포션을 판매하는 상점.
 */
public class PotionShop {
    private static class Potion {
        String name;
        int price;
        PotionEffect effect;

        Potion(String name, int price, PotionEffect effect) {
            this.name = name;
            this.price = price;
            this.effect = effect;
        }
    }

    @FunctionalInterface
    private interface PotionEffect {
        void apply(Hero hero);
    }

    private List<Potion> potions = new ArrayList<>();

    public PotionShop() {
        potions.add(new Potion("힘의 포션", 50, h -> h.power += 5));
        potions.add(new Potion("방어의 포션", 50, h -> h.defense += 5));
        potions.add(new Potion("체력의 포션", 50, h -> { h.maxHp += 20; h.hp += 20; }));
        potions.add(new Potion("마나의 포션", 50, h -> { h.maxMp += 10; h.mp += 10; }));
    }

    /** 포션 목록 출력 */
    public void showPotionList() {
        for (int i = 0; i < potions.size(); i++) {
            Potion p = potions.get(i);
            System.out.printf("%d. %s - %d골드%n", i + 1, p.name, p.price);
        }
    }

    /** 포션 구매 */
    public void buyPotion(Hero hero, int index) {
        if (index < 0 || index >= potions.size()) {
            System.out.println("잘못된 번호입니다.");
            return;
        }

        Potion p = potions.get(index);
        if (hero.money < p.price) {
            System.out.println("골드가 부족합니다.");
            return;
        }

        hero.money -= p.price;
        p.effect.apply(hero);
        System.out.printf("%s를 사용하여 능력치가 상승했습니다.%n", p.name);
    }
}