package shoshinsya9;

public class SuperMonster extends Monster {

	private static int numOfPoisonAttack = 5;

	// オーバーライド
	public void attackHero(Hero h, Magician ma) {
		System.out.println(super.getName() + "の" + h.getName() + "への攻撃！");
		System.out.println(h.getName() + "に" + super.getAt() + "のダメージを与えた！");
		h.setHp(h.getHp() - super.getAt());
		System.out.println();

		if(numOfPoisonAttack > 0 && h.getHp() > 0) {
			System.out.println("毒による追加攻撃");
			System.out.println(h.getName() + "に" + super.getAt() + "のダメージを与えた！");
			h.setHp(h.getHp() - super.getAt());
			this.numOfPoisonAttack = this.numOfPoisonAttack - 1;
			System.out.println(this.numOfPoisonAttack);
			System.out.println();
		}

		if(numOfPoisonAttack > 0 && h.getHp() <= 0) {
			System.out.println("毒による追加攻撃");
			System.out.println(ma.getName() + "に" + super.getAt() + "のダメージを与えた！");
			ma.setHp(ma.getHp() - super.getAt());
			this.numOfPoisonAttack = this.numOfPoisonAttack - 1;
			System.out.println(this.numOfPoisonAttack);
			System.out.println();
		}
	}

	public void attackMagician(Magician ma, Hero h) {
		System.out.println(super.getName() + "の" + ma.getName() + "への攻撃！");
		System.out.println(ma.getName() + "に" + super.getAt() + "のダメージを与えた！");
		ma.setHp(ma.getHp() - super.getAt());
		System.out.println();

		if(numOfPoisonAttack > 0 && ma.getHp() > 0) {
			System.out.println("毒による追加攻撃");
			System.out.println(ma.getName() + "に" + super.getAt() + "のダメージを与えた！");
			ma.setHp(ma.getHp() - super.getAt());
			this.numOfPoisonAttack = this.numOfPoisonAttack - 1;
			System.out.println(this.numOfPoisonAttack);
			System.out.println();
		}
	}

}
