
import java.util.Scanner;

public class Main {
    // 고장난 버튼을 체크할 배열
    static boolean[] broken = new boolean[10];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int targetChannel = sc.nextInt(); // 목표 채널
        int brokenCount = sc.nextInt(); // 고장난 버튼의 개수
        for (int i = 0; i < brokenCount; i++) {
            int brokenButton = sc.nextInt();
            broken[brokenButton] = true; // 고장난 버튼 표시
        }

        // +, - 버튼만 눌러서 이동하는 경우의 초기값 설정
        int minClicks = Math.abs(targetChannel - 100);

        // 모든 채널을 순회하면서 체크
        for (int channel = 0; channel <= 999999; channel++) {
            int clicks = canPress(channel);
            if (clicks > 0) { // channel을 버튼으로 누를 수 있는 경우
                int totalClicks = clicks + Math.abs(channel - targetChannel);
                minClicks = Math.min(minClicks, totalClicks);
            }
        }

        System.out.println(minClicks);
        sc.close();
    }

    // 채널을 버튼으로 누를 수 있는지 체크하는 함수
    static int canPress(int channel) {
        if (channel == 0) {
            return broken[0] ? 0 : 1;
        }
        int length = 0;
        while (channel > 0) {
            if (broken[channel % 10]) { // 고장난 버튼이면 누를 수 없음
                return 0;
            }
            length += 1;
            channel /= 10;
        }
        return length;
    }
}

