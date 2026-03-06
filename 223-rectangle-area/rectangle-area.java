class Solution {

    public int computeArea(int A, int B, int C, int D,
                           int E, int F, int G, int H) {

        int areaA=(C-A)*(D-B);
        int areaB=(G-E)*(H-F);

        int left=Math.max(A,E);
        int right=Math.min(C,G);
        int bottom=Math.max(B,F);
        int top=Math.min(D,H);

        int c=0;
          //yaha c mtlb overlapping haiiii
        if(right>left && top>bottom){
            c=(right-left)*(top-bottom);
        }

        return areaA+areaB-c;
    }
}