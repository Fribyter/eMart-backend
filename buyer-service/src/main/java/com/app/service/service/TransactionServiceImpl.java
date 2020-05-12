package com.app.service.service;

import com.app.service.model.Transaction;
import com.app.service.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    @Transactional
    public void checkout(Transaction transaction) {
        transactionRepository.saveAndFlush(transaction);
    }
}
