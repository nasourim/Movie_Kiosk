package controller;

import au.edu.uts.ap.javafx.ViewLoader;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import model.Kiosk;
import au.edu.uts.ap.javafx.Controller;

public class AdminController extends Controller<Kiosk> {
    public Stage addMov = new Stage();
    @FXML
    private Button ViewCusBtn;
    @FXML
    private Button AddCusBtn;
    @FXML
    private Button RmCusBtn;
    @FXML
    private Button ViewMovBtn;
    @FXML
    private Button AddMovBtn;
    @FXML
    private Button RmMovBtn;
    @FXML
    private Button ExitBtn;
    
    public AdminController() {
        super();
    }
    
    @FXML
    public void initialize() {
    }
    
    @FXML
    private void ViewCusBot(final ActionEvent actionEvent) throws Exception {
        ViewLoader.showStage((Object)this.getKiosk(), "/view/ShowAllCustomers.fxml", "AllCustomers", new Stage());
    }
    
    @FXML
    private void AddCusBot(final ActionEvent actionEvent) throws Exception {
        ViewLoader.showStage((Object)this.getKiosk(), "/view/AddCustomer.fxml", "Add Customer", new Stage());
    }
    
    @FXML
    private void RmCusBot(final ActionEvent actionEvent) throws Exception {
        ViewLoader.showStage((Object)this.getKiosk(), "/view/RemoveCustomer.fxml", "RemoveCustomer", new Stage());
    }
    
    @FXML
    private void ViewMovBot(final ActionEvent actionEvent) throws Exception {
        ViewLoader.showStage((Object)this.getKiosk(), "/view/ShowAllMovies.fxml", "AllCustomers", new Stage());
    }
    
    @FXML
    private void AddMovBot(final ActionEvent actionEvent) throws Exception {
        ViewLoader.showStage((Object)this.getKiosk(), "/view/AddMovie.fxml", "Add Movie", new Stage());
    }
    
    @FXML
    private void RmMovBot(final ActionEvent actionEvent) throws Exception {
        ViewLoader.showStage((Object)this.getKiosk(), "/view/RemoveMovie.fxml", "Remove Movie", new Stage());
    }
    
    @FXML
    private void ExitBot(final ActionEvent actionEvent) {
        Stage stage = (Stage) ExitBtn.getScene().getWindow();
        stage.close();
    }
    
    public final Kiosk getKiosk() {
        return (Kiosk)this.model;
    }
}