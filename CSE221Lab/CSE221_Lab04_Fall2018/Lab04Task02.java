/*
 * Shoaib Ahmed Dipu
 * CSE221 Lab 04
 * Theory Section : 03
 * Lab Section : 06
 */

import java.*;
import java.io.*; 
import java.*;
import java.util.*;

public class Lab04Task02{
    
    public static int time = 0;
    
    public static int vertex;
    
    public static int startingTime[];
    public static int endingTime[];
    public static int parent[];
    public static int sortedArray[];
    public static int sortInFinishTime[];
    public static int x;
    
    public static void main(String[] args)throws Exception{ 
        
        try{
            
            // Reading The .txt File To Represent Graph In Matrix
            
            File file = new File("/home/dipu/Desktop/CSE221Lab/Lab04/graph.txt"); 
            
            BufferedReader br = new BufferedReader(new FileReader(file)); 
            
            String ver = br.readLine();
            vertex = Integer.parseInt(ver);
            System.out.println("Number Of Vertices : " + vertex + " " + "\n");
            
            int [][] adj_mat = new int[vertex+1][vertex+1];
            
            String st = null;
            
            while ((st = br.readLine()) != null){ 
                StringTokenizer stk = new StringTokenizer(st, " ");
                
                int firstToken = Integer.parseInt(stk.nextToken());
                int secondToken = Integer.parseInt(stk.nextToken());
                
                adj_mat[firstToken][secondToken] = 1;
            }
            
            // Printing The Ajd. Matrix 
            
            for(int i=1; i<=vertex; i++){
                for(int j=1; j<=vertex; j++){
                    System.out.print(adj_mat[i][j] + " ");
                }
                System.out.println();
            }
            
            System.out.print("\n");
            
            
            startingTime = new int [vertex+1];
            endingTime = new int [vertex+1];
            parent = new int [vertex+1];
            sortedArray = new int [vertex+1];
            x = vertex;
            
            for(int a=1; a<=vertex; a++) startingTime[a]= -1;
            for(int a=1; a<=vertex; a++) endingTime[a] = -1;
            
            
            // Calling The DFS Method
            DFS(adj_mat, 1);
            System.out.println();
            
            
            // Printing in topological sort
            String s = "";
            
            System.out.print("After Topological Sort: Nodes: ");
            for(int i=1; i<vertex; i++){
                System.out.print(sortedArray[i] + " -> ");
                s = s + endingTime[sortedArray[i]] + " ";
            }
            System.out.print(sortedArray[vertex]);
            s = s + endingTime[sortedArray[vertex]];
            
            System.out.println("\n" + "Finish Times: " + s);   
            
        }catch(Exception e){
            System.err.println(e);
        }
    } 
    
    
    // DFS Method
    public static void DFS(int adj_mat[][], int source){
        
        System.out.print(source + " ");
        
        startingTime[source] = ++time;
        
        for(int i=1; i<=vertex; i++){
            if(adj_mat[source][i]==1 && startingTime[i]==-1){
                parent[i] = source;
                DFS(adj_mat, i);
            }
        }
        sortedArray[x] = source;
        x--;
        endingTime[source] = ++time;
    }
    
}
