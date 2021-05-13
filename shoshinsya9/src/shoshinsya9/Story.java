package shoshinsya9;

import java.util.ArrayList;
import java.util.List;
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

		// モンスターインスタンス生成
		Scanner scan3 = new Scanner(System.in);

		Monster m2 = new Monster();

		System.out.println("モンスターの名前を設定してください");
		m2.setName(scan3.nextLine());

		System.out.println("モンスターの体力を設定してください");
		m2.setHp(scan3.nextInt());

		System.out.println("モンスターの攻撃力を設定してください");
		m2.setAt(scan3.nextInt());

		System.out.println("モンスターの防御力を設定してください");
		m2.setDf(scan3.nextInt());

		System.out.println("モンスターが誕生した");
		System.out.println("名前: " + m2.getName());
		System.out.println("体力: " + m2.getHp());
		System.out.println("攻撃力: " + m2.getAt());
		System.out.println("防御力: " + m2.getDf());
		System.out.println();

		// 魔法使いインスタンス生成
		Scanner scan4 = new Scanner(System.in);

		Magician ma = new Magician();

		System.out.println("魔法使いの名前を設定してください");
		ma.setName(scan4.nextLine());

		System.out.println("魔法使いの体力を設定してください");
		ma.setHp(scan4.nextInt());

		System.out.println("魔法使いの攻撃力を設定してください");
		ma.setAt(scan4.nextInt());

		System.out.println("魔法使いのMPを設定してください");
		ma.setMp(scan4.nextInt());

		System.out.println("魔法使いの防御力を設定してください");
		ma.setDf(scan4.nextInt());

		System.out.println("魔法使いが誕生した");
		System.out.println("名前: " + ma.getName());
		System.out.println("体力: " + ma.getHp());
		System.out.println("攻撃力: " + ma.getAt());
		System.out.println("MP: " + ma.getMp());
		System.out.println("防御力: " + ma.getDf());
		System.out.println();

		int count = 1;							                // ターン数格納変数
		boolean judgeHeroDead = false;				// hのhp判定
		boolean judgeMagicianDead = false;         // Maのhp判定

		// Monster格納用リスト
		List<Monster> monsterList = new ArrayList<Monster>();

		/*
		 * ストーリー
		 *
		 */
		while((h.getHp() > 0 || ma.getHp() > 0) && (m.getHp() > 0 || m2.getHp() > 0)) {

			// Monster生存リスト作成
			if(m.getHp() > 0 && m2.getHp() > 0) {
				monsterList.add(m);
				monsterList.add(m2);
			} else if(m.getHp() > 0 && m2.getHp() <= 0) {
				monsterList.add(m);
			} else if(m.getHp() <= 0 && m2.getHp() > 0) {
				monsterList.add(m2);
			}

			System.out.println("========" + count + "ターン目==========");

			// Heroの攻撃
			if(!judgeHeroDead) {
				Monster monster = monsterList.get(0);
				h.attack(monster);
				if(monster.getHp() <= 0) {
					System.out.println(monster.getName() + "のHPが0になりました。");
					monsterList.remove(0);
				}
			}

			// Monsterの攻撃
			for(int i=0; i<monsterList.size(); i++) {
				Monster monsterAt = monsterList.get(i);
				if(!judgeHeroDead) {
					monsterAt.attackHero(h);
					if(h.getHp() <= 0) {
						System.out.println(h.getName() + "のHPが0になりました。");
						judgeHeroDead = true;
					}
				} else if(!judgeMagicianDead) {
					monsterAt.attackMagician(ma);
					if(ma.getHp() <= 0) {
						System.out.println(ma.getHp() + "のHPが0になりました。");
						judgeMagicianDead = true;
					}
				}
			}

			// Magicianの攻撃
			if(!judgeMagicianDead) {
				ma.magicAttack(monsterList);
			}

			System.out.println();
			System.out.println(h.getName() + "の残りHP" + h.getHp());
			System.out.println(m.getName() + "の残りHP" + m.getHp());
			System.out.println(m2.getName() + "の残りHP" + m2.getHp());
			System.out.println(ma.getName() + "の残りHP" + ma.getHp());

			count++;

			// ターン終了時にはモンスターリストをクリアする
			monsterList.clear();
		}

		// 勝敗判定
		if(judgeHeroDead && judgeMagicianDead) {
			System.out.println(m.getName() + ", " + m2.getName() + "の勝利です");
		} else {
			System.out.println(h.getName() + ", " + ma.getName() + "の勝利です");
		}
	}
}
