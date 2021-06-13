package shoshinsya9;

import java.util.List;

public class SuperMagician extends Magician {

	public void exMagicAttack(List<Monster> monsterList) {

		System.out.println(super.getName() + "の魔法攻撃!");

		// MP消費、攻撃力はmagicAttackの2倍
		int exCalMp = 2 * super.getCalMp();
		int exMagicAt = 2 * super.getMagicAt();
		System.out.println("MPを"+exCalMp +"消費する");

		if(super.getMp() < exCalMp) {
			System.out.println("MPが不足しているため" + super.getName() + "は超魔法攻撃を使用できません。");
			// MPが不足している場合は回復
			super.healMagic();
			System.out.println();
		} else {
			super.setMp(super.getMp() - exCalMp);
			for(Monster monster : monsterList) {
				monster.setHp(monster.getHp() - exMagicAt);
				System.out.println(monster.getName() + "に" + exMagicAt + "のダメージを与えた");
				System.out.println();
			}
		}
	}

}
