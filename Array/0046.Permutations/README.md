# [46. 全排列](https://leetcode-cn.com/problems/permutations)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个不含重复数字的数组 <code>nums</code> ，返回其 <strong>所有可能的全排列</strong> 。你可以 <strong>按任意顺序</strong> 返回答案。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,2,3]
<strong>输出：</strong>[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [0,1]
<strong>输出：</strong>[[0,1],[1,0]]
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>nums = [1]
<strong>输出：</strong>[[1]]
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= nums.length <= 6</code></li>
	<li><code>-10 <= nums[i] <= 10</code></li>
	<li><code>nums</code> 中的所有整数 <strong>互不相同</strong></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python

```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        Deque<Integer> path = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[len];
        if(len == 0) {
            return res;
        }
        dfs(path,nums,used,0,len,res);
        return res;
    }

    public void dfs(Deque<Integer> path,int[] nums,boolean[] used,int depth,int len,List<List<Integer>> res) {
        if(depth == len){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = 0; i < len; i ++){
            if(!used[i]){
                path.addLast(nums[i]);
                used[i] = true;
                dfs(path,nums,used,depth + 1,len,res);
                used[i] = false;
                path.removeLast();
            }
        }
    }
}
```

### **...**

```

```

<!-- tabs:end -->
