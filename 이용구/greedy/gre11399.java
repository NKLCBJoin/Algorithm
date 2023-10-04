package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//그리디 11399 atm 어쩔 eta~~
//걍 정렬하고 더하고 바꿔주기

public class gre11399 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(sc.nextInt());
        }
        int result = 0;
        Collections.sort(list);
        for (int i = 1; i <= list.size(); i++) {
            for (int j = 0; j < i; j++) {
                result += list.get(j);
            }
        }

        System.out.println(result);
    }
}