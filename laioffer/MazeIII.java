package laioffer;

public class MazeIII {
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        if(maze==null|| maze.length==0|| maze[0].length==0){
            return null;
        }
        String res = "";
        int rows= maze.length;
        int columns = maze[0].length;
        for(int i=0; i<rows;i++){
            for (int j=0;j<columns;j++){
                if (maze[i][j]=='0'){
                    dfs(maze, i, j, rows, columns, hole);
                }
            }
        }
        return res;
    }
    final static int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    private void dfs(int[][] grid, int x, int y, int rows, int columns,int[] hole) {
        if(x<0||x>=rows||y<0||y>=columns||grid[x][y]=='1'){
            return;
        }
        if(x == hole[0] && y == hole[1]){
            return;
        }
        grid[x][y]='1';
        for(int[] dir : dirs){
            int neiX = dir[0]+x;
            int neiY = dir[1]+y;
            dfs(grid,neiX,neiY,rows,columns,hole);
        }
    }
}
