# [3488. 距离最小相等元素查询](https://leetcode.cn/problems/closest-equal-element-queries)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个&nbsp;<strong>循环&nbsp;</strong>数组&nbsp;<code>nums</code>&nbsp;和一个数组&nbsp;<code>queries</code>&nbsp;。</p>

<p>对于每个查询&nbsp;<code>i</code>&nbsp;，你需要找到以下内容：</p>

<ul>
	<li>数组&nbsp;<code>nums</code>&nbsp;中下标&nbsp;<code>queries[i]</code>&nbsp;处的元素与&nbsp;<strong>任意&nbsp;</strong>其他下标&nbsp;<code>j</code>（满足&nbsp;<code>nums[j] == nums[queries[i]]</code>）之间的&nbsp;<strong>最小&nbsp;</strong>距离。如果不存在这样的下标&nbsp;<code>j</code>，则该查询的结果为 <code>-1</code> 。</li>
</ul>

<p>返回一个数组&nbsp;<code>answer</code>，其大小与&nbsp;<code>queries</code>&nbsp;相同，其中&nbsp;<code>answer[i]</code>&nbsp;表示查询<code>i</code>的结果。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<div class="example-block">
<p><strong>输入：</strong> <span class="example-io">nums = [1,3,1,4,1,3,2], queries = [0,3,5]</span></p>

<p><strong>输出：</strong> <span class="example-io">[2,-1,3]</span></p>

<p><strong>解释：</strong></p>

<ul>
	<li>查询 0：下标&nbsp;<code>queries[0] = 0</code>&nbsp;处的元素为&nbsp;<code>nums[0] = 1</code>&nbsp;。最近的相同值下标为 2，距离为 2。</li>
	<li>查询 1：下标&nbsp;<code>queries[1] = 3</code>&nbsp;处的元素为&nbsp;<code>nums[3] = 4</code>&nbsp;。不存在其他包含值 4 的下标，因此结果为 -1。</li>
	<li>查询 2：下标&nbsp;<code>queries[2] = 5</code>&nbsp;处的元素为&nbsp;<code>nums[5] = 3</code>&nbsp;。最近的相同值下标为 1，距离为 3（沿着循环路径：<code>5 -&gt; 6 -&gt; 0 -&gt; 1</code>）。</li>
</ul>
</div>

<p><strong class="example">示例 2：</strong></p>

<div class="example-block">
<p><strong>输入：</strong> <span class="example-io">nums = [1,2,3,4], queries = [0,1,2,3]</span></p>

<p><strong>输出：</strong> <span class="example-io">[-1,-1,-1,-1]</span></p>

<p><strong>解释：</strong></p>

<p>数组&nbsp;<code>nums</code>&nbsp;中的每个值都是唯一的，因此没有下标与查询的元素值相同。所有查询的结果均为 -1。</p>
</div>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= queries.length &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>6</sup></code></li>
	<li><code>0 &lt;= queries[i] &lt; nums.length</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def solveQueries(self, nums: List[int], queries: List[int]) -> List[int]:
        n = len(nums)
        ans = [-1] * n
        last, first = dict(), dict()
        for i, v in enumerate(nums):
            if v in last:
                last_pos = last[v]
                d = min(i - last_pos, n - i + first[v])
                ans[i] = d
                if ans[last_pos] == -1:
                    ans[last_pos] = d
                else:
                    ans[last_pos] = min(ans[last_pos], i - last_pos, n - i + last_pos)
                ans[first[v]] = min(ans[first[v]], n - i + first[v])
            last[v] = i
            first.setdefault(v, i)
        return [ans[v] for v in queries]
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Map<Integer, Integer> last = new HashMap<>();
        Map<Integer, Integer> first = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int v = nums[i];
            if (last.containsKey(v)) {
                int lastPos = last.get(v);
                int d = Math.min(i - lastPos, n - i + first.get(v));
                ans[i] = d;
                if (ans[lastPos] == -1) {
                    ans[lastPos] = d;
                } else {
                    ans[lastPos] = Math.min(ans[lastPos], Math.min(i - lastPos, n - i + lastPos));
                }
                ans[first.get(v)] = Math.min(ans[first.get(v)], n - i + first.get(v));
            }
            last.put(v, i);
            first.putIfAbsent(v, i);
        }
        List<Integer> res = new ArrayList<>();
        for (int q : queries) {
            res.add(ans[q]);
        }
        return res;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
