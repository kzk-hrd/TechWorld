package shoshinsya12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Story {

	//public static boolean judgeHeroDead = false;
	//public static boolean judgeMagicianDead = false;
	//public static boolean judgeMonster1Dead = false;
	//public static boolean judgeMonster2Dead = false;
	public static int  count = 1;
	public static Charactor sh = null;
	public static Charactor sma = null;


	public static void main(String[] args) {

		// スーパー勇者インスタンス生成
		Scanner scan = new Scanner(System.in);

		Charactor sh = new SuperHero();
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

		Creature sm1 = new SuperMonster();

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

		Creature sm2 = new SuperMonster();

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

		Charactor sma = new SuperMagician();
		SuperMagician m = (SuperMagician)sma;

		System.out.println("魔法使いの名前を設定してください");
		sma.setName(scan4.nextLine());

		System.out.println("魔法使いの体力を設定してください");
		sma.setHp(scan4.nextInt());

		System.out.println("魔法使いの攻撃力を設定してください");
		sma.setAt(scan4.nextInt());

		System.out.println("魔法使いのMPを設定してください");
		m.setMp(scan4.nextInt());

		System.out.println("魔法使いの防御力を設定してください");
		sma.setDf(scan4.nextInt());

		System.out.println("魔法使いが誕生した");
		System.out.println("名前: " + sma.getName());
		System.out.println("体力: " + sma.getHp());
		System.out.println("攻撃力: " + sma.getAt());
		System.out.println("MP: " + m.getMp());
		System.out.println("防御力: " + sma.getDf());
		System.out.println();

		// 登場人物をリストに格納する
		List<Charactor> charactorList = new ArrayList<Charactor>();
		charactorList.add(sh);
		charactorList.add(sma);

		List<Creature> creatureList = new ArrayList<Creature>();
		creatureList.add(sm1);
		creatureList.add(sm2);

		// ストーリー
		// battleメソッドは、battleの最後HP判定して終了判定をbooleanで返して、trueの間loopにするとかのほうがコードがスマートになりそう。
		while((sh.getHp() > 0 || sma.getHp() > 0) && (sm1.getHp() > 0 || sm2.getHp() > 0)) {
			System.out.println("========" + count + "ターン目==========");
			battle(charactorList, creatureList, count);

			System.out.println();
			System.out.println(sh.getName() + "の残りHP" + sh.getHp());
			System.out.println(sm1.getName() + "の残りHP" + sm1.getHp());
			System.out.println(sm2.getName() + "の残りHP" + sm2.getHp());
			System.out.println(sma.getName() + "の残りHP" + sma.getHp());

			count++;
		}

		// 勝敗判定
		if(sh.getHp() <= 0 && sma.getHp() <= 0) {
			System.out.println(sm1.getName() + ", " + sm2.getName() + "の勝利です");
		} else {
			System.out.println(sh.getName() + ", " + sma.getName() + "の勝利です");
		}
	}

	// バトルメソッド
	public static void battle(List<Charactor> charactorList, List<Creature> creatureList, int count) {

		// 初回のみcharactorListから値を取得
		if(count == 1) {
			sh = charactorList.get(0);
			sma = charactorList.get(1);
		}


		// SuperHeroの攻撃
		if(sh.getHp() > 0) {
			SuperHero superHero = (SuperHero)sh;
			superHero.attack(creatureList);
		}

		// SuperMonsterの攻撃
		if(!creatureList.isEmpty()) {
			for(int i=0; i<creatureList.size(); i++) {
				SuperMonster superMonster = (SuperMonster)creatureList.get(i);
				if(!charactorList.isEmpty()) {
					superMonster.attack(charactorList);
				}
			}
		}

		// SuperMagicianの攻撃
		if(sma.getHp() > 0) {
			SuperMagician superMagician = (SuperMagician)sma;
			superMagician.exMagicAttack(creatureList);
			for(int i=0; i < creatureList.size(); i++) {
				if(creatureList.get(i).getHp() <= 0) {
					System.out.println(creatureList.get(i).getName() + "のHPが0になりました。");
					creatureList.remove(i);
				}
			}
		}
	}
}
