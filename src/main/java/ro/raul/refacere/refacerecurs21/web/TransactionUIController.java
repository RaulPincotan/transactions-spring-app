package ro.raul.refacere.refacerecurs21.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ro.raul.refacere.refacerecurs21.service.TransactionService;

@Controller
@RequestMapping("/transactions")
public class TransactionUIController {
    private final TransactionService transactionService;

    public TransactionUIController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    String getAllTransactionsPage(Model model) {
        model.addAttribute("transactions", transactionService.getAll());
        return "transactions";
    }

    // iti dau toate tranzactiile dar iti dau si detaliile transactiei respective
    @GetMapping("{transactionId}")
    public String getTrasactionPage(Model pageModel, @PathVariable Integer transactionId) {
        pageModel.addAttribute("showDetails", true);
        pageModel.addAttribute("selectedTransaction", transactionService.getOneTransaction(transactionId));
        pageModel.addAttribute("transactions", transactionService.getAll());
        return "transactions";
    }

}
