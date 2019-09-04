package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import model.Kiosk;
import model.Movie;

public class ShowAvailableMoviesController extends Controller<Kiosk> {
   @FXML
   private TableView<Movie> MovieTv;
   @FXML
   private Button ExitBtn;

   @FXML
   public void initialize() {
      this.MovieTv.setItems(this.getKiosk().getCatalogue().getAvailableMovies());
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