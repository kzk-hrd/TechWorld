package shoshinsya11;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		// ノーマル属性
		PokemonObj po = new PokemonObj();
		po.attack();
		po.deffence();

		// 炎属性
		FirePokemonObj fpo = new FirePokemonObj();
		fpo.fireAttack();
		fpo.attack();
		fpo.deffence();

		// 雷属性
		ThunderPokemonObj tpo = new ThunderPokemonObj();
		tpo.thunderAttack();
		tpo.attack();
		tpo.deffence();

		// 雷炎属性
		ThunderFirePokemonObj tfpo = new ThunderFirePokemonObj();
		tfpo.thunderAttack();
		tfpo.fireAttack();
		tfpo.attack();
		tfpo.deffence();

	}

}
