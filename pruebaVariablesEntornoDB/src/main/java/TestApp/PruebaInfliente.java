/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package TestApp;

import Services.ClientesServices;

/**
 *
 * @author Warner Moscoso M.
 */
public class PruebaInfliente {
 
    public static void main(String[] args) {
        
        ClientesServices cs = new ClientesServices();
        var buscado=cs.infCliente(1);
        System.out.println(buscado.toString());
        
    }
}
