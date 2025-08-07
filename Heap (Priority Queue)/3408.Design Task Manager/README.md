# [3408. 设计任务管理器](https://leetcode.cn/problems/design-task-manager)

## 题目描述

<!-- 这里写题目描述 -->

<p>一个任务管理器系统可以让用户管理他们的任务，每个任务有一个优先级。这个系统需要高效地处理添加、修改、执行和删除任务的操作。</p>

<p>请你设计一个&nbsp;<code>TaskManager</code>&nbsp;类：</p>

<ul>
	<li>
	<p><code>TaskManager(vector&lt;vector&lt;int&gt;&gt;&amp; tasks)</code>&nbsp;初始化任务管理器，初始化的数组格式为&nbsp;<code>[userId, taskId, priority]</code>&nbsp;，表示给 <code>userId</code>&nbsp;添加一个优先级为 <code>priority</code>&nbsp;的任务 <code>taskId</code>&nbsp;。</p>
	</li>
	<li>
	<p><code>void add(int userId, int taskId, int priority)</code>&nbsp;表示给用户 <code>userId</code>&nbsp;添加一个优先级为 <code>priority</code>&nbsp;的任务 <code>taskId</code>&nbsp;，输入 <strong>保证&nbsp;</strong><code>taskId</code>&nbsp;不在系统中。</p>
	</li>
	<li>
	<p><code>void edit(int taskId, int newPriority)</code>&nbsp;更新已经存在的任务&nbsp;<code>taskId</code>&nbsp;的优先级为&nbsp;<code>newPriority</code>&nbsp;。输入 <strong>保证</strong>&nbsp;<code>taskId</code>&nbsp;存在于系统中。</p>
	</li>
	<li>
	<p><code>void rmv(int taskId)</code>&nbsp;从系统中删除任务&nbsp;<code>taskId</code>&nbsp;。输入 <strong>保证</strong>&nbsp;<code>taskId</code>&nbsp;存在于系统中。</p>
	</li>
	<li>
	<p><code>int execTop()</code>&nbsp;执行所有用户的任务中优先级 <strong>最高</strong>&nbsp;的任务，如果有多个任务优先级相同且都为 <strong>最高</strong>&nbsp;，执行&nbsp;<code>taskId</code>&nbsp;最大的一个任务。执行完任务后，<code>taskId</code><strong>&nbsp;</strong>从系统中 <strong>删除</strong>&nbsp;。同时请你返回这个任务所属的用户&nbsp;<code>userId</code>&nbsp;。如果不存在任何任务，返回&nbsp;-1 。</p>
	</li>
</ul>

<p><strong>注意</strong> ，一个用户可能被安排多个任务。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<div class="example-block">
<p><strong>输入：</strong><br />
<span class="example-io">["TaskManager", "add", "edit", "execTop", "rmv", "add", "execTop"]<br />
[[[[1, 101, 10], [2, 102, 20], [3, 103, 15]]], [4, 104, 5], [102, 8], [], [101], [5, 105, 15], []]</span></p>

<p><strong>输出：</strong><br />
<span class="example-io">[null, null, null, 3, null, null, 5] </span></p>

<p><strong>解释：</strong></p>
TaskManager taskManager = new TaskManager([[1, 101, 10], [2, 102, 20], [3, 103, 15]]); // 分别给用户 1 ，2 和 3 初始化一个任务。<br />
taskManager.add(4, 104, 5); // 给用户 4 添加优先级为 5 的任务 104 。<br />
taskManager.edit(102, 8); // 更新任务 102 的优先级为 8 。<br />
taskManager.execTop(); // 返回 3 。执行用户 3 的任务 103 。<br />
taskManager.rmv(101); // 将系统中的任务 101 删除。<br />
taskManager.add(5, 105, 15); // 给用户 5 添加优先级为 15 的任务 105 。<br />
taskManager.execTop(); // 返回 5 。执行用户 5 的任务 105 。</div>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= tasks.length &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= userId &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= taskId &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= priority &lt;= 10<sup>9</sup></code></li>
	<li><code>0 &lt;= newPriority &lt;= 10<sup>9</sup></code></li>
	<li><code>add</code>&nbsp;，<code>edit</code>&nbsp;，<code>rmv</code>&nbsp;和&nbsp;<code>execTop</code>&nbsp;的总操作次数 <strong>加起来</strong>&nbsp;不超过&nbsp;<code>2 * 10<sup>5</sup></code> 次。</li>
	<li>输入保证&nbsp;<code>taskId</code> 是合法的。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class TaskManager:

    def __init__(self, tasks: List[List[int]]):
        self.q = []
        self.rm = defaultdict(int)
        self.user = defaultdict(int)
        self.d = 0
        for u, t, p in tasks:
            self.add(u, t, p)
        
    def add(self, userId: int, taskId: int, priority: int) -> None:
        heapq.heappush(self.q, [-priority, -taskId, self.d])
        self.user[taskId] = userId
        self.d += 1
        
    def edit(self, taskId: int, newPriority: int) -> None:
        self.rmv(taskId)
        heapq.heappush(self.q, [-newPriority, -taskId, self.d])
        
    def rmv(self, taskId: int) -> None:
        self.rm[taskId] = self.d
        self.d += 1
        
    def execTop(self) -> int:
        if not self.q:
            return -1
        p, t, d = heapq.heappop(self.q)
        while d <= self.rm.get(-t, -1):
            if self.q:
                p, t, d = heapq.heappop(self.q)
            else:
                return -1
        return self.user[-t]
        


# Your TaskManager object will be instantiated and called as such:
# obj = TaskManager(tasks)
# obj.add(userId,taskId,priority)
# obj.edit(taskId,newPriority)
# obj.rmv(taskId)
# param_4 = obj.execTop()
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
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
```

### **...**

```

```

<!-- tabs:end -->
