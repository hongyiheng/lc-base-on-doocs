# [757. 设置交集大小至少为2](https://leetcode-cn.com/problems/set-intersection-size-at-least-two)



## 题目描述

<!-- 这里写题目描述 -->

<p>一个整数区间&nbsp;<code>[a, b]</code>&nbsp;&nbsp;(&nbsp;<code>a &lt; b</code>&nbsp;) 代表着从&nbsp;<code>a</code>&nbsp;到&nbsp;<code>b</code>&nbsp;的所有连续整数，包括&nbsp;<code>a</code>&nbsp;和&nbsp;<code>b</code>。</p>

<p>给你一组整数区间<code>intervals</code>，请找到一个最小的集合 S，使得 S 里的元素与区间<code>intervals</code>中的每一个整数区间都至少有2个元素相交。</p>

<p>输出这个最小集合S的大小。</p>

<p><strong>示例 1:</strong></p>

<pre><strong>输入:</strong> intervals = [[1, 3], [1, 4], [2, 5], [3, 5]]
<strong>输出:</strong> 3
<strong>解释:</strong>
考虑集合 S = {2, 3, 4}. S与intervals中的四个区间都有至少2个相交的元素。
且这是S最小的情况，故我们输出3。
</pre>

<p><strong>示例 2:</strong></p>

<pre><strong>输入:</strong> intervals = [[1, 2], [2, 3], [2, 4], [4, 5]]
<strong>输出:</strong> 5
<strong>解释:</strong>
最小的集合S = {1, 2, 3, 4, 5}.
</pre>

<p><strong>注意:</strong></p>

<ol>
	<li><code>intervals</code>&nbsp;的长度范围为<code>[1, 3000]</code>。</li>
	<li><code>intervals[i]</code>&nbsp;长度为&nbsp;<code>2</code>，分别代表左、右边界。</li>
	<li><code>intervals[i][j]</code> 的值是&nbsp;<code>[0, 10^8]</code>范围内的整数。</li>
</ol>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def intersectionSizeTwo(self, intervals: List[List[int]]) -> int:
        def cmp(a, b):
            return a[0] - b[0] if a[1] == b[1] else a[1] - b[1]

        intervals.sort(key=cmp_to_key(cmp))
        ans = []
        use = set()
        for l, r in intervals:
            need = 2
            if len(ans) >= 1 and ans[-1] >= l:
                need -= 1
            if len(ans) >= 2 and ans[-2] >= l:
                need -= 1
            if need == 2:
                ans.append(r - 1)
                ans.append(r)
                use.add(r)
            if need == 1:
                if r not in use:
                    ans.append(r)
                else:
                    ans.append(r - 1)
                use.add(r)
        return len(ans)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        List<Integer> ans = new ArrayList<>();
        Set<Integer> use = new HashSet<>();
        for (int[] interval : intervals) {
            int l = interval[0], r = interval[1];
            int need = 2;
            if (ans.size() >= 1 && ans.get(ans.size() - 1) >= l) {
                need--;
            }
            if (ans.size() >= 2 && ans.get(ans.size() - 2) >= l) {
                need--;
            }
            if (need == 2) {
                ans.add(r - 1);
                ans.add(r);
                use.add(r);
            } else if (need == 1) {
                if (!use.contains(r)) {
                    ans.add(r); 
                } else {
                    ans.add(r - 1);
                }
                use.add(r);
            }
        }
        return ans.size();
    }
}
```

### **...**

```

```

<!-- tabs:end -->
