class Solution {
    class Robot{
        int pos,health,index;

        char dir;

        Robot(int pos,int health,int index,char dir){
            this.pos=pos;
            this.health=health;
            this.index=index;
            this.dir=dir;
        }
    }
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {

        int n=positions.length;

        Robot robots[]=new Robot[n];
        

        //yaha robots ko combine kr diya hai saare ek saath
        for(int i=0;i<n;i++){
            robots[i]=new Robot(positions[i],healths[i],i,directions.charAt(i));
        }

        //ab sort kr lenege position ke hisaab se

        Arrays.sort(robots, (a,b)->a.pos-b.pos);

        Stack<Robot> s=new Stack<>();

        for(Robot curr:robots){
          
          if(curr.dir=='R')
          s.push(curr);

          else{
            //curr dir left hai
            while(!s.isEmpty() && s.peek().dir=='R'){
                //iska mtlb collison hoga curr aur jo already pressent tha


                if(curr.health>s.peek().health){
                  s.pop();
                  curr.health--;
                }
                else if(curr.health<s.peek().health){
                    s.peek().health--;
                    curr=null;
                    break;
                }
                else{
                    //dono barabar hai
                    s.pop();
                    curr=null;
                    break;
                }
            }
                if(curr!=null){
                    s.push(curr);
                }
            }

          }
           //result storee karao ab
          List<Robot> survivor=new ArrayList<>(s);

          Collections.sort(survivor, (a,b)->a.index-b.index);

           List<Integer> result= new ArrayList<>();
          for(Robot r:survivor){
             result.add(r.health);
          }

          return result;

         }

}