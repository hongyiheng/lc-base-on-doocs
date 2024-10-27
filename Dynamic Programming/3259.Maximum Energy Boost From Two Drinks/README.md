# [3259. 超级饮料的最大强化能量](https://leetcode.cn/problems/maximum-energy-boost-from-two-drinks)

## 题目描述

<!-- 这里写题目描述 -->

<p>来自未来的体育科学家给你两个整数数组 <code>energyDrinkA</code> 和 <code>energyDrinkB</code>，数组长度都等于 <code>n</code>。这两个数组分别代表 A、B 两种不同能量饮料每小时所能提供的强化能量。</p>

<p>你需要每小时饮用一种能量饮料来 <strong>最大化 </strong>你的总强化能量。然而，如果从一种能量饮料切换到另一种，你需要等待一小时来梳理身体的能量体系（在那个小时里你将不会获得任何强化能量）。</p>

<p>返回在接下来的 <code>n</code> 小时内你能获得的<strong> 最大 </strong>总强化能量。</p>

<p><strong>注意 </strong>你可以选择从饮用任意一种能量饮料开始。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<div class="example-block">
<p><strong>输入：</strong>energyDrinkA<span class="example-io"> = [1,3,1], </span>energyDrinkB<span class="example-io"> = [3,1,1]</span></p>

<p><strong>输出：</strong><span class="example-io">5</span></p>

<p><strong>解释：</strong></p>

<p>要想获得 5 点强化能量，需要选择只饮用能量饮料 A（或者只饮用 B）。</p>
</div>

<p><strong class="example">示例 2：</strong></p>

<div class="example-block">
<p><strong>输入：</strong>energyDrinkA<span class="example-io"> = [4,1,1], </span>energyDrinkB<span class="example-io"> = [1,1,3]</span></p>

<p><strong>输出：</strong><span class="example-io">7</span></p>

<p><strong>解释：</strong></p>

<ul>
	<li>第一个小时饮用能量饮料 A。</li>
	<li>切换到能量饮料 B ，在第二个小时无法获得强化能量。</li>
	<li>第三个小时饮用能量饮料 B ，并获得强化能量。</li>
</ul>
</div>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>n == energyDrinkA.length == energyDrinkB.length</code></li>
	<li><code>3 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= energyDrinkA[i], energyDrinkB[i] &lt;= 10<sup>5</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def maxEnergyBoost(self, energyDrinkA: List[int], energyDrinkB: List[int]) -> int:
        n = len(energyDrinkA)
        f = [[0] * 2 for _ in range(n + 1)]
        for i in range(1, n + 1):
            a, b = energyDrinkA[i - 1], energyDrinkB[i - 1]
            f[i][0] = f[i - 1][0] + a
            f[i][1] = f[i - 1][1] + b
            if i >= 2:
                f[i][0] = max(f[i][0], f[i - 2][1] + a)
                f[i][1] = max(f[i][1], f[i - 2][0] + b)
        return max(f[-1])
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
        int n = energyDrinkA.length;
        long[][] f = new long[n + 1][2];
        for (int i = 1; i <= n; i++) {
            int a = energyDrinkA[i - 1];
            int b = energyDrinkB[i - 1];
            f[i][0] = f[i - 1][0] + a;
            f[i][1] = f[i - 1][1] + b;
            if (i >= 2) {
                f[i][0] = Math.max(f[i][0], f[i - 2][1] + a);
                f[i][1] = Math.max(f[i][1], f[i - 2][0] + b);
            }
        }
        return Math.max(f[n][0], f[n][1]);
    }
}
```

### **...**

```

```

<!-- tabs:end -->
