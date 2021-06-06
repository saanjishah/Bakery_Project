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
public class Menu {
    private String itemName = "";
    private int indexPassedIn;
    private int totalItems = 0;
    private double itemPrice = 0.0, itemTime;
    double prices[] = new double[3];
    double times[] = new double[3];
    String cakeRecipe[] = new String[5];
    String cookieRecipe[] = new String[5];
    String pieRecipe[] = new String[7];
    String SSRecipe[] = new String[6];
    String brownieRecipe[] = new String[7];
    String PBCRecipe[] = new String[6];
    String PBCCCRecipe[] = new String[7];
    String SPRecipe[] = new String[7];
    String SCRecipe[] = new String[6];
    String CCSRecipe[] = new String[2];
    public Menu(){
        itemName = "";
    }
    public Menu(String name, int index){
        itemName = name;
        indexPassedIn = index;
        prices[0] = 8.99;
        prices[1] = 13.99;
        prices[2] = 17.99;
        setItemPrice();
//        setItemTime();
    }
    public void setItemPrice(){
        if(indexPassedIn<3){
            itemPrice = prices[0];
        }
        else if (indexPassedIn<7){
            itemPrice = prices[1];
        }else if(indexPassedIn<10){
            itemPrice = prices[2];
        }
    }
//    public void setItemTime(){
//        if(indexPassedIn<5){
//            itemTime = 10;
//            System.out.println(itemTime);
//            times[indexPassedIn] = itemTime;
//        }
//    }
    public void setRecipe(){
        //The number represents how many times the user should click the button
        //Cake
        cakeRecipe[0] = "2 Sugar";
        cakeRecipe[1] = "1 Butter";
        cakeRecipe[2] = "2 Vanilla Extract";
        cakeRecipe[3] = "4 Flour";
        cakeRecipe[4] = "2 Milk";
        //Sugar Cookie
        cookieRecipe[0] = "3 Flour";
        cookieRecipe[1] = "1 Salt";
        cookieRecipe[2] = "1 Sugar";
        cookieRecipe[3] = "9 Butter";
        cookieRecipe[4] = "2 Vanilla Extract";
        //Pie
        pieRecipe[0] = "1 Flour";
        pieRecipe[1] = "1 Oil";
        pieRecipe[2] = "1 Water";
        pieRecipe[3] = "1 Salt";
        pieRecipe[4] = "2 Apples";
        pieRecipe[5] = "2 Sugar";
        pieRecipe[6] = "1 Cinnamon";
        //Strawberry Shortcake
        SSRecipe[0] = "2 Sugar";
        SSRecipe[1] = "1 Butter";
        SSRecipe[2] = "2 Vanilla Extract";
        SSRecipe[3] = "4 Flour";
        SSRecipe[4] = "2 Milk";
        SSRecipe[5] = "3 Strawberries";
        //brownie
        brownieRecipe[0] = "3 Flour";
        brownieRecipe[1] = "1 Salt";
        brownieRecipe[2] = "1 Sugar";
        brownieRecipe[3] = "1 Butter";
        brownieRecipe[4] = "2 Milk";
        brownieRecipe[5] = "2 Vanilla Extract";
        brownieRecipe[6] = "3 Cocoa Powder";
        //Peanut Butter Cookie
        PBCRecipe[0] = "2 Sugar";
        PBCRecipe[1] = "9 Butter";
        PBCRecipe[2] = "2 Vanilla Extract";
        PBCRecipe[3] = "4 Flour";
        PBCRecipe[4] = "2 Milk";
        PBCRecipe[5] = "5 Peanut Butter";
        //Peanut Butter Chocolate Chip Cookies
        PBCCCRecipe[0] = "2 Sugar";
        PBCCCRecipe[1] = "9 Butter";
        PBCCCRecipe[2] = "2 Vanilla Extract";
        PBCCCRecipe[3] = "4 Flour";
        PBCCCRecipe[4] = "2 Milk";
        PBCCCRecipe[5] = "7 Chocolate Chip";
        PBCCCRecipe[6] = "2 Peanut Butter";
        //Strawberry Cake
        SCRecipe[0] = "3 Flour";
        SCRecipe[1] = "1 Salt";
        SCRecipe[2] = "1 Sugar";
        SCRecipe[3] = "1 Butter";
        SCRecipe[4] = "2 Vanilla Extract";
        SCRecipe[5] = "5 Strawberries";
        //Strawberry Pie
        SPRecipe[0] = "1 Flour";
        SPRecipe[1] = "1 Oil";
        SPRecipe[2] = "1 Water";
        SPRecipe[3] = "1 Salt";
        SPRecipe[4] = "2 Strawberries";
        SPRecipe[5] = "2 Sugar";
        SPRecipe[6] = "1 Cinnamon";
        //Chocolate Covered Strawberries
        CCSRecipe[0] = "3 Strawberries";
        CCSRecipe[1] = "6 Chocolate Chips";
    }
    public String getName(){
        return itemName;
    }
    public double getPrice(){
        return itemPrice;
    }
    public double getItemTime(String itemName){
        //Change later
        if(itemName.equals("Cake")){
            return 10;
        }else if(itemName.equals("Cookie")){
            return 10;
        }else if(itemName.equals("Chocolate Covered Strawberries")){
            return 10;
        }else if(itemName.equals("Pie")){
            return 10;
        }else if(itemName.equals("Strawberry Pie")){
            return 10;
        }else if(itemName.equals("Strawberry Cake")){
            return 10;
        }else if(itemName.equals("Peanut Butter Cookies")){
            return 10;
        }else if(itemName.equals("Peanut Butter Chocolate Chip Cookies")){
            return 10;
        }else if(itemName.equals("Strawberry Shortcake")){
            return 10;
        }else{
            return 10;
        }
    }
    public String getRecipe(String itemName, int itemIndex){
        if(itemName.equals("Cake")){
            return cakeRecipe[itemIndex];
        }else if(itemName.equals("Cookie")){
            return cookieRecipe[itemIndex];
        }else if(itemName.equals("Chocolate Covered Strawberries")){
            return CCSRecipe[itemIndex];
        }else if(itemName.equals("Pie")){
            return pieRecipe[itemIndex];
        }else if(itemName.equals("Brownies")){
            return brownieRecipe[itemIndex];
        }else if(itemName.equals("Strawberry Pie")){
            return SPRecipe[itemIndex];
        }else if(itemName.equals("Strawberry Cake")){
            return SCRecipe[itemIndex];
        }else if(itemName.equals("Peanut Butter Cookies")){
            return PBCRecipe[itemIndex];
        }else if(itemName.equals("Peanut Butter Chocolate Chip Cookies")){
            return PBCCCRecipe[itemIndex];
        }else if(itemName.equals("Strawberry Shortcake")){
            return SSRecipe[itemIndex];
        }else{
            return pieRecipe[itemIndex];
        }
    }
}
