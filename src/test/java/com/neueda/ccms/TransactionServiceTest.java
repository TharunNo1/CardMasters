package com.neueda.ccms;


import com.neueda.ccms.DTO.*;
import com.neueda.ccms.Entities.Transaction;
import com.neueda.ccms.Repositories.TransactionMongoDBTemplate;
import com.neueda.ccms.Repositories.TransactionRepository;
import com.neueda.ccms.Services.Implementations.TransactionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class TransactionServiceTest {
    @Mock
    private TransactionRepository transactionRepository;
    @Mock
    private TransactionMongoDBTemplate transactionMongoDBTemplate;
    @InjectMocks
    private TransactionService transactionService;
    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void  testGetTransactionByCity(){
        List<Transaction> transactionList=new ArrayList<>();
        when(transactionRepository.findBycity("Achille")).thenReturn(transactionList);
        List<Transaction>result=transactionService.getTransactionByCity("Achille");
        assertEquals(transactionList,result);
    }
    @Test
    public void  testGetTransactionBygender(){
        List<Transaction> transactionList=new ArrayList<>();
        when(transactionRepository.findBygender('F')).thenReturn(transactionList);
        List<Transaction> result=transactionService.getTransactionByGender('F');
        assertEquals(transactionList,result);
    }
    @Test
    public void  testGetTransactionByMerchant(){
        List<Transaction> transactionList=new ArrayList<>();
        when(transactionRepository.findBymerchant("Abbot")).thenReturn(transactionList);
        List<Transaction>result=transactionService.getTransactionByMerchant("Abbot");
        assertEquals(transactionList,result);
    }
    @Test
    public void  testGetTransactionByState(){
        List<Transaction> transactionList=new ArrayList<>();
        when(transactionRepository.findBystate("OK")).thenReturn(transactionList);
        List<Transaction>result=transactionService.getTransactionByState("OK");
        assertEquals(transactionList,result);
    }
    @Test
    public void  testGetTransactionByCategory(){
        List<Transaction> transactionList=new ArrayList<>();
        when(transactionRepository.findBycategory("shopping")).thenReturn(transactionList);
        List<Transaction>result=transactionService.getTransactionByCategory("shopping");
        assertEquals(transactionList,result);
    }
    @Test
    public void  testGetTransactionByJob(){
        List<Transaction> transactionList=new ArrayList<>();
        when(transactionRepository.findByjob("Seismic Interpreter")).thenReturn(transactionList);
        List<Transaction>result=transactionService.getTransactionByJob("Seismic Interpreter");
        assertEquals(transactionList,result);
    }
    @Test public void  testGetTransactionByAmt(){
        List<Transaction> transactionList=new ArrayList<>();
        when(transactionRepository.findByamt(190,195)).thenReturn(transactionList);
        List<Transaction>result=transactionService.getTransactionByAmt(190,195);
        assertEquals(transactionList,result);
    }
    @Test
    void testGetStateAmount() {
        List<StateAmount> expectedStateAmounts = new ArrayList<>();

        when(transactionMongoDBTemplate.getAmountSpentByState()).thenReturn(expectedStateAmounts);

        List<StateAmount> actualStateAmounts = transactionService.getStateAmount();

        assertEquals(expectedStateAmounts, actualStateAmounts);
        verify(transactionMongoDBTemplate, times(1)).getAmountSpentByState();
    }

    @Test
    void testGetMerchantAmount() {
        List<MerchantAmount> expectedMerchantAmounts = new ArrayList<>();

        when(transactionMongoDBTemplate.getAmountSpentByMerchant()).thenReturn(expectedMerchantAmounts);

        List<MerchantAmount> actualMerchantAmounts = transactionService.getMerchantAmount();

        assertEquals(expectedMerchantAmounts, actualMerchantAmounts);
        verify(transactionMongoDBTemplate, times(1)).getAmountSpentByMerchant();
    }

    @Test
    void testGetGenderAmount() {
        List<GenderAmount> expectedGenderAmounts = new ArrayList<>();

        when(transactionMongoDBTemplate.getSpentByGender()).thenReturn(expectedGenderAmounts);

        List<GenderAmount> actualGenderAmounts = transactionService.getGenderAmount();

        assertEquals(expectedGenderAmounts, actualGenderAmounts);
        verify(transactionMongoDBTemplate, times(1)).getSpentByGender();
    }

    @Test
    void testGetCategoryAmount() {
        List<CategoryAmount> expectedCategoryAmounts = new ArrayList<>();

        when(transactionMongoDBTemplate.getAmountSpentByCategory()).thenReturn(expectedCategoryAmounts);

        List<CategoryAmount> actualCategoryAmounts = transactionService.getCategoryAmount();

        assertEquals(expectedCategoryAmounts, actualCategoryAmounts);
        verify(transactionMongoDBTemplate, times(1)).getAmountSpentByCategory();
    }

    @Test
    void testGetCityAmount() {
        List<CityAmount> expectedCityAmounts = new ArrayList<>();

        when(transactionMongoDBTemplate.getAmountSpentByCity()).thenReturn(expectedCityAmounts);

        List<CityAmount> actualCityAmounts = transactionService.getCityAmount();

        assertEquals(expectedCityAmounts, actualCityAmounts);
        verify(transactionMongoDBTemplate, times(1)).getAmountSpentByCity();
    }

}
