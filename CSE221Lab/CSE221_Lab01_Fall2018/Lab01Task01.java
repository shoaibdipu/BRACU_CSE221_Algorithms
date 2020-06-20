/*
 * Shoaib Ahmed Dipu
 * CSE221 Lab 01
 * Theory Section : 03
 * Lab Section : 06
 */

import java.io.*; 
import java.*;
import java.util.*; 

public class Lab01Task01{
    public static void main(String[] args)throws Exception{ 
        
        try{
            
            File file = new File("/home/dipu/Desktop/CSE221Lab/Lab01/AdjMat.txt"); 
            
            BufferedReader br = new BufferedReader(new FileReader(file)); 
            
            String ver = br.readLine();
            int vertex = Integer.parseInt(ver);
            System.out.println("Number Of Vertices : " + vertex + " " + "\n");
            
            int [][] adj_mat = new int[vertex][vertex];
            
            String st = null;
            
            while ((st = br.readLine()) != null){ 
                StringTokenizer stk = new StringTokenizer(st, " ");
                
                int firstToken = Integer.parseInt(stk.nextToken());
                int secondToken = Integer.parseInt(stk.nextToken());
                
                adj_mat[firstToken][secondToken] = 1;
                adj_mat[secondToken][firstToken] = 1;
            }
            
            for(int i=0; i<vertex; i++){
                for(int j=0; j<vertex; j++){
                    System.out.print(adj_mat[i][j] + " ");
                }
                System.out.println();
            }
            
        }catch(Exception e){
            System.err.println(e);
        }
    } 
}
