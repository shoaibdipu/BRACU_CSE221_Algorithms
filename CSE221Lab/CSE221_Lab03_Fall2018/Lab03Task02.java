/*
 * Shoaib Ahmed Dipu
 * CSE221 Lab 03
 * Theory Section : 03
 * Lab Section : 06
 */

import java.io.*; 
import java.*;
import java.util.*; 

public class Lab03Task02{
    
    public static void main(String[] args)throws Exception{ 
        
        try{
            
            // Reading The .txt File To Represent Graph In Matrix
            
            File file = new File("/home/dipu/Desktop/Lab03/Graph.txt"); 
            
            BufferedReader br = new BufferedReader(new FileReader(file)); 
            
            String ver = br.readLine();
            int vertex = Integer.parseInt(ver);
            System.out.println("Number Of Vertices : " + vertex + " " + "\n");
            
            int [][] adj_mat = new int[vertex+1][vertex+1];
            
            String st = null;
            
            while ((st = br.readLine()) != null){ 
                StringTokenizer stk = new StringTokenizer(st, " ");
                
                int firstToken = Integer.parseInt(stk.nextToken());
                int secondToken = Integer.parseInt(stk.nextToken());
                
                adj_mat[firstToken][secondToken] = 1;
                adj_mat[secondToken][firstToken] = 1;
            }
            
            // Printing The Ajd. Matrix 
            
            for(int i=1; i<=vertex; i++){
                for(int j=1; j<=vertex; j++){
                    System.out.print(adj_mat[i][j] + " ");
                }
                System.out.println();
            }
            
            
            // Taking Input For Source
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter The Source Of Graph");
            int source = sc.nextInt();
            
            
            // Calling The BFS Method
            BFS(adj_mat, source);
            
        }catch(Exception e){
            System.err.println(e);
        }
    } 
    
    // BFS Method
    public static void BFS(int a[][], int source){
        
        Queue<Integer> q = new LinkedList<>();
        
        int n = a[source].length-1;
        int [] visit = new int[n + 1];
        
        int i, vertex;
        
        visit[source] = 1;
        q.add(source);
        
        while(!q.isEmpty()){
            vertex = q.remove();
            i = vertex;
            System.out.print(i + " ");
            
            while(i<=n){
                
                if(a[vertex][i]==1 && visit[i]==0){
                    q.add(i);
                    visit[i] = 1;
                }
                
                i++;
            }
        }
    }
}

