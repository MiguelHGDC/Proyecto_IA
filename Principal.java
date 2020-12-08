import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;
//Aprender a la lectura de un fichero. empezando desde 0
public class Principal {
	//Buenas
	
	static ArrayList<Lugares> lugarList = new ArrayList<Lugares>();
	
    public static void main(String args[]){ //Funcion para la lectura del fichero donde se interpretan las acciones
    	
    	
        String linetxt = "";
        String nuevalinea = "";
        String[] partes;



        try {
            FileInputStream fichero = new FileInputStream("C:\\Users\\mhere\\OneDrive\\Escritorio\\U-TAD\\Curso2\\Programacion orientada a objetos\\08-POO\\Trabajos\\ProyectoJava\\src\\Prueba_lectura.txt");
            Scanner src = new Scanner(fichero);

            while(src.hasNextLine()){
                linetxt = src.nextLine();
                System.out.println(linetxt);
                //System.out.println(linetxt.compareTo("</Localizaciones>"));

                if(linetxt.contains("<Localizaciones>")){ //Parte del texto donde se encuentran las localizaciones.
                    while(true){ //Captura de todas las localizaciones que hay
                        linetxt = src.nextLine();
                        if(linetxt.contains("</Localizaciones>")){
                            break;
                        }else{
                            nuevalinea = linetxt.replace("(", "-").replace(")", "").replace(",","-").trim();
                            //System.out.println(nuevalinea);
                            
                            partes = nuevalinea.split("-");
                            
                          //Hacer un for tipo aux donde sobrescribimos la posicion 1 a la 0 y asi sucesivamente
                            Lugares lugar = new Lugares(partes[0],partes);
                            lugarList.add(lugar);
                         


                        }
                    }
                } 
                for(Lugares nini:lugarList) {
        			System.out.print(nini.toString()+"\n\n");
        			System.out.println("");
        		}
                
               /* for(String elemento:localizaciones){
                    System.out.println("Localizacion es: "+elemento); 
                }*/

                if(linetxt.contains("</Localizaciones>")){
                    System.out.println(linetxt);
                }
                
                //System.out.println("Localizacion actual: " +localizacion );
            }

            src.close(); //Cerramos el scanner al fichero.
            fichero.close(); //Cerramos el fichero.
        } catch (Exception e) { //Levanto una excepcion si no se ha podido leer el fichero
            e.printStackTrace();
        }

    }
    
}
