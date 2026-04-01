class Solution {
    class Pair{
        int pos, speed;

        Pair(int pos,int speed){
            this.pos=pos;
            this.speed=speed;
        }
    };
    public int carFleet(int target, int[] pos, int[] speed) {
        if(pos.length==1)
        return 1;
        int n=pos.length;

        Pair pairs[]=new Pair[n];

        for(int i=0;i<pos.length;i++){
            pairs[i]=new Pair(pos[i],speed[i]);
        }

        Arrays.sort(pairs,(a,b)->b.pos-a.pos);  //sort kr lo position ko descending order mein kyuki position jitni badi utna target ke close

        Stack<Double> s=new Stack<>();
        
        for(Pair curr:pairs){

           double time=(double)(target-curr.pos)/curr.speed;

           if(!s.isEmpty() && time<=s.peek()){
            continue;  //yaha pe merge ho raha mtlb peeche waale gaadi ko kam time lag raha 
           }else
           {
            s.push(time);
           }
   

        }

        return s.size();


      
    }
}