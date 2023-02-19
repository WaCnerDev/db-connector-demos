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
import model.Cliente;
import util.Conexion;

/**
 *
 * @author Warner Moscoso M.
 */
public class ClientesServices {

    private List<Cliente> registroclientes = new ArrayList();
    private final Conexion clienteConexion = Conexion.getInstConexion();

    public List<Cliente> obtenerClientes() {
        try (Connection clienteConnection = clienteConexion.getConnection(); CallableStatement statement = clienteConnection.prepareCall("CALL listarClientes()"); ResultSet rs = statement.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("idclientes");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                Double saldo = rs.getDouble("saldo");
                registroclientes.add(new Cliente(id, nombre, apellidos, saldo));
            }
            return this.registroclientes;
        } catch (SQLException ex) {
            System.err.println("Ocurrió un error: " + ex.getMessage());
            ex.printStackTrace(System.out);
        }
        return null;
    }

    public Cliente infCliente(int idclientes) {
        try {
            Connection clienteConnection = clienteConexion.getConnection();
            CallableStatement statement = clienteConnection.prepareCall("CALL infoCliente(?)");
            statement.setInt(1, idclientes);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("idclientes");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                String email = rs.getString("email");
                String phone = rs.getString("telefono");
                Double saldo = rs.getDouble("saldo");
                return new Cliente(id, nombre, apellidos, email, phone, saldo);
            }
        } catch (SQLException ex) {
            System.err.println("Ocurrió un error: " + ex.getMessage());
            ex.printStackTrace(System.out);
        }
        return null;
    }

}
