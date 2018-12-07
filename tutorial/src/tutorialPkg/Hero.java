package tutorialPkg;

/**
 * describes a hero 
 * @author victor.truong
 * @date
 * @version
 */

public class Hero {
	private String name;
	private String power;
	private int age;
	private int health;
	private int damage;
	
	/**
	 * defualt constructor
	 * 
	 */
	public Hero() {
		name = "Jane doe";
		power = "Super speed";
		age = 20;
		health = 100;
		damage = 10;
	}
	
	/**
	 * constructor to build hero
	 * @param name - hero's name
	 * @param power - the hero's super power
	 * @param age - the hero's age
	 * @param health
	 * @param damage
	 */
	
	public Hero(String name, String power, int age, int health, int damage) {
		this.name = name;
		this.power = power;
		this.age = age;
		this.health = health;
		this.damage = damage;
	}

	/**
	 * sets the super power for the hero
	 * @param power
	 */
	public void setPower(String power) {
		this.power = power;
	}
	
	/**
	 * shows heros health
	 * @return - the hero health
	 */
	public int getHealth() {
		return health;
	}
	
	public int getDamage() {
		return damage;
	}
	
	public void setHealth(int health) {
		this.health = health;
	}
	
	public void fight(Hero h) {
		h.setHealth(h.getHealth() - this.damage);
	}
	
	public String toString() {
		return "Name: " + name + " Power: " + power;
	}
	
	
	
	
	
	
	
	
}
