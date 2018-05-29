package Microsoft;

public class UnionFind {
    private int[] nums;
    public UnionFind(int n){
        nums = new int[n];
        for(int i=0; i<n;i++){
             nums[i]=i;
        }
    }

    private int findRoot(int a){
        int root =a;
        while(nums[root]!=root){
            root= nums[root];
        }
        while(a!=root){
            int temp= nums[a];
            nums[a]=root;
            a=temp;
        }
        return root;
    }

    public void union(int x, int y){
        int rootX=findRoot(x);
        int rootY=findRoot(y);
        nums[rootX]= rootY;
    }

    public boolean find(int x, int y){
        return findRoot(x)==findRoot(y);
    }
}
