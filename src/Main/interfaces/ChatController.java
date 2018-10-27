package Main.interfaces;

import Main.clazz.Message;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ChatController extends Remote {

    public void updateMessages(Message msg) throws RemoteException;

    public void updateClients(List<String> clientes) throws RemoteException;
}
