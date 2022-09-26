package fr.pantheonsorbonne.ufr27.miage.m1.app.dao;

import fr.pantheonsorbonne.ufr27.miage.m1.app.model.AccountDTO;

import java.util.List;

public interface AccountDAO {
    void createAccount(final String fname,final String lname,final double balance);
    void deleteAccount(final int id);
    List<AccountDTO> getAccountList();
}
