package Vista;

import java.net.URL;
import java.util.ResourceBundle;

import Controlador.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControladoraInformes implements Initializable{

	//pantalla
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
		//elementos
		 @FXML
			private DatePicker FechaInicial;
		 @FXML
			private DatePicker FechaFinal;
		 @FXML
			private ComboBox<String> TipoDonante;
		@FXML
			private TextField volumentiposanguineo;
		@FXML
			private TextArea resultados;
		@FXML
		private Button Buscar;
		@FXML
		private Button Borrar;
		 
		 //comboboxañadir
			ObservableList<String>ListaTipo=FXCollections.observableArrayList();

			@Override
			public void initialize(URL arg0, ResourceBundle arg1) {
				//listaComboGrupoSanguineo
				ListaTipo.add("A+");
				ListaTipo.add("A-");
				ListaTipo.add("B+");
				ListaTipo.add("B-");
				ListaTipo.add("AB+");
				ListaTipo.add("AB-");
				ListaTipo.add("0+");
				ListaTipo.add("0-");
				TipoDonante.setItems(ListaTipo);
			}


			public Main getPaginaPrincipal() {
				return PaginaPrincipal;
			}


			public void setPaginaPrincipal(Main paginaPrincipal) {
				PaginaPrincipal = paginaPrincipal;
			}
		
			
			

}


