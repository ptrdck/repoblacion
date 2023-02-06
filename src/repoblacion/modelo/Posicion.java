package repoblacion.modelo;

public class Posicion {

	// Declaración de variables tipo Real.
	private double x;
	private double y;


	// Constructor con parámetros

	public Posicion(double x, double y)
	{
		setX(x);
		setY(y);
	}

	//Constructor copia

	public Posicion(Posicion p)
	{
		if (p == null)
		{
			throw new NullPointerException("ERROR: No se puede copiar una posición nula.");
		}

		setX(p.getX());
		setY(p.getY());
	}

	//getters & setters

	public double getX()
	{
		return x;
	}


	private void setX(double x)
	{
		this.x = x;
	}


	public double getY()
	{
		return y;
	}


	private void setY(double y)
	{
		this.y = y;
	}

	/*
	 * Método que calcula la distancia entre dos puntos según el teorema de Euclides
	 * La función Math.sqrt calcula la raíz cuadrada de la expresión: (expresion)^1/2
	 * La función Math.pow calcula la primera expresión elevada a la segunda de su argumento: (expresion1)^expresion2
	 * Debe devolver un valor real.
	 */
	public double distancia(Posicion posicion)
	{
		if (posicion == null)
		{
			throw new NullPointerException("ERROR: No se puede calcular la distancia a una posición nula.");
		}

		double distancia = Math.sqrt((Math.pow(getX()-x, 2)) + Math.pow(getY()-y, 2));

		return distancia;
	}

	// Método toString para devolver la posición de un objeto en una cadena.
	@Override
	public String toString() {
		return "Posicion (x=" + x + ", y=" + y + ")";
	}


}
