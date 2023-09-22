# [2591. 将钱分给最多的儿童](https://leetcode-cn.com/problems/distribute-money-to-maximum-children)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个整数&nbsp;<code>money</code>&nbsp;，表示你总共有的钱数（单位为美元）和另一个整数&nbsp;<code>children</code>&nbsp;，表示你要将钱分配给多少个儿童。</p>

<p>你需要按照如下规则分配：</p>

<ul>
	<li>所有的钱都必须被分配。</li>
	<li>每个儿童至少获得&nbsp;<code>1</code>&nbsp;美元。</li>
	<li>没有人获得 <code>4</code>&nbsp;美元。</li>
</ul>

<p>请你按照上述规则分配金钱，并返回 <strong>最多</strong>&nbsp;有多少个儿童获得 <strong>恰好</strong><em>&nbsp;</em><code>8</code>&nbsp;美元。如果没有任何分配方案，返回&nbsp;<code>-1</code>&nbsp;。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><b>输入：</b>money = 20, children = 3
<b>输出：</b>1
<b>解释：</b>
最多获得 8 美元的儿童数为 1 。一种分配方案为：
- 给第一个儿童分配 8 美元。
- 给第二个儿童分配 9 美元。
- 给第三个儿童分配 3 美元。
没有分配方案能让获得 8 美元的儿童数超过 1 。
</pre>

<p><strong>示例 2：</strong></p>

<pre><b>输入：</b>money = 16, children = 2
<b>输出：</b>2
<b>解释：</b>每个儿童都可以获得 8 美元。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= money &lt;= 200</code></li>
	<li><code>2 &lt;= children &lt;= 30</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def distMoney(self, money: int, children: int) -> int:
        if money < children:
            return -1
        money -= children
        i = 0
        while i < children and money >= 7:
            money -= 7
            i += 1
        if i < children - 1:
            return i
        if i == children - 1:
            return i if money != 3 else i - 1
        return i if money == 0 else i - 1
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int distMoney(int money, int children) {
        if (money < children) {
            return -1;
        }
        money -= children;
        int i = 0;
        while (i < children && money >= 7) {
            money -= 7;
            i++;
        }
        if (i < children - 1) {
            return i;
        }
        if (i == children - 1) {
            return money == 3 ? i - 1 : i;
        }
        return money == 0 ? i : i - 1;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
