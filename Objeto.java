
public class Objeto {

		public String nombre;
		public String localizacion;

		public Objeto(String nombre, String localizacion) {
			this.nombre = nombre;
			this.localizacion = localizacion;
		}
		
		

		public String getNombre() {
			return nombre;
		}



		public void setNombre(String nombre) {
			this.nombre = nombre;
		}



		public String getLocalizacion() {
			return localizacion;
		}



		public void setLocalizacion(String localizacion) {
			this.localizacion = localizacion;
		}



		@Override
		public String toString() {
			return "Objeto [nombre: " + nombre + ", localizacion: " + localizacion + "  ]";
		}
		
}
