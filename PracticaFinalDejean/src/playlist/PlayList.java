//declaracion del paquete
package playlist;
//declaracion de librerias a importar
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Scanner;

//declaracion de atributos

public class PlayList  {

	//declaracion de atributos, en este caso una lista 
	
	private LinkedList <Cancion> miLista;
	
	//constructor sin parametros de la clase playlist
	
	public PlayList () {
		this.miLista=new LinkedList<Cancion>();
	}
	
	//constructor con parametros de la clase playlist
	
	public PlayList(Cancion primerCancion) {
		this.miLista=new LinkedList<Cancion>();
		miLista.add(primerCancion);
	}
	
	//metodo que devuelve la cantidad de canciones en la linkedlist usando .size()
	
	public double cantidadCanciones() {
		return this.miLista.size();
	}
	
	//metodo que agrega un objeto de tipo cancion en la linkedlist
	
	public void agregarCancion(Cancion nuevaCancion) {
		
		this.miLista.add(nuevaCancion);
	}
	
	//metodo que elimina una cancion, le pasamos un string con el nombre como parametro,
	//recorremos la lista de objetos cancion, y si encuentra uno igual lo elimina.
	
	public void eliminarCancion(String tituloEliminar) throws CancionNoEncontradaException {
	for (Cancion tmp : this.miLista) {
	      if (tmp.getTitulo().equals(tituloEliminar)){
	  this.miLista.remove(tmp);
return;
}}
	}
	
	//metodo que recorre la lista de objetos cancion y acumula el total de la duracion de los temas
	
	public double duracionTotal() {
		double acuDuracion=0;
		
		for(Cancion tmp : this.miLista) {
			acuDuracion += tmp.getDuracion();
		}
		return acuDuracion;
		
	}
	
	//metodo que muestra por pantalla la lista
	
	public void mostrarLista() {
		System.out.println(this.miLista);
		
	}
	
	//metodo que ordena la lista en base a la interfaz comparable de la clase cancion y el metodo compare to de 
	//esa clase. el mismo esta programado para ordenar alfabeticamente atravez de .getInterprete
	
	public void ordenarPlayList() {
		Collections.sort(miLista);
		
	}
	
	//Metodo que ordena la lista, la recorre con un for each y la imprime en un archivo
	
	public void exportarPlayList() throws IOException {
		PrintWriter salida=new PrintWriter(new FileWriter("miLista.out.txt"));
		Collections.sort(this.miLista);
		for(Cancion c : this.miLista) {
			salida.print(c.getInterprete());
			salida.print(" ");
			salida.print(c.getTitulo());
			salida.print(" ");
			salida.print(c.getAlbum());
			salida.print(" ");
			salida.println(c.getDuracion());
		}
		salida.close();
	}
	
	//metodo que recibe un string con el nombre de la lista que queremos importar,
	//crea una lista nueva, recorre el archivo y copia los datos creando nuevos objetos cancion
	//por ultimo devuelve la lista creada
	
	public LinkedList<Cancion> importarPlaylist(String listaAimportar)  throws FileNotFoundException {
		
			
			LinkedList<Cancion> listaImportada = new LinkedList<Cancion>();
			File f = new File(listaAimportar);
			Scanner sc = new Scanner(f);
			sc.useLocale(Locale.ENGLISH);
			
			while(sc.hasNext()) {
				listaImportada.add(new Cancion(sc.next(),sc.next(),sc.next(), sc.nextDouble()));
			}
			
			sc.close();
			return listaImportada;
		}
		
	//Metodo que recibe lista como parametro, crea una nueva lista y la ordena utilizando el metodo sort pero
	//pasandole como parametro un objeto comparator que es definido dentro del metodo. (compare).
	//luego lo imprime en un nuevo archivo de salida.
	
	public static  LinkedList<Cancion> getOrdenadasPorTitulo(LinkedList<Cancion> list) throws IOException {
		
		LinkedList <Cancion> ordenadasPorTitulo=new LinkedList <Cancion>();
		Collections.sort(list, new Comparator<Cancion>(){

		    @Override
		    public int compare(Cancion p1, Cancion p2) {
		        return p1.getTitulo().compareTo(p2.getTitulo());
		    }
		});
		for(Cancion p : list) {
		ordenadasPorTitulo.add(p);}
		
		PrintWriter salida=new PrintWriter(new FileWriter("ordenadasPorTitulo.txt"));
		for(Cancion p : ordenadasPorTitulo) {
			salida.println(p);
		}
		
		salida.close();
		
		return ordenadasPorTitulo;
		
	}

		
	}



