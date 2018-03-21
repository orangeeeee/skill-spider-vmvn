package jp.co.aimsoft.attendance.sample.dzone.strategy.model;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * クレジットカードクラス
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CreditCard extends Card {

//	public CreditCard(String nameOnCard, String number, String cvv, String expirationDate) {
//		// super(nameOnCard, number, cvv, expirationDate);
//	}

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
