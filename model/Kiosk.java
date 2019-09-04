package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Kiosk {
    
    private static model.Catalogue catalogue = null;
    private static ObservableList<model.Customer> customers = null;
    
    public Kiosk() {
        
        catalogue = new model.Catalogue(this);
        customers = FXCollections.observableArrayList();
        
        //database of customers
        customers.add(new model.Customer(101, "Jaime", 10));
        customers.add(new model.Customer(102, "Luke", 10));
        customers.add(new model.Customer(103, "William", 1));
        
    }
    
    public static void addCustomer(int id, String name, int balance) {
        customers.add(new model.Customer(id, name, balance));
    }

        
    public static void topUpAccount(model.Customer customer, int topUpAmount) {
        if (topUpAmount > 0 ) {
            customer.topUpAccount(topUpAmount);
        }       
    }

    public static ObservableList<model.Customer> getCustomers() {
        return customers;
    }
 
    public static model.Customer getCustomer(int id) {
        
        for (model.Customer p : customers) {
            if (p.getId() ==  id) return p;
        }
        
        return null;
    }

    public static void removeCustomer(model.Customer customer) {
       customers.remove(customer);
    }
    
    public static model.Catalogue getCatalogue() {
        return catalogue;
    }

}
