package repoblacion.modelo;

public enum Especie {
	ALAMO("Alamo"), ENCINA("Encina"), CASTANO("Castaño"), CIPRES("Ciprés"),
	PINO("Pino piñonero"), ROBLE("Roble Mediterraneo"), OLIVO("Olivo");
	
	private String cadenaAMostrar;
	
	private Especie (String cadenaAMostrar)
	{
		this.cadenaAMostrar = cadenaAMostrar;
	}
	
	@Override
	public String toString()
	{
		return this.cadenaAMostrar;
	}

}