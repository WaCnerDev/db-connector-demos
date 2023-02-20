/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Client;
import util.Conexion;

/**
 *
 * @author Warner Moscoso M.
 */
public class ClientServices {

    private final List<Client> clientsRegister = new ArrayList();
    private final Conexion clientConexion = Conexion.getInstConexion();

    public List<Client> getClientsInf() {
        try (Connection clientConnection = clientConexion.getConnection(); CallableStatement statement = clientConnection.prepareCall("CALL listarClientes()"); ResultSet rs = statement.executeQuery()) {
            while (rs.next()) {
                int clientId = rs.getInt("idclientes");
                String clientName = rs.getString("nombre");
                String clientLastName = rs.getString("apellidos");
                Double clientTotalSales = rs.getDouble("saldo");
                clientsRegister.add(new Client(clientId, clientName, clientLastName, clientTotalSales));
            }
            return this.clientsRegister;
        } catch (SQLException ex) {
            System.err.println("Ocurrió un error: " + ex.getMessage());
            ex.printStackTrace(System.out);
        }
        return null;
    }

    public Client getClientInf(int clientId) {
        try {
            Connection clientConnection = clientConexion.getConnection();
            CallableStatement statement = clientConnection.prepareCall("CALL infoCliente(?)");
            statement.setInt(1, clientId);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                String clientName = rs.getString("nombre");
                String clientLastName = rs.getString("apellidos");
                String clientEmail = rs.getString("email");
                String clientPhone = rs.getString("telefono");
                Double clientTotalSales = rs.getDouble("saldo");
                return new Client(clientId, clientName, clientLastName, clientEmail, clientPhone, clientTotalSales);
            }
        } catch (SQLException ex) {
            System.err.println("Ocurrió un error: " + ex.getMessage());
            ex.printStackTrace(System.out);
        }
        return null;
    }

    public int addClient(String clientName, String clientLname, String clientEmail, String clientPhone, double clientTotalSales) {

        return 0;
    }

    public int updateClient(int clientId, String clientName, String clientLname, String clientEmail, String clientPhone, double clientTotalSales) {

        return 0;
    }

    public int removeClient(int clientId) {

        return 0;
    }
}
