# [3020. 子集中元素的最大数量](https://leetcode.cn/problems/find-the-maximum-number-of-elements-in-subset)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个<strong> 正整数 </strong>数组 <code>nums</code> 。</p>

<p>你需要从数组中选出一个满足下述条件的<span data-keyword="subset">子集</span>：</p>

<ul>
	<li>你可以将选中的元素放置在一个下标从 <strong>0</strong> 开始的数组中，并使其遵循以下模式：<code>[x, x<sup>2</sup>, x<sup>4</sup>, ..., x<sup>k/2</sup>, x<sup>k</sup>, x<sup>k/2</sup>, ..., x<sup>4</sup>, x<sup>2</sup>, x]</code>（<strong>注意</strong>，<code>k</code> 可以是任何 <strong>非负</strong> 的 2 的幂）。例如，<code>[2, 4, 16, 4, 2]</code> 和 <code>[3, 9, 3]</code> 都符合这一模式，而 <code>[2, 4, 8, 4, 2]</code> 则不符合。</li>
</ul>

<p>返回满足这些条件的子集中，元素数量的 <strong>最大值 </strong><em>。</em></p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [5,4,1,2,2]
<strong>输出：</strong>3
<strong>解释：</strong>选择子集 {4,2,2} ，将其放在数组 [2,4,2] 中，它遵循该模式，且 2<sup>2</sup> == 4 。因此答案是 3 。
</pre>

<p><strong class="example">示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,3,2,4]
<strong>输出：</strong>1
<strong>解释：</strong>选择子集 {1}，将其放在数组 [1] 中，它遵循该模式。因此答案是 1 。注意我们也可以选择子集 {2} 、{4} 或 {3} ，可能存在多个子集都能得到相同的答案。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>2 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def maximumLength(self, nums: List[int]) -> int:
        cnt = defaultdict(int)
        for v in nums:
            cnt[v] += 1
        nums.sort()
        ans = 1
        vis = set()
        for v in nums:
            if cnt[v] < 2 or v == 1 or v in vis: 
                continue
            x = v
            d = 1
            while cnt[x * x] >= 2:
                vis.add(x)
                d += 1
                x = x * x           
            d = d * 2 + (1 if cnt[x * x] else -1)
            ans = max(ans, d)
        if cnt[1]:
            ans = max(ans, cnt[1] // 2 * 2 + (1 if cnt[1] % 2 else -1))
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int maximumLength(int[] nums) {
        Integer INF = Integer.MAX_VALUE;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int v : nums) {
            cnt.put(v, cnt.getOrDefault(v, 0) + 1);
        }
        Arrays.sort(nums);
        int ans = 1;
        Set<Integer> vis = new HashSet<>();
        for (int v : nums) {
            if (cnt.getOrDefault(v, 0) < 2 || v == 1 || vis.contains(v)) {
                continue;
            }
            int x = v, d = 1;
            while ((long)x * x < INF && cnt.getOrDefault(x * x, 0) >= 2) {
                vis.add(x);
                d++;
                x *= x;
            }
            d = d * 2 + ((long)x * x < INF && cnt.containsKey(x * x) ? 1 : -1);
            ans = Math.max(ans, d);
        }
        if (cnt.containsKey(1)) {
            int v = cnt.get(1);
            ans = Math.max(ans, v / 2 * 2 + (v % 2 == 1 ? 1 : -1));
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
