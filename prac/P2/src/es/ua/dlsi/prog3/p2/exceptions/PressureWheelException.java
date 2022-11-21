package es.ua.dlsi.prog3.p2.exceptions;

public class PressureWheelException extends Throwable{
	
	private double pressure;
	
	public PressureWheelException(double press) {
		this.pressure = press;
	}
	
	public String getMessage() {
		String mensaje;
		
		mensaje = "Pressure of " + this.pressure + "BAR";
		return mensaje;
	}
}