package com.org.principal.optionsmenu;

import java.util.Scanner;

public class ValidarNumeros {

    private static Scanner teclado;

    public ValidarNumeros() {
        teclado = new Scanner(System.in);
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


}
