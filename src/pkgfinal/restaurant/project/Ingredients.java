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
public class Ingredients {
    double [][] ingPrices = new double[4][4];
    public Ingredients(){
        setPrice();
    }
    public void setPrice(){
        for(int i = 0; i < 4;i++){
            for(int j = 0; j< 4 ; j++){
                if(i<2){
                    ingPrices[i][j] = 0.33;
                }else{
                    ingPrices[i][j] = 0.56;
                }
            }
        }
    }
    public double getPrice(int row, int col){
        return ingPrices[row][col];
    }
}
