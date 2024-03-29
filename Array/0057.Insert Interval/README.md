# [57. 插入区间](https://leetcode-cn.com/problems/insert-interval)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个<strong> 无重叠的</strong><em> ，</em>按照区间起始端点排序的区间列表。</p>

<p>在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>intervals = [[1,3],[6,9]], newInterval = [2,5]
<strong>输出：</strong>[[1,5],[6,9]]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
<strong>输出：</strong>[[1,2],[3,10],[12,16]]
<strong>解释：</strong>这是因为新的区间 <code>[4,8]</code> 与 <code>[3,5],[6,7],[8,10]</code> 重叠。</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>intervals = [], newInterval = [5,7]
<strong>输出：</strong>[[5,7]]
</pre>

<p><strong>示例 4：</strong></p>

<pre>
<strong>输入：</strong>intervals = [[1,5]], newInterval = [2,3]
<strong>输出：</strong>[[1,5]]
</pre>

<p><strong>示例 5：</strong></p>

<pre>
<strong>输入：</strong>intervals = [[1,5]], newInterval = [2,7]
<strong>输出：</strong>[[1,7]]
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>0 <= intervals.length <= 10<sup>4</sup></code></li>
	<li><code>intervals[i].length == 2</code></li>
	<li><code>0 <= intervals[i][0] <= intervals[i][1] <= 10<sup>5</sup></code></li>
	<li><code>intervals</code> 根据 <code>intervals[i][0]</code> 按 <strong>升序</strong> 排列</li>
	<li><code>newInterval.length == 2</code></li>
	<li><code>0 <= newInterval[0] <= newInterval[1] <= 10<sup>5</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        ans = []
        i, n = 0, len(intervals)
        while i < n and intervals[i][1] < newInterval[0]:
            ans.append(intervals[i])
            i += 1
        l, r = newInterval
        while i < n and intervals[i][0] <= r and intervals[i][1] >= l:
            l = min(l, intervals[i][0])
            r = max(r, intervals[i][1])
            i += 1
        ans.append([l, r])
        while i < n:
            ans.append(intervals[i])
            i += 1
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        int i = 0, n = intervals.length;
        while (i < n && intervals[i][1] < newInterval[0]) {
            ans.add(intervals[i]);
            i++;
        }
        int l = newInterval[0], r = newInterval[1];
        while (i < n && intervals[i][0] <= r && intervals[i][1] >= l) {
            l = Math.min(l, intervals[i][0]);
            r = Math.max(r, intervals[i][1]);
            i++;
        }
        ans.add(new int[]{l, r});
        while (i < n) {
            ans.add(intervals[i]);
            i++;
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
```

### **...**

```

```

<!-- tabs:end -->
