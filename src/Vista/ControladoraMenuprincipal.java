package Vista;

import java.net.URL;
import java.util.ResourceBundle;

import Controlador.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class ControladoraMenuprincipal implements Initializable {
	
	 private  Main ProgramaPrincipal;

	 	@FXML
		private Button Donantes;
		
		@FXML
		private Button Donaciones;
		
		
		
		@FXML
		private Button Informes;
		
		 public void setProgramaPrincipal(Main ProgramaPrincipal) {
		     this.ProgramaPrincipal = ProgramaPrincipal;
		  }


		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Apéndice de método generado automáticamente
			
		}
	    @FXML
	    private void abrirVentanaDonante() {
	       	this.ProgramaPrincipal.mostrarVentanaDonante();
	    }
	    @FXML
	    private void abrirVentanaDonacion() {
	       	this.ProgramaPrincipal.mostrarVentanaFormulario();
	    }
	    @FXML
	    private void abrirVentanaInformes() {
	       	this.ProgramaPrincipal.mostrarVentanainformes();
	    }

	    @FXML
	    private void abrirVentanaFormulario() {
	       	this.ProgramaPrincipal.mostrarVentanaFormulario();
	    }

	
	   
	    
}