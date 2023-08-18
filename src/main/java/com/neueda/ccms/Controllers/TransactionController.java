package com.neueda.ccms.Controllers;


import com.neueda.ccms.Entities.Transaction;
import com.neueda.ccms.Repositories.TransactionRepository;
import com.neueda.ccms.Services.Implementations.TransactionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.neueda.ccms.DTO.*;

@RestController
@RequestMapping("/transaction")
//@Tag(name = "Transaction-Controller")
@CrossOrigin
public class TransactionController {
    @Autowired
    private TransactionService transactionService;
    @Autowired
    private TransactionRepository transactionRepository;
    @GetMapping("/city/{city}")
    public ResponseEntity<List<Transaction>> getTransactionByCity(@PathVariable String city)
    {
            return ResponseEntity.ok(this.transactionService.getTransactionByCity(city));
    }
    @GetMapping("/gender/{gender}")
    public  ResponseEntity<List<Transaction>> getTransactionByGender(@PathVariable char gender)
    {
        return ResponseEntity.ok(this.transactionService.getTransactionByGender(gender));
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Transaction>> getTransactionByCategory(@PathVariable String category)
    {
        return ResponseEntity.ok(this.transactionService.getTransactionByCategory(category));
    }

    @GetMapping("/merchant/{merchant}")
    public ResponseEntity<List<Transaction>> getTransactionByMerchant(@PathVariable String merchant)
    {
        return ResponseEntity.ok(this.transactionService.getTransactionByMerchant(merchant));
    }
    @GetMapping("/state/{state}")
    public List<Transaction> getTransactionByState(@PathVariable String state)
    {
        return this.transactionService.getTransactionByState(state);
    }
    @GetMapping("/job/{job}")
    public ResponseEntity<List<Transaction>> getTransactionByJob(@PathVariable String job)
    {
        return ResponseEntity.ok(this.transactionService.getTransactionByJob(job));
    }
    @GetMapping("/amt/{from}/{to}")
    public ResponseEntity<List<Transaction>> getTransactionByAmt(@PathVariable double from,double to)
    {
        return ResponseEntity.ok(this.transactionService.getTransactionByAmt(from,to));
    }


    @GetMapping("/pages")
    public Page<Transaction> getpaginationtransacts(@ParameterObject Pageable pageable) {
        return this.transactionRepository.findAll(pageable);
    }
    @GetMapping("/getStatebyAmount")
    public ResponseEntity<List<StateAmount>> getByStateAmount()
    {
        return ResponseEntity.status(HttpStatus.FOUND).body(transactionService.getStateAmount());
    }

    @GetMapping("/getMerchantbyAmount")
    public ResponseEntity<List<MerchantAmount>> getByMerchantAmount()
    {
        return ResponseEntity.status(HttpStatus.FOUND).body(transactionService.getMerchantAmount());
    }

    @GetMapping("/getGenderbyAmount")
    public ResponseEntity<List<GenderAmount>> getByGenderAmount()
    {
        return ResponseEntity.status(HttpStatus.FOUND).body(transactionService.getGenderAmount());
    }

    @GetMapping("/getCategorybyAmount")
    public ResponseEntity<List<CategoryAmount>> getByCategoryAmount()
    {
        return ResponseEntity.status(HttpStatus.FOUND).body(transactionService.getCategoryAmount());
    }

    @GetMapping("/getCitybyAmount")
    public List<CityAmount> getByCityAmount()
    {
        return transactionService.getCityAmount();
    }




}
