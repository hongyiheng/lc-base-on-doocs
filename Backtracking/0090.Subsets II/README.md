# [90. 子集 II](https://leetcode-cn.com/problems/subsets-ii)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个整数数组 <code>nums</code> ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。</p>

<p>解集 <strong>不能</strong> 包含重复的子集。返回的解集中，子集可以按 <strong>任意顺序</strong> 排列。</p>

<div class="original__bRMd">
<div>
<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,2,2]
<strong>输出：</strong>[[],[1],[1,2],[1,2,2],[2],[2,2]]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [0]
<strong>输出：</strong>[[],[0]]
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= nums.length <= 10</code></li>
	<li><code>-10 <= nums[i] <= 10</code></li>
</ul>
</div>
</div>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        ans, path = set(), []
        n = len(nums)

        def dfs(path, idx, cur):
            nonlocal ans, nums, n
            if idx == n:
                ans.add(tuple(path[::]))
                return
            for i in range(cur, n):
                path.append(nums[i])
                dfs(path, idx + 1, i + 1)
                path.pop()
                dfs(path, idx + 1, i + 1)

        dfs(path, 0, 0)
        return list(ans)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    Set<List<Integer>> ans;
    int[] nums;
    int n;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        n = nums.length;
        ans = new HashSet<>();
        Deque<Integer> path = new ArrayDeque<>();
        dfs(path, 0, 0);
        return new ArrayList(ans);
    }

    public void dfs(Deque<Integer> path, int idx, int cur) {
        if (idx == n) {
            ans.add(new ArrayList(path));
            return;
        }
        for (int i = cur; i < n; i++) {
            path.addLast(nums[i]);
            dfs(path, idx + 1, i + 1);
            path.pollLast();
            dfs(path, idx + 1, i + 1);
        }
    }
}
```

### **...**

```

```

<!-- tabs:end -->
