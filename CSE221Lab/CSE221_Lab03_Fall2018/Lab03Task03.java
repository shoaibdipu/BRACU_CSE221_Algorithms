/*
 * Shoaib Ahmed Dipu
 * CSE221 Lab 03
 * Theory Section : 03
 * Lab Section : 06
 */

import java.io.*; 
import java.*;
import java.util.*; 

public class Lab03Task03{
    
    public static void main(String[] args)throws Exception{ 
        
        try{
            
            // Reading The .txt File To Represent Graph In Matrix
            
            File file = new File("/home/dipu/Desktop/Lab03/Task03Input.txt"); 
            
            BufferedReader br = new BufferedReader(new FileReader(file)); 
            
            // Taking Input Of The Value Of T
            String testCase = br.readLine();
            int t = Integer.parseInt(testCase);
            System.out.println("Testcases : " + t + "\n");
            
            for(int a=0; a<t; a++){
                // Taking Input Of The Value Of N & M
                
                String stPre = br.readLine();
                StringTokenizer stk = new StringTokenizer(stPre, " ");
                
                int n = Integer.parseInt(stk.nextToken());
                int m = Integer.parseInt(stk.nextToken());
                
                
                int [][] adj_mat = new int[n+1][n+1];
                
                String st = null;
                
                for(int i=0; i<m; i++){
                    String str = br.readLine();
                    StringTokenizer stk2 = new StringTokenizer(str, " ");
                    
                    int firstToken = Integer.parseInt(stk2.nextToken());
                    int secondToken = Integer.parseInt(stk2.nextToken());
                    
                    adj_mat[firstToken][secondToken] = 1;
                    adj_mat[secondToken][firstToken] = 1;
                }
                
                
                // Calling The BFS Method
                int distanceOfOptimalRoute = BFS(adj_mat, 1, n);
                
                System.out.println(distanceOfOptimalRoute);
            }
            
        }catch(Exception e){
            System.err.println(e);
        }
    } 
    
    // BFS Method
    public static int BFS(int a[][], int source, int destination){
        
        Queue<Integer> q = new LinkedList<>();
        
        int n = a[source].length-1;
        int [] visit = new int[n + 1];
        
        int i, vertex;
        
        visit[source] = 1;
        q.add(source);
        
        int count = 0;
        
        while(!q.isEmpty()){
            vertex = q.remove();
            i = vertex;
            
            while(i<=destination){
                
                if(a[vertex][i]==1 && visit[i]==0){
                    q.add(i);
                    visit[i] = 1;
                    count++;
                }
                i++;
            }            
        }
        
        return count;
    }
}

