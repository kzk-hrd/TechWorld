package shoshinsya9;

public class Hero {

	// フィールド
	private String name;         // 名前
	private int hp;                  // HP
	private int at;                   // 攻撃力
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

	public void attack(Monster m) {
		System.out.println(this.name + "の" + m.getName() + "への攻撃！");
		System.out.println(m.getName() + "に" + this.at + "のダメージを与えた！");
		m.setHp(m.getHp() - this.at);
		System.out.println();
	}

	void defence() {
		System.out.println("勇者が防御した");
		this.df = this.df + 10;
		System.out.println("防御力が10upし、" + this.df + "になった");
	}

	void heal() {
		System.out.println("勇者が休憩した");
		this.hp = this.hp + 10;
		System.out.println("hpが10回復し、" + this.hp + "になった");
	}






}
