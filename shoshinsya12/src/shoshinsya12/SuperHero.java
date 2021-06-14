package shoshinsya12;

import java.util.List;

public class SuperHero extends Hero {

	int numOfAttack = 2;

	// オーバーライド
	public void attack(List<Creature> monster) {

		for(int i =0; i<this.numOfAttack; i++) {
			// 攻撃対象はListの先頭要素
			Creature m = monster.get(0);
			super.attack(m);
			if(m.getHp() <= 0) {
				System.out.println(m.getName() + "のHPが0になりました。");
				monster.remove(0);
			}
			if(monster.isEmpty()) {
				break;
			}
		}
	}

}
