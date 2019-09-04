package controller;

import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.EventType;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.Catalogue;
import model.Kiosk;
import au.edu.uts.ap.javafx.Controller;

public class AddMovieController extends Controller<Kiosk> {
    @FXML
    private TextField TitleTf;
    @FXML
    private TextField YearTf;
    @FXML
    private TextField GenreTf;
    @FXML
    private TextField PriceTf;
    @FXML
    private Label label1;
    @FXML
    private Button ExitBtn;

    public AddMovieController() {
        super();
    }
    
    @FXML
    public void initialize() {
    }
    
    private String GetTitle() {
        return TitleTf.getText();
    }
    
    private int GetYear() {
        return Integer.parseInt(YearTf.getText());
    }
    
    private String GetGenre() {
        return GenreTf.getText();
    }
    
    private int GetPrice() {
        return Integer.parseInt(PriceTf.getText());
    }


    @FXML
    public void AddMovieBot(ActionEvent actionEvent) throws Exception {
        try {
            Catalogue cat = new Catalogue(new Kiosk());
            cat.addMovie(GetTitle(), GetYear(), GetGenre(), GetPrice());
            label1.setText("Movie added!");
        }
        catch (Exception ex) {
            label1.setText(ex.toString()+ex.getLocalizedMessage());
            ViewLoader.showStage((Object)ex, "/view/error.fxml", "error", new Stage());
        }
    }
    
    @FXML
    public void ExitBot( ActionEvent actionEvent) {
        Stage stage = (Stage) ExitBtn.getScene().getWindow();
        stage.close();
    }
    
    public final Kiosk getKiosk() {
        return this.model;
    }
}