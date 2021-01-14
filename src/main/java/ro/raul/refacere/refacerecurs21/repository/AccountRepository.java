package ro.raul.refacere.refacerecurs21.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.raul.refacere.refacerecurs21.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {
}
