package Graph;
/*You want to build a house on an empty land which reaches all buildings in the shortest amount of distance. You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:

Each 0 marks an empty land which you can pass by freely.
Each 1 marks a building which you cannot pass through.
Each 2 marks an obstacle which you cannot pass through.
For example, given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2):

1 - 0 - 2 - 0 - 1
|   |   |   |   |
0 - 0 - 0 - 0 - 0
|   |   |   |   |
0 - 0 - 1 - 0 - 0
The point (1,2) is an ideal empty land to build a house, as the total travel distance of 3+3+1=7 is minimal. So return 7.

Note:
There will be at least one building. If it is not possible to build such house according to the above rules, return -1.*/
import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceToHouse {
    int numofHouse=0;
    int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public int shortestDistance(int[][] grid) {
        int minDistance = Integer.MAX_VALUE;

        for(int i=0; i<grid.length;i++){
            for(int j=0; j<grid[0].length;j++){
                if(grid[i][j]==1){
                    numofHouse++;
                }
            }
        }

        for(int i=0; i<grid.length;i++){
            for(int j=0; j<grid[0].length;j++){
                if(grid[i][j]==2||grid[i][j]==1){
                    continue;
                }
                minDistance= Math.min(minDistance, bfs(grid,i,j));
            }
        }
        return minDistance==Integer.MAX_VALUE?-1:minDistance;
    }

    public int bfs(int[][] grid, int i, int j){
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        queue.offer(new int[]{i,j});
        visited[i][j]= true;
        int distance=0;
        int houses=0;
        int level=0;

        while(!queue.isEmpty()){
            int size=queue.size();
            for(int k=0; k<size;k++){
                int[] cur = queue.poll();
                if(grid[cur[0]][cur[1]]==1){
                    distance+=level;
                    houses++;
                    continue;
                }
                for(int[] dir:dirs){
                    int x= cur[0]+dir[0];
                    int y= cur[1]+dir[1];
                    if(x>=0&&x<grid.length&&y>=0&&y<grid[0].length&&!visited[x][y]&&grid[x][y]!=2){
                        visited[x][y]=true;
                        queue.offer(new int[]{x,y});
                    }
                }
            }
            level++;
        }
        return houses==numofHouse?distance:Integer.MAX_VALUE;
    }

    public static void main(String[] args) {

    }
}
