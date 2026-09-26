class Solution {
    public int numDecodings(String s) {
        int dp[]=new int[s.length()];

        Arrays.fill(dp,-1);

        return solve(s,0,dp);
    }

    public int solve(String s,int i, int[] dp){
        //base case 
        if(i==s.length()){
            return 1;
        }


        if(dp[i]!=-1){    //memo
            return dp[i];
        }

        //0 se shuru hone wale ko consider nahi krenge
        if(s.charAt(i)=='0'){
            return 0;
        }

        int ways=solve(s,i+1,dp);

        //yaha check krenge ki i+1 s.length se km hai ki nahi warna do characters le hi nahi skte example 226 me agar i=2 hai pe last digit 6 hai to 6 ke baad koi character hi nahi hai 
        if(i+1<s.length()){
            int number=Integer.parseInt(s.substring(i,i+2));

            if(number>=10 && number<=26){
                ways=ways+solve(s,i+2,dp);
            }
        }
        return  dp[i]=ways;

    }
}