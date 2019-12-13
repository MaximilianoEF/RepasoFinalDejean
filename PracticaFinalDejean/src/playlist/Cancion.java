
//declaracion de Package
package playlist;
//declaracion de clase cancion
//la clase cancion implementa la interfaz comparable de tipo cancion
public class Cancion implements Comparable<Cancion> {

//declaracion de atributos de la clase cancion
	
private String titulo;
private String album;
private String interprete;
private double duracion;

//constructor con parametros de la clase cancion

public Cancion(String titulo, String album, String interprete, double duracion) {
	this.titulo=titulo;
	this.album=album;
	this.interprete=interprete;
	this.duracion=duracion;
}

//getters de la clase getTitulo, getAlbum, getInterprete, getDuracion

public String getTitulo() {
	return titulo;
}


public String getAlbum() {
	return album;
}


public String getInterprete() {
	return interprete;
}


public double getDuracion() {
	return duracion;
}

//Metodo toString de la clase cancion mostrando todos los atributos

@Override
public String toString() {
	return "Cancion [titulo=" + titulo + ", album=" + album + ", interprete=" + interprete + ", duracion=" + duracion
			+ "]";
}

//metodo compareTo de la interfaz comparable que comparable que compara las canciones alfabeticamente por nombre de interprete
@Override
public int compareTo(Cancion otraCancion) {
	
	return this.getInterprete().compareToIgnoreCase(otraCancion.getInterprete());
}

}
