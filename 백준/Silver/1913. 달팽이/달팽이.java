import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int N,find,startx,starty;
    static int mapvalue;
    static int firstUpCount = 1;
    static int rightCount = -1;
    static int downCount = 0;
    static int leftCount = 0;
    static int secondUpCount = 0;
    static int findx,findy;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        find = Integer.parseInt(br.readLine());

        map = new int[N][N];
        startx = N/2;
        starty = N/2;
        mapvalue = 1;

        map[startx][starty] = mapvalue;

        while (mapvalue < N*N) {
            rightCount += 2;
            downCount += 2;
            leftCount += 2;
            secondUpCount += 2;

            for (int i = 0; i < firstUpCount; i++) {
                map[--startx][starty] = ++mapvalue;
            }

            for (int i = 0; i < rightCount; i++) {
                map[startx][++starty] = ++mapvalue;

            }

            for (int i = 0; i < downCount; i++) {
                map[++startx][starty] = ++mapvalue;
            }

            for (int i =0; i < leftCount; i++) {
                map[startx][--starty] = ++mapvalue;
            }

            for (int i = 0; i < secondUpCount; i++) {
                map[--startx][starty] = ++mapvalue;

            }




        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == find) {
                    findx = i;
                    findy = j;
                }
                sb.append(map[i][j] + " ");
            }
            sb.append("\n");
        }
        sb.append((findx+1) + " " + (findy+1));
        System.out.println(sb.toString());





    }


}