package shoshinsya12;

import java.util.List;

public abstract class Creature {

	// フィールド
	private String name;
	private int hp;
	private int at;
	private int df;

	// メソッド
	public abstract void attack(List<Charactor> c);
	public abstract void deffence();

	// getter, setter
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

}
