# [118. 杨辉三角](https://leetcode-cn.com/problems/pascals-triangle)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个非负整数 <em><code>numRows</code>，</em>生成「杨辉三角」的前 <em><code>numRows</code> </em>行。</p>

<p><small>在「杨辉三角」中，每个数是它左上方和右上方的数的和。</small></p>

<p><img alt="" src="https://pic.leetcode-cn.com/1626927345-DZmfxB-PascalTriangleAnimated2.gif" /></p>

<p> </p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入:</strong> numRows = 5
<strong>输出:</strong> [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入:</strong> numRows = 1
<strong>输出:</strong> [[1]]
</pre>

<p> </p>

<p><strong>提示:</strong></p>

<ul>
	<li><code>1 <= numRows <= 30</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        ans = [[1]]
        for i in range(1, numRows):
            last = ans[-1]
            cur = [0] * (len(last) + 1)
            cur[0] = cur[-1] = 1
            for j in range(1, len(cur) - 1):
                cur[j] = last[j - 1] + last[j]
            ans.append(cur)
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(Arrays.asList(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> last = ans.get(ans.size() - 1);
            List<Integer> cur = new ArrayList<>();
            for (int j = 0; j < last.size() + 1; j++) {
                if (j == 0 || j == last.size()) {
                    cur.add(1);
                } else {
                    cur.add(last.get(j - 1) + last.get(j));
                }
            }
            ans.add(cur);
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
