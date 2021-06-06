/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal.restaurant.project;

import java.awt.Rectangle;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.animation.AnimationTimer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javax.swing.JOptionPane;

/**
 *
 * @author shah1932
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label label;
    private String name = " ", level = "";
    private int numOfDays = 0, totalCusts = 0, numOfCustomers = 0, passedDays = 0, submittedMeals = 0, startIndex = 0, totalMeals = 0, whichCustomer = 0, whichSubmit = 0, countCustMeal = 0;
    private double totalCost = 0, totalRevenue = 0, totalTips = 0, totalProfit = 0, submitProbTime = -1, overallProbTime = -1, custTotalTime = 0, startCustWaitTime = 0.0, checkTime = 5000000000.0, checkAddCusts = 10000000000.0;
    private boolean cheat = false;
    Menu menuClass = new Menu();
    Ingredients ingClass = new Ingredients();
    ArrayList<Menu> menuArrList = new ArrayList<>();
    ArrayList<Integer> passCustArrList = new ArrayList<>();
    String menuFoodNames[] = new String[10];
    String[][] ingredients = new String[4][4];
    Button[][] ingredientsGPBtns = new Button[4][4];

    ArrayList<Person> custArrLists = new ArrayList<>();
    String customerNames[] = new String[30];
    @FXML
    private TextField fieldNameEnter;
    @FXML
    private Button buttonEasy, buttonMedium, buttonHard, buttonSubmit, button1, button5, button10, buttonInfinite, buttonCheat;
    @FXML
    private Text textNameEnter, textChooseLevel, textChooseDay, textHomeTitle, textHTP;
    @FXML
    private Label labelGameTitle, labelDay, labelCosts, labelRevenue, labelTips, labelProfit, labelCoverAll, labelIngCover, labelTime, labelInstructions, labelCoverAll2;
    @FXML
    private ListView listviewCustomers;
    ObservableList<String> custDisplayList = FXCollections.observableArrayList();
    @FXML
    private ListView listviewAdded;
    ObservableList<String> addDisplayList = FXCollections.observableArrayList();
    @FXML
    private ListView listviewSubmitMeal;
    ObservableList<String> subMealDisplayList = FXCollections.observableArrayList();
    @FXML
    private ListView listviewRecipe;
    ObservableList<String> recipeDisplayList = FXCollections.observableArrayList();
    @FXML
    private GridPane gridpaneIngredients;
    @FXML
    private GridPane gridpaneSubmitMeal;

    @FXML
    private void clickedEasy(ActionEvent event) {
        totalCusts = 3;//10;
        level = "Easy";
        checkAddCusts = 20000000000.0;
        button1.setDisable(false);
        button5.setDisable(false);
        button10.setDisable(false);
        buttonInfinite.setDisable(false);
        buttonEasy.setDisable(true);
        buttonMedium.setDisable(true);
        buttonHard.setDisable(true);
    }

    @FXML
    private void clickedMedium(ActionEvent event) {
        totalCusts = 15;
        checkAddCusts = 15000000000.0;
        level = "Medium";
        button1.setDisable(false);
        button5.setDisable(false);
        button10.setDisable(false);
        buttonInfinite.setDisable(false);
        buttonEasy.setDisable(true);
        buttonMedium.setDisable(true);
        buttonHard.setDisable(true);
    }

    @FXML
    private void clickedHard(ActionEvent event) {
        totalCusts = 25;
        checkAddCusts = 10000000000.0;
        level = "Hard";
        button1.setDisable(false);
        button5.setDisable(false);
        button10.setDisable(false);
        buttonInfinite.setDisable(false);
        buttonEasy.setDisable(true);
        buttonMedium.setDisable(true);
        buttonHard.setDisable(true);
    }

    @FXML
    private void clickedSubmit(ActionEvent event) {
        name = fieldNameEnter.getText();
        fieldNameEnter.clear();
        if(name.equals("saanji")){
            buttonCheat.setDisable(false);
        }else{
            buttonCheat.setDisable(true);
        }
        buttonEasy.setDisable(false);
        buttonMedium.setDisable(false);
        buttonHard.setDisable(false);
        buttonSubmit.setDisable(true);
        fieldNameEnter.setDisable(true);
    }

    @FXML
    private void clickedDay1(ActionEvent event) {
        numOfDays = 1;
        button1.setDisable(true);
        button5.setDisable(true);
        button10.setDisable(true);
        buttonInfinite.setDisable(true);
        start();
    }

    @FXML
    private void clickedDay5(ActionEvent event) {
        numOfDays = 5;
        button1.setDisable(true);
        button5.setDisable(true);
        button10.setDisable(true);
        buttonInfinite.setDisable(true);
        start();
    }

    @FXML
    private void clickedDay10(ActionEvent event) {
        numOfDays = 10;
        button1.setDisable(true);
        button5.setDisable(true);
        button10.setDisable(true);
        buttonInfinite.setDisable(true);
        start();
    }

    @FXML
    private void clickedDayI(ActionEvent event) {
        numOfDays = 0;//0 means never ending
        button1.setDisable(true);
        button5.setDisable(true);
        button10.setDisable(true);
        buttonInfinite.setDisable(true);
        start();
    }
    @FXML
    private void cheat(ActionEvent event) {
        cheat = true;
        
    }
    @FXML
    private void startGame(ActionEvent event) {
        overallTimer();
        labelIngCover.setVisible(false);
        passedDays++;
        labelDay.setText("Day: " + passedDays);
        initializeFood();
        initializeIngredients();
        setCustomerNames();

        for (int i = 0; i < ingredientsGPBtns.length; i++) {
            for (int j = 0; j < ingredientsGPBtns.length; j++) {
                ingredientsGPBtns[i][j] = new Button(ingredients[i][j]);//a new object of a button is created---button objects that take the form of a button but don't do anything here
                ingredientsGPBtns[i][j].setPrefSize(120, 100);
                //Paramters:  object, columns, rows
                gridpaneIngredients.add(ingredientsGPBtns[i][j], j, i);
            }
        }
        EventHandler z = new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                String cost;
                int x = GridPane.getRowIndex(((Button) t.getSource()));
                int y = GridPane.getColumnIndex(((Button) t.getSource()));
                listviewAdded.setItems(addDisplayList);
                addDisplayList.add(ingredients[x][y]);
                totalCost += ingClass.getPrice(x, y);
                cost = Double.toString(totalCost);
                if (cost.length() > 5) {
                    totalCost = Double.parseDouble(cost.substring(0, (cost.indexOf(".") + 3)));
                    //Later on add rounding with string and int using if statements
                }
                labelCosts.setText(Double.toString(totalCost));
                calculateProfit(false);
            }

        };
        for (int i = 0; i < ingredientsGPBtns.length; i++) {
            for (int j = 0; j < ingredientsGPBtns.length; j++) {
                ingredientsGPBtns[i][j].setOnAction(z);
            }
        }

    }

    private void start() {
        buttonEasy.setVisible(false);
        buttonMedium.setVisible(false);
        buttonHard.setVisible(false);
        buttonSubmit.setVisible(false);
        button1.setVisible(false);
        button5.setVisible(false);
        button10.setVisible(false);
        buttonInfinite.setVisible(false);
        textHomeTitle.setVisible(false);
        textNameEnter.setVisible(false);
        textChooseLevel.setVisible(false);
        textChooseDay.setVisible(false);
        fieldNameEnter.setVisible(false);
        labelGameTitle.setText(name + "'s Bakery");
        labelCoverAll.setVisible(false);
        labelIngCover.setVisible(true);
    }

    private void submitTimer() {
        //timer
        submitProbTime = System.nanoTime();
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (submitProbTime > 0) {
                    labelTime.setText(Integer.toString((int) Math.floor((now - submitProbTime) / 1000000000.0)));
                    if (now - submitProbTime > (custTotalTime * 1000000000.0) + checkTime) {//9 zeros\
//                        custArrLists.get(whichCustomer).updateCustTotal(2);
                        totalRevenue -= 2.0;
//                            labelRevenue.setText(Double.toString(totalRevenue));
                        checkTime += 5000000000.0;
                    }
                }
            }
        }.start();
    }

    private void overallTimer() {
        //timer
        overallProbTime = System.nanoTime();
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (overallProbTime > 0) {
                    if (numOfCustomers >= 1) {
                        if (now - overallProbTime > checkAddCusts && numOfCustomers < totalCusts) {//9 zeros\
                            initializeCustomers(numOfCustomers);
                            checkAddCusts += checkAddCusts;
                        }
                    } else if (numOfCustomers == 0) {
                        initializeCustomers(0);
                    }
                    //Attempted to have the customer leave after waiting too long
//                        if(level.equals("Hard")){
//                            startCustWaitTime = now - overallProbTime;
//                            if(startCustWaitTime > 25){
//                                if(custArrLists.get(numOfCustomers).getCustTotal() > 10){
//                                    custArrLists.get(numOfCustomers).updateCustTotal(10.0);
//                                }else{
//                                    custArrLists.remove(numOfCustomers);
//                                }
//                            }
//                        }
                }
            }
        }.start();
    }

    private void initializeFood() {
        //sets menu
        menuFoodNames[0] = "Chocolate Covered Strawberries";
        menuFoodNames[1] = "Brownies";
        menuFoodNames[2] = "Cookie";
        menuFoodNames[3] = "Cake";
        menuFoodNames[4] = "Pie";
        menuFoodNames[5] = "Strawberry Pie";
        menuFoodNames[6] = "Strawberry Cake";
        menuFoodNames[7] = "Peanut Butter Cookies";
        menuFoodNames[8] = "Peanut Butter Chocolate Chip Cookies";
        menuFoodNames[9] = "Strawberry Shortcake";

//        menuFoodNames[0] = "Cake";
//        menuFoodNames[1] = "Cookie";
//        menuFoodNames[2 ] = "Pie";
        //Once more food is added, have a new object be created, and pass the name of the item, and the index of the item in the array
        for (int i = 0; i < menuFoodNames.length; i++) {
            menuArrList.add(new Menu(menuFoodNames[i], i));
        }

    }

    private void initializeIngredients() {
        //iniitalizes ingredients
        ingredients[0][0] = "Flour";
        ingredients[0][1] = "Sugar";
        ingredients[0][2] = "Butter";
        ingredients[0][3] = "Vanilla Extract";
        ingredients[1][0] = "Milk";
        ingredients[1][1] = "Salt";
        ingredients[1][2] = "Oil";
        ingredients[1][3] = "Water";
        ingredients[2][0] = "Cinnamon";
        ingredients[2][1] = "Chocolate Chips";
        ingredients[2][2] = "Cocoa Powder";
        ingredients[2][3] = "Baking Soda";
        ingredients[3][0] = "Baking Powder";
        ingredients[3][1] = "Peanut Butter";
        ingredients[3][2] = "Apples";
        ingredients[3][3] = "Strawberries";
        menuClass.setRecipe();
    }

    private void setCustomerNames() {
        //iniitalizes ingredients
        customerNames[0] = "a";
        customerNames[1] = "b";
        customerNames[2] = "c";
        customerNames[3] = "d";
        customerNames[4] = "e";
        customerNames[5] = "f";
        customerNames[6] = "g";
        customerNames[7] = "h";
        customerNames[8] = "i";
        customerNames[9] = "j";
        customerNames[10] = "k";
        customerNames[11] = "l";
        customerNames[12] = "m";
        customerNames[13] = "n";
        customerNames[14] = "o";
        customerNames[15] = "p";
        customerNames[16] = "q";
        customerNames[17] = "r";
        customerNames[18] = "s";
        customerNames[19] = "t";
        customerNames[20] = "u";
        customerNames[21] = "v";
        customerNames[22] = "w";
        customerNames[23] = "x";
        customerNames[24] = "y";
        customerNames[25] = "z";
        customerNames[26] = "aa";
        customerNames[27] = "bb";
        customerNames[28] = "cc";
        customerNames[29] = "dd";
    }

    private void initializeCustomers(int i) {
        //initializes customers
        int whichCustName = (int) Math.floor(Math.random()*30);
        custArrLists.add(new Person(customerNames[whichCustName]));
        listviewCustomers.setItems(custDisplayList);
        for (int j = 0; j < custArrLists.get(i).getNumOrder(); j++) {
            custArrLists.get(i).setCustOrder(menuArrList.get((custArrLists.get(i).whichItemIndex()) - 1).getName());
            custArrLists.get(i).setCustTotal(menuArrList.get((custArrLists.get(i).whichItemIndex()) - 1).getPrice());
            custArrLists.get(i).setCustTip();
        }
        custDisplayList.add((i + 1) + " " + custArrLists.get(i).getCustName() + "    " + custArrLists.get(i).getCustTotal() + "   " + custArrLists.get(i).getCustTip());
        listviewSubmitMeal.setItems(subMealDisplayList);
        subMealDisplayList.add(i, (i + 1) + " Submit");
        numOfCustomers++;
        totalMeals += custArrLists.get(i).getNumOrder();
    }

    private void setTotalTime(String order) {
        //Gets how much time the user gets to make the food
        int i = 0;
        while (i < order.length()) {
            if ((order.substring(i, i + 3)).equals("Pie")) {
                custTotalTime += menuClass.getItemTime("Pie");
                i += 3;
            } else if ((order.substring(i, i + 4)).equals("Cake")) {
                custTotalTime += menuClass.getItemTime("Cake");
                i += 4;
            } else if ((order.substring(i, i + 6)).equals("Cookie")) {
                custTotalTime += menuClass.getItemTime("Cookie");
                i += 6;
            } else if ((order.substring(i, i + 8)).equals("Brownies")) {
                custTotalTime += menuClass.getItemTime("Brownies");
                i += 8;
            } else if ((order.substring(i, i + 14)).equals("Strawberry Pie")) {
                custTotalTime += menuClass.getItemTime("Strawberry Pie");
                i += 14;
            } else if ((order.substring(i, i + 15)).equals("Strawberry Cake")) {
                custTotalTime += menuClass.getItemTime("Strawberry Cake");
                i += 15;
            } else if ((order.substring(i, i + 20)).equals("Strawberry Shortcake")) {
                custTotalTime += menuClass.getItemTime("Strawberry Shortcake");
                i += 20;
            } else if ((order.substring(i, i + 21)).equals("Peanut Butter Cookies")) {
                custTotalTime += menuClass.getItemTime("Peanut Butter Cookies");
                i += 21;
            } else if ((order.substring(i, i + 30)).equals("Chocolate Covered Strawberries")) {
                custTotalTime += menuClass.getItemTime("Chocolate Covered Strawberries");
                i += 30;
            } else {
                custTotalTime += menuClass.getItemTime("Peanut Butter Chocolate Chip Cookies");
                i += 36;
            }
        }
        System.out.println("Total Time: " + custTotalTime);
    }

    private void setRecipeList(String custOrder) {
        //This function decides which recipe to display based on the next item that was ordered
        recipeDisplayList.clear();
        if ((custOrder.substring(0, 3)).equals("Pie")) {
            listviewRecipe.setItems(recipeDisplayList);
            startIndex += 3;
            for (int i = 0; i < 7; i++) {
                recipeDisplayList.add(menuClass.getRecipe("Pie", i));
            }
        } else if ((custOrder.substring(0, 4)).equals("Cake")) {
            listviewRecipe.setItems(recipeDisplayList);
            startIndex += 4;
            for (int i = 0; i < 5; i++) {
                recipeDisplayList.add(menuClass.getRecipe("Cake", i));
            }
        } else if ((custOrder.substring(0, 6)).equals("Cookie")) {
            listviewRecipe.setItems(recipeDisplayList);
            startIndex += 6;
            for (int i = 0; i < 5; i++) {
                recipeDisplayList.add(menuClass.getRecipe("Cookie", i));
            }
        } else if ((custOrder.substring(0, 8)).equals("Brownies")) {
            listviewRecipe.setItems(recipeDisplayList);
            startIndex += 8;
            for (int i = 0; i < 7; i++) {
                recipeDisplayList.add(menuClass.getRecipe("Brownies", i));
            }
        } else if ((custOrder.substring(0, 14)).equals("Strawberry Pie")) {
            listviewRecipe.setItems(recipeDisplayList);
            startIndex += 14;
            for (int i = 0; i < 7; i++) {
                recipeDisplayList.add(menuClass.getRecipe("Strawberry Pie", i));
            }
        } else if ((custOrder.substring(0, 15)).equals("Strawberry Cake")) {
            listviewRecipe.setItems(recipeDisplayList);
            startIndex += 15;
            for (int i = 0; i < 6; i++) {
                recipeDisplayList.add(menuClass.getRecipe("Strawberry Cake", i));
            }
        } else if ((custOrder.substring(0, 20)).equals("Strawberry Shortcake")) {
            listviewRecipe.setItems(recipeDisplayList);
            startIndex += 20;
            for (int i = 0; i < 6; i++) {
                recipeDisplayList.add(menuClass.getRecipe("Strawberry Shortcake", i));
            }
        } else if ((custOrder.substring(0, 21)).equals("Peanut Butter Cookies")) {
            listviewRecipe.setItems(recipeDisplayList);
            startIndex += 21;
            for (int i = 0; i < 6; i++) {
                recipeDisplayList.add(menuClass.getRecipe("Peanut Butter Cookies", i));
            }
        } else if ((custOrder.substring(0, 30)).equals("Chocolate Covered Strawberries")) {
            listviewRecipe.setItems(recipeDisplayList);
            startIndex += 30;
            for (int i = 0; i < 2; i++) {
                recipeDisplayList.add(menuClass.getRecipe("Chocolate Covered Strawberries", i));
            }
        } else {
            listviewRecipe.setItems(recipeDisplayList);
            startIndex += 36;
            for (int i = 0; i < 7; i++) {
                recipeDisplayList.add(menuClass.getRecipe("Peanut Butter Chocolate Chip Cookies", i));
            }
        }
    }

    @FXML
    public void customerClick(MouseEvent event) {
        //what should happen when you click the listview with the customers
        whichCustomer = (listviewCustomers.getSelectionModel().getSelectedIndex());
        boolean passed = false;
        for (int i = 0; i < passCustArrList.size(); i++) {
            if (whichCustomer == passCustArrList.get(i)) {
                passed = true;
                break;
            }
        }
        if (!passed) {
            System.out.println("------------------------- Customer: " + (whichCustomer + 1) + " -------------------------");
            setRecipeList(custArrLists.get(whichCustomer).getCustOrder());
            setTotalTime(custArrLists.get(whichCustomer).getCustOrder());
            System.out.println("Order: " + custArrLists.get(whichCustomer).getCustOrder());
            custTotalTime = 0;
            submitTimer();
        }
    }
    //MFP
    @FXML
    public void submitClick(MouseEvent event) {
        //what should happen when you click the listview with the customers
        whichSubmit = (listviewSubmitMeal.getSelectionModel().getSelectedIndex());//This gets which submit was clicked on in the Listview
        /*This for loop checks if the customer was previously clicked on, and if their meal was already submitted. 
        If it was submitted, nothing will happen, when that customer is clicked on*/
        boolean correctSubmit = true;
        if(whichSubmit != whichCustomer){
            correctSubmit = false;
        }
        boolean passed = false;
        for (int i = 0; i < passCustArrList.size(); i++) {
            if (whichCustomer == passCustArrList.get(i)) {
                passed = true;
                break;
            }
        }
        if ((!passed && correctSubmit) || cheat) {//Makes sure that it wasn't clicked on
            if (correctMeal() || cheat) {//correctMeal() is another function that checks if the added items match the recipe
                if(cheat){
                    submittedMeals = totalMeals;
                    countCustMeal = custArrLists.get(whichSubmit).getNumOrder();
                }else{
                    listviewAdded.setItems(addDisplayList);
                    addDisplayList.clear();//If the meal was correct, the added list is cleared
                    submittedMeals++;//keeps track of how many meals were submitted overall
                    countCustMeal++;//keeps track of how many meals were submitted per customer
                }
                if (countCustMeal < custArrLists.get(whichSubmit).getNumOrder()) {//Checks if the customer has still ordered more
                    //Start index is used to keep track of which index the next item is on
                    //Uses if statements to find the next item in the order, and calls a function that will display the recipe in the recipe arraylist
                    if ((custArrLists.get(whichSubmit).getCustOrder().substring(startIndex, startIndex + 3)).equals("Pie")) {
                        setRecipeList(custArrLists.get(whichSubmit).getCustOrder().substring(startIndex));
                    } else if ((custArrLists.get(whichSubmit).getCustOrder().substring(startIndex, startIndex + 4)).equals("Cake")) {
                        setRecipeList(custArrLists.get(whichSubmit).getCustOrder().substring(startIndex));
                    } else if ((custArrLists.get(whichSubmit).getCustOrder().substring(startIndex, startIndex + 6)).equals("Cookie")) {
                        setRecipeList(custArrLists.get(whichSubmit).getCustOrder().substring(startIndex));
                    } else if ((custArrLists.get(whichSubmit).getCustOrder().substring(startIndex, startIndex + 8)).equals("Brownies")) {
                        setRecipeList(custArrLists.get(whichSubmit).getCustOrder().substring(startIndex));
                    } else if ((custArrLists.get(whichSubmit).getCustOrder().substring(startIndex, startIndex + 14)).equals("Strawberry Pie")) {
                        setRecipeList(custArrLists.get(whichSubmit).getCustOrder().substring(startIndex));
                    } else if ((custArrLists.get(whichSubmit).getCustOrder().substring(startIndex, startIndex + 15)).equals("Strawberry Cake")) {
                        setRecipeList(custArrLists.get(whichSubmit).getCustOrder().substring(startIndex));
                    } else if ((custArrLists.get(whichSubmit).getCustOrder().substring(startIndex, startIndex + 20)).equals("Strawberry Shortcake")) {
                        setRecipeList(custArrLists.get(whichSubmit).getCustOrder().substring(startIndex));
                    } else if ((custArrLists.get(whichSubmit).getCustOrder().substring(startIndex, startIndex + 21)).equals("Peanut Butter Cookies")) {
                        setRecipeList(custArrLists.get(whichSubmit).getCustOrder().substring(startIndex));
                    } else if ((custArrLists.get(whichSubmit).getCustOrder().substring(startIndex, startIndex + 30)).equals("Chocolate Covered Strawberries")) {
                        setRecipeList(custArrLists.get(whichSubmit).getCustOrder().substring(startIndex));
                    } else {
                        setRecipeList(custArrLists.get(whichSubmit).getCustOrder().substring(startIndex));
                    }
                } else {//This will happen if all of the customer's meals were submitted
                    //resets variables that were used per customer
                    cheat = false;
                    countCustMeal = 0;
                    startIndex = 0;
                    listviewRecipe.setItems(recipeDisplayList);
                    recipeDisplayList.clear();//clears recipe listview, which tells the user that the customer was satisfied
                    passCustArrList.add(whichSubmit);/*adds the index of the customer to the passed arraylist, which was used to 
                    restrict the user from clicking on the same customer more than once*/
                    //Only shows what the user paid after their meal was susbmitted
                    totalRevenue += custArrLists.get(whichSubmit).getCustTotal();
                    labelRevenue.setText(Double.toString(totalRevenue));
                    totalTips += custArrLists.get(whichSubmit).getCustTip();
                    labelTips.setText(Double.toString(totalTips));
                    calculateProfit(false);
                    //restarts the time
                    labelTime.setText("");
                    submitProbTime = -1;
                    if (submittedMeals >= totalMeals && numOfCustomers >= totalCusts) {//checks to see if all of the customers for the day were satisfied
                        if (numOfDays == 0 || passedDays < numOfDays) {//if the game should end, because all of the days are up
                            passedDays++;//counts the number of days
                            System.out.println("**************************************** New Day ****************************************");
                            System.out.println("");
                            labelDay.setText("Day: " + passedDays);
                            if (!calculateProfit(true)) {//at the end of the day, it is checked to see if the user had a negative profit, which would end the game
                                //goes to the next day by "restarting" the game
                                labelIngCover.setVisible(false);
                                labelDay.setText("Day: " + passedDays);
                                numOfCustomers = 0;
                                submittedMeals = 0;
                                totalMeals = 0;
                                listviewCustomers.setItems(custDisplayList);
                                custDisplayList.clear();
                                listviewSubmitMeal.setItems(subMealDisplayList);
                                subMealDisplayList.clear();
                                overallProbTime = -1;
                                submitProbTime = -1;
                                startIndex = 0;
                                custArrLists.clear();
                                passCustArrList.clear();
                                if (level.equals("Easy")) {
                                    checkAddCusts = 20000000000.0;
                                } else if (level.equals("Medium")) {
                                    checkAddCusts = 15000000000.0;
                                } else {
                                    checkAddCusts = 10000000000.0;
                                }
                                overallTimer();
                            }
                        } else if (passedDays >= numOfDays && numOfDays != 0) {//checks if all of the days selected are over
                            endGame();//ends the game
                        }
                    }
                }
            }
        }
    }

    @FXML
    private void mealRestart(ActionEvent event) {
        //If the user messes the meal up, they should click this button to start the meal over again
        addDisplayList.clear();
        listviewAdded.setItems(addDisplayList);
    }

    private boolean correctMeal() {
        //checks the meal
        boolean correct = true;
        for (int i = 0; i < recipeDisplayList.size(); i++) {
            int count = 0;
            for (int j = 0; j < addDisplayList.size(); j++) {
                if ((recipeDisplayList.get(i).substring(2).equals(addDisplayList.get(j)))) {
                    count++;
                }
            }
            if (count == Integer.parseInt(recipeDisplayList.get(i).substring(0, 1))) {
                correct = true;
            } else {
                correct = false;
            }
        }
        return correct;
    }

    private boolean calculateProfit(boolean check) {
        //calculates the total profit
        totalProfit = totalRevenue - (totalTips + totalCost);
        labelProfit.setText(Double.toString(totalProfit));
        if (check) {
            if (totalProfit < 0) {
                endGame();
                return true;
            } else {
                return false;
            }
        } else {
            labelProfit.setText(Double.toString(totalProfit));
            return false;
        }
    }

    private void endGame() {
        //what should happen if the game ends
        System.out.println("Game Over!");
        String contin = JOptionPane.showInputDialog("Do you want to restart the game?");
        if (contin.toLowerCase().equals("yes")) {
            buttonEasy.setVisible(true);
            buttonMedium.setVisible(true);
            buttonHard.setVisible(true);
            buttonSubmit.setVisible(true);
            button1.setVisible(true);
            button5.setVisible(true);
            button10.setVisible(true);
            buttonInfinite.setVisible(true);
            textHomeTitle.setVisible(true);
            textNameEnter.setVisible(true);
            textChooseLevel.setVisible(true);
            textChooseDay.setVisible(true);
            fieldNameEnter.setVisible(true);
            labelCoverAll.setVisible(true);
            labelIngCover.setVisible(true);
            buttonSubmit.setDisable(false);
            fieldNameEnter.setDisable(false);
            //Add the reseting of variables and all that stuff  
            submittedMeals = 0;
            totalMeals = 0;
            totalProfit = 0;
            totalRevenue = 0;
            totalTips = 0;
            totalCost = 0;
            listviewCustomers.setItems(custDisplayList);
            custDisplayList.clear();
            listviewSubmitMeal.setItems(subMealDisplayList);
            subMealDisplayList.clear();
            overallProbTime = -1;
            submitProbTime = -1;
            numOfCustomers = 0;
            startIndex = 0;
            passedDays = 0;
            labelCosts.setText(Double.toString(totalCost));
            labelTips.setText(Double.toString(totalTips));
            labelRevenue.setText(Double.toString(totalRevenue));
            labelTime.setText("");
            customerNames[0] = "";
            custArrLists.clear();
            passCustArrList.clear();
            addDisplayList.clear();
            listviewAdded.setItems(addDisplayList);
            listviewRecipe.setItems(recipeDisplayList);
            recipeDisplayList.clear();//clears recipe listview, which tells the user that the customer was satisfied
            //Restart labels
        }else{
            System.exit(0);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        buttonEasy.setDisable(true);
        buttonMedium.setDisable(true);
        buttonHard.setDisable(true);
        buttonSubmit.setDisable(false);
        button1.setDisable(true);
        button5.setDisable(true);
        button10.setDisable(true);
        buttonInfinite.setDisable(true);
    }

}
