package es.ua.dlsi.prog3.p3.highlevel;

import es.ua.dlsi.prog3.p3.lowlevel.InputDevice;

/**
 * Representa un raton
 * Es subclase de InputDevice
 * @author Óscar Climent Ingles 48784077L
 *
 */
public class Mouse extends InputDevice{
	
	/**
	 * Constructor por defecto
	 * Crea un objeto de calse Mouse
	 */
	public Mouse() {
		super();
	}
	
	/**
	 * Metodo de instacia
	 * envia al bufer coordenadasde un raton hayadas en el canal 
	 * @param x
	 * @param y
	 */
	public void put(byte x, byte y) {
		super.sendToChannel(y);
		super.sendToChannel(x);
	}
}
