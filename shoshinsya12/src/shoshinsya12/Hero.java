package shoshinsya12;

public class Hero extends Charactor {

	// メソッド
	public void attack(Creature c) {
		System.out.println(super.getName() + "の" + c.getName() + "への攻撃！");
		System.out.println(c.getName() + "に" + super.getAt() + "のダメージを与えた！");
		c.setHp(c.getHp() - super.getAt());
		System.out.println();
	}

	public void deffence() {
		System.out.println(super.getName() +"が防御した");
		super.setDf(super.getDf() + 10);
		System.out.println("防御力が10upし、" + super.getDf() + "になった");
	}

	public void heal() {
		System.out.println(super.getName() + "が休憩した");
		super.setHp(super.getHp() + 10);
		System.out.println("hpが10回復し、" + super.getHp() + "になった");
	}
}
