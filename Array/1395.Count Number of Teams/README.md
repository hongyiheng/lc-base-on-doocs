# [1395. 统计作战单位数](https://leetcode-cn.com/problems/count-number-of-teams)



## 题目描述

<!-- 这里写题目描述 -->

<p> <code>n</code> 名士兵站成一排。每个士兵都有一个 <strong>独一无二</strong> 的评分 <code>rating</code> 。</p>

<p>每 <strong>3</strong> 个士兵可以组成一个作战单位，分组规则如下：</p>

<ul>
	<li>从队伍中选出下标分别为 <code>i</code>、<code>j</code>、<code>k</code> 的 3 名士兵，他们的评分分别为 <code>rating[i]</code>、<code>rating[j]</code>、<code>rating[k]</code></li>
	<li>作战单位需满足： <code>rating[i] < rating[j] < rating[k]</code> 或者 <code>rating[i] > rating[j] > rating[k]</code> ，其中  <code>0 <= i < j < k < n</code></li>
</ul>

<p>请你返回按上述条件可以组建的作战单位数量。每个士兵都可以是多个作战单位的一部分。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>rating = [2,5,3,4,1]
<strong>输出：</strong>3
<strong>解释：</strong>我们可以组建三个作战单位 (2,3,4)、(5,4,1)、(5,3,1) 。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>rating = [2,1,3]
<strong>输出：</strong>0
<strong>解释：</strong>根据题目条件，我们无法组建作战单位。
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>rating = [1,2,3,4]
<strong>输出：</strong>4
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>n == rating.length</code></li>
	<li><code>3 <= n <= 1000</code></li>
	<li><code>1 <= rating[i] <= 10^5</code></li>
	<li><code>rating</code> 中的元素都是唯一的</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def numTeams(self, rating: List[int]) -> int:
        ans = 0
        for i, v in enumerate(rating):
            llt = rlt = lgt = rgt = 0
            for j, x in enumerate(rating):
                if x < v:
                    if j < i:
                        llt += 1
                    else:
                        rlt += 1
                if x > v:
                    if j < i:
                        lgt += 1
                    else:
                        rgt += 1
            ans += (llt * rgt) + (lgt * rlt)
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int numTeams(int[] rating) {
        int ans = 0, n = rating.length;
        for (int i = 0; i < n; i++) {
            int llt = 0, rlt = 0, lgt = 0, rgt = 0;
            for (int j = 0; j < n; j++) {
                if (rating[j] < rating[i]) {
                    if (j < i) {
                        llt++;
                    } else {
                        rlt++;
                    }
                }
                if (rating[j] > rating[i]) {
                    if (j < i) {
                        lgt++;
                    } else {
                        rgt++;
                    }
                }
            }
            ans += (llt * rgt) + (lgt * rlt);
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
