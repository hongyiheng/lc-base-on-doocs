# [3219. 切蛋糕的最小总开销 II](https://leetcode.cn/problems/minimum-cost-for-cutting-cake-ii)



## 题目描述

<!-- 这里写题目描述 -->

<p>有一个&nbsp;<code>m x n</code>&nbsp;大小的矩形蛋糕，需要切成&nbsp;<code>1 x 1</code>&nbsp;的小块。</p>

<p>给你整数&nbsp;<code>m</code>&nbsp;，<code>n</code>&nbsp;和两个数组：</p>

<ul>
	<li><code>horizontalCut</code> 的大小为&nbsp;<code>m - 1</code>&nbsp;，其中&nbsp;<code>horizontalCut[i]</code>&nbsp;表示沿着水平线 <code>i</code>&nbsp;切蛋糕的开销。</li>
	<li><code>verticalCut</code> 的大小为&nbsp;<code>n - 1</code>&nbsp;，其中&nbsp;<code>verticalCut[j]</code>&nbsp;表示沿着垂直线&nbsp;<code>j</code>&nbsp;切蛋糕的开销。</li>
</ul>

<p>一次操作中，你可以选择任意不是&nbsp;<code>1 x 1</code>&nbsp;大小的矩形蛋糕并执行以下操作之一：</p>

<ol>
	<li>沿着水平线&nbsp;<code>i</code>&nbsp;切开蛋糕，开销为&nbsp;<code>horizontalCut[i]</code>&nbsp;。</li>
	<li>沿着垂直线&nbsp;<code>j</code>&nbsp;切开蛋糕，开销为&nbsp;<code>verticalCut[j]</code>&nbsp;。</li>
</ol>

<p>每次操作后，这块蛋糕都被切成两个独立的小蛋糕。</p>

<p>每次操作的开销都为最开始对应切割线的开销，并且不会改变。</p>

<p>请你返回将蛋糕全部切成&nbsp;<code>1 x 1</code>&nbsp;的蛋糕块的&nbsp;<strong>最小</strong>&nbsp;总开销。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<div class="example-block">
<p><span class="example-io"><b>输入：</b>m = 3, n = 2, horizontalCut = [1,3], verticalCut = [5]</span></p>

<p><span class="example-io"><b>输出：</b>13</span></p>

<p><strong>解释：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2024/06/04/ezgifcom-animated-gif-maker-1.gif" style="width: 280px; height: 320px;" /></p>

<ul>
	<li>沿着垂直线 0 切开蛋糕，开销为 5 。</li>
	<li>沿着水平线 0 切开&nbsp;<code>3 x 1</code>&nbsp;的蛋糕块，开销为 1 。</li>
	<li>沿着水平线 0 切开 <code>3 x 1</code>&nbsp;的蛋糕块，开销为 1 。</li>
	<li>沿着水平线 1 切开 <code>2 x 1</code>&nbsp;的蛋糕块，开销为 3 。</li>
	<li>沿着水平线 1 切开 <code>2 x 1</code>&nbsp;的蛋糕块，开销为 3 。</li>
</ul>

<p>总开销为&nbsp;<code>5 + 1 + 1 + 3 + 3 = 13</code>&nbsp;。</p>
</div>

<p><strong class="example">示例 2：</strong></p>

<div class="example-block">
<p><span class="example-io"><b>输入：</b>m = 2, n = 2, horizontalCut = [7], verticalCut = [4]</span></p>

<p><span class="example-io"><b>输出：</b>15</span></p>

<p><strong>解释：</strong></p>

<ul>
	<li>沿着水平线 0 切开蛋糕，开销为 7 。</li>
	<li>沿着垂直线 0 切开&nbsp;<code>1 x 2</code>&nbsp;的蛋糕块，开销为 4 。</li>
	<li>沿着垂直线 0 切开&nbsp;<code>1 x 2</code>&nbsp;的蛋糕块，开销为 4 。</li>
</ul>

<p>总开销为&nbsp;<code>7 + 4 + 4 = 15</code>&nbsp;。</p>
</div>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= m, n &lt;= 10<sup>5</sup></code></li>
	<li><code>horizontalCut.length == m - 1</code></li>
	<li><code>verticalCut.length == n - 1</code></li>
	<li><code>1 &lt;= horizontalCut[i], verticalCut[i] &lt;= 10<sup>3</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def minimumCost(self, m: int, n: int, horizontalCut: List[int], verticalCut: List[int]) -> int:
        horizontalCut.sort(reverse=True)
        verticalCut.sort(reverse=True)
        i = j = ans = 0
        while i < m - 1 or j < n - 1:
            if i < m - 1 and j < n - 1:
                if horizontalCut[i] < verticalCut[j]:
                    ans += verticalCut[j] * (i + 1)
                    j += 1
                else:
                    ans += horizontalCut[i] * (j + 1)
                    i += 1
            elif i < m - 1:
                ans += horizontalCut[i] * (j + 1)
                i += 1
            else:
                ans += verticalCut[j] * (i + 1)
                j += 1
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public long minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        Arrays.sort(horizontalCut);
        Arrays.sort(verticalCut);
        long ans = 0;
        int i = 0, j = 0;
        while (i < m - 1 || j < n - 1) {
            if (i < m - 1 && j < n - 1) {
                if (horizontalCut[m - i - 2] < verticalCut[n - j - 2]) {
                    ans += (long)verticalCut[n - j - 2] * (i + 1);
                    j++;
                } else {
                    ans += (long)horizontalCut[m - i - 2] * (j + 1);
                    i++;
                }
            } else if (i < m - 1) {
                ans += (long)horizontalCut[m - i - 2] * (j + 1);
                i++;
            } else {
                ans += (long)verticalCut[n - j - 2] * (i + 1);
                j++;
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
