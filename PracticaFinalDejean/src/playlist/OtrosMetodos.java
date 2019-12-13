package playlist;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class OtrosMetodos {

	
	public static void descubrirNombresRepetidos(String miArchivo) throws IOException {
		int cantNombres;
		int cantRepetidos;
		Map<String, Integer> nombres = new TreeMap<String, Integer>();
		TreeMap< Integer,String> repetidos = new TreeMap<Integer,String>();

		Scanner sc = new Scanner(new File(miArchivo));
		cantNombres=sc.nextInt();
		cantRepetidos=sc.nextInt();
		for(int i=0;i<cantNombres;i++){
			String nom = sc.next();
			int cantidad=0;
			if(nombres.containsKey(nom)){
				cantidad = nombres.get(nom);
				nombres.put(nom, cantidad+1);	
			}				
			else
				nombres.put(nom, 1);	
			
		}

		sc.close();

		for (Entry<String, Integer> nombre : nombres.entrySet())
			repetidos.put(nombre.getValue(), nombre.getKey());

		PrintWriter s = new PrintWriter(new FileWriter("repetidos.out")); 

		for(int k=1; k<=cantRepetidos;k++){
			Entry<Integer,String> salida=repetidos.pollLastEntry();
			s.println(salida.getValue()+" "+salida.getKey());
		}
		s.close();
		
	}
	
	public void  ListaDePrecios (){
		
		LinkedList<Articulo> lista = new LinkedList <Articulo>();
		
		public void cargarArticulo(int numero, double precio){
			lista.add(new Articulo(numero, precio));		
		}
		public double devuelvePrecio(int numero){
			double aux=0;
			for(Articulo a: lista){
				if(numero == a.getNumero()){
					aux=a.getPrecio();
				}			
			}
			return aux;
		}
		public double caclProm(Articulo articulo){
			double suma=0;
			int cont=0;
			for(Articulo a: lista){
				suma=suma+a.getPrecio();
				cont++;
			}
			return suma/cont;
		}
		public double precioMaximo(int numero){
			Articulo aux;
			double max = 0,auxD;
			aux=lista.peekFirst();		
			for(Articulo a: lista){
				if(aux.getPrecio()<a.getPrecio()){				
					max=a.getPrecio();				
				}			
			}
			return max;
		}
		public int cuentaCant(double precio1, double precio2){
			int cont=0;
			for(Articulo b:lista){
				if((b.getPrecio()>precio1)&&(b.getPrecio()<precio2)){
					cont++;
				}
			}
			return cont;
		}
	}
	
		
public void supermercado() {
					
			TreeMap<Integer, Cliente> filaA = new TreeMap<Integer, Cliente>();
			TreeMap<Integer, Cliente> filaB = new TreeMap<Integer, Cliente>();
			TreeMap<Integer, Cliente> filaTemp = new TreeMap<Integer, Cliente>();
			
			Cliente maxi=new Cliente(5);			filaA.put(1,maxi);
			Cliente jose=new Cliente(10);			filaA.put(2, jose);
			Cliente nahuel=new Cliente(2);			filaA.put(3, nahuel);
			Cliente lucas=new Cliente(6);			filaA.put(4, lucas);
			Cliente nico=new Cliente(8);			filaA.put(5, nico);
			Cliente mati=new Cliente(1);			filaA.put(6, mati);
			Cliente juan=new Cliente(3);			filaA.put(7, juan);
			Cliente gabriel=new Cliente(12);		filaA.put(8, gabriel);
			Cliente esteban=new Cliente(4);			filaA.put(9, esteban);
			Cliente gian=new Cliente(9);			filaA.put(10, gian);
			
			
			for (Entry<Integer, Cliente> cliente : filaA.entrySet())
			{
				System.out.println("Cliente de la fila A, en la posicion "+cliente.getKey()+", posee "+cliente.getValue()+" productos.");
			}
			
			int cont = 1;
			int cont2 = 1;
			
			//Aquellos clientes que tengan menos de 5 productos pasan a la fila B
			for (Entry<Integer, Cliente> cliente : filaA.entrySet())
			{
				if(cliente.getValue().getCantProductos()<5) {
				filaB.put(cont, cliente.getValue());
				cont++;
				}else {
					//Aquellos clientes que tengan mas de 5 productos pasan a la fila Temporal
					filaTemp.put(cont2, cliente.getValue());
					cont2++;
				}
			}
			
			//Limpio la fila A y le asigno los clientes con mas de 5 productos
			filaA.clear();
			//Clonamos el mapa
			filaA = (TreeMap)filaTemp.clone();
			
			//Limpio la fila temporal.
			
			filaTemp.clear();
			
			System.out.println();
			
			for (Entry<Integer, Cliente> cliente : filaA.entrySet())
			{
				System.out.println("Cliente de la fila A, en la posicion "+cliente.getKey()+", posee "+cliente.getValue().getCantProductos()+" productos.");
			}
			
			System.out.println();
			
			for (Entry<Integer, Cliente> cliente : filaB.entrySet())
			{
				System.out.println("Cliente de la fila B, en la posicion "+cliente.getKey()+", posee "+cliente.getValue().getCantProductos()+" productos.");
			}
			
}}

