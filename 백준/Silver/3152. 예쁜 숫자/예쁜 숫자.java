import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static Long[] nArray = new Long[4];
    public static HashSet<Long> treeNodes = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int p = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 4; i++) {
            nArray[i] = Long.parseLong(st.nextToken());
        }

        // 트리 생성
        generateTree(p, nArray);

        // 예쁜 숫자인지 확인
        int[] result = isPrettyNumber(treeNodes, nArray);

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int resultOne : result) {
            sb.append(resultOne).append(" ");
        }

        System.out.println(sb.toString().trim());
    }

    public static void generateTree(int p, Long[] nArray) {
        // nArray에서 가장 큰 값을 찾음
        long maxValue = 0;
        for (Long n : nArray) {
            if (n > maxValue) {
                maxValue = n;
            }
        }

        // 트리 노드 생성
        buildTree(1, p, maxValue);
    }

    private static void buildTree(long currentValue, int p, long maxValue) {
        if (currentValue > maxValue) {
            return;
        }

        treeNodes.add(currentValue);

        // 왼쪽 자식 노드
        buildTree(p * currentValue, p, maxValue);
        // 오른쪽 자식 노드
        buildTree(p * currentValue + 1, p, maxValue);
    }

    public static int[] isPrettyNumber(HashSet<Long> treeNodes, Long[] nArray) {
        int[] result = new int[nArray.length];

        // treeNodes를 리스트로 변환하고 정렬
        List<Long> nodeList = new ArrayList<>(treeNodes);
        Collections.sort(nodeList);

        for (int i = 0; i < nArray.length; i++) {
            result[i] = isPretty(nArray[i], nodeList) ? 1 : 0;
        }

        return result;
    }

    private static boolean isPretty(long num, List<Long> nodeList) {
        int count = 0; // 가능한 경우의 수를 셀 변수

        for (int i = 0; i < nodeList.size(); i++) {
            for (int j = i + 1; j < nodeList.size(); j++) {
                if (nodeList.get(i) + nodeList.get(j) == num) {
                    count++;
                    // 두 가지 이상의 경우의 수가 발견되면 바로 false 반환
                    if (count > 1) {
                        return false;
                    }
                }
            }
        }

        // 가능한 경우의 수가 정확히 하나인 경우만 true 반환
        return count == 1;
    }
}
