import java.io.*;
import java.util.*;

public class Main {

    static String kingFirstLocation;
    static String stoneFirstLocation;
    static int N;
    static int[] dx = {0,0,-1,1,1,1,-1,-1};
    static int[] dy = {1,-1,0,0,1,-1,1,-1};
    static int[] king;
    static int[] stone;




    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        kingFirstLocation  = st.nextToken();
        king = stringToPosition(kingFirstLocation);
        stoneFirstLocation = st.nextToken();
        stone = stringToPosition(stoneFirstLocation);


        N = Integer.parseInt(st.nextToken());


        for (int i = 0; i < N; i++) {
          String move = br.readLine();
          int index = -1;
          switch(move) {
              case "R":
                  index = 0;
                  break;
              case "L":
                  index = 1;
                  break;
              case "B":
                  index = 2;
                  break;
              case "T":
                  index = 3;
                  break;
              case "RT":
                  index = 4;
                  break;
              case "LT":
                  index = 5;
                  break;
              case "RB":
                  index = 6;
                  break;
              case "LB":
                  index = 7;
                  break;
          }
            int[] nKing = new int[] { king[0] + dy[index], king[1] + dx[index] };

          if (nKing[0] >= 0 && nKing[0] < 8 && nKing[1] >= 0 && nKing[1] < 8) {

              if (nKing[0] == stone[0] && nKing[1] == stone[1]) {
                  int[] nStone = new int[] { stone[0] + dy[index], stone[1] + dx[index] };
                  if (nStone[0] >= 0 && nStone[0] < 8 && nStone[1] >= 0 && nStone[1] < 8) {
                      king = nKing;
                      stone = nStone;
                  }
              }else{
                  king = nKing;
              }

          }

        }
        System.out.println(positionToString(king));
        System.out.println(positionToString(stone));


    }

    public static int[] stringToPosition(String FirstLocation) {
        char [] temp = FirstLocation.toCharArray();
        int col = temp[0] - 'A';
        int row = temp[1] - '1';

        int [] position = new int[]{col,row};

        return position;
    }

    public static String positionToString(int[] LastLocation) {
        char col = (char)(LastLocation[0] + 'A');
        char row = (char)(LastLocation[1] + '1');

        char [] c = new char[]{col,row};
        return new String(c);
    }




}