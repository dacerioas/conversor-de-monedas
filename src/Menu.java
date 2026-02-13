import java.util.Scanner;

public class Menu {


    public String menuPrincipal(Scanner lectura) {
        System.out.println("""
                --------------------------
                1 - Estados Unidos (USD)
                2 - Costa Rica (CRC)
                3 - México (MXN)
                4 - Europa (EUR)
                5 - Reino Unido (GBP)
                6 - Más monedas
                7 - Salir""");

        String linea = lectura.nextLine();
        int opcion;
        try {
            opcion = Integer.parseInt(linea.trim());
        } catch (NumberFormatException e) {
            System.out.println("Opción inválida (no es un número).");
            return null;
        }
        return switch (opcion) {
            case 1 -> "USD";
            case 2 -> "CRC";
            case 3 -> "MXN";
            case 4 -> "EUR";
            case 5 -> "GBP";
            case 6 -> menuAlternativo(lectura);
            case 7 -> {
                System.out.println("Finalizó el programa");
                yield null;
            }
            default -> {
                System.out.println("Opción inválida");
                yield null;
            }
        };
    }

    public String menuAlternativo(Scanner lectura) {
        System.out.println("""
                --------------------------
                8 - Suiza (CHF)
                9 - Japón (JPY)
                10 - Hong Kong (HKD)
                11 - Canadá (CAD)
                12 - China (CNY)
                13 - Australia (AUD)
                14 - Brasil (BRL)
                15 - Salir""");

        String linea = lectura.nextLine();
        int opcion;

        try {
            opcion = Integer.parseInt(linea.trim());
        } catch (NumberFormatException e) {
            System.out.println("Opción inválida (no es un número).");
            return null;
        }

        return switch (opcion) {
            case 8 -> "CHF";
            case 9 -> "JPY";
            case 10 -> "HKD";
            case 11 -> "CAD";
            case 12 -> "CNY";
            case 13 -> "AUD";
            case 14 -> "BRL";
            case 15 -> {
                System.out.println("Finalizó el programa");
                yield null;
            }
            default -> {
                System.out.println("Opción inválida");
                yield null;
            }
        };
    }

    public int menuFinal(Scanner lectura) {
        System.out.println(
                """
                        1 - Consultar Tasa
                        2 - Hacer otra conversión
                        3 - Salir
                        """);

        String linea = lectura.nextLine();
        try {
            return Integer.parseInt(linea.trim());
        } catch (NumberFormatException e) {
            System.out.println("Opción inválida (no es un número).");
            return -1; // valor inválido que tu código principal debe manejar

        }

    }
}






