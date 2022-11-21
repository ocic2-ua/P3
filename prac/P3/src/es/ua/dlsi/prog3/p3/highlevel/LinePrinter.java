package es.ua.dlsi.prog3.p3.highlevel;

import es.ua.dlsi.prog3.p3.highlevel.exceptions.NoLineForPrintingException;
import es.ua.dlsi.prog3.p3.lowlevel.OutputDevice;

/**
 * La clase LinePrinter imprimpe por pantalla la linea almacenada en el bufer
 * Es subclase de OutputDevice
 * @author Óscar Climent Ingles 48784077L
 *
 */
public class LinePrinter extends OutputDevice{
	
	/**
	 * Atributo de clase 
	 * Es una constante que alamcena el tamañno maximo de la linea a imprimir
	 */
	private static final int MAX_LINE_LENGTH=80;
	
	/**
	 * Constructor por defecto
	 * Crea un obejto de ña clase por defecto
	 */
	public LinePrinter(){
		super(MAX_LINE_LENGTH+1);
	}
	
	/**
	 * Metodo de instancia
	 * Recoge los datos del bufer y los devuleve en un String
	 * @return String con los datos del bufer
	 * @throws NoLineForPrintingException
	 */
	public String printLine() throws NoLineForPrintingException{
		String line = new String();
		
		if(super.getChannel().hasData()==true) {
			line=super.readStoredString();
		}
		else {
			throw new NoLineForPrintingException();
		}
		
		return line;
	}
}
