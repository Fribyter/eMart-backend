package com.app.service.controller;

import com.app.service.model.Item;
import com.app.service.model.Transaction;
import com.app.service.service.ItemService;
import com.app.service.service.TransactionService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/*
 Commented as its been called from Zuul Gateway Service
 Uncomment if to call directly
@CrossOrigin

*/
@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @RequestMapping(value = "/checkout", method = RequestMethod.POST)
    public void checkout(@RequestBody Transaction transaction) {
        transactionService.checkout(transaction);
    }
}
