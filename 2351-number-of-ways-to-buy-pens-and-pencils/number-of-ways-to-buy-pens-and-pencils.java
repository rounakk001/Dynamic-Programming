class Solution {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        int maxpen=total/cost1;
        int maxpencil=total/cost2;
      long count=0;
      int remaining=0;

        while(maxpen>=0){
            remaining=total-(maxpen*cost1);
            count+=remaining/cost2+1;
            maxpen--;
            remaining=0;
        }
    return count;
    }
    
}