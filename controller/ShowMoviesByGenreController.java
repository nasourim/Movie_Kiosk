package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import model.Catalogue;
import model.Genre;
import model.Kiosk;
import model.Movie;

import java.util.Observable;

public class ShowMoviesByGenreController extends Controller<Kiosk> {
   @FXML
   private TableView<Movie> MovieTv;
   @FXML
   private ListView<Genre> MovieLv;
   @FXML
   private Button DisPlayBtn;
   @FXML
   private Button ExitBtn;

   @FXML
   public void initialize() {
      ObservableList<Genre> genres = Catalogue.getGenres();
      MovieLv.setItems(genres);
      System.out.println(genres.toString());
//      ObservableList<Movie> moviesForThisGenre = Catalogue.getMoviesInGenre(getSelectedGenre());
//      System.out.println(moviesForThisGenre.toString());
//      MovieTv.setItems(moviesForThisGenre);
   }

   private Genre getSelectedGenre() {
      return MovieLv.getSelectionModel().getSelectedItem();
   }

   @FXML
   private void handleGenre(ActionEvent var1) {
      ObservableList<Movie> moviesForThisGenre = Catalogue.getMoviesInGenre(getSelectedGenre());
      MovieTv.setItems(moviesForThisGenre);
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