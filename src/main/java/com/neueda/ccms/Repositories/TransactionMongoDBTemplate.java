package com.neueda.ccms.Repositories;


import com.neueda.ccms.DTO.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

@Repository
public class TransactionMongoDBTemplate  {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<StateAmount> getAmountSpentByState() {
        // MongoTemplate pipeline
        GroupOperation groupByState = group("state").sum("amt").as("totalAmount");
        System.out.println(groupByState.count());
        MatchOperation allStates = match(new Criteria("state").exists(true));
        ProjectionOperation includes = project("totalAmount").and("state").previousOperation();
        SortOperation sortBySalesDesc = sort(Sort.by(Sort.Direction.DESC,"totalAmount"));
        Aggregation aggregation = newAggregation(allStates,groupByState,sortBySalesDesc,includes);
        AggregationResults<StateAmount> groupResults = mongoTemplate.aggregate(aggregation, "transactions", StateAmount.class);
        List<StateAmount> result = groupResults.getMappedResults();
        return result;
    }

    public List<MerchantAmount> getAmountSpentByMerchant() {
        // MongoTemplate pipeline
        GroupOperation groupByMerchant = group("merchant").sum("amt").as("totalAmount");
        System.out.println(groupByMerchant.count());
        MatchOperation allMerchant = match(new Criteria("merchant").exists(true));
        ProjectionOperation includes = project("totalAmount").and("merchant").previousOperation();
        SortOperation sortBySalesDesc = sort(Sort.by(Sort.Direction.DESC,"totalAmount"));
        Aggregation aggregation = newAggregation(allMerchant,groupByMerchant,sortBySalesDesc,includes);
        AggregationResults<MerchantAmount> groupResults = mongoTemplate.aggregate(aggregation, "transactions", MerchantAmount.class);
        List<MerchantAmount> result = groupResults.getMappedResults();
        return result;
    }

    public List<GenderAmount> getSpentByGender() {
        // MongoTemplate pipeline
        GroupOperation groupByGender = group("gender").sum("amt").as("totalAmount");
        MatchOperation allGender = match(new Criteria("gender").exists(true));
        ProjectionOperation includes = project("totalAmount").and("gender").previousOperation();
        SortOperation sortBySalesDesc = sort(Sort.by(Sort.Direction.DESC,"totalAmount"));
        Aggregation aggregation = newAggregation(allGender,groupByGender,sortBySalesDesc,includes);
        AggregationResults<GenderAmount> groupResults = mongoTemplate.aggregate(aggregation, "transactions", GenderAmount.class);
        List<GenderAmount> result = groupResults.getMappedResults();
        return result;
    }

    public List<CategoryAmount> getAmountSpentByCategory() {
        // MongoTemplate pipeline

        GroupOperation groupByProfession = group("category").sum("amt").as("totalAmount");
        MatchOperation allProfession = match(new Criteria("category").exists(true));
        ProjectionOperation includes = project("totalAmount").and("category").previousOperation();
        SortOperation sortBySalesDesc = sort(Sort.by(Sort.Direction.DESC,"totalAmount"));
        Aggregation aggregation = newAggregation(allProfession,groupByProfession,sortBySalesDesc,includes);
        AggregationResults<CategoryAmount> groupResults = mongoTemplate.aggregate(aggregation, "transactions", CategoryAmount.class);
        List<CategoryAmount> result = groupResults.getMappedResults();
        return result;
    }

    public List<CityAmount> getAmountSpentByCity() {
        GroupOperation groupByGender = group("city").sum("amt").as("totalAmount");
        MatchOperation allGender = match(new Criteria("city").exists(true));
        ProjectionOperation includes = project("totalAmount").and("city").previousOperation();
        SortOperation sortBySalesDesc = sort(Sort.by(Sort.Direction.DESC,"totalAmount"));
        Aggregation aggregation = newAggregation(allGender,groupByGender,sortBySalesDesc,includes);
        AggregationResults<CityAmount> groupResults = mongoTemplate.aggregate(aggregation, "transactions",CityAmount.class);
        List<CityAmount> result = groupResults.getMappedResults();
        return result;
//        GroupOperation groupByCityTotalAmount = group("city").sum("amt").as("total_amount");
//        MatchOperation allCity = match(new Criteria("city").exists(true));
//        System.out.println(allCity);
//        ProjectionOperation includes = project("total_amount").and("city").previousOperation();
//        SortOperation sortByTotalAmountDesc = sort(Sort.by(Sort.Direction.DESC,"total_amount"));
//        Aggregation aggregation = newAggregation(allCity,groupByCityTotalAmount,sortByTotalAmountDesc,includes);
//        AggregationResults<CityAmount> groupResults = mongoTemplate.aggregate(aggregation, "transactions", CityAmount.class);
//        System.out.println(groupResults);
//        List<CityAmount> result = groupResults.getMappedResults();
//        System.out.println(result);
//        return result;
    }



}
