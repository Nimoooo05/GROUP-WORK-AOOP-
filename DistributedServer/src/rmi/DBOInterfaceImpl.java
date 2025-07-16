package rmi;

import server.DBOperations;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class DBOInterfaceImpl extends UnicastRemoteObject implements DBOInterface{
    DBOperations dbo = new DBOperations();
    
    public DBOInterfaceImpl() throws RemoteException{
        super();
    }

    @Override
    public String insertOperation(int id, String make, String model, int engineSize, String status, int price) throws RemoteException {
        return dbo.insertOperation(id, make, model, engineSize, status, price);
    }

    @Override
    public String[] selectOperation(int id) throws RemoteException {
        return dbo.selectOperation(id);
    }

    @Override
    public String updateOperation(int oldId, int newId, String make, String model, int engineSize, String status, int price) throws RemoteException {
        return dbo.updateOperation(oldId, newId, make, model, engineSize, status, price);
    }

    @Override
    public String deleteOperation(int id) throws RemoteException {
        return dbo.deleteOperation(id);
    }
    
}