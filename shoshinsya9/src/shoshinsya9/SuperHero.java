package shoshinsya9;

import java.util.List;

public class SuperHero extends Hero {

	int numOfAttack = 2;

	// オーバーライド
	public void attack(List<Monster> monster) {

		for(int i =0; i<this.numOfAttack; i++) {
			// 攻撃対象はListの先頭要素
			Monster m = monster.get(0);
			super.attack(m);
			if(m.getHp() <= 0) {
				System.out.println(m.getName() + "のHPが0になりました。");
				monster.remove(0);
			}
		}
	}

}
