import java.util.Scanner;


public class Interfaz {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        Lanzador lanzador = new Lanzador();
        System.out.println("Qué nivel quieres usar: 1, 2, 3, 4");
        System.out.println("> ");
        String nivel = scanner.nextLine();



        while(true){
            System.out.println("Introduce un numero (o 'salir' para terminar)");
            System.out.println("> ");
            String entrada = scanner.nextLine();

            if(entrada.equalsIgnoreCase("salir")){
                System.out.println("saliendo del programa");
                break;
            }

            int codigo = 0;
            if(nivel.equals("2")){
                codigo = lanzador.ejecutarNivel2(entrada);
            } else if (nivel.equals("3")){
                codigo = lanzador.ejecutarNivel3(entrada);
            } else{
                codigo = lanzador.ejecutarFactor(entrada);
            }
            System.out.println("Operación completada código de salida: " + codigo);
        }
        scanner.close();

    }


}
