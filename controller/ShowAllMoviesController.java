package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import model.Catalogue;
import model.Kiosk;
import model.Movie;

public class ShowAllMoviesController extends Controller<Kiosk> {
   @FXML
   private TableView<Movie> MovieTv;
   @FXML
   private Button ExitBtn;

   @FXML
   public void initialize() {
      ObservableList<Movie> availableMovies =  Catalogue.getAllMovies();
      MovieTv.setItems(availableMovies);
   }

   @FXML
   private void ExitBot(ActionEvent var1) {
      Stage stage = (Stage) ExitBtn.getScene().getWindow();
      stage.close();
   }

   public final Kiosk getKiosk() {
      return (Kiosk)this.model;
   }
}