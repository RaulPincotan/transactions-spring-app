package ro.raul.refacere.refacerecurs21.service;

import org.springframework.stereotype.Service;
import ro.raul.refacere.refacerecurs21.entity.Transaction;
import ro.raul.refacere.refacerecurs21.exceptions.TransactionNotFoundException;
import ro.raul.refacere.refacerecurs21.repository.TransactionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> getAll() {
        return transactionRepository.findAll();
    }


    public Transaction getOneTransaction(Integer transactionId) {
        return transactionRepository.findById(transactionId)
                .orElseThrow(() -> new TransactionNotFoundException("Transaction with id " + transactionId + " could not be found!"));
    }

    public Transaction addTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public Transaction replaceTransaction(Integer transactionId, Transaction transaction) {
        transaction.setId(transactionId);
        return transactionRepository.save(transaction);
    }

    public Transaction deleteTransaction(Integer transactioId) {
        Optional<Transaction> dobTransaction = transactionRepository.findById(transactioId);
        dobTransaction.ifPresent(transactionRepository::delete);
        return dobTransaction.orElse(null);
    }


}
