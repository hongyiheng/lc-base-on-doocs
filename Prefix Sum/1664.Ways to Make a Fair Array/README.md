# [1664. 生成平衡数组的方案数](https://leetcode-cn.com/problems/ways-to-make-a-fair-array)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个整数数组 <code>nums</code> 。你需要选择 <strong>恰好</strong> 一个下标（下标从 <strong>0</strong> 开始）并删除对应的元素。请注意剩下元素的下标可能会因为删除操作而发生改变。</p>

<p>比方说，如果 <code>nums = [6,1,7,4,1]</code> ，那么：</p>

<ul>
	<li>选择删除下标 <code>1</code> ，剩下的数组为 <code>nums = [6,7,4,1]</code> 。</li>
	<li>选择删除下标 <code>2</code> ，剩下的数组为 <code>nums = [6,1,4,1]</code> 。</li>
	<li>选择删除下标 <code>4</code> ，剩下的数组为 <code>nums = [6,1,7,4]</code> 。</li>
</ul>

<p>如果一个数组满足奇数下标元素的和与偶数下标元素的和相等，该数组就是一个 <strong>平衡数组</strong> 。</p>

<p>请你返回删除操作后，剩下的数组<em> </em><code>nums</code><em> </em>是 <strong>平衡数组</strong> 的 <strong>方案数</strong> 。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<b>输入：</b>nums = [2,1,6,4]
<b>输出：</b>1
<strong>解释：</strong>
删除下标 0 ：[1,6,4] -> 偶数元素下标为：1 + 4 = 5 。奇数元素下标为：6 。不平衡。
删除下标 1 ：[2,6,4] -> 偶数元素下标为：2 + 4 = 6 。奇数元素下标为：6 。平衡。
删除下标 2 ：[2,1,4] -> 偶数元素下标为：2 + 4 = 6 。奇数元素下标为：1 。不平衡。
删除下标 3 ：[2,1,6] -> 偶数元素下标为：2 + 6 = 8 。奇数元素下标为：1 。不平衡。
只有一种让剩余数组成为平衡数组的方案。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<b>输入：</b>nums = [1,1,1]
<b>输出：</b>3
<b>解释：</b>你可以删除任意元素，剩余数组都是平衡数组。
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<b>输入：</b>nums = [1,2,3]
<b>输出：</b>0
<b>解释：</b>不管删除哪个元素，剩下数组都不是平衡数组。
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= nums.length <= 10<sup>5</sup></code></li>
	<li><code>1 <= nums[i] <= 10<sup>4</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def waysToMakeFair(self, nums: List[int]) -> int:
        n = len(nums)
        s = [[0] * 2 for _ in range(n + 1)]
        for i in range(1, n + 1):
            s[i][0] = s[i - 1][0]
            s[i][1] = s[i - 1][1]
            if (i - 1) % 2:
                s[i][1] += nums[i - 1]
            else:
                s[i][0] += nums[i - 1]
        ans = 0
        for i in range(n):
            odd = even = 0
            if i % 2:
                odd = s[n][0] - s[i + 1][0] + s[i + 1][1] - nums[i]
                even = s[n][1] - s[i + 1][1] + s[i + 1][0]
            else:
                even = s[n][1] - s[i + 1][1] + s[i + 1][0] - nums[i]
                odd = s[n][0] - s[i + 1][0] + s[i + 1][1]
            if odd == even:
                ans += 1
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int waysToMakeFair(int[] nums) {
        int n = nums.length;
        int[][] s = new int[n + 1][2];
        for (int i = 1; i < n + 1; i++) {
            s[i][0] = s[i - 1][0];
            s[i][1] = s[i - 1][1];
            if ((i - 1) % 2 == 1) {
                s[i][1] += nums[i - 1];
            } else {
                s[i][0] += nums[i - 1];
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int odd = 0, even = 0;
            if (i % 2 == 1) {
                odd = s[n][0] - s[i + 1][0] + s[i + 1][1] - nums[i];
                even = s[n][1] - s[i + 1][1] + s[i + 1][0];
            } else {
                even = s[n][1] - s[i + 1][1] + s[i + 1][0] - nums[i];
                odd = s[n][0] - s[i + 1][0] + s[i + 1][1];
            }
            if (odd == even) {
                ans++;
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
