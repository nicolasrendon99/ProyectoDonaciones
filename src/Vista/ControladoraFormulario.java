package Vista;


import Controlador.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControladoraFormulario {

	private  Controlador.Main PaginaPrincipal;

	@FXML
	private Button buttonclose;
private Button continuar;


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

	public void AbrirVentana3(){
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

