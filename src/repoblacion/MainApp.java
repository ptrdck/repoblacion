package repoblacion;

import repoblacion.modelo.Bosque;
import repoblacion.utilidades.Consola;


/**
 * 
 * @author Pedro Patricio Cárdenas Figueroa
 * IES Al-Andalús
 * Programación
 * Tarea Online 
 * URL : https://github.com/ptrdck/repoblacion.git
 *
 */
public class MainApp {

	private Bosque bosque;

	public static void main(String[] args)
	{
		System.out.println("_______________________");
		System.out.println("**  Tarea Online 4  **");
		System.out.println("**  Programación  **");
		System.out.println("** Pedro Cárdenas F. **");
		System.out.println("_______________________");
		
		
		int altura;
		int anchura;
		int poblacion;

		try {

			anchura = Consola.leerAnchura();
			altura = Consola.leerAltura();
			poblacion = Consola.leerPoblacion();

			System.out.println("___________________________________________________");
			Bosque bosque = new Bosque(anchura, altura, poblacion);

			System.out.println("__________________________________________________");
			System.out.println("Arbol más cercano: " + bosque.getArbolMasCentrado());
			System.out.println("Arbol más alejado " + bosque.getArbolMasAlejado());


		}catch (Exception e)
		{
			System.out.println(e.getMessage());
		}


	}

}
