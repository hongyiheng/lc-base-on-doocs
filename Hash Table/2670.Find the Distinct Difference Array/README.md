# [2670. 找出不同元素数目差数组](https://leetcode-cn.com/problems/find-the-distinct-difference-array)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个下标从 <strong>0</strong> 开始的数组 <code>nums</code> ，数组长度为 <code>n</code> 。</p>

<p><code>nums</code> 的 <strong>不同元素数目差</strong> 数组可以用一个长度为 <code>n</code> 的数组 <code>diff</code> 表示，其中 <code>diff[i]</code> 等于前缀 <code>nums[0, ..., i]</code> 中不同元素的数目 <strong>减去</strong> 后缀 <code>nums[i + 1, ..., n - 1]</code> 中不同元素的数目。</p>

<p>返回<em> </em><code>nums</code> 的 <strong>不同元素数目差</strong> 数组。</p>

<p>注意 <code>nums[i, ..., j]</code> 表示 <code>nums</code> 的一个从下标 <code>i</code> 开始到下标 <code>j</code> 结束的子数组（包含下标 <code>i</code> 和 <code>j</code> 对应元素）。特别需要说明的是，如果 <code>i &gt; j</code> ，则 <code>nums[i, ..., j]</code> 表示一个空子数组。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,2,3,4,5]
<strong>输出：</strong>[-3,-1,1,3,5]
<strong>解释：
</strong>对于 i = 0，前缀中有 1 个不同的元素，而在后缀中有 4 个不同的元素。因此，diff[0] = 1 - 4 = -3 。
对于 i = 1，前缀中有 2 个不同的元素，而在后缀中有 3 个不同的元素。因此，diff[1] = 2 - 3 = -1 。
对于 i = 2，前缀中有 3 个不同的元素，而在后缀中有 2 个不同的元素。因此，diff[2] = 3 - 2 = 1 。
对于 i = 3，前缀中有 4 个不同的元素，而在后缀中有 1 个不同的元素。因此，diff[3] = 4 - 1 = 3 。
对于 i = 4，前缀中有 5 个不同的元素，而在后缀中有 0 个不同的元素。因此，diff[4] = 5 - 0 = 5 。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [3,2,3,4,2]
<strong>输出：</strong>[-2,-1,0,2,3]
<strong>解释：</strong>
对于 i = 0，前缀中有 1 个不同的元素，而在后缀中有 3 个不同的元素。因此，diff[0] = 1 - 3 = -2 。
对于 i = 1，前缀中有 2 个不同的元素，而在后缀中有 3 个不同的元素。因此，diff[1] = 2 - 3 = -1 。
对于 i = 2，前缀中有 2 个不同的元素，而在后缀中有 2 个不同的元素。因此，diff[2] = 2 - 2 = 0 。
对于 i = 3，前缀中有 3 个不同的元素，而在后缀中有 1 个不同的元素。因此，diff[3] = 3 - 1 = 2 。
对于 i = 4，前缀中有 3 个不同的元素，而在后缀中有 0 个不同的元素。因此，diff[4] = 3 - 0 = 3 。 
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= n == nums.length&nbsp;&lt;= 50</code></li>
	<li><code>1 &lt;= nums[i] &lt;= 50</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def distinctDifferenceArray(self, nums: List[int]) -> List[int]:
        cnt = defaultdict(int)
        for v in nums:
            cnt[v] += 1
        ans = []
        s = set()
        for v in nums:
            s.add(v)
            cnt[v] -= 1
            if cnt[v] == 0:
                cnt.pop(v)
            ans.append(len(s) - len(cnt.keys()))
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int[] distinctDifferenceArray(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int v : nums) {
            cnt.put(v, cnt.getOrDefault(v, 0) + 1);
        }
        int[] ans = new int[n];
        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int v = nums[i];
            s.add(v);
            int c = cnt.getOrDefault(v, 0);
            if (c == 1) {
                cnt.remove(v);
            } else {
                cnt.put(v, c - 1);
            }
            ans[i] = s.size() - cnt.keySet().size();
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
