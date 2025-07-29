# [2411. 按位或最大的最小子数组长度](https://leetcode-cn.com/problems/smallest-subarrays-with-maximum-bitwise-or)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个长度为 <code>n</code>&nbsp;下标从 <strong>0</strong>&nbsp;开始的数组&nbsp;<code>nums</code>&nbsp;，数组中所有数字均为非负整数。对于&nbsp;<code>0</code>&nbsp;到&nbsp;<code>n - 1</code>&nbsp;之间的每一个下标 <code>i</code>&nbsp;，你需要找出&nbsp;<code>nums</code>&nbsp;中一个 <strong>最小</strong> 非空子数组，它的起始位置为&nbsp;<code>i</code>&nbsp;（包含这个位置），同时有&nbsp;<strong>最大</strong>&nbsp;的 <strong>按位或</strong><b>运算值</b>&nbsp;。</p>

<ul>
	<li>换言之，令&nbsp;<code>B<sub>ij</sub></code>&nbsp;表示子数组&nbsp;<code>nums[i...j]</code>&nbsp;的按位或运算的结果，你需要找到一个起始位置为&nbsp;<code>i</code>&nbsp;的最小子数组，这个子数组的按位或运算的结果等于&nbsp;<code>max(B<sub>ik</sub>)</code>&nbsp;，其中&nbsp;<code>i &lt;= k &lt;= n - 1</code>&nbsp;。</li>
</ul>

<p>一个数组的按位或运算值是这个数组里所有数字按位或运算的结果。</p>

<p>请你返回一个大小为 <code>n</code>&nbsp;的整数数组<em>&nbsp;</em><code>answer</code>，其中<em>&nbsp;</em><code>answer[i]</code>是开始位置为&nbsp;<code>i</code>&nbsp;，按位或运算结果最大，且&nbsp;<strong>最短</strong>&nbsp;子数组的长度。</p>

<p><strong>子数组</strong>&nbsp;是数组里一段连续非空元素组成的序列。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><b>输入：</b>nums = [1,0,2,1,3]
<b>输出：</b>[3,3,2,2,1]
<strong>解释：</strong>
任何位置开始，最大按位或运算的结果都是 3 。
- 下标 0 处，能得到结果 3 的最短子数组是 [1,0,2] 。
- 下标 1 处，能得到结果 3 的最短子数组是 [0,2,1] 。
- 下标 2 处，能得到结果 3 的最短子数组是 [2,1] 。
- 下标 3 处，能得到结果 3 的最短子数组是 [1,3] 。
- 下标 4 处，能得到结果 3 的最短子数组是 [3] 。
所以我们返回 [3,3,2,2,1] 。
</pre>

<p><strong>示例 2：</strong></p>

<pre><b>输入：</b>nums = [1,2]
<b>输出：</b>[2,1]
<strong>解释：
</strong>下标 0 处，能得到最大按位或运算值的最短子数组长度为 2 。
下标 1 处，能得到最大按位或运算值的最短子数组长度为 1 。
所以我们返回 [2,1] 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>n == nums.length</code></li>
	<li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def smallestSubarrays(self, nums: List[int]) -> List[int]:
        cnt = [[] for _ in range(32)]
        for i, v in enumerate(nums):
            for j in range(32):
                if v >> j & 1:
                    cnt[j].append(i)
        ans = []
        n = len(nums)
        for i in range(n):
            t = 1
            for j in range(32):
                if not cnt[j]:
                    continue
                l, r = 0, len(cnt[j]) - 1
                while l < r:
                    mid = (l + r) >> 1
                    if cnt[j][mid] < i:
                        l = mid + 1
                    else:
                        r = mid
                if cnt[j][r] >= i:
                    t = max(t, cnt[j][r] - i + 1)
            ans.append(t)
        return ans

```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        List<Integer>[] cnt = new List[32];
        for (int i = 0; i < 32; i++) {
            cnt[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            int v = nums[i];
            for (int j = 0; j < 32; j++) {
                if (((v >> j) & 1) == 1) {
                    cnt[j].add(i);
                }
            }
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int t = 1;
            for (int j = 0; j < 32; j++) {
                if (cnt[j].isEmpty()) {
                    continue;
                }
                int l = 0, r = cnt[j].size() - 1;
                while (l < r) {
                    int mid = (l + r) >> 1;
                    if (cnt[j].get(mid) < i) {
                        l = mid + 1;
                    } else {
                        r = mid;
                    }
                }
                if (cnt[j].get(r) >= i) {
                    t = Math.max(t, cnt[j].get(r) - i + 1);
                }
            }
            ans[i] = t;
        }
        return ans;
    }
}

```

### **...**

```

```

<!-- tabs:end -->
