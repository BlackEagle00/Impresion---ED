package impresoras;

import java.util.LinkedList;

public class Impresora2 extends Thread
{
    private static LinkedList<String> queue = new LinkedList<String>();

    private static int tipo_documento;
	private static String departamento; 
	private static String [] temporal;
	
	public void run ()
	{
		
		for (int i = 0; i < queue.size(); i++) //Si el tamaño de la cola es mayor a 0
		{
			
			temporal = queue.get(i).split(" "); //Separar la cola por espacio
			departamento = temporal [0]; //Guardar el primer elemento [0] que sería el departamento
			tipo_documento = Integer.parseInt(temporal[1]); //Guardar el segundo elemento [1] que sería el tipo de trabajo
			
			try 
			{
				switch(tipo_documento) 
				{
				case 1://Sencillo 
					System.out.println("Tipo de Trabajo: " + tipo_documento +"\n"+
							           "Departamento de Trabajo: " + departamento +"\n"+ 
							           "Impresora: 2");
					Thread.sleep(60000);
					System.out.println("Tipo de Trabajo: " + tipo_documento +"\n"+
					          		   "Departamento de Trabajo: " + departamento +"\n"+ 
					          		   "Impresora: 2");
					break;
					
				case 2://Informe 
					System.out.println("Tipo de Trabajo: " + tipo_documento +"\n"+
					           		   "Departamento de Trabajo: " + departamento +"\n"+ 
					                   "Impresora: 2");
					Thread.sleep(180000);
					System.out.println("Tipo de Trabajo: " + tipo_documento +"\n"+
			          		           "Departamento de Trabajo: " + departamento +"\n"+ 
			          		           "Impresora: 2");
					
				case 3://Catalogo
					System.out.println("Tipo de Trabajo: " + tipo_documento +"\n"+
					                   "Departamento de Trabajo: " + departamento +"\n"+ 
					                   "Impresora: 2");
					Thread.sleep(300000);
					System.out.println("Tipo de Trabajo: " + tipo_documento +"\n"+
			          		           "Departamento de Trabajo: " + departamento +"\n"+ 
			          		           "Impresora: 2");
					
				}
			}
			catch(Exception ex) 
			{
				ex.printStackTrace();
			}
		}
	}

	public static void setQueue(LinkedList<String> queue) 
	{
		Impresora2.queue= queue;
	}
}
