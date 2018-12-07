package OOP;

public class LineItem {
	int qty;
	Product aProduct;
	/**
	 * @param qty
	 * @param aProduct
	 */
	public LineItem(int qty, Product aProduct) {
		super();
		this.qty = qty;
		this.aProduct = aProduct;
	}
	/**
	 * @return the qty
	 */
	public int getQty() {
		return qty;
	}
	/**
	 * @param qty the qty to set
	 */
	public void setQty(int qty) {
		this.qty = qty;
	}
	/**
	 * @return the aProduct
	 */
	public Product getaProduct() {
		return aProduct;
	}
	/**
	 * @param aProduct the aProduct to set
	 */
	public void setaProduct(Product aProduct) {
		this.aProduct = aProduct;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LineItem [qty=" + qty + ", "+ aProduct + "]" + " Total: " + (qty * aProduct.getPrice());
	}
	
}
