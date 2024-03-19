# [1793. 好子数组的最大分数](https://leetcode-cn.com/problems/maximum-score-of-a-good-subarray)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个整数数组 <code>nums</code> <strong>（下标从 0 开始）</strong>和一个整数 <code>k</code> 。</p>

<p>一个子数组 <code>(i, j)</code> 的 <strong>分数</strong> 定义为 <code>min(nums[i], nums[i+1], ..., nums[j]) * (j - i + 1)</code> 。一个 <strong>好</strong> 子数组的两个端点下标需要满足 <code>i &lt;= k &lt;= j</code> 。</p>

<p>请你返回 <strong>好</strong> 子数组的最大可能 <strong>分数</strong> 。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre><b>输入：</b>nums = [1,4,3,7,4,5], k = 3
<b>输出：</b>15
<b>解释：</b>最优子数组的左右端点下标是 (1, 5) ，分数为 min(4,3,7,4,5) * (5-1+1) = 3 * 5 = 15 。
</pre>

<p><strong>示例 2：</strong></p>

<pre><b>输入：</b>nums = [5,5,4,5,4,1,1,1], k = 0
<b>输出：</b>20
<b>解释：</b>最优子数组的左右端点下标是 (0, 4) ，分数为 min(5,5,4,5,4) * (4-0+1) = 4 * 5 = 20 。
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= 2 * 10<sup>4</sup></code></li>
	<li><code>0 &lt;= k &lt; nums.length</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def maximumScore(self, nums: List[int], k: int) -> int:
        n = len(nums)
        left = [-1] * n
        q = []
        for i, v in enumerate(nums):
            while q and nums[q[-1]] >= v:
                q.pop()
            if q:
                left[i] = q[-1]
            q.append(i)
        right = [n] * n
        q.clear()
        for i in range(n - 1, -1, -1):
            v = nums[i]
            while q and v <= nums[q[-1]]:
                q.pop()
            if q:
                right[i] = q[-1]
            q.append(i)
        ans = 0
        for h, l, r in zip(nums, left, right):
            if l < k < r:
                ans = max(ans, h * (r - l - 1))
        return ans        
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int maximumScore(int[] nums, int k) {
        int n = nums.length;
        int[] left = new int[n];
        Arrays.fill(left, -1);
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int v = nums[i];
            while (!q.isEmpty() && nums[q.peekLast()] >= v) {
                q.pollLast();
            } 
            if (!q.isEmpty()) {
                left[i] = q.peekLast();
            }
            q.addLast(i);
        }
        int[] right = new int[n];
        Arrays.fill(right, n);
        q.clear();
        for (int i = n - 1; i > -1; i--) {
            int v = nums[i];
            while (!q.isEmpty() && nums[q.peekLast()] >= v) {
                q.pollLast();
            }
            if (!q.isEmpty()) {
                right[i] = q.peekLast();
            }
            q.addLast(i);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int h = nums[i], l = left[i], r = right[i];
            if (l < k && k < r) {
                ans = Math.max(ans, h * (r - l - 1));
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
