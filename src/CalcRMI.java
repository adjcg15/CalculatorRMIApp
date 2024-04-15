import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalcRMI extends UnicastRemoteObject implements Calculadora {
    protected CalcRMI() throws RemoteException {
        super();
    }

    @Override
    public int div(int a, int b) throws RemoteException {
        return a / b;
    }

    @Override
    public int mul(int a, int b) throws RemoteException {
        return a * b;
    }

    @Override
    public int res(int a, int b) throws RemoteException {
        return a - b;
    }

    @Override
    public int sum(int a, int b) throws RemoteException {
        return a + b;
    }
    
}