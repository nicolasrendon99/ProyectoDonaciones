package Vista;




import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

import Controlador.Main;
import Modelo.ConexionBBDD;
import Modelo.Donante;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
	private TextField PROVINCIA;
	@FXML
	private TextField POBLACION;
	@FXML
	private TextField DIRECCION;
	@FXML
	private TextField CP;
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
	private TableColumn<Donante,String> col_NUM_DONANTE;
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
	private TableColumn<Donante,String> col_TELEFONO;
	@FXML
	private TableColumn<Donante,String> col_MOVIL;
	@FXML
	private TableColumn<Donante,String> col_TIPO_SANGUINEO;
	@FXML
	private TableColumn<Donante,String> col_PAIS_NACIMIENTO;
	@FXML
	private TableColumn<Donante,String> col_EMAIL;
	@FXML
	private TableColumn<Donante,String> col_CP;
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
	ObservableList<Donante> datos ;

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
				
				datos= FXCollections.observableArrayList();
				
				ConexionBBDD con = new ConexionBBDD();
				datos = con.MostrarTabla();

				tabla.setItems(this.datos);

				col_NUM_DONANTE.setCellValueFactory(new PropertyValueFactory<Donante,String>("num_donante"));
				col_NOMBRE.setCellValueFactory(new PropertyValueFactory<Donante,String>("nombre"));
				col_APELLIDO1.setCellValueFactory(new PropertyValueFactory<Donante,String>("apellido1"));
				col_APELLIDO2.setCellValueFactory(new PropertyValueFactory<Donante,String>("apellido2"));
				col_DNI.setCellValueFactory(new PropertyValueFactory<Donante,String>("DNI"));
				col_APTITUD.setCellValueFactory(new PropertyValueFactory<Donante,String>("aptitud"));
				col_FECHA_NACIMIENTO.setCellValueFactory(new PropertyValueFactory<Donante,String>("fecha_nacimiento"));
				col_TELEFONO.setCellValueFactory(new PropertyValueFactory<Donante,String>("telefono"));
				col_MOVIL.setCellValueFactory(new PropertyValueFactory<Donante,String>("movil"));
				col_TIPO_SANGUINEO.setCellValueFactory(new PropertyValueFactory<Donante,String>("tipo_sanguineo"));
				col_PAIS_NACIMIENTO.setCellValueFactory(new PropertyValueFactory<Donante,String>("pais_nacimiento"));
				col_EMAIL.setCellValueFactory(new PropertyValueFactory<Donante,String>("email"));
				col_CP.setCellValueFactory(new PropertyValueFactory<Donante,String>("cp"));
				col_PROVINCIA.setCellValueFactory(new PropertyValueFactory<Donante,String>("provincia"));
				col_POBLACION.setCellValueFactory(new PropertyValueFactory<Donante,String>("poblacion"));
				col_DIRECCION.setCellValueFactory(new PropertyValueFactory<Donante,String>("direccion"));
				col_SEXO.setCellValueFactory(new PropertyValueFactory<Donante, Character>("sexo"));
				col_CICLO.setCellValueFactory(new PropertyValueFactory<Donante,String>("ciclo"));
				
				
				
				
}
	public void Guardar() throws SQLException, FileNotFoundException{
		char SEXO;

		if(H.isSelected()) {
			SEXO = 'H';
		}else {
			SEXO = 'M';
		}

		// Añadir un chequeo de campos vacíos o de validación de formato como el email
		if(NUM_DONANTE.getText().equals("") || NOMBRE.getText().equals("") || APELLIDO1.getText().equals("") || APELLIDO2.getText().equals("") || DNI.getText().equals("") || DIRECCION.getText().equals("") || POBLACION.getText().equals("") || CP.getText().equals("") || TELEFONO.getText().equals("") || MOVIL.getText().equals("") || EMAIL.getText().equals("") ){
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error!!!");
			alert.setHeaderText("No se han introducido todos los datos");
			alert.setContentText("¡No se pueden grabar campos vacíos!");
			alert.showAndWait();
		}
		else{

			if(edicion == true){

				// Hago la llamda al método que hace el update en la base de datos
				ConexionBBDD con = new ConexionBBDD();
				
				DateTimeFormatter isoFecha = DateTimeFormatter.ISO_LOCAL_DATE;
				String fcita = FECHA_NACIMIENTO.getValue().format(isoFecha);
				
				
				int res = con.ModificarDonante(NUM_DONANTE.getText(), NOMBRE.getText(), APELLIDO1.getText(), APELLIDO2.getText(), DNI.getText(), APTITUD.getText(), fcita, TELEFONO.getText(), MOVIL.getText(), GRUPO_SANGUINEO.getValue(), PAIS_NACIMIENTO.getText(), EMAIL.getText(), CP.getText(), PROVINCIA.getText(), POBLACION.getText(), DIRECCION.getText(), SEXO, CICLO.getText() );
				switch (res){

					case 0:
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("OK!");
						alert.setHeaderText("Modificación OK!");
						alert.setContentText("¡Persona modificada con éxito!");
						alert.showAndWait();

						// Actualizo los datos de la tabla
						datos = con.MostrarTabla();
						tabla.setItems(datos);
						break;

					default:
							alert = new Alert(AlertType.ERROR);
							alert.setTitle("Error!");
							alert.setHeaderText("Modificación NOK!");
							alert.setContentText("¡Ha habido un problema al realizar el update!");
							alert.showAndWait();
							break;

						}




			}
			else{
				// Realizar el insertado de datos en la base de datos
				ConexionBBDD con = new ConexionBBDD();
				
				DateTimeFormatter isoFecha = DateTimeFormatter.ISO_LOCAL_DATE;
				String fcita = FECHA_NACIMIENTO.getValue().format(isoFecha);
				
				
				int res = con.InsertarDonante(NUM_DONANTE.getText(), NOMBRE.getText(), APELLIDO1.getText(), APELLIDO2.getText(), DNI.getText(), APTITUD.getText(), fcita, TELEFONO.getText(), MOVIL.getText(), GRUPO_SANGUINEO.getValue(), PAIS_NACIMIENTO.getText(), EMAIL.getText(), CP.getText(), PROVINCIA.getText(), POBLACION.getText(), DIRECCION.getText(), SEXO, CICLO.getText()  );
				
			
				switch (res){

				case 0:
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("OK!");
					alert.setHeaderText("Inserción OK!");
					alert.setContentText("¡Persona insertada con éxito!");
					alert.showAndWait();

					// Actualizo los datos de la tabla
					datos = con.MostrarTabla();
					tabla.setItems(datos);
					break;

				case 1:
					alert = new Alert(AlertType.WARNING);
					alert.setTitle("Aviso!");
					alert.setHeaderText("Inserción NOK!");
					alert.setContentText("¡Ya existe una persona con ese email!");
					alert.showAndWait();
					break;

				default:
					alert = new Alert(AlertType.ERROR);
					alert.setTitle("Error!");
					alert.setHeaderText("Inserción NOK!");
					alert.setContentText("¡Ha habido un problema al realizar la inserción!");
					alert.showAndWait();
					break;

				}

			}


			}

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
		
