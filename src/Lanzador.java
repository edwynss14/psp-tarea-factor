import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Lanzador {
    public int ejecutarFactor(String numero){
        try{
            ProcessBuilder pb = new ProcessBuilder("factor", numero); //Aquí el ProcessBuilder crea y lanza programas o comandos externos desde el propio código Java
            Process p = pb.start(); // Java incia, es decir, el sistema operativo ejecuta el comando factor y Java se queda esperando a la respuesta
            BufferedReader salidaOk = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String linea;
            while((linea = salidaOk.readLine()) != null){
                System.out.println("[OK] " + linea);
            }

            BufferedReader salidaError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            while((linea = salidaError.readLine()) != null){
                System.out.println("[ERROR] " + linea);
            }
            return p.waitFor(); //Espera a que el comando termine de ejecutarse en Linux, a su vez sale el código, si es 0 salió todo bien, si es 1 es porque ha ocurrido un error
        } catch (Exception e){
            return 1;
        }
    }
}
