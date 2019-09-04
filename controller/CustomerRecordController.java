package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Kiosk;
import model.Movie;

import java.util.Objects;

public class CustomerRecordController extends Controller<Kiosk> {
   @FXML
   private TextField SelectCusTf;
   @FXML
   private Button SelectCusBtn;
   @FXML
   private TableView<Movie> RentHistoryTv;
   @FXML
   private TableView<Movie> CurrentRentTv;
   @FXML
   private Button ExitBtn;
   @FXML
   private Label label1;

   private int Getid() {
      return Integer.parseInt(this.SelectCusTf.getText());
   }

   @FXML
   public void initialize() {
//      this.SelectCusTf.textProperty().addListener((var1, var2, var3) -> {
//         this.SelectCusBtn.setDisable(this.getKiosk().getCustomer(this.Getid()) == null);
//      });
   }

   @FXML
   private void GetSelectCus(ActionEvent var1) {
      if (Kiosk.getCustomer(Getid()) != null) {
         this.RentHistoryTv.setItems(Objects.requireNonNull(Kiosk.getCustomer(this.Getid())).rentingHistory());
         this.CurrentRentTv.setItems(Objects.requireNonNull(Kiosk.getCustomer(this.Getid())).currentlyRented());
         this.label1.setText("" + Kiosk.getCustomer(this.Getid()));
         System.out.println("You selected:");
      }

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