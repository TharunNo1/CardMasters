package com.neueda.ccms.Services.Interfaces;


import com.neueda.ccms.Entities.Transaction;

import java.util.List;

public interface ITransactionService {
    public List<Transaction> getTransactionByCity(String city);
    public List<Transaction> getTransactionByGender(char gender);
    public List<Transaction> getTransactionByTransnum(int transnum);

    public List<Transaction> getTransactionByCategory(String category);
    public List<Transaction> getTransactionByMerchant(String merchant);
    public List<Transaction> getTransactionByState(String state);

    public List<Transaction> getTransactionByJob(String job);
    public List<Transaction> getTransactionByAmt(double amt);
}
