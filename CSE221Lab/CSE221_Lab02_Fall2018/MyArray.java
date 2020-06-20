/*
 * Shoaib Ahmed Dipu
 * CSE221 Lab 02
 * Theory Section : 03
 * Lab Section : 06
 */

public class MyArray{
    
    public static int[] insertionSort(int a[], int n){
        
        for(int j=1; j<n; j++){
            int key = a[j];
            
            int i=j-1;
            
            while(i>0 && a[i]>key){
                a[i+1] = a[i];
            }
            
            a[i+1] = key;
        }
        
        return a;
    }
    
    
    
    public static int[] mergeSort(int [] a){ 
        
        
        if(a.length==1) return a; 
        else{ 
            
            
            int a1[] = new int[a.length/2]; 
            int a2[] = new int[a.length - a1.length]; 
            
            for(int i=0; i<a.length/2; i++){ 
                a1[i] = a[i]; 
            } 
            
            int c = 0; 
            for(int i=a.length/2; i<a.length; i++){ 
                a2[c] = a[i]; 
                c++; 
            } 
            
            int newA [] = merge(mergeSort(a1), mergeSort(a2)); 
            return newA; 
        } 
        
    } 
    
    public static int[] merge(int a[], int b[]){ 
        
        int c [] = new int[a.length + b.length]; 
        
        int i=0; 
        int j=0; 
        int k=0; 
        
        while(i<a.length && j<b.length){ 
            if(a[i]<b[j]){ 
                c[k] = a[i]; 
                k++; 
                i++; 
            }else{ 
                c[k] = b[j]; 
                k++; 
                j++; 
            } 
            
        } 
        
        if(i>=a.length){ 
            while(j<b.length){ 
                c[k] = b[j]; 
                j++; 
                k++; 
            } 
        }else{ 
            while(i<a.length){ 
                c[k] = a[i]; 
                i++; 
                k++; 
            } 
        } 
        return c;
    }
    
    
    
    
    public static int[] quickSort(int a[], int p, int r){ 
        if(p<r){ 
            int q = partition(a, p, r); 
            quickSort(a, p, q-1); 
            quickSort(a, q+1, r); 
        }
        
        return a;
    } 
    
    
    
    
    public static int partition(int []a, int p, int q){ 
        int x = a[p]; 
        int i = p; 
        
        for(int j=p+1; j<=q; j++){ 
            if(a[j]<=x){ 
                i++; 
                int temp = a[i]; 
                a[i] = a[j]; 
                a[j] = temp; 
            } 
        } 
        int temp = a[p]; 
        a[p] = a[i]; 
        a[i] = temp; 
        return i; 
    } 
    
    public static String toString(int a[]){
        
        String s = "[ ";
        
        for(int i=0; i<a.length; i++){
            s = s + a[i] + " ";
        }
        
        s += " ]"; 
        
        return s;
    }
}


