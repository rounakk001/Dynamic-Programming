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

    public void unionbyrank(int u,int v){
        int ulp_u=findPar(u);
        int ulp_v=findPar(v);

        if(ulp_u==ulp_v)
            return ;

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
     
    }
}
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> details) {
        int n=details.size();

        DisjointSet ds=new DisjointSet(n);

        HashMap<String,Integer> mapmailnode=new HashMap<>();

        for(int i=0;i<n;i++){
            for(int j=1;j<details.get(i).size();j++){
                String mail=details.get(i).get(j);
                if(mapmailnode.containsKey(mail)==false){
                    mapmailnode.put(mail,i);
                }
                else
                ds.unionbyrank(i,mapmailnode.get(mail));
            }
        }
        ArrayList<String>[] mergedmail=new ArrayList[n]; //array ke anad index pe arraylist rahegi
        for(int i=0;i<n;i++){
            mergedmail[i]=new ArrayList<String>();  //initialize kr rahe
        }

        for(Map.Entry<String,Integer> it:mapmailnode.entrySet()){
            String mail=it.getKey();
            int node=ds.findPar(it.getValue()); //ultimate parent of the node
            mergedmail[node].add(mail);
        }

        List<List<String>> ans=new ArrayList<>();

        for(int i=0;i<n;i++){
            if(mergedmail[i].size()==0) continue; //koi mail nhi hai us index pe, wo merge ho gayi
            
            Collections.sort(mergedmail[i]);
        

        List<String> temp=new ArrayList<>();

        temp.add(details.get(i).get(0)); //uska node pe kya naam tha,wo nikaal raha

        for(String it:mergedmail[i]){
            temp.add(it);
        }
        ans.add(temp);
        }
        return ans;
    }

}