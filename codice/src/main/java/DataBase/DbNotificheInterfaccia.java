package DataBase;

import java.rmi.Remote; 
import java.rmi.RemoteException;  

import java.util.HashMap;
import java.util.ArrayList;

public interface DbNotificheInterfaccia extends Remote 
{  
   ArrayList<HashMap<String, Object>> query(String comandoSql) throws RemoteException;
   void update(String comandoSql) throws RemoteException;
} 
