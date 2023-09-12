/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package item.controller;
import Customer.model.CustomerModel;
import item.model.ItemModel;
import java.sql.Connection;
import item.db.DBConnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
/**
 *
 * @author Uthsara Basnayake
 */
public class ItemController {
    public String saveItem (ItemModel item) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "INSERT INTO Item VALUES(?,?,?,?)";
        PreparedStatement preparedstatement = connection.prepareStatement(query);
        preparedstatement.setString(1, item.getID());
        preparedstatement.setString(2, item.getItemName());
        preparedstatement.setDouble(3, item.getItemPrice());
        preparedstatement.setDouble(4, item.getQty());
        
        if(preparedstatement.executeUpdate()>0){
            return "Sucess";
            
        }else{return "Failed";
}
    }
    public String deleteItem(ItemModel item)throws SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "DELETE FROM item WHERE ID=(?)" ;
         PreparedStatement preparedstatement = connection.prepareStatement(query);
          preparedstatement.setString(1, item.getID());
          
           if(preparedstatement.executeUpdate()>0){
            return "Sucess";
            
        }else{return "Failed";
    }
}
    
     public String updateItem(ItemModel item)throws SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "UPDATE item\n" +
"SET ID=(?), ItemName = (?),  ItemPrice = (?)\n" +
"WHERE QTY = (?);" ;
         PreparedStatement preparedstatement = connection.prepareStatement(query);
          preparedstatement.setString(1, item.getID());
           preparedstatement.setString(2, item.getItemName());
           preparedstatement.setDouble(3, item.getItemPrice());
            preparedstatement.setDouble(4, item.getQty());
          
           if(preparedstatement.executeUpdate()>0){
            return "Sucess";
            
        }else{return "Failed";
    }
}
     
      public static ArrayList<ItemModel> getAllItems() throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();

        String query = "Select * FROM item";

        PreparedStatement statement = connection.prepareStatement(query);

        ResultSet rst = statement.executeQuery();

        ArrayList<ItemModel> itemModels = new ArrayList<>();

        while (rst.next()) {
            ItemModel im = new ItemModel(rst.getString(1),
                   rst.getString(2), rst.getDouble(3), (int) rst.getDouble(4));
            itemModels.add(im);
        }
        return itemModels;
}

    public ItemModel searchItem(String id) throws SQLException{
Connection connection =DBConnection.getInstance().getConnection();
String query = "Select * FROM item WHERE id=?";

        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, id);
        ResultSet rst =statement.executeQuery();
while(rst.next()){
    ItemModel im;
    im = new ItemModel(rst.getString(1),rst.getString(2),Double.parseDouble(rst.getString(3)),(int)Double.parseDouble(rst.getString(4)));
    return im;
}return null;
      }
}