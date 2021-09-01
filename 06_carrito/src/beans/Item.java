package beans;

public class Item {
	private String item;
	private int unidades;
	private double valor;
	
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public int getUnidades() {
		return unidades;
	}
	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public Item(String item, int unidades, double valor) {
		super();
		this.item = item;
		this.unidades = unidades;
		this.valor = valor;
	}
	@Override
	public String toString() {
		return "Item [" + item + " unidades: " + unidades + " precio: " + valor + "]";
	}
	
}
