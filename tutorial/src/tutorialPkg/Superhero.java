package tutorialPkg;

public class Superhero {

	String name;
	String power = "none";
	boolean isMutated = false;
	int age;
	int powerLevel = 0;
	
	public Superhero() {}
	
	public Superhero(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public Superhero(String name, int age, String power, int powerLevel) {
		this.name = name;
		this.age = age;
		this.power = power;
		this.powerLevel = powerLevel;
		isMutated = true;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the power
	 */
	public String getPower() {
		return power;
	}
	/**
	 * @param power the power to set
	 */
	public void setPower(String power) {
		this.power = power;
	}
	/**
	 * @return the isMutated
	 */
	public boolean isMutated() {
		return isMutated;
	}
	/**
	 * @param isMutated the isMutated to set
	 */
	public void setMutated(boolean isMutated) {
		this.isMutated = isMutated;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return the powerLevel
	 */
	public int getPowerLevel() {
		return powerLevel;
	}
	/**
	 * @param powerLevel the powerLevel to set
	 */
	public void setPowerLevel(int powerLevel) {
		this.powerLevel = powerLevel;
	}
	
	public String toString() {
		return name + " has " + power + " power at power level " + powerLevel;
	}
	
}
