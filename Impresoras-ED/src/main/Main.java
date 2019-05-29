package main;
import java.io.*;
import java.util.LinkedList;
import java.util.Stack;

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
    private static Stack <String> cola1 = new Stack <>();
    private static Stack <String> cola2 = new Stack <>();
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
        		
				if(temporal_archivo [0].equalsIgnoreCase("ADMON") || temporal_archivo [0].equalsIgnoreCase("GERENCIA")) // Departamentos Impresora 1
				{
					if (temporal_archivo [0].equalsIgnoreCase("GERENCIA")) //Condicional de la prioridad de Gerencia
					{
						if (tiempo_colaImp1 > 5) //Verificación de tiempo Impresora 1
						{
							if (tiempo_colaImp1 <= tiempo_colaImp2) //Comparación de tiempos de las 2 colas 
							{
								switch(Integer.parseInt(temporal_archivo[1]))
								{
									case 1:
										tiempo_colaImp1+=1; //Tiempo acumulado de cola: 1 minuto 
										break;
										
									case 2:
										tiempo_colaImp1+=3; //Tiempo acumulado de cola: 3 minutos
										break;
										
									case 3:
										tiempo_colaImp1+=5; //Tiempo acumulado de cola: 5 minutos
										break;
								}
							}
							else 
							{
								cola2.push(renglon);
								switch(Integer.parseInt(temporal_archivo[1]))
								{
									case 1:
										tiempo_colaImp1+=1; //Tiempo acumulado de cola: 1 minuto 
										break;
										
									case 2:
										tiempo_colaImp1+=3; //Tiempo acumulado de cola: 3 minutos
										break;
										
									case 3:
										tiempo_colaImp1+=5; //Tiempo acumulado de cola: 5 minutos
										break;
								}
							}
						} 
					
						else //Tiempo de la cola < 5 minutos
						{
							cola1.push(renglon);
							switch(Integer.parseInt(temporal_archivo[1]))
							{
								case 1:
									tiempo_colaImp1+=1; //Tiempo acumulado de cola: 1 minuto 
									break;
									
								case 2:
									tiempo_colaImp1+=3; //Tiempo acumulado de cola: 3 minutos
									break;
									
								case 3:
									tiempo_colaImp1+=5; //Tiempo acumulado de cola: 5 minutos
									break;
							}
						}	
					}
					else //Documento de Administración
					{
						cola1.push(renglon);
						switch(Integer.parseInt(temporal_archivo[1]))
						{
							case 1:
								tiempo_colaImp1+=1; //Tiempo acumulado de cola: 1 minuto 
								break;
								
							case 2:
								tiempo_colaImp1+=3; //Tiempo acumulado de cola: 3 minutos
								break;
								
							case 3:
								tiempo_colaImp1+=5; //Tiempo acumulado de cola: 5 minutos
								break;
						}
					}
				}
				else 
				{
					if(temporal_archivo [0].equalsIgnoreCase("MERCADEO") || temporal_archivo [0].equalsIgnoreCase("PRODUC")) // Departamentos Impresora 2
					{
						cola2.push(renglon);
						switch(Integer.parseInt(temporal_archivo[1]))
						{
							case 1:
								tiempo_colaImp2+=1; //Tiempo acumulado de cola: 1 minuto 
								break;
								
							case 2:
								tiempo_colaImp2+=3; //Tiempo acumulado de cola: 3 minutos
								break;
								
							case 3:
								tiempo_colaImp2+=5; //Tiempo acumulado de cola: 5 minutos
								break;
						}						
					}
				}
			}

        	System.out.println("Código realizado por: Andrés Guillermo Bonilla Olarte");
			System.out.println("Bienvenido al Administrador de Impresiones MinuTech");
			System.out.println("Departamentos:\n"
							 + "1. Administración\n"
							 + "2. Gerencia\n"
							 + "3. Mercadeo\n"
							 + "4. Producción");
			System.out.println("\nCola de Impresora 1: " + cola1 +"\n"
							   + "Cola de Impresora 2: " + cola2 + "\n");
			
        	Thread.sleep(5000);
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
