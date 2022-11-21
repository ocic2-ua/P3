package es.ua.dlsi.prog3.p3.highlevel;

import java.nio.BufferUnderflowException;

import es.ua.dlsi.prog3.p3.lowlevel.OutputDevice;


/**
 * La clase Display simula una pantalla cuadrada de NXN cuyos pixeles
 * pueden estar en blanco o en negro
 * Es subclase de OutputDevice
 * 
 * @author Óscar Climent Ingles 48784077L
 *
 */
public class Display extends OutputDevice{
	
	/**
	 * Atributo de instancia
	 * Representa el tamaño (n) de las filas y columnas
	 */
	private int pixel_rows;
	
	/**
	 * Atributo de instancia
	 * Almacena la pantalla del Display
	 */
	private byte[][] display;
	
	/**
	 * Constructor sobrecargado
	 * @param n numero de filas y columnas
	 */
	public Display(int n){
		super(n*n*2);
		pixel_rows=n;
		display = new byte[n][n];
	}
	
	/**
	 * Metodo de instancia 
	 * devuelve el tamaño de las filas y columnas
	 * @return el tamaño de filas y columnas
	 */
	public int getDisplaySize() {
		int size=pixel_rows;
		return size;
	}
	
	/**
	 * Metodo de instancia 
	 * Este metodo se necarga de asignar un valor distinto de 0 a los puntos 
	 * del display que deben actualizarse
	 * @return devuelve el display actualizado
	 */
	public byte[][] refresh(){
		byte[] posicion = new byte[2];
		byte[][] display = new byte[pixel_rows][pixel_rows];
		
		if(super.getBufferSize()<2){
			throw new BufferUnderflowException();
		}
		else{
			if(super.getChannel().hasData()) {
				while(super.getChannel().hasData()){
					posicion = get(2);
					if((0<=posicion[0] && posicion[0] < pixel_rows) && (0<=posicion[1] && posicion[1] < pixel_rows)) {	
						this.display[posicion[0]][posicion[1]]=1;
					}
					else {
						throw new  IndexOutOfBoundsException("Los valores pasados se salen del display");
					}
				}
				for(int i=0; i<pixel_rows; i++) {
					for(int j=0; j<pixel_rows; j++) {
						display[i][j]=this.display[i][j];
					}
				}
			}
		}
		return display;
	}
	
	/**
	 * Metodo de instancia 
	 * Borra todo el display
	 */
	public void clear() {
		for(int i=0; i<pixel_rows; i++) {
			for(int j=0; j<pixel_rows; j++) {
				this.display[i][j]=0;
			}
		}
	}

}
