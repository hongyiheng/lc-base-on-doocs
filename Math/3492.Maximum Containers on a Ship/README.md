# [3492. 船上可以装载的最大集装箱数量](https://leetcode.cn/problems/maximum-containers-on-a-ship)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个正整数 <code>n</code>，表示船上的一个 <code>n x n</code> 的货物甲板。甲板上的每个单元格可以装载一个重量<strong> 恰好 </strong>为 <code>w</code> 的集装箱。</p>

<p>然而，如果将所有集装箱装载到甲板上，其总重量不能超过船的最大承载重量 <code>maxWeight</code>。</p>

<p>请返回可以装载到船上的 <strong>最大 </strong>集装箱数量。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<div class="example-block">
<p><strong>输入：</strong> <span class="example-io">n = 2, w = 3, maxWeight = 15</span></p>

<p><strong>输出：</strong> 4</p>

<p><strong>解释：</strong></p>

<p>甲板有 4 个单元格，每个集装箱的重量为 3。将所有集装箱装载后，总重量为 12，未超过 <code>maxWeight</code>。</p>
</div>

<p><strong class="example">示例 2：</strong></p>

<div class="example-block">
<p><strong>输入：</strong> <span class="example-io">n = 3, w = 5, maxWeight = 20</span></p>

<p><strong>输出：</strong> <span class="example-io">4</span></p>

<p><strong>解释：</strong></p>

<p>甲板有 9 个单元格，每个集装箱的重量为 5。可以装载的最大集装箱数量为 4，此时总重量不超过 <code>maxWeight</code>。</p>
</div>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 1000</code></li>
	<li><code>1 &lt;= w &lt;= 1000</code></li>
	<li><code>1 &lt;= maxWeight &lt;= 10<sup>9</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def maxContainers(self, n: int, w: int, maxWeight: int) -> int:
        return min(n * n, maxWeight // w)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int maxContainers(int n, int w, int maxWeight) {
        return Math.min(n * n, maxWeight / w);
    }
}
```

### **...**

```

```

<!-- tabs:end -->
