/*
 * Shoaib Ahmed Dipu
 * CSE221 Lab 08 : LCS
 * Theory Section : 03
 * Lab Section : 06
 */

import java.util.*;
import java.io.*;
import java.*;

public class Lab08LCS{
    
    public static int LCScost[][];
    public static int LCSdir[][];
    public static int rowCount = 0;
    public static int columnCount = 0;
    
    public static void main(String[]args)throws Exception{
        
        try{
            File file = new File("input.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            
            String a = br.readLine(); // ABEJ
            char x [] = a.toCharArray();
            
            String b = br.readLine(); // AJBCE
            char y [] = b.toCharArray();

            
            // Calling the LCS method
            LCS(x,y);
            
            // Printing The Cost Matrix 
            System.out.println("Cost Matrix : " + "\n");
            
            for(int i=0; i<=rowCount; i++){
                for(int j=0; j<=columnCount; j++){
                    System.out.print(LCScost[i][j] + " ");
                }
                System.out.println();
            }
            
            // Printing The Direction Matrix 
            System.out.println("\n" + "Direction Matrix : " + "\n");
            
            for(int i=0; i<=rowCount; i++){
                for(int j=0; j<=columnCount; j++){
                    System.out.print(LCSdir[i][j] + " ");
                }
                System.out.println();
            }
            
            
            // Finding Out The LCS By Backtracking
            String lcsTemp = "";
            
            int i = rowCount;
            int j = columnCount;
            
            while(i > 0 && j>0){
                if(LCSdir[i][j]==1){
                    lcsTemp+=a.charAt(i-1);
                    i--;
                    j--;
                }else if(LCSdir[i][j]==2){
                    i--;
                }else{
                    j--;
                }
            }
            
            
            // Printing The LCS
            System.out.print("\nLongest Common Subsequence : ");
            char [] lcsFinal = lcsTemp.toCharArray();
            for(int p=lcsFinal.length-1; p>=0; p--) System.out.print(lcsFinal[p]);
            
            
            // Length of LCS
            System.out.println("\n" + "Length Of LCS : " + LCScost[rowCount][columnCount]);
            
        }catch(Exception e){
            System.err.println(e);
        }
    }
    
    public static void LCS(char[] x, char[] y){
        
        int m = x.length;
        int n = y.length;
        
        if(m < n){
            rowCount = m;
            columnCount = n;
        }else{
            rowCount = n;
            columnCount = m;
        }
        
        LCScost = new int[rowCount+1][columnCount+1];
        LCSdir = new int [rowCount+1][columnCount+1];
        
        for(int i=1; i<=rowCount; i++) LCScost[i][0] = 0;
        for(int i=1; i<=columnCount; i++) LCScost[0][i] = 0;
        
        for(int i=1; i<=rowCount; i++){
            
            for(int j=1; j<=columnCount; j++){
                
                if(x[i-1]==y[j-1]){
                    
                    LCScost[i][j] = LCScost[i-1][j-1] + 1;
                    LCSdir[i][j] = 1; // Diagonal
                    
                }else if(LCScost[i-1][j] >= LCScost[i][j-1]){
                    
                    LCScost[i][j] = LCScost[i-1][j];
                    LCSdir[i][j] = 2; // Upward
                    
                }else{
                    
                    LCScost[i][j] = LCScost[i][j-1];
                    LCSdir[i][j] = 3; // Leftward
                    
                }
            }
        }
    }
}
