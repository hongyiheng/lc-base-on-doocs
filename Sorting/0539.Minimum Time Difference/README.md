# [539. 最小时间差](https://leetcode-cn.com/problems/minimum-time-difference)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个 24 小时制（小时:分钟 <strong>"HH:MM"</strong>）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>timePoints = ["23:59","00:00"]
<strong>输出：</strong>1
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>timePoints = ["00:00","23:59","00:00"]
<strong>输出：</strong>0
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>2 <= timePoints <= 2 * 10<sup>4</sup></code></li>
	<li><code>timePoints[i]</code> 格式为 <strong>"HH:MM"</strong></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def findMinDifference(self, timePoints: List[str]) -> int: 
        if len(timePoints) > 24 * 60:
            return 0
        mins = sorted(int(t[:2]) * 60 + int(t[3:]) for t in timePoints)
        mins.append(mins[0] + 24 * 60)
        ans = float("inf")
        for i in range(1, len(mins)):
            diff = mins[i] - mins[i - 1]
            ans = min(diff, ans)
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        if (n > 24 * 60) {
            return 0;
        }
        PriorityQueue<Integer> mins = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        int minTime = Integer.MAX_VALUE;
        for (String t : timePoints) {
            int hour = Integer.parseInt(t.split(":")[0]);
            int min = Integer.parseInt(t.split(":")[1]);
            mins.offer(hour * 60 + min);
            minTime = Math.min(minTime, hour * 60 + min);
        }
        mins.offer(minTime + 24 * 60);
        int ans = Integer.MAX_VALUE;
        int last = mins.poll();
        while (!mins.isEmpty()) {
            int cur = mins.poll();
            int diff = last - cur;
            ans = Math.min(ans, diff);
            last = cur;
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
