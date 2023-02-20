/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Warner Moscoso M.
 */
public class Cliente {

    private int id_cliente;
    private String nombre;
    private String apellidos;
    private String email;
    private String phone;
    private double saldo;

    public Cliente() {
    }

    public Cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Cliente(int id_cliente, String nombre, String apellidos, double saldo) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.saldo = saldo;
    }
    

    public Cliente(int id_cliente, String nombre, String apellidos, 
            String email, String phone, double saldo) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.phone = phone;
        this.saldo = saldo;
    }

    public Cliente(String nombre, String apellidos, String email, String phone, double saldo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.phone = phone;
        this.saldo = saldo;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cliente{");
        sb.append("id_cliente=").append(id_cliente);
        sb.append(", nombre=").append(nombre);
        sb.append(", apellidos=").append(apellidos);
        sb.append(", email=").append(email);
        sb.append(", phone=").append(phone);
        sb.append(", saldo=").append(saldo);
        sb.append('}');
        return sb.toString();
    }
    
}