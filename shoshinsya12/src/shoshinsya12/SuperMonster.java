package shoshinsya12;

import java.util.List;

public class SuperMonster extends Monster {

	private static int numOfPoisonAttack = 5;

	// オーバーライド
	public void attack(List<Charactor> charactorList) {

		System.out.println(super.getName() + "の攻撃!");
		Charactor charactor = charactorList.get(0);
		System.out.println(charactor.getName() + "に" + super.getAt() + "のダメージを与えた！");
		charactor.setHp(charactor.getHp() - super.getAt());

		// 追加毒攻撃の対象判定
		if(numOfPoisonAttack > 0 && charactor.getHp() > 0) {
			System.out.println("毒による追加攻撃");
			System.out.println(charactor.getName() + "に" + super.getAt() + "のダメージを与えた！");
			charactor.setHp(charactor.getHp() - super.getAt());
			this.numOfPoisonAttack = this.numOfPoisonAttack - 1;
			System.out.println(this.numOfPoisonAttack);
			System.out.println();
		} else if(numOfPoisonAttack > 0 && charactor.getHp() <= 0) {
			// HPが0以下の場合はListから削除し、次のモンスターを取得する。
			charactorList.remove(0);
			if(!charactorList.isEmpty()) {
				Charactor charactor2 = charactorList.get(0);
				System.out.println("毒による追加攻撃");
				System.out.println(charactor2.getName() + "に" + super.getAt() + "のダメージを与えた！");
				charactor2.setHp(charactor2.getHp() - super.getAt());
				this.numOfPoisonAttack = this.numOfPoisonAttack - 1;
				System.out.println(this.numOfPoisonAttack);
				System.out.println();
			}
		}
	}
}
