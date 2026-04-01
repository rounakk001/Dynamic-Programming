import java.util.*;

class Solution{

    class Pair{
        int pos,speed;

        Pair(int pos,int speed){
            this.pos=pos;
            this.speed=speed;
        }
    }

    public double[] getCollisionTimes(int[][] cars){

        int n=cars.length;
        Pair pairs[]=new Pair[n];

        //pairs fill (pos + speed)
        for(int i=0;i<n;i++){
            pairs[i]=new Pair(cars[i][0],cars[i][1]);
        }

        double ans[]=new double[n];
        Arrays.fill(ans,-1.0);

        Stack<Integer>s=new Stack<>(); //stack me index store hoga

        //right se process (aage wali cars pehle)
        for(int i=n-1;i>=0;i--){

            int currPos=pairs[i].pos;
            int currSpeed=pairs[i].speed;

            while(!s.isEmpty()){

                int j=s.peek();

                
                int nextPos=pairs[j].pos;
                int nextSpeed=pairs[j].speed;

                //agar current slow hai to kabhi catch nahi karega
                if(currSpeed<=nextSpeed){
                    s.pop();
                }
                else{
                    double time=(double)(nextPos-currPos)/(currSpeed-nextSpeed); //collision time

                    //agar valid collision hai
                    if(ans[j]==-1||time<=ans[j]) break;

                    //warna next car pehle kisi aur se takra jayegi
                    s.pop();
                }
            }

            //agar collision possible hai
            if(!s.isEmpty()){
                int j=s.peek();
                ans[i]=(double)(pairs[j].pos-pairs[i].pos)/(pairs[i].speed-pairs[j].speed);
            }

            s.push(i); //current ko stack me daal
        }

        return ans;
    }
}