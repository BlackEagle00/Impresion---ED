package mundo;

public class Impresoras extends Thread 
{

    private String departamento;
    private int tipo_doc;

    public void correr() 
    {
        try {
            switch (tipo_doc) 
            {
                case 1: //Sencillo
                    if (departamento.equalsIgnoreCase("ADMON") || departamento.equalsIgnoreCase("GERENCIA")) 
                    {
                        System.out.println("Tipo del trabajo: " + tipo_doc);
                        System.out.println("Departamento del trabajo: " + departamento);
                        Thread.sleep(60000);
                        System.out.println("Trabajo del Departamento " + departamento + " de tipo " + tipo_doc + " ha sido impreso");
                    }
                    else if (departamento.equalsIgnoreCase("MERCADEO") || departamento.equalsIgnoreCase("PRODUCCION")) 
                    {
                        System.out.println("Tipo del trabajo: " + tipo_doc);
                        System.out.println("Departamento del trabajo: " + departamento);
                        Thread.sleep(60000);
                        System.out.println("Trabajo del Departamento " + departamento + " de tipo " + tipo_doc + " ha sido impreso");
                    }
                    break;
                    
                case 2: //Informe
                    if (departamento.equalsIgnoreCase("ADMON") || departamento.equalsIgnoreCase("GERENCIA")) 
                    {
                        System.out.println("Tipo del trabajo: " + tipo_doc);
                        System.out.println("Departamento del trabajo: " + departamento);
                        Thread.sleep(180000);
                        System.out.println("Trabajo del Departamento " + departamento + " de tipo " + tipo_doc + " ha sido impreso");
                    } 
                    else if (departamento.equalsIgnoreCase("MERCADEO") || departamento.equalsIgnoreCase("PRODUCCION")) 
                    {
                        System.out.println("Tipo del trabajo: " + tipo_doc);
                        System.out.println("Departamento del trabajo: " + departamento);
                        Thread.sleep(180000);
                        System.out.println("Trabajo del Departamento " + departamento + " de tipo " + tipo_doc + " ha sido impreso");
                    }
                    break;
                    
                case 3: //Catálogo
                    if (departamento.equalsIgnoreCase("ADMON") || departamento.equalsIgnoreCase("GERENCIA")) 
                    {
                        System.out.println("Tipo del trabajo: " + tipo_doc);
                        System.out.println("Departamento del trabajo: " + departamento);
                        Thread.sleep(300000);
                        System.out.println("Trabajo del Departamento " + departamento + " de tipo " + tipo_doc + " ha sido impreso");
                    } 
                    else if (departamento.equalsIgnoreCase("MERCADEO") || departamento.equalsIgnoreCase("PRODUCCION")) 
                    {
                        System.out.println("Tipo del trabajo: " + tipo_doc);
                        System.out.println("Departamento del trabajo: " + departamento);
                        Thread.sleep(300000);
                        System.out.println("Trabajo del Departamento " + departamento + " de tipo " + tipo_doc + " ha sido impreso");
                    }
                    break;
            }
        } catch (Exception e) 
        {
            e.printStackTrace();
        }

    }

    public void departamento(String valor) 
    {
        this.departamento = valor;
    }

    public void tipo_doc(int valor) 
    {
        this.tipo_doc = valor;
    }
}
