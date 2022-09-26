package fr.pantheonsorbonne.ufr27.miage.m1.app.service;

import fr.pantheonsorbonne.ufr27.miage.m1.app.dao.AccountDAO;
import fr.pantheonsorbonne.ufr27.miage.m1.app.exception.InvalidFnameException;
import fr.pantheonsorbonne.ufr27.miage.m1.app.model.AccountDTO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
@ApplicationScoped
public class AccountServiceImpl implements AccountService{

    @Inject
    private AccountDAO accountDAO;

    @Override
    public void createAccount(String fname, String lname, double balance) throws InvalidFnameException {
        if(fname.length()<2){
            throw new InvalidFnameException();
        }
        accountDAO.createAccount(fname, lname, balance);
    }
    @Override
    public List<AccountDTO> getAccountList() {
        return this.accountDAO.getAccountList();
    }
    @Override
    public void deleteAccount(int id) {

    }
}
