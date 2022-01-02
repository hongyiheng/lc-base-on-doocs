# [254. 因子的组合](https://leetcode-cn.com/problems/factor-combinations)



## 题目描述

<!-- 这里写题目描述 -->

<p>整数可以被看作是其因子的乘积。</p>

<p>例如：</p>

<pre>8 = 2 x 2 x 2;
  = 2 x 4.</pre>

<p>请实现一个函数，该函数接收一个整数 <em>n</em>&nbsp;并返回该整数所有的因子组合。</p>

<p><strong>注意：</strong></p>

<ol>
	<li>你可以假定 <em>n</em> 为永远为正数。</li>
	<li>因子必须大于 1 并且小于 <em>n</em>。</li>
</ol>

<p><strong>示例 1：</strong></p>

<pre><strong>输入: </strong><code>1</code>
<strong>输出: </strong>[]
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入: </strong><code>37</code>
<strong>输出: </strong>[]</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入: </strong><code>12</code>
<strong>输出:</strong>
[
  [2, 6],
  [2, 2, 3],
  [3, 4]
]</pre>

<p><strong>示例 4: </strong></p>

<pre><strong>输入: </strong><code>32</code>
<strong>输出:</strong>
[
  [2, 16],
  [2, 2, 8],
  [2, 2, 2, 4],
  [2, 2, 2, 2, 2],
  [2, 4, 4],
  [4, 8]
]
</pre>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def getFactors(self, n: int) -> List[List[int]]:
        nums, path, res = [], [], []
        for i in range(2, n // 2 + 1):
            if n % i == 0:
                nums.append(i)

        def back_trace(cur, index):
            if cur == 1:
                res.append(path[:])
                return
            for i in range(index, len(nums)):
                if cur % nums[i] == 0:
                    path.append(nums[i])
                    back_trace(cur // nums[i], i)
                    path.pop()

        if nums:
            back_trace(n, 0)
        return res
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    List<Integer> nums;
    List<List<Integer>> res;
    Deque<Integer> path;

    public List<List<Integer>> getFactors(int n) {
        nums = new ArrayList();
        res = new ArrayList();
        path = new ArrayDeque();
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                nums.add(i);
            }
        }
        if (!nums.isEmpty()) {
            backTrace(n, 0);
        }
        return res;
    }

    public void backTrace(int n, int index) {
        if (n == 1) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < nums.size(); i++) {
            if (n % nums.get(i) == 0) {
                path.addLast(nums.get(i));
                backTrace(n / nums.get(i), i);
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
