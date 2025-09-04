/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bms.model;

public class Account {
    private String nic;
    private String accType;
    private String cardNumber;
    private int pin;
    private String services;

    public Account(String nic,String accType, String cardNumber, int pin, String services) {
        this.accType = accType;
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.services = services;
        this.nic = nic;
    }
    
    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }
    /**
     * @return the accType
     */
    public String getAccType() {
        return accType;
    }

    /**
     * @param accType the accType to set
     */
    public void setAccType(String accType) {
        this.accType = accType;
    }

    /**
     * @return the cardNumber
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * @param cardNumber the cardNumber to set
     */
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    /**
     * @return the pin
     */
    public int getPin() {
        return pin;
    }

    /**
     * @param pin the pin to set
     */
    public void setPin(int pin) {
        this.pin = pin;
    }

    /**
     * @return the services
     */
    public String getServices() {
        return services;
    }

    /**
     * @param services the services to set
     */
    public void setServices(String services) {
        this.services = services;
    }
    
    
}
