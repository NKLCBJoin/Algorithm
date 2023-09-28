import java.io.*;
import java.util.*;

public class Main {
    static List<Integer> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String tmp = st.nextToken();
            Stack<Character> stack = new Stack<>();

            for(int j = 0 ; j < tmp.length(); j++){
                char cur = tmp.charAt(j);

                if(cur == '('){
                    stack.push('(');
                }
                else if(cur == ')'){
                    if(stack.size() > 0)
                        stack.pop();
                    else if(stack.size() == 0){
                        System.out.println("NO");
                        break;
                    }
                }

                if(j== tmp.length()-1){
                    if(stack.size() == 0)
                        System.out.println("YES");
                    else
                        System.out.println("NO");
                }
            }
            //* 스택에다 관리하자!
            //=> )면 pop | Push()
            //=> 스택에 (가 없는데 )가 있으면 오류 발생
        }
    }
}
