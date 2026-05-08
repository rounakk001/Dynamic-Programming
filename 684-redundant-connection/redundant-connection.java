class DisjointSet{
    ArrayList<Integer> rank=new ArrayList<>();
    ArrayList<Integer> parent=new ArrayList<>();

    DisjointSet(int n){
        for(int i=0;i<=n;i++){
            rank.add(0);
            parent.add(i);
        }
    }

    public int findPar(int node){
        if(node==parent.get(node)){
            return node;
        }

        int ulp=findPar(parent.get(node));
        //path compression
        parent.set(node,ulp);
        return parent.get(node);
    }

    public boolean unionbyrank(int u,int v){
        int ulp_u=findPar(u);
        int ulp_v=findPar(v);

        if(ulp_u==ulp_v)
            return false;

        if(rank.get(ulp_u)<rank.get(ulp_v))
            parent.set(ulp_u,ulp_v);

        else if(rank.get(ulp_v)<rank.get(ulp_u))
            parent.set(ulp_v,ulp_u);
        else
            {
                parent.set(ulp_v,ulp_u);
                int ulp=rank.get(ulp_u);
                rank.set(ulp_u,ulp+1);
            }
     return true;
    }
}
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        

        DisjointSet ds=new DisjointSet(n);

        for(int i=0;i<n;i++){
            int u=edges[i][0];
            int v=edges[i][1];

                    if(ds.unionbyrank(u,v)==false)
                    return new int[]{u,v};
                }
    
        return new int[]{0,0};
    }
}
