package Controlador;

import java.io.IOException;

import Vista.ControladoraDonaciones;
import Vista.ControladoraDonantes;
import Vista.ControladoraFormulario;
import Vista.ControladoraMenuprincipal;
import Vista.ControladoraInformes;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main  extends Application{

	 private static Stage stagePrincipal;
	    private AnchorPane rootPane;

	    @Override
	    public void start(Stage stagePrincipal) throws Exception {
	        Main.stagePrincipal = stagePrincipal;
	        mostrarUIMenuprincipal();

	    }


	    public static void main(String[] args) {
	        launch(args);
	    }

	    public void mostrarUIMenuprincipal() {
	        try {
	        	
	            FXMLLoader loader = new FXMLLoader(Main.class.getResource("../Vista/UIMenuPrincipal.fxml"));
	            rootPane=(AnchorPane) loader.load();
	            Scene scene = new Scene(rootPane);
	            stagePrincipal.setTitle("Ventana Principal");
	            stagePrincipal.setScene(scene);
	            
	             
	             ControladoraMenuprincipal controller = loader.getController();
	             controller.setProgramaPrincipal(this);

	            stagePrincipal.show();
	        } catch (IOException e) {
	         
	        }
	   }
    

	    public void mostrarVentanaDonante() {
	        try {
	            FXMLLoader loader = new FXMLLoader(Main.class.getResource("../vista/UIDonantes.fxml"));
	            AnchorPane ventanaDos = (AnchorPane) loader.load();
	   
	            Stage ventana = new Stage();
	            ventana.setTitle("Ventana Donantes");
	           
	            ventana.initOwner(stagePrincipal);
	            Scene scene = new Scene(ventanaDos);
	            ventana.setScene(scene);

	            ControladoraDonantes controller2 = loader.getController();
	            controller2.setStagePrincipal(ventana);
	            controller2.setProgramaPrincipal(this);

	            ventana.show();

	        } catch (Exception e) {
	            
	        }
	    }
	    
	
	    public void VentanaDonaciones() {
	        try {
	            FXMLLoader loader = new FXMLLoader(Main.class.getResource("../vista/UIDonaciones.fxml"));
	            AnchorPane ventana3 = (AnchorPane) loader.load();
	          
	            Stage ventana = new Stage();
	             ventana.setTitle("Ventana Donaciones");
	         
	            ventana.initOwner(stagePrincipal);
	            Scene scene = new Scene(ventana3);
	            ventana.setScene(scene);

	            ControladoraDonaciones controller2 = loader.getController();
	            controller2.setStagePrincipal(ventana);
	            controller2.setProgramaPrincipal(this);

	            ventana.show();

	        } catch (Exception e) {
	       
	        }
	    }
	    
	  
	    public void mostrarVentanainformes() {
	        try {
	            FXMLLoader loader = new FXMLLoader(Main.class.getResource("../vista/UIinformes.fxml"));
	            AnchorPane ventana4 = (AnchorPane) loader.load();
	            
	            Stage ventana = new Stage();
	            ventana.setTitle("Ventana Informes");
	           
	            ventana.initOwner(stagePrincipal);
	            Scene scene = new Scene(ventana4);
	            ventana.setScene(scene);

	            ControladoraInformes controller2 = loader.getController();
	            controller2.setStagePrincipal(ventana);
	            ventana.show();

	        } catch (Exception e) {
	        }
	        }
	        public void mostrarVentanaFormulario() {
		        try {
		            FXMLLoader loader = new FXMLLoader(Main.class.getResource("../vista/UIFormulario.fxml"));
		            AnchorPane ventanaDos = (AnchorPane) loader.load();
		            
		            Stage ventana = new Stage();
		            ventana.setTitle("Ventana formulario");
		           
		            ventana.initOwner(stagePrincipal);
		            Scene scene = new Scene(ventanaDos);
		            ventana.setScene(scene);

		            ControladoraFormulario controller2 = loader.getController();
		            controller2.setStagePrincipal(ventana);

		            ventana.show();

		        } catch (Exception e) {
	    }
	        
		           
	        }
	  
	    }
	    
	   