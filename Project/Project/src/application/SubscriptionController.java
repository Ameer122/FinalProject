package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;

public class SubscriptionController {
	public String username;

    @FXML
    private MenuButton typeMenu;

    @FXML
    private Button subBtn;
    
    @FXML
    private Label confimLbl;
     
    @FXML
    void setMonthly(ActionEvent event) {
    	typeMenu.setText("Monthly");
    }

    @FXML
    void setYearly(ActionEvent event) {
    	typeMenu.setText("Yearly");
    }

    @FXML
    void Subscribe(ActionEvent event) {
    	if(typeMenu.getText().equals("Type")) {
    		return;
    	}
    	DbConnect db = new DbConnect();
		Connection con = db.getConnection();
		Statement stmt, stmt2;
		try {
			stmt = con.createStatement();
			stmt2 = con.createStatement();
			String query = "Select Subsciption from users Where username = '" + username +"'";
			ResultSet rs = stmt2.executeQuery(query);
			while(rs.next()) {
				//System.out.println(rs.getString(1));
				if(!rs.getString(1).equals("Monthly") && !rs.getString(1).equals("Yearly")) {
			    	query = "UPDATE users SET Subsciption= '" + typeMenu.getText()+ "' where username = '" + username +"'";
			    	stmt.executeUpdate(query);
			    	confimLbl.setText("Confirmed");
				}
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
    }
    public void recived1(String s)
    {
    	username=s;
    }
	

}
