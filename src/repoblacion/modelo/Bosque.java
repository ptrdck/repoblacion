package repoblacion.modelo;

import java.util.Arrays;
import java.util.Random;

public class Bosque {

	//declaración de constantes
	public static final int MAX_ALTURA = 500;
	public static final int MINIMO = 10;
	public static final int MAX_ANCHURA = 1000;
	public static final int MAX_ESPECIES = 4;
	
	//declaración de variables
	private Arbol arbolMasAlejado;
	private Arbol arbolMasCentrado;
	private Random generador;
	private int ancho;
	private int alto;
	
	//declaración de array que almacena arboles
	private Arbol[] arboles;
	
	
	//Constructor con parámetros
	public Bosque(int ancho, int alto, int poblacion)
	{
		
		setAncho(ancho);
		setAlto(alto);
		checkPoblacion(poblacion);
		arboles = new Arbol[poblacion];
		generador = new Random();
		
		repoblar();
		
		
	}
	
	public Arbol[] duplicaBosque()
	{
		Arbol[] copiaBosque = new Arbol[arboles.length];
		for (int i = 0; i < arboles.length ; i++) 
		{
			copiaBosque[i] = new Arbol(arboles[i]);
		}
		return copiaBosque;
	}
	

	//getters & setters
	public Arbol getArbolMasAlejado() {
		return arbolMasAlejado;
	}

	public Arbol getArbolMasCentrado() {
		return arbolMasCentrado;
	}

	public int getAncho() {
		return ancho;
	}

	public int getAlto() {
		return alto;
	}


	public void setAncho(int ancho) {
		
		//Comprueba que el ancho sea válido mientras su valor se encuentre entre MIN y MAX_ANCHURA
		if (ancho > MAX_ANCHURA || ancho < MINIMO)
		{
			throw new IllegalArgumentException("ERROR: Anchura no válida.");
		}
		this.ancho = ancho;
	}

	public void setAlto(int alto) {
		
		//Comprueba validez de la entrada. Válido si alto está entre MIN y MAX_ALTURA
		if (alto > MAX_ALTURA || alto < MINIMO)
		{
			throw new IllegalArgumentException("ERROR: Altura no válida.");
		}
		this.alto = alto;
	}
	
	
	/*
	 * Método que comprueba si el parámetro población es válido
	 * si y solo está comprendido entre 0 y el perímetro del bosque
	 */
	public void checkPoblacion (int poblacion)
	{
		int perimetro = (alto*2) + (ancho*2);
		
		if (poblacion > perimetro)
		{
			throw new IllegalArgumentException("ERROR: La población no puede superar el perímetro del bosque.");
		}
		else if (poblacion < 0)
		{
			throw new IllegalArgumentException("ERROR: La población debe ser mayor que cero.");
		}	
	}
	
	
	/*
	 * Método repoblar según la compatibilidad entre especies
	 */
	private void repoblar()
	{
		//iniciamos una variable para crear la primera especie que determinará la especie inicial del bosque
		Especie generaEspecie = null;
		//Declaramos e inicializamos un generador de entero que determinará la especie del arbol sobre la cual se evaluará la compatibilidad del bosque
		int ordinalEspecie = generador.nextInt(0,7);
		
		//Declaramos un array de posiciones
		Posicion[] generaPosicion = new Posicion[arboles.length];
		//declaramos e inicializamos arrays de especies según su compatibilidad
		Especie[] compatibleAlamo = new Especie[] {Especie.ALAMO, Especie.ENCINA, Especie.PINO, Especie.ROBLE};
		Especie[] compatibleOlivo = new Especie[] {Especie.OLIVO, Especie.CASTANO, Especie.CIPRES, Especie.PINO, Especie.ROBLE};
		// Array auxiliar en caso de que Roble sea primera especie en plantar
		Especie[] compatibleOlivoRoble = new Especie[] {Especie.ROBLE, Especie.OLIVO, Especie.CASTANO, Especie.CIPRES, Especie.PINO};
		// booleano que determinará que especies plantar en caso de que el primer arbol sea Roble o Pino
		boolean compatibleAleatorio = generador.nextBoolean();
		
		
		// ciclo for que determinará la primera posición segun muestre el método generador entre 0 y 6
		
		
		//determinamos el valor de la variable generaEspecie que nos ayudará a evaluar la compatibilidad del bosque
		if (ordinalEspecie == 0)
		{
			generaEspecie = Especie.ALAMO;
		}else if (ordinalEspecie == 1)
		{
			generaEspecie = Especie.ENCINA;
		}else if (ordinalEspecie == 2)
		{
			generaEspecie = Especie.CASTANO;
		}else if (ordinalEspecie == 3)
		{
			generaEspecie = Especie.CIPRES;
		}else if (ordinalEspecie == 4)
		{
			generaEspecie = Especie.PINO;
		}else if (ordinalEspecie == 5)
		{
			generaEspecie = Especie.ROBLE;
		}else if (ordinalEspecie == 6)
		{
			generaEspecie = Especie.OLIVO;
		}
		
		
		//Creamos un ciclo for para comenzar a repoblar el bosque según la compatibilidad de los arboles.
		for (int i = 0; i < arboles.length; i++)
		{
			//Iniciamos el array de posiciones en el plano
			generaPosicion[i] = new Posicion(generador.nextDouble(-ancho/2, ancho/2), generador.nextDouble(-alto/2, alto/2));
			
			//Creamos las condiciones en que se repoblará el arbol según se haya determinado la especie.
			
			//Repoblamos bosque si la especie es Alamo o Encina
			if (generaEspecie == Especie.ALAMO || generaEspecie == Especie.ENCINA)
			{
				//creamos un objeto arbol con una especie y una posicion determinada en el array arboles
				arboles[i] = new Arbol(compatibleAlamo[generador.nextInt(MAX_ESPECIES)], generaPosicion[i]);
			}
			//Repoblamos bosque si la especie es Olivo, Castaño o Ciprés
			else if(generaEspecie == Especie.OLIVO || generaEspecie == Especie.CASTANO || generaEspecie == Especie.CIPRES)
			{
				arboles[i] = new Arbol(compatibleOlivo[generador.nextInt(MAX_ESPECIES)], generaPosicion[i]);
				
			}
			//Repoblamos el bosque en caso de que que el determinante sea Roble o PINO
			else if(generaEspecie == Especie.PINO || generaEspecie == Especie.ROBLE)
			{
				//Condicion de que nuestro booleano sea verdadero, asignaremos la repoblación según la compatibiidad del Alamo
				if (compatibleAleatorio == true)
				{
					arboles[i] = new Arbol(compatibleAlamo[generador.nextInt(MAX_ESPECIES)], generaPosicion[i]);
				}
				//COndición en que el booleano sea falso y repoblamos bosque con la compatibilidad del OLIVO
				else
					//caso en que la especie la determine el PINO y así nos evitamos que se creen más de 4 especies
					if (generaEspecie == Especie.PINO) 
					{
						arboles[i] = new Arbol(compatibleOlivo[generador.nextInt(MAX_ESPECIES)], generaPosicion[i]);
					}
					//caso de que la especie la determine el Roble
					else if (generaEspecie == Especie.ROBLE)
					{
						//Usamos un array auxiliar de la compatibilidad del Roble para que no se quede afuera ni tampoco nos entregue más de 4 especies
						arboles[i] = new Arbol(compatibleOlivoRoble[generador.nextInt(MAX_ESPECIES)], generaPosicion[i]);
					}
					
		
			}
			
			System.out.println(arboles[i]);
				
		}
	}
	
	// Método que buscará el arbol más alejado y más cercano al punto centro del plano (0,0)
	public void realizarCalculos ()
	{
		//Declaramos e inicializamos la posicion centro del plano.
		Posicion centro = new Posicion(0,0);
		
	
		//Declaramos un array donde dejaremos cada distancia de cada arbol creado en nuestro array arboles
		double[] distancias = new double[arboles.length]  ;
		
		//iniciamos un ciclo for para que vaya calculando las distancias con el centro y el arbol
		
		for (int i = 0; i < arboles.length; i++ )
		{
			//almacenamos la distancia de cada arbol
			distancias[i] = arboles[i].getPosicion().distancia(centro);
			
			//comparamos el array de distancias. Si la distancia que se está calculando es mayor a la anterior ya calculada
			//actualizamos la variable arbolMasAlejado con el índice del arbol sobre el que se calculó
			if (distancias[i] > distancias[i-1])
			{
				this.arbolMasAlejado = arboles[i];
			}
			//Si la distancia que se está calculando actualmente es menor a la anterior ya calculada actualizamos 
			// el valor de la variable arbolMasCentrado con el índice del árbol 
			if (distancias[i] < distancias[i-1])
			{
				this.arbolMasCentrado =arboles[i];
			}
		}
		
	}

	@Override
	public String toString() {
		return "Bosque [ancho=" + ancho + ", alto=" + alto + ", arboles=" + Arrays.toString(arboles) + "]";
	}
	
	
	
	
}

