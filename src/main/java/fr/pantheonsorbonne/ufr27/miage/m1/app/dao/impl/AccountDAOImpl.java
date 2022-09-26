package fr.pantheonsorbonne.ufr27.miage.m1.app.dao.impl;

import fr.pantheonsorbonne.ufr27.miage.m1.app.dao.AccountDAO;
import fr.pantheonsorbonne.ufr27.miage.m1.app.model.AccountDTO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
@Named("array")
public class AccountDAOImpl implements AccountDAO {

    private AccountDTO[] accounts;
    private int size = 0;
    private static final int INITIAL_SIZE = 5000;

    {
        accounts = new AccountDTO[INITIAL_SIZE];


    }

    public AccountDAOImpl(){


            this.createAccount("toto", "tutu", 1);
            this.createAccount("totoMap", "tutuMAP", 1);
            this.createAccount("Maptoto", "Maptutu", 1);



    }

    @Override
    public void createAccount(String fname, String lname, double balance) {
        var account = new AccountDTO(size++, fname, lname, balance);
        accounts[size - 1] = account;


    }

    @Override
    public void deleteAccount(int id) {
        throw new RuntimeException(new NoSuchMethodException());
    }

    @Override
    public List<AccountDTO> getAccountList() {
        return Arrays.stream(this.accounts).filter(a->a!=null).collect(Collectors.toList());
    }
}
