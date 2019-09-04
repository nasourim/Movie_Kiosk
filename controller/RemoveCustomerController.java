package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import model.Customer;
import model.Kiosk;

public class RemoveCustomerController extends Controller<Kiosk> {
   @FXML
   private TableView<Customer> RmCustomerTv;
   @FXML
   private Button RmBtn;
   @FXML
   private Button ExitBtn;

   @FXML
   public void initialize() {
      ObservableList<Customer> allCustomers =  Kiosk.getCustomers();
      RmCustomerTv.setItems(allCustomers);
   }

   private Customer getSelectedMovie() {
      return RmCustomerTv.getSelectionModel().getSelectedItem();
   }

   @FXML
   private void RmCusBot(ActionEvent var1) {
      Kiosk.removeCustomer(getSelectedMovie());
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