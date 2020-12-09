import java.util.Arrays;

public class Lugar {
	public String nombre;
	public String[] adyaciencias;
	
	
	public Lugar(String nombre, String[] adyaciencias) {
		this.nombre = nombre;
		this.adyaciencias = adyaciencias;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	public String[] getAdyaciencias() {
		return adyaciencias;
	}
	public void setAdyaciencias(String[] adyaciencias) {
		this.adyaciencias = adyaciencias;
	}
	
	public String mostrar() {
		return adyaciencias[1];
	}
	
	@Override
	public String toString() {
		return "Lugar [nombre: " + nombre + ", adyaciencias: " + Arrays.toString(adyaciencias) + "  ]";
	}


	
	
	
	
}
