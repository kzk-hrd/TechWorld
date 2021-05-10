package shoshinsya9;

public class Monster {

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

	void attackHero(Hero h) {
		System.out.println(this.name + "の" + h.getName() + "への攻撃！");
		System.out.println(h.getName() + "に" + this.at + "のダメージを与えた！");
		h.setHp(h.getHp() - this.at);
		System.out.println();
	}

	void attackMagician(Magician ma) {
		System.out.println(this.name + "の" + ma.getName() + "への攻撃！");
		System.out.println(this.at + "のダメージ");
		ma.setHp(ma.getHp() - this.at);
		System.out.println();

	}

	void defence() {
		System.out.println(this.name + "は守りを固めた");
		this.df = this.df + 10;
		System.out.println("防御力が10上がった");
	}
}
