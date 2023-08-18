package com.neueda.ccms;

import com.neueda.ccms.Entities.CreditCard;
import com.neueda.ccms.Entities.DatabaseSequence;
import com.neueda.ccms.Repositories.CreditCardRepository;
import com.neueda.ccms.Services.Implementations.CreditCardService;
import com.neueda.ccms.Services.Implementations.SequenceGeneratorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class CreditCardServiceTest {

    @Mock
    private CreditCardRepository creditCardRepository;

    @Mock
    private SequenceGeneratorService sequenceGeneratorService;

    @InjectMocks
    private CreditCardService creditCardService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddCreditCard() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
        CreditCard creditCard = new CreditCard("Tharun","G","Male", formatter.parse("2002-05-02"), "Student", "MASTERCARD", "8759-1423-0000-3213", "2002");

        when(sequenceGeneratorService.generateSequence(any())).thenReturn(creditCard.get_id());

        creditCardService.addCreditCard(creditCard);

        verify(creditCardRepository, times(1)).save(creditCard);
    }

    @Test
    public void testRemoveCreditCard() {

        String creditCardNumber = "4169-3690-3065-9632";
        when(creditCardRepository.deleteByCardNumber(creditCardNumber)).thenReturn(null);

        creditCardService.removeCreditCard(creditCardNumber);

        verify(creditCardRepository, times(1)).deleteByCardNumber(creditCardNumber);
    }


    @Test
    public void testUpdateCreditCard() throws ParseException {
        String creditCardNumber = "4004-7544-6482-17689";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
        CreditCard creditCard = new CreditCard("Tharun","G","Male", formatter.parse("2002-05-02"), "Student", "MASTERCARD", "8759-1423-0000-3213", "2002");
        CreditCard updatedCreditCard = creditCard;

        updatedCreditCard.setCard_number(creditCardNumber);

        when(creditCardRepository.findByCardNumber(creditCardNumber)).thenReturn(updatedCreditCard);

        String result = creditCardService.updateCreditCard(creditCardNumber, creditCard);

        verify(creditCardRepository, times(1)).findByCardNumber(creditCardNumber);

        assertNotNull(result);
    }

    @Test
    public void testRetrieveCreditCard() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
        CreditCard retrievedCreditCard = new CreditCard("Tharun","G","Male", formatter.parse("2002-05-02"), "Student", "VISA", "8759-1423-0000-3213", "2002");
        retrievedCreditCard.setCard_number();
        String creditCardNumber = retrievedCreditCard.getCard_number();
        when(creditCardRepository.findByCardNumber(creditCardNumber)).thenReturn(retrievedCreditCard);

        CreditCard result = creditCardService.retrieveCreditCard(creditCardNumber);

        verify(creditCardRepository, times(1)).findByCardNumber(creditCardNumber);
        assertEquals(retrievedCreditCard.getCard_number(), result.getCard_number());

    }
}