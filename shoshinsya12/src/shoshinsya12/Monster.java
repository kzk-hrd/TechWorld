package shoshinsya12;

import java.util.List;

public class Monster extends Creature {

	public void attack(List<Charactor> c) {

		System.out.println(super.getName() + "の攻撃!");
		Charactor charactor = c.get(0);
		System.out.println(charactor.getName() + "に" + super.getAt() + "のダメージを与えた！");
		charactor.setHp(charactor.getHp() - super.getAt());

	}

	public void deffence() {
		System.out.println(super.getName() + "は守りを固めた");
		super.setDf(super.getHp() + 10);
		System.out.println("防御力が10上がった");
	}

}
