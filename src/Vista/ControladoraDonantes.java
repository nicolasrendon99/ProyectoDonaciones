package Vista;




import java.sql.SQLException;

import Controlador.Main;
import Modelo.ConexionBBDD;
import Modelo.Donante;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


public class ControladoraDonantes {
	
	private  Main PaginaPrincipal;
	
	private Stage ventana;
	
	@FXML
	private Button buttonclose;
	
	@FXML
	private Button guardar;
	
	@FXML 
	private Button generar;
	
	@FXML 
	private Button eliminar;
	
	@FXML
	private Button modificar;
	
	@FXML
	private TextField NUM_DONANTE;
	@FXML
	private TextField NOMBRE;
	@FXML
	private TextField APELLIDO1;
	@FXML
	private TextField APELLIDO2;
	@FXML
	private TextField DNI;
	@FXML
	private TextField APTITUD;
	@FXML
	private DatePicker FECHA_NACIMIENTO;
	@FXML
	private TextField PAIS_NACIMIENTO;
	@FXML
	private ComboBox<String> GRUPO_SANGUINEO;
	@FXML
	private TextField POBLACION;
	@FXML
	private TextField DIRECCION;
	@FXML
	private TextField CODIGO_POSTAL;
	@FXML
	private TextField TELEFONO;
	@FXML
	private TextField MOVIL;
	@FXML
	private TextField EMAIL;
	@FXML
	private TextField CICLO;
	
	@FXML
	RadioButton H;
	@FXML
	RadioButton M;
	@FXML
	ToggleGroup SEXO;
	
	
	@FXML
	private TableView<Donante> tabla;
	
	@FXML
	private TableColumn<Donante,Integer> col_NUM_DONANTE;
	@FXML
	private TableColumn<Donante,String> col_NOMBRE;
	@FXML
	private TableColumn<Donante,String> col_APELLIDO1;
	@FXML
	private TableColumn<Donante,String> col_APELLIDO2;
	@FXML
	private TableColumn<Donante,String> col_DNI;
	@FXML
	private TableColumn<Donante,String> col_APTITUD;
	@FXML
	private TableColumn<Donante,String> col_FECHA_NACIMIENTO;
	@FXML
	private TableColumn<Donante,Integer> col_TELEFONO;
	@FXML
	private TableColumn<Donante,Integer> col_MOVIL;
	@FXML
	private TableColumn<Donante,String> col_TIPO_SANGUINEO;
	@FXML
	private TableColumn<Donante,String> col_PAIS_NACIMIENTO;
	@FXML
	private TableColumn<Donante,String> col_EMAIL;
	@FXML
	private TableColumn<Donante,Integer> col_CP;
	@FXML
	private TableColumn<Donante,String> col_PROVINCIA;
	@FXML
	private TableColumn<Donante,String> col_POBLACION;
	@FXML
	private TableColumn<Donante,String> col_DIRECCION;
	@FXML
	private TableColumn<Donante,Character> col_SEXO;
	@FXML
	private TableColumn<Donante,String> col_CICLO;
	
	
	//comboboxañadir
	
	ObservableList<String>ListacomboGrupoSanguineo=FXCollections.observableArrayList();
	
	//datos tabla
	ObservableList<Donante> datos = FXCollections.observableArrayList();

	// Atributos necesarios para codificar la edicion
	private boolean edicion;
	private int indiceedicion;
	
	//inial al cargar
	public void initialize() throws SQLException{
		//listaComboGrupoSanguineo
		
		ListacomboGrupoSanguineo.add("A+");
		ListacomboGrupoSanguineo.add("A-");
		ListacomboGrupoSanguineo.add("B+");
		ListacomboGrupoSanguineo.add("B-");
		ListacomboGrupoSanguineo.add("AB+");
		ListacomboGrupoSanguineo.add("AB-");
		ListacomboGrupoSanguineo.add("0+");
		ListacomboGrupoSanguineo.add("0-");
		GRUPO_SANGUINEO.setItems(ListacomboGrupoSanguineo);
		// Llamar a un método de la clase de manipulación de BBDD para que me devuelva un ObservableList<Persona> datos
		
		ConexionBBDD conxBBDD = new ConexionBBDD();
		datos = conxBBDD.bbddObtenerDonantes();

		tabla.setItems(datos);

		col_NUM_DONANTE.setCellValueFactory(new PropertyValueFactory<Donante,Integer>("NUM_DONANTE"));
		col_NOMBRE.setCellValueFactory(new PropertyValueFactory<Donante,String>("NOMBRE"));
		col_APELLIDO1.setCellValueFactory(new PropertyValueFactory<Donante,String>("APELLIDO1"));
		col_APELLIDO2.setCellValueFactory(new PropertyValueFactory<Donante,String>("APELLIDO2"));
		col_DNI.setCellValueFactory(new PropertyValueFactory<Donante,String>("DNI"));
		col_APTITUD.setCellValueFactory(new PropertyValueFactory<Donante,String>("APTITUD"));
		col_FECHA_NACIMIENTO.setCellValueFactory(new PropertyValueFactory<Donante,String>("FECHA_NACIMIENTO"));
		col_TELEFONO.setCellValueFactory(new PropertyValueFactory<Donante,Integer>("TELEFONO"));
		col_MOVIL.setCellValueFactory(new PropertyValueFactory<Donante,Integer>("MOVIL"));
		col_TIPO_SANGUINEO.setCellValueFactory(new PropertyValueFactory<Donante,String>("TIPO_SANGUINEO"));
		col_PAIS_NACIMIENTO.setCellValueFactory(new PropertyValueFactory<Donante,String>("PAIS_NACIMIENTO"));
		col_EMAIL.setCellValueFactory(new PropertyValueFactory<Donante,String>("EMAIL"));
		col_CP.setCellValueFactory(new PropertyValueFactory<Donante,Integer>("CODIGO_POSTAL"));
		col_PROVINCIA.setCellValueFactory(new PropertyValueFactory<Donante,String>("PROVINCIA"));
		col_POBLACION.setCellValueFactory(new PropertyValueFactory<Donante,String>("POBLACION"));
		col_DIRECCION.setCellValueFactory(new PropertyValueFactory<Donante,String>("DIRECCION"));
		col_SEXO.setCellValueFactory(new PropertyValueFactory<Donante,Character>("SEXO"));
		col_CICLO.setCellValueFactory(new PropertyValueFactory<Donante,String>("CICLO"));
		
		
		edicion = false;
		indiceedicion = 0;
		
}
	
	
			public Main getPaginaPrincipal() {
			return PaginaPrincipal;
		}
		public void setPaginaPrincipal(Main paginaPrincipal) {
			PaginaPrincipal = paginaPrincipal;
		}

		public void setStagePrincipal(Stage ventana) {
			// TODO Auto-generated method stub
			this.ventana = ventana;
		}
		public void closeWindow(){
			this.ventana.close();
		}

		public void setProgramaPrincipal(Main ProgramaPrincipal) {
	        this.setPaginaPrincipal(ProgramaPrincipal);
	    }


		

		public Main getStagePrincipal() {
			return PaginaPrincipal;
		}

		public void setStagePrincipal(Main stagePrincipal) {
			PaginaPrincipal = stagePrincipal;
		}

	
			
			}
		
