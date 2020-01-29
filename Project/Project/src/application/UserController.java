package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Control;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.text.SimpleDateFormat;
import javafx.scene.input.MouseEvent;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.sql.Connection;
//import java.sql.Date;
//import java.sql.Date;
//import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.Date;
import javax.net.ssl.SSLException;
import javax.swing.JOptionPane;

import javafx.scene.input.KeyEvent;

import javafx.scene.control.ComboBox;

import javafx.event.EventHandler;
public class UserController implements Initializable {
	public User userreg = new User();
    @FXML
    public TextField textid;

    @FXML
    public Button Resetpp;

    @FXML
    public Button Submitit;

    @FXML
    public TextField textPassword;

    @FXML
    public TextField textRank;

    @FXML
    public TextField textemail;

    @FXML
    public TextField textfirstname;
    public ClientConsole cl;
    @FXML
    public TextField textlastname;

    @FXML
    public TextField textCreditcard;

    @FXML
    public TextField textPhone;

    @FXML
    public TextField textUsername;



    @FXML
    void handleClicks(ActionEvent event) {
    	if(event.getSource() == Submitit)
    	{
    		DbConnect db = new DbConnect();
			Connection connection = db.getConnection();
			Connection con = db.getConnection();
			Statement stmt;
			try {

					stmt = connection.createStatement();
	    		String p ="SELECT * FROM `users` WHERE Username = '"+textUsername.getText()+"' ";
	    		String noth = "0";
	    		ResultSet rs = stmt.executeQuery(p);
	    		if(rs.next())
	    		{
	    			p="DELETE FROM `users` WHERE Username = '"+textUsername.getText()+"'";
	    			stmt.execute(p);
	    			p="INSERT INTO `users`(`ID`, `Firstname`, `Lastname`, `email`, `username`, `password`, `CreditCard`, `Status`, `Rank`, `phone`, `Type`, `Coins`) VALUES ('"+textid.getText()+"','"+textfirstname.getText()+"','"+textlastname.getText()+"','"+textemail.getText()+"','"+textUsername.getText()+"','"+textPassword.getText()+"','"+textCreditcard.getText()+"','"+noth+"','"+textRank.getText()+"','"+textPhone.getText()+"','"+noth+"','"+noth+"')";
	    			stmt.execute(p);
	    			
	    			
	    			
	    		}
	    		else
	    		{
	    			p="INSERT INTO `users`(`ID`, `Firstname`, `Lastname`, `email`, `username`, `password`, `CreditCard`, `Status`, `Rank`, `phone`, `Type`, `Coins`) VALUES ('"+textid.getText()+"','"+textfirstname.getText()+"','"+textlastname.getText()+"','"+textemail.getText()+"','"+textUsername.getText()+"','"+textPassword.getText()+"','"+textCreditcard.getText()+"','"+noth+"','"+textRank.getText()+"','"+textPhone.getText()+"','"+noth+"','"+noth+"')";
	    			stmt.execute(p);
	    		}
	    		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			

    }
    	

}
    void received(ClientConsole client)
    {
    	cl = client;
    	/*if(this.bol == true) {
    	client.sendtoserver();
    	bol = false;
    	}*/
    	
    }


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}