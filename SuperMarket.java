/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import item.view.ItemView;
import Customer.view.CustomerView;
import Order.view.OrderView;
/**
 *
 * @author Uthsara Basnayake
 */
public class SuperMarket {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new ItemView().setVisible(true);
        new CustomerView().setVisible(true);
        new OrderView().setVisible(true);
    }
    
}
