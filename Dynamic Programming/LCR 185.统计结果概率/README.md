# [LCR 185. 统计结果概率](https://leetcode.cn/problems/nge-tou-zi-de-dian-shu-lcof)



## 题目描述

<!-- 这里写题目描述 -->

<p>你选择掷出 <code>num</code> 个色子，请返回所有点数总和的概率。</p>

<p>你需要用一个浮点数数组返回答案，其中第 <code>i</code> 个元素代表这 <code>num</code> 个骰子所能掷出的点数集合中第 <code>i</code> 小的那个的概率。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>num = 3
<strong>输出：</strong>[0.00463,0.01389,0.02778,0.04630,0.06944,0.09722,0.11574,0.12500,0.12500,0.11574,0.09722,0.06944,0.04630,0.02778,0.01389,0.00463]
</pre>

<p><strong>示例&nbsp;2：</strong></p>

<pre>
<strong>输入：</strong>num = 5
<strong>输出:</strong>[0.00013,0.00064,0.00193,0.00450,0.00900,0.01620,0.02636,0.03922,0.05401,0.06944,0.08372,0.09452,0.10031,0.10031,0.09452,0.08372,0.06944,0.05401,0.03922,0.02636,0.01620,0.00900,0.00450,0.00193,0.00064,0.00013]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= num &lt;= 11</code></li>
</ul>

<p>&nbsp;</p>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python

```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }
        int[] f = new int[n];
        Arrays.fill(f, 0x3f3f3f3f);
        f[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < Math.min(i + nums[i] + 1, n); j++) {
                f[j] = Math.min(f[j], f[i] + 1);
            }
        }
        return f[n - 1];
    }
}
```

### **...**

```

```

<!-- tabs:end -->
