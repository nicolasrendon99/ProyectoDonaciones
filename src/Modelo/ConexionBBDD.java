package Modelo;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ToggleGroup;

public class ConexionBBDD {

	private String url= "jdbc:oracle:thin:@localhost:1521:XE";
	private String user = "";
	private String pwd = "";
	private String usr= "";
	private Connection conexion;


	public ConexionBBDD()  {
		Properties propiedades = new Properties();
		InputStream entrada = null;
		
		try {
			File miFichero = new File("src/Modelo/Datos.ini");
			if (miFichero.exists()){
				entrada = new FileInputStream(miFichero);
				propiedades.load(entrada);
				url=propiedades.getProperty("url");
				user=propiedades.getProperty("user");
				
				pwd=propiedades.getProperty("pwd");
				usr=propiedades.getProperty("usr");
				
			}

			else
				System.out.println("Fichero no encontrado");
		} catch (IOException ex) {
			ex.printStackTrace();
		}finally {
			if (entrada != null) {
				try {
					entrada.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conexion = DriverManager.getConnection(url, user, pwd);

				if(!conexion.isClosed()) {
					System.out.println("Conexión establecida");

					//conexion.close();
				}
				else
					System.out.println("Fallo en Conexión");


			}catch (Exception e) {
				System.out.println("ERROR en conexión con ORACLE");
				e.printStackTrace();
			}

		}

	//*************************METODOS APLICACION*****************************************
	
	//metodo bbddObtenerDonantes
	public ObservableList<Donante> MostrarTabla() throws SQLException{
		
		ObservableList<Donante> listadonantes = FXCollections.observableArrayList();

		//Preparo la conexión para ejecutar sentencias SQL de tipo update
		Statement stm = conexion.createStatement();

		// Preparo la sentencia SQL CrearTablaPersonas
		String selectsql = "SELECT * FROM "+ usr+".DONANTES";

		//ejecuto la sentencia
		try{
			ResultSet resultado = stm.executeQuery(selectsql);

			int contador = 0;
			while(resultado.next()){
				contador++;

				String num_donante = resultado.getString(1);
				String nombre = resultado.getString(2);
				String apellido1 = resultado.getString(3);
				String apellido2 = resultado.getString(4);
				String DNI=resultado.getString(5);
				String aptitud=resultado.getString(6);
				String fecha_nacimiento=resultado.getString(7);
				String telefono=resultado.getString(8);
				String movil=resultado.getString(9);
				String tipo_sanguineo =resultado.getString(10);
				String pais_nacimiento=resultado.getString(11);
				String email=resultado.getString(12);
				String cp=resultado.getString(13);
				String provincia=resultado.getString(14);
				String poblacion=resultado.getString(15);
				String direccion=resultado.getString(16);
				char sexo = resultado.getString(17).charAt(0);
				String ciclo =resultado.getString(18);
								
				Donante nuevo = new Donante(num_donante, nombre, apellido1, apellido2, DNI, aptitud, fecha_nacimiento, telefono, movil, tipo_sanguineo,  pais_nacimiento,  email, cp, provincia, poblacion, direccion,   sexo,   ciclo);
				listadonantes.add(nuevo);
			}

			if(contador==0)
				System.out.println("no data found");

		}catch(SQLException sqle){

			int pos = sqle.getMessage().indexOf(":");
			String codeErrorSQL = sqle.getMessage().substring(0,pos);

			System.out.println(codeErrorSQL);
		}

		return listadonantes;
	}
	/*
	 * El método InsertarDonante devuelve un código de error para los siguientes casos:
	 *
	 * 0 - Persona insertada OK!
	 * 1 - Se ha queriro introducir uan persona con un email existente (Primary key violated)
	 * 2 - Otro fallo en el tipo de datos o en la base de datos al hacer la inserción
	 *
	 *
	 */
	public int InsertarDonante(String num_donante, String nombre, String apellido1, String apellido2, String DNI, String aptitud,
				String fecha_nacimiento,String telefono, String movil,String tipo_sanguineo, String pais_nacimiento, String email, String cp, String provincia, String poblacion, String direccion,
				   char SEXO, String ciclo) throws SQLException{

		// Preparo la sentencia SQL CrearTablaPersonas
		String insertsql = "INSERT INTO " + usr+".DONANTES VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		//Seguridad en las Aplicaciones: SQL Injection

		PreparedStatement pstmt = conexion.prepareStatement (insertsql);
		pstmt.setString(1, num_donante);
		pstmt.setString(2, nombre);
		pstmt.setString(3, apellido1);
		pstmt.setString(4,apellido2);
		pstmt.setString(5,DNI);
		pstmt.setString(6,aptitud);
		pstmt.setDate(6,java.sql.Date.valueOf(fecha_nacimiento));
		pstmt.setString(8,telefono);
		pstmt.setString(9,movil);
		pstmt.setString(10,tipo_sanguineo);
		pstmt.setString(11,pais_nacimiento);
		pstmt.setString(12,email);
		pstmt.setString(13,cp);
		pstmt.setString(14,provincia);
		pstmt.setString(15, poblacion);
		pstmt.setString(16, direccion);
		pstmt.setString(17, Character.toString(SEXO));
		pstmt.setString(18,ciclo);
		
		
		
		//ejecuto la sentencia
		try{
			int resultado = pstmt.executeUpdate();//pstmt y tiene que estar vacio

			if(resultado != 1)
				System.out.println("Error en la inserción " + resultado);
			else
				System.out.println("Persona insertada con éxito");

			return 0;
		}catch(SQLException sqle){

			int pos = sqle.getMessage().indexOf(":");
			String codeErrorSQL = sqle.getMessage().substring(0,pos);

			if(codeErrorSQL.equals("ORA-00001") ){
				System.out.println("Ya existe una persona con  ese email");
				return 1;
			}
			else{
				System.out.println("Ha habido algún problema con  Oracle al hacer la insercion");
				return 2;
			}
			}
		}

		
		public int ModificarDonante(String num_donante, String nombre, String apellido1, String apellido2, String DNI, String aptitud,
				String fecha_nacimiento,String telefono, String movil,String tipo_sanguineo, String pais_nacimiento, String email, String cp, String provincia, String poblacion, String direccion,
				  char SEXO, String ciclo) throws SQLException{

			// Preparo la sentencia SQL CrearTablaPersonas
			String updatesql = "UPDATE " + usr+".DONANTES SET NOMBRE=?,APELLIDO1=?,APELLIDO2=?,DNI=?,FECHA_NACIMIENTO=?,PAIS_NACIMIENTO=?,DIRECCION=?,POBLACION=?,CODIGO_POSTAL=?,TELEFONO=?,TELEFONO2=?,CORREO_ELECTRONICO=?,SEXO=?,TIPO_SANGUINEO=?,FOTO=? WHERE NUM_DONANTE=?";

			//Seguridad en las Aplicaciones: SQL Injection

					PreparedStatement pstmt = conexion.prepareStatement (updatesql);
					pstmt.setString(1, num_donante);
					pstmt.setString(2, nombre);
					pstmt.setString(3, apellido1);
					pstmt.setString(4,apellido2);
					pstmt.setString(5,DNI);
					pstmt.setString(6,aptitud);
					pstmt.setString(7,fecha_nacimiento);
					pstmt.setString(8,telefono);
					pstmt.setString(9,movil);
					pstmt.setString(10,tipo_sanguineo);
					pstmt.setString(11,pais_nacimiento);
					pstmt.setString(12,email);
					pstmt.setString(13,cp);
					pstmt.setString(14,provincia);
					pstmt.setString(15,poblacion);
					pstmt.setString(16,direccion);
					pstmt.setString(17, Character.toString(SEXO));
					pstmt.setString(18,ciclo);

					
					
			//ejecuto la sentencia
			try{
				int resultado = pstmt.executeUpdate(); //pstmt y tiene que estar vacio

				if(resultado != 1)
					System.out.println("Error en la actualización " + resultado);
				else
					System.out.println("Persona actualizada con éxito!!!");

				return 0;
			}catch(SQLException sqle){

				int pos = sqle.getMessage().indexOf(":");
				String codeErrorSQL = sqle.getMessage().substring(0,pos);

				if(codeErrorSQL.equals("ORA-00001") ){
					System.out.println("Ya existe una persona con  ese email!!");
					return 1;
				}
				else{
					System.out.println("Ha habido algún problema con  Oracle al hacer la insercion");
					return 2;
				}

			}

		

	}

	
	//metodo bbddObtenerDonaciones
			public ObservableList<Donacion> bbddObtenerDonaciones() throws SQLException{

				ObservableList<Donacion> listadonantes = FXCollections.observableArrayList();

				//Preparo la conexión para ejecutar sentencias SQL de tipo update
				Statement stm = conexion.createStatement();

				// Preparo la sentencia SQL CrearTablaPersonas
				String selectsql = "SELECT * FROM "+ usr+".DONACIONES";

				//ejecuto la sentencia
				try{
					ResultSet resultado = stm.executeQuery(selectsql);

					int contador = 0;
					while(resultado.next()){
						contador++;

						int cod_donacion = resultado.getInt(1);
						String DNI = resultado.getString(2);
						String tipo = resultado.getString(3);
						String volumen = resultado.getString(4);
						String fecha = resultado.getString(5);
						String ultima_donacion=resultado.getString(6);
						
						Donacion nueva = new Donacion(cod_donacion,DNI,tipo,volumen,fecha,ultima_donacion);
						listadonantes.add(nueva);
					}

					if(contador==0)
						System.out.println("no data found");

				}catch(SQLException sqle){

					int pos = sqle.getMessage().indexOf(":");
					String codeErrorSQL = sqle.getMessage().substring(0,pos);

					System.out.println(codeErrorSQL);
				}

				return listadonantes;
			}
	
		

}