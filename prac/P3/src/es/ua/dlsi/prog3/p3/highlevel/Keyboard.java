package es.ua.dlsi.prog3.p3.highlevel;

import es.ua.dlsi.prog3.p3.lowlevel.InputDevice;

/**
 * Esta calse representa un teclado 
 * Es subclase de InputDevice
 * @author Óscar Climent Ingles 48784077L
 *
 */
public class Keyboard extends InputDevice{
	
	/**
	 * Consttructor por defecto
	 * Crea un objeto de tipo Keyboard 
	 */
	public Keyboard(){
		super();
	}
	
	/**
	 * Metodo de instancia 
	 * Envia al bufer un caracter que haya en el canal
	 * @param send el caracter recogido 
	 */
	public void put(char send) {
		super.sendToChannel((byte) send);
	}

}
