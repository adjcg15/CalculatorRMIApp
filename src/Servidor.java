import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Servidor {
    public static void main(String[] args) {
        try {
            int puerto = 8080;
            String hostServidor = "192.168.56.103";

            System.out.println("Iniciando servidor en: ");
            System.out.println("Hostname: " + hostServidor);
            System.out.println("Puerto: " + puerto);

            Registry registro = LocateRegistry.createRegistry(puerto);
            System.setProperty("java.rmi.server.hostname", hostServidor);
            registro.rebind("Calculadora", new CalcRMI());

            System.out.println("Servidor en ejecución en espera de clientes");
        } catch (RemoteException ex) {
            System.out.println(ex);
        }
    }
}
