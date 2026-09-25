import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;


public class Lanzador {
    public int ejecutarFactor(String numero){
        try{
            ProcessBuilder pb = new ProcessBuilder("factor", numero); //Aquí el ProcessBuilder crea y lanza programas o comandos externos desde el propio código Java
            pb.inheritIO(); // Esto es la salida que se imprime en la terminal, es decir, lo que estaría en consola en linux solo que en la terminal de Java
            Process p = pb.start(); // Java incia, es decir, el sistema operativo ejecuta el comando factor y Java se queda esperando a la respuesta
            return p.waitFor(); //Espera a que el comando termine de ejecutarse en Linux, a su vez sale el código, si es 0 salió todo bien, si es 1 es porque ha ocurrido un error
        } catch (Exception e){
            return 1;
        }
    }
}
