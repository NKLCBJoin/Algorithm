package greedy;
import java.util.Scanner;

//그리디 알고리즘
// 백준 11047번
// 탐욕 알고리즘 특징 : 현재 최고의 경우를 선택한다. 이 선택은 이후 결과에 미칠 영향을 고려하지 않는다.
// 현재의 상활과 이후 상황이 개별로 처리될 때 최적으로 사용가능

public class gre11047 {

    public static void main(String[] args) {
        //동전의 갯수, 목표 원
        Scanner sc = new Scanner(System.in);

        int coinCount = sc.nextInt();
        int money = sc.nextInt();
        int[] coin = new int[coinCount];

        for(int i =0; i<coinCount; i++){
            coin[i]= sc.nextInt();
        }
        //money보다 커지는 coin을 캐치
        int count = 0;
        int balance = money;
        while(true){
            for(int i =coin.length-1;i>=0; i--){
                if(coin[i]<=balance) {
                    balance-=coin[i];
                    break;
                }
            }
            count++;
            if(balance==0){
                break;
            }
        }
        System.out.println(count);
        sc.close();
    }
}
