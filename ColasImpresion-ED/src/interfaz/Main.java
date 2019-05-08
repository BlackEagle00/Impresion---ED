package interfaz;
import java.io.*;
import java.util.concurrent.ArrayBlockingQueue;
import mundo.Impresoras;

public class Main 
{  
    private static Thread  cola1  = new  Impresoras();
    private static Thread  cola2  = new  Impresoras();
    private static ArrayBlockingQueue <String> cola = new ArrayBlockingQueue<>(10);
    private static File archivo = null;
    private static FileReader fr = null;
    private static BufferedReader br = null;
    
    public static void main(String[] args) 
    {
        try
        {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File ("C:\\Users\\BOG-A408-E-016\\eclipse-workspace\\Colas-ED\\DocumentoImpresion.txt");
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);      
            // Lectura del fichero
            String linea;
            
            while((linea = br.readLine()) != null)
            System.out.println(linea);  
            
            for (int i = 0; (cola.size() - 1); i++) 
            {
                
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }       
    }
}
