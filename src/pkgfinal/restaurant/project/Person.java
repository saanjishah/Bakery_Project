/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal.restaurant.project;

/**
 *
 * @author Saanji Shah
 */
public class Person {
    private String custName = "", custOrder = "";
    private double custTotal = 0, custTip;
    private int numItemOrder = (int) Math.floor(Math.random()*5)+1;//The 3 should change depending on how many items are in the menu
    public Person(String name){
        setCustName(name);
    }
    public void setCustName(String name){
        custName = name;
    }
    public void setCustTip(){
        //This will later be based on the financial status of the customer
        custTip = custTotal * 0.15;
        String tip = Double.toString(custTip);
        custTip = Double.parseDouble(tip.substring(0,(tip.indexOf(".")+3)));
    }
    public int getNumOrder(){
        //Returns the number of items ordered by the customer
        return numItemOrder;
    }
    public int whichItemIndex(){
        //This will later become based upon the financial status of the customer
        int whichItemOrder = (int) Math.floor(Math.random()*10)+1;//The 3 should change depending on how many items are in the menu
        //Can change it here to have each item only be ordered once
        return whichItemOrder;
    }
    public void setCustTotal(double itemPrice){
        custTotal += itemPrice;
    }
    public void setCustOrder(String itemName){
        custOrder = custOrder + itemName;
    }
    public void updateCustTotal(int change){
        custTotal = custTotal - change;
    }
    public String getCustName(){
        return custName;
    }
    public String getCustOrder(){
        return custOrder;
    }
    public double getCustTotal(){
        return custTotal;
    }
    public double getCustTip(){
        return custTip;
    }
}
