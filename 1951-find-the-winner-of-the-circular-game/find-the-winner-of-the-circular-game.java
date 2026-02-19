class Solution {
    public int help(int ind,List<Integer> arr,int k){

          if(arr.size()==1)
          return arr.get(0);

        ind=(ind+k-1)%arr.size(); 
        //ek time agar modulo nhi krenge to ind 4 ho jayega aur rray ki size 2 to ot of bound aayega isliye size se modulo to map ho jayega element particular index se us array ke hisaab se

          arr.remove(ind);

         return  help(ind,arr,k);

         
    }
    public int findTheWinner(int n, int k) {
       List<Integer> arr=new ArrayList<>();
       for(int i=1;i<=n;i++){
        arr.add(i);
       }

       return help(0,arr,k);
    }
}