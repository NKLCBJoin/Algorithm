package 분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10830 {

    static final int DIVIDER = 1000;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        int[][] matrix = new int[N][N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                matrix[i][j] = Integer.parseInt(st.nextToken())%DIVIDER;
            }
        }
        int[][] result = calculateMatrix(matrix, B);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static int[][] calculateMatrix(int[][] matrix, long B){
        if(B==1){
            return matrix;
        }
        int[][] temp = calculateMatrix(matrix, B/2);
        if(B%2==0){
            return multiplyMatrix(temp, temp);
        } else {
            return multiplyMatrix(multiplyMatrix(temp, temp), matrix);
        }
    }

    private static int[][] multiplyMatrix(int[][] temp, int[][] temp1) {
        int[][] result = new int[temp.length][temp1[0].length];
        for(int i=0;i<temp.length;i++){
            for(int j=0;j<temp1[0].length;j++){
                for(int k=0;k<temp[0].length;k++){
                    result[i][j] += temp[i][k] * temp1[k][j] % DIVIDER;
                }
                result[i][j] %= DIVIDER;
            }
        }
        return result;
    }
}
