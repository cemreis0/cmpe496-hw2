package model;

public class Purchaser {

    // Data Members
    private String name;
    private String phone;
    private String postalCode;
    private String province;
    private String city;
    private String deliveryAddress;
    private String todaysDate;
    private String creditCardNo;
    private String validationId;

    // Constructors
    public Purchaser(
            String name,
            String phone,
            String postalCode,
            String province,
            String city,
            String deliveryAddress,
            String todaysDate,
            String creditCardNo,
            String validationId
    ) {
        this.name = name;
        this.phone = phone;
        this.postalCode = postalCode;
        this.province = province;
        this.city = city;
        this.deliveryAddress = deliveryAddress;
        this.todaysDate = todaysDate;
        this.creditCardNo = creditCardNo;
        this.validationId = validationId;
    }

    public Purchaser() {
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getProvince() {
        return province;
    }

    public String getCity() {
        return city;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public String getTodaysDate() {
        return todaysDate;
    }

    public String getCreditCardNo() {
        return creditCardNo;
    }

    public String getValidationId() {
        return validationId;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public void setTodaysDate(String todaysDate) {
        this.todaysDate = todaysDate;
    }

    public void setCreditCardNo(String creditCardNo) {
        this.creditCardNo = creditCardNo;
    }

    public void setValidationId(String validationId) {
        this.validationId = validationId;
    }

}
