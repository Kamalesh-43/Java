class Solution {
    public int countDigitOccurrences(int[] nums, int digit) {
        int count=0,m;
        for(int i=0;i<nums.length;i++){
            m=nums[i];
            while(m!=0){
                if(m%10==digit){
                    count +=1;
                }
                m/=10;
            }
        }
        return count;
    }
}