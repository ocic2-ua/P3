package es.ua.dlsi.prog3.p1;

import java.util.ArrayList;

/**
 * La clase SummaryStatics se dedica a calcular valores estadisticos básicos
 * a partir de la lista de enteros que almacena.
 * Calcula el máximo, el mínimo, la media y devuelve el número de elementos
 * @author Óscar Climent Inglés 	DNI:48784077L
 */
public class SummaryStatistics {
	
	/**
	 * Atributo de instancia
	 * Este atributo almacena el ID del próximo objeto de SummaryStatistics que se cree.
	 */
	private static int NEXT_ID=1;
	
	/**
	 * Atributo de clase
	 * Este atributo almacena el id de ese objeto
	 */
	private int id;
	
	/**
	 * Atributo de clase
	 * Este es el atributo que almacena en un array los numeros enteros con los que se realizarán la operacionoes estadísticas
	 */
	private ArrayList<Integer> values;
	
	
	/**
	 * Constructor por defecto
	 */
	public SummaryStatistics(){
		values = new ArrayList<Integer>();
		id = NEXT_ID;
		NEXT_ID++;
	}
	
	/**
	 * Es un contructor de sobrecarga
	 * Este método es un constructor que da valores al array de enteros en función
	 * de un array que se le pasa
	 * @param values : paso por valor
	 */
	public SummaryStatistics(ArrayList<Integer> values) {
		ArrayList<Integer> val = new ArrayList<Integer>();
		for(int i=0;i<values.size();i++) {
			val.add(values.get(i));
		}
		
		this.values=val;
		id = NEXT_ID;
		NEXT_ID++;
	}
	
	/**
	 * Es un constructor de copia profunda.
	 * Es un contructor que da valores al array de enteros copiandolo de otro
	 * objeto de la misma clase.
	 * @param s :paso por valor
	 */
	public SummaryStatistics(SummaryStatistics s){
		ArrayList<Integer> val = new ArrayList<Integer>();
		for(int i=0;i<s.values.size();i++) {
			val.add(s.values.get(i));
		}
		this.values=val;
		id = NEXT_ID;
		NEXT_ID++;
	}
	
	/**
	 * Es un método que añade un nuevo valor al array de enteros.
	 * Es un método de instancia. En este método se hace boxin por que pasa un valor int
	 * a Integer 
	 * @param value paso por referencia
	 */
	public void add(int value){
		values.add(value);
	}
	
	/**
	 * Es un método que devuelve el id del objeto en cuestion
	 * Es un método de instancia
	 * @return
	 */
	public int getId(){
		int id;
		id=this.id;
		
		return id;
	}
	
	/**
	 * Es un método que devuelve la media de todos los valores almacenados en
	 * el array. Suma todos los valores y los divide entre el total
	 * Es un método de instancia
	 * @return
	 */
	public Integer getAverage(){
		Integer average=null;
		int x=0;
		
		if(values.size()>0){
			for(int i=0; i<values.size();i++) {
				x = x + values.get(i);
			}
			average=x/values.size();
		}
		return average;
	}
	
	/**
	 * Es un método que devuelve el valor más pequeño del array de enteros
	 * Es un método de instancia
	 * @return
	 */
	public Integer getMin(){
		Integer min=null;
		
		if(values.size()>0){
			min=values.get(0);
			for(int i=0;i<values.size();i++) {
				min=Math.min(min, values.get(i));
			}
		}
		return min;
	}
	
	/**
	 * Es un método que devuelve el valor mas grande del array de enteros
	 * Es un método de instancia
	 * @return
	 */
	public Integer getMax() {
		Integer max=null;
		
		if(values.size()>0){
			max=values.get(0);
			for(int i=0;i<values.size();i++) {
				max=Math.max(max, values.get(i));
			}
		}
		return max;
	}
	
	/**
	 * Es un método que devuelve el tamaño del array de enteros
	 * Es un método de instancia
	 * @return
	 */
	public int getSize(){
		int size;
		size=this.values.size();
		
		return size;
	}
	
	/**
	 * Este método devuelve el número de objetos tipo SummaryStatistics creados
	 * Es un método de clase
	 * @return
	 */
	static public int COUNT_INSTANCES(){
		int instances;
		instances=NEXT_ID;
		instances--;
		
		return instances;
	}
}
