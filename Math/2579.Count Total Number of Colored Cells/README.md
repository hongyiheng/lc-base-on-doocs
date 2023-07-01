# [2579. 统计染色格子数](https://leetcode-cn.com/problems/count-total-number-of-colored-cells)



## 题目描述

<!-- 这里写题目描述 -->

<p>有一个无穷大的二维网格图，一开始所有格子都未染色。给你一个正整数&nbsp;<code>n</code>&nbsp;，表示你需要执行以下步骤&nbsp;<code>n</code>&nbsp;分钟：</p>

<ul>
	<li>第一分钟，将 <strong>任一</strong> 格子染成蓝色。</li>
	<li>之后的每一分钟，将与蓝色格子相邻的 <strong>所有</strong> 未染色格子染成蓝色。</li>
</ul>

<p>下图分别是 1、2、3 分钟后的网格图。</p>
<img alt="" src="https://assets.leetcode.com/uploads/2023/01/10/example-copy-2.png" style="width: 500px; height: 279px;">
<p>请你返回 <code>n</code>&nbsp;分钟之后 <strong>被染色的格子&nbsp;</strong>数目。</p>

<p>&nbsp;</p>

<p><b>示例 1：</b></p>

<pre><b>输入：</b>n = 1
<b>输出：</b>1
<b>解释：</b>1 分钟后，只有 1 个蓝色的格子，所以返回 1 。
</pre>

<p><strong>示例 2：</strong></p>

<pre><b>输入：</b>n = 2
<b>输出：</b>5
<b>解释：</b>2 分钟后，有 4 个在边缘的蓝色格子和 1 个在中间的蓝色格子，所以返回 5 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def coloredCells(self, n: int) -> int:
        ans = 2 * n - 1
        cur = 1
        for i in range(n - 1):
            ans += cur * 2
            cur += 2
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public long coloredCells(int n) {
        long ans = 2 * n - 1, cur = 1;
        for (int i = 0; i < n - 1; i++) {
            ans += cur * 2;
            cur += 2;
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
