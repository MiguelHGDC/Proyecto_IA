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
        int tipo = 0; //1->Lugar, 2->Personaje, 3->Objeto

        try {
            FileInputStream fichero = new FileInputStream("C:\\Users\\mhere\\OneDrive\\Escritorio\\U-TAD\\Curso2\\Programacion orientada a objetos\\08-POO\\Proyecto_Java\\Prueba_lectura.txt");
            Scanner src = new Scanner(fichero);

            while(src.hasNextLine()) {              
                //System.out.println(linetxt);
            	linetxt = src.nextLine(); 
            	
            	if(linetxt.contains("<")) {
            		
            		if(linetxt.contains("<Localizaciones>")) {
            			tipo = 1;
            		}
            		else if(linetxt.contains("<Personajes>")) {
            			tipo = 2;
            		}
            		else {
            			tipo = 3;
            		}
            		
            	}
            	else {
            		if(tipo == 1) {
            			nuevalinea = linetxt.replace("(", "-").replace(")", "").replace(",","-").trim();
                        
                        partes = nuevalinea.split("-");
                        
                        nuevalinea2 = linetxt.replace(partes[0],"").replace("(", "").replace(")", "").replace(",","-").trim();
                        
                       // System.out.println("\n\n NUEVA LINEA 2 :"+nuevalinea2);
                        aux = nuevalinea2.split("-");

                        Lugar lugar = new Lugar(partes[0],aux);
                        lugares.add(lugar);
            		}
            		else if(tipo == 2) {
            			
            			nuevalinea = linetxt.replace("(", "-").replace(")", "").replace(",","-").trim();
                        
                        partes = nuevalinea.split("-");
                        
                        nuevalinea2 = linetxt.replace(partes[0],"").replace("(", "").replace(")", "").replace(",","-").trim();
                        
                        //System.out.println("\n\n NUEVA LINEA 2 :"+nuevalinea2);
                        aux = nuevalinea2.split("-");

                        Personaje personaje = new Personaje(partes[0],aux[0]);
                        personajes.add(personaje);
            		}
            		else {
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
        } 
        
        catch (Exception e) { //Levanto una excepcion si no se ha podido leer el fichero
            e.printStackTrace();
        }
	}
}
