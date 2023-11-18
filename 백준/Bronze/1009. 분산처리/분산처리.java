import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 전체 1009 문제 알고리즘 클래스
 *
 * @author RWB
 * @see <a href="https://blog.itcode.dev/posts/2021/06/09/a1009">1009 풀이</a>
 * @since 2021.06.09 Tue 11:06:38
 */
public class Main
{
	/**
	 * 메인 함수
	 *
	 * @param args: [String[]] 매개변수
	 *
	 * @throws IOException 데이터 입출력 예외
	 */
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(reader.readLine());
		
		for (int i = 0; i < T; i++)
		{
			String[] temp = reader.readLine().split(" ");
			
			int a = Integer.parseInt(temp[0]);
			int b = Integer.parseInt(temp[1]);
			
			int result = 1;
			
			for (int j = 1; j <= b; j++)
			{
				result = result * a % 10;
			}
			
			// 0일 경우 10으로 처리
			result = result == 0 ? 10 : result;
			
			System.out.println(result);
		}
		
		reader.close();
	}
}