package com.neueda.ccms.Controllers;

import com.neueda.ccms.Entities.CreditCard;
import com.neueda.ccms.Repositories.CreditCardRepository;
import com.neueda.ccms.Services.Implementations.CreditCardService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@Tag(name = "Creditcard-Controller")
@RequestMapping("/creditcard")
@CrossOrigin
public class CreditCardController {
    @Autowired
    private CreditCardService creditCardService;

    @Autowired
    private CreditCardRepository creditCardRepository;

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PostMapping("/registeration")
    public ResponseEntity registerCreditCard(@RequestBody CreditCard creditCard) {
        try {
            creditCard.setCard_number();
            return ResponseEntity.status(HttpStatus.CREATED).body(this.creditCardService.addCreditCard(creditCard));
        }
        catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Exception :" + exception.getMessage());
        }
    }


    @DeleteMapping("/cancellation/{creditCardNumber}-{PIN}")
    public ResponseEntity<Object> cancelCreditCard(@PathVariable String creditCardNumber, @PathVariable String PIN) {
                try {
                    System.out.println(creditCardNumber);
                    String passKey = creditCardRepository.findByCardNumber(creditCardNumber).getSecurity_pin();
                    if (passKey.equals(PIN)) {
                        return ResponseEntity.status(HttpStatus.ACCEPTED).body(this.creditCardService.removeCreditCard(creditCardNumber));
                    }
                    else {
                        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid PIN number entered!");
                    }
                }
                catch (Exception exception) {
                    return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Exception :" + exception.getMessage());
                }
    }

    @GetMapping("/getDetailsByCardNumber/{creditCardNumber}-{PIN}")
    public Object getCreditCard(@PathVariable String creditCardNumber, @PathVariable String PIN) {
        try {
            System.out.println(creditCardNumber);
            String passKey = creditCardRepository.findByCardNumber(creditCardNumber).getSecurity_pin();
            if (passKey.equals(PIN)) {
                return this.creditCardService.retrieveCreditCard(creditCardNumber);
            }
            else {
                return "Invalid PIN number entered!";
            }
        }
        catch (Exception exception) {
            return "Exception :" + exception.getMessage();
        }
    }

    @PutMapping("/updateCreditCardDetails")
    public ResponseEntity updateCreditCard(@RequestBody CreditCard creditCard) {
        try {
            String creditCardNumber = creditCard.getCard_number();
            String PIN = creditCard.getSecurity_pin();
            String passKey = creditCardRepository.findByCardNumber(creditCardNumber).getSecurity_pin();
            if (passKey.equals(PIN)) {
                return ResponseEntity.status(HttpStatus.ACCEPTED).body(this.creditCardService.updateCreditCard(creditCardNumber, creditCard));
            }
            else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid PIN number entered!");
            }
        }
        catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Exception :" + exception.getMessage());
        }
    }



}
