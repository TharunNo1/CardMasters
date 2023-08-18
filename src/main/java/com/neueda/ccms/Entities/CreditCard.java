package com.neueda.ccms.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.security.SecureRandom;
import java.util.Date;

@Document(collection = "credit_cards")
public class CreditCard {

    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto incrementing the customer_id
    @Field("_id")
    @JsonIgnore
    private long _id;
    @Field("first_name")
    private String first_name = null;
    @Field("last_name")
    private String last_name = null;
    @Field("gender")
    private String gender = null;
    @Field("date_of_birth")
    private Date date_of_birth = null;
    @Field("job_title")
    private String job_title = null;
    @Field("national_id")
    private String national_id = "0000000000000000";
    @Field("card_number")
    @JsonIgnore
    private String card_number = null;
    @Field("security_pin")
    private String security_pin = "0000";
    @Field("card_type")
    private String card_type = null;

    public CreditCard(String first_name, String last_name, String gender, Date date_of_birth, String job_title, String card_type, String national_id, String security_pin) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.date_of_birth = date_of_birth;
        this.job_title = job_title;
        this.card_type = card_type;
        this.national_id = national_id;
        this.security_pin = security_pin;
    }

    public CreditCard() {

    }

    private String digitRandom(int numOfDigits) {
        SecureRandom secureRandom = new SecureRandom();
        int min = (int) Math.pow(10,numOfDigits-1);
        int max = (int) (Math.pow(10,numOfDigits)-1);

        int randomNumber = secureRandom.nextInt(max-min) + min;
        return String.valueOf(randomNumber);
    }

    public String generateCardNumber() {
        String cardNumber = "";

        if (this.card_type == null) {
                cardNumber += "5" + digitRandom(3) + "-";
        }
        else if (this.card_type.equals("VISA")) {
            cardNumber += "4" + digitRandom(3) + "-";
        } else if (this.card_type.equals("MASTERCARD")) {
            cardNumber += "2" + digitRandom(3) + "-";
        }


        cardNumber += digitRandom(4) + "-";
        cardNumber += digitRandom(4) + "-";
        cardNumber += digitRandom(4);

        return cardNumber;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public String getNational_id() {
        return national_id;
    }

    public void setNational_id(String national_id) {
        this.national_id = national_id;
    }

    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = generateCardNumber();
    }

    public void setCard_number() {
        this.card_number = generateCardNumber();
    }

    public String getSecurity_pin() {
        return security_pin;
    }

    public void setSecurity_pin(String security_pin) {
        this.security_pin = security_pin;
    }

    public String getCard_type() {
        return card_type;
    }

    public void setCard_type(String card_type) {
        this.card_type = card_type;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "customerId=" + _id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", gender=" + gender +
                ", date_of_birth=" + date_of_birth +
                ", job_title='" + job_title + '\'' +
                ", card_number=" + card_number +
                ", security_pin=" + security_pin +
                '}';
    }
}
