package Graph;

public class MaxAreaOfIsland {
    int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public int maxAreaOfIsland(int[][] grid){
        if(grid==null||grid.length==0||grid[0].length==0){
            return 0;
        }
        int rows= grid.length;
        int columns=grid[0].length;
        int maxArea=0;
        for(int i=0; i<grid.length;i++){
            for(int j=0; j<grid[0].length;j++){
                if(grid[i][j]==1){
                    int area=dfs(grid,i,j,rows,columns,0);
                    maxArea=Math.max(area,maxArea);
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int i, int j, int rows, int columns, int area){
        if(i<0||i>=rows||j<0||j>=columns||grid[i][j]==0){
            return area;
        }
        grid[i][j]=0;
        area++;
        for(int[] dir: dirs){
            int x=i+dir[0];
            int y=j+dir[1];
            area= dfs(grid,x,y,rows,columns,area);
        }
        return area;
    }
}
