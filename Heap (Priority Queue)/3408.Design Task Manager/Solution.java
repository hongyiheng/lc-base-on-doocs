class TaskManager {

    PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] == b[0] ? b[1] - a[1] : b[0] - a[0]);
    Map<Integer, Integer> rm = new HashMap<>();
    Map<Integer, Integer> user = new HashMap<>();
    int d = 0;

    public TaskManager(List<List<Integer>> tasks) {
        for (List<Integer> item : tasks) {
            add(item.get(0), item.get(1), item.get(2));
        }
    }

    public void add(int userId, int taskId, int priority) {
        q.add(new int[]{priority, taskId, d++});
        user.put(taskId, userId);
    }

    public void edit(int taskId, int newPriority) {
        rmv(taskId);
        q.add(new int[]{newPriority, taskId, d});
    }

    public void rmv(int taskId) {
        rm.put(taskId, d++);
    }

    public int execTop() {
        if (q.isEmpty()) {
            return -1;
        }
        int[] cur = q.poll();
        int t = cur[1];
        while (cur[2] <= rm.getOrDefault(t, -1)) {
            if (!q.isEmpty()) {
                cur = q.poll();
                t = cur[1];
            } else {
                return -1;
            }
        }
        return user.get(t);
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */