package ro.raul.refacere.refacerecurs21;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.raul.refacere.refacerecurs21.entity.*;
import ro.raul.refacere.refacerecurs21.repository.AccountRepository;
import ro.raul.refacere.refacerecurs21.repository.LabelRepository;
import ro.raul.refacere.refacerecurs21.repository.TransactionRepository;

import java.util.List;

@SpringBootApplication
public class RefacereCurs21Application {

    public static void main(String[] args) {
        SpringApplication.run(RefacereCurs21Application.class, args);
    }

    @Bean
    CommandLineRunner atStartup(TransactionRepository transactionRepository, AccountRepository accountRepository,
                                LabelRepository labelRepository
    ) {


        return args -> {
            Account account = accountRepository.save(new Account("Raul"));
            Account account1 = accountRepository.save(new Account("Adrian"));
            Account account2 = accountRepository.save(new Account("Alexandra"));

            Category utils = new Category("utils");
            Category personal = new Category("personal");
            Category food = new Category("food");

            Label christmas = labelRepository.save(new Label("christmas"));
            Label lenovo = labelRepository.save(new Label("lenovo"));
            Label gifts = labelRepository.save(new Label("gifts"));
            Label audi = labelRepository.save(new Label("audi"));
            Label newJob = labelRepository.save(new Label("new job"));
            transactionRepository.saveAll(List.of(
                    new Transaction("pita", Type.BUY, 5, account, food),
                    new Transaction("cafea", Type.BUY, 6, account2, food),
                    new Transaction("laptop", Type.SELL, 4500, account, utils,
                            List.of(christmas,
                                    lenovo,
                                    gifts)
                    ),
                    new Transaction("televizor", Type.BUY, 2500, account1, personal),
                    new Transaction("masina", Type.SELL, 50000, account2, utils, List.of(
                            christmas,
                            audi,
                            newJob
                    ))
            ));
        };
    }
}

