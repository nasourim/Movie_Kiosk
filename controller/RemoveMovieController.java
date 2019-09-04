package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import model.Catalogue;
import model.Kiosk;
import model.Movie;

import java.net.URL;
import java.util.ResourceBundle;

public class RemoveMovieController extends Controller<Kiosk> {
   @FXML
   private TableView<Movie> RmMovieTv;
   @FXML
   private Button RmBtn;
   @FXML
   private Button ExitBtn;

   @FXML
   public void initialize() {
      ObservableList<Movie> availableMovies =  Catalogue.getAllMovies();
      RmMovieTv.setItems(availableMovies);
   }

   private Movie getSelectedMovie() {
      return RmMovieTv.getSelectionModel().getSelectedItem();
   }

   @FXML
   private void RmMovie(ActionEvent var1) {
      Catalogue.removeMovie(this.getSelectedMovie());
      initialize();
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