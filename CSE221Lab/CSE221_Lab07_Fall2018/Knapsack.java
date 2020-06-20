/*
 * Shoaib Ahmed Dipu
 * CSE221 Lab 07 : 0/1 Knapsack
 * Theory Section : 03
 * Lab Section : 06
 */

import java.io.*; 
import java.*;
import java.util.*; 

public class Knapsack {
    
    public static int value[];
    public static int weight[];
    
    public static void main(String[] args){
        
        try{ 
            
            File file = new File("inputKnapsack.txt"); 
            
            BufferedReader br = new BufferedReader(new FileReader(file));
            
            int testCases = Integer.parseInt(br.readLine());
            
            for(int a=0; a<testCases; a++){
                
                int m = Integer.parseInt(br.readLine());
                
                value = new int[m];
                weight = new int[m];
                
                String st = br.readLine();
                StringTokenizer stk = new StringTokenizer(st, " ");
                
                for(int i=0; i<m; i++){
                    weight[i] = Integer.parseInt(stk.nextToken());
                }
                
                for(int i=0; i<m; i++){
                    value[i] = 1;
                }
                
                int sum = 0;
                
                for(int i=0; i<m; i++){
                    sum += weight[i];
                }
                
                knapsack(sum / m);
            }
        }catch(Exception e){
            
        }
    }
    
    
    public static void knapsack(int n){
        
        int[][] k = new int[weight.length+1][n+1];
        
        for(int i=1; i<=weight.length; i++){
            for(int j=0; j<=n; j++){
                if(j<weight[i]){
                    k[i][j] = k[i-1][j];
                }else{
                    k[i][j] = Math.max(k[i-1][j], k[i-1][j-weight[i]+value[i]]);
                }
            }
        }
        
        System.out.println(k[weight.length][n]);
    }
}
