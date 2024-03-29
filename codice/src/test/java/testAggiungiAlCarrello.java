import static org.junit.Assert.*;


import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import org.junit.Test;

import DataBase.DbProdotti;
import DataBase.DbUtenti;
import Elaborazione.GestoreAccessi;
import Elaborazione.GestoreCarrelli;
import UserInterface.*;

public class testAggiungiAlCarrello {
     
    GestoreCarrelli gestore = new GestoreCarrelli(new DbProdotti());
    
    @Test
    public void testAggiuntaAlCarrello() throws RemoteException, NotBoundException{

    //controllo inserimento quantità prodotto disponibile
    assertTrue(gestore.controlloLimiteQuantita(2));
    
    //controllo inserimento quantità non valida
    assertFalse(gestore.controlloLimiteQuantita(4));
    assertFalse(gestore.controlloLimiteQuantita(0));
    
    //controllo di prodotto disponibile
    assertTrue(gestore.controlloDisponibilita(100000));
    
    //controllo di prodotto non disponibile
    assertFalse(gestore.controlloDisponibilita(100003));


    }

/*
    @Test
    public void testAggiunta() throws RemoteException{
       UiCarrello uiCarrello = new UiCarrello();
       uiCarrello.avvioAggiungiAlCarrello("aldo",100000);
    }
*/
}
