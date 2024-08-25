package net.dkr.freelancing.model;

public class PaymentModel {
    private String amount;
    private String orderId;
    private String currency;

    public PaymentModel(String amount, String orderId, String currency) {
        this.amount = amount;
        this.orderId = orderId;
        this.currency = currency;
    }

    public String getAmount() {
        return amount;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCurrency() {
        return currency;
    }
}
