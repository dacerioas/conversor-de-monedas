import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        System.out.println("Bienvenido al conversor de monedas ");
        Menu menu = new Menu();
        GeneradorDeArchivo generador = new GeneradorDeArchivo();

        try (Scanner lectura = new Scanner(System.in)) {
            boolean continuar = true;

            while (continuar) {
                System.out.println("Seleccione la moneda de origen:");
                String codigoOrigen = menu.menuPrincipal(lectura);

                if (codigoOrigen == null) {
                    System.out.println("Error con la moneda solicitada ");
                    continue;
                }
                System.out.println("Elegiste: " + codigoOrigen);

                MonedaApi conversion = new MonedaApi();
                MonedaResponse datos;

                try {
                    datos = conversion.obtenerDatos(codigoOrigen);
                    if (datos == null){
                        System.out.println("No se obtuvieron datos de la API. ");
                        continue;
                    }
                } catch (RuntimeException e) {
                    System.out.println("Error al conectar con la API: " + e.getMessage());
                    continue;
                }

                System.out.println("Digite el monto que desea convertir");
                String lineaMonto = lectura.nextLine();
                double montoConversion;

                try {
                    montoConversion = Double.parseDouble(lineaMonto.trim());
                    if (montoConversion <= 0) {
                        System.out.println("Error: Digite un número mayor que 0.");
                        continue;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error: Debes ingresar un número válido.");
                    continue;
                }
                System.out.println("Seleccione la moneda de destino");
                String codigoDestino = menu.menuPrincipal(lectura);
                if (codigoDestino == null) {
                    System.out.println("No se seleccionó moneda destino. Saliendo.");
                    break;
                }
                Conversor conversor = new Conversor();
                double resultado = conversor.convertir(montoConversion, codigoDestino, datos);

                RegistroConversion registro = new RegistroConversion(
                        codigoOrigen,
                        codigoDestino,
                        montoConversion,
                        codigoOrigen + " -> " + codigoDestino,
                        resultado
                );

                generador.guardarJson(registro);

                System.out.println("\nResultado:");
                System.out.println(montoConversion + " " + codigoOrigen + " equivalen a " + resultado + " " + codigoDestino);


                System.out.println("--------------------------\n");

                boolean menuActivo = true;
                while (menuActivo) {
                    int opcionFinal = menu.menuFinal(lectura);
                    if (opcionFinal == 1) {
                        double tasa = new ConsultarTasa().consultarTasa(codigoDestino, datos);
                        System.out.println("La tasa actual de " + codigoDestino + " es: " + tasa);
                    } else if (opcionFinal == 2) {
                        System.out.println("Nueva Conversión");
                        System.out.println("--------------------------\n");
                        menuActivo = false;
                    } else if (opcionFinal == 3) {
                        System.out.println("Finaliza el programa");
                        menuActivo = false;
                        continuar = false;

                    } else {
                        System.out.println("Seleccione una opción válida");
                    }
                }
            }
        }
    }

    }

