package controller;

import au.edu.uts.ap.javafx.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.Kiosk;

public class KioskController extends Controller<Kiosk> {
   @FXML
   private Button adminBtn;
   @FXML
   private Button ExpCatBtn;
   @FXML
   private Button CusRecordBtn;
   @FXML
   private Button TopUpBtn;
   @FXML
   private Button FavBtn;
   @FXML
   private Button ExitBtn;

   @FXML
   public void initialize() {
   }

   @FXML
   private void adminBot(ActionEvent var1) throws Exception {
      ViewLoader.showStage(this.getKiosk(), "/view/Admin.fxml", "Admin", new Stage());
   }

   @FXML
   private void ExpCatBot(ActionEvent var1) throws Exception {
      ViewLoader.showStage(this.getKiosk(), "/view/Catalogue.fxml", "Catalogue", new Stage());
   }

   @FXML
   private void CusRecordBot(ActionEvent var1) throws Exception {
      ViewLoader.showStage(this.getKiosk(), "/view/CustomerRecord.fxml", "CustomerRecord", new Stage());
   }

   @FXML
   private void TopUpBot(ActionEvent var1) throws Exception {
      ViewLoader.showStage(this.getKiosk(), "/view/TopUpAccount.fxml", "FavouriteMovies", new Stage());
   }

   @FXML
   private void FavBot(ActionEvent var1) throws Exception {
      ViewLoader.showStage(this.getKiosk(), "/view/FavouriteMovies.fxml", "FavouriteMovies", new Stage());
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