package com.civilink.civilink_project_management.dtos.requests;

public class RequestMaterialDto {
    private String type;
    private int quantity;
    private double pricePerUnit;
    private String paymentStatus;

    public RequestMaterialDto() {}

    public RequestMaterialDto(String type, int quantity, double pricePerUnit, String paymentStatus) {
        this.type = type;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
        this.paymentStatus = paymentStatus;
    }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public double getPricePerUnit() { return pricePerUnit; }
    public void setPricePerUnit(double pricePerUnit) { this.pricePerUnit = pricePerUnit; }
    public String getPaymentStatus() { return paymentStatus; }
    public void setPaymentStatus(String paymentStatus) { this.paymentStatus = paymentStatus; }
}
