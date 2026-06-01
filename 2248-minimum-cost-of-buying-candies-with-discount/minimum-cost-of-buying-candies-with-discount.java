class Solution {
    public int minimumCost(int[] cost) {
        if(cost.length==2)
        return cost[0]+cost[1];

        Arrays.sort(cost);

        int totalcost=0;
        int d=0;

        for(int i=cost.length-1;i>=0;i--){

            if(d==2){
                d=0;
                continue;
            }
            totalcost+=cost[i];  
            d++;

            

        }
        return totalcost;
    }
}