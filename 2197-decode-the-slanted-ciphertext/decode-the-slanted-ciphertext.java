class Solution {
    public String decodeCiphertext(String s, int rows) {
      
        if(rows==1)
        return s;   //edge cases
       int column=s.length()/rows;
       char arr[][]=new char[rows][column];
       int k=0;

       for(int i=0;i<rows;i++){
        for(int j=0;j<column;j++){
            arr[i][j]=s.charAt(k);
            k++;
        }
       } 

       StringBuilder sb=new StringBuilder();

       for(int t=0;t<column;t++){
          int i=0;
          int j=t;
          while(i<rows && j<column){
             sb.append(arr[i][j]);
             i++;
             j++;
          }
       }

       return sb.toString().replaceAll("\\s+$","");
    }
}