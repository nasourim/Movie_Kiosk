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

public class ReturnMovieController extends Controller<Kiosk> {
   @FXML
   private TextField SelectCusTf;
   @FXML
   private Button SelectCusBtn;
   @FXML
   private TableView<Movie> AvaMovTv;
   @FXML
   private Button RentMovBtn;
   @FXML
   private Button ExitBtn;
   @FXML
   private Label label1;

   private int Getid() {
      return Integer.parseInt(this.SelectCusTf.getText());
   }

   private Movie getSelectedAccount() {
      return (Movie)this.AvaMovTv.getSelectionModel().getSelectedItem();
   }

   @FXML
   public void initialize() {
      this.SelectCusTf.textProperty().addListener((var1, var2, var3) -> {
         this.SelectCusBtn.setDisable(this.getKiosk().getCustomer(this.Getid()) == null);
      });
      this.AvaMovTv.getSelectionModel().selectedItemProperty().addListener((var1, var2, var3) -> {
         this.RentMovBtn.setDisable(this.getSelectedAccount() == null);
      });
   }

   @FXML
   private void GetSelectCus(ActionEvent var1) {
      this.getKiosk().getCustomer(this.Getid());
      if (this.getKiosk().getCustomer(this.Getid()) != null) {
         this.AvaMovTv.setItems(this.getKiosk().getCustomer(this.Getid()).currentlyRented());
         System.out.println("You selected:");
      }

   }

   @FXML
   private void GetSelectMov(ActionEvent var1) {
      this.getKiosk().getCatalogue().returnMovieFromCustomer(this.getSelectedAccount(), this.getKiosk().getCustomer(this.Getid()));
      this.label1.setText("Movie return");
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