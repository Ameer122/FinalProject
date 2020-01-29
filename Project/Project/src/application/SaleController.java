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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class SaleController {

	ObservableList<String> Products = FXCollections.observableArrayList();
	ObservableList<String> ProductID = FXCollections.observableArrayList();
	
	@FXML
    private ComboBox<String> ProductNameCB;

    @FXML
    private ComboBox<String> ProductIDCB;

    @FXML
    private Pane SelectionPane;

    @FXML
    private Button SelectNameBtn;

    @FXML
    private TextField salePercent1TXT;

    @FXML
    private Button Selectid;

    @FXML
    private Pane ProductNamePane;

    @FXML
    private Pane ProductIDPane;

    @FXML
    private Button confirmSaleBtn;

    @FXML
    private Button CancelBtn;

    @FXML
    private TextField salePercentTXT2;
    
	@FXML
	private Label storeNIDLBL;
	
	@FXML
	private TextField StoreNIDTXT;
	
	@FXML
	private Label storeNNameLBL;
	
	@FXML
	private TextField StoreNNameTXT;
	
	@FXML
    private Label confirmationLBL;
	
    @FXML
    void ReturnToMain(ActionEvent event) {
    	salePercent1TXT.clear();
    	salePercentTXT2.clear();
    	confirmationLBL.setText("");
    	StoreNIDTXT.clear();
    	StoreNNameTXT.clear();
    	ProductNameCB.getSelectionModel().clearAndSelect(0);
    	ProductIDCB.getSelectionModel().clearAndSelect(0);
    	ProductNamePane.setVisible(false);
    	ProductIDPane.setVisible(false);
    	CancelBtn.setVisible(false);
    	confirmSaleBtn.setVisible(false);
    	SelectionPane.setVisible(true);   	
    }
    
    @FXML
    void getProductIDs(ActionEvent event){
    	DbConnect db = new DbConnect();
		Connection con = db.getConnection();
		Statement stmt;
		try {
			stmt = con.createStatement();		
			String query = "Select `ID` from item";
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				if(!ProductID.contains(rs.getString(1))) {
					ProductID.add(rs.getString(1));
				}
			}
			ProductIDCB.setItems(ProductID);
			ProductIDCB.getSelectionModel().clearAndSelect(0);
			SelectionPane.setVisible(false);
			ProductIDPane.setVisible(true);
			confirmSaleBtn.setVisible(true);
			CancelBtn.setVisible(true);
		}		
		catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
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
			ProductNameCB.getSelectionModel().clearAndSelect(0);
			SelectionPane.setVisible(false);
			ProductNamePane.setVisible(true);
			confirmSaleBtn.setVisible(true);
			CancelBtn.setVisible(true);
		}		
		catch (SQLException e) {
			e.printStackTrace();
		}
    }

    private void updateDatabase(int num, double sale, int storeNum) {
    	String query;
    	DbConnect db = new DbConnect();
		Connection con = db.getConnection();
		Statement stmt;
		try {
			stmt = con.createStatement();		
	    	if(num ==1) { // change db based on name
	    		query = "UPDATE `item` SET `Price" + storeNum+ "`= `Price`*" + (sale/100) + " where Name = '" + ProductNameCB.getSelectionModel().getSelectedItem() + "'";
	    		
	    	}
	    	else {
	    		query = "UPDATE `item` SET `Price" + storeNum+ "`= `Price`*" + (sale/100) + " where ID = '" + ProductIDCB.getSelectionModel().getSelectedItem() + "'";
	    		
	    	}
	    	stmt.executeUpdate(query);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
    }
    @FXML
    void ConfirmSale(ActionEvent event) {
    	if (ProductNamePane.isVisible()) {
    		if(salePercent1TXT.getText() == null) {
    			return;
    		}   		
    		updateDatabase(1, Double.parseDouble(salePercent1TXT.getText()), Integer.parseInt(StoreNNameTXT.getText()));
    		confirmationLBL.setText("Confirmed");
    	}
    	if (ProductIDPane.isVisible()) {
    		if(salePercentTXT2.getText() == null) {
    			return;
    		}
    		updateDatabase(2, Double.parseDouble(salePercentTXT2.getText()),Integer.parseInt(StoreNIDTXT.getText()));
    		confirmationLBL.setText("Confirmed");
    	}    	
    	
    }
}
