package shoshinsya12;

import java.util.List;

public class Magician extends Charactor {

	// フィールド
	private int mp;
	private int calMp = 20;		// 魔法攻撃消費MP
	private int magicAt = 20;	// 魔法攻撃力

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

	public void healMagic() {
		System.out.println( super.getName()+"が回復した");
		super.setHp(super.getHp() + 10);
		this.mp = this.mp + 20;
		System.out.println("hpが10回復し、" + super.getHp() + "になった");
		System.out.println("mpが20回復し、" + this.mp + "になった");
		System.out.println();
	}

	public void magicAttack(List<Creature> creatureList) {

		System.out.println(super.getName() + "の魔法攻撃!");
		System.out.println("MPを"+calMp +"消費する");

		if(this.mp < calMp) {
			System.out.println("MPが不足しているため" + super.getName() + "は魔法攻撃を使用できません。");
			healMagic();
			System.out.println();
		} else {
			this.mp = this.mp - calMp;
			for(Creature creature : creatureList) {
				creature.setHp(creature.getHp() - magicAt);
				System.out.println(creature.getName() + "に" + magicAt + "のダメージを与えた");
				System.out.println();
			}
		}
	}



	// getter, setter
	public int getMp() {
		return mp;
	}

	public void setMp(int mp) {
		if(mp < 0) {
			this.mp = 0;
		} else {
			this.mp = mp;
		}
	}

	public int getCalMp() {
		return calMp;
	}

	public void setCalMp(int calMp) {
		this.calMp = calMp;
	}

	public int getMagicAt() {
		return magicAt;
	}

	public void setMagicAt(int magicAt) {
		this.magicAt = magicAt;
	}


}
