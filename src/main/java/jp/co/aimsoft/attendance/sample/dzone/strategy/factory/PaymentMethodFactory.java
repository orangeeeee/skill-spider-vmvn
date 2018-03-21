package jp.co.aimsoft.attendance.sample.dzone.strategy.factory;

import jp.co.aimsoft.attendance.sample.dzone.strategy.model.Cash;
import jp.co.aimsoft.attendance.sample.dzone.strategy.model.CreditCard;
import jp.co.aimsoft.attendance.sample.dzone.strategy.model.DebitCard;
import jp.co.aimsoft.attendance.sample.dzone.strategy.model.PaymentMethod;

/**
 * カードクラスのインスタンス生成クラス
 */
public class PaymentMethodFactory {

	/**
	 * 指定タイプのカードクラスのインスタンスを生成
	 * @param type
	 * @return カードクラス
	 */
	public static PaymentMethod getPaymentMethod(String type) {
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

	public static CreditCard createCreditCard() {
		return new CreditCard("John Doe", "4111111111111111", "123", "01/22");
	}

	public static DebitCard createDebitCard() {
		return new DebitCard("John Doe", "4111111111111111", "123", "01/22");
	}

	public static Cash createCash() {
		return new Cash();
	}
}
