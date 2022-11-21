package es.ua.dlsi.prog3.p2.model;

import es.ua.dlsi.prog3.p2.exceptions.NoTyreTypeException;
import es.ua.dlsi.prog3.p2.exceptions.PressureWheelException;

/**
 * Esta clase representa la rueda de un vehículo a la que se le puede asignar un tipo
 * TyreType. Por lo que su estado esta asignado por los atributos de TyreType y por la presión 
 * a la qu está inflada 
 * 
 * @author Óscar DNI: 48784077L
 */

public class Wheel {
	
	/**
	 * Este atributo de tipo double almacena la presión a la que está inflada la rueda 
	 */
	private double pressure;
	
	/**
	 * Este atributo de clase TyreType almacena el tipo de rueda y atributos de ese tipo
	 */
	private TyreType type;
	
	
	/**
	 * Constructor por defecto, deja el TyreType a null y la presion la inicializa a 0
	 */
	public Wheel() {
		pressure = 0;
	}
	
	/**
	 * Constructor de sobrecarga.
	 * Da valores al atributo de TyreType en función a uno de la misma calse pasado
	 * 
	 * @param t : paso por referencia
	 */
	public Wheel(TyreType t) {
		pressure = 0;
		type=t;
	}
	
	/**
	 * Constructor de copia. Realiza una copia profunda de un objeto pasado.
	 * Crea un objeto de tipo Wheel cuyos atributos son la copia los de otro igual
	 * 
	 * @param w : paso por refeferancia.
	 */
	public Wheel(Wheel w) {
		this.pressure=w.pressure;
		this.type=w.type;
	}
	
	
	/**
	 * Método de insancia 
	 * 
	 * Se encarga de dar un valor pasado por referencia al atributo TyreType
	 * 
	 * @param type : paso por referencia
	 */
	public void setTyreType(TyreType type) {
		this.type=type;
	}
	
	/**
	 * Método de instancia 
	 * 
	 * Se encarga de devolver el valor almacenado dentro del atributo TyreType de la calse
	 * 
	 * @return TyreType
	 */
	public TyreType getTyreType() {
		return this.type;
	}
	
	/**
	 * Método de instancia
	 * 
	 * Este método se encarga de darle al valor pressure de la calse uno pasado por referencia
	 * También se asegura antes que la rueda tenga un tipo definido y que la presión pasada sea positiva
	 * En caso de no ser así lanza las Execpcions NoTyreTypeException y PressureWheelException respectivamente
	 * 
	 * @param press : paso por valor 
	 * @throws NoTyreTypeException
	 * @throws PressureWheelException
	 */
	public void inflate(double press) throws NoTyreTypeException, PressureWheelException {
		 
		if(press<0) {
			throw new IllegalArgumentException("La presion no puede ser menor que 0");
		}
		else if(this.type == null) {
			throw new NoTyreTypeException();
		}
		else if(press<this.type.getMinPressure() || press>this.type.getMaxPressure()) {
			throw new PressureWheelException(press);
		}
		else {
			this.pressure=press;
		}
	}
}
