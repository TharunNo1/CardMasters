package com.neueda.ccms;


import com.neueda.ccms.Controllers.TransactionController;
import com.neueda.ccms.DTO.*;
import com.neueda.ccms.Entities.Transaction;
import com.neueda.ccms.Services.Implementations.TransactionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class TransactionControllerTest {

    @Mock
    private TransactionService transactionService;

    @InjectMocks
    private TransactionController transactionController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetByStateAmount() {
        List<StateAmount> stateAmountList = new ArrayList<>();
        // Add some mock data to the list
        // stateAmountList.add(...);

        when(transactionService.getStateAmount()).thenReturn(stateAmountList);

        ResponseEntity<List<StateAmount>> responseEntity = transactionController.getByStateAmount();

        assert responseEntity.getStatusCode() == HttpStatus.FOUND;
        assert responseEntity.getBody() == stateAmountList;

        verify(transactionService, times(1)).getStateAmount();
        verifyNoMoreInteractions(transactionService);
    }
    @Test
    public void testGetTransactionByCity() {
        String city = "New York";
        List<Transaction> transactions = new ArrayList<>();
        // Add some mock transactions

        when(transactionService.getTransactionByCity(city)).thenReturn(transactions);

        ResponseEntity<List<Transaction>> responseEntity = transactionController.getTransactionByCity(city);

        assert responseEntity.getStatusCode() == HttpStatus.OK;
        assert responseEntity.getBody() == transactions;

        verify(transactionService, times(1)).getTransactionByCity(city);
        verifyNoMoreInteractions(transactionService);
    }
    @Test
    public void testGetTransactionByGender() {
        char gender = 'M';
        List<Transaction> transactions = new ArrayList<>();
        // Add some mock transactions

        when(transactionService.getTransactionByGender(gender)).thenReturn(transactions);

        ResponseEntity<List<Transaction>> responseEntity = transactionController.getTransactionByGender(gender);

        assert responseEntity.getStatusCode() == HttpStatus.OK;
        assert responseEntity.getBody() == transactions;

        verify(transactionService, times(1)).getTransactionByGender(gender);
        verifyNoMoreInteractions(transactionService);
    }
    @Test
    public void testGetTransactionByCategory() {
        String category = "Electrical";
        List<Transaction> transactions = new ArrayList<>();
        // Add some mock transactions

        when(transactionService.getTransactionByCategory(category)).thenReturn(transactions);

        ResponseEntity<List<Transaction>> responseEntity = transactionController.getTransactionByCategory(category);

        assert responseEntity.getStatusCode() == HttpStatus.OK;
        assert responseEntity.getBody() == transactions;

        verify(transactionService, times(1)).getTransactionByCategory(category);
        verifyNoMoreInteractions(transactionService);
    }
    @Test
    public void testGetTransactionByMerchant() {
        String merchant = " Merchant";
        List<Transaction> transactions = new ArrayList<>();
        // Add some mock transactions

        when(transactionService.getTransactionByMerchant(merchant)).thenReturn(transactions);

        ResponseEntity<List<Transaction>> responseEntity = transactionController.getTransactionByMerchant(merchant);

        assert responseEntity.getStatusCode() == HttpStatus.OK;
        assert responseEntity.getBody() == transactions;

        verify(transactionService, times(1)).getTransactionByMerchant(merchant);
        verifyNoMoreInteractions(transactionService);
    }

    @Test
    public void testGetTransactionByState() {
        String state = "Chennai";
        List<Transaction> transactions = new ArrayList<>();
        // Add some mock transactions

        when(transactionService.getTransactionByState(state)).thenReturn(transactions);

        List<Transaction> result = transactionController.getTransactionByState(state);

        assert result == transactions;

        verify(transactionService, times(1)).getTransactionByState(state);
        verifyNoMoreInteractions(transactionService);
    }

    @Test
    public void testGetTransactionByJob() {
        String job = "Engineer";
        List<Transaction> transactions = new ArrayList<>();
        // Add some mock transactions

        when(transactionService.getTransactionByJob(job)).thenReturn(transactions);

        ResponseEntity<List<Transaction>> responseEntity = transactionController.getTransactionByJob(job);

        assert responseEntity.getStatusCode() == HttpStatus.OK;
        assert responseEntity.getBody() == transactions;

        verify(transactionService, times(1)).getTransactionByJob(job);
        verifyNoMoreInteractions(transactionService);
    }

    @Test
    public void testGetTransactionByAmt() {
        double from = 100.0;
        double to = 200.0;
        List<Transaction> transactions = new ArrayList<>();
        // Add some mock transactions

        when(transactionService.getTransactionByAmt(from, to)).thenReturn(transactions);

        ResponseEntity<List<Transaction>> responseEntity = transactionController.getTransactionByAmt(from, to);

        assert responseEntity.getStatusCode() == HttpStatus.OK;
        assert responseEntity.getBody() == transactions;

        verify(transactionService, times(1)).getTransactionByAmt(from, to);
        verifyNoMoreInteractions(transactionService);
    }

    @Test
    public void testGetByCityAmount() {
        List<CityAmount> cityAmountList = new ArrayList<>();
        // Add some mock city amount data
        // cityAmountList.add(...);

        when(transactionService.getCityAmount()).thenReturn(cityAmountList);

        ResponseEntity<List<CityAmount>> responseEntity = transactionController.getByCityAmount();

        assert responseEntity.getStatusCode() == HttpStatus.FOUND;
        assert responseEntity.getBody() == cityAmountList;

        verify(transactionService, times(1)).getCityAmount();
        verifyNoMoreInteractions(transactionService);
    }
    @Test
    public void testGetByCategoryAmount() {
        List<CategoryAmount> categoryAmountList = new ArrayList<>();
        // Add some mock category amount data
        // categoryAmountList.add(...);

        when(transactionService.getCategoryAmount()).thenReturn(categoryAmountList);

        ResponseEntity<List<CategoryAmount>> responseEntity = transactionController.getByCategoryAmount();

        assert responseEntity.getStatusCode() == HttpStatus.FOUND;
        assert responseEntity.getBody() == categoryAmountList;

        verify(transactionService, times(1)).getCategoryAmount();
        verifyNoMoreInteractions(transactionService);
    }
    @Test
    public void testGetByGenderAmount() {
        List<GenderAmount> genderAmountList = new ArrayList<>();
        // Add some mock gender amount data
        // genderAmountList.add(...);

        when(transactionService.getGenderAmount()).thenReturn(genderAmountList);

        ResponseEntity<List<GenderAmount>> responseEntity = transactionController.getByGenderAmount();

        assert responseEntity.getStatusCode() == HttpStatus.FOUND;
        assert responseEntity.getBody() == genderAmountList;

        verify(transactionService, times(1)).getGenderAmount();
        verifyNoMoreInteractions(transactionService);
    }
    @Test
    public void testGetByMerchantAmount() {
        List<MerchantAmount> merchantAmountList = new ArrayList<>();
        // Add some mock merchant amount data
        // merchantAmountList.add(...);

        when(transactionService.getMerchantAmount()).thenReturn(merchantAmountList);

        ResponseEntity<List<MerchantAmount>> responseEntity = transactionController.getByMerchantAmount();

        assert responseEntity.getStatusCode() == HttpStatus.FOUND;
        assert responseEntity.getBody() == merchantAmountList;

        verify(transactionService, times(1)).getMerchantAmount();
        verifyNoMoreInteractions(transactionService);
    }


}
















