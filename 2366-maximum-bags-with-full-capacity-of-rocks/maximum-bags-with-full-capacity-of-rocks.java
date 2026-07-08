class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int extrarock) {

       
        int diff[]=new int [capacity.length];

        for(int i=0;i<capacity.length;i++){
            diff[i]=capacity[i]-rocks[i];
        }

        Arrays.sort(diff);

        int c=0;

       for(int d:diff){
        if(extrarock>=d){
            extrarock=extrarock-d;
            c++;
        }
        else{
            break;
        }
       }
        
    return c;
    }
}