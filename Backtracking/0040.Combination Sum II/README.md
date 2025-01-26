# [40. 组合总和 II](https://leetcode-cn.com/problems/combination-sum-ii)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个数组 <code>candidates</code> 和一个目标数 <code>target</code> ，找出 <code>candidates</code> 中所有可以使数字和为 <code>target</code> 的组合。</p>

<p><code>candidates</code> 中的每个数字在每个组合中只能使用一次。</p>

<p><strong>注意：</strong>解集不能包含重复的组合。 </p>

<p> </p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入:</strong> candidates = <code>[10,1,2,7,6,1,5]</code>, target = <code>8</code>,
<strong>输出:</strong>
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入:</strong> candidates = [2,5,2,1,2], target = 5,
<strong>输出:</strong>
[
[1,2,2],
[5]
]</pre>

<p> </p>

<p><strong>提示:</strong></p>

<ul>
	<li><code>1 <= candidates.length <= 100</code></li>
	<li><code>1 <= candidates[i] <= 50</code></li>
	<li><code>1 <= target <= 30</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        def dfs(i, s, p, skip):
            if s >= target or i >= len(candidates):
                if s == target:
                    ans.append(p[::])
                return
            if skip and candidates[i] == candidates[i - 1]:
                return dfs(i + 1, s, p, True)

            p.append(candidates[i])
            s += candidates[i]
            dfs(i + 1, s, p, False)
            s -= candidates[i]
            p.pop()
            dfs(i + 1, s, p, True)

        candidates.sort()
        ans = []
        dfs(0, 0, [], False)
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {

    int target;
    int[] candidates;
    List<List<Integer>> ans;

    public void dfs(int i, int s, List<Integer> p, boolean skip) {
        if (s >= target || i >= candidates.length) {
            if (s == target) {
                ans.add(new ArrayList<>(p)); 
            }
            return;
        }
        if (skip && candidates[i] == candidates[i - 1]) {
            dfs(i + 1, s, p, skip);
            return;
        }
        s += candidates[i];
        p.add(candidates[i]);
        dfs(i + 1, s, p, false);
        s -= candidates[i];
        p.remove(p.size() - 1);
        dfs(i + 1, s, p, true);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.target = target;
        this.candidates = candidates;
        ans = new ArrayList<>();
        dfs(0, 0, new ArrayList<>(), false);
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
