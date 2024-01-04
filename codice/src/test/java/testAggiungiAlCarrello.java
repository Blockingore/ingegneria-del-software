


import static org.junit.Assert.assertEquals;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import org.junit.Test;

import DataBase.DbProdotti;
import Elaborazione.GestoreCarrelli;
import UserInterface.UiCarrello;
import UserInterface.UiCarrelloInterfaccia;

public class testAggiungiAlCarrello{

    GestoreCarrelli gesto = new GestoreCarrelli(new DbProdotti());



    @Test
    public void testControlloLimiteQuantita() throws RemoteException, NotBoundException {

   
        //quantita non valida: troppo grande 
        assertEquals(false, gesto.controlloLimiteQuantita(5));
        
        //quantita non valida: troppo piccola 
        assertEquals(false, gesto.controlloLimiteQuantita(0));
       
        //quantita valida 
        assertEquals(true, gesto.controlloLimiteQuantita(2));
      
    }


    @Test
    public void testControlloDisponibilita() throws RemoteException{
        
        assertEquals(true, gesto.controlloDisponibilita(10000));
    }
}
