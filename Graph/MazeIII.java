package Graph;

import java.util.LinkedList;

import java.util.Queue;

public class MazeIII {
    private class Element{
        int direction;//down left right up
        int row, column;
        String moves;

        Element(int row, int column, String moves, int direction){
            this.row=row;
            this.column=column;
            this.direction=direction;
            this.moves=moves;
        }
    }

    public String findShortestWay(int[][] maze, int[] ball, int[] hole){
        int m=maze.length;
        int n=maze[0].length;
        Queue<Element> queue= new LinkedList<>();
        char[] directions={'d','l','r','u'};
        //dirs has to match the directions letter so that we can use to generate
        int[][] dirs={{1,0},{0,-1},{0,1},{-1,0}};
        boolean[][][] visited = new boolean[m][n][4];
        //initiate the queue
        for(int i=0; i<4;i++){
            int x= ball[0]+dirs[i][0];
            int y= ball[1]+dirs[i][1];
            if(x>=0&&x<m&&y>=0&&y<n&&maze[x][y]==0){
                queue.add(new Element(x,y,String.valueOf(directions[i]),i));
            }
        }
        //begin BFS
        while(!queue.isEmpty()){
            Element cur= queue.poll();
            visited[cur.row][cur.column][cur.direction]=true;
            //check is on the hole return if so
            if(cur.row==hole[0]&&cur.column==hole[1]){
                return cur.moves;
            }
            //begin generate from cur, start form the same direction
            int neiX=cur.row+dirs[cur.direction][0];
            int neiY=cur.column+dirs[cur.direction][1];
            if(neiX>=0&&neiX<m&&neiY>=0&&neiY<n&&maze[neiX][neiY]==0&&!visited[neiX][neiY][cur.direction]){
                queue.offer(new Element(neiX,neiY,cur.moves,cur.direction));
            }else{
                //change direction to generate
                for(int i=0; i<4; i++){
                    if(i!=cur.direction){
                        int newX=cur.row+dirs[i][0];
                        int newY=cur.column+dirs[i][1];
                        if(newX>=0&&newX<m&&newY>=0&&newY<n&&maze[newX][newY]==0&&!visited[newX][newY][i]){
                            queue.offer(new Element(newX,newY,cur.moves+directions[i],i));
                        }
                    }
                }
            }
        }
        return "impossible";
    }

    public static void main(String[] args) {
        int[][] maze={{0,0,0,0,0},{1,1,0,0,1},{0,0,0,0,0},{0,1,0,0,1},{0,1,0,0,0}};
        int[] ball= {4,3};
        int[] hole= {0,1};
        MazeIII m= new MazeIII();
        m.findShortestWay(maze,ball,hole);
    }
}
