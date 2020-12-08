import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;
//Aprender a la lectura de un fichero. empezando desde 0
public class Principal {
	
	static ArrayList<Lugar> lugares = new ArrayList<Lugar>();
	
    public static void main(String args[]){ //Funcion para la lectura del fichero donde se interpretan las acciones
    	
    	
        String linetxt = "";
        String nuevalinea = "";
        String nuevalinea2 = "";
        String[] partes;
        String[] aux;

        try {
            FileInputStream fichero = new FileInputStream("C:\\Users\\mhere\\OneDrive\\Escritorio\\U-TAD\\Curso2\\Programacion orientada a objetos\\08-POO\\Trabajos\\ProyectoJava\\src\\Prueba_lectura.txt");
            Scanner src = new Scanner(fichero);

            while(src.hasNextLine()){
                linetxt = src.nextLine();
                System.out.println(linetxt);

                if(linetxt.contains("<Localizaciones>")){ //Parte del texto donde se encuentran las localizaciones.
                    while(true){ //Captura de todas las localizaciones que hay
                        linetxt = src.nextLine();
                        if(linetxt.contains("</Localizaciones>")){
                            break;
                        }else{
                            nuevalinea = linetxt.replace("(", "-").replace(")", "").replace(",","-").trim();
                            
                            partes = nuevalinea.split("-");
                            
                            nuevalinea2 = linetxt.replace(partes[0],"").replace("(", "").replace(")", "").replace(",","-").trim();
                            
                            System.out.println("\n\n NUEVA LINEA 2 :"+nuevalinea2);
                            aux = nuevalinea2.split("-");

                            Lugar lugar = new Lugar(partes[0],aux);
                            lugares.add(lugar);

                        }
                    }
                } 
                for(Lugar nini:lugares) {
        			System.out.print(nini.toString()+"\n\n");
        			System.out.println("");
        		}
                
                if(linetxt.contains("</Localizaciones>")){
                    System.out.println(linetxt);
                }
                //System.out.println("HOLAAAAA----->"+lugares.get(0).mostrar());
            }
            
            

            src.close(); //Cerramos el scanner al fichero.
            fichero.close(); //Cerramos el fichero.
        } catch (Exception e) { //Levanto una excepcion si no se ha podido leer el fichero
            e.printStackTrace();
        }

    }
    
}
