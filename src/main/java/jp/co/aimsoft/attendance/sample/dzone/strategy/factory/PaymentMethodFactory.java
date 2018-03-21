package jp.co.aimsoft.attendance.sample.dzone.strategy.factory;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import jp.co.aimsoft.attendance.sample.dzone.strategy.model.Cash;
import jp.co.aimsoft.attendance.sample.dzone.strategy.model.CreditCard;
import jp.co.aimsoft.attendance.sample.dzone.strategy.model.DebitCard;
import jp.co.aimsoft.attendance.sample.dzone.strategy.model.PaymentMethod;

/**
 * カードクラスのインスタンス生成クラス
 */
@Component
public class PaymentMethodFactory {

	 @Autowired
	 private BeanFactory beanFactory;

//	 @Autowired
//	 private CreditCard creditCard;

	// ApplicationContextでも良いが、機能の幅が大きいので、FactoryBeanを使用する。
	/**
	 * 指定タイプのカードクラスのインスタンスを生成 TODO staticである必要が無いので、修正
	 *
	 * @param type
	 * @return カードクラス
	 */
	public PaymentMethod getPaymentMethod(String type) {
		switch (type) {
		case "credit":
			return createCreditCard();
		case "debit":
			return createDebitCard();
		case "cash":
			return createCash();
		}
		throw new IllegalArgumentException();
	}

	private CreditCard createCreditCard() {

		 CreditCard creditCard = beanFactory.getBean(CreditCard.class);
		 creditCard.init("John Doe", "4111111111111111", "125", "01/21");
		 return creditCard;
//		return new CreditCard();
	}

	private DebitCard createDebitCard() {

		 DebitCard debitCard = beanFactory.getBean(DebitCard.class);
		 debitCard.init("John Doe", "4111111111111112", "123", "01/22");
		 return debitCard;
//		return new DebitCard();
	}

	private Cash createCash() {
		return new Cash();
	}
}
