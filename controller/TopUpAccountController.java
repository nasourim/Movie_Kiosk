package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Customer;
import model.Kiosk;

public class TopUpAccountController extends Controller<Kiosk> {
   @FXML
   private TextField SelectCusTf;
   @FXML
   private Button TopupBtn;
   @FXML
   private TextField AmountTf;
   @FXML
   private Button ExitBtn;
   @FXML
   private Label label1;

   private int Getid() {
      return Integer.parseInt(this.SelectCusTf.getText());
   }

   private int Getamount() {
      return Integer.parseInt(this.AmountTf.getText());
   }

   @FXML
   public void initialize() {
   }

   @FXML
   private void GetTOPup(ActionEvent var1) throws IOException {
      try {
         Customer custom = Kiosk.getCustomer(this.Getid());
         if (custom != null) {
            Kiosk.topUpAccount(custom, Getamount());
            System.out.println("You selected:");
            this.label1.setText("Transaction complete");
         }
      } catch (Exception var3) {
         ViewLoader.showStage(var3, "/view/error.fxml", "error", new Stage());
      }

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