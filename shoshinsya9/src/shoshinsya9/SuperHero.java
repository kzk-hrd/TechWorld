package shoshinsya9;

public class SuperHero extends Hero {

	int numOfAttack = 2;

	// オーバーライド
	public void attack(Monster m) {

		for(int i =0; i<this.numOfAttack; i++) {
			super.attack(m);
		}
	}

}
