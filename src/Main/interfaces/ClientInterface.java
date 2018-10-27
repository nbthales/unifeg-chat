package Main.interfaces;

import Main.clazz.Message;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ClientInterface extends Remote {

    public String getNome() throws RemoteException;

    public void setNome(String nome) throws RemoteException;

    public void setChatGUI(ChatController chat) throws RemoteException;

    public List<Message> getMessages() throws RemoteException;

    public void update(ChatInterface chat) throws RemoteException;
    //public void setClientesLogados(List<String> nomes) throws RemoteException;
    //public void receberMensagem(String msg) throws RemoteException;
    //public void setChat(Observable chat) throws RemoteException;
}
