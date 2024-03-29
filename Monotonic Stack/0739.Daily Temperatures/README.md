# [739. 每日温度](https://leetcode-cn.com/problems/daily-temperatures)



## 题目描述

<!-- 这里写题目描述 -->

<p>请根据每日 <code>气温</code> 列表 <code>temperatures</code> ，<span style="font-size:10.5pt"><span style="font-family:Calibri"><span style="font-size:10.5000pt"><span style="font-family:宋体"><font face="宋体">请计算在每一天需要等几天才会有更高的温度</font></span></span></span></span>。如果气温在这之后都不会升高，请在该位置用 <code>0</code> 来代替。</p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入:</strong> <code>temperatures</code> = [73,74,75,71,69,72,76,73]
<strong>输出:</strong> [1,1,4,2,1,1,0,0]
</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入:</strong> temperatures = [30,40,50,60]
<strong>输出:</strong> [1,1,1,0]
</pre>

<p><strong>示例 3:</strong></p>

<pre>
<strong>输入:</strong> temperatures = [30,60,90]
<strong>输出: </strong>[1,1,0]</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= temperatures.length <= 10<sup>5</sup></code></li>
	<li><code>30 <= temperatures[i] <= 100</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def dailyTemperatures(self, t: List[int]) -> List[int]:
        n = len(t)
        ans = [0] * n
        q = deque()
        for i in range(n):
            while q and t[q[-1]] < t[i]:
                idx = q.pop()
                ans[idx] = i - idx
            q.append(i)
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int[] dailyTemperatures(int[] t) {
        int n = t.length;
        int[] ans = new int[n];
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!q.isEmpty() && t[q.peekLast()] < t[i]) {
                int idx = q.pollLast();
                ans[idx] = i - idx;
            }
            q.addLast(i);
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
