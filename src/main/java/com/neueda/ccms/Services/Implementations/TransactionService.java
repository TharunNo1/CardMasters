package com.neueda.ccms.Services.Implementations;


import com.neueda.ccms.DTO.*;
import com.neueda.ccms.Entities.Transaction;
import com.neueda.ccms.Repositories.TransactionMongoDBTemplate;
import com.neueda.ccms.Repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService  {
    @Autowired
    private TransactionRepository transactionRepository;
   @Autowired
   private TransactionMongoDBTemplate mongorepo;
    /*public long getTransactionCount(){
        return transactionRepository.count();
    }*/
    /*public List<Transaction> getTransactionByCity(String city) throws RecordNotFoundException{
        return transactionRepository.findBycity(city)
                .orElseThrow(()->new RecordNotFoundException("transaction with "+city+" does not exist"));
        //return transactionRepository.findBycity(city);
    }*/
    public List<Transaction> getTransactionByCity(String city)  {
        return transactionRepository.findBycity(city);

    }
    public List<Transaction> getTransactionByGender(char gender){
        return transactionRepository.findBygender(gender);
    }

    public List<Transaction> getTransactionByCategory(String category){
        return transactionRepository.findBycategory(category);
    }
    public List<Transaction> getTransactionByMerchant(String merchant){
        return transactionRepository.findBymerchant(merchant);
    }
    public List<Transaction> getTransactionByState(String state){
        return transactionRepository.findBystate(state);
    }

    public List<Transaction> getTransactionByJob(String job){
        return transactionRepository.findByjob(job);
    }
    public List<Transaction> getTransactionByAmt(double from,double to){
        return transactionRepository.findByamt(from,to);
    }
    public List<StateAmount> getStateAmount(){
        return mongorepo.getAmountSpentByState();
    }

    public List<MerchantAmount> getMerchantAmount(){
        return mongorepo.getAmountSpentByMerchant();
    }

    public List<GenderAmount> getGenderAmount(){
        return mongorepo.getSpentByGender();
    }

    public List<CategoryAmount> getCategoryAmount(){
        return mongorepo.getAmountSpentByCategory();
    }

    public List<CityAmount> getCityAmount(){
        return mongorepo.getAmountSpentByCity();
    }



    //public List<Transaction> getTransactionByGender(Gender)
}
