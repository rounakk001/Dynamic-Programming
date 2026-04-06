class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        
        int x=0,y=0;  //startpos
        int dir=0;    //0=N,1=E,2=S,3=W
        int maxDist=0; //maxdist^2

        //obstaclesfastcheck
        HashSet<String> set=new HashSet<>();
        for(int[] obs:obstacles){
            set.add(obs[0]+","+obs[1]); //storeas"X,Y"
        }

        for(int i=0;i<commands.length;i++){

            if(commands[i]==-1){ //rightturn
                dir=(dir+1)%4;   //+1mod4
            }
            else if(commands[i]==-2){ //leftturn
                dir=(dir+3)%4;       //+3mod4
            }
            else{
                //stepbystepmove
                for(int step=0;step<commands[i];step++){

                    int nx=x,ny=y; //nextpos

                    if(dir==0) ny++;      //North
                    else if(dir==1) nx++; //East
                    else if(dir==2) ny--; //South
                    else nx--;            //West

                    //obstaclecheck
                    if(set.contains(nx+","+ny)){
                        break; //stopifblocked
                    }

                    x=nx;
                    y=ny;

                    //updatedistance
                    maxDist=Math.max(maxDist,x*x+y*y);
                }
            }
        }

        return maxDist; //finalans
    }
}