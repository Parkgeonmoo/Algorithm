import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String name = br.readLine();
		
		int[] arr = new int[4];
		int max = -1;
		String str = "LOVE";
		String str2 = "";
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			String team = br.readLine();
			
			for(int j = 0; j < 4; j++) {
				int cnt = name.length() - name.replace(String.valueOf(str.charAt(j)), "").length();
				cnt += team.length() - team.replace(String.valueOf(str.charAt(j)), "").length();
				arr[j] = cnt;
				
			}
			
			int tot = 1;
			for(int j = 0; j < 4; j++) {
				for(int k = (j + 1); k < 4; k++) {
					tot *= (arr[j] + arr[k]);
				}
			}
			
			if(max == (tot % 100) && str2 != "") {
				String[] arr2 = new String[2];
				arr2[0] = str2;
				arr2[1] = team;
				Arrays.sort(arr2);
				str2 = arr2[0];
			}
			
			if(max < (tot % 100)) {
				max = tot % 100;
				str2 = team;
			}
		}
		
		System.out.println(str2);
	}

}