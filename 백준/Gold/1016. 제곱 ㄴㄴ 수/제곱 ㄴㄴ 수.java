import java.util.Scanner;

public class Main{

    public static void main(String[]args) {
        Scanner in = new Scanner(System.in);
        long min = in.nextLong();
        long max = in.nextLong();
        boolean[] check = new boolean[(int)(max-min+1)];

        for (long i = 2; i*i <= max; i++) {
            long pow = i*i; // 2부터 시작하는 제곱수
            long start_index = min/pow; // 이렇게 해주는 이유는 배수인 경우에는 거기서부터 배열을 시작하면 되고 아닌 경우에는 시작지점을 1로 하고 아래 for문에서 실제 들어갈 배열 컨트롤 위한 것
            if (min % pow != 0) // 키포인트 만약 min이 제곱수보다 작을 경우
                start_index++; // start_index는 무조건 1이 된다
            for (long j = start_index; pow * j <= max; j++) {
                check[(int)((j*pow) - min)] = true;// 이 부분에서 실제 min부터 시작했을떄 해당 제곱수가 놓일 배열을 넣기 위해 j*pow - min 형태로 넣음 (예를 들어,min이 2 배수가 4일때 실제 배열은 1번째 인덱스에 넣어야 함,그걸 구현해준것)
            }
        } 
        int count = 0;
        for (int i = 0; i <= max-min; i++) {
            if(!check[i])
                count++;
        }
        System.out.println(count);

    }
}