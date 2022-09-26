package fr.pantheonsorbonne.ufr27.miage.m1.app.service;

import fr.pantheonsorbonne.ufr27.miage.m1.app.dao.AccountDAO;
import fr.pantheonsorbonne.ufr27.miage.m1.app.exception.InvalidFnameException;
import fr.pantheonsorbonne.ufr27.miage.m1.app.model.AccountDTO;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@ApplicationScoped
public class AccountServiceImpl implements AccountService {
    @Inject
    public AccountServiceImpl(@Named("map") AccountDAO accountDAO) {
        this.accountDAO = accountDAO;

    }


    final private AccountDAO accountDAO;


    @ConfigProperty(name = "fr.pantheonsorbonne.ufr27.miage.m1.app.service.balanceLimit")
    long limit;

    @Override
    public void createAccount(String fname, String lname, double balance) throws InvalidFnameException {
        if (fname.length() < 2) {
            throw new InvalidFnameException();
        }
        if (balance < this.limit) {
            throw new RuntimeException("la balance est trop faible");
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
