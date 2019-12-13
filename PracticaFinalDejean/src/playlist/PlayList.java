package playlist;

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

public class PlayList  {

	private LinkedList <Cancion> miLista;
	
	public PlayList () {
		this.miLista=new LinkedList<Cancion>();
	}
	
	public PlayList(Cancion primerCancion) {
		this.miLista=new LinkedList<Cancion>();
		miLista.add(primerCancion);
	}
	
	public double cantidadCanciones() {
		return this.miLista.size();
	}
	
	public void agregarCancion(Cancion nuevaCancion) {
		
		this.miLista.add(nuevaCancion);
	}
	
	public void eliminarCancion(String tituloEliminar) throws CancionNoEncontradaException {
	for (Cancion tmp : this.miLista) {
	      if (tmp.getTitulo().equals(tituloEliminar)){
	  this.miLista.remove(tmp);
return;
}}
	}
	public double duracionTotal() {
		double acuDuracion=0;
		
		for(Cancion tmp : this.miLista) {
			acuDuracion += tmp.getDuracion();
		}
		return acuDuracion;
		
	}
	
	public void mostrarLista() {
		System.out.println(this.miLista);
		
	}
	
	public void ordenarPlayList() {
		Collections.sort(miLista);
		
	}
	
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



