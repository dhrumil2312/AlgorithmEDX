package GraphAlgorithms;

public class NetworkDelay {

    static int minDistance(int[] visited, int[] distance){
        int minIndex = 0;
        int minValue = Integer.MAX_VALUE;

        for(int i = 0 ; i < visited.length ; i++){
            if(visited[i]==0 && distance[i] < minValue){
                minIndex = i;
                minValue = distance[i];
            }
        }
        return  minIndex;
    }

    static int networkDelayTime(int[][] graph, int nodes, int start_node){

        int[] distance = new int[nodes];
        int[] visited = new int[nodes];

        for(int i = 0 ; i < nodes ; i++){
            distance[i] = Integer.MAX_VALUE;
        }

        distance[start_node] = 0 ;

        for(int i = 0 ; i < nodes-1 ; i++){
            int currentNode = minDistance(visited, distance);

            visited[currentNode] = 1 ;

            for(int j = 0 ; j < nodes ; j++){

                if(visited[j]==0 && graph[currentNode][j] != -1 && distance[currentNode] != Integer.MAX_VALUE && distance[currentNode] + graph[currentNode][j] < distance[j]){
                    distance[j]= distance[currentNode] + graph[currentNode][j];
                }
            }

        }
        int ans = Integer.MIN_VALUE ;
        for(int i : distance){
            System.out.printf(" %d " , i);
            if(i == Integer.MAX_VALUE){
                return -1;
            }
            if(ans < i){
                ans = i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] times = {{3,5,78},{2,1,1},{1,3,0},{4,3,59},{5,3,85},{5,2,22},{2,4,23},{1,4,43},{4,5,75},{5,1,15},{1,5,91},{4,1,16},{3,2,98},{3,4,22},{5,4,31},{1,2,0},{2,5,4},{4,2,51},{3,1,36},{2,3,59}};

        int N=5;
        int K=5;

        int[][] graph = new int[N][N];

        for(int[] i : times){
            int start = i[0] -1;
            int end = i[1] -1;

            if(i[2] == 0){
                graph[start][end] = -2;
            }
            else {
                graph[start][end] = i[2];
            }
        }


        for(int i = 0 ; i < N ; i ++){
            for(int j = 0 ; j < N ; j++){
                if(graph[i][j] == 0){
                   graph[i][j] = -1;
                }
                if(graph[i][j] == -2){
                    graph[i][j] = 0;
                }
            }
        }

        System.out.println(networkDelayTime(graph,N ,  K-1));
    }
}
