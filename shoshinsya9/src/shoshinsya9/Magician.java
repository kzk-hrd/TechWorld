package shoshinsya9;

import java.util.List;

public class Magician extends Charactor {

	// フィールド
	private int mp;                 // MP
	private int calMp = 20;     // 魔法攻撃消費MP
	private int magicAt = 20; //  魔法攻撃力

	// メソッド
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

	public void attack(Monster m) {
		System.out.println(super.getName() + "の攻撃!");
		System.out.println("敵にダメージを" + super.getAt() + "与えた！");
		m.setHp(m.getHp() - super.getAt());
		if(m.getHp() <= 0) {
			System.out.println(m.getName() + "のhpは0以下になりました、負けです。");
		}
		System.out.println();
	}

	public void magicAttack(List<Monster> monsterList) {

		System.out.println(super.getName() + "の魔法攻撃!");
		System.out.println("MPを"+calMp +"消費する");

		if(this.mp < calMp) {
			System.out.println("MPが不足しているため" + super.getName() + "は魔法攻撃を使用できません。");
			healMagic();
			System.out.println();
		} else {
			this.mp = this.mp - calMp;
			for(Monster monster : monsterList) {
				monster.setHp(monster.getHp() - magicAt);
				System.out.println(monster.getName() + "に" + magicAt + "のダメージを与えた");
				System.out.println();
			}
		}
	}

	public void healMagic() {
		System.out.println( super.getName()+"が回復した");
		super.setHp(super.getHp() + 10);
		this.mp = this.mp + 20;
		System.out.println("hpが10回復し、" + super.getHp() + "になった");
		System.out.println("mpが20回復し、" + this.mp + "になった");
		System.out.println();
	}

	public void deffence() {
		System.out.println(super.getName() +"が防御した");
		super.setDf(super.getDf() + 10);
		System.out.println("防御力が10upし、" + super.getDf() + "になった");
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
