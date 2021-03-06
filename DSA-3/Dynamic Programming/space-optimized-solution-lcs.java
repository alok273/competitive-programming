/*******

https://www.geeksforgeeks.org/space-optimized-solution-lcs/

******/

import java.util.*;
import java.lang.*;
import java.io.*;

public class GFG_1 {
    
    public static int LCS(String str1,String str2,Integer len1,Integer len2){
        
        int store[][] = new int[2][len2 + 1];
       // System.out.println(str1 + " " +str2);
        int bi = 0;
        for(int i=0; i<=len1; i++){
        	
        	bi = i & 1;
        	
            for(int j=0; j<=len2; j++){
                
            	
                if(i == 0 || j == 0){
                    store[bi][j] = 0;
                }else if(str1.charAt(i-1) == str2.charAt(j-1)){
                	//System.out.println(str1.charAt(i-1));
                    store[bi][j] = store[1 - bi][j-1] + 1;
                }else{
                    store[bi][j] = Math.max(store[1 - bi][j],store[bi][j-1]);
                }
            }
        }
        
        return store[bi][len2];
    }
    
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		Integer t = sc.nextInt();
		while(t-- > 0 ){
		    Integer len1 = sc.nextInt();
		    Integer len2 = sc.nextInt();
		    //sc.next();
		    String str1 = sc.next();
		   // sc.next();
		    String str2 = sc.next();
		   // System.out.println("len1: "+len1+" len2: "+len2+" str1: "+str1+" str2: "+ str2);
		    System.out.println(LCS(str1,str2,len1,len2));
		}
	}
}