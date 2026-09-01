class Solution {
    public int addDigits(int num) {
        if(num==0){
            return 0;
        }
        int digit=0;
       
           while( num>0){ 
            digit+=num%10;
            num=num/10;}
            if(digit>=10){
                return addDigits(digit);
            }
            return digit;
        
        
    }
}