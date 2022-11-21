package es.ua.dlsi.prog3.p1;

import java.util.Arrays;

/**
 * Esta clase representa coordenadas en un espacio n-dimensional. 
 * Para que el espacio permita almacenar n dimensiones se utiliza
 * un array de elemento como componentes de las cordenada
 * Esta clase es inmutable puesto que no tiene metodos qe modifiquen el objeto,
 * los atributos son privados y están definidos como final, uso copias defensivas y
 * y el objeto está definido como final.
 * @author Óscar Climent Inglés 	DNI:48784077L
 *
 */
final public class Coordinate {
	
	/**
	 * El atributo components es un array que almacena las cordenadas
	 * Este atributo es de instancia
	 */
	final private double[] components;
	
	/**
	 * Coordinate(double[]) es un contructor que crea un objeto Coordinate con
	 * valor en el atributo components uno pasado con el contructor
	 * Es un constructor sobrecargado
	 * Se utiliza una copia defensiva para no inincalizar con una referencia externa
	 * Los parametros se pasan por valor
	 * @param comps
	 */
	public Coordinate(double[] comps) {
		components = new double[comps.length];
		for (int i=0; i<comps.length; i++) {
			components[i] = comps[i];
		}
	}
	
	/**
	 * Coordinate(Coordinate) es un constructor que crea un objeto cuyos valores 
	 * en el atributo components son iguales a los de otro objeto Coordinate pasado
	 * Es un contructor de copia profunda
	 * Los parametros se pasan por valor
	 * @param c
	 */
	public Coordinate(Coordinate c) {
		components = new double[c.components.length];
		for(int i=0;i<c.components.length;i++) {
			components[i]=c.components[i];
		}
	}
	
	/**
	 * getDimesions() es un método que devuelve la longitud del array components
	 * Este método es de clase 
	 * @return
	 */
	public int getDimensions() {
		return components.length;
	}
	
	/**
	 * getComponents es un metodo que devuelve una array que contiene los valores 
	 * components del objeto Coordinate. Se utiliza una copia defensiva para no devolver
	 * una referencia interna
	 * Este método es de intancia
	 * @return
	 */
	public double[] getComponents() {
		double[] comps = new double[components.length];
		for(int i=0;  i<components.length; i++){
			comps[i] = this.components[i];
		}
		return comps;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(components);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinate other = (Coordinate) obj;
		return Arrays.equals(components, other.components);
	}	
}
