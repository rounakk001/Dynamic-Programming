class pair{
    double probability;
    int node;
    pair(double probability,int node){
        this.probability=probability;
        this.node=node;
    }
}
 class Solution {

    public double maxProbability(int n, int[][] edges, double[] weight, int src, int dest) {
        ArrayList<ArrayList<pair>> adj=new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(new pair(weight[i],edges[i][1]));
            adj.get(edges[i][1]).add(new pair(weight[i],edges[i][0]));
        }

        PriorityQueue<pair> pq=new PriorityQueue<>((x,y)->Double.compare(y.probability, x.probability));

        double dist[]=new double[n];

        Arrays.fill(dist,0.0);

        pq.add(new pair(1.0,src));

        dist[src]=1.0;

        while(!pq.isEmpty()){
            double prob=pq.peek().probability;

            int node=pq.peek().node;

            if(node==dest){
                return prob;
            }

            pq.remove();

            for(pair itr:adj.get(node)){
                double probneig=itr.probability;
                int adjNode=itr.node;

                if((prob*probneig)>dist[adjNode]){
                    dist[adjNode]=prob*probneig;
                    pq.add(new pair(prob*probneig,adjNode));
                }
            }
        }
        return 0.0;
    }
}