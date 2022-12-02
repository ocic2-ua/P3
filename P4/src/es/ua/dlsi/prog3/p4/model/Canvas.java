package es.ua.dlsi.prog3.p4.model;

import java.util.ArrayList;

/**
 * Canvas representa un lienzo
 * Se compone de dos dimensiones, altura y longitud, de un titulo y de una serie de 
 * figuras representadas en el agrupadas en un ArrayList
 * @author Óscar Climent Inglés 48784077L
 *
 */
public class Canvas {
	
	/**
	 * Atributo de clase
	 * Es el tamaño pos defevto de las dimensiones del lienzo
	 */
	public final static float DEFAULT_SIZE = 1000;
	
	/**
	 * Atributo de instancia
	 * El titulo del lienzo
	 */
	private String title;
	
	/**
	 * Atributo de Instancia 
	 * La ancura del lienzo
	 */
	private double width;
	
	/**
	 * Atributo de instancia
	 * La altura del lienzo
	 */
	private double height;
	
	/**
	 * Atributo de intancia
	 * Representa todas las figuras en el lienzo
	 */
	private ArrayList<Form2D> figures;
	
	
	/**
	 * Constructor por defecto
	 * Crea un lienzo De tamaño default
	 */
	public Canvas() {
		title = "default canvas";
		width = DEFAULT_SIZE;
		height = DEFAULT_SIZE;
		figures = new ArrayList<Form2D>();
	}
	
	/**
	 * Constructor de copia
	 * Crea un lienzo cuyos atributos coinciden con los de un lienzo pasado 
	 * @param canvas El lienzo a copiar
	 */
	public Canvas(Canvas canvas) {
		this.title = canvas.title;
		this.width = canvas.width;
		this.height = canvas.height;
		
		figures = new ArrayList<Form2D>();
		for(int i=0; i<canvas.getNumForms();i++) {
			figures.add(canvas.getForm(i));
		}
	}
	
	public Canvas(String title, double width, double height) {
		if(width>0 && height>0) {
			this.title = title;
			this.height = height;
			this.width = width;
		}
		else {
			throw new IllegalArgumentException();
		}
	}
	
	public void addForm(Form2D figure) {
		figures.add(figure);
	}
	
	public Canvas clone() {
		Canvas newCanvas = new Canvas(this.title,this.width,this.height);
		newCanvas.figures = this.figures;
		
		return newCanvas;
	}
	
	public double getWidth() {
		return width;
	}
	
	public double getHeight() {
		return height;
	}
	
	public int getNumForms() {
		return figures.size();
	}
	
	public Form2D getForm(int n) {
		n--;
		if(n<0 || n>=figures.size()) {
			throw new IndexOutOfBoundsException();
		}
		return figures.get(n);
	}
	
	public void removeForm(int n) {
		n--;
		if(n<0 || n>=figures.size()) {
			throw new IndexOutOfBoundsException();
		}
		else {
			figures.remove(n);
		}
	}
	
	public String toString() {
		return this.title + " (" + this.height + "," + this.width + ") with " + this.figures.size() + " forms";
	}
	
	
}
