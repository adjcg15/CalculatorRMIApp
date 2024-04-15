import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JOptionPane;

public class Cliente {
    public static void main(String[] args) {
        int puerto = 8080;
        String hostServidor = "192.168.56.103";
        String rmiURL = "rmi://" + hostServidor + ":" + puerto + "/Calculadora";
        
        try {
            Calculadora servicioCalculadora = (Calculadora) Naming.lookup(rmiURL);
            
            while (true) {
                String opt = JOptionPane.showInputDialog(
                    "Cacular\n " +
                    "Suma................(1)\n" +
                    "Resta...............(2)\n" +
                    "Multiplicacion......(3)\n" +
                    "Division............(4)\n\n" +
                    "Cancelar para salir"
                );

                if(opt == null) {
                    break;
                }

                int a = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el primer numero"));
                int b = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el segundo numero"));

                switch (opt) {
                    case "1":
                        JOptionPane.showMessageDialog(
                            null, a + " + " + b + " = " + servicioCalculadora.sum(a, b));
                        break;
                    case "2":
                        JOptionPane.showMessageDialog(
                        null, a + " - " + b + " = " + servicioCalculadora.res(a, b));
                        break;
                    case "3":
                        JOptionPane.showMessageDialog(
                            null, a + " * " + b + " = " + servicioCalculadora.mul(a, b));
                        break;
                    case "4":
                        JOptionPane.showMessageDialog(
                            null, a + " / " + b + " = " + servicioCalculadora.div(a, b));
                        break;
                }
            }
        } catch (RemoteException | NotBoundException ex) {
            JOptionPane.showMessageDialog(
                null, "No se pudo conectar al servidor:\n" + ex);
        } catch (MalformedURLException ex) {
            JOptionPane.showMessageDialog(
                null, "La URL está en formato incorrecto:\n" + ex);
        }
    }
}
