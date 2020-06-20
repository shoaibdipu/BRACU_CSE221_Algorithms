/*
 * Shoaib Ahmed Dipu
 * CSE221 Lab 01
 * Theory Section : 03
 * Lab Section : 06
 */

import java.io.*; 
import java.*;
import java.util.*; 

public class Lab01Task02{ 
    public static void main(String [] args)throws Exception{ 
        
        try{
            
            File file = new File("/home/dipu/Desktop/CSE221Lab/Lab01/AdjList.txt"); 
            
            BufferedReader br = new BufferedReader(new FileReader(file));
            
            String ver = br.readLine();
            int vertex = Integer.parseInt(ver);
            System.out.println("Number Of Vertcies : " + vertex);
            
            String edg = br.readLine();
            int edges = Integer.parseInt(edg);
            System.out.println("Number Of Edges : " + edges + "\n");
            
            
            ArrayList<ArrayList<Integer>> list= new ArrayList<ArrayList<Integer>>(); 
            for (int i=0 ;i<vertex ;i++){ 
                list.add(new ArrayList<Integer>()); 
            }
            
            String st = null;
            
            while ((st = br.readLine()) != null){ 
                StringTokenizer stk = new StringTokenizer(st, " ");
                
                int firstToken = Integer.parseInt(stk.nextToken());
                int secondToken = Integer.parseInt(stk.nextToken());
                
                list.get(firstToken).add(secondToken);
            }
            
            for(int i=0;i<vertex;i++){ 
                System.out.print(i); 
                for(int j=0 ;j<vertex;j++){ 
                    if(list.get(i).contains(j)) System.out.print(" --> "+j); 
                    
                } 
                System.out.println(); 
            } 
            
        }catch(Exception e){
            System.err.println(e);
        }
    } 
}
