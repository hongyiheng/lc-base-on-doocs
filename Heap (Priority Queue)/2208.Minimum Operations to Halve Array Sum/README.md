# [2208. 将数组和减半的最少操作次数](https://leetcode-cn.com/problems/minimum-operations-to-halve-array-sum)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个正整数数组 <code>nums</code> 。每一次操作中，你可以从 <code>nums</code> 中选择 <strong>任意</strong> 一个数并将它减小到 <strong>恰好</strong> 一半。（注意，在后续操作中你可以对减半过的数继续执行操作）</p>

<p>请你返回将 <code>nums</code> 数组和 <strong>至少</strong> 减少一半的 <strong>最少</strong> 操作数。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre><b>输入：</b>nums = [5,19,8,1]
<b>输出：</b>3
<b>解释：</b>初始 nums 的和为 5 + 19 + 8 + 1 = 33 。
以下是将数组和减少至少一半的一种方法：
选择数字 19 并减小为 9.5 。
选择数字 9.5 并减小为 4.75 。
选择数字 8 并减小为 4 。
最终数组为 [5, 4.75, 4, 1] ，和为 5 + 4.75 + 4 + 1 = 14.75 。
nums 的和减小了 33 - 14.75 = 18.25 ，减小的部分超过了初始数组和的一半，18.25 >= 33/2 = 16.5 。
我们需要 3 个操作实现题目要求，所以返回 3 。
可以证明，无法通过少于 3 个操作使数组和减少至少一半。
</pre>

<p><strong>示例 2：</strong></p>

<pre><b>输入：</b>nums = [3,8,20]
<b>输出：</b>3
<strong>解释：</strong>初始 nums 的和为 3 + 8 + 20 = 31 。
以下是将数组和减少至少一半的一种方法：
选择数字 20 并减小为 10 。
选择数字 10 并减小为 5 。
选择数字 3 并减小为 1.5 。
最终数组为 [1.5, 8, 5] ，和为 1.5 + 8 + 5 = 14.5 。
nums 的和减小了 31 - 14.5 = 16.5 ，减小的部分超过了初始数组和的一半， 16.5 >= 31/2 = 16.5 。
我们需要 3 个操作实现题目要求，所以返回 3 。
可以证明，无法通过少于 3 个操作使数组和减少至少一半。
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= nums.length <= 10<sup>5</sup></code></li>
	<li><code>1 <= nums[i] <= 10<sup>7</sup></code></li>
</ul>

## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def halveArray(self, nums: List[int]) -> int:
        s = 0
        q = []
        for v in nums:
            s += v
            heapq.heappush(q, -v)
        t, cur, ans = s / 2, 0, 0
        while cur < t:
            v = -heapq.heappop(q) / 2
            cur += v
            heapq.heappush(q, -v)
            ans += 1
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int halveArray(int[] nums) {
        PriorityQueue<Double> q = new PriorityQueue<>((a, b) -> b.compareTo(a));
        long s = 0;
        for (int v : nums) {
            s += v;
            q.add(v * 1.0);
        }
        double t = s / 2.0, cur = 0;
        int ans = 0;
        while (cur < t) {
            double v = q.poll() / 2;
            cur += v;
            q.add(v);
            ans++;
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
