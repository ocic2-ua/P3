package es.ua.dlsi.prog3.p4.model;

import java.util.Objects;

/**
 * Form2D representa un objeto en 2 dimensiones
 * Es abstracta la clase y puede ser un rectangulo o un circulo
 * Tiene un posicion y un color de relleno
 * @author Óscar Climent Inglés 48784077L
 *
 */
public abstract class Form2D {
	
	/**
	 * Atributo de instancia 
	 * Representa la posición de la figura
	 */
	private Coordinate position;
	
	/**
	 * Atributo de instancia 
	 * Representa el color de relleno
	 */
	private Color fillColor;
	
	
	/**
	 * Constructor por defecto
	 * Da una posición inválida y color nulo
	 */
	protected Form2D() {
		position = new Coordinate();
		fillColor = Color.none;
	}
	
	/**
	 * Constrructor de copia
	 * Crea un objeto copia de otro pasado por parametro
	 * @param form Objeto a copiar
	 */
	protected Form2D(Form2D form) {
		
		position = form.getPosition();
		fillColor = form.getFillColor();
	}
	
	/**
	 * Constructor sobrecargado
	 * Crea un objeto con los atributos pasados por párametro
	 * @param position Coordenadas del obejto
	 * @param fillColor Color de relleno
	 */
	protected Form2D(Coordinate position, Color fillColor) {
		this.position = position;
		this.fillColor = fillColor;
	}
	
	/**
	 * Método de instancia
	 * Devuelve la posición del objeto
	 * @return position
	 */
	public Coordinate getPosition() {
		return this.position;
	}
	
	/**
	 * Método de instancia
	 * Devuelve la el color del objeto
	 * @return fillColor
	 */
	public Color getFillColor(){
		return this.fillColor;
	}
	
	/**
	 * Método de intancia
	 * Cambia el color de la figura
	 * @param color El color al que cambiar
	 */
	public void setFillColor(Color color) {
		this.fillColor = color;
	}
	
	/**
	 * Método de intancia 
	 * Cambia la posición de la figura y devuleve la posición anterior
	 * @param moveTo La posición a la que se cambia
	 * @return actual (donde estaba)
	 */
	public Coordinate move(Coordinate moveTo) {
		
		Coordinate actual;
		actual = this.position;
		
		if(moveTo!=null) {
			this.position = moveTo;
		}
		
		return actual;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Form2D other = (Form2D) obj;
		return fillColor == other.fillColor && Objects.equals(position, other.position);
	}

	@Override
	public String toString() {
		return "(" + position.getX() + "," + position.getY() + "),fill=" + fillColor;
	}
	
	/**
	 * Método de instancia
	 * Crea una copia de la figura en una posición determinada por parametro y la devuleve
	 * @param position La posición donde se crea la figura
	 * @return La copia de la figura
	 */
	public Form2D clone(Coordinate position) {
		Form2D newform = (Form2D) clone();
		newform.move(position);
		
		return newform;
	}
	
	/**
	 * Metodo de instancia 
	 * Crea una copia de la figura ya la devulve
	 * Se define en la subclase
	 */
	public abstract Form2D clone();
	
	/**
	 * MEtodo de instancia
	 * Escala el tamaño de la figura 
	 * Se define en la subclase
	 * @param scale
	 */
	public abstract void scale(double scale);
}
