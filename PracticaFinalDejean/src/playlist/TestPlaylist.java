package playlist;

public class TestPlaylist {

	
	public static void main(String[] args) throws CancionNoEncontradaException {
		Cancion c1=new Cancion("black dog","fa","Led Zeppelin",210);
		Cancion c2=new Cancion("cant stop","fe","Red Hot chilli",215);
		Cancion c3=new Cancion("smoke on the water","fi","deep purple",160);
		Cancion c4=new Cancion("angie","fo","rolling stones",147);
		Cancion c5=new Cancion("penny lane","fu","the beatles",100);
		
		PlayList nuevaPlaylist=new PlayList();
		
		nuevaPlaylist.agregarCancion(c1);
		nuevaPlaylist.agregarCancion(c2);
		nuevaPlaylist.agregarCancion(c3);
		nuevaPlaylist.agregarCancion(c4);
		nuevaPlaylist.agregarCancion(c5);
		
		System.out.println("mostrar lista sin ordenar");
		
		nuevaPlaylist.mostrarLista();
		
		System.out.println("ordenar y mostrar la lista ordenada por interprete");
		
		nuevaPlaylist.ordenarPlayList();
		
		nuevaPlaylist.mostrarLista();
		
		nuevaPlaylist.eliminarCancion("angie");
		
		System.out.println(nuevaPlaylist.cantidadCanciones());
		
		nuevaPlaylist.eliminarCancion("la macarena");
		
		System.out.println(nuevaPlaylist.cantidadCanciones());
	}
}
