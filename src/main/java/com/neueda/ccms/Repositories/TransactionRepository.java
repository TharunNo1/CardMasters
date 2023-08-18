package com.neueda.ccms.Repositories;


import com.neueda.ccms.Entities.Transaction;
import com.neueda.ccms.Repositories.TransactionMongoDBTemplate;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface TransactionRepository extends MongoRepository<Transaction, ObjectId> {
    //@Aggregation(pipeline = {"{$match,{'city':'Acworth'}}"})
    List<Transaction> findBycity(String city);

    List<Transaction> findBygender(char gender);



   List<Transaction> findBycategory(String category);

    List<Transaction> findBymerchant(String merchant);

    @Query("{'state': ?0}")
    List<Transaction> findBystate(String state);
   /* @Query("{'city_population' : {$gte : ?0, $lte : ?1}}")
    List<Transaction> findBypopulation(double from, double to);*/

    @Query("{'job': ?0}")
   List<Transaction> findByjob(String job);
    //List<Transaction> findByGender(Transaction.Gender gender);*/
    @Query("{'amt' : {$gte : ?0, $lte : ?1}}")
    List<Transaction> findByamt(double from,double to) ;
    public List<Transaction> getTransactionByAmt(double from,double to);

    @Aggregation(pipeline = {
            "{'$sort':{'amt':-1}}"
    })


    List<Transaction> getByCityAmount(String City);
}

