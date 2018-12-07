package tutorialPkg;

public class Customer {

	String lairLocation;
	String name;
	double evilFunds;
	
	/**
	 * @param lairLocation
	 * @param name
	 * @param evilFunds
	 */
	public Customer(String lairLocation, String name, double evilFunds) {
		
		this.lairLocation = lairLocation;
		this.name = name;
		this.evilFunds = evilFunds;
	}

	/**
	 * @return the lairLocation
	 */
	public String getLairLocation() {
		return lairLocation;
	}

	/**
	 * @param lairLocation the lairLocation to set
	 */
	public void setLairLocation(String lairLocation) {
		this.lairLocation = lairLocation;
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
	 * @return the evilFunds
	 */
	public double getEvilFunds() {
		return evilFunds;
	}

	/**
	 * @param evilFunds the evilFunds to set
	 */
	public void setEvilFunds(double evilFunds) {
		this.evilFunds = evilFunds;
	}
	
	public void addFunds(double funds) {
		evilFunds += funds;
	}
	
	public String toString() {
		return name + " Lair Location: " + lairLocation + " Evil Funds: " + evilFunds;
	}
	
}
