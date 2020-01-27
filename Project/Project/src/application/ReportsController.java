package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ReportsController {

	private int storeNum1 = -1;
	private int storeNum2 = -1;
	private String date1;
	private String date2;
	ObservableList<Orders> OrdersList = FXCollections.observableArrayList();
	ObservableList<Orders> OrdersList2 = FXCollections.observableArrayList();
	ObservableList<Orders> OrdersList3 = FXCollections.observableArrayList();
	ObservableList<Reports> ComplaintList = FXCollections.observableArrayList();
	ObservableList<String> FlowerTypes = FXCollections.observableArrayList();
	@FXML
	private TextField StoreNum1TXT;

	@FXML
	private TextField StoreNum2TXT;

	@FXML
	private TextField date1TXT;

	@FXML
	private TextField date2TXT;

	@FXML
	private MenuButton flowerTypeDD;

	@FXML
	private Button getReportBTN;

	@FXML
	private MenuButton ReportDD;
	
	@FXML
	private Label storeNum1LBL;

	@FXML
	private Label storeNum2LBL;

	@FXML
	private TableView<Orders> TableOrder;

	@FXML
	private TableColumn<Orders, String> CustomerName;

	@FXML
	private TableColumn<Orders, String> ProductName;

	@FXML
	private TableColumn<Orders, String> ProductPrice;

	@FXML
	private TableColumn<Orders, String> PurchaseDate;

	@FXML
	private TableColumn<Orders, String> DeliveryDate;

	@FXML
	private TableColumn<Orders, String> CreditCard;

	@FXML
	private TableColumn<Orders, String> Typeofpayment;

	@FXML
	private TableColumn<Orders, String> Numberofinstallments;

	@FXML
	private Label date1LBL;
	
	@FXML
	private Label date2LBL;

	@FXML
	private Label errorsLBL;

	@FXML
	private TableView<Orders> TableOrder2;

	@FXML
	private TableColumn<Orders, String> CustomerName2;

	@FXML
	private TableColumn<Orders, String> ProductName2;

	@FXML
	private TableColumn<Orders, String> ProductPrice2;

	@FXML
	private TableColumn<Orders, String> PurchaseDate2;

	@FXML
	private TableColumn<Orders, String> DeliveryDate2;

	@FXML
	private TableColumn<Orders, String> CreditCard2;

	@FXML
	private TableColumn<Orders, String> Typeofpayment2;

	@FXML
	private TableColumn<Orders, String> Numberofinstallments2;
	
	@FXML
	private TableView<Reports> TableComplaint;

	@FXML
	private TableColumn<Reports, String> name;

	@FXML
	private TableColumn<Reports, String> email;

	@FXML
	private TableColumn<Reports, String> date;

	@FXML
	private TableColumn<Reports, String> phone;

	@FXML
	private TableColumn<Reports, String> complaint;

	@FXML
	private TableColumn<Reports, String> status;
	
	@FXML
	private Button compareBTN;
	
	@FXML
    private ComboBox<String> flowerTypeCB;

	@FXML
	void GetReport(ActionEvent event) {
		if (ReportDD.getText().equals("Report type")) {
			return;
		}
		TableOrder.setItems(null);
		DbConnect db = new DbConnect();
		Connection con = db.getConnection();
		try {
			storeNum1 = Integer.parseInt(StoreNum1TXT.getText());
			date1 = date1TXT.getText();
			try {
				if (StoreNum2TXT.isVisible() && date2TXT.isVisible()) {
					storeNum2 = Integer.parseInt(StoreNum2TXT.getText());
					date2 = date2TXT.getText();
				}
				// add store number check
			} catch (Exception e) {
				// errorsLBL.setText("store number cannot be empty");
			}
		} catch (Exception e) {
			// errorsLBL.setText("store number cannot be empty");
		}
		try {
			Statement stmt = con.createStatement();			
			
			if (ReportDD.getText().equals("Complaints")) {
				String query = "Select * from Reports";
				ResultSet rs = stmt.executeQuery(query);
				while (rs.next()) {
					Reports report = new Reports();
					report.setusername(rs.getString(1));
					report.setemail(rs.getString(2));
					report.setdate(rs.getString(3));
					report.setphone(rs.getString(4));
					report.setcomplaint(rs.getString(5));
					report.setstaus(rs.getString(6));
					ComplaintList.add(report);
				}
				name.setCellValueFactory(new PropertyValueFactory<>("username"));

				email.setCellValueFactory(new PropertyValueFactory<>("email"));

				date.setCellValueFactory(new PropertyValueFactory<>("date"));

				phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
				complaint.setCellValueFactory(new PropertyValueFactory<Reports,String>("complain"));
				status.setCellValueFactory(new PropertyValueFactory<>("status"));

				TableComplaint.setItems(null);
				TableComplaint.setItems(ComplaintList);
				TableComplaint.refresh();
				TableComplaint.setVisible(true);
			} 
			else if (ReportDD.getText().equals("Orders by type")) {
				String query = "Select * from Orders Where `Product Name` = '" + flowerTypeCB.getValue() + "'";
				ResultSet rs = stmt.executeQuery(query);
				while(rs.next()) {
					
					Orders order = new Orders();
					order.setname(rs.getString(1));
					order.setproduct(rs.getString(2));
					order.setprice(rs.getString(3));
					order.setdate(rs.getString(4));
					order.setdelivery(rs.getString(5));
					order.setcard(rs.getString(6));
					order.settype(rs.getString(7));
					order.setinstallments(rs.getString(7));

					OrdersList3.add(order);
				}
					CustomerName.setCellValueFactory(new PropertyValueFactory<>("name"));

					ProductName.setCellValueFactory(new PropertyValueFactory<>("product"));

					ProductPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

					PurchaseDate.setCellValueFactory(new PropertyValueFactory<>("date"));
					DeliveryDate.setCellValueFactory(new PropertyValueFactory<>("delivery"));
					CreditCard.setCellValueFactory(new PropertyValueFactory<>("card"));
					Typeofpayment.setCellValueFactory(new PropertyValueFactory<>("type"));
					Numberofinstallments.setCellValueFactory(new PropertyValueFactory<>("installments"));
					TableOrder.setItems(null);
					TableOrder.setItems(OrdersList3);
					TableOrder.refresh();
					TableOrder.setVisible(true);
			}
			else {
				String query = "Select * from Orders";

				ResultSet rs = stmt.executeQuery(query);
				while (rs.next()) {
					String storeNum = rs.getString("Type");
					String[] dateParts = rs.getString("Purchase Date").split(" ");
					String[] orderDate = dateParts[0].split("-");
					String[] askedDate = date1.split("/");

					int year = Integer.parseInt(orderDate[0]);
					int month = Integer.parseInt(orderDate[1]);
					int askedyear = Integer.parseInt(askedDate[1]);
					int askedmonth = Integer.parseInt(askedDate[0]);
					if (askedyear == year && askedmonth == month && Integer.parseInt(storeNum) == Integer.parseInt(StoreNum1TXT.getText())) {
						Orders order = new Orders();
						order.setname(rs.getString(1));
						order.setproduct(rs.getString(2));
						order.setprice(rs.getString(3));
						order.setdate(rs.getString(4));
						order.setdelivery(rs.getString(5));
						order.setcard(rs.getString(6));
						order.settype(rs.getString(7));
						order.setinstallments(rs.getString(7));

						OrdersList.add(order);

					}
					if (date2TXT.isVisible() && Integer.parseInt(storeNum) == Integer.parseInt(StoreNum2TXT.getText())) {
						String[] askedDate2 = date2.split("/");
						askedyear = Integer.parseInt(askedDate2[1]);
						askedmonth = Integer.parseInt(askedDate2[0]);
						if (askedyear == year && askedmonth == month) {
							Orders order2 = new Orders();
							order2.setname(rs.getString(1));
							order2.setproduct(rs.getString(2));
							order2.setprice(rs.getString(3));
							order2.setdate(rs.getString(4));
							order2.setdelivery(rs.getString(5));
							order2.setcard(rs.getString(6));
							order2.settype(rs.getString(7));
							order2.setinstallments(rs.getString(7));

							OrdersList2.add(order2);

						}
					}

				}

				CustomerName.setCellValueFactory(new PropertyValueFactory<>("name"));

				ProductName.setCellValueFactory(new PropertyValueFactory<>("product"));

				ProductPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

				PurchaseDate.setCellValueFactory(new PropertyValueFactory<>("date"));
				DeliveryDate.setCellValueFactory(new PropertyValueFactory<>("delivery"));
				CreditCard.setCellValueFactory(new PropertyValueFactory<>("card"));
				Typeofpayment.setCellValueFactory(new PropertyValueFactory<>("type"));
				Numberofinstallments.setCellValueFactory(new PropertyValueFactory<>("installments"));
				TableOrder.setItems(null);
				TableOrder.setItems(OrdersList);
				TableOrder.refresh();

				if (date2LBL.isVisible()) {
					CustomerName2.setCellValueFactory(new PropertyValueFactory<>("name"));

					ProductName2.setCellValueFactory(new PropertyValueFactory<>("product"));

					ProductPrice2.setCellValueFactory(new PropertyValueFactory<>("price"));

					PurchaseDate2.setCellValueFactory(new PropertyValueFactory<>("date"));
					DeliveryDate2.setCellValueFactory(new PropertyValueFactory<>("delivery"));
					CreditCard2.setCellValueFactory(new PropertyValueFactory<>("card"));
					Typeofpayment2.setCellValueFactory(new PropertyValueFactory<>("type"));
					Numberofinstallments2.setCellValueFactory(new PropertyValueFactory<>("installments"));
					TableOrder2.setItems(null);
					TableOrder2.setItems(OrdersList2);
					TableOrder2.refresh();
					TableOrder2.setVisible(true);
				}
				TableOrder.setVisible(true);
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}
	}

	@FXML
	void getStoreNum1(ActionEvent event) {

	}

	@FXML
	void getStoreNum2(ActionEvent event) {
	}

	@FXML
	void getMonthlyReport(ActionEvent event) {
		ReportDD.setText("Monthly report");
		ClearAllFields();
		date1TXT.setVisible(true);
		date1LBL.setVisible(true);
		storeNum1LBL.setVisible(true);
		StoreNum1TXT.setVisible(true);
		TableOrder.setItems(null);
		TableOrder2.setItems(null);
		TableComplaint.setItems(null);
		TableComplaint.setVisible(false);
		TableOrder.setVisible(false);
		TableOrder2.setVisible(false);
		flowerTypeCB.setVisible(false);
		date2LBL.setVisible(false);
		date2TXT.setVisible(false);
		storeNum2LBL.setVisible(false);
		StoreNum2TXT.setVisible(false);

	}

	private void ClearAllFields() {
		date1TXT.clear();
		date2TXT.clear();
		TableOrder.setItems(null);
		TableOrder2.setItems(null);
		TableComplaint.setItems(null);
		flowerTypeCB.setValue("Flower Type");
		OrdersList.clear();
		OrdersList2.clear();
		OrdersList3.clear();
	}
	@FXML
	void GetOrdersByType(ActionEvent event) {
		ReportDD.setText("Orders by type");
		ClearAllFields();
		date1TXT.setVisible(false);
		date1LBL.setVisible(false);
		storeNum1LBL.setVisible(false);
		StoreNum1TXT.setVisible(false);		
		TableComplaint.setVisible(false);
		TableOrder.setVisible(false);
		TableOrder2.setVisible(false);
		flowerTypeCB.setVisible(true);
		date2LBL.setVisible(false);
		date2TXT.setVisible(false);
		storeNum2LBL.setVisible(false);
		StoreNum2TXT.setVisible(false);
		
		DbConnect db = new DbConnect();
		Connection con = db.getConnection();
		Statement stmt;
		try {
			stmt = con.createStatement();		
			String query = "Select `Name` from item";
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				if(!FlowerTypes.contains(rs.getString(1))) {
					FlowerTypes.add(rs.getString(1));
				}
			}
			flowerTypeCB.setItems(FlowerTypes);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void GetComplaints(ActionEvent event) {
		ReportDD.setText("Complaints");
		ClearAllFields();
		date1TXT.setVisible(false);
		date1LBL.setVisible(false);
		storeNum1LBL.setVisible(false);
		StoreNum1TXT.setVisible(false);
		TableOrder.setItems(null);
		TableOrder2.setItems(null);
		TableComplaint.setItems(null);
		TableComplaint.setVisible(false);
		TableOrder.setVisible(false);
		TableOrder2.setVisible(false);
		flowerTypeCB.setVisible(false);
		date2LBL.setVisible(false);
		date2TXT.setVisible(false);
		storeNum2LBL.setVisible(false);
		StoreNum2TXT.setVisible(false);
	}

	@FXML
	void MakeComparison(ActionEvent event) {
		ReportDD.setText("Comparison");
		ClearAllFields();
		date1TXT.setVisible(true);
		date1LBL.setVisible(true);
		storeNum1LBL.setVisible(true);
		StoreNum1TXT.setVisible(true);
		TableOrder.setItems(null);
		TableOrder2.setItems(null);
		TableComplaint.setItems(null);
		TableComplaint.setVisible(false);
		TableOrder.setVisible(false);
		TableOrder2.setVisible(false);
		flowerTypeCB.setVisible(false);
		date2LBL.setVisible(true);
		date2TXT.setVisible(true);
		storeNum2LBL.setVisible(true);
		StoreNum2TXT.setVisible(true);
	}

}
