package shoshinsya9;

public class Monster extends Creature {

	// メソッド
	public void attackHero(Hero h, Magician ma) {
		System.out.println(super.getName() + "の" + h.getName() + "への攻撃！");
		System.out.println(h.getName() + "に" + super.getAt() + "のダメージを与えた！");
		h.setHp(h.getHp() - super.getAt());
		System.out.println();
	}

	public void attackMagician(Magician ma, Hero h) {
		System.out.println(super.getName() + "の" + ma.getName() + "への攻撃！");
		System.out.println(super.getAt() + "のダメージ");
		ma.setHp(ma.getHp() - super.getAt());
		System.out.println();

	}

	public void deffence() {
		System.out.println(super.getName() + "は守りを固めた");
		super.setDf(super.getHp() + 10);
		System.out.println("防御力が10上がった");
	}
}
