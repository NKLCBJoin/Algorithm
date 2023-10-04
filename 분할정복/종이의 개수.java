import java.io.*;

public class Main {
    static int[][] paper;
    static int[] papers = new int[3];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        paper = new int[N][N];

        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");

            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(input[j]);
            }
        }

        getPapers(0,0,N);
        for(int value : papers)
            System.out.println(value);
    }

    private static void getPapers(int x, int y, int depth) {
        // 모든 종이가 동일한 숫자로 채워져 있는 경우
        if(isOne(x, y, depth)){
            if(paper[x][y] == -1)
                papers[0]++;
            else if(paper[x][y] == 0)
                papers[1]++;
            else if(paper[x][y] == 1)
                papers[2]++;
            return;
        }

        int newDepth = depth / 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                getPapers(x + i * newDepth, y + j * newDepth, newDepth);
            }
        }
    }

    public static boolean isOne(int x, int y, int depth) {
        // 모든 종이의 숫자가 동일한지 확인
        int target = paper[x][y]; // 비교 대상 숫자를 가져옵니다.
        for (int i = x; i < x + depth; i++) {
            for (int j = y; j < y + depth; j++) {
                if (paper[i][j] != target) // paper[i][j]를 비교 대상과 비교합니다.
                    return false;
            }
        }
        return true;
    }
}
