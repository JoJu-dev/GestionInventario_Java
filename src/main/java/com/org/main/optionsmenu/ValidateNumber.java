package com.org.sisinventory.service;

import java.util.Scanner;

public class ValidateNumber {

    private static Scanner teclado = new Scanner(System.in);


    public ValidateNumber() {

      //  teclado = new Scanner(System.in);
    }

    public static String capturarCadenaCaracteres(String mensaje) {
        String resultado;
        while (true) {
            System.out.println("%s" + mensaje);
            resultado = teclado.nextLine().trim();

            if (!resultado.isEmpty()) {
                return teclado.nextLine().trim();
            }

            System.out.println("Especifique una cadena");
        }
    }

    public static int capturarEntero(String mensaje) {

        while (true) {
            try {
                System.out.println("%s" + mensaje);
                return Integer.parseInt(teclado.nextLine());
            } catch (NumberFormatException n) {
                System.out.println("Especifique un valor entero");
                n.printStackTrace();
            }
        }
    }

    public static double capturaNumeroReal(String mensaje) {
        while (true) {
            try {
                System.out.println("%s" + mensaje);
                return Double.parseDouble(teclado.nextLine());
            } catch (NumberFormatException number) {
                System.out.println("Especifique un valor double");
                number.printStackTrace();
            }
        }
    }

    public static boolean correoElectronicoValido(String correo) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return correo.matches(regex);
    }

   public static void continuar() {
        System.out.println();
        System.out.print("Presione Enter para continuar...");
        teclado.nextLine();
        System.out.println();
    }



}
