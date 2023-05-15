# [632. 最小区间](https://leetcode-cn.com/problems/smallest-range-covering-elements-from-k-lists)



## 题目描述

<!-- 这里写题目描述 -->

<p>你有 <code>k</code> 个 <strong>非递减排列</strong> 的整数列表。找到一个 <strong>最小 </strong>区间，使得 <code>k</code> 个列表中的每个列表至少有一个数包含在其中。</p>

<p>我们定义如果 <code>b-a < d-c</code> 或者在 <code>b-a == d-c</code> 时 <code>a < c</code>，则区间 <code>[a,b]</code> 比 <code>[c,d]</code> 小。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
<strong>输出：</strong>[20,24]
<strong>解释：</strong> 
列表 1：[4, 10, 15, 24, 26]，24 在区间 [20,24] 中。
列表 2：[0, 9, 12, 20]，20 在区间 [20,24] 中。
列表 3：[5, 18, 22, 30]，22 在区间 [20,24] 中。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [[1,2,3],[1,2,3],[1,2,3]]
<strong>输出：</strong>[1,1]
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>nums = [[10,10],[11,11]]
<strong>输出：</strong>[10,11]
</pre>

<p><strong>示例 4：</strong></p>

<pre>
<strong>输入：</strong>nums = [[10],[11]]
<strong>输出：</strong>[10,11]
</pre>

<p><strong>示例 5：</strong></p>

<pre>
<strong>输入：</strong>nums = [[1],[2],[3],[4],[5],[6],[7]]
<strong>输出：</strong>[1,7]
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>nums.length == k</code></li>
	<li><code>1 <= k <= 3500</code></li>
	<li><code>1 <= nums[i].length <= 50</code></li>
	<li><code>-10<sup>5</sup> <= nums[i][j] <= 10<sup>5</sup></code></li>
	<li><code>nums[i]</code> 按非递减顺序排列</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def smallestRange(self, nums: List[List[int]]) -> List[int]:
        q = []
        for i, row in enumerate(nums):
            for v in row:
                q.append((v, i))
        q.sort()
        cnt = dict()
        l = r = 0
        ans = [q[0][0], q[-1][0]]
        while r < len(q):
            cnt[q[r][1]] = cnt.get(q[r][1], 0) + 1
            while len(cnt) == len(nums):
                if ans[1] - ans[0] > q[r][0] - q[l][0]:
                    ans = [q[l][0], q[r][0]] 
                cnt[q[l][1]] -= 1
                if cnt[q[l][1]] == 0:
                    cnt.pop(q[l][1])
                l += 1
            r += 1
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int n = nums.size();
        List<int[]> q = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int v : nums.get(i)) {
                q.add(new int[]{v, i});
            }
        }
        Collections.sort(q, Comparator.comparingInt(o -> o[0]));
        Map<Integer, Integer> cnt = new HashMap<>();
        int l = 0, r = 0, ansL = q.get(0)[0], ansR = q.get(q.size() - 1)[0];
        while (r < q.size()) {
            int[] cur = q.get(r);
            cnt.put(cur[1], cnt.getOrDefault(cur[1], 0) + 1);
            while (cnt.size() == n) {
                if (q.get(r)[0] - q.get(l)[0] < ansR - ansL) {
                    ansL = q.get(l)[0];
                    ansR = q.get(r)[0];
                }
                int[] curL = q.get(l++);
                cnt.put(curL[1], cnt.get(curL[1]) - 1);
                if (cnt.get(curL[1]) == 0) {
                    cnt.remove(curL[1]);
                }
            }
            r++;
        }
        return new int[]{ansL, ansR};
    }
}
```

### **...**

```

```

<!-- tabs:end -->
