# [1345. 跳跃游戏 IV](https://leetcode-cn.com/problems/jump-game-iv)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个整数数组&nbsp;<code>arr</code>&nbsp;，你一开始在数组的第一个元素处（下标为 0）。</p>

<p>每一步，你可以从下标&nbsp;<code>i</code>&nbsp;跳到下标：</p>

<ul>
	<li><code>i + 1</code>&nbsp;满足：<code>i + 1 &lt; arr.length</code></li>
	<li><code>i - 1</code>&nbsp;满足：<code>i - 1 &gt;= 0</code></li>
	<li><code>j</code>&nbsp;满足：<code>arr[i] == arr[j]</code>&nbsp;且&nbsp;<code>i != j</code></li>
</ul>

<p>请你返回到达数组最后一个元素的下标处所需的&nbsp;<strong>最少操作次数</strong>&nbsp;。</p>

<p>注意：任何时候你都不能跳到数组外面。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>arr = [100,-23,-23,404,100,23,23,23,3,404]
<strong>输出：</strong>3
<strong>解释：</strong>那你需要跳跃 3 次，下标依次为 0 --&gt; 4 --&gt; 3 --&gt; 9 。下标 9 为数组的最后一个元素的下标。
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>arr = [7]
<strong>输出：</strong>0
<strong>解释：</strong>一开始就在最后一个元素处，所以你不需要跳跃。
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>arr = [7,6,9,6,9,6,9,7]
<strong>输出：</strong>1
<strong>解释：</strong>你可以直接从下标 0 处跳到下标 7 处，也就是数组的最后一个元素处。
</pre>

<p><strong>示例 4：</strong></p>

<pre><strong>输入：</strong>arr = [6,1,9]
<strong>输出：</strong>2
</pre>

<p><strong>示例 5：</strong></p>

<pre><strong>输入：</strong>arr = [11,22,7,7,7,7,7,7,7,22,13]
<strong>输出：</strong>3
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= arr.length &lt;= 5 * 10^4</code></li>
	<li><code>-10^8 &lt;= arr[i] &lt;= 10^8</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def minJumps(self, arr: List[int]) -> int:
        n = len(arr)
        mp = defaultdict(list)
        for i, v in enumerate(arr):
            mp[v].append(i)
        steps = [float('inf')] * n
        q = deque([0])
        steps[0] = 0
        while q:
            cur = q.popleft()
            step = steps[cur]
            if cur == n - 1:
                return step
            for index in mp[arr[cur]]:
                if steps[index] == float('inf'):
                    q.append(index)
                    steps[index] = step + 1
            mp.pop(arr[cur])
            if cur and steps[cur - 1] == float('inf'):
                q.append(cur - 1)
                steps[cur - 1] = step + 1
            if steps[cur + 1] == float('inf'):
                q.append(cur + 1)
                steps[cur + 1] = step + 1
        return -1
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        Map<Integer, List<Integer>> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            mp.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
        int[] steps = new int[n];
        Arrays.fill(steps, Integer.MAX_VALUE);
        Deque<Integer> q = new ArrayDeque<>();
        q.add(0);
        steps[0] = 0;
        while (!q.isEmpty()) {
            int cur = q.pollFirst(), step = steps[cur];
            if (cur == n - 1) {
                return step;
            }
            if (cur - 1 >= 0 && steps[cur - 1] == Integer.MAX_VALUE) {
                q.addLast(cur - 1);
                steps[cur - 1] = step + 1;
            }
            if (cur + 1 < n && steps[cur + 1] == Integer.MAX_VALUE) {
                q.addLast(cur + 1);
                steps[cur + 1] = step + 1;
            }
            List<Integer> same = mp.getOrDefault(arr[cur], Collections.emptyList());
            for (int index : same) {
                if (steps[index] == Integer.MAX_VALUE) {
                    q.addLast(index);
                    steps[index] = step + 1;
                }
            }
            mp.remove(arr[cur]);
        }
        return -1;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
