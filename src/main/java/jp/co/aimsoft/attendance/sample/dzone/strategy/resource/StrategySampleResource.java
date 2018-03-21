package jp.co.aimsoft.attendance.sample.dzone.strategy.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.aimsoft.attendance.sample.dzone.strategy.factory.PaymentMethodFactory;
import jp.co.aimsoft.attendance.sample.dzone.strategy.service.Bill;
import jp.co.aimsoft.attendance.sample.dzone.strategy.service.LineItem;

@Scope("request")
@RestController
@RequestMapping("api/strategy")
public class StrategySampleResource {


	@Autowired
	PaymentMethodFactory paymentMethodFactory;

	@PostMapping(value = "/sample1", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<String> pay() {

		Bill bill = new Bill();
		bill.addLineItem(new LineItem("Milk", 200));
		bill.addLineItem(new LineItem("Bread", 150));
		bill.pay(paymentMethodFactory.getPaymentMethod("credit"));

		return ResponseEntity.ok("");
	}
}
