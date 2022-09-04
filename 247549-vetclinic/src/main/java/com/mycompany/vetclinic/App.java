package com.mycompany.vetclinic;

import model.Animal;
import model.AnimalDAO;
import model.Spicie;
import model.SpicieDAO;
import model.Client;
import model.ClientDAO;
import java.util.List;

public class App {

    public static void main(String[] args) {
        //Spicie o0 = SpicieDAO.getInstance().create("Cachorro");
        // Animal o1 = AnimalDAO.getInstance().create("Chaya", 2021, "F", 2, 2);
        
        //SpicieDAO.getInstance().delete(4);
        List oo = ClientDAO.getInstance().retrieveAll();
        
        System.out.println(oo);

    }
}
