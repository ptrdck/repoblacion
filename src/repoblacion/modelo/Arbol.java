package repoblacion.modelo;

public class Arbol {
	
	// Declaración de Atributos (variables)
	private Especie especie;
	private Posicion posicion;
	
	
	//Constructor con parámetros 
	public Arbol(Especie especie, Posicion posicion)
	{
		setEspecie(especie);
		setPosicion(posicion);
	}
	
	//Constructor copia
	public Arbol(Arbol a)
	{
		//captura de excepción nula
		if (a == null)
		{
			throw new NullPointerException("ERROR: No se puede copiar un árbol nulo.");
			
		}
		setEspecie(a.getEspecie());
		setPosicion(a.getPosicion());
	}

	//getters & setters
	public Especie getEspecie() {
		return especie;
	}


	private void setEspecie(Especie especie) {
		
		//comprueba la excepción del nulo
		if (especie == null)
		{
			throw new NullPointerException("ERROR: La especie no puede ser nula.");
		}
		this.especie = especie;
		
	}


	public Posicion getPosicion() {
		return posicion;
	}


	private void setPosicion(Posicion posicion) {
		
		//comprueba la excepción nula. 
		if (posicion == null)
		{
			throw new NullPointerException("ERROR: La posición no puede ser nula.");
		}
		this.posicion = posicion;
	}

	//Método toString()  para representar el objeto en forma de cadena
	@Override
	public String toString() {
		return "Arbol (especie=" + especie + ", posicion=" + posicion + ")";
	}
	
	

}
