# [2335. 装满杯子需要的最短总时长](https://leetcode-cn.com/problems/minimum-amount-of-time-to-fill-cups)



## 题目描述

<!-- 这里写题目描述 -->

<p>现有一台饮水机，可以制备冷水、温水和热水。每秒钟，可以装满 <code>2</code> 杯 <strong>不同</strong> 类型的水或者 <code>1</code> 杯任意类型的水。</p>

<p>给你一个下标从 <strong>0</strong> 开始、长度为 <code>3</code> 的整数数组 <code>amount</code> ，其中 <code>amount[0]</code>、<code>amount[1]</code> 和 <code>amount[2]</code> 分别表示需要装满冷水、温水和热水的杯子数量。返回装满所有杯子所需的 <strong>最少</strong> 秒数。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>amount = [1,4,2]
<strong>输出：</strong>4
<strong>解释：</strong>下面给出一种方案：
第 1 秒：装满一杯冷水和一杯温水。
第 2 秒：装满一杯温水和一杯热水。
第 3 秒：装满一杯温水和一杯热水。
第 4 秒：装满一杯温水。
可以证明最少需要 4 秒才能装满所有杯子。
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>amount = [5,4,4]
<strong>输出：</strong>7
<strong>解释：</strong>下面给出一种方案：
第 1 秒：装满一杯冷水和一杯热水。
第 2 秒：装满一杯冷水和一杯温水。
第 3 秒：装满一杯冷水和一杯温水。
第 4 秒：装满一杯温水和一杯热水。
第 5 秒：装满一杯冷水和一杯热水。
第 6 秒：装满一杯冷水和一杯温水。
第 7 秒：装满一杯热水。
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>amount = [5,0,0]
<strong>输出：</strong>5
<strong>解释：</strong>每秒装满一杯冷水。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>amount.length == 3</code></li>
	<li><code>0 &lt;= amount[i] &lt;= 100</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def fillCups(self, amount: List[int]) -> int:
        ans = 0
        while amount[0] and amount[1] and amount[2]:
            amount.sort()
            amount[2] -= 1
            amount[0] -= 1
            ans += 1
        return ans + max(amount)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int fillCups(int[] amount) {
        int ans = 0;
        while (amount[0] > 0 && amount[1] > 0 && amount[2] > 0) {
            Arrays.sort(amount);
            amount[2]--;
            amount[0]--;
            ans++;
        }
        Arrays.sort(amount);
        return ans + Math.max(amount[1], amount[2]);
    }
}
```

### **...**

```

```

<!-- tabs:end -->
