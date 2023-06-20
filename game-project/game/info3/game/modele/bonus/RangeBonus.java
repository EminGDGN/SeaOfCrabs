package info3.game.modele.bonus;

import automate.AutomateLoader;
import info3.game.modele.GameEntity;
import info3.game.modele.GameModele;
import info3.game.modele.StillEntityClass.Bonus;

public class RangeBonus extends Bonus {

	public RangeBonus(int level, int x, int y) {
		super(level, x, y);
	}

	@Override
	public void power() {
		GameModele.player1.addRangeCoeff(BONUS_APPLIED, getLevel());
	}

	@Override
	public void move() {
		setX(getX()+1);
	}
}
