import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;


public class Lanzador {
    public int ejecutarFactor(String numero) {
        try {
            ProcessBuilder pb = new ProcessBuilder("factor", numero); //Aquí el ProcessBuilder crea y lanza programas o comandos externos desde el propio código Java
            pb.inheritIO(); // Aqui imprime lo que hay en consola
            Process p = pb.start(); // Java incia, es decir, el sistema operativo ejecuta el comando factor y Java se queda esperando a la respuesta
            return p.waitFor(); // Aquí Java espera a que Linux la consola o el programa termine de ejecutar la acción. Si no Java se terminaría de ejecutar sin que termine la acción Linux
        } catch (Exception e) {
            return 1;
        }
    }
        public int ejecutarNivel2(String numero){

            try {
                ProcessBuilder pb = new ProcessBuilder("factor", numero);
                Process p = pb.start();
                BufferedReader salidaOk = new BufferedReader(new InputStreamReader(p.getInputStream()));
                String linea;

                while ((linea = salidaOk.readLine()) != null) {
                    System.out.println("[OK] " + linea);
                }

                BufferedReader salidaError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
                while ((linea = salidaError.readLine()) != null) {
                    System.out.println("[ERROR] " + linea);
                }
                return p.waitFor();
            } catch (Exception e) {
                return 1;
            }
        }

        public int ejecutarNivel3(String numero){
        try{
            ProcessBuilder pb = new ProcessBuilder("factor", numero);

            File ficheroSalida = new File ("factor_output.log");
            File ficheroError = new File ("factor_error.log");

            pb.redirectOutput(ProcessBuilder.Redirect.appendTo(ficheroSalida));
            pb.redirectError(ProcessBuilder.Redirect.appendTo(ficheroError));

            Process p = pb.start();
            return p.waitFor();

        } catch (Exception e) {
                return 1;
        }
        }
    }


