package l;

public class LeetCode055 {
    public static boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0) return true;
        if(nums.length == 1 && nums[0] >= 0) return true;
//        [1,3,4,6,9]
        boolean[] use = new boolean[nums.length];
        use[0] = nums[0]!=0;
        for (int i = 0; i < nums.length; i++) {
            if(!use[i]) return false;
            for (int j = 0; j <= nums[i]; j++) {
                if(i+j < nums.length){
                    use[i+j] = true;
                }else{
                    return true;
                }
            }
        }
        return use[nums.length-1];
    }
}
