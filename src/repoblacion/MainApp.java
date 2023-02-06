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
		System.out.printf("%n" + "%n" + "===========================" + "%n" + "%n" );
		System.out.println(" Aplicación para Repoblación de Bosques");
		System.out.printf("%n" + "%n" + "===========================" + "%n" + "%n" );
		
		int altura;
		int anchura;
		int poblacion;

		try {
			
			do {
				anchura = Consola.leerAnchura();
			}while(anchura<=Bosque.MINIMO || anchura>=Bosque.MAX_ANCHURA);

			
			
			do {
				altura = Consola.leerAltura();
			}while(altura<=Bosque.MINIMO || altura>=Bosque.MAX_ALTURA);
			
			do {
				poblacion = Consola.leerPoblacion();
				
			}while(poblacion<=0 || poblacion>2*(anchura+altura));
			

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
