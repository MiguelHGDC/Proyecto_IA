import java.util.Arrays;

public class Lugares {
	public String nombre;
	public String[] adyaciencias;
	
	public Lugares(String nombre, String[] adyaciencias) {
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


	@Override
	public String toString() {
		return "Lugares [nombre=" + nombre + ", adyaciencias=" + Arrays.toString(adyaciencias) + "]";
	}
	
	
	
}
