package Modelo;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ConexionBBDD {

	private String url= "jdbc:oracle:thin:@localhost:1521:XE";
	private String usr = "";
	private String pwd = "";
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
				usr=propiedades.getProperty("usr");
				
				pwd=propiedades.getProperty("pwd");
				
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
				conexion = DriverManager.getConnection(url, usr, pwd);

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
	public ObservableList<Donante> bbddObtenerDonantes() throws SQLException{
		
		ObservableList<Donante> listadonantes = FXCollections.observableArrayList();

		//Preparo la conexión para ejecutar sentencias SQL de tipo update
		Statement stm = conexion.createStatement();

		// Preparo la sentencia SQL CrearTablaPersonas
		String selectsql = "SELECT * FROM "+ usr+".DONANTE";

		//ejecuto la sentencia
		try{
			ResultSet resultado = stm.executeQuery(selectsql);

			int contador = 0;
			while(resultado.next()){
				contador++;

				int num_donante = resultado.getInt(1);
				String nombre = resultado.getString(2);
				String apellido1 = resultado.getString(3);
				String apellido2 = resultado.getString(4);
				String DNI=resultado.getString(5);
				String aptitud=resultado.getString(6);
				String fecha_nacimiento=resultado.getString(7);
				String pais_nacimiento=resultado.getString(8);
				String direccion=resultado.getString(9);
				String provincia=resultado.getString(10);
				String poblacion=resultado.getString(11);
				String residencia=resultado.getString(12);
				int cp=resultado.getInt(13);
				int telefono=resultado.getInt(14);
				int movil=resultado.getInt(15);
				String email=resultado.getString(16);
				char sexo = resultado.getString(17).charAt(0);
				String tipo_sanguineo =resultado.getString(18);
				Blob FOTO=resultado.getBlob(19);
								
				Donante nuevo = new Donante(num_donante, nombre, apellido1, apellido2, DNI, aptitud, fecha_nacimiento, pais_nacimiento, provincia, poblacion, residencia, cp, telefono, movil ,email, sexo, direccion,  tipo_sanguineo, FOTO);
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

	
	//metodo bbddObtenerDonaciones
			public ObservableList<Donacion> bbddObtenerDonaciones() throws SQLException{

				ObservableList<Donacion> listadonantes = FXCollections.observableArrayList();

				//Preparo la conexión para ejecutar sentencias SQL de tipo update
				Statement stm = conexion.createStatement();

				// Preparo la sentencia SQL CrearTablaPersonas
				String selectsql = "SELECT * FROM "+ usr+".DONACION";

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