import java.io.IOException;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Conexion conversion = new Conexion();
        Scanner teclado = new Scanner(System.in);
        int opcion = 0;

        System.out.println("\nBienvenido al conversor de monedas\n");
        System.out.println("\nIndique que conversion desea realizar\n");

        String menu = """
                1) Dolar --> Colon Costarricense
                2) Colon Costarricense --> Dolar
                3) Dolar --> Peso Argentino
                4) Peso Argentino --> Dolar
                5) Dólar --> Peso Mexicano
                6) Peso Mexicano --> Dólar 
                7) Salir 
                """;

        while ( opcion != 7 ) {
            System.out.println(menu);
            System.out.println("Elija una opción:");
            opcion = teclado.nextInt();

            if (opcion == 7){
                System.out.println("Ha salido con exito del programa Conversor de Monedas");
                break;
            }

            System.out.println("Ingresar monto a convertir: ");
            double monto = teclado.nextDouble();

            try{
                switch (opcion){
                    case 1:
                        conversion.convertirValor("USD", "CRC", monto);
                        break;
                    case 2:
                        conversion.convertirValor("CRC", "USD", monto);
                        break;
                    case 3:
                        conversion.convertirValor("USD", "ARS", monto);
                        break;
                    case 4:
                        conversion.convertirValor("ARS", "USD", monto);
                        break;
                    case 5:
                        conversion.convertirValor("USD", "MXN", monto);
                        break;
                    case 6:
                        conversion.convertirValor("MXN", "USD", monto);
                        break;
                    default:
                        System.out.println("Opcion no valida");
                }
            }
            catch (IOException | InterruptedException e){
                System.out.println("Error al realizar la conversion: " + e.getMessage());
            }
        }
        teclado.close();
    }
}