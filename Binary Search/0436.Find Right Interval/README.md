# [436. 寻找右区间](https://leetcode-cn.com/problems/find-right-interval)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个区间数组 <code>intervals</code> ，其中 <code>intervals[i] = [start<sub>i</sub>, end<sub>i</sub>]</code> ，且每个 <code>start<sub>i</sub></code> 都 <strong>不同</strong> 。</p>

<p>区间 <code>i</code> 的 <strong>右侧区间</strong> 可以记作区间 <code>j</code> ，并满足 <code>start<sub>j</sub></code><code> >= end<sub>i</sub></code> ，且 <code>start<sub>j</sub></code> <strong>最小化 </strong>。</p>

<p>返回一个由每个区间 <code>i</code> 的 <strong>右侧区间</strong> 的最小起始位置组成的数组。如果某个区间 <code>i</code> 不存在对应的 <strong>右侧区间</strong> ，则下标 <code>i</code> 处的值设为 <code>-1</code> 。</p>
 

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>intervals = [[1,2]]
<strong>输出：</strong>[-1]
<strong>解释：</strong>集合中只有一个区间，所以输出-1。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>intervals = [[3,4],[2,3],[1,2]]
<strong>输出：</strong>[-1, 0, 1]
<strong>解释：</strong>对于 [3,4] ，没有满足条件的“右侧”区间。
对于 [2,3] ，区间[3,4]具有最小的“右”起点;
对于 [1,2] ，区间[2,3]具有最小的“右”起点。
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>intervals = [[1,4],[2,3],[3,4]]
<strong>输出：</strong>[-1, 2, -1]
<strong>解释：</strong>对于区间 [1,4] 和 [3,4] ，没有满足条件的“右侧”区间。
对于 [2,3] ，区间 [3,4] 有最小的“右”起点。
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= intervals.length <= 2 * 10<sup>4</sup></code></li>
	<li><code>intervals[i].length == 2</code></li>
	<li><code>-10<sup>6</sup> <= start<sub>i</sub> <= end<sub>i</sub> <= 10<sup>6</sup></code></li>
	<li>每个间隔的起点都 <strong>不相同</strong></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def findRightInterval(self, intervals: List[List[int]]) -> List[int]:
        def hash(x):
            return x[0] * 13331 + x[1]

        n = len(intervals)
        ans = [-1] * n
        mp = dict()
        for i, v in enumerate(intervals):
            mp[hash(v)] = i
        intervals.sort(key=lambda x: x[0])
        for v in intervals:
            target = v[1]
            left, right = 0, n - 1
            while left < right:
                mid = (left + right) >> 1
                if intervals[mid][0] < target:
                    left = mid + 1
                else:
                    right = mid
            if intervals[left][0] >= target:
                ans[mp[hash(v)]] = mp[hash(intervals[left])]
        return ans

```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        Map<int[], Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            mp.put(intervals[i], i);
        }
        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int idx = mp.get(intervals[i]);
            int target = intervals[i][1];
            int left = 0, right = n - 1;
            while (left < right) {
                int mid = (left + right) >> 1;
                if (intervals[mid][0] < target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            if (intervals[left][0] >= target) {
                ans[idx] = mp.get(intervals[left]);
            } else {
                ans[idx] = -1;
            }
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
