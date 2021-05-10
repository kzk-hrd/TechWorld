package shoshinsya9;

import java.util.List;

public class Magician {

	// フィールド
	private String name;         // 名前
	private int hp;                  // HP
	private int at;                   // 攻撃力
	private int mp;                 // MP
	private int df;                   // 防御力

	// メソッド
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(name.equals("")) {
			throw new IllegalArgumentException
			("名前がNULLです");
		} else if(name.length() < 3 || name.length() > 10) {
			throw new IllegalArgumentException
			("名前の設定は3文字以上、10文字以下で設定してください");
		}
		this.name = name;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		if(hp < 0) {
			this.hp = 0;
		} else {
			this.hp = hp;
		}

	}
	public int getAt() {
		return at;
	}
	public void setAt(int at) {
		if(at < 0) {
			this.at = 0;
		} else {
			this.at = at;
		}

	}
	public int getDf() {
		return df;
	}
	public void setDf(int df) {
		if(df < 0) {
			this.df = 0;
		} else {
			this.df = df;
		}

	}
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
		System.out.println(this.name + "の攻撃!");
		System.out.println("敵にダメージを" + this.at + "与えた！");
		m.setHp(m.getHp() - this.at);
		if(m.getHp() <= 0) {
			System.out.println(m.getName() + "のhpは0以下になりました、負けです。");
		}
		System.out.println();
	}

	public void magicAttack(List<Monster> monsterList) {
		// MP消費変数
		int calMp = 20;
		int magicAt = 20;
		System.out.println(this.name + "の魔法攻撃!");
		System.out.println("MPを"+calMp +"消費する");

		if(this.mp < calMp) {
			System.out.println("MPが不足しているため" + this.name + "は魔法攻撃を使用できません。");
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
		System.out.println( this.name+"が回復した");
		this.hp = this.hp + 10;
		this.mp = this.mp + 20;
		System.out.println("hpが10回復し、" + this.hp + "になった");
		System.out.println("mpが20回復し、" + this.mp + "になった");
		System.out.println();
	}

}
