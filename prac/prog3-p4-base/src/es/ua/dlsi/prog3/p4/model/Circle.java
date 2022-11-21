package es.ua.dlsi.prog3.p4.model;


/**
 * Representa una figura tipo circulo en el plano
 * Hereda atributo y tiene otro definido, el radio
 * @author Óscar Climent Inglés 48784077L
 *
 */
public class Circle extends Form2D{
	
	/**
	 * Atributo de clase
	 * El redion del circulo
	 */
	private double radius;
	
	/**
	 * ^Contructor por defecto
	 * Crea un objeto Circle De radio 0
	 */
	public Circle() {
		super();
		radius = 0;
	}
	
	/**
	 * Contructor de Copia
	 * Crea un objeto Circle copiando los artibutos de otro pasado por parametro
	 * @param circle El circulo a copiar
	 */
	public Circle(Circle circle) {
		super(circle);
		this.radius = circle.getRadius();
	}
	
	/**
	 * Contructor sobrecargado
	 * Crea un objeto Circle con atributos pasados por parametro
	 * @param position La posición del circulo
	 * @param radius El radio del circulo
	 * @param fillColor El color del circulo
	 */
	public Circle(Coordinate position, double radius, Color fillColor) {
		super(position,fillColor);
		this.radius = radius;
	}
	
	/**
	 * Método de instancia
	 * Devuelve la el radio del circulo
	 * @return radius
	 */
	public double getRadius(){
		return radius;
	}
	
	@Override
	public Form2D clone() {
		Circle circ = new Circle(this.getPosition(),radius,this.getFillColor());
		
		return circ;
	}

	@Override
	public void scale(double scale) {
		
		if(scale>0) {
			this.radius = this.radius*(scale/100);
		}
		else {
			throw new IllegalArgumentException();
		}
	}

	@Override
	public String toString() {
		return "(" + this.getPosition().getX() + "," + this.getPosition().getY() + "),fill=" + this.getFillColor() + ",radius=" + this.radius;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Circle other = (Circle) obj;
		return Double.doubleToLongBits(radius) == Double.doubleToLongBits(other.radius);
	}
	
}
