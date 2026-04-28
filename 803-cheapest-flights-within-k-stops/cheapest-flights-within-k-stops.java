class pair{
    int first,second;
    pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
class tuple{
    int stops,node,dist;
    tuple(int stops,int node,int dist){
        this.stops=stops;
        this.node=node;
        this.dist=dist;
    }
}
    class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        ArrayList<ArrayList<pair>> adj=new ArrayList<>();
        
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<flights.length;i++){
            adj.get(flights[i][0]).add(new pair(flights[i][1],flights[i][2]));
        }

        int dist[]=new int[n];

        Arrays.fill(dist,(int)(1e9));

        Queue<tuple> q=new LinkedList<>();

        q.add(new tuple(0,src,0));

        dist[src]=0;

        while(!q.isEmpty()){
            int node=q.peek().node;
            int stops=q.peek().stops;
            int distance=q.peek().dist;

            q.remove();

            if(stops>k)
            continue;

            for(pair itr:adj.get(node)){
                int adjNode=itr.first;
                int edW=itr.second;

                if(distance+edW<dist[adjNode] && stops<=k){
                    dist[adjNode]=distance+edW;
                    q.add(new tuple(stops+1,adjNode,distance+edW));
                }
            }
        }
        if(dist[dst]==(int)(1e9))
        return -1;

        return dist[dst];
    }
}