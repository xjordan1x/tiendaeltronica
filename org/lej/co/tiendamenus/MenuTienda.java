package org.lej.co.tiendamenus;

import org.lej.co.electronicstore.TiendaElectronica;
import static org.lej.co.tiendamenus.MenuAdmin.menuAdministrator;
import static org.lej.co.tiendamenus.MenuVendedor.menuVendedor;
import static org.lej.co.tiendamenus.MenuGerente.menuGerente;
import org.lej.co.models.Role;

public class MenuTienda {

    public static void menuTienda(Role usuarioRol, TiendaElectronica tienda){
        System.out.println("Iniciando sesion como " + usuarioRol);
        switch (usuarioRol){
            case ADMINISTRADOR:
                menuAdministrator(tienda);
                break;
            case VENDEDOR:
                menuVendedor(tienda);
                break;
            case GERENTE:
                menuGerente(tienda);
                break;
        }

    }
}
