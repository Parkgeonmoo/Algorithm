import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
 
public class Main {
	
	public static int N;
	public static int[] dp;
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	
    	dp = new int[100001];
    	dp[0] = 0;
    	dp[1] = 0;
    	dp[2] = 1;
    	dp[3] = 0;
    	dp[4] = 2;
    	dp[5] = 1;
    	
    	for(int i=6; i<=N;i++) {
    		if(dp[i-2] == 0 && dp[i-5] == 0 ) {
    			dp[i] = 0;
    		}
    		else if(dp[i-2] > 0 && dp[i-5] == 0 ) {
    			dp[i] = dp[i-2] + 1;
    		}
    		else if(dp[i-2] == 0 && dp[i-5] > 0 ) {
    			dp[i] = dp[i-5] + 1;
    		}else {
    			dp[i] = Math.min(dp[i-2], dp[i-5]) + 1;
    		}
    	}
    	
    	if(dp[N] == 0)
    		System.out.println("-1");
    	else
    		System.out.println(dp[N]);
    	
    }
}