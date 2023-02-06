package repoblacion.utilidades;

import repoblacion.modelo.Bosque;

public class Consola {
	
	private Consola()
	{
		
	}

	public int leerAnchura()
	{
		int anchura = 0;
		boolean anchuraCorrecta = false;
		
		do 
		{
			System.out.println("Ingrese la anchura del bosque");
			anchura = Entrada.entero();
			
			if (anchura>Bosque.MINIMO && anchura<Bosque.MAX_ANCHURA)
			{
				anchuraCorrecta = true;
			}
		} while (anchuraCorrecta = false);
		
		return anchura;
	}
	
	public int leerAltura()
	{
		int altura = 0;
		boolean alturaCorrecta = false;
		
		do 
		{
			System.out.println("Ingrese la altura del bosque");
			altura = Entrada.entero();
			
			if (altura>Bosque.MINIMO && altura<Bosque.MAX_ALTURA)
			{
				alturaCorrecta = true;
			}
		} while (alturaCorrecta = false);
		
		return altura;
	}
	
	public int leerPoblacion()
	{
		int poblacion = 0;
		boolean poblacionCorrecta = false;
		
		do 
		{
			System.out.println("Ingrese el número de población a repoblar en el bosque");
			poblacion = Entrada.entero();
			
			if (poblacion> 0 && poblacion<2*(Bosque.MAX_ALTURA + Bosque.MAX_ANCHURA))
			{
				poblacionCorrecta = true;
			}
			else
				System.out.println("La población no puede ser mayor al perimtreo entre los valores máximos");
		} while (poblacionCorrecta = false);
		
		return poblacion;
	}
}