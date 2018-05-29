package Company;


import java.util.PriorityQueue;

public class SuperBowl {
    double[] probability = {0.5,0.3,0.2};
    class node implements Comparable<node>{
        int scoreA;
        int scoreB;
        double prob;
        node(int teamA, int teamB, double prob){
            this.scoreA=teamA;
            this.scoreB=teamB;
            this.prob=prob;
        }

        @Override
        public int compareTo(node that) {
            return this.prob< that.prob ? 1:-1;
        }
    }


    private double calculateP(int round, int score, double[] probability, int maxScore){
        double sum=0.00;
        if(round==1 && score >=0 &&score<probability.length){
            return probability[score];
        }else if(round>1){
            for(int i=0; i<probability.length;i++){
                double temp= calculateP(round-1, score-i,probability,probability.length);
                sum+=temp*probability[i];
            }
        }
        return sum;
    }

    node[] getTop10(int round){
        PriorityQueue<node> pq= new PriorityQueue<node>((a-b) -> )
        for(int a=0; a<= 2*round; a++){
            for(int b=0; b<= 2* round; b++){
                double curP = calculateP(round,a,probability,probability.length)*
                             calculateP(round,b,probability,probability.length);
                node cur =new node(a,b,curP);
            }
        }
    }

}
