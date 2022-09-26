package fr.pantheonsorbonne.ufr27.miage.m1.app;

import fr.pantheonsorbonne.ufr27.miage.m1.app.model.AccountDTO;
import fr.pantheonsorbonne.ufr27.miage.m1.app.service.AccountService;
import fr.pantheonsorbonne.ufr27.miage.m1.app.service.AccountServiceImpl;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.stream.Collectors;

@Path("/")
public class GreetingResource {


    @Inject
    private AccountService service;

    @Path("account")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String listAccounts(){

        return service.getAccountList().stream().map( a -> a.toString()).collect(Collectors.joining(" "));
    }
}
