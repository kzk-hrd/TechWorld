package shoshinsya9;

import java.util.Scanner;

public class Story {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		Scanner scan = new Scanner(System.in);

		// 勇者インスタンス生成
		Hero h = new Hero();

		System.out.println("勇者の名前を設定してください");
		h.setName(scan.nextLine());

		System.out.println("勇者の体力を設定してください");
		h.setHp(scan.nextInt());

		System.out.println("勇者の攻撃力を設定してください");
		h.setAt(scan.nextInt());

		System.out.println("勇者の防御力を設定してください");
		h.setDf(scan.nextInt());

		System.out.println("勇者が誕生した");
		System.out.println("名前: " + h.getName());
		System.out.println("体力: " + h.getHp());
		System.out.println("攻撃力: " + h.getAt());
		System.out.println("防御力: " + h.getDf());
		System.out.println();

		// モンスターインスタンス生成
		Scanner scan2 = new Scanner(System.in);

		Monster m = new Monster();

		System.out.println("モンスターの名前を設定してください");
		m.setName(scan2.nextLine());

		System.out.println("モンスターの体力を設定してください");
		m.setHp(scan2.nextInt());

		System.out.println("モンスターの攻撃力を設定してください");
		m.setAt(scan2.nextInt());

		System.out.println("モンスターの防御力を設定してください");
		m.setDf(scan2.nextInt());

		System.out.println("モンスターが誕生した");
		System.out.println("名前: " + m.getName());
		System.out.println("体力: " + m.getHp());
		System.out.println("攻撃力: " + m.getAt());
		System.out.println("防御力: " + m.getDf());
		System.out.println();

		int count = 1;							// ターン数格納変数
		boolean judgeHeroDead = false;				// Heroのhp判定
		boolean judgeMonsterDead = false;			// Monsterのhp判定

		while(h.getHp() > 0 || m.getHp() > 0) {
			System.out.println("========" + count + "ターン目==========");

			// ヒーローの攻撃
			h.attack(m);
			if(m.getHp() <= 0) {
				judgeMonsterDead = true;
				break;
			}

			// モンスターの攻撃
			m.attackHero(h);
			if(h.getHp() <= 0) {
				judgeHeroDead = true;
				break;
			}
			// ターン数+1
			count++;
		}

		// 勝敗判定
		if(judgeHeroDead) {
			System.out.println(m.getName() + "の勝利です");
		} else if(judgeMonsterDead) {
			System.out.println(h.getName() + "の勝利です");
		}

	}

}
