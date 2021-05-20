package shoshinsya9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Story10_3 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		// スーパー勇者インスタンス生成
		Scanner scan = new Scanner(System.in);

		SuperHero sh = new SuperHero();
		System.out.println("勇者の名前を設定してください");
		sh.setName(scan.nextLine());

		System.out.println("勇者の体力を設定してください");
		sh.setHp(scan.nextInt());

		System.out.println("勇者の攻撃力を設定してください");
		sh.setAt(scan.nextInt());

		System.out.println("勇者の防御力を設定してください");
		sh.setDf(scan.nextInt());

		System.out.println("勇者が誕生した");
		System.out.println("名前: " + sh.getName());
		System.out.println("体力: " + sh.getHp());
		System.out.println("攻撃力: " + sh.getAt());
		System.out.println("防御力: " + sh.getDf());
		System.out.println();

		// スーパーモンスターインスタンス生成
		Scanner scan2 = new Scanner(System.in);

		SuperMonster sm1 = new SuperMonster();

		System.out.println("モンスターの名前を設定してください");
		sm1.setName(scan2.nextLine());

		System.out.println("モンスターの体力を設定してください");
		sm1.setHp(scan2.nextInt());

		System.out.println("モンスターの攻撃力を設定してください");
		sm1.setAt(scan2.nextInt());

		System.out.println("モンスターの防御力を設定してください");
		sm1.setDf(scan2.nextInt());

		System.out.println("モンスターが誕生した");
		System.out.println("名前: " + sm1.getName());
		System.out.println("体力: " + sm1.getHp());
		System.out.println("攻撃力: " + sm1.getAt());
		System.out.println("防御力: " + sm1.getDf());
		System.out.println();

		// スーパーモンスターインスタンス生成
		Scanner scan3 = new Scanner(System.in);

		SuperMonster sm2 = new SuperMonster();

		System.out.println("モンスターの名前を設定してください");
		sm2.setName(scan3.nextLine());

		System.out.println("モンスターの体力を設定してください");
		sm2.setHp(scan3.nextInt());

		System.out.println("モンスターの攻撃力を設定してください");
		sm2.setAt(scan3.nextInt());

		System.out.println("モンスターの防御力を設定してください");
		sm2.setDf(scan3.nextInt());

		System.out.println("モンスターが誕生した");
		System.out.println("名前: " + sm2.getName());
		System.out.println("体力: " + sm2.getHp());
		System.out.println("攻撃力: " + sm2.getAt());
		System.out.println("防御力: " + sm2.getDf());
		System.out.println();

		// スーパー魔法使いインスタンス生成
		Scanner scan4 = new Scanner(System.in);

		SuperMagician sma = new SuperMagician();

		System.out.println("魔法使いの名前を設定してください");
		sma.setName(scan4.nextLine());

		System.out.println("魔法使いの体力を設定してください");
		sma.setHp(scan4.nextInt());

		System.out.println("魔法使いの攻撃力を設定してください");
		sma.setAt(scan4.nextInt());

		System.out.println("魔法使いのMPを設定してください");
		sma.setMp(scan4.nextInt());

		System.out.println("魔法使いの防御力を設定してください");
		sma.setDf(scan4.nextInt());

		System.out.println("魔法使いが誕生した");
		System.out.println("名前: " + sma.getName());
		System.out.println("体力: " + sma.getHp());
		System.out.println("攻撃力: " + sma.getAt());
		System.out.println("MP: " + sma.getMp());
		System.out.println("防御力: " + sma.getDf());
		System.out.println();

		// 変数宣言
		int count = 1;
		boolean judgeHeroDead = false;				// shのhp判定
		boolean judgeMagicianDead = false;         // smaのhp判定

		// Monster格納用リスト
		List<Monster> monsterList = new ArrayList<Monster>();
		monsterList.add(sm1);
		monsterList.add(sm2);

		/*
		 * ストーリー
		 *
		 */
		while((sh.getHp() > 0 || sma.getHp() > 0) && (sm1.getHp() > 0 || sm2.getHp() > 0)) {

			System.out.println("========" + count + "ターン目==========");

			// SuperHeroの攻撃
			if(!judgeHeroDead) {
				sh.attack(monsterList);
			}
			if(monsterList.isEmpty()) {
				break;
			}


			// SuperMonsterの攻撃
			for(int i=0; i<monsterList.size(); i++) {
				Monster monsterAt = monsterList.get(i);
				if(!judgeHeroDead) {
					monsterAt.attackHero(sh, sma);
					if(sh.getHp() <= 0) {
						System.out.println(sh.getName() + "のHPが0になりました。");
						judgeHeroDead = true;
					}
				} else if(!judgeMagicianDead) {
					monsterAt.attackMagician(sma, sh);
					if(sma.getHp() <= 0) {
						System.out.println(sma.getHp() + "のHPが0になりました。");
						judgeMagicianDead = true;
					}
				}
			}

			// SuperMagicianの攻撃
			if(!judgeMagicianDead) {
				sma.exMagicAttack(monsterList);
				for(int i=0; i < monsterList.size(); i++) {
					if(monsterList.get(i).getHp() <= 0) {
						System.out.println(monsterList.get(i).getName() + "のHPが0になりました。");
						monsterList.remove(i);
					}
				}
			}

			System.out.println();
			System.out.println(sh.getName() + "の残りHP" + sh.getHp());
			System.out.println(sm1.getName() + "の残りHP" + sm1.getHp());
			System.out.println(sm2.getName() + "の残りHP" + sm2.getHp());
			System.out.println(sma.getName() + "の残りHP" + sma.getHp());

			count++;
		}

		// 勝敗判定
		if(judgeHeroDead && judgeMagicianDead) {
			System.out.println(sm1.getName() + ", " + sm2.getName() + "の勝利です");
		} else {
			System.out.println(sh.getName() + ", " + sma.getName() + "の勝利です");
		}
	}

}
