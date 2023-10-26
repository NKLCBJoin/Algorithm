import java.util.*;
class Solution {
    static HashSet<String> list= new HashSet<>();
    static int[] visited;
    static String ary;
    public int solution(String numbers) {
        ary = numbers;
        visited= new int[ary.length()];
        int answer = 0;

        findAll(0,"");
        Iterator<String> iter = list.iterator(); // set을 Iterator 안에 담기
        while(iter.hasNext()) { // iterator에 다음 값이 있다면
            //System.out.println("iterator : " + iter.next()); // iter에서 값 꺼내기

            //이게 소수인가?
            int isPrime = 0;
            int cur = Integer.parseInt(iter.next());
            System.out.println(cur);
            for(int i = 2; i * i <= cur; i++){
                if(cur % i == 0){
                    isPrime = 1;
                    break;
                }
            }
            if(cur != 1 && isPrime == 0)
                answer++;
        }

        return answer;
    }
    public static void findAll(int depth,String cur){
        if(depth == ary.length()){
            return;
        }

        for(int i = 0 ; i < ary.length(); i++){
            if(visited[i] == 0){
                visited[i] = 1;
                String temp = cur + ary.charAt(i);
                if(temp.charAt(0) != '0')
                    list.add(temp);
                findAll(depth+1, temp);
                visited[i] = 0;
            }
        }
    }
}