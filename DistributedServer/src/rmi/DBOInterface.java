package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DBOInterface extends Remote {

    public String insertOperation(int id, String make, String model, int engineSize, String status, int price) throws RemoteException;

    public String[] selectOperation(int id) throws RemoteException;

    public String updateOperation(int oldId, int newId, String make, String model, int engineSize, String status, int price) throws RemoteException;

    public String deleteOperation(int id) throws RemoteException;
}
