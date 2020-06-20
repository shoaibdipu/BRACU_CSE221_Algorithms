import java.io.*; 
import java.*;
import java.util.*; 

public class DijkstraForSSSP { 
    
    public static int[][] graph = new int[15][15]; 
    public static int[] parent = new int[15]; 
    public static int[] key = new int[15]; 
    public static boolean[] check = new boolean[15]; 
    
    public static void main(String[] args) { 
        try{ 
            
            // Reading The .txt File To Represent Graph In Matrix 
            
            File file = new File("Dijkstra.txt");  
            
            BufferedReader br = new BufferedReader(new FileReader(file));  
            
            int [][] graph = new int[15][15]; 
            
            String st = null; 
            
            while ((st = br.readLine()) != null){  
                StringTokenizer stk = new StringTokenizer(st, " "); 
                
                String firstToken = stk.nextToken(); 
                String secondToken = stk.nextToken(); 
                int thirdToken = Integer.parseInt(stk.nextToken()); 
                
                int firstInt = convertToInt(firstToken); 
                int secondInt = convertToInt(secondToken); 
                
                graph[firstInt][secondInt] = thirdToken; 
                
                
                dijkstra(graph , 1); 
            } 
        }catch(Exception e){
        }
    }
    
    public static int convertToInt(String s){ 
        if(s=="Motijheel") return 1;
        else if(s=="A") return 2; 
        else if(s=="B") return 3; 
        else if(s=="C") return 4; 
        else if(s=="D") return 5; 
        else if(s=="E") return 6; 
        else if(s=="F") return 7; 
        else if(s=="G") return 8; 
        else if(s=="H") return 9; 
        else if(s=="I") return 10; 
        else if(s=="J") return 11; 
        else if(s=="K") return 12; 
        else if(s=="L") return 13; 
        else return 14; 
    }
    
    public static String convertToPlace(int n){ 
        if(n==1) return "Motijheel";
        else if(n==2) return "A";
        else if(n==3) return "B";
        else if(n==4) return "C";
        else if(n==5) return "D";
        else if(n==6) return "E";
        else if(n==7) return "F";
        else if(n==8) return "G";
        else if(n==9) return "H";
        else if(n==10) return "I";
        else if(n==11) return "J";
        else if(n==12) return "K";
        else if(n==13) return "L";
        else return "MOGHBAZAR";
    }
    
    public static void dijkstra(int[][] graph , int r){ 
        for (int i = 1 ; i < graph.length ; i++){ 
            key[i] = 5000; 
            parent[i] = -1; 
            check[i] = false; 
        } 
        
        key[r] = 0; 
//        check[r] = true; 
        
        for(int i = 1 ; i < graph.length ; i++){ 
            int minKey = min(key , check); 
            check[minKey] = true; 
            for(int j = 1 ; j < graph.length ; j++){ 
                if (check[j] == false && graph[minKey][j] + key[i] < key[j]){  
                    parent[j] = minKey;  
                    key[j] = key[i] + graph[minKey][j];  
                } 
            }  
        } 
        
        int i = 1; 
        for (int j = 2; j < graph.length; j++){
            String firstPlace = convertToPlace(i);
            String secondPlace = convertToPlace(j); 
            System.out.println(firstPlace+ " -- " + secondPlace + "\t"+ key[j]);
            i++; 
        } 
    } 
    
    public static int min (int[] key , boolean[] check){ 
        int min = 50000 , minIndex = -1 ; 
        for(int i = 1 ; i <key.length ; i++){ 
            if(check[i] == false && key[i] < min){ 
                min = key[i]; 
                minIndex = i; 
            } 
        } 
        return minIndex; 
    } 
} 
