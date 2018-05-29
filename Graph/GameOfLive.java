package Graph;

public class GameOfLive {
    int[][] dirs ={{1,-1},{1,0},{1,1},{0,-1},{0,1},{-1,-1},{-1,0},{-1,1}};
    public void gameOfLife(int[][] board) {
        int m=board.length;
        int n=board[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int live=0;
                for(int[] dir: dirs){
                    int new_x= i+dir[0];
                    int new_y= j+dir[1];
                    if(new_x<0||new_y<0||new_x>=m|new_y>=n){
                        continue;
                    }
                    if(board[new_x][new_y]==1||board[new_x][new_y]==2) {
                        live++;
                    }
                }
                if(board[i][j]==0 && live==3){
                    //3 is live
                    board[i][j]=3;
                }
                if(board[i][j]==1 && (live <2 || live >3)){
                    // 2 is dead
                    board[i][j]=2;
                }
            }
        }
     //post processing
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                board[i][j] %=2;
            }
        }
    }
}
