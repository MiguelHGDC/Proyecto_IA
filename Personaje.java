
public class Personaje {
	public String nombre;
	public String localizacion;
	
	public Personaje(String nombre, String localizacion) {
		this.nombre = nombre;
		this.localizacion = localizacion;
	}
	
	@Override
	public String toString() {
		return "Personajes [nombre: " + nombre + ", localizacion: " + localizacion + "  ]";
	}
	
	
}
