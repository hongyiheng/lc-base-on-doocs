# [1743. 从相邻元素对还原数组](https://leetcode-cn.com/problems/restore-the-array-from-adjacent-pairs)



## 题目描述

<!-- 这里写题目描述 -->

<p>存在一个由 <code>n</code> 个不同元素组成的整数数组 <code>nums</code> ，但你已经记不清具体内容。好在你还记得 <code>nums</code> 中的每一对相邻元素。</p>

<p>给你一个二维整数数组 <code>adjacentPairs</code> ，大小为 <code>n - 1</code> ，其中每个 <code>adjacentPairs[i] = [u<sub>i</sub>, v<sub>i</sub>]</code> 表示元素 <code>u<sub>i</sub></code> 和 <code>v<sub>i</sub></code> 在 <code>nums</code> 中相邻。</p>

<p>题目数据保证所有由元素 <code>nums[i]</code> 和 <code>nums[i+1]</code> 组成的相邻元素对都存在于 <code>adjacentPairs</code> 中，存在形式可能是 <code>[nums[i], nums[i+1]]</code> ，也可能是 <code>[nums[i+1], nums[i]]</code> 。这些相邻元素对可以 <strong>按任意顺序</strong> 出现。</p>

<p>返回 <strong>原始数组</strong><em> </em><code>nums</code><em> </em>。如果存在多种解答，返回 <strong>其中任意一个</strong> 即可。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>adjacentPairs = [[2,1],[3,4],[3,2]]
<strong>输出：</strong>[1,2,3,4]
<strong>解释：</strong>数组的所有相邻元素对都在 adjacentPairs 中。
特别要注意的是，adjacentPairs[i] 只表示两个元素相邻，并不保证其 左-右 顺序。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>adjacentPairs = [[4,-2],[1,4],[-3,1]]
<strong>输出：</strong>[-2,4,1,-3]
<strong>解释：</strong>数组中可能存在负数。
另一种解答是 [-3,1,4,-2] ，也会被视作正确答案。
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>adjacentPairs = [[100000,-100000]]
<strong>输出：</strong>[100000,-100000]
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>nums.length == n</code></li>
	<li><code>adjacentPairs.length == n - 1</code></li>
	<li><code>adjacentPairs[i].length == 2</code></li>
	<li><code>2 <= n <= 10<sup>5</sup></code></li>
	<li><code>-10<sup>5</sup> <= nums[i], u<sub>i</sub>, v<sub>i</sub> <= 10<sup>5</sup></code></li>
	<li>题目数据保证存在一些以 <code>adjacentPairs</code> 作为元素对的数组 <code>nums</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def restoreArray(self, adjacentPairs: List[List[int]]) -> List[int]:
        cnt = defaultdict(list)
        for a, b in adjacentPairs:
            cnt[a].append(b)
            cnt[b].append(a)
        n = len(cnt)
        ans = [0] * n
        for k in cnt.keys():
            if len(cnt[k]) == 1:
                ans[0] = k
                ans[1] = cnt[k][0]
                break
        for i in range(2, n):
            a, b = cnt.get(ans[i - 1])
            if a == ans[i - 2]:
                ans[i] = b
            else:
                ans[i] = a
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> cnt = new HashMap<>();
        for (int[] v : adjacentPairs) {
            cnt.computeIfAbsent(v[0], k -> new ArrayList<>()).add(v[1]);
            cnt.computeIfAbsent(v[1], k -> new ArrayList<>()).add(v[0]);
        }
        int n = cnt.size();
        int[] ans = new int[n];
        for (var entry : cnt.entrySet()) {
            if (entry.getValue().size() == 1) {
                ans[0] = entry.getKey();
                ans[1] = entry.getValue().get(0);
            }
        }
        for (int i = 2; i < n; i++) {
            List<Integer> v = cnt.get(ans[i - 1]);
            if (v.get(0) == ans[i - 2]) {
                ans[i] = v.get(1);
            } else {
                ans[i] = v.get(0);
            }
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
