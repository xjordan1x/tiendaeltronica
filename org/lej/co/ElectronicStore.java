package org.lej.co;

import org.lej.co.electronicstore.TiendaElectronica;
import org.lej.co.models.Role;
import org.lej.co.models.Usuario;
import static org.lej.co.models.Role.ADMINISTRADOR;
import static org.lej.co.tiendamenus.MenuTienda.menuTienda;

import java.util.Scanner;

public class ElectronicStore
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TiendaElectronica tienda = new TiendaElectronica();
        Usuario usuarioAdmin = new Usuario("laura", "password", ADMINISTRADOR);
        tienda.crearUsuario(usuarioAdmin);
        int opcion;
        do {
            System.out.println("1. Iniciar Sesion");
            System.out.println("2. Salir...");
            opcion = sc.nextInt();

            switch (opcion){
                case 1:
                    sc.nextLine();
                    System.out.println("Bienvenido al sistema de ventas");
                    System.out.print("Digita tu nombre de usuario: ");
                    String nombreUsuario = sc.nextLine();
                    nombreUsuario.toLowerCase();
                    System.out.print("Digita tu contraseña: ");
                    String contraseñaUsuario = sc.nextLine();
                    contraseñaUsuario.toLowerCase();
                    Usuario usuario = tienda.login(nombreUsuario, contraseñaUsuario);
                    System.out.println(usuario);
                    if(usuario == null){
                        System.out.println("Usuario o contraseña incorrectos o no existe");
                    } else {
                        Role userRol = usuario.getRol();
                        menuTienda(userRol, tienda);
                    }
                    break;
            }
        }while(opcion != 2);
    }
}
