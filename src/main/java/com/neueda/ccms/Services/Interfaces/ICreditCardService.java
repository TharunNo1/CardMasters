package com.neueda.ccms.Services.Interfaces;

import com.neueda.ccms.Entities.CreditCard;

public interface ICreditCardService {
    public String addCreditCard(CreditCard creditCard);
    public String removeCreditCard(String creditCardNumber);
    public String updateCreditCard(String creditCardNumber, CreditCard creditCard);
    public CreditCard retrieveCreditCard(String creditCardNumber);

}
