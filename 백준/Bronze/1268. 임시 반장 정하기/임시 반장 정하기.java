import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int cnt = Integer.parseInt(br.readLine());
        int[][] table = new int[cnt][5];
        int num = 0;
        int num2 = 0;
        
        for (int i = 0; i < cnt; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < 5; j++) {
                table[i][j] = Integer.parseInt(str[j]);
            }
        }

        for (int i = 0; i < cnt; i++) {
            Set<Integer> set = new HashSet<>();
            
            for (int j = 0; j < 5; j++) {
                
                for (int k = 0; k < cnt; k++) {
                    
                    if (i == k){
                      continue;  
                    } 
                    if (table[i][j] == table[k][j]) {
                        set.add(k);
                    }
                }
            }
            if (num2 < set.size()) {
                num2 = set.size();
                num = i + 1;
            }
            
        }
        
        if(num == 0) {
            System.out.println(1);
        } else {
            System.out.println(num);
        }
        
    }
}