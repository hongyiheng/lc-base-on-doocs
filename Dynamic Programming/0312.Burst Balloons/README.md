# [312. 戳气球](https://leetcode-cn.com/problems/burst-balloons)



## 题目描述

<!-- 这里写题目描述 -->

<p>有 <code>n</code> 个气球，编号为<code>0</code> 到 <code>n - 1</code>，每个气球上都标有一个数字，这些数字存在数组 <code>nums</code> 中。</p>

<p>现在要求你戳破所有的气球。戳破第 <code>i</code> 个气球，你可以获得 <code>nums[i - 1] * nums[i] * nums[i + 1]</code> 枚硬币。 这里的 <code>i - 1</code> 和 <code>i + 1</code> 代表和 <code>i</code> 相邻的两个气球的序号。如果 <code>i - 1</code>或 <code>i + 1</code> 超出了数组的边界，那么就当它是一个数字为 <code>1</code> 的气球。</p>

<p>求所能获得硬币的最大数量。</p>

<p> </p>
<strong>示例 1：</strong>

<pre>
<strong>输入：</strong>nums = [3,1,5,8]
<strong>输出：</strong>167
<strong>解释：</strong>
nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,5]
<strong>输出：</strong>10
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>n == nums.length</code></li>
	<li><code>1 <= n <= 500</code></li>
	<li><code>0 <= nums[i] <= 100</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def maxCoins(self, nums: List[int]) -> int:
        n = len(nums)
        nums = [1] + nums + [1]
        f = [[0] * (n + 2) for _ in range(n + 2)]
        for m in range(3, n + 3):
            for i in range(n + 2):
                j = i + m - 1
                if j > n + 1:
                    break
                for k in range(i + 1, j):
                    f[i][j] = max(f[i][j], f[i][k] + f[k][j] + nums[i] * nums[k] * nums[j])
        return f[0][n + 1]
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 2];
        arr[0] = arr[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }
        int[][] f = new int[n + 2][n + 2];
        for (int m = 3; m <= n + 2; m++) {
            for (int i = 0; i < n + 2; i++) {
                int j = i + m - 1;
                if (j > n + 1) {
                    break;
                }
                for (int k = i + 1; k < j; k++) {
                    f[i][j] = Math.max(f[i][j], f[i][k] + f[k][j] + arr[i] * arr[k] * arr[j]);
                }

            }
        }
        return f[0][n + 1];
    }
}
```

### **...**

```

```

<!-- tabs:end -->
