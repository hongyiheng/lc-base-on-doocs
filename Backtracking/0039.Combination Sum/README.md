# [39. 组合总和](https://leetcode-cn.com/problems/combination-sum)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个<strong>无重复元素</strong>的正整数数组 <code>candidates</code> 和一个正整数 <code>target</code> ，找出 <code>candidates</code> 中所有可以使数字和为目标数 <code>target</code> 的唯一组合。</p>

<p><code>candidates</code> 中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的。 </p>

<p>对于给定的输入，保证和为 <code>target</code> 的唯一组合数少于 <code>150</code> 个。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入: </strong>candidates = <code>[2,3,6,7], </code>target = <code>7</code>
<strong>输出: </strong>[[7],[2,2,3]]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入: </strong>candidates = [2,3,5]<code>, </code>target = 8
<strong>输出: </strong>[[2,2,2,2],[2,3,3],[3,5]]</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入: </strong>candidates = <code>[2], </code>target = 1
<strong>输出: </strong>[]
</pre>

<p><strong>示例 4：</strong></p>

<pre>
<strong>输入: </strong>candidates = <code>[1], </code>target = <code>1</code>
<strong>输出: </strong>[[1]]
</pre>

<p><strong>示例 5：</strong></p>

<pre>
<strong>输入: </strong>candidates = <code>[1], </code>target = <code>2</code>
<strong>输出: </strong>[[1,1]]
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= candidates.length <= 30</code></li>
	<li><code>1 <= candidates[i] <= 200</code></li>
	<li><code>candidate</code> 中的每个元素都是独一无二的。</li>
	<li><code>1 <= target <= 500</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        def dfs(i, s, path):
            if i == len(candidates) or s >= target:
                if s == target:
                    ans.append(path[::])
                return
            path.append(candidates[i])
            dfs(i, s + candidates[i], path)
            path.pop()
            dfs(i + 1, s, path)
        
        ans = []
        dfs(0, 0, [])
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    
    List<List<Integer>> ans = new ArrayList<>();
    int[] cancelAccount;
    int target;

    public void dfs(int i, int s, Deque<Integer> path) {
        if (i == cancelAccount.length || s >= target) {
            if (s == target) {
                ans.add(new ArrayList<>(path));
            }
            return;
        }
        path.addLast(cancelAccount[i]);
        dfs(i, s + cancelAccount[i], path);
        path.pollLast();
        dfs(i + 1, s, path);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.target = target;
        this.cancelAccount = candidates;
        dfs(0, 0, new ArrayDeque<>());
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
