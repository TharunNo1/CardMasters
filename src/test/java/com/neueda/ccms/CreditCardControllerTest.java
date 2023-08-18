package com.neueda.ccms;

import com.neueda.ccms.Entities.CreditCard;
import com.neueda.ccms.Repositories.CreditCardRepository;
import com.neueda.ccms.Controllers.CreditCardController;
import com.neueda.ccms.Services.Implementations.CreditCardService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CreditCardControllerTest {

    @Mock
    private CreditCardService creditCardService;

    @Mock
    private CreditCardRepository creditCardRepository;

    @InjectMocks
    private CreditCardController creditCardController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRegisterCreditCardSuccess() {
        CreditCard creditCard = new CreditCard();
        when(creditCardService.addCreditCard(creditCard)).thenReturn("Credit card added successfully");

        ResponseEntity response = creditCardController.registerCreditCard(creditCard);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Credit card added successfully", response.getBody());
    }

    @Test
    public void testRegisterCreditCardFailure() {
        CreditCard creditCard = new CreditCard();
        when(creditCardService.addCreditCard(creditCard)).thenThrow(new RuntimeException("Registration error"));

        ResponseEntity response = creditCardController.registerCreditCard(creditCard);

        assertEquals(HttpStatus.NOT_ACCEPTABLE, response.getStatusCode());
        assertEquals("Exception :Registration error", response.getBody());
    }

    @Test
    public void testCancelCreditCardSuccess() {
        String creditCardNumber = "123456789";
        String pin = "1234";
        CreditCard creditCard = new CreditCard();
        creditCard.setSecurity_pin(pin);
        when(creditCardRepository.findByCardNumber(creditCardNumber)).thenReturn(creditCard);

        ResponseEntity response = creditCardController.cancelCreditCard(creditCardNumber, pin);

        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
    }

    @Test
    public void testCancelCreditCardInvalidPin() {
        String creditCardNumber = "123456789";
        String invalidPin = "5678";
        CreditCard creditCard = new CreditCard();
        creditCard.setSecurity_pin("1234");
        when(creditCardRepository.findByCardNumber(creditCardNumber)).thenReturn(creditCard);

        ResponseEntity response = creditCardController.cancelCreditCard(creditCardNumber, invalidPin);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Invalid PIN number entered!", response.getBody());
    }

    @Test
    public void testCancelCreditCardFailure() {
        String creditCardNumber = "123456789";
        String pin = "1234";
        when(creditCardRepository.findByCardNumber(creditCardNumber)).thenReturn(null);

        ResponseEntity response = creditCardController.cancelCreditCard(creditCardNumber, pin);

        assertEquals(HttpStatus.NOT_ACCEPTABLE, response.getStatusCode());
    }
}