package rmi;
 
import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
 
public class ServerApp {
    public static void main(String[] args){
        try {
            DBOInterfaceImpl dboi = new DBOInterfaceImpl();
            
            Registry rmiRegistry = LocateRegistry.createRegistry(1099);            
            rmiRegistry.bind("DBOperations", (Remote) dboi);
            
            System.out.println("Server is running ...");
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        } catch (AlreadyBoundException ex) {
            System.out.println(ex.getMessage());
        } 
    }
}