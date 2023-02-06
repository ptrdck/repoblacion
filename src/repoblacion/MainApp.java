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

			System.out.println("Arbol más cercano: " + bosque.getArbolMasCentrado());
			System.out.println("Arbol más alejado " + bosque.getArbolMasAlejado());


		}catch (Exception e)
		{
			System.out.println(e.getMessage());
		}


	}

}
