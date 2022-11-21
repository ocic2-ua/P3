package es.ua.dlsi.prog3.p4.model;

/**
 * Representa una figura tipo rectangulo en el plano
 * Hereda atributo y tiene dos definido, la longitud y la altura
 * @author Óscar Climent Inglés 48784077L
 *
 */
public class Rectangle extends Form2D{
	
	/**
	 * Atributo de clase
	 * La longitud
	 */
	private double length;
	
	/**
	 * atributo de clase
	 * La altura
	 */
	private double width;
	
	
	/**
	 * Contructor por defecto
	 * Crea un rectangulo cuyos atributos son 0
	 */
	public Rectangle(){
		super();
		length=0;
		width=0;
	}
	
	/**
	 * Constructor de copia
	 * Crea un ojbeto tipo Rectangle copiando los atributos de otro pasado
	 * @param rectangle El rectangulo que copiar
	 */
	public Rectangle(Rectangle rectangle){
		super(rectangle);
		this.length = rectangle.getLength();
		this.width = rectangle.getWidth();
	}
	
	/**
	 * Contructor Sobrecargado
	 * Crea un objeto tipo Rectangle cuyos atributos son valores pasados por parametro
	 * @param position La posisición del rectangulo
	 * @param length La longitud
	 * @param width La altura
	 * @param fillColor El color de relleno
	 */
	public Rectangle(Coordinate position, double length, double width, Color fillColor){
		super(position,fillColor);
		this.length = length;
		this.width = width;
	}
	
	/**
	 * Método de intancia
	 * Devuleve la longitud
	 * @return length
	 */
	public double getLength() {
		return this.length;
	}
	
	/**
	 * Método de intancia
	 * Devuleve la altura
	 * @return width
	 */
	public double getWidth() {
		return this.width;
	}
	@Override
	public Form2D clone() {
		Rectangle rec = new Rectangle(this.getPosition(),length,width,this.getFillColor());
		
		return rec;
	}

	@Override
	public void scale(double scale) {
		if(scale>0) {
			this.length = this.length *(scale/100);
			this.width = this.width *(scale/100);
		}
		else {
			throw new IllegalArgumentException();
		}
	}
	
	@Override
	public String toString() {
		return "(" + this.getPosition().getX() + "," + this.getPosition().getY() + "),fill=" + this.getFillColor() + ",length=" + this.length + ",width=" + this.width;
	}
}
