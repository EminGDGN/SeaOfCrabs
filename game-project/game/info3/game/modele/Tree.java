package info3.game.modele;

public class Tree extends StillEntity {
	
	public static final int DEFAULT_HEALTH_POINTS_T0_HEAL_PIRATEBOAT = 50;
	public static final int DEFAULT_HEALTH_POINTS = 50;
	
	private int healthPoints;
	private int healthPointsToHeal;
	private float coeff;
	
	public Tree() {
		super();
		this.healthPoints = DEFAULT_HEALTH_POINTS;
		this.healthPointsToHeal = DEFAULT_HEALTH_POINTS_T0_HEAL_PIRATEBOAT;
	}
	
	public Tree(int level) { // mettre le numéro du tronçon
		super();
		this.coeff = (new Level(level)).getCoeffBasedOnLevel();
		this.healthPoints = DEFAULT_HEALTH_POINTS;
		this.healthPointsToHeal = (int) ((float)DEFAULT_HEALTH_POINTS_T0_HEAL_PIRATEBOAT * this.coeff);
	}

	public void move() {
		//Mettre la fonction move de Crabe once done
	}

	
	public void die() {
		GameModele.pirateBoat.heal(this.healthPointsToHeal);
		super.die();
	}

	//Damage taken by the tree
	public void takeDamage(int damage) {
		this.healthPoints -= damage;
		
	}

}
