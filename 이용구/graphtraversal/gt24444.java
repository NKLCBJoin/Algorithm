package graphtraversal;


//gt24444 너비우선탐색1
//bfs

import java.util.*;

public class gt24444 {

    public static int n,m,r;
    public static List<Integer>[]arr;
    public static boolean []visited;
    public static int []order;
    public static int cnt=0;

    public static void BFS(int n){
        Queue<Integer> queue=new LinkedList<Integer>();
        queue.add(n);
        visited[n]=true;

        while(!queue.isEmpty()){
            int x=queue.poll();
            cnt++;
            order[x]=cnt;

            for(int node:arr[x]){
                if(!visited[node]){
                    queue.add(node);
                    visited[node]=true;
                }
            }
        }
    }

    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        r=sc.nextInt();
        arr=new ArrayList[n+1];
        visited=new boolean[n+1];
        order=new int[n+1];
        Arrays.fill(order,0);
        for(int i=0;i<=n;i++){
            arr[i]=new ArrayList<Integer>();
        }

        for(int i=0;i<m;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            arr[a].add(b);
            arr[b].add(a);
        }
        for(int i=1;i<=n;i++){
            Collections.sort(arr[i]);

        }
        BFS(r);

        for(int i=1;i<=n;i++){
            System.out.println(order[i]);
        }

    }

}
