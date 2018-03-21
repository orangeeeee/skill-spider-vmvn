package jp.co.aimsoft.attendance.sample.dzone.strategy.model;

/**
 * クレジットカードクラス
 */
public class CreditCard extends Card {

	public CreditCard(String nameOnCard, String number, String cvv, String expirationDate) {
		super(nameOnCard, number, cvv, expirationDate);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getType() {
		return "credit";
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void executeTransaction(int cents) {
		// Contact credit holder to make transaction
	}
}
