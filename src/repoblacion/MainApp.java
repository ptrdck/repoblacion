package repoblacion;

import repoblacion.modelo.Bosque;
import repoblacion.utilidades.Consola;

public class MainApp {
	
	private Bosque bosque;

	public static void main(String[] args)
	{
		int altura;
		int anchura;
		int poblacion;
		
		try {
			
			anchura = Consola.leerAnchura();
			altura = Consola.leerAltura();
			poblacion = Consola.leerPoblacion();
			
			Bosque bosque = new Bosque(anchura, altura, poblacion);
			
			
		}catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		

	}

}
