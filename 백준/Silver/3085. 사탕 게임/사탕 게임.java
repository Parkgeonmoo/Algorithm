

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static char[][] map;
    public static int num;
    public static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine());
        map = new char[num][num];

        String line = "";
        for(int i = 0; i < num; i++) {
            line = br.readLine();
            map[i] = line.toCharArray();
        }

        for(int i = 0; i < num; i++) {
            for(int j = 0; j < num-1; j++) {
                char swap = map[i][j];
                map[i][j] = map[i][j+1];
                map[i][j+1] = swap;
                searchCandy();
                swap = map[i][j];
                map[i][j] = map[i][j+1];
                map[i][j+1] = swap;
            }
        }

        for(int i = 0; i < num; i++) {
            for(int j = 0; j < num-1; j++) {
                char swap = map[j][i];
                map[j][i] = map[j+1][i];
                map[j+1][i] = swap;
                max = Math.max(searchCandy(), max);
                swap = map[j][i];
                map[j][i] = map[j+1][i];
                map[j+1][i] = swap;
            }
        }


        System.out.println(max);

    }

    private static int searchCandy() {
        for(int i = 0; i < num; i++) {
            int cnt = 1;
            for(int j = 0; j < num-1; j++) {
                if(map[i][j] == map[i][j+1]) {
                    cnt++;
                } else {
                    cnt = 1;
                }
                max = Math.max(max, cnt);
            }
        }
        
        for(int i = 0; i < num; i++) {
            int cnt = 1;
            for(int j = 0; j < num-1; j++) {
                if(map[j][i] == map[j+1][i]) {
                    cnt++;
                } else {
                    cnt = 1;
                }
                max = Math.max(max, cnt);
            }
        }

        return max;
    }

}

