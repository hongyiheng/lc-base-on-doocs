# [1449. 数位成本和为目标值的最大数字](https://leetcode-cn.com/problems/form-largest-integer-with-digits-that-add-up-to-target)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个整数数组 <code>cost</code> 和一个整数 <code>target</code> 。请你返回满足如下规则可以得到的 <strong>最大</strong> 整数：</p>

<ul>
	<li>给当前结果添加一个数位（<code>i + 1</code>）的成本为 <code>cost[i]</code> （<code>cost</code> 数组下标从 0 开始）。</li>
	<li>总成本必须恰好等于 <code>target</code> 。</li>
	<li>添加的数位中没有数字 0 。</li>
</ul>

<p>由于答案可能会很大，请你以字符串形式返回。</p>

<p>如果按照上述要求无法得到任何整数，请你返回 "0" 。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>cost = [4,3,2,5,6,7,2,5,5], target = 9
<strong>输出：</strong>"7772"
<strong>解释：</strong>添加数位 '7' 的成本为 2 ，添加数位 '2' 的成本为 3 。所以 "7772" 的代价为 2*3+ 3*1 = 9 。 "977" 也是满足要求的数字，但 "7772" 是较大的数字。
<strong> 数字     成本</strong>
  1  ->   4
  2  ->   3
  3  ->   2
  4  ->   5
  5  ->   6
  6  ->   7
  7  ->   2
  8  ->   5
  9  ->   5
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>cost = [7,6,5,5,5,6,8,7,8], target = 12
<strong>输出：</strong>"85"
<strong>解释：</strong>添加数位 '8' 的成本是 7 ，添加数位 '5' 的成本是 5 。"85" 的成本为 7 + 5 = 12 。
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>cost = [2,4,6,2,4,6,4,4,4], target = 5
<strong>输出：</strong>"0"
<strong>解释：</strong>总成本是 target 的条件下，无法生成任何整数。
</pre>

<p><strong>示例 4：</strong></p>

<pre>
<strong>输入：</strong>cost = [6,10,15,40,40,40,40,40,40], target = 47
<strong>输出：</strong>"32211"
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>cost.length == 9</code></li>
	<li><code>1 <= cost[i] <= 5000</code></li>
	<li><code>1 <= target <= 5000</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def largestNumber(self, cost: List[int], target: int) -> str:
        f = [0] + [-0x3f3f3f3f] * (target + 1)
        for i in range(target + 1):
            for j in range(9):
                if cost[j] > i:
                    continue
                f[i] = max(f[i], f[i - cost[j]] + 1)
        if f[target] <= 0:
            return "0"
        ans = []
        for i in range(9, 0, -1):
            c = cost[i - 1]
            while target >= c and f[target - c] + 1 == f[target]:
                ans.append(str(i))
                target -= c
        return "".join(ans)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public String largestNumber(int[] cost, int target) {
        int[] f = new int[target + 1];
        Arrays.fill(f, -0x3f3f3f3f);
        f[0] = 0;
        for (int i = 0; i <= target; i++) {
            for (int j = 0; j < 9; j++) {
                int c = cost[j];
                if (c > i) {
                    continue;
                }
                f[i] = Math.max(f[i], f[i - c] + 1);
            }
        }
        if (f[target] <= 0) {
            return "0";
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 9; i > 0; i--) {
            int c = cost[i - 1];
            while (target >= c && f[target - c] + 1 == f[target]) {
                ans.append(i);
                target -= c;
            }
        }
        return ans.toString();
    }
}
```

### **...**

```

```

<!-- tabs:end -->
