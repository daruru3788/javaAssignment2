package Main;

import java.util.Scanner;

import character.hero.Hero;
import character.job.Warrior;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		System.out.print("영웅의 이름을 입력하세요 : ");
		String name = s.next();
		System.out.println("");
		System.out.println("1. 전사");
		System.out.println("2. 궁수");
		System.out.println("3. 마법사");
		System.out.println("4. 정령술사");
		System.out.println("");
		System.out.print("직업의 번호를 입력하세요 : ");
		int jobNum = s.nextInt();

		switch (jobNum) {
		case 1:
			Hero user = new Hero(name, new Warrior());
		}
	}

}
