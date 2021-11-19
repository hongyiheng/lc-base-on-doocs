class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        Deque<Integer> path = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[len];
        if(len == 0) {
            return res;
        }
        dfs(path,nums,used,0,len,res);
        return res;
    }

    public void dfs(Deque<Integer> path,int[] nums,boolean[] used,int depth,int len,List<List<Integer>> res) {
        if(depth == len){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = 0; i < len; i ++){
            if(!used[i]){
                path.addLast(nums[i]);
                used[i] = true;
                dfs(path,nums,used,depth + 1,len,res);
                used[i] = false;
                path.removeLast();
            }
        }
    }
}