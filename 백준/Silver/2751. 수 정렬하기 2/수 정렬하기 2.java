import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class  Main  {
    public static int[] A,  tmp;
    public static long  result;
    public static void main(String[]  args)  throws  IOException  {

        BufferedReader br =  new  BufferedReader(new  InputStreamReader(System.in));
        BufferedWriter bw  =  new  BufferedWriter(new OutputStreamWriter(System.out));
        int N   =  Integer.parseInt(br.readLine());
        A  =  new  int[N +  1];
        tmp  =  new  int[N +  1];
        for (int i =  1;  i <=  N;  i++)  {
            A[i] =  Integer.parseInt(br.readLine());
        }

        merget_sort(1,  N);
        for (int i =  1;  i <=  N;  i++)  {
        bw.write(A[i] +  "\n"); }
        bw.flush();
        bw.close();
}
    private static void merget_sort(int s, int e) {
        if (e  - s  <  1)
            return;
        int m  =  s  +  (e  - s)  / 2; // 재귀 함수 형태로 구현
        merget_sort(s,  m);
        merget_sort(m +  1,  e);
        for (int i =  s;  i <=  e;  i++)  {
            tmp[i] =  A[i]; }
        int k =  s;
        int indexl =  s;
        int index2  =  m  +  1;
        while  (indexl <=  m   &&  index2  <=  e)  {       // 두 그룹을 병합하는 로직 // 양쪽 그룹의 index가 가리키는 값을 비교해 더 작은 수를 선택해 배열에 저장하고, 선택된 데이터의 index 값을 오른쪽으로 한 칸 이동하기
            if (tmp[indexl]  >  tmp[index2])  {
                A[k] =  tmp[index2]; k++;
                index2++;
            } else {
                A[k]  =  tmp[indexl]; k++;
                indexl++;
            }
        }
        while  (indexl <=  m)   {                   // 한쪽 그룹이 모두 선택된 후 남아 있는 값 정리하기
            A[k] =  tmp[indexl]; k++;
            indexl++;
        }
        while (index2 <= e) { A[k] = tmp[index2]; k++;
            index2++;
        }
    }
}