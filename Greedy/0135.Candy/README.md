# [135. 分发糖果](https://leetcode-cn.com/problems/candy)



## 题目描述

<!-- 这里写题目描述 -->

<p>老师想给孩子们分发糖果，有 <em>N</em> 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。</p>

<p>你需要按照以下要求，帮助老师给这些孩子分发糖果：</p>

<ul>
	<li>每个孩子至少分配到 1 个糖果。</li>
	<li>评分更高的孩子必须比他两侧的邻位孩子获得更多的糖果。</li>
</ul>

<p>那么这样下来，老师至少需要准备多少颗糖果呢？</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>[1,0,2]
<strong>输出：</strong>5
<strong>解释：</strong>你可以分别给这三个孩子分发 2、1、2 颗糖果。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>[1,2,2]
<strong>输出：</strong>4
<strong>解释：</strong>你可以分别给这三个孩子分发 1、2、1 颗糖果。
     第三个孩子只得到 1 颗糖果，这已满足上述两个条件。</pre>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def candy(self, ratings: List[int]) -> int:
        ans, n = 0, len(ratings)
        left, right = [1] * n, [1] * n
        for i in range(1, n):
            if ratings[i] > ratings[i - 1]:
                left[i] = left[i - 1] + 1
        for i in range(n - 2, -1, -1):
            if ratings[i] > ratings[i + 1]:
                right[i] = right[i + 1] + 1
        for a, b in zip(left, right):
            ans += max(a, b)
        return ans
        
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int candy(int[] ratings) {
        int ans = 0, n = ratings.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } 
        }
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            }
        }
        for (int i = 0; i < n; i++) {
            ans += Math.max(left[i], right[i]) + 1;
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
