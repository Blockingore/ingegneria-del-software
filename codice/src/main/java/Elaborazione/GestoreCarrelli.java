package Elaborazione;

import java.util.HashMap;

import java.util.ArrayList;



import java.rmi.registry.Registry;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.rmi.registry.LocateRegistry; 
import java.rmi.RemoteException;
import java.beans.Statement;
import java.rmi.NotBoundException;

import DataBase.*;




public class GestoreCarrelli implements GestoreCarrelliInterfaccia
{
	private Registry registry;
	private DbProdottiInterfaccia dbProdotti;

	public GestoreCarrelli(String host) throws RemoteException, NotBoundException
	{
		registry = LocateRegistry.getRegistry(host, 1098); 
       	dbProdotti = (DbProdottiInterfaccia) registry.lookup("dbProdotti");
	}
	
	public GestoreCarrelli(DbProdotti d1)
	{
		dbProdotti = d1;
	}


	public boolean controlloLimiteQuantita(int quantita){
		//RF 09 - aggiunta al carrello
		//autori: Fasano Lorenzo, Iacobucci Luca;

		if(quantita > 0 && quantita < 4)
			return true;
		return false;
	}


	public boolean controlloDisponibilita(int codiceProdotto) throws RemoteException{

		//RF 09 - aggiunta al carrello
		//autori: Fasano Lorenzo, Iacobucci Luca;

		String query = "SELECT * FROM Prodotto WHERE codice =" + codiceProdotto; //+ " AND disponibile = 1";
		System.out.println(dbProdotti.query(query));
		if(dbProdotti.query(query).size() != 0){
			return true;
		}

		System.out.println("Query: "+ query);
		return false;

		}

		public void aggiornamentoQuantita(int quantita, int codiceProdotto, String username) throws RemoteException{

		//RF 09 - aggiunta al carrello
		//autori: Fasano Lorenzo, Iacobucci Luca;
	
		String query = "UPDATE Prodotto SET quantita = quantita - " + 
		quantita + " WHERE codiceProdotto =" + codiceProdotto +"AND username = " + username;
		
		dbProdotti.update(query);

		}



}

