package application;

import javafx.collections.FXCollections;
import java.util.Properties;


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
import javafx.scene.layout.HBox;
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

public class HomeController implements Initializable {
	ObservableList<Orders> OrdersList = FXCollections.observableArrayList(); // Orders Table View
	ObservableList<Orders> RemovedOrdersList = FXCollections.observableArrayList(); // RemovedOrders Table View

	ObservableList<Busket> BusketList = FXCollections.observableArrayList(); // Orders Table View
	ObservableList<Reports> ReportsList = FXCollections.observableArrayList(); // Orders Table View
	ObservableList<Messages> MessagesList = FXCollections.observableArrayList(); // Messages Table View
//Current Date//
  Date date= new Date();
  
	public long refund = 0;  
	  long timer = date.getTime();
	  Timestamp today = new Timestamp(timer);//Current Date
	public User user = new User();
	public User userreg = new User();
	public Reports report = new Reports();
	@FXML
    private Button subscribeBtn;
	@FXML
	private ResourceBundle resources;
	@FXML
	private Pane userpan;
	@FXML
	private Label labelname2;
	@FXML
	private Pane paneowner;
	@FXML
	private Pane paneuser;
	@FXML
	private Pane UserControlpnl;
	@FXML
	private Pane CatControlpnl;

	@FXML
	private Pane catpan;

    @FXML
    private HBox buttoncatalog;
    
	@FXML
	private Label labelname4;
	@FXML
	private URL location;

	@FXML
	private Button btncat;

	@FXML
	private Button btnfee;
	@FXML
	private Button test;
	@FXML
	private Button btnuser;

	@FXML
	private Button tet;
	@FXML
	private Button btnsetting;

	@FXML
	private Button btnworker;

	@FXML
	private Pane pnlCat;

	@FXML
	private Pane pnlUsers;

	@FXML
	private Button addbus;

	@FXML
	private Button additem;

	@FXML
	private Button delitem;

	@FXML
	private Button edititem;
	@FXML
	private Button adduser;

	@FXML
	private Button deluser;
	@FXML
	private TableView<ItemController> table;

	@FXML
	private TableColumn<ItemController, String> idcol;

	@FXML
	private TableColumn<ItemController, String> namecol;

	@FXML
	private TableColumn<ItemController, String> descol;
	public ClientConsole client;
	@FXML
	private TableColumn<ItemController, String> pricecol;

	@FXML
	private TableColumn<ItemController, FileInputStream> piccol;
	@FXML
	private TableColumn<ItemController, CheckBox> Selectcol;
	@FXML
	private Button edituser;

	// Login panel
	@FXML
	private Button btnlogin;
	@FXML
	private Pane Loginpan;

	@FXML
	private TextField tf_username;

	@FXML
	private PasswordField pf_password;

	@FXML
	private Button login;
	// Ends Here
	// order reports start
	@FXML
	private Button OrderRepbtn;
	// order reports end
	
	@FXML
	private Button Salebtn;

	// SignUp Panel

	@FXML
	private Pane Signuppan;

	@FXML
	private TextField tf_usernamesignup;
	@FXML
	private Label labname;
	@FXML
	private PasswordField pf_passwordsignup;

	@FXML
	private TextField tf_emailSignup;

	@FXML
	private TextField tf_IDSignup;

	@FXML
	private TextField tf_firstnameSignup;

	@FXML
	private TextField tf_LastNameSignup;
	@FXML
	private TextField tf_phone;

	@FXML
	private TextField tf_CardSignup;

	@FXML
	private Button signupbtn;
	// Ends Here

	// User Table
	@FXML
	private TableView<User> TableUser;

	@FXML
	private TableColumn<User, String> IDUser;

	@FXML
	private TableColumn<User, String> FirstUser;

	@FXML
	private TableColumn<User, String> LastUser;

	@FXML
	private TableColumn<User, String> MailUser;

	@FXML
	private TableColumn<User, String> UsernameUser;

	@FXML
	private TableColumn<User, String> PassUser;

	@FXML
	private TableColumn<User, String> CardUser;

	@FXML
	private TableColumn<User, String> DateUser;

	@FXML
	private TableColumn<User, String> StatusUser;
	// Ends Here

	// Orders Panel

	@FXML
	private Pane Orderspnl;

	@FXML
	private Label labelname21;

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
	    private TableColumn<Orders, CheckBox> orderselect;

	    @FXML
	    private Button removeorder;

	    @FXML
	    private Button removedorder;

	    @FXML
	    private Pane ordersviewrequest;
	    @FXML
	    private Pane ordersview;
	    
	    @FXML
	    private TableView<Orders> TableOrderrequests;

	    @FXML
	    private TableColumn<Orders, String> CustomerNameorder;

	    @FXML
	    private TableColumn<Orders, String> ProductNameorder;

	    @FXML
	    private TableColumn<Orders, String> PurchaseDateorder;

	    @FXML
	    private TableColumn<Orders, CheckBox> confirmselect;

	    @FXML
	    private Button confirmremove;

	
	
	// ends here

	// Complains

	@FXML
	private Pane Complaintpnl;

	@FXML
	private Label labelname211;

	@FXML
	private TableView<Reports> tablecomplain;

	@FXML
	private TableColumn<Reports, String> usernamecol;

	@FXML
	private TableColumn<Reports, String> emailcol;

	@FXML
	private TableColumn<Reports, String> datecol;

	@FXML
	private TableColumn<Reports, String> phonecol;

	@FXML
	private TableColumn<Reports, String> complaintcol;

	@FXML
	private TableColumn<Reports, String> statuscol;
	@FXML
	private TableColumn<Reports, String> chck;
	@FXML
	private Button addcomplaint;

	@FXML
	private Button readcomplaint;

	@FXML
	private TextField complaintuser;

	@FXML
	private TextField complaintmail;

	@FXML
	private TextField complaintphone;

	@FXML
	private TextArea complainttext;

	@FXML
	private Button complaintsubmit;

	@FXML
	private Button complaintbtn;

	// Ends here

	// Purshase Scene
	@FXML
	private Pane Checkbusket;

	@FXML
	private TableView<Busket> tablepursh;

	@FXML
	private TableColumn<Busket, String> itecol;

	@FXML
	private TableColumn<Busket, String> prcol;

	@FXML
	private TableColumn<Busket, String> quanitycol;

	@FXML
	private CheckBox delivery;
	@FXML
	private CheckBox carde;

	@FXML
	private Label Orderpr;

	@FXML
	private Label Cardpr;

	@FXML
	private Label shippr;

	@FXML
	private Label totalpr;

	@FXML
	private TextField orderuser;

	@FXML
	private TextField orderaddress;

	@FXML
	private TextField orderphone;

	@FXML
	private TextField ordermail;

	@FXML
	private TextField ordercard;

	@FXML
	private Button complete;
	@FXML
	private Button mybusket;
	@FXML
	private Button card;
	@FXML
	private TextArea textorder;
	// Ends here
	
	 //Custom Item
    @FXML
    private Button custom;

    @FXML
    private ComboBox<String> amountcombo;

    @FXML
    private ColorPicker colorpick;

    @FXML
    private ComboBox<String> potcombo;

    @FXML
    private ComboBox<String> ordercombo;

    @FXML
    private ComboBox<String> sizecombo;

    @FXML
    private Label customprice;
    
    
    @FXML
    private Pane CustomPane;
    Color color = new Color(1,1,1,1);
    ObservableList<String> amountlist = FXCollections.observableArrayList("1","2","3","4","5","6","7","8","9","10","11","12");
    ObservableList<String> potlist = FXCollections.observableArrayList("Yes","No");
    ObservableList<String> orderlist = FXCollections.observableArrayList("By color","By Size");
    ObservableList<String> sizelist = FXCollections.observableArrayList("Big","Medium","Small");
    //Ends Here
    
    //Messages
    

    
    ObservableList<String> Messagecombo = FXCollections.observableArrayList(); // Messages Table View
    @FXML
    private Pane msgreadpnl;

    @FXML
    private TableView<Messages> tablemsg;

    @FXML
    private TableColumn<Messages, String> fromcol;

    @FXML
    private TableColumn<Messages, String> tocol;

    @FXML
    private TableColumn<Messages, String> msgdatecol;

    @FXML
    private TableColumn<Messages, String> msgcol;

    @FXML
    private Button sendmsg;

    @FXML
    private Pane msgsendpnl;
    @FXML
    private Pane Messagespnl;
    @FXML
    private TextField msguser;

    @FXML
    private TextField msgmail;

    @FXML
    private ComboBox<String> msgwho;

    @FXML
    private TextArea msgtext;
  
    Messages msgsend = new Messages();

    @FXML
    private Button sendmsgbtn;
@FXML
private Button messagesbtn;
    //Ends Here
	
	@FXML
	private Label numcar;

	@FXML
	private ComboBox<String> combo;
	@FXML
	private ComboBox<String> storecombo;
	@FXML
	private DatePicker orderdat;
	ObservableList<String> storelist = FXCollections.observableArrayList("1", "2");
	ObservableList<String> comlist = FXCollections.observableArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9",
			"10", "11", "12");
	public int a = 0;
	public int b = 0;
	public int c = 0;
	public int d = 0;
	
    @FXML
    private Button backcat;
    @FXML
    private Button backmsg;
    @FXML
    private Button Backorder;
	
	@SuppressWarnings({ "deprecation", "null" })
	@FXML
	void handleClicks(ActionEvent event) {
		// Working on Purshase Scene
//Working on Messages
    	
    	if(event.getSource() == messagesbtn)
    	{
    		Messagespnl.setVisible(true);
    		Messagespnl.toFront();
    		
    		   CatControlpnl.setVisible(false);
   	       	Signuppan.setVisible(false);
   	           Loginpan.setVisible(false);
   	           Complaintpnl.setVisible(false);
   	           UserControlpnl.setVisible(false);
   	           Orderspnl.setVisible(false);
   		Signuppan.setVisible(false);
           Loginpan.setVisible(false);
         //Message Table View
           MessagesList.clear();
           
	         DbConnect db = new DbConnect();
	          try {
	          	Connection con = db.getConnection();
	          	{
	          		ResultSet rs = con.createStatement().executeQuery("SELECT * From Messages WHERE Sender= '" + client.name + "' OR Receiver = '" +client.name+"'");
	          	   	while(rs.next())
		          	{	
	          	   	  Messages msg = new Messages();	
		          	msg.setFrom(rs.getString(1));
		          	msg.setTo(rs.getString(2));
		          	msg.setDate(rs.getString(3));
		          	msg.setMessage(rs.getString(4));
		          		
		          		MessagesList.add(msg);
	          	}
	          	}
	          } catch (SQLException e) {
	          	// TODO Auto-generated catch block
	          	e.printStackTrace();
	          }
	         fromcol.setCellValueFactory(  new PropertyValueFactory<>("from"));

	         tocol.setCellValueFactory(
	            new PropertyValueFactory<>("to"));

	          msgdatecol.setCellValueFactory(
	            new PropertyValueFactory<>("date"));

	          msgcol.setCellValueFactory(
	            new PropertyValueFactory<>("message"));
	          
	          tablemsg.setItems(null);
	          tablemsg.setItems(MessagesList);
	          tablemsg.refresh();	
    	}
    	
    	
if(event.getSource() == sendmsg)
{
	backmsg.setVisible(true);
	Messagecombo.clear();
	msgreadpnl.setVisible(false);
	msgsendpnl.setVisible(true);
	msguser.setText(client.name);
	msgmail.setText(user.getEmail());
	DbConnect db = new DbConnect();
    try {
    	Connection con = db.getConnection();
    	{
    		ResultSet rs = con.createStatement().executeQuery("SELECT * From users");
    	   	while(rs.next())
        	{	
        		String temp ;
        		temp = rs.getString(5);
        		
        		Messagecombo.add(temp);
    	}
    	}
    } catch (SQLException e) {
    	// TODO Auto-generated catch block
    	e.printStackTrace();
    }
    msgwho.setItems(Messagecombo);
    
    
    
   
}
if(event.getSource() == sendmsgbtn)
{
	msgreadpnl.setVisible(true);
	msgsendpnl.setVisible(false);
	tablemsg.refresh();
	  DbConnect db = new DbConnect();
		PreparedStatement stms;
		String q = "INSERT INTO Messages(Sender,Receiver,Message) VALUES(?,?,?)";
		
		Connection connection = db.getConnection();
		
		try {
			msgsend.setMessage(msgtext.getText());
			msgsend.setFrom(client.name);
			msgsend.setTo(msgwho.getValue());
			//report.setcomplaint(complainttext.getText());
			stms = connection.prepareStatement(q);
			stms.setString(1,msgsend.getFrom());
			stms.setString(2, msgsend.getTo());
stms.setString(3, msgsend.getMessage()); //Should be changed soon


if(  stms.executeUpdate()>0)
{
JOptionPane.showMessageDialog(null, "Your message has been sent to " + msgsend.getTo());
CatControlpnl.setVisible(true);
CatControlpnl.toFront();

}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
}
    	
    	
    	
    	
    	
    	//End here messages
    	
    	
    	
//Working on Custom Item 
    	if(event.getSource() == custom && custom.getText().equals("Custom Item"))
    	{
    		custom.setText("Catalog");
    		labelname4.setText("Custom Item");
    		CustomPane.setVisible(true);
    		table.setVisible(false);
    		
    	}
    	else if(event.getSource() == custom && custom.getText().equals("Catalog"))
    	{
    		custom.setText("Custom Item");
    		labelname4.setText("Catalog");
    		CustomPane.setVisible(false);
    		table.setVisible(true);
    		
    	}
    	if(event.getSource() == potcombo)
    	{
    		if(potcombo.getValue().equals("Yes"))
    			b = 40;
    		else {
    			b = 0;
    			
    		}	
    			customprice.setText(Integer.toString(a+b+c+d));
    		
    	}
    	if(event.getSource() == sizecombo)
    	{
    		if(sizecombo.getValue().equals("Small"))
    			c = 5;
    		else if (sizecombo.getValue().equals("Medium"))
    			c = 10;
    		else if (sizecombo.getValue().equals("Big"))
    				c = 15;
    		
    		customprice.setText(Integer.toString(a+b+c+d));
    	}
    	if(event.getSource() == colorpick)
    	{
             color = colorpick.getValue();
            System.out.println(color.toString());
    		if(color.toString().equals("0xffffffff"))
    		{
        		d = 8;
        		
        		
    		}        	else d = 15;
    		
    		customprice.setText(Integer.toString(a+b+c+d));
    	}
    	if(event.getSource() == amountcombo)
    	{
    		
    		a = (Integer.parseInt(amountcombo.getValue()) * 10);
    	
    	
    		customprice.setText(Integer.toString(a+b+c+d));
    		System.out.println(a);
    	}
    	
    	
    	//Ends Here Custom Item
    	
    	
		if (event.getSource() == complete) {

			DbConnect db = new DbConnect();
			PreparedStatement stms;
			PreparedStatement stm;
			String q = "INSERT INTO `Orders`(`Customer`, `Product Name`, `Product Price`, `Purchase Date`, `Delivery Date`, `Credit Card`, `Type of payment`, `Number of installments`, `Quanity`, `Message`,`Address`,`Type`) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
String ql = " UPDATE `Messages` SET `Sender`= Server,`Message`= Purchase confirmed WHERE `Receiver` = '"+ user.getUsername() +"'";
			Connection connection = db.getConnection();
			
Connection con = db.getConnection();
			try {
				for (int i = 0; i < tablepursh.getItems().size(); i++) {
					stms = connection.prepareStatement(q);
					stms.setString(1, user.getUsername());
					stms.setString(2, tablepursh.getItems().get(i).getName());
					stms.setString(3, tablepursh.getItems().get(i).getPrice());

					java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
					stms.setTimestamp(4, date);
				//	stms.setString(5, ((TextField) orderdat.getEditor()).getText());
stms.setString(5, Timestamp.valueOf(orderdat.getValue().atTime(0,0)).toString());
					stms.setString(6, user.getCard());
					stms.setString(7, "1");
					stms.setString(8, combo.getValue());
					stms.setString(9, tablepursh.getItems().get(i).getQuanity());
					stms.setString(10, textorder.getText());
					stms.setString(11, orderaddress.getText());
					stms.setString(12, user.getType());
					stms.executeUpdate();
					
				}
				{
					String sql2 = "DELETE FROM `Busket` WHERE `Username` = ?";
					stm = con.prepareStatement(sql2);
					stm.setString(1, user.getUsername());
					stm.executeUpdate();
					stm.close();
				}
				BusketList.clear();
				tablepursh.setItems(null);
				tablepursh.setItems(BusketList);
				
				{
					
				
					
					
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
if(event.getSource() == backcat)
{
	catpan.setVisible(true);
	Checkbusket.setVisible(false);
	pnlCat.setVisible(true);
	mybusket.setVisible(true);
	backcat.setVisible(false);
}
if(event.getSource() == Backorder)
{
	ordersviewrequest.setVisible(false);
	ordersview.setVisible(true);
}
if(event.getSource() == backmsg)
{
	msgreadpnl.setVisible(true);
	msgsendpnl.setVisible(false);
	backmsg.setVisible(false);
}
		if (event.getSource() == mybusket) {
			BusketList.clear();
			Checkbusket.setVisible(true);
			catpan.setVisible(false);
			pnlCat.setVisible(false);
			mybusket.setVisible(false);
			backcat.setVisible(true);
			orderuser.setText(client.name);
			orderphone.setText(user.getphone());
			ordermail.setText(user.getEmail());
			ordercard.setText(user.getCard());

			DbConnect db = new DbConnect();
			try {
				Connection con = db.getConnection();

				
				
				{
					ResultSet rs = con.createStatement()
							.executeQuery("SELECT * From Busket WHERE Username= '" + client.name + "'");
					while (rs.next()) {
						Busket busket = new Busket();
						busket.setUsername(rs.getString(1));
						busket.setId(rs.getString(2));
						busket.setName(rs.getString(3));
						busket.setDescription(rs.getString(4));
						busket.setPrice(rs.getString(5));
						busket.setQuanity(rs.getString(7));

						BusketList.add(busket);
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// @FXML
			// private TableView<ItemController> tablepursh;

			itecol.setCellValueFactory(new PropertyValueFactory<>("name"));

			prcol.setCellValueFactory(new PropertyValueFactory<>("price"));

			quanitycol.setCellValueFactory(new PropertyValueFactory<>("quanity"));

			tablepursh.setItems(null);
			tablepursh.setItems(BusketList);
			tablepursh.refresh();

			double c = 0;
			Orderpr.setText(Double.toString(c));
			for (int i = 0; i < tablepursh.getItems().size(); i++) {
				System.out.println(tablepursh.getItems().get(i).getPrice());
				c += Double.parseDouble(tablepursh.getItems().get(i).getPrice())
						* Double.parseDouble(tablepursh.getItems().get(i).getQuanity());
			}
			Orderpr.setText(Double.toString(c));

		}

		if (event.getSource() == delivery) {
			if (delivery.isSelected()) {
				shippr.setText("15");
				orderaddress.setDisable(false);
				orderaddress.setEditable(true);
				// totalpr.setText(Integer.toString(Integer.parseInt(Orderpr.getText()) +
				// Integer.parseInt(shippr.getText())));
			} else {
				shippr.setText("0");
				orderaddress.setDisable(true);

			}
			totalpr.setText(Double.toString(Double.parseDouble(Orderpr.getText()) + Double.parseDouble(shippr.getText())));
		}
		if (event.getSource() == carde) {
			if (carde.isSelected()) {
				Cardpr.setText("15");
				textorder.setVisible(true);
				// totalpr.setText(Integer.toString(Integer.parseInt(Orderpr.getText()) +
				// Integer.parseInt(Cardpr.getText())));
			} else {
				Cardpr.setText("0");
				textorder.setVisible(false);
				//
			}
			totalpr.setText(Double.toString(Double.parseDouble(Orderpr.getText()) + Double.parseDouble(Cardpr.getText())));
		}

		// Ends here

		if (event.getSource() == tet) {
			try {
				client.close();
				DbConnect db = new DbConnect();
				PreparedStatement stms;
				String q = "update users set Status = ? where username = '" + user.getUsername() + "'";
				Connection connection = db.getConnection();
				try {
					stms = connection.prepareStatement(q);
					stms.setString(1, "0");
					stms.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (event.getSource() == btncat) {
			// pnlcat.setStyle("-fx-background-color : #1620A1");
			Messagespnl.setVisible(false);
			CatControlpnl.toFront();
			CatControlpnl.setVisible(true);
			Signuppan.setVisible(false);
			Loginpan.setVisible(false);
			Complaintpnl.setVisible(false);
			UserControlpnl.setVisible(false);
			Orderspnl.setVisible(false);
			
			
		}

		if (event.getSource() == complaintbtn) {
			CatControlpnl.setVisible(false);
			Complaintpnl.setVisible(true);
			Messagespnl.setVisible(false);

			Signuppan.setVisible(false);
			Loginpan.setVisible(false);

			UserControlpnl.setVisible(false);
			Orderspnl.setVisible(false);
			Complaintpnl.toFront();
			complaintuser.setText(user.getUsername());
			complaintmail.setText(user.getEmail());
			complaintphone.setText(user.getFirstname());

			if (user.getRank().equals("2")) {
				paneowner.setVisible(true);
				paneuser.setVisible(false);
				

				ReportsList.clear();
				DbConnect db = new DbConnect();

				try {
					Connection connection = db.getConnection();
					ResultSet rs = connection.createStatement().executeQuery("SELECT * From Reports");
					while (rs.next()) {
						Reports r = new Reports();
						r.setusername(rs.getString(1));
						r.setemail(rs.getString(2));
						r.setdate(rs.getString(3));
						r.setphone(rs.getString(4));
						r.setcomplaint(rs.getString(5));
						r.setstaus(rs.getString(6));

						ReportsList.add(r);

						System.out.print(r.getComplain() + " " + r.getDate() + " " + r.getEmail() + " " + r.getPhone()
								+ " " + r.getStatus() + " " + r.getUsername() + "   ,   ");
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				usernamecol.setCellValueFactory(new PropertyValueFactory<>("username"));

				emailcol.setCellValueFactory(new PropertyValueFactory<>("email"));

				datecol.setCellValueFactory(new PropertyValueFactory<>("date"));

				phonecol.setCellValueFactory(new PropertyValueFactory<>("phone"));
				complaintcol.setCellValueFactory(new PropertyValueFactory<>("complain"));

				statuscol.setCellValueFactory(new PropertyValueFactory<>("status"));

				tablecomplain.setItems(null);
				tablecomplain.setItems(ReportsList);

// TO DO
				/*
				
				*/
			} else {
				paneowner.setVisible(false);
				paneuser.setVisible(true);
			}

		}
		if (event.getSource() == complaintsubmit) {
			DbConnect db = new DbConnect();
			PreparedStatement stms;
			String q = "INSERT INTO Reports(ReporterName,ReporterEmail,ReporterPhone,ReporterComplaint,ReporterStatus) VALUES(?,?,?,?,?)";

			Connection connection = db.getConnection();

			try {
				report.setcomplaint(complainttext.getText());
				stms = connection.prepareStatement(q);
				stms.setString(1, user.getUsername());
				stms.setString(2, user.getEmail());
				System.out.println(user.getphone());
				stms.setString(3, user.getphone()); // Should be changed soon
				stms.setString(4, report.getComplain());
				stms.setString(5, "Pending");

				
				if (stms.executeUpdate() > 0) {
					JOptionPane.showMessageDialog(null,
							"We have recieved your complain, we will make sure to sort things out in 24 hours!");
					CatControlpnl.setVisible(true);
					Complaintpnl.setVisible(false);
					CatControlpnl.toFront();

					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (event.getSource() == btnlogin && btnlogin.getText().equals("Logout")) {
			// pnlcat.setStyle("-fx-background-color : #1620A1");

			try {
				client.close();
				DbConnect db = new DbConnect();
				PreparedStatement stms;
				String q = "update users set Status = ? where username = '" + user.getUsername() + "'";
				Connection connection = db.getConnection();
				try {
					stms = connection.prepareStatement(q);
					stms.setString(1, "0");
					stms.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			CatControlpnl.setVisible(true);
			Signuppan.setVisible(false);
			Messagespnl.setVisible(false);

			Complaintpnl.setVisible(false);
			UserControlpnl.setVisible(false);
			Orderspnl.setVisible(false);
			// Loginpan.toFront();
			CatControlpnl.toFront();
			Signuppan.setVisible(false);
			Loginpan.setVisible(false);
			btnlogin.setText("Login");
			OrderRepbtn.setVisible(false);
			subscribeBtn.setVisible(false);
			Salebtn.setVisible(false);
			complaintbtn.setVisible(false);
			messagesbtn.setVisible(false);
			 btnfee.setVisible(false);
			  
				btnuser.setVisible(false);
				
				//buttons 
				additem.setVisible(false);
				delitem.setVisible(false);
				edititem.setVisible(false);
				addbus.setVisible(false);
				custom.setVisible(false);
				mybusket.setVisible(false);
				Selectcol.setVisible(false);
				//
				
				
		}

		else if (event.getSource() == btnlogin && btnlogin.getText().equals("Login")) {
			// pnlcat.setStyle("-fx-background-color : #1620A1");

			CatControlpnl.setVisible(false);
			Signuppan.setVisible(false);
			Messagespnl.setVisible(false);

			Complaintpnl.setVisible(false);
			UserControlpnl.setVisible(false);
			Orderspnl.setVisible(false);
			Loginpan.toFront();
			Signuppan.setVisible(true);
			Loginpan.setVisible(true);
		}
		if (event.getSource() == btnfee) {
			Messagespnl.setVisible(false);
if(user.getRank().equals("2"))
{
	removedorder.setVisible(true);
}
else
{
	removedorder.setVisible(false);
}
			Orderspnl.toFront();
			CatControlpnl.setVisible(false);
			Signuppan.setVisible(false);
			Loginpan.setVisible(false);
			Complaintpnl.setVisible(false);
			UserControlpnl.setVisible(false);
			Orderspnl.setVisible(true);
			Signuppan.setVisible(false);
			Loginpan.setVisible(false);
			// Order Table View
			OrdersList.clear();

			DbConnect db = new DbConnect();
			try {
				Connection con = db.getConnection();
				if (client.name.equals("ameer")) {
					ResultSet rs = con.createStatement().executeQuery("SELECT * From Orders ");

					while (rs.next()) {
						Orders order = new Orders();
						CheckBox ch = new CheckBox("");
						order.setCh(ch);
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
				} else {
					ResultSet rs = con.createStatement()
							.executeQuery("SELECT * From Orders WHERE Customer= '" + client.name + "'");
					while (rs.next()) {
						CheckBox ch = new CheckBox("");
						
						Orders order = new Orders();
						order.setCh(ch);
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
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			CustomerName.setCellValueFactory(new PropertyValueFactory<>("name"));

			ProductName.setCellValueFactory(new PropertyValueFactory<>("product"));

			ProductPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

			PurchaseDate.setCellValueFactory(new PropertyValueFactory<>("date"));
			DeliveryDate.setCellValueFactory(new PropertyValueFactory<>("delivery"));
			CreditCard.setCellValueFactory(new PropertyValueFactory<>("card"));
			Typeofpayment.setCellValueFactory(new PropertyValueFactory<>("type"));
			Numberofinstallments.setCellValueFactory(new PropertyValueFactory<>("installments"));
			orderselect.setCellValueFactory(new PropertyValueFactory<>("ch"));
			TableOrder.setItems(null);
			TableOrder.setItems(OrdersList);
			TableOrder.refresh();

		}
		if (event.getSource() == removeorder ) {
			DbConnect db = new DbConnect();
			Connection connection = db.getConnection();
			Connection con = db.getConnection();
			Statement stmt;
			PreparedStatement st;
			try {

				stmt = connection.createStatement();

				for (int i = 0; i < TableOrder.getItems().size(); i++) {
					if (TableOrder.getItems().get(i).getCh().isSelected()) {
						String sql = "SELECT * FROM Orders WHERE Customer = '" + user.getUsername()
								+ " '  AND `Product Name` = '" + TableOrder.getItems().get(i).getProduct()  + " '  AND `Purchase Date` = '" + TableOrder.getItems().get(i).getDate() + "'  ";
				
						
						try {
							ResultSet rs = stmt.executeQuery(sql);
							
							if (rs.next()) {
								String sq = "INSERT INTO `RemovedOrders`(`username`, `Productname`, `PurchaseDate`,`Price`,`DeliveryDate`) VALUES (?,?,?,?,?)";

								st = con.prepareStatement(sq);
								st.setString(1, user.getUsername());
								st.setString(2, rs.getString(2));
								st.setString(3, rs.getString(4));
								st.setString(4, rs.getString(3));
								st.setString(5, rs.getString(5));
								
								if(  st.executeUpdate()>0)
								{
								JOptionPane.showMessageDialog(null, "Your Request to remove your order has been received.");
								Orderspnl.setVisible(false);
								CatControlpnl.setVisible(true);
								CatControlpnl.toFront();
								}
							}
							// System.out.println(rs.getString(1)+" "+rs.getString(2)+" " +
							// rs.getString(3));
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(event.getSource() == readcomplaint)
		{
			DbConnect db = new DbConnect();
			Connection connection = db.getConnection();
			Connection con = db.getConnection();
			Statement stmt;
			Statement st;
			try {
				
				stmt = connection.createStatement();

				for (int i = 0; i < table.getItems().size(); i++) {
					if (tablecomplain.getItems().get(i).getCh().isSelected()) {
					{
						String sql = "SELECT * FROM Reports WHERE `ReporterName` = '" + tablecomplain.getItems().get(i).getUsername()
								+ " '  AND `ReporterEmail` = '" + tablecomplain.getItems().get(i).getEmail() + "'";

						try {
							ResultSet rs = stmt.executeQuery(sql);
							if (rs.next()) {
								String sq = "UPDATE `Reports` SET `ReporterStatus`= READ  WHERE `ReporterName` = '" + tablecomplain.getItems().get(i).getUsername() + "'";
								
								st = con.createStatement();		

								st.executeUpdate(sq);

							}
							// System.out.println(rs.getString(1)+" "+rs.getString(2)+" " +
							// rs.getString(3));
						} catch (SQLException e) {
							System.out.println("Please");
							e.printStackTrace();
						}

					}
				}
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if(event.getSource() == removedorder)
		{
			     ordersview.setVisible(false);
			     ordersviewrequest.setVisible(true);
			     //oblist.clear();
					DbConnect db = new DbConnect();
					int i = 0;

					try {
						Connection connection = db.getConnection();
						ResultSet rs = connection.createStatement().executeQuery("SELECT * From RemovedOrders");
						while (rs.next()) {
							CheckBox ch = new CheckBox("" + i);
							Orders order = new Orders();
							order.setname(rs.getString(1));
							order.setproduct(rs.getString(2));
							order.setdate(rs.getString(3));
							order.setprice(rs.getString(4));
							order.setdelivery(rs.getString(5));
							order.setCh(ch);
							RemovedOrdersList.add(order);
							i++;
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					CustomerNameorder.setCellValueFactory(new PropertyValueFactory<>("name"));

					ProductNameorder.setCellValueFactory(new PropertyValueFactory<>("product"));

					PurchaseDateorder.setCellValueFactory(new PropertyValueFactory<>("date"));

					
					confirmselect.setCellValueFactory(new PropertyValueFactory<>("ch"));
					TableOrderrequests.setItems(null);
					TableOrderrequests.setItems(RemovedOrdersList);     
		}
		
		if(event.getSource()== confirmremove)
		{
			DbConnect db = new DbConnect();
			Connection connection = db.getConnection();
			Connection con = db.getConnection();
			Statement stmt;
			PreparedStatement st;
			Statement stm;
			
				
			
			try {

				stmt = connection.createStatement();

				for (int i = 0; i < TableOrderrequests.getItems().size(); i++) {
					if (TableOrderrequests.getItems().get(i).getCh().isSelected()) {
						String sql = "SELECT * FROM RemovedOrders WHERE username = '" + TableOrderrequests.getItems().get(i).getName()
						+ " '  AND `Productname` = '" + TableOrderrequests.getItems().get(i).getProduct()  + " '  AND `PurchaseDate` = '" + TableOrderrequests.getItems().get(i).getDate() + "'  ";
						try {
							System.out.println(TableOrderrequests.getItems().get(i).getName() + " " +TableOrderrequests.getItems().get(i).getProduct() + " " + TableOrderrequests.getItems().get(i).getDate()  );
							ResultSet rs = stmt.executeQuery(sql);
							if (rs.next()) {
								

								
								String sql1 = "DELETE FROM `RemovedOrders` WHERE `username` = '" + rs.getString(1) + " '  AND `Productname` = '"
										+ rs.getString(2) + "'";
								Timestamp t;
							
								t = Timestamp.valueOf(rs.getString(5));
								
								
						
								
								 long milliseconds1 = today.getTime();
								  long milliseconds2 = t.getTime();
								  long diff = milliseconds2 - milliseconds1;
								  long diffHours = diff / (60 * 60 * 1000);
								 System.out.println(diffHours);
								
								     
								//
								if(diffHours < 3 && diffHours > 1)
								{
									//a += Long.parseLong(rs.getString(4));
									System.out.println("50% has been refuded.");
								}
								else if(diffHours < 1)
								{
									System.out.println("Nothing Returned");
								}
								else if(diffHours > 3)
								{
									System.out.println("Refund Everything");
								}
								stm = con.createStatement();
						/*	if(stm.execute(sql1));
							{
								stm.close();
								String sql2 = "DELETE FROM `Orders` WHERE `Customer` = '" + rs.getString(1) + " '  AND `Product Name` = '"
										+ rs.getString(2) + "'";
								stm = con.createStatement();
								stm.execute(sql2);
								stm.close();
							}*/
					


							}
							
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					

					}
				}
			
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		}
		
		if (event.getSource() == addbus && custom.getText().equals("Custom Item")) {
			DbConnect db = new DbConnect();
			Connection connection = db.getConnection();
			Connection con = db.getConnection();
			Statement stmt;
			PreparedStatement st;
			try {

				stmt = connection.createStatement();

				for (int i = 0; i < table.getItems().size(); i++) {
					if (table.getItems().get(i).getCheckbox().isSelected()) {
						
						String sql = "SELECT * FROM item WHERE ID = '" + table.getItems().get(i).getId()
								+ " '  AND ID = '" + table.getItems().get(i).getId() + "'";
						try {
							ResultSet rs = stmt.executeQuery(sql);
							if (rs.next()) {
								String sq = "INSERT INTO `Busket`(`Username`,`ID`, `Name`, `Description`, `Price`) VALUES (?,?,?,?,?)";

								st = con.prepareStatement(sq);
								st.setString(1, user.getUsername());
								st.setString(2, rs.getString(1));
								st.setString(3, rs.getString(2));
								st.setString(4, rs.getString(3));
								st.setString(5, rs.getString(4));
								st.executeUpdate();

							}
							// System.out.println(rs.getString(1)+" "+rs.getString(2)+" " +
							// rs.getString(3));
						} catch (SQLException e) {
							System.out.println("Please");
							e.printStackTrace();
						}

					}
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(event.getSource() == addbus && custom.getText().equals("Catalog"))
    	{
    		DbConnect db = new DbConnect();
    		
    		Connection con = db.getConnection();
    		
    		PreparedStatement st;
			try {
				
					
							String sq = "INSERT INTO `Busket`(`Username`,`ID`, `Name`, `Description`, `Price`,`Quanity`) VALUES (?,?,?,?,?,?)";
						
									st = con.prepareStatement(sq);
									st.setString(1,user.getUsername());
									st.setString(2,"00");
									st.setString(3,"Custom");
									st.setString(4,color.toString() + "Flowers" + "With a flower pot ? " +potcombo.getValue() +" Flowers Order" + ordercombo.getValue() + " ,flower size:  "+ sizecombo.getValue() );
									st.setString(5, customprice.getText());
									st.setString(6,amountcombo.getValue());
									
									st.executeUpdate();
									
						}
						
					
    				
    				
					
    			
    		
			 catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	}
		
		if (event.getSource() == OrderRepbtn) {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Reports.fxml"));

			try {
				Parent root = (Parent) loader.load();
				ReportsController rep = loader.getController();
				Stage stage = new Stage();
				stage.setScene(new Scene(root));
				stage.show();							
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if (event.getSource() == subscribeBtn) {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Subscription.fxml"));

			try {
				Parent root = (Parent) loader.load();
				SubscriptionController sub = loader.getController();
				Stage stage = new Stage();
				stage.setScene(new Scene(root));
				stage.show();	
				sub.recived1(user.getUsername());
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if (event.getSource() == Salebtn) {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Sale.fxml"));

			try {
				Parent root = (Parent) loader.load();
				SaleController sale = loader.getController();
				Stage stage = new Stage();
				stage.setScene(new Scene(root));
				stage.show();							
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// Login to database using an account
		if (event.getSource() == login) {

			user.setusername(tf_username.getText());
			user.setpassword(pf_password.getText());
			DbConnect db = new DbConnect();
			Connection connection = db.getConnection();
			try {
				Statement stmt = connection.createStatement();
				String sql = "SELECT * FROM users WHERE username = '" + user.getUsername() + " '  AND password = '"
						+ user.getPassword() + "'";
				ResultSet resultset = stmt.executeQuery(sql);
				if (resultset.next()) {
					if (resultset.getString(9).equals("0")) {
						client = new ClientConsole(user.getUsername(), "127.0.0.1", 5555);
						user.setId(resultset.getString(1));
						user.setfirstname(resultset.getString(2));
						user.setlastname(resultset.getString(3));
						user.setemail(resultset.getString(4));
						user.setusername(resultset.getString(5));
						user.setpassword(resultset.getString(6));
						user.setcard(resultset.getString(7));
						user.setDate(resultset.getString(8));
						user.setStatus(resultset.getString(9));
						user.setrank(resultset.getString(10));
						user.setphone(resultset.getString(11));
user.setType(resultset.getString(12));
						PreparedStatement stms;
						String q = "update users set Status = ? where username = '" + user.getUsername() + "'";
						stms = connection.prepareStatement(q);
						stms.setString(1, "1");
						stms.executeUpdate();
						btnlogin.setText("Logout");
						labname.setText(user.getUsername());
						CatControlpnl.toFront();
						CatControlpnl.setVisible(true);
						pnlCat.setVisible(true);
						Messagespnl.setVisible(false);
						table.setVisible(true);
						Signuppan.setVisible(false);
						Loginpan.setVisible(false);
						subscribeBtn.setVisible(true);
						labname.setText(user.getUsername());
//Buttons of catalog
						System.out.println(user.getRank());
						if(user.getRank().equals("2"))
						{
							System.out.println("a");
							additem.setVisible(true);
							delitem.setVisible(true);
							edititem.setVisible(true);
							OrderRepbtn.setVisible(true);
							Salebtn.setVisible(true);
							subscribeBtn.setVisible(false);
						}
						
						addbus.setVisible(true);
						custom.setVisible(true);
						mybusket.setVisible(true);
						Selectcol.setVisible(true);
						
						
						
						//Buttons of catalog
						// btnlogin.setText(user.getUsername());
						// btnlogin.setDisable(true);
						
						complaintbtn.setVisible(true);
						messagesbtn.setVisible(true);
						 btnfee.setVisible(true);
						if (resultset.getString(10).equals("2")) {
							btnuser.setVisible(true);
							//btnworker.setVisible(true);
							//btnsetting.setVisible(true);
						//	OrderRepbtn.setVisible(true);
							//Salebtn.setVisible(true);

						}
						
						
						
					} else {
						System.out.println("You're Already online");
					}
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		if (event.getSource() == signupbtn) {

			{
				
				userreg.setusername(tf_usernamesignup.getText());
				userreg.setpassword(pf_passwordsignup.getText());
				userreg.setemail(tf_emailSignup.getText());
				userreg.setcard(tf_CardSignup.getText());
				userreg.setfirstname(tf_firstnameSignup.getText());
				userreg.setlastname(tf_LastNameSignup.getText());
				userreg.setId(tf_IDSignup.getText());
				userreg.setphone(tf_phone.getText());
				userreg.setType(storecombo.getValue());
				userreg.setrank("0");
				/*user.setusername(tf_usernamesignup.getText());
				user.setpassword(pf_passwordsignup.getText());
				user.setemail(tf_emailSignup.getText());
				user.setcard(tf_CardSignup.getText());
				user.setfirstname(tf_firstnameSignup.getText());
				user.setlastname(tf_LastNameSignup.getText());
				user.setId(tf_IDSignup.getText());
				user.setphone(tf_phone.getText());
				user.setType(storecombo.getValue());
				user.setrank("0");*/
			}

			DbConnect db = new DbConnect();
			Connection connection = db.getConnection();
			String q = "INSERT INTO users(username,email,password,ID,Firstname,Lastname,CreditCard,phone,Type) VALUES(?,?,?,?,?,?,?,?,?)";

			PreparedStatement stms;
			try {

				stms = connection.prepareStatement(q);
				stms.setString(1, userreg.getUsername());
				stms.setString(2, userreg.getEmail());
				stms.setString(3, userreg.getPassword());
				stms.setString(4, userreg.getId());
				stms.setString(5, userreg.getFirstname());
				stms.setString(6, userreg.getLastname());
				stms.setString(7, userreg.getCard());
				stms.setString(8, userreg.getphone());
				stms.setString(9, userreg.getType());
				if (stms.executeUpdate() > 0) {
					//client = new ClientConsole(user.getUsername(), "127.0.0.1", 5555);
				//	CatControlpnl.toFront();
					Signuppan.setVisible(false);
					Loginpan.setVisible(true);
				//	labname.setText(user.getUsername());

					//btnlogin.setVisible(false);
					//btnlogin.setText("Logout");
					//CatControlpnl.toFront();
					//Signuppan.setVisible(false);
					//Loginpan.setVisible(false);
					//labname.setText(user.getUsername());
				//	System.out.println(user.getRank());
				//if(user.getRank().equals("2"))
					//{
						//System.out.println("a");
						//OrderRepbtn.setVisible(true);
						//Salebtn.setVisible(true);
				//	}
					
				//	addbus.setVisible(true);
					//custom.setVisible(true);
					//mybusket.setVisible(true);
					//Selectcol.setVisible(true);
				}
  /* stms.setString(3,  userreg.getPassword());    
   stms.setString(4, userreg.getId());
   stms.setString(5,userreg.getFirstname());
   stms.setString(6,userreg.getLastname());
   stms.setString(7,userreg.getCard());
   stms.setString(8,userreg.getphone());
   stms.setString(9,userreg.getType());
   if(stms.executeUpdate()>0)
   {
    client = new ClientConsole(user.getUsername(),"127.0.0.1",5555);
   CatControlpnl.toFront();
  	Signuppan.setVisible(false);
      Loginpan.setVisible(false);
     labname.setText(user.getUsername());
  
     btnlogin.setVisible(false);
   }*/
				
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (event.getSource() == btnuser) {

			UserControlpnl.toFront();
			Messagespnl.setVisible(false);

			CatControlpnl.setVisible(false);
			Signuppan.setVisible(false);
			Loginpan.setVisible(false);
			Complaintpnl.setVisible(false);
			UserControlpnl.setVisible(true);
			Orderspnl.setVisible(false);

		}
		if (event.getSource() == additem) {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Item.fxml"));
			try {
				Parent root = (Parent) loader.load();
				ItemController ite = loader.getController();
				Stage stage = new Stage();
				stage.setScene(new Scene(root));
				stage.show();
				ite.received(client);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// ItemController ite = new ItemController ();
			//
			// ite.OpenScene();
			// ite.decider = false;
		}

		if (event.getSource() == edititem) {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("EditItem.fxml"));

			try {
				Parent root = (Parent) loader.load();
				ItemController ite = loader.getController();
				Stage stage = new Stage();
				stage.setScene(new Scene(root));
				stage.show();
				ItemController t = table.getSelectionModel().getSelectedItem();
				ite.ID2.setText(t.getId());
				ite.Name2.setText(t.getname());
				ite.Price2.setText(t.getprice());
				ite.Desription2.setText(t.getdescription());
				ite.received(client);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		if (event.getSource() == edituser) {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Edituser.fxml"));

			try {
				Parent root = (Parent) loader.load();
				UserController userr = loader.getController();
				Stage stage = new Stage();
				stage.setScene(new Scene(root));
				stage.show();
				User u = TableUser.getSelectionModel().getSelectedItem();
				userr.textid.setText(user.getId());
				userr.textCreditcard.setText(user.getCard());
				userr.textemail.setText(user.getEmail());
				userr.textfirstname.setText(user.getFirstname());
				userr.textlastname.setText(user.getLastname());
				userr.textPassword.setText(user.getPassword());
				userr.textPhone.setText(user.getphone());
				userr.textRank.setText(user.getRank());
				userr.textUsername.setText(user.getUsername());
			
				userr.received(client);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		if (event.getSource() == delitem) {
			oblist.clear();
			DbConnect db = new DbConnect();
			int i = 0;

			try {
				Connection connection = db.getConnection();
				ResultSet rs = connection.createStatement().executeQuery("SELECT * From item");
				while (rs.next()) {
					CheckBox ch = new CheckBox("" + i);
					ItemController s = new ItemController();
					if(user.getType() == "1")
					s.ItemControllers(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(6), ch);
					else if(user.getType() == "2")
					{
						s.ItemControllers(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(7), ch);
					}
					else {
						s.ItemControllers(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), ch);
					}
					oblist.add(s);
					i++;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			idcol.setCellValueFactory(new PropertyValueFactory<>("id"));

			namecol.setCellValueFactory(new PropertyValueFactory<>("name"));

			descol.setCellValueFactory(new PropertyValueFactory<>("description"));

			pricecol.setCellValueFactory(new PropertyValueFactory<>("price"));

			Selectcol.setCellValueFactory(new PropertyValueFactory<>("checkbox"));
			table.setItems(null);
			table.setItems(oblist);

			table.setEditable(true);
			idcol.setCellFactory(TextFieldTableCell.forTableColumn());
		}
		if (event.getSource() == adduser) {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Edituser.fxml"));
			try {
				Parent root = (Parent) loader.load();
				Stage stage = new Stage();
				stage.setScene(new Scene(root));
				stage.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if (event.getSource() == deluser) {
			User t = TableUser.getSelectionModel().getSelectedItem();
			DbConnect db = new DbConnect();
			Connection connection = db.getConnection();
			Connection con = db.getConnection();
			Statement stmt;
			try {

					stmt = connection.createStatement();
					
			String p="DELETE FROM `users` WHERE Username = '"+t.getUsername()+"'";
			stmt.executeUpdate(p);
			stmt.close();
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	}

	@FXML
	public void log(MouseEvent event) {
		Loginpan.toFront();
		Loginpan.setVisible(true);
		Signuppan.setVisible(false);

		CatControlpnl.setVisible(false);

		Complaintpnl.setVisible(false);
		UserControlpnl.setVisible(false);
		Orderspnl.setVisible(false);

	}

	@FXML
	public void signup(MouseEvent event) {
		Signuppan.toFront();
		Signuppan.setVisible(true);
		Loginpan.setVisible(false);
		CatControlpnl.setVisible(false);

		Loginpan.setVisible(false);
		Complaintpnl.setVisible(false);
		UserControlpnl.setVisible(false);
		Orderspnl.setVisible(false);

	}

	ObservableList<User> olist = FXCollections.observableArrayList(); // Users Table View
	ObservableList<ItemController> oblist = FXCollections.observableArrayList(); // Catalog Table View

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
//Catalog Table View
		combo.setItems(comlist);
		storecombo.setItems(storelist);
		//Customeitem
		amountcombo.setItems(amountlist);

		
	 potcombo.setItems(potlist);

		   ordercombo.setItems(orderlist);

		   sizecombo.setItems(sizelist);

		DbConnect db = new DbConnect();

		try {
			int i = 0;
			Connection connection = db.getConnection();
			ResultSet rs = connection.createStatement().executeQuery("SELECT * From item");
			while (rs.next()) {
				CheckBox ch = new CheckBox("" + i);
				ItemController s = new ItemController();
				if(user.getType() != null)
				{
				if(user.getType() == "1")
					s.ItemControllers(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(6), ch);
					else if(user.getType() == "2")
					{
						s.ItemControllers(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(7), ch);
					}
					else {
						s.ItemControllers(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), ch);
					}
				}
				else if(user.getType()==null)
				{
					s.ItemControllers(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), ch);
				}
					
				oblist.add(s);
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		idcol.setCellValueFactory(new PropertyValueFactory<>("id"));

		namecol.setCellValueFactory(new PropertyValueFactory<>("name"));

		descol.setCellValueFactory(new PropertyValueFactory<>("description"));

		pricecol.setCellValueFactory(new PropertyValueFactory<>("price"));
		Selectcol.setCellValueFactory(new PropertyValueFactory<>("checkbox"));

		table.setItems(null);
		table.setItems(oblist);

		table.setEditable(true);
		idcol.setCellFactory(TextFieldTableCell.forTableColumn());

//Users Table View
		try {
			Connection conn = db.getConnection();
			ResultSet rs = conn.createStatement().executeQuery("SELECT * From users");
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getString(1));
				user.setfirstname(rs.getString(2));
				user.setlastname(rs.getString(3));
				user.setemail(rs.getString(4));
				user.setusername(rs.getString(5));
				user.setpassword(rs.getString(6));

				user.setcard(rs.getString(7));
				user.setDate(rs.getString(8));
				user.setStatus(rs.getString(9));
				olist.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		IDUser.setCellValueFactory(new PropertyValueFactory<>("id"));

		FirstUser.setCellValueFactory(new PropertyValueFactory<>("firstname"));

		LastUser.setCellValueFactory(new PropertyValueFactory<>("lastname"));

		MailUser.setCellValueFactory(new PropertyValueFactory<>("email"));
		UsernameUser.setCellValueFactory(new PropertyValueFactory<>("username"));
		PassUser.setCellValueFactory(new PropertyValueFactory<>("password"));
		CardUser.setCellValueFactory(new PropertyValueFactory<>("card"));
		DateUser.setCellValueFactory(new PropertyValueFactory<>("date"));
		StatusUser.setCellValueFactory(new PropertyValueFactory<>("status"));

		TableUser.setItems(null);
		TableUser.setItems(olist);

	}
	

	public void ChangeFirst(CellEditEvent editedCell) {
		ItemController item = table.getSelectionModel().getSelectedItem();
		item.setId(editedCell.getNewValue().toString());
	}

	public void ChangeID(CellEditEvent editedCell) {
		ItemController item = table.getSelectionModel().getSelectedItem();
		item.setId(editedCell.getNewValue().toString());

		
	}
	

	public void ChangeD(CellEditEvent editedCell) {
		ItemController item = table.getSelectionModel().getSelectedItem();
		item.setdescription(editedCell.getNewValue().toString());

	}

	public void Changeprice(CellEditEvent editedCell) {
		ItemController item = table.getSelectionModel().getSelectedItem();
		item.setprice(editedCell.getNewValue().toString());

	}
	
	
}
