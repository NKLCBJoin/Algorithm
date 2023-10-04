package 분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1629 {

    static int[] answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        long C = Integer.parseInt(st.nextToken());
        answer = new int[1000_000];
        System.out.println(calculate(A,B,C));
    }

    private static long calculate(long a, int b, long c) {
        if(b==1){
            return (a%c);
        }
        if(b < answer.length && answer[b]>0) return answer[b];
        long result = (calculate(a, b/2, c) * calculate(a, b-b/2, c))%c;
        if (b < answer.length) answer[b] = (int)result;
        return result;
    }
}
