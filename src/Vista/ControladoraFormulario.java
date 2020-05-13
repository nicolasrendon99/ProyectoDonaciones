package Vista;


import Controlador.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControladoraFormulario {

	private Main PaginaPrincipal;

	@FXML
	private Button buttonclose;
	
	@FXML
	private Button continuar;
	
	@FXML 
	private Button eliminar;


	private Stage ventana;

	public void setProgramaPrincipal(Main ProgramaPrincipal) {
        this.PaginaPrincipal = ProgramaPrincipal;
    }

	public void setStagePrincipal(Stage ventana) {
		// TODO Auto-generated method stub
		this.ventana = ventana;
	}

	public void closeWindow(){
		this.ventana.close();
	}

	public void AbrirVentanaDonaciones(){
		this.PaginaPrincipal.VentanaDonaciones();
		this.ventana.close();
	}


	public Controlador.Main getPaginaPrincipal() {
		return PaginaPrincipal;
	}

	public void setPaginaPrincipal(Controlador.Main paginaPrincipal) {
		PaginaPrincipal = paginaPrincipal;
	}

	public Button getContinuar() {
		return continuar;
	}

	public void setContinuar(Button continuar) {
		this.continuar = continuar;
	}




}

