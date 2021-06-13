package shoshinsya10;

public class EvolvedPokemon extends Pokemon {

	// 進化後ポケモンの攻撃回数
	private int numOfAttack = 2;

	// オーバーライド
	public void attack() {
		for(int i=0; i < this.numOfAttack; i++) {
			super.attack();
		}
	}

	public void heal() {
		System.out.println("進化後ポケモンの回復です。");
	}


}
