
package es.ua.dlsi.prog3.p2.model;

import java.util.Objects;

/**
 * Esta calse se encarga de almacenar los atributos de distintos tipos de neumáticos que 
 * puedan existir 
 * Se trata de una calse inmmutable
 * @author Óscar DNI: 48784077L
 *
 */

public class TyreType {

	/**
	 * Atrinuto de clase
	 * Este atributo almacena una cadena de tipo String en la que se da una descripción de la rueda
	 */
	private String description;
	
	/**
	 * Atributo de clase
	 * Este atributo de tipo double almacena la presión mínima de la rueda
	 */
	private double min_pressure;
	
	/**
	 * Atributo de clase
	 * Este atributo de tipo double almacena la presión máxima de la rueda
	 */
	private double max_pressure;
	
	
	/**
	 * Se trata de un constructor por sobrecarca.
	 * Da valores a los atributos de la clase en función de unos valores pasados
	 * Utilizo copia defensiva en este constructor para dar los valores
	 * 
	 * @param description : paso por referencia
	 * @param min_pressure : paso por valor
	 * @param max_pressure : paso por valor
	 */
	public TyreType(String description, double min_pressure, double max_pressure) {
		
		if (description==null || description.length()==0){
			throw new IllegalArgumentException("No se valen cadenas vacias como descripción");
		}
		else if(min_pressure<0) {
			throw new IllegalArgumentException("La presión minima debe ser mayor que 0");
		}
		else if(max_pressure<0) {
			throw new IllegalArgumentException("La presión maxima debe ser mayor que 0");
		}
		else if(min_pressure>max_pressure) {
			throw new IllegalArgumentException("La presión minima no puede ser mayor que la maxima");
		}
		else {
			String desc = new String();
			desc=description;
			this.description = desc;
			
			double min = min_pressure;
			this.min_pressure = min;
			
			double max = max_pressure;
			this.max_pressure = max;
		}
	}
	
	/**
	 * Se trata de un contructor de copia. Realiza una copia profunda
	 * Crea un objeto igual que uno igual pasado por referencia
	 * Utilizo copia defesiva para dar los valores
	 * 
	 * @param t : paso por referencia
	 */
	public TyreType(TyreType t) {

		String desc = new String();
		desc=t.description;
		this.description = desc;
		
		double min = t.min_pressure;
		this.min_pressure = min;
		
		double max = t.max_pressure;
		this.max_pressure = max;
	}
	
	/**
	 * Método de instancia
	 * Realiza copia defensiva del atriubuto min_pressure
	 * 
	 * Este método se encarga de devolver el valor almacenado en el atributo min_pressure
	 * 
	 * @return double
	 */
	public double getMinPressure() {
		double min;
		min=this.min_pressure;
		
		return min;
	}
	
	/**
	 * Mérodo de instancia
	 * Realiza copia defensiva del atributo max_pressure
	 * 
	 * Este metodo se encarga de devolver el valor almacenado en el atributo max_pressure
	 * 
	 * @return double
	 */
	public double getMaxPressure() {
		double max;
		max=this.max_pressure;
		
		return max;
	}

	/**
	 * Método de instancia
	 * 
	 * Este método se enacarga de devolver un string donde se devuelcen los datos del objeto
	 * 
	 * @Override
	 */
	public String toString() {
		return "TyreType " + description + " [" + min_pressure + "," + max_pressure + "]";
	}

	/**
	 * Método de instancia 
	 * 
	 * Este método devuelve un booleano que es true si el objeto pasado es igual al
	 * objeto.
	 * 
	 * @Override
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TyreType other = (TyreType) obj;
		return Objects.equals(description, other.description)
				&& Double.doubleToLongBits(max_pressure) == Double.doubleToLongBits(other.max_pressure)
				&& Double.doubleToLongBits(min_pressure) == Double.doubleToLongBits(other.min_pressure);
	}
	
}
