import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.LinkedList;

public class PlayList {

	private LinkedList<Cancion> lista;
	
	public PlayList() {
		this.lista = new LinkedList<Cancion>();
	}
	
	public PlayList(Cancion cancion) {
		this.lista = new LinkedList<Cancion>();
		this.lista.add(cancion);
	}
	
	public void agregarCancion(Cancion cancion) {
		this.lista.add(cancion);
	}
	
	public void eliminarCancion(String titulo) throws CancionNoEncontradaException {
			
			for(Cancion c : this.lista) {
					if(c.getTitulo().equals(titulo)) {
						this.lista.remove(c);
						break;
						}
					else {
						throw new CancionNoEncontradaException("No se encontro la cancion.");
					}
			}
	}
	
	public double numeroDeCanciones() {
		return this.lista.size();
	}
	
	public double duracionTotal() {
		double tmp = 0;
		for(Cancion c : this.lista) {
			tmp += c.getDuracion();
		}
		return tmp;
	}
	
	public void exportarPlayList() throws IOException {
		PrintWriter salida=new PrintWriter(new FileWriter("miLista.out.txt"));
		Collections.sort(this.lista);
		for(Cancion c : this.lista) {
			salida.print(c.getInterprete());
			salida.print(" ");
			salida.print(c.getTitulo());
			salida.print(" ");
			salida.print(c.getAlbum());
			salida.print(" ");
			salida.println(c.getDuracion());
		}
		salida.close();
		for(Cancion c : this.lista) {
			System.out.println(c);
		}
		
	}
	
}


