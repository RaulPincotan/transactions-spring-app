package ro.raul.refacere.refacerecurs21.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.raul.refacere.refacerecurs21.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
}
