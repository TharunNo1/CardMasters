package com.neueda.ccms.Services.Implementations;

import com.neueda.ccms.Entities.CreditCard;
import com.neueda.ccms.Entities.DatabaseSequence;
import com.neueda.ccms.Repositories.CreditCardRepository;
import com.neueda.ccms.Services.Interfaces.ICreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditCardService implements ICreditCardService {

    @Autowired
    private CreditCardRepository creditCardRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @Override
    public String addCreditCard(CreditCard creditCard) {
        creditCard.set_id(sequenceGeneratorService.generateSequence(CreditCard.SEQUENCE_NAME));
        new DatabaseSequence().setSeq(creditCard.get_id());
        creditCardRepository.save(creditCard);
        return "Added a credit card: " + creditCard.toString();
    }

    @Override
    public String removeCreditCard(String creditCardNumber) {
        creditCardRepository.deleteByCardNumber(creditCardNumber);
        return "Removed a credit card with card number : " + creditCardNumber;
    }

    @Override
    public String updateCreditCard(String creditCardNumber, CreditCard updatedCreditCard) {
        CreditCard prevCreditCard = creditCardRepository.findByCardNumber(creditCardNumber);
        if (!(prevCreditCard.getJob_title().equals(updatedCreditCard.getJob_title()))) {
            prevCreditCard.setJob_title(updatedCreditCard.getJob_title());
        }
        if (!(prevCreditCard.getLast_name().equals(updatedCreditCard.getLast_name()))) {
            prevCreditCard.setLast_name(updatedCreditCard.getLast_name());
        }

        return "Updated a credit card with card number : " + creditCardNumber;

    }

    @Override
    public CreditCard retrieveCreditCard(String creditCardNumber) {
        return creditCardRepository.findByCardNumber(creditCardNumber);
    }
}
