package com.org.principal.optionsmenu;

public class ShowMainMenu {

    public static void menuPrincipal() {
        System.out.println("MENÚ PRINCIPAL");
        System.out.println("1- Gestión Clientes");
        System.out.println("2- Gestión Proveedores");
        System.out.println("3- Gestión Productos");
        System.out.println("4- Gestión Facturación");
        System.out.println("0 -Salir");
    }

    public static void Submenu(String menu){
        System.out.println("MENÚ GESTIÓN : %s \n " + menu );
        System.out.println("1- Crear");
        System.out.println("2- Buscar");
        System.out.println("3- Actualizar");
        System.out.println("4- Eliminar");
        System.out.println("0 -Salir");
    }
    public static void SubmenuInvoice(){
        System.out.println("MENÚ GESTIÓN  FACTURACIÓN: %s \n");
        System.out.println("1- Crear");
        System.out.println("2- Buscar");
        System.out.println("0 -Salir");
    }
}
