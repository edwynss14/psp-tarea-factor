import java.util.Scanner;


public class Interfaz {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        Lanzador lanzador = new Lanzador();

        while(true){
            System.out.println("Introduce un numero (o 'salir' para terminar)");
            System.out.println("> ");
            String entrada = scanner.nextLine();

            if(entrada.equalsIgnoreCase("salir")){
                System.out.println("saliendo del programa");
                break;
            }

            int codigo = lanzador.ejecutarFactor(entrada);

            System.out.println("Operación completada código de salida: " + codigo);
        }
        scanner.close();

    }


}
