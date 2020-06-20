/*
 * Shoaib Ahmed Dipu
 * CSE221 Lab 05 : MST
 * Theory Section : 03
 * Lab Section : 06
 */

import java.*;
import java.io.*; 
import java.util.*;

public class Lab5MST{
    
    public static String parent[];
    public static int distance[];
    public static boolean visited[];
    
    public static void main(String[] args)throws Exception {
        
        try{
            File file = new File("inputMST.txt"); 
            BufferedReader br = new BufferedReader(new FileReader(file));
            
            int length = Integer.parseInt(br.readLine());
            
            String area []= new String[length];
            int[][] adjMat = new int[length][length];
            
            parent = new String[length];
            visited = new boolean[length];
            distance = new int[length];
            
            // Initializing Area Array
            String temp = br.readLine();
            StringTokenizer tempStk = new StringTokenizer(temp, " ");
            
            for(int i=0; i<length; i++){
                area[i] = tempStk.nextToken();
            }
            
            // Initializing Distance Array
            
            for(int i=0; i<length; i++) distance[i] = 9999;
            
            // Initializing Visited Array 
            
            for(int i=0; i<length; i++) visited[i] = false;
            
            // Initializing The AdjMat Array
            
            String st = null;
            int rowCount = 0;
            
            while((st=br.readLine())!=null){
                StringTokenizer stk = new StringTokenizer(st, " ");
                
                for(int j=0; j<length; j++){
                    int token = Integer.parseInt(stk.nextToken());
                    adjMat[rowCount][j] = token;
                }
                rowCount++;
            }
            
            // User's Choice 
            
            System.out.println("Input 1 for Prim's MST Algorithm");
            System.out.println("Input 2 for Kruskal's MST Algorithm");
            
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            
            // Implementation Of Prim's MST Algorithm
            
            if(choice==1){
                for(int i=0; i<area.length; i++){ 
                    for(int j=0; j<area.length; j++){
                        if(adjMat[i][j]!=0 && visited[j]==false && adjMat[i][j]<distance[j]){
                            parent[j]=area[i];
                            distance[j]=adjMat[i][j];
                        }
                    }
                    visited[i]=true;
                }
                
            }
            
            // Implementation Of Kruskal's MST Algorithm
            
            if(choice==2){
                for(int c=0; c<(area.length); c++){
                    int min = 9999;
                    int x = -1;
                    int y = -1;
                    for(int i=0; i<area.length; i++){ 
                        for(int j=0; j<area.length; j++){
                            if(min>adjMat[i][j] && adjMat[i][j]!=0){
                                min = adjMat[i][j];
                                x = i;
                                y = j;
                            }
                        }
                    } 
                    if(visited[x]==false && min!=9999){
                        parent[y] = area[x];
                        visited[x] = true;
                        distance[y] = min;
                        adjMat[x][y] = 9999;
                    }
                }
            }
            
            // Output Sum 
            
            int sum = 0;
            
            for(int i=0; i<area.length; i++){ 
                if(parent[i]!=null){
                    System.out.println(parent[i]+" - "+area[i] + ": " + distance[i]);
                    sum = sum + distance[i];
                }
            } 
            System.out.println("Total Cost = " + sum);
            
        }catch(Exception e){
            System.err.println(e);
        }
    }
}
