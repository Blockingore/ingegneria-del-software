package UserInterface;
import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;
import java.rmi.registry.Registry; 
import java.rmi.registry.LocateRegistry; 
import java.rmi.RemoteException;
import java.rmi.NotBoundException;
import javax.swing.*;
import java.awt.GridLayout;


import UserInterface.*;
import Elaborazione.*;

public class UiCarrello extends JOptionPane implements UiCarrelloInterfaccia
{
	// registri
	private Registry registryUI;
	private Registry registryGestore;

	// componenti
	private UiNotificaInterfaccia uiNotifica;
	private GestoreCarrelliInterfaccia gestoreCarrelli;

	// attributi
	
	
	private int scelta; /*RF09*/
	private int quantita; /*RF09*/
	
	// elementi grafici
	
	private JLabel quantitaLabel;	/*RF09*/
	private JTextField quantitaField; /*RF09*/
	private JPanel formPanel;	/*RF09*/
	private String[] pulsanteOK;	/*RF09*/

	public UiCarrello(String hostGestore) throws RemoteException, NotBoundException
	{
	registryUI = LocateRegistry.getRegistry("127.0.0.1", 1100); // default: 1099
	registryGestore = LocateRegistry.getRegistry(hostGestore, 1099);

	uiNotifica = (UiNotificaInterfaccia) registryUI.lookup("uiNotifica");
	gestoreCarrelli = (GestoreCarrelliInterfaccia) registryGestore.lookup("gestoreCarrelli"); 

	quantitaLabel = new JLabel("Quantita'");		//RF09
	quantitaField = new JTextField("", 10); //RF09

	formPanel = new JPanel(new GridLayout(1,1)); //RF09
	formPanel.add(quantitaLabel);  //RF09
	formPanel.add(quantitaField); //RF09
	
	pulsanteOK = new String[1]; //RF09
		pulsanteOK[0] = "Ok"; //RF09

}
	
	public void avvioVisualizzaCarrello() throws RemoteException
	{	// RF05	
	}

	public void avvioEffettuaOrdine() throws RemoteException
	{	// RF06	
	}

	public void avvioRimuoviProdottiDalCarrello() throws RemoteException
	{	// RF07	
	}

	public void avvioAggiungiAlCarrello(String username, int codiceProdotto) throws RemoteException
	{	// RF09	
		// Autori: Fasano Lorenzo, Iacobucci Luca;

		int quantitaUtente = mostraForm();


	}

	public int mostraForm() throws RemoteException
	{	// RF09	
		// Autori: Fasano Lorenzo, Iacobucci Luca;

System.out.println("sono dentro mostraForm()");
		scelta = this.showOptionDialog(null, formPanel, "Inserire quantita'", DEFAULT_OPTION, QUESTION_MESSAGE, null, pulsanteOK, "OK");

		//utente preme OK
		if(scelta == 0){
			//aggiungere numberFormatException
			quantita = Integer.parseInt(quantitaField.getText());
			System.out.println("quantita inserita:" + quantita);
		}
		//utente preme X
		if(scelta == -1){
			System.out.println("Inserimento annullato");
			return -1;
		}


		return quantita;
	}


	
	}




