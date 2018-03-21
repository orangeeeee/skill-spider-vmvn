package jp.co.aimsoft.attendance.sample.dzone.strategy.service;

import java.util.ArrayList;
import java.util.List;

import jp.co.aimsoft.attendance.sample.dzone.strategy.model.PaymentMethod;

/**
 * 請求書
 */
public class Bill {
    private List<LineItem> lineItems = new ArrayList<>();
    public void addLineItem(LineItem lineItem) {
        lineItems.add(lineItem);
    }
    public void removeLineItem(LineItem lineItem) {
        lineItems.remove(lineItem);
    }
    public int getCostInCents() {
        return lineItems.stream().mapToInt(item -> item.getCostInCents()).sum();
    }
    public void pay(PaymentMethod method) {
        method.pay(getCostInCents());
    }
}
