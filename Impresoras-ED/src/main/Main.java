//Trabajo Realizado por: Andrés Guillermo Bonilla Olarte
package main;
import java.io.*;
import java.util.LinkedList;
import impresoras.Impresora1;
import impresoras.Impresora2;

public class Main 
{  
    private static Thread  hilo1  = new  Impresora1(); //Creación cola de impresión 1
    private static Thread  hilo2  = new  Impresora2(); //Creación cola de impresión 2
	//private static Impresora1 imprimir1 = new Impresora1();
	//private static Impresora2 imprimir2 = new Impresora2();
    private static LinkedList<String> cola1 = new LinkedList<String>();
    private static LinkedList<String> cola2 = new LinkedList<String>();
    private static File archivo = null;
    private static FileReader fr = null;
    private static BufferedReader br = null;
    
    public static void main(String[] args) 
    {
        try
        {
        	String renglon; //Acá se guardará cada renglón del archivo de texto
        	String [] temporal_archivo; //Archivo de texto completo
        	
	        archivo = new File ("C:\\Users\\RGH-LS13-08\\Downloads\\Impresoras-ED\\ArchivoImpresion.txt"); //Ubicación del archivo
	        fr = new FileReader (archivo); //Guardar el archivo en fr
	        br = new BufferedReader(fr); //Leer fr
	        
        	while((renglon = br.readLine()) != null) //Mientras el renglon del archivo, tenga algo
        	{
        		temporal_archivo = renglon.split(" "); //Renglón, separarlo por espacio
        		
				if(temporal_archivo [0].equalsIgnoreCase("ADMON") || temporal_archivo [0].equalsIgnoreCase("GERENCIA")) 
				{
					cola1.add(renglon);//Añadimos el renglón, a la cola de la impresora
				}else 
				{
					if(temporal_archivo [0].equalsIgnoreCase("MERCADEO") || temporal_archivo [0].equalsIgnoreCase("PRODUC"))
					{
						cola2.add(renglon);//Añadimos el renglón, a la cola de la impresora
					}
				}
			}

			
			System.out.println("Bienvenido al Administrador de Impresiones MinuTech");
			System.out.println("Departamentos:\n"
							 + "1. Administración\n"
							 + "2. Gerencia\n"
							 + "3. Mercadeo\n"
							 + "4. Producción");
			System.out.println("\nCola de Impresora 1: " + cola1 +"\n"
							   + "Cola de Impresora 2: " + cola2 + "\n");
			
        	
        	Impresora1.setQueue(cola1); //Set de la cola de la impresora 1
			Impresora2.setQueue(cola2); //Set de la cola de la impresora 2
			
			hilo1.start(); //Inicio al hilo 1
			hilo2.start(); //Inicio al hilo 2
			
				
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }       
    }
}