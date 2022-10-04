# [491. 递增子序列](https://leetcode-cn.com/problems/increasing-subsequences)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是 2 。</p>

<p> </p>

<p><strong>示例：</strong></p>

<pre>
<strong>输入：</strong>[4, 6, 7, 7]
<strong>输出：</strong>[[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li>给定数组的长度不会超过15。</li>
	<li>数组中的整数范围是 [-100,100]。</li>
	<li>给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def findSubsequences(self, nums: List[int]) -> List[List[int]]:
        ans = []
        s = set()
        n = len(nums)

        def dfs(path, vis, idx):
            if len(path) >= 2:
                h = str(path)
                if h not in s:
                    ans.append(path[::])
                    s.add(h)
            if idx >= n:
                return
            for i in range(idx, n):
                if vis[i]:
                    continue
                if path and path[-1] > nums[i]:
                    continue
                path.append(nums[i])
                vis[i] = True
                dfs(path, vis, i + 1)
                vis[i] = False
                path.pop()
        
        dfs(list(), [False] * n, 0)
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    List<List<Integer>> ans;
    Set<String> s;
    int[] nums;
    int n;

    public List<List<Integer>> findSubsequences(int[] nums) {
        ans = new ArrayList<>();
        this.nums = nums;
        n = nums.length;
        Deque<Integer> path = new ArrayDeque<>();
        boolean[] vis = new boolean[n];
        s = new HashSet<>();
        dfs(path, vis, 0);
        return ans;
    }

    public void dfs(Deque<Integer> path, boolean[] vis, int idx) {
        if (path.size() >= 2) {
            String h = hash(path);
            if (!s.contains(h)) {
                ans.add(new ArrayList(path));
                s.add(h);
            }
        }
        if (idx >= n) {
            return;
        }
        for (int i = idx; i < n; i++) {
            if (!path.isEmpty() && path.peekLast() > nums[i]) {
                continue;
            }
            if (vis[i]) {
                continue;
            }
            vis[i] = true;
            path.addLast(nums[i]);
            dfs(path, vis, i + 1);
            path.pollLast();
            vis[i] = false;
        }
    }

    public String hash(Deque<Integer> q) {
        StringBuilder sb = new StringBuilder();
        for (int v : q) {
            sb.append(String.valueOf(v) + "-");
        }
        return sb.toString();
    }
}
```

### **...**

```

```

<!-- tabs:end -->
