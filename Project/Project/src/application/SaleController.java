package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class SaleController {

	ObservableList<String> Products = FXCollections.observableArrayList();
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> ProductNameCB;

    @FXML
    private TextField salePercentTXT;

    @FXML
    private Button confirmSaleBtn;
    
    @FXML
    void getProductNames(ActionEvent event) {
    	DbConnect db = new DbConnect();
		Connection con = db.getConnection();
		Statement stmt;
		try {
			stmt = con.createStatement();		
			String query = "Select `Name` from item";
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				if(!Products.contains(rs.getString(1))) {
					Products.add(rs.getString(1));
				}
			}
			ProductNameCB.setItems(Products);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void ConfirmSale(ActionEvent event) {
    	System.out.println("here");
    }

    @FXML
    void initialize() {
        assert ProductNameCB != null : "fx:id=\"ProductNameCB\" was not injected: check your FXML file 'Sale.fxml'.";
        assert salePercentTXT != null : "fx:id=\"salePercentTXT\" was not injected: check your FXML file 'Sale.fxml'.";
        assert confirmSaleBtn != null : "fx:id=\"confirmSaleBtn\" was not injected: check your FXML file 'Sale.fxml'.";

    }
}
