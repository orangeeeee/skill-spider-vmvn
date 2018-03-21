package jp.co.aimsoft.attendance.sample.dzone.strategy.model;

/**
 * 	デビットカードクラス
 */
public class DebitCard extends Card {

	public DebitCard(String nameOnCard, String number, String cvv, String expirationDate) {
		super(nameOnCard, number, cvv, expirationDate);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getType() {
		return "debit";
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void executeTransaction(int cents) {
		// Contact bank to execute transaction
	}
}
