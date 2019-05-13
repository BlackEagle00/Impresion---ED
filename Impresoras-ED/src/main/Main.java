//Trabajo Realizado por: Andr�s Guillermo Bonilla Olarte
package main;
import java.io.*;
import java.util.LinkedList;
import impresoras.Impresora1;
import impresoras.Impresora2;

public class Main 
{  
    private static Thread  hilo1  = new  Impresora1(); //Creaci�n cola de impresi�n 1
    private static Thread  hilo2  = new  Impresora2(); //Creaci�n cola de impresi�n 2
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
        	String renglon; //Ac� se guardar� cada rengl�n del archivo de texto
        	String [] temporal_archivo; //Archivo de texto completo
        	
	        archivo = new File ("C:\\Users\\RGH-LS13-08\\Downloads\\Impresoras-ED\\ArchivoImpresion.txt"); //Ubicaci�n del archivo
	        fr = new FileReader (archivo); //Guardar el archivo en fr
	        br = new BufferedReader(fr); //Leer fr
	        
        	while((renglon = br.readLine()) != null) //Mientras el renglon del archivo, tenga algo
        	{
        		temporal_archivo = renglon.split(" "); //Rengl�n, separarlo por espacio
        		
				if(temporal_archivo [0].equalsIgnoreCase("ADMON") || temporal_archivo [0].equalsIgnoreCase("GERENCIA")) 
				{
					cola1.add(renglon);//A�adimos el rengl�n, a la cola de la impresora
				}else 
				{
					if(temporal_archivo [0].equalsIgnoreCase("MERCADEO") || temporal_archivo [0].equalsIgnoreCase("PRODUC"))
					{
						cola2.add(renglon);//A�adimos el rengl�n, a la cola de la impresora
					}
				}
			}

			
			System.out.println("Bienvenido al Administrador de Impresiones MinuTech");
			System.out.println("Departamentos:\n"
							 + "1. Administraci�n\n"
							 + "2. Gerencia\n"
							 + "3. Mercadeo\n"
							 + "4. Producci�n");
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