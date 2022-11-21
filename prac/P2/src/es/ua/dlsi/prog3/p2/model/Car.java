package es.ua.dlsi.prog3.p2.model;

import java.util.ArrayList;

import es.ua.dlsi.prog3.p2.exceptions.NoTyreTypeException;
import es.ua.dlsi.prog3.p2.exceptions.PressureWheelException;
import es.ua.dlsi.prog3.p2.exceptions.TooManyWheelsException;
import es.ua.dlsi.prog3.p2.exceptions.WrongTyreTypeException;

/**
 * Esta clase representa un coche y viene definido por las ruedas que tiene. Se le puede añadir ruedas
 * que son objetos de tipo Wheel hasta un máximo definido por la relacioón 0..4
 * @author Óscar DNI 48784077L
 *
 */
public class Car {
	
	/**
	 * Este atributo es un array de Objetos tipo Wheel, almacena las ruedas que tiene el coche 
	 */
	private Wheel[] wheels;
	
	/**
	 * Este atributo tipo int almacena la cantidad de ruedas que el coche tiene añadidas
	 */
	private int numRuedas=0;
	
	
	/**
	 * Constructor por defecto
	 * Inicializa el atributo wheels a un array de 4 posicuines en null que son las máximas ruedas posibles
	 */
	public Car() {
		wheels = new Wheel[4];
	}
	
	/**
	 * Costructor por copia. Realiza una copia profunda
	 * Da valores al atributo wheels añadiendo las mismas ruedas que otro objeto de clase Car tiene añadidas
	 * y pone el atributo numRuedas a la cantidad de ruedad añadidas 
	 * @param c : paso por referencia
	 */
	public Car(Car c) {
		for(int i=0; c.wheels.length<i;i++) {
			this.wheels[i]=c.wheels[i];
			numRuedas++;
		}
	}
	
	
	/**
	 * Método de instacia
	 * Se encarga de añadir al atributo wheels una rueda nueva, del tipo pasado por referencia.
	 * Antes se encarga de comprobar que el objeto Car puede almacenar una rueda mas (no supera las 4 ruedas)
	 * y comprueba que eñ tipo de rueda nuevo es igual que las que ya hay, en caso de no ser asi, lanza las Exceptions 
	 * TomanyWheelsExceptio y WrongTypeExceptio respectivamente
	 * 
	 * @param wheel : paso por referencia
	 * @throws TooManyWheelsException
	 * @throws WrongTyreTypeException
	 */
	public void addWheel(Wheel wheel) throws TooManyWheelsException, WrongTyreTypeException{
		if(numRuedas>=4) {
			throw new TooManyWheelsException();
		}
		else if(numRuedas>0) {
			if(this.wheels[0].getTyreType()!=wheel.getTyreType()) {
				throw new WrongTyreTypeException();
			}
		}
		else {
			this.wheels[numRuedas]=wheel;
			numRuedas++;
		}
	}
	
	
	/**
	 * Método de instancia 
	 * Este metodo se encarga de devolver en un ArrayList><Wheels> el atributo wheels, que son todas las ruedas
	 * del coche.
	 * 
	 * @return ArrayList<Wheel>
	 */
	public ArrayList<Wheel> getWheels(){
		ArrayList<Wheel> wheels = new ArrayList<Wheel>();
		
			for(int i=0; i<numRuedas;i++) {
				wheels.add(this.wheels[i]);
			}
		
		return wheels;
	}
	
	/**
	 * Método de instancia
	 * Este método se encarga de cambiar el tipo y presión de las ruedas almacenadas dentro del atributo wheels
	 * Antes de ellos comprueba de los valores pasados que el tipo de rueda no sea null y que la presión sea correcta
	 * en caso de no ser así lanza las Exceptions IllegalArgumentException y PressureWheelException resprectivamente
	 * Tambien hace catch de las Exceptions que pueden darse de los métodos que utiliza
	 * 
	 * @param t : paso por referencia
	 * @param pressure : paso por valor
	 * @throws PressureWheelException
	 */
	public void changeTyres(TyreType t, double pressure) throws PressureWheelException{
		if(t==null) {
			throw new IllegalArgumentException();
		}
		
		try {
			for(int i=0; i<this.wheels.length;i++) {
				this.wheels[i].setTyreType(t);
				this.wheels[i].inflate(pressure);
			}
		}
		catch(PressureWheelException e){
			System.err.println("Valor de presion mo valido" + e.getMessage());
			throw new PressureWheelException(pressure);
		}
		catch(NoTyreTypeException | IllegalArgumentException e) {
			System.err.println("RuntimeException");
			throw new RuntimeException();
		}
	}
}
