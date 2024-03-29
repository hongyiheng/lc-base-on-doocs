# [274. H 指数](https://leetcode-cn.com/problems/h-index)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个整数数组 <code>citations</code> ，其中 <code>citations[i]</code> 表示研究者的第 <code>i</code> 篇论文被引用的次数。计算并返回该研究者的 <strong><code>h</code><em> </em>指数</strong>。</p>

<p><a href="https://baike.baidu.com/item/h-index/3991452?fr=aladdin" target="_blank">h 指数的定义</a>：h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （<code>n</code> 篇论文中）<strong>总共</strong>有 <code>h</code> 篇论文分别被引用了<strong>至少</strong> <code>h</code> 次。且其余的 <em><code>n - h</code> </em>篇论文每篇被引用次数 <strong>不超过 </strong><em><code>h</code> </em>次。</p>

<p>例如：某人的 h 指数是 20，这表示他已发表的论文中，每篇被引用了至少 20 次的论文总共有 20 篇。</p>

<p><strong>提示：</strong>如果 <code>h</code><em> </em>有多种可能的值，<strong><code>h</code> 指数 </strong>是其中最大的那个。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong><code>citations = [3,0,6,1,5]</code>
<strong>输出：</strong>3 
<strong>解释：</strong>给定数组表示研究者总共有 <code>5</code> 篇论文，每篇论文相应的被引用了 <code>3, 0, 6, 1, 5</code> 次。
     由于研究者有 <code>3 </code>篇论文每篇 <strong>至少 </strong>被引用了 <code>3</code> 次，其余两篇论文每篇被引用 <strong>不多于</strong> <code>3</code> 次，所以她的 <em>h </em>指数是 <code>3</code>。</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>citations = [1,3,1]
<strong>输出：</strong>1
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>n == citations.length</code></li>
	<li><code>1 <= n <= 5000</code></li>
	<li><code>0 <= citations[i] <= 1000</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        def check(x):
            cnt = 0
            for v in citations:
                if v >= x:
                    cnt += 1
            return cnt >= x

        left, right = 0, 1000
        while left < right:
            mid = (left + right + 1) >> 1
            if check(mid):
                left = mid
            else:
                right = mid - 1
        return left
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int hIndex(int[] citations) {
        int left = 0, right = citations.length;
        while (left < right) {
            int mid = (left + right + 1) >> 1;
            if (check(citations, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public boolean check(int[] nums, int x) {
        int cnt = 0;
        for (int v : nums) {
            if (v >= x) {
                cnt++;
            }
        }
        return cnt >= x;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
