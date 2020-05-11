package Modelo;

public class Donacion {

	private int cod_donacion;
	private String DNI;
	private String tipo;
	private String volumen;
	private String fecha;
	private String ultima_donacion;
	
	
	public Donacion(int cod_donacion, String dNI, String tipo, String volumen, String fecha, String ultima_donacion) {
		super();
		this.cod_donacion = cod_donacion;
		DNI = dNI;
		this.tipo = tipo;
		this.volumen = volumen;
		this.fecha = fecha;
		this.ultima_donacion = ultima_donacion;
	}


	public int getCod_donacion() {
		return cod_donacion;
	}


	public void setCod_donacion(int cod_donacion) {
		this.cod_donacion = cod_donacion;
	}


	public String getDNI() {
		return DNI;
	}


	public void setDNI(String dNI) {
		DNI = dNI;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getVolumen() {
		return volumen;
	}


	public void setVolumen(String volumen) {
		this.volumen = volumen;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public String getUltima_donacion() {
		return ultima_donacion;
	}


	public void setUltima_donacion(String ultima_donacion) {
		this.ultima_donacion = ultima_donacion;
	}
	
	
	
}
