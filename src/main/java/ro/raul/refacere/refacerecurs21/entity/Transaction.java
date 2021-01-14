package ro.raul.refacere.refacerecurs21.entity;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.PERSIST;

@Entity
public class Transaction {
    @Id
    @GeneratedValue
    private int id;
    private String product;
    private Type type;
    private double amount;
    @OneToOne
    private Account account;
    @ManyToOne(cascade = PERSIST)
    private Category category;

    @ManyToMany
    private List<Label> labels;


    public Transaction(String product, Type type, double amount, Account account, Category category) {
        this(product, type, amount, account, category, List.of());
    }

    public Transaction(String product, Type type, double amount, Account account, Category category, List<Label> labels) {
        this.product = product;
        this.type = type;
        this.amount = amount;
        this.account = account;
        this.category = category;
        this.labels = labels;

    }

    public Transaction() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
