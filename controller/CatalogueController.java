package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.Kiosk;

public class CatalogueController extends Controller<Kiosk> {
   @FXML
   private Button AllMovieBtn;
   @FXML
   private Button AvaMovBtn;
   @FXML
   private Button MovByGenBtn;
   @FXML
   private Button MovByYearBtn;
   @FXML
   private Button RentMovBtn;
   @FXML
   private Button ReturnBtn;
   @FXML
   private Button ExitBtn;

   @FXML
   public void initialize() {
   }

   @FXML
   private void AllMovieBot(ActionEvent var1) throws Exception {
      ViewLoader.showStage(this.getKiosk(), "/view/ShowAllMovies.fxml", "AllCustomers", new Stage());
   }

   @FXML
   private void AvaMovBot(ActionEvent var1) throws Exception {
      ViewLoader.showStage(this.getKiosk(), "/view/ShowAvailableMovies.fxml", "Avaliable Movies", new Stage());
   }

   @FXML
   private void MovByGenBot(ActionEvent var1) throws Exception {
      ViewLoader.showStage(this.getKiosk(), "/view/ShowMoviesByGenre.fxml", "Movie by Genre", new Stage());
   }

   @FXML
   private void MovByYearBot(ActionEvent var1) throws Exception {
      ViewLoader.showStage(this.getKiosk(), "/view/ShowMoviesByYear.fxml", "Movie by Year", new Stage());
   }

   @FXML
   private void RentMovBot(ActionEvent var1) throws Exception {
      ViewLoader.showStage(this.getKiosk(), "/view/RentMovie.fxml", "Rent a Movie", new Stage());
   }

   @FXML
   private void ReturnBot(ActionEvent var1) throws Exception {
      ViewLoader.showStage(this.getKiosk(), "/view/ReturnMovie.fxml", "Return a Movie", new Stage());
   }

   @FXML
   private void ExitBot(ActionEvent var1) {
      Stage stage = (Stage) ExitBtn.getScene().getWindow();
      stage.close();
   }

   public final Kiosk getKiosk() {
      return model;
   }
}