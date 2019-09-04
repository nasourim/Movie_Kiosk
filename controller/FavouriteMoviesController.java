package controller;

import javafx.beans.value.ObservableValue;
import java.io.IOException;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import model.Movie;
import javafx.scene.control.TableView;
import javafx.scene.control.Button;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.Kiosk;
import au.edu.uts.ap.javafx.Controller;

public class FavouriteMoviesController extends Controller<Kiosk> {
    @FXML
    private TextField SelectCusTf;
    @FXML
    private Button SelectCusBtn;
    @FXML
    private TableView<Movie> AvaMovTv;
    @FXML
    private Button ExitBtn;
    
    public FavouriteMoviesController() {
        super();
    }
    
    private int Getid() {
        return Integer.parseInt(this.SelectCusTf.getText());
    }
    
    @FXML
    public void initialize() {
        this.SelectCusTf.textProperty().addListener((observableValue, s, s2) -> this.SelectCusBtn.setDisable(this.getKiosk().getCustomer(this.Getid()) == null));
    }
    
    @FXML
    private void GetSelectCus(final ActionEvent actionEvent) throws IOException {
        try {
            Kiosk.getCustomer(this.Getid());
            if (Kiosk.getCustomer(this.Getid()) != null) {
                this.AvaMovTv.setItems(Kiosk.getCustomer(this.Getid()).favouriteMovies());
                System.out.println("You selected:");
            }
        }
        catch (Exception ex) {
            ViewLoader.showStage((Object)ex, "/view/error.fxml", "error", new Stage());
        }
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