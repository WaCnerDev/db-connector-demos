package TestApp;

import Services.ClientesServices;
import java.util.ArrayList;
import model.Cliente;

/**
 *
 * @author warne
 */
public class PruebaVariablesEntornoDB {
    public static void main(String[] args) {
        ClientesServices cs = new  ClientesServices();
        ArrayList<Cliente> clientes=(ArrayList<Cliente>) cs.obtenerClientes();
        for (Cliente cliente : clientes) {
            System.out.println(cliente.toString());
        }
    }
}
