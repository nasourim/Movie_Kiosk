package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Catalogue;
import model.Kiosk;
import model.Movie;

public class AddCustomerController extends Controller<Kiosk> {
   @FXML
   private TextField customerIdField,  nameField , balanceField;
   @FXML
   private Button ExitBtn;
   @FXML
   private Label label1;

   private int getCusID() {
      return Integer.parseInt(customerIdField.getText());
   }

   private String getCusName() {
      return nameField.getText();
   }

   private int getCusBalance() {
      return Integer.parseInt(balanceField.getText());
   }

   @FXML
   public void initialize() {
   }


   @FXML
   private void ExitBot(ActionEvent var1) {
      Stage stage = (Stage) ExitBtn.getScene().getWindow();
      stage.close();
   }



   @FXML
   private void addCustomer(ActionEvent actionEvent) throws Exception {
      try {
         Kiosk.addCustomer(getCusID(), getCusName(), getCusBalance() );
         label1.setText("Customer added!");
      }
      catch (Exception ex) {
         label1.setText(ex.toString()+ex.getLocalizedMessage());
         ViewLoader.showStage((Object)ex, "/view/error.fxml", "error", new Stage());
      }
   }
   public final Kiosk getKiosk() {
      return (Kiosk)this.model;
   }
}