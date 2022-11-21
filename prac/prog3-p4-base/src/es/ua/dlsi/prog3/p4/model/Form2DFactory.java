package es.ua.dlsi.prog3.p4.model;

/**
 * Clase que se encraga de crear objetos tipo Form2D
 * @author Óscar Climent Inglés 48784077L
 *
 */
public class Form2DFactory {
	
	public static Form2D createForm2D(String figureName) {
		
		if(figureName == "Circle") {
			Circle circle = new Circle();
			return (Form2D)circle;
		}
		else if(figureName == "Rectangle") {
			Rectangle rectangle = new Rectangle();
			return (Form2D)rectangle;
		}
		else {
			throw new IllegalArgumentException();
		}
	}
}
