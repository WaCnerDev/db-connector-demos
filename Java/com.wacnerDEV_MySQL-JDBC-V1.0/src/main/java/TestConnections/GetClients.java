package TestConnections;

import Services.ClientServices;
import java.util.ArrayList;
import model.Client;

/**
 *
 * @author warne
 */
public class GetClients {
    public static void main(String[] args) {
        ClientServices cs = new  ClientServices();
        ArrayList<Client> clientes=(ArrayList<Client>) cs.getClientsInf();
        for (Client cliente : clientes) {
            System.out.println(cliente.toString());
        }
    }
}
