/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Customer.controller;
import java.sql.Connection;
import item.db.DBConnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import Customer.model.CustomerModel;
/**
 *
 * @author ASUS
 */
public class CustomerController {
    public String saveCustomer (CustomerModel customer) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "INSERT INTO customer VALUES(?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedstatement = connection.prepareStatement(query);
        preparedstatement.setString(1, customer.getId());
        preparedstatement.setString(2, customer.getTitle());
        preparedstatement.setString(3, customer.getFirstName());
        preparedstatement.setString(4, customer.getLastName());
        preparedstatement.setString(5, customer.getAddress());
        preparedstatement.setString(6, customer.getZipcode());
        preparedstatement.setInt(7, customer.getAge()); 
        preparedstatement.setString(8, customer.getMobile());
        preparedstatement.setString(9, customer.getGender());
           
        
        if(preparedstatement.executeUpdate()>0){
            return "Sucess";
            
        }else{return "Failed";
}
    }
    public String deleteCustomer(CustomerModel cm)throws SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "DELETE FROM customer WHERE ID=(?)" ;
         PreparedStatement preparedstatement = connection.prepareStatement(query);
          preparedstatement.setString(1, cm.getId());
          
           if(preparedstatement.executeUpdate()>0){
            return "Sucess";
            
        }else{return "Failed";
    }
}
    
     public String updateCustomer(CustomerModel cm)throws SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "UPDATE customer\n" +
"SET ID=(?), ItemName = (?),  ItemPrice = (?)\n" +
"WHERE QTY = (?);" ;
         PreparedStatement preparedstatement = connection.prepareStatement(query);
          preparedstatement.setString(1, cm.getId());
           preparedstatement.setString(2, cm.getTitle());
           preparedstatement.setString(3, cm.getFirstName());
            preparedstatement.setString(4, cm.getLastName());
            preparedstatement.setString(5, cm.getAddress());
            preparedstatement.setString(6, cm.getZipcode());
            preparedstatement.setInt(7, cm.getAge());
            preparedstatement.setString(8, cm.getMobile());
            preparedstatement.setString(9, cm.getGender());
            
          
           if(preparedstatement.executeUpdate()>0){
            return "Sucess";
            
        }else{return "Failed";
    }
}
     
      public static ArrayList<CustomerModel> getAllCustomers() throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();

        String query = "Select * FROM customer";

        PreparedStatement statement = connection.prepareStatement(query);

        ResultSet rst = statement.executeQuery();

        ArrayList<CustomerModel> customerModels = new ArrayList<>();

        while (rst.next()) {
            CustomerModel cm;
            cm = new CustomerModel(rst.getString(1),
                    rst.getString(2), rst.getString(3),  rst.getString(4),rst.getString(5),rst.getString(6),(int)rst.getDouble(7),rst.getString(8),rst.getString(9));
            customerModels.add(cm);
        }
        return customerModels;
}
      public CustomerModel searchCustomer(String id) throws SQLException{
Connection connection =DBConnection.getInstance().getConnection();
String query = "Select * FROM customer WHERE id=?";

        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, id);
        ResultSet rst =statement.executeQuery();
while(rst.next()){
    CustomerModel cm;
    cm = new CustomerModel(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getString(6),rst.getInt(7),rst.getString(8),rst.getString(9));
    return cm;
}return null;
      }
}
