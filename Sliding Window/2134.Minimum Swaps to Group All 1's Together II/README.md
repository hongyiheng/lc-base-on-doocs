# [2134. 最少交换次数来组合所有的 1 II](https://leetcode-cn.com/problems/minimum-swaps-to-group-all-1s-together-ii)

## 题目描述

<!-- 这里写题目描述 -->

<p><strong>交换</strong> 定义为选中一个数组中的两个 <strong>互不相同</strong> 的位置并交换二者的值。</p>

<p><strong>环形</strong> 数组是一个数组，可以认为 <strong>第一个</strong> 元素和 <strong>最后一个</strong> 元素 <strong>相邻</strong> 。</p>

<p>给你一个 <strong>二进制环形</strong> 数组 <code>nums</code> ，返回在 <strong>任意位置</strong> 将数组中的所有 <code>1</code> 聚集在一起需要的最少交换次数。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>nums = [0,1,0,1,1,0,0]
<strong>输出：</strong>1
<strong>解释：</strong>这里列出一些能够将所有 1 聚集在一起的方案：
[0,<strong><em>0</em></strong>,<em><strong>1</strong></em>,1,1,0,0] 交换 1 次。
[0,1,<em><strong>1</strong></em>,1,<em><strong>0</strong></em>,0,0] 交换 1 次。
[1,1,0,0,0,0,1] 交换 2 次（利用数组的环形特性）。
无法在交换 0 次的情况下将数组中的所有 1 聚集在一起。
因此，需要的最少交换次数为 1 。
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>nums = [0,1,1,1,0,0,1,1,0]
<strong>输出：</strong>2
<strong>解释：</strong>这里列出一些能够将所有 1 聚集在一起的方案：
[1,1,1,0,0,0,0,1,1] 交换 2 次（利用数组的环形特性）。
[1,1,1,1,1,0,0,0,0] 交换 2 次。
无法在交换 0 次或 1 次的情况下将数组中的所有 1 聚集在一起。
因此，需要的最少交换次数为 2 。
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>nums = [1,1,0,0,1]
<strong>输出：</strong>0
<strong>解释：</strong>得益于数组的环形特性，所有的 1 已经聚集在一起。
因此，需要的最少交换次数为 0 。</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>nums[i]</code> 为 <code>0</code> 或者 <code>1</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def minSwaps(self, nums: List[int]) -> int:
        win, n = nums.count(1), len(nums)
        if win == 0 or win == n:
            return 0
        s = [0] * (n + win)
        for i in range(win):
            s[0] += nums[i]
        for i in range(1, n):
            right = (i + win - 1) % n
            s[i] = s[i - 1] + nums[right] - nums[i - 1]
        ans = n
        for v in s:
            ans = min(ans, win - v)
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int minSwaps(int[] nums) {
        int win = 0, n = nums.length;
        for (int num : nums) {
            win += num;
        }
        if (win == 0 || win == n) {
            return 0;
        }
        int[] count = new int[n + win];
        for (int i= 0; i < win; i++) {
            count[0] += nums[i];
        }
        for (int i = 1; i < n; i++) {
            int right = (i + win - 1) % n;
            count[i] = count[i - 1] + nums[right] - nums[i - 1];
        }
        int ans = n;
        for (int num : count) {
            ans = Math.min(ans, win - num);
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
