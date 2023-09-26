B1012package 그래프와순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class B2567 {

    static ArrayList<Integer> answer = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        boolean[][] map = new boolean[size][size];
        for(int i=0;i<size;i++){
            String input = br.readLine();
            for(int j=0;j<size;j++){
                map[i][j] = input.charAt(j) == '1';
            }
        }
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(map[i][j]) {
                    answer.add(findNearHouse(map, i, j));
                }
            }
        }
        Collections.sort(answer);
        StringBuilder sb = new StringBuilder();
        sb.append(answer.size()).append("\n");
        for (Integer integer : answer) {
            sb.append(integer).append("\n");
        }
        System.out.print(sb);
    }

    private static int findNearHouse(boolean[][] map, int i, int j) {
        if(!map[i][j]) return 0;
        int result = 1;
        map[i][j] = false;
        if(i>0) result += findNearHouse(map, i-1, j);
        if(j>0) result += findNearHouse(map, i, j-1);
        if(i<map.length-1) result += findNearHouse(map, i+1, j);
        if(j<map.length-1) result += findNearHouse(map, i, j+1);
        return result;
    }
}
