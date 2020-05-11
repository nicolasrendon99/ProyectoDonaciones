package Vista;

import java.sql.SQLException;

import Controlador.Main;
import Modelo.ConexionBBDD;
import Modelo.Donacion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ControladoraDonaciones {
	 private  Main PaginaPrincipal;
		
	
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
	        this.setPaginaPrincipal(ProgramaPrincipal);
	    }
		
		// Al presionar el botón de volver cierro VentanaTres y abro VentanDos
		public void Volver(){
			this.ventana.close();
			this.PaginaPrincipal.mostrarVentanaFormulario();

		}



		 
		//***********elementos************
		 @FXML
			private TextField COD_DONACION;
		 @FXML
			private TextField DNI;
		 @FXML
			private ComboBox<String> TIPO;
		 @FXML
			private DatePicker FECHA;
		 @FXML
			private DatePicker ULTIMA_DONACION;
		 @FXML
			private TextField TextFieldBuacarTipoDonacion;
		 @FXML
			private Button BotonbuscartipoDonacion;
		 @FXML
			private Button GUARDAR;
			@FXML
			private Button BORRAR;
			@FXML
			private Button ELIMINAR;
			
		 //tabla
		 @FXML
			private TableView<Donacion> tabla;
		 @FXML
			private TableColumn<Donacion,Integer> col_COD_DONACION;
		 @FXML
			private TableColumn<Donacion,String> col_DNI;
		 @FXML
			private TableColumn<Donacion,String> col_TIPO;
		 @FXML
			private TableColumn<Donacion,String> col_VOLUMEN;
		 @FXML
			private TableColumn<Donacion,String> col_FECHA;
		 @FXML
			private TableColumn<Donacion,String> col_ULTIMA_DONACION;
		
		 
		 
		 
		 //comboboxañadir
			ObservableList<String>ListaTipoDonacion=FXCollections.observableArrayList();
			
			
		//datos tabla
			ObservableList<Donacion> datos = FXCollections.observableArrayList();
			
		//Atributos necesarios para codificar la edicion
			private boolean edicion;
			private int indiceedicion;
			
	
			//inial al cargar
			public void initialize() throws SQLException{
			 //LitaTipoDonacion
			 ListaTipoDonacion.add("SANGRE");
			 ListaTipoDonacion.add("AFERESIS");
			 
			 ConexionBBDD con = new ConexionBBDD();
				datos = con.bbddObtenerDonaciones();

				tabla.setItems(datos);

				col_COD_DONACION.setCellValueFactory(new PropertyValueFactory<Donacion,Integer>("NUM_DONACION"));
				col_DNI.setCellValueFactory(new PropertyValueFactory<Donacion,String>("DNI"));
				col_TIPO.setCellValueFactory(new PropertyValueFactory<Donacion,String>("TIPO_DONACION"));
				col_VOLUMEN.setCellValueFactory(new PropertyValueFactory<Donacion,String>("VOLUMEN"));
				col_FECHA.setCellValueFactory(new PropertyValueFactory<Donacion,String>("FECHA"));
				col_ULTIMA_DONACION.setCellValueFactory(new PropertyValueFactory<Donacion,String>("ULTIMA_DONACION"));
				
				
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
			public Main getPaginaPrincipal() {
				return PaginaPrincipal;
			}
			public void setPaginaPrincipal(Main paginaPrincipal) {
				PaginaPrincipal = paginaPrincipal;
			}

}