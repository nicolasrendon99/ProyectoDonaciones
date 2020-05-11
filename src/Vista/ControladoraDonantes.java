package Vista;

import java.io.File;
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
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class ControladoraDonantes {
	
	private Main ProgramaPrincipal;
		
		@FXML
		private Button buttonclose;

		private Stage ventana;

		public void setStagePrincipal(Stage ventana) {
			// TODO Auto-generated method stub
			this.ventana = ventana;
		}

		public void closeWindow(){
			this.ventana.close();
		}
		public void setProgramaPrincipal(Main ProgramaPrincipal) {
			// TODO Auto-generated method stub
			this.ProgramaPrincipal = ProgramaPrincipal;
		}

		//***********elementos************
		
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
		
		private Button Seleccionar_Imagen;
		@FXML
		private Button GENERARCARNET;
		@FXML
		private Button GUARDAR;
		@FXML
		private Button BORRAR;
		@FXML
		private Button ELIMINAR;
		
		//imagen
		@FXML
		private ImageView Imagen;
		private int position;
		private int maximo;
		private File file;
		
		@FXML
		private TextField txtf_ruta;
	
		//tabla
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
		private TableColumn<Donante,String> col_FECHA_NACIMIENTO;
		@FXML
		private TableColumn<Donante,String> col_PAIS_NACIMIENTO;
		@FXML
		private TableColumn<Donante,String> col_DIRECCION;
		@FXML
		private TableColumn<Donante,String> col_POBLACION;
		@FXML
		private TableColumn<Donante,Integer> col_CODIGO_POSTAL;
		@FXML
		private TableColumn<Donante,Integer> col_TELEFONO;
		@FXML
		private TableColumn<Donante,Integer> col_MOVIL;
		@FXML
		private TableColumn<Donante,String> col_EMAIL;
		@FXML
		private TableColumn<Donante,Character> col_SEXO;
		@FXML
		private TableColumn<Donante,String> col_TIPO_SANGUINEO;
		
		
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
				
				ConexionBBDD con = new ConexionBBDD();
				datos = con.bbddObtenerDonantes();

				tabla.setItems(datos);

				col_NUM_DONANTE.setCellValueFactory(new PropertyValueFactory<Donante,Integer>("NUM_DONANTE"));
				col_NOMBRE.setCellValueFactory(new PropertyValueFactory<Donante,String>("NOMBRE"));
				col_APELLIDO1.setCellValueFactory(new PropertyValueFactory<Donante,String>("APELLIDO1"));
				col_APELLIDO2.setCellValueFactory(new PropertyValueFactory<Donante,String>("APELLIDO2"));
				col_DNI.setCellValueFactory(new PropertyValueFactory<Donante,String>("DNI"));
				col_FECHA_NACIMIENTO.setCellValueFactory(new PropertyValueFactory<Donante,String>("FECHA_NACIMIENTO"));
				col_PAIS_NACIMIENTO.setCellValueFactory(new PropertyValueFactory<Donante,String>("PAIS_NACIMIENTO"));
				col_DIRECCION.setCellValueFactory(new PropertyValueFactory<Donante,String>("DIRECCION"));
				col_POBLACION.setCellValueFactory(new PropertyValueFactory<Donante,String>("POBLACION"));
				col_CODIGO_POSTAL.setCellValueFactory(new PropertyValueFactory<Donante,Integer>("CODIGO_POSTAL"));
				col_TELEFONO.setCellValueFactory(new PropertyValueFactory<Donante,Integer>("TELEFONO"));
				col_MOVIL.setCellValueFactory(new PropertyValueFactory<Donante,Integer>("MOVIL"));
				col_EMAIL.setCellValueFactory(new PropertyValueFactory<Donante,String>("EMAIL"));
				col_SEXO.setCellValueFactory(new PropertyValueFactory<Donante,Character>("SEXO"));
				col_TIPO_SANGUINEO.setCellValueFactory(new PropertyValueFactory<Donante,String>("TIPO_SANGUINEO"));
				
				

				// Al arrancar la vista se pone edicion a false
				setEdicion(false);
				setIndiceedicion(0);
				}

		public boolean isEdicion() {
			return edicion;
		}

		public void setEdicion(boolean edicion) {
			this.edicion = edicion;
		}

		public int getIndiceedicion() {
			return indiceedicion;
		}

		public void setIndiceedicion(int indiceedicion) {
			this.indiceedicion = indiceedicion;
		}

		public Button getSeleccionar_Imagen() {
			return Seleccionar_Imagen;
		}

		public void setSeleccionar_Imagen(Button seleccionar_Imagen) {
			Seleccionar_Imagen = seleccionar_Imagen;
		}

		public int getPosition() {
			return position;
		}

		public void setPosition(int position) {
			this.position = position;
		}

		public int getMaximo() {
			return maximo;
		}

		public void setMaximo(int maximo) {
			this.maximo = maximo;
		}

		public File getFile() {
			return file;
		}

		public void setFile(File file) {
			this.file = file;
		}

		public Main getStagePrincipal() {
			return ProgramaPrincipal;
		}

		public void setStagePrincipal(Main stagePrincipal) {
			ProgramaPrincipal = stagePrincipal;
		}

	
			
			}
		
