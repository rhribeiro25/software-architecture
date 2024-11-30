package br.com.rhribeiro25.domain;

public class Address {
    private String zipCode;
    private Integer number;
    private String complement;

    public Address(String zipCode, Integer number, String complement) {
        this.zipCode = zipCode;
        this.number = number;
        this.complement = complement;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }
}
