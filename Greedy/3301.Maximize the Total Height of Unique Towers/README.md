# [3301. 高度互不相同的最大塔高和](https://leetcode.cn/problems/maximize-the-total-height-of-unique-towers)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个数组&nbsp;<code>maximumHeight</code>&nbsp;，其中&nbsp;<code>maximumHeight[i]</code>&nbsp;表示第 <code>i</code>&nbsp;座塔可以达到的 <strong>最大</strong>&nbsp;高度。</p>

<p>你的任务是给每一座塔分别设置一个高度，使得：</p>

<ol>
	<li>第 <code>i</code>&nbsp;座塔的高度是一个正整数，且不超过&nbsp;<code>maximumHeight[i]</code>&nbsp;。</li>
	<li>所有塔的高度互不相同。</li>
</ol>

<p>请你返回设置完所有塔的高度后，可以达到的 <strong>最大</strong>&nbsp;总高度。如果没有合法的设置，返回 <code>-1</code>&nbsp;。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<div class="example-block">
<p><b>输入：</b>maximumHeight<span class="example-io"> = [2,3,4,3]</span></p>

<p><span class="example-io"><b>输出：</b>10</span></p>

<p><strong>解释：</strong></p>

<p>我们可以将塔的高度设置为：<code>[1, 2, 4, 3]</code>&nbsp;。</p>
</div>

<p><strong class="example">示例 2：</strong></p>

<div class="example-block">
<p><b>输入：</b>maximumHeight<span class="example-io"> = [15,10]</span></p>

<p><span class="example-io"><b>输出：</b>25</span></p>

<p><strong>解释：</strong></p>

<p>我们可以将塔的高度设置为：<code>[15, 10]</code>&nbsp;。</p>
</div>

<p><strong class="example">示例 3：</strong></p>

<div class="example-block">
<p><b>输入：</b>maximumHeight<span class="example-io"> = [2,2,1]</span></p>

<p><span class="example-io"><b>输出：</b>-1</span></p>

<p><b>解释：</b></p>

<p>无法设置塔的高度为正整数且高度互不相同。</p>
</div>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= maximumHeight.length&nbsp;&lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= maximumHeight[i] &lt;= 10<sup>9</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def maximumTotalSum(self, maximumHeight: List[int]) -> int:
        maximumHeight.sort(reverse=True)
        ans = 0
        for i in range(1, len(maximumHeight)):
            maximumHeight[i] = min(maximumHeight[i], maximumHeight[i - 1] - 1)
            if maximumHeight[i] <= 0:
                return -1
        return sum(maximumHeight)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public long maximumTotalSum(int[] maximumHeight) {
        Arrays.sort(maximumHeight);
        int n = maximumHeight.length;
        long ans = maximumHeight[n - 1];
        for (int i = n - 2; i > -1; i--) {
            maximumHeight[i] = Math.min(maximumHeight[i], maximumHeight[i + 1] - 1);
            if (maximumHeight[i] <= 0) {
                return -1L;
            }
            ans += maximumHeight[i];
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
