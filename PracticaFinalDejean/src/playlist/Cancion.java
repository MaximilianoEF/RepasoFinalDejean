
public class Cancion implements Comparable<Cancion>{

	private String titulo;
	private String album;
	private String interprete;
	private double duracion;
	
	public Cancion(String titulo, String album, String interprete, double duracion) {
		this.titulo = titulo;
		this.album = album;
		this.interprete = interprete;
		this.duracion = duracion;
	}
	
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


	@Override
	public int compareTo(Cancion o) {
		if(this.interprete.compareToIgnoreCase(o.interprete) == 0)
		{           
		            
		     return this.interprete.compareToIgnoreCase(o.interprete);
		}
		
		return this.interprete.compareToIgnoreCase(o.interprete);
		        
	}

	@Override
	public String toString() {
		return "Cancion [titulo=" + titulo + ", album=" + album + ", interprete=" + interprete + ", duracion="
				+ duracion + "]";
	}

}
