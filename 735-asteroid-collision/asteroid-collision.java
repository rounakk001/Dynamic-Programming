class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer>  s=new Stack<>();

        for(int i=0;i<asteroids.length;i++){
            if(asteroids[i]>0)
            {
                s.push(asteroids[i]);
            }
            else{
                boolean gaadfatgayi=false;
                while(!s.isEmpty() && s.peek()>0){
                    if(Math.abs(asteroids[i])>s.peek()){
                        s.pop();
                    }
                    else if(Math.abs(asteroids[i])<s.peek()){
                        gaadfatgayi=true;
                          break;
                    }
                    else{
                        s.pop();
                        gaadfatgayi=true;
                        break;
                    }
                }
                if(!gaadfatgayi){
                    s.push(asteroids[i]);
                }
            }
        }
         int result[]=new int[s.size()];
        //ab stack me survivor pade hue hai

        int i=s.size()-1;

        while(i>=0){
           result[i--]=s.pop();
        }
        return result;
    }
}