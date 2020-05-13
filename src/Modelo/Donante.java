package Modelo;


public class Donante {
	private int num_donante;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String DNI;
	private String aptitud;
	private String fecha_nacimiento;
	private int telefono;
	private int movil;
	private String tipo_sanguineo;
	private String pais_nacimiento;
	private String email;
	private int cp;
	private String provincia;
	private String poblacion;
	private String direccion;
	private char sexo;
	private String ciclo;
	
	
	public Donante(int num_donante, String nombre, String apellido1, String apellido2, String DNI, String aptitud,
			String fecha_nacimiento,int telefono, int movil,String tipo_sanguineo, String pais_nacimiento, String email, int cp, String provincia, String poblacion, String direccion,
			   char sexo, String ciclo) {
		super();
		this.num_donante = num_donante;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.DNI = DNI;
		this.aptitud = aptitud;
		this.fecha_nacimiento = fecha_nacimiento;
		this.telefono = telefono;
		this.movil = movil;
		this.tipo_sanguineo = tipo_sanguineo;
		this.pais_nacimiento = pais_nacimiento;
		this.email = email;
		this.cp = cp;
		this.provincia=provincia;
		this.poblacion = poblacion;
	
		this.direccion = direccion;
		this.sexo = sexo;
		this.ciclo=ciclo;
	}
	




	public int getNum_donante() {
		return num_donante;
	}


	public void setNum_donante(int num_donante) {
		this.num_donante = num_donante;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido1() {
		return apellido1;
	}


	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}


	public String getApellido2() {
		return apellido2;
	}


	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}


	public String getDni() {
		return DNI;
	}


	public void setDni(String dni, String DNI) {
		this.DNI = DNI;
	}


	public String getAptitud() {
		return aptitud;
	}


	public void setAptitud(String aptitud) {
		this.aptitud = aptitud;
	}


	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}


	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}




	public int getTelefono() {
		return telefono;
	}


	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}


	public int getMovil() {
		return movil;
	}


	public void setMovil(int movil) {
		this.movil = movil;
	}


	public String getTipo_sanguineo() {
		return tipo_sanguineo;
	}


	public void setTipo_sanguineo(String tipo_sanguineo) {
		this.tipo_sanguineo = tipo_sanguineo;
	}


	public String getPais_nacimiento() {
		return pais_nacimiento;
	}


	public void setPais_nacimiento(String pais_nacimiento) {
		this.pais_nacimiento = pais_nacimiento;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getCp() {
		return cp;
	}


	public void setCp(int cp) {
		this.cp = cp;
	}


	public String getprovincia() {
		return provincia;
	}


	public void setprovincia(String provincia) {
		this.provincia = provincia;
	}


	public String getPoblacion() {
		return poblacion;
	}


	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}




	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public char getSexo() {
		return sexo;
	}


	public void setSexo(char sexo) {
		this.sexo = sexo;
	}









	public String getCiclo() {
		return ciclo;
	}





	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}





	public String getProvincia() {
		return provincia;
	}





	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
	
	
	
	
	

}
