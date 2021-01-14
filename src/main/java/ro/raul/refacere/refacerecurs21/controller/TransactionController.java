package ro.raul.refacere.refacerecurs21.controller;

import org.springframework.web.bind.annotation.*;
import ro.raul.refacere.refacerecurs21.entity.Transaction;
import ro.raul.refacere.refacerecurs21.service.TransactionService;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    Transaction addTransaction(@RequestBody Transaction transaction) {
        return transactionService.addTransaction(transaction);

    }

    @PutMapping("{transactionId}")
    Transaction replaceTransaction(@PathVariable Integer transactionId, @RequestBody Transaction transaction) {
        return transactionService.replaceTransaction(transactionId, transaction);
    }

    @DeleteMapping("{transactionId}")
    Transaction deleteTransaction(@PathVariable Integer transactionId) {
        return transactionService.deleteTransaction(transactionId);
    }
}
