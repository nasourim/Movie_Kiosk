package au.edu.uts.ap.javafx;
import model.*;
import java.io.IOException;

import controller.KioskController;
import javafx.scene.Scene;
import javafx.util.BuilderFactory;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;


public class Controller<Catalogue> {
    protected Catalogue model;
    protected Stage stage;
    public Controller(){
        super();
    }
    public void setModel(Catalogue cat){
        model = cat;
    }
    public void setStage(Stage cat){
        stage = cat;
    }
}
