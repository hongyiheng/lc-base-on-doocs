# [862. 和至少为 K 的最短子数组](https://leetcode-cn.com/problems/shortest-subarray-with-sum-at-least-k)



## 题目描述

<!-- 这里写题目描述 -->

<p>返回 <code>A</code> 的最短的非空连续子数组的<strong>长度</strong>，该子数组的和至少为 <code>K</code> 。</p>

<p>如果没有和至少为&nbsp;<code>K</code>&nbsp;的非空子数组，返回&nbsp;<code>-1</code>&nbsp;。</p>

<p>&nbsp;</p>

<ol>
</ol>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>A = [1], K = 1
<strong>输出：</strong>1
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>A = [1,2], K = 4
<strong>输出：</strong>-1
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>A = [2,-1,2], K = 3
<strong>输出：</strong>3
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ol>
	<li><code>1 &lt;= A.length &lt;= 50000</code></li>
	<li><code>-10 ^ 5&nbsp;&lt;= A[i] &lt;= 10 ^ 5</code></li>
	<li><code>1 &lt;= K &lt;= 10 ^ 9</code></li>
</ol>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def shortestSubarray(self, nums: List[int], k: int) -> int:
        n = len(nums)
        pre = [0] * (n + 1)
        for i in range(n):
            if nums[i] >= k:
                return 1
            pre[i + 1] = pre[i] + nums[i]
        lefts = deque()
        ans = float("inf")
        for r in range(n + 1):
            while lefts and pre[r] <= pre[lefts[-1]]:
                lefts.pop()
            while lefts and pre[r] - pre[lefts[0]] >= k:
                ans = min(ans, r - lefts.popleft())
            lefts.append(r)
        return -1 if ans == float("inf") else ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] pre = new long[n + 1];
        for (int i = 0; i < n; i++) {
            if (nums[i] >= k) {
                return 1;
            }
            pre[i + 1] = pre[i] + nums[i];
        }
        int ans = Integer.MAX_VALUE;
        Deque<Integer> lefts = new ArrayDeque<>();
        for (int r = 0; r < pre.length; r++) {
            while (!lefts.isEmpty() && pre[r] <= pre[lefts.getLast()]) {
                lefts.removeLast();
            }
            while (!lefts.isEmpty() && pre[r] - pre[lefts.peek()] >= k) {
                ans = Math.min(ans, r - lefts.poll());
            }
            lefts.add(r);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
