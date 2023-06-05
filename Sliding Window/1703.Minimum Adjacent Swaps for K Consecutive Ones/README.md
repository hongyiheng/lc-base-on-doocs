# [1703. 得到连续 K 个 1 的最少相邻交换次数](https://leetcode-cn.com/problems/minimum-adjacent-swaps-for-k-consecutive-ones)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个整数数组 <code>nums</code> 和一个整数 <code>k</code> 。 <code>nums</code> 仅包含 <code>0</code> 和 <code>1</code> 。每一次移动，你可以选择 <strong>相邻</strong> 两个数字并将它们交换。</p>

<p>请你返回使 <code>nums</code> 中包含 <code>k</code> 个 <strong>连续 </strong><code>1</code> 的 <strong>最少</strong> 交换次数。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre><b>输入：</b>nums = [1,0,0,1,0,1], k = 2
<b>输出：</b>1
<b>解释：</b>在第一次操作时，nums 可以变成 [1,0,0,0,<strong>1</strong>,<strong>1</strong>] 得到连续两个 1 。
</pre>

<p><strong>示例 2：</strong></p>

<pre><b>输入：</b>nums = [1,0,0,0,0,0,1,1], k = 3
<b>输出：</b>5
<b>解释：</b>通过 5 次操作，最左边的 1 可以移到右边直到 nums 变为 [0,0,0,0,0,<strong>1</strong>,<strong>1</strong>,<strong>1</strong>] 。
</pre>

<p><strong>示例 3：</strong></p>

<pre><b>输入：</b>nums = [1,1,0,1], k = 2
<b>输出：</b>0
<b>解释：</b>nums 已经有连续 2 个 1 了。
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>nums[i]</code> 要么是 <code>0</code> ，要么是 <code>1</code> 。</li>
	<li><code>1 &lt;= k &lt;= sum(nums)</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def minMoves(self, nums: List[int], k: int) -> int:
        pos = []
        for i, v in enumerate(nums):
            if v == 1:
                pos.append(i)
        cur = 0
        for i in range(k):
            cur += (pos[i] - pos[i - 1] - 1) * min(i, k - i)
        ans = cur
        mid = k // 2
        for r in range(k, len(pos)):
            cur -= (pos[r - k + mid] - pos[r - k])
            cur += (pos[r] - pos[r - mid])
            ans = min(ans, cur)
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int minMoves(int[] nums, int k) {
        List<Integer> pos = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                pos.add(i);
            }
        }
        int cur = 0;
        for (int i = 1; i < k; i++) {
            cur += (pos.get(i) - pos.get(i - 1) - 1) * Math.min(i, k - i);
        }
        int ans = cur, mid = k / 2;
        for (int r = k; r < pos.size(); r++) {
            cur -= pos.get(r - k + mid) - pos.get(r - k);
            cur += pos.get(r) - pos.get(r - mid);
            ans = Math.min(ans, cur);
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
