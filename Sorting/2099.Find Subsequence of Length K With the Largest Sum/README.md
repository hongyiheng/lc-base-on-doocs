# [2099. 找到和最大的长度为 K 的子序列](https://leetcode-cn.com/problems/find-subsequence-of-length-k-with-the-largest-sum)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个整数数组&nbsp;<code>nums</code>&nbsp;和一个整数&nbsp;<code>k</code>&nbsp;。你需要找到&nbsp;<code>nums</code>&nbsp;中长度为 <code>k</code>&nbsp;的 <strong>子序列</strong>&nbsp;，且这个子序列的&nbsp;<strong>和最大&nbsp;</strong>。</p>

<p>请你返回 <strong>任意</strong> 一个长度为&nbsp;<code>k</code>&nbsp;的整数子序列。</p>

<p><strong>子序列</strong>&nbsp;定义为从一个数组里删除一些元素后，不改变剩下元素的顺序得到的数组。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><b>输入：</b>nums = [2,1,3,3], k = 2
<b>输出：</b>[3,3]
<strong>解释：</strong>
子序列有最大和：3 + 3 = 6 。</pre>

<p><strong>示例 2：</strong></p>

<pre><b>输入：</b>nums = [-1,-2,3,4], k = 3
<b>输出：</b>[-1,3,4]
<b>解释：</b>
子序列有最大和：-1 + 3 + 4 = 6 。
</pre>

<p><strong>示例 3：</strong></p>

<pre><b>输入：</b>nums = [3,4,3,3], k = 2
<b>输出：</b>[3,4]
<strong>解释：</strong>
子序列有最大和：3 + 4 = 7 。
另一个可行的子序列为 [4, 3] 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 1000</code></li>
	<li><code>-10<sup>5</sup>&nbsp;&lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= k &lt;= nums.length</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def maxSubsequence(self, nums: List[int], k: int) -> List[int]:
        q = [(i, v) for i, v in enumerate(nums)]
        q.sort(key=lambda x:-x[1])
        q = q[:k]
        q.sort(key=lambda x:x[0])
        return [v for _, v in q]
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        List<int[]> q = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            q.add(new int[]{i, nums[i]});
        }
        q.sort((a, b) -> b[1] - a[1]);
        q = q.subList(0, k);
        q.sort((a, b) -> a[0] - b[0]);
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = q.get(i)[1];
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
