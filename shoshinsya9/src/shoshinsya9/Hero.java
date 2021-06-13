package shoshinsya9;

public class Hero extends Charactor {

	// メソッド
	public void attack(Monster m) {
		System.out.println(super.getName() + "の" + m.getName() + "への攻撃！");
		System.out.println(m.getName() + "に" + super.getAt() + "のダメージを与えた！");
		m.setHp(m.getHp() - super.getAt() );
		System.out.println();
	}

	public void deffence() {
		System.out.println(super.getName() +"が防御した");
		super.setDf(super.getDf() + 10);
		System.out.println("防御力が10upし、" + super.getDf() + "になった");
	}

	void heal() {
		System.out.println("勇者が休憩した");
		super.setHp(super.getHp() + 10);
		System.out.println("hpが10回復し、" + super.getHp() + "になった");
	}
}
