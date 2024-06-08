# [3040. 相同分数的最大操作数目 II](https://leetcode.cn/problems/maximum-number-of-operations-with-the-same-score-ii)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个整数数组&nbsp;<code>nums</code>&nbsp;，如果&nbsp;<code>nums</code>&nbsp;<strong>至少</strong>&nbsp;包含 <code>2</code>&nbsp;个元素，你可以执行以下操作中的&nbsp;<strong>任意</strong>&nbsp;一个：</p>

<ul>
	<li>选择 <code>nums</code>&nbsp;中最前面两个元素并且删除它们。</li>
	<li>选择 <code>nums</code>&nbsp;中最后两个元素并且删除它们。</li>
	<li>选择 <code>nums</code>&nbsp;中第一个和最后一个元素并且删除它们。</li>
</ul>

<p>一次操作的&nbsp;<strong>分数</strong>&nbsp;是被删除元素的和。</p>

<p>在确保<strong>&nbsp;所有操作分数相同</strong>&nbsp;的前提下，请你求出&nbsp;<strong>最多</strong>&nbsp;能进行多少次操作。</p>

<p>请你返回按照上述要求&nbsp;<strong>最多</strong>&nbsp;可以进行的操作次数。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<pre>
<b>输入：</b>nums = [3,2,1,2,3,4]
<b>输出：</b>3
<b>解释：</b>我们执行以下操作：
- 删除前两个元素，分数为 3 + 2 = 5 ，nums = [1,2,3,4] 。
- 删除第一个元素和最后一个元素，分数为 1 + 4 = 5 ，nums = [2,3] 。
- 删除第一个元素和最后一个元素，分数为 2 + 3 = 5 ，nums = [] 。
由于 nums 为空，我们无法继续进行任何操作。
</pre>

<p><strong class="example">示例 2：</strong></p>

<pre>
<b>输入：</b>nums = [3,2,6,1,4]
<b>输出：</b>2
<b>解释：</b>我们执行以下操作：
- 删除前两个元素，分数为 3 + 2 = 5 ，nums = [6,1,4] 。
- 删除最后两个元素，分数为 1 + 4 = 5 ，nums = [6] 。
至多进行 2 次操作。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>2 &lt;= nums.length &lt;= 2000</code></li>
	<li><code>1 &lt;= nums[i] &lt;= 1000</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def maxOperations(self, nums: List[int]) -> int:
        @cache
        def f(l, r, t):
            if r - l + 1 < 2:
                return 0
            ans = 0
            if nums[l] + nums[l + 1] == t:
                ans = max(f(l + 2, r, t) + 1, ans)

            if nums[l] + nums[r] == t:
                ans = max(f(l + 1, r - 1, t) + 1, ans)
            if nums[r] + nums[r - 1] == t:
                ans = max(f(l, r - 2, t) + 1, ans)
            return ans
        
        n = len(nums)
        return max(f(0, n - 1, nums[0] + nums[1]), f(0, n - 1, nums[0] + nums[-1]), f(0, n - 1, nums[-1] + nums[-2]))
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {

    Map<String, Integer> f;
    int[] nums;

    public int dfs(int l, int r, int t) {
        if (r - l + 1 < 2) {
            return 0;
        } 
        String key = l + ":" + r + ":" + t;
        if (f.containsKey(key)) {
            return f.get(key);
        }
        int ans = 0;
        if (nums[l] + nums[l + 1] == t) {
            ans = Math.max(ans, dfs(l + 2, r, t) + 1);
        }
        if (nums[l] + nums[r] == t) {
            ans = Math.max(ans, dfs(l + 1, r - 1, t) + 1);
        }
        if (nums[r] + nums[r - 1] == t) {
            ans = Math.max(ans, dfs(l, r - 2, t) + 1);
        }
        f.put(key, ans);
        return ans;
    } 

    public int maxOperations(int[] nums) {
        int n = nums.length;
        f = new HashMap<>();
        this.nums = nums;
        int ans = Math.max(dfs(0, n - 1, nums[0] + nums[1]), dfs(0, n - 1, nums[0] + nums[n - 1]));
        return Math.max(ans, dfs(0, n - 1, nums[n - 2] + nums[n - 1]));
    }
}
```

### **...**

```

```

<!-- tabs:end -->
