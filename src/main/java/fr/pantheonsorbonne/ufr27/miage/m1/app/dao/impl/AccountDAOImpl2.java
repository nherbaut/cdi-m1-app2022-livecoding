package fr.pantheonsorbonne.ufr27.miage.m1.app.dao.impl;

import fr.pantheonsorbonne.ufr27.miage.m1.app.dao.AccountDAO;
import fr.pantheonsorbonne.ufr27.miage.m1.app.model.AccountDTO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
@Named("map")
public class AccountDAOImpl2 implements AccountDAO {


    private Map<Integer, AccountDTO> accounts = new HashMap<>();
    private static int counter = 0;

    public AccountDAOImpl2() {

        this.createAccount("toto", "tutu", 1);
        this.createAccount("totoMap", "tutuMAP", 1);
        this.createAccount("Maptoto", "Maptutu", 1);


    }

    @Override
    public void createAccount(String fname, String lname, double balance) {
        var newAccount = new AccountDTO(counter++, fname, lname, balance);
        this.accounts.put(newAccount.id(), newAccount);
    }

    @Override
    public void deleteAccount(int id) {
        this.accounts.remove(id);
    }

    @Override
    public List<AccountDTO> getAccountList() {
        List<AccountDTO> res = new ArrayList<>();
        res.addAll(this.accounts.values());
        return res;
    }
}
