package main;
import java.io.*;
import java.util.LinkedList;
import impresoras.Impresora1;
import impresoras.Impresora2;
/**
 * ED - Trabajo Impresoras
 * @author Andrés Guillermo Bonilla Olarte
 * 13 - 05 - 2019
 */
public class Main 
{  
    private static Thread  hilo1  = new  Impresora1(); //Creación cola de impresión 1
    private static Thread  hilo2  = new  Impresora2(); //Creación cola de impresión 2
    private static LinkedList<String> cola1 = new LinkedList<String>();
    private static LinkedList<String> cola2 = new LinkedList<String>();
    private static File archivo = null;
    private static FileReader fr = null;
    private static BufferedReader br = null;
    private static int tiempo_colaImp1 = 0;
    private static int tiempo_colaImp2 = 0;
    
    public static void main(String[] args) 
    {
        try
        {
        	String renglon; //Acá se guardará cada renglón del archivo de texto
        	String [] temporal_archivo; //Archivo de texto completo
        	
	        archivo = new File ("D:\\Eclipse\\eclipse\\Impresoras-ED\\ArchivoImpresion.txt"); //Ubicación del archivo
	        fr = new FileReader (archivo); //Guardar el archivo en fr
	        br = new BufferedReader(fr); //Leer fr
	        
        	while((renglon = br.readLine()) != null) //Mientras el renglon del archivo, tenga algo
        	{
        		temporal_archivo = renglon.split(" "); //Renglón, separarlo por espacio
        		
				if(temporal_archivo [0].equalsIgnoreCase("ADMON") || temporal_archivo [0].equalsIgnoreCase("GERENCIA")) 
				{
					switch(Integer.parseInt(temporal_archivo[1]))
					{
						case 1:
							tiempo_colaImp1++; //Tiempo acumulado de cola: 1 minuto 
							break;
							
						case 2:
							tiempo_colaImp1+=3; //Tiempo acumulado de cola: 3 minutos
							break;
							
						case 3:
							tiempo_colaImp1+=5; //Tiempo acumulado de cola: 5 minutos
							break;
					}
					cola1.add(renglon);
				}
       
				else 
				{
					if(temporal_archivo [0].equalsIgnoreCase("MERCADEO") || temporal_archivo [0].equalsIgnoreCase("PRODUC"))
					{
						switch(Integer.parseInt(temporal_archivo[1]))
						{
							case 1:
								tiempo_colaImp2++; //Tiempo acumulado de cola: 1 minuto 
								break;
								
							case 2:
								tiempo_colaImp2+=3; //Tiempo acumulado de cola: 3 minutos
								break;
								
							case 3:
								tiempo_colaImp2+=5; //Tiempo acumulado de cola: 5 minutos
								break;
						}
						if(cola2.size() > 2) //Límite de archivos de la cola 2 = 2 Archivos
						{
							System.out.println("Cola de impresión 2, llena. Por favor, espere a que termine de imprimirse un archivo");
						}
						else
						{
							cola2.add(renglon);//Añadimos el renglón, a la cola de la impresora
						}
						
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
			
        	
        	Impresora1.setQueue(cola1);
			Impresora2.setQueue(cola2);
			
			hilo1.start();
			hilo2.start();
			
				
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }       
    }
}
