package jp.co.aimsoft.attendance.sample.dzone.strategy.model;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * デビットカードクラス TODO
 * DZoneでは、このようなやりかたはしていないが、singletonでは良くないので、prototypeを明示的に指定する。
 */
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
public class DebitCard extends Card {

	// TODO 引数有のコンストラクタがある状態でDIするとBean定義がないのでエラーとなる。
	// public DebitCard(String nameOnCard, String number, String cvv, String
	// expirationDate) {
	//// super(nameOnCard, number, cvv, expirationDate);
	// }

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
