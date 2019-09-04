package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import model.Kiosk;
import model.Movie;

public class ShowMoviesByYearController extends Controller<Kiosk> {
   @FXML
   private TableView<Movie> MovieTv;
   @FXML
   private ListView<Integer> MovieYearLv;
   @FXML
   private Button DisPlayBtn;
   @FXML
   private Button ExitBtn;

   @FXML
   public void initialize() {
      this.MovieYearLv.setItems(this.getKiosk().getCatalogue().getYears());
   }

   private Integer getSelectedGenre() {
      return (Integer)this.MovieYearLv.getSelectionModel().getSelectedItem();
   }

   @FXML
   private void handleGenre(ActionEvent var1) {
      Integer var2 = this.getSelectedGenre();
      this.MovieTv.setItems(this.getKiosk().getCatalogue().getMoviesByYear(this.getSelectedGenre()));
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