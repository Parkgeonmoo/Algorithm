import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        //시간초과가 나온 코드
        /*BigInteger N = new BigInteger(st.nextToken());
        BigInteger M = new BigInteger("20000303");

        System.out.println(N.remainder(M));*/

        //나머지 연산 방법
        String N = br.readLine();
        long remain = 0;
        for(int i =0; i < N.length(); i++){
            remain = (remain * 10 + (N.charAt(i) - '0')) % 20000303;
        }
        bw.write(remain + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
