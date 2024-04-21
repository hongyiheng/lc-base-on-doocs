# [216. 组合总和 III](https://leetcode-cn.com/problems/combination-sum-iii)



## 题目描述

<!-- 这里写题目描述 -->

<p>找出所有相加之和为&nbsp;<em><strong>n</strong> </em>的&nbsp;<strong><em>k&nbsp;</em></strong>个数的组合<strong><em>。</em></strong>组合中只允许含有 1 -&nbsp;9 的正整数，并且每种组合中不存在重复的数字。</p>

<p><strong>说明：</strong></p>

<ul>
	<li>所有数字都是正整数。</li>
	<li>解集不能包含重复的组合。&nbsp;</li>
</ul>

<p><strong>示例 1:</strong></p>

<pre><strong>输入:</strong> <em><strong>k</strong></em> = 3, <em><strong>n</strong></em> = 7
<strong>输出:</strong> [[1,2,4]]
</pre>

<p><strong>示例 2:</strong></p>

<pre><strong>输入:</strong> <em><strong>k</strong></em> = 3, <em><strong>n</strong></em> = 9
<strong>输出:</strong> [[1,2,6], [1,3,5], [2,3,4]]
</pre>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def combinationSum3(self, k: int, n: int) -> List[List[int]]:
        def dfs(i, cnt, s, path):
            if i >= 10 or cnt >= k or s >= n:
                if cnt == k and s == n:
                    ans.append(path[::])
                return
            dfs(i + 1, cnt, s, path)
            path.append(i)
            dfs(i + 1, cnt + 1, s + i, path)
            path.pop()
        
        ans = []
        dfs(1, 0, 0, [])
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {

    int k, n;
    List<List<Integer>> ans;

    public void dfs(int i, int cnt, int s, Deque<Integer> path) {
        if (i >= 10 || cnt >= k || s >= n) {
            if (cnt == k && s == n) {
                ans.add(new ArrayList<>(path));
            }
            return;
        }
        dfs(i + 1, cnt, s, path);
        path.add(i);
        dfs(i + 1, cnt + 1, s + i, path);
        path.pollLast();
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        this.k = k;
        this.n = n;
        ans = new ArrayList<>();
        dfs(1, 0, 0, new ArrayDeque<>());
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
