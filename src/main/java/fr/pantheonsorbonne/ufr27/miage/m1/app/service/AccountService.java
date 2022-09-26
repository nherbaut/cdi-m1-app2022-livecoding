package fr.pantheonsorbonne.ufr27.miage.m1.app.service;

import fr.pantheonsorbonne.ufr27.miage.m1.app.exception.InvalidFnameException;
import fr.pantheonsorbonne.ufr27.miage.m1.app.model.AccountDTO;

import java.util.List;

public interface AccountService {

    void createAccount(final String fname,final String lname,final double balance) throws InvalidFnameException;
    void deleteAccount(final int id);
    List<AccountDTO> getAccountList();

}
