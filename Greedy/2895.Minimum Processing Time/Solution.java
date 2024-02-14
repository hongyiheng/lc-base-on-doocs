class Solution {
    public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        Collections.sort(processorTime, (a, b) -> a - b);
        Collections.sort(tasks, (a, b) -> b - a);
        int ans = 0;
        for (int i = 0; i < processorTime.size(); i++) {
            ans = Math.max(ans, processorTime.get(i) + tasks.get(i * 4));
        }
        return ans;
    }
}