import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Fichero {
	static ArrayList<Lugar> lugares = new ArrayList<Lugar>();
	static ArrayList<Personaje> personajes = new ArrayList<Personaje>();
	static ArrayList<Objeto> objetos = new ArrayList<Objeto>();
	
	public void inicializar() {
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
                //System.out.println(linetxt);

                if(linetxt.contains("<Localizaciones>")){ //Parte del texto donde se encuentran las localizaciones.
                    while(true){ //Captura de todas las localizaciones que hay
                        linetxt = src.nextLine();
                        if(linetxt.contains("</Localizaciones>")){
                            break;
                        }else{
                            nuevalinea = linetxt.replace("(", "-").replace(")", "").replace(",","-").trim();
                            
                            partes = nuevalinea.split("-");
                            
                            nuevalinea2 = linetxt.replace(partes[0],"").replace("(", "").replace(")", "").replace(",","-").trim();
                            
                           // System.out.println("\n\n NUEVA LINEA 2 :"+nuevalinea2);
                            aux = nuevalinea2.split("-");

                            Lugar lugar = new Lugar(partes[0],aux);
                            lugares.add(lugar);

                        }
                    }
                }
                
                if(linetxt.contains("<Personajes>")){ //Parte del texto donde se encuentran las localizaciones.
                    while(true){ //Captura de todas las localizaciones que hay
                        linetxt = src.nextLine();
                        if(linetxt.contains("</Personajes>")){
                            break;
                        }else{
                            nuevalinea = linetxt.replace("(", "-").replace(")", "").replace(",","-").trim();
                            
                            partes = nuevalinea.split("-");
                            
                            nuevalinea2 = linetxt.replace(partes[0],"").replace("(", "").replace(")", "").replace(",","-").trim();
                            
                            //System.out.println("\n\n NUEVA LINEA 2 :"+nuevalinea2);
                            aux = nuevalinea2.split("-");

                            Personaje personaje = new Personaje(partes[0],aux[0]);
                            personajes.add(personaje);

                        }
                    }
                } 
                if(linetxt.contains("<Objetos>")){ //Parte del texto donde se encuentran las localizaciones.
                    while(true){ //Captura de todas las localizaciones que hay
                        linetxt = src.nextLine();
                        if(linetxt.contains("</Objetos>")){
                            break;
                        }else{
                            nuevalinea = linetxt.replace("(", "-").replace(")", "").replace(",","-").trim();
                            
                            partes = nuevalinea.split("-");
                            
                            nuevalinea2 = linetxt.replace(partes[0],"").replace("(", "").replace(")", "").replace(",","-").trim();
                            
                            //System.out.println("\n\n NUEVA LINEA 2 :"+nuevalinea2);
                            aux = nuevalinea2.split("-");

                            Objeto objeto = new Objeto(partes[0],aux[0]);
                            objetos.add(objeto);

                        }
                    }
                } 
            }
            System.out.println("[     LUGARES     ]\n");
            
            for(Lugar nini:lugares) {
    			System.out.print(nini.toString()+"\n");
    			System.out.println("");
    		}
            
            System.out.println("[     PERSONAJES     ]\n");
            
            for(Personaje lili:personajes) {
    			System.out.print(lili.toString()+"\n");
    			System.out.println("");
    		}
            
            System.out.println("[     OBJETOS     ]\n");
            
            for(Objeto claudio:objetos) {
    			System.out.print(claudio.toString()+"\n");
    			System.out.println("");
    		}
          //System.out.println("HOLAAAAA----->"+lugares.get(0).mostrar()); debuggeando con el rabo hermano

            src.close(); //Cerramos el scanner al fichero.
            fichero.close(); //Cerramos el fichero.
        } catch (Exception e) { //Levanto una excepcion si no se ha podido leer el fichero
            e.printStackTrace();
        }
	}
}
