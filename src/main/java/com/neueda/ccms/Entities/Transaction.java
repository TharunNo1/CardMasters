package com.neueda.ccms.Entities;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Document("transactions")
public class Transaction {
    @Id
    private ObjectId _id;

    private String trans_date_trans_time;
    private double amt;

    private int trans_num;
    private int  customer_id;
    private String city;
    private String state;
    private long city_population;
    private String merchant;
    private String category;
    private String first;
    private String last;
    private Gender gender;
   @Field("Job")
   private String job;
    private String dob;
    public static enum Gender {
        M, F;
    }

    public Transaction(String trans_date_trans_time, double amt, int trans_num, int customer_id, String city, String state, long city_population, String merchant, String category, String first, String last, Gender gender, String job, String dob) {
        this.trans_date_trans_time = trans_date_trans_time;
        this.amt = amt;
        this.trans_num = trans_num;
        this.customer_id = customer_id;
        this.city = city;
        this.state = state;
        this.city_population = city_population;
        this.merchant = merchant;
        this.category = category;
        this.first = first;
        this.last = last;
        this.gender = gender;
        this.job = job;
        this.dob = dob;
    }


    public String getTrans_date_trans_time() {
        return trans_date_trans_time;
    }

    public void setTrans_date_trans_time(String trans_date_trans_time) {
        this.trans_date_trans_time = trans_date_trans_time;
    }

    public double getAmt() {
        return amt;
    }

    public void setAmt(double amt) {
        this.amt = amt;
    }

    public int getTrans_num() {
        return trans_num;
    }

    public void setTrans_num(int trans_num) {
        this.trans_num = trans_num;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public long getCity_population() {
        return city_population;
    }

    public void setCity_population(long city_population) {
        this.city_population = city_population;
    }

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getjob() {
        return job;
    }

    public void setjob(String job) {
        job = job;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "transaction{" +
                "customer_id='" + customer_id + '\'' +
                ", trans_date_trans_time='" + trans_date_trans_time + '\'' +
                ", amt=" + amt +
                ", transnum=" + trans_num +
//                ", customer_id=" + _id +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", city_population=" + city_population +
                ", merchant='" + merchant + '\'' +
                ", category='" + category + '\'' +
                ", first='" + first + '\'' +
                ", last='" + last + '\'' +
                ", gender=" + gender +
                ", job='" + job + '\'' +
                ", dob=" + dob +
                '}';
    }
}
