/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author Warner Moscoso M.
 */
public class Conexion implements DataSource {

    private static Conexion instConexion;
    private final BasicDataSource DS;
    private static final String URL = System.getenv("JDBC_URL");
    private static final String USER_NAME = System.getenv("JDBC_USER");
    private static final String PASSWORD = System.getenv("JDBC_PASSWORD");

    private Conexion() {
        DS = new BasicDataSource();
        DS.setUrl(Conexion.URL);
        DS.setUsername(Conexion.USER_NAME);
        DS.setPassword(Conexion.PASSWORD);
        /*Cantidad de conexiones inicializadas*/
        DS.setInitialSize(5);
        /*Cantidad de conexiones maximas, si es necesario crear mas conexiones
        la libreria se encargara de agregar más, mientras no supere este limt.*/
        DS.setMaxTotal(10);
        /*El maximo de conexiones inactivas en el pool, es decir; si existe
        una conexion inactiva de más esta se cerrará automaticamente*/
        DS.setMaxIdle(5);
    }

    /**
     * Verifica que solo exista una instancia Conexion esta parte es la
     * reponsable de aplicar el patron singlenton
     *
     * @return la unica instancia de Conexion
     */
    public static Conexion getInstConexion() {
            if (instConexion == null) {
            System.out.println("Se creo la pila de conexiones");
            instConexion = new Conexion();
            return instConexion;
        } else {
            System.out.println("Ya habia sido creada la conexion");
            return Conexion.instConexion;
        }
    }

    @Override
    public Connection getConnection() throws SQLException {
        return DS.getConnection();
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return DS.getConnection(username, password);
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {
    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {
    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

}
