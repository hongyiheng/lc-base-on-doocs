# [904. 水果成篮](https://leetcode-cn.com/problems/fruit-into-baskets)



## 题目描述

<!-- 这里写题目描述 -->

<p>在一排树中，第 <code>i</code> 棵树产生&nbsp;<code>tree[i]</code> 型的水果。<br>
你可以<strong>从你选择的任何树开始</strong>，然后重复执行以下步骤：</p>

<ol>
	<li>把这棵树上的水果放进你的篮子里。如果你做不到，就停下来。</li>
	<li>移动到当前树右侧的下一棵树。如果右边没有树，就停下来。</li>
</ol>

<p>请注意，在选择一颗树后，你没有任何选择：你必须执行步骤 1，然后执行步骤 2，然后返回步骤 1，然后执行步骤 2，依此类推，直至停止。</p>

<p>你有两个篮子，每个篮子可以携带任何数量的水果，但你希望每个篮子只携带一种类型的水果。</p>

<p>用这个程序你能收集的水果树的最大总量是多少？</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>[1,2,1]
<strong>输出：</strong>3
<strong>解释：</strong>我们可以收集 [1,2,1]。
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>[0,1,2,2]
<strong>输出：</strong>3
<strong>解释：</strong>我们可以收集 [1,2,2]
如果我们从第一棵树开始，我们将只能收集到 [0, 1]。
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>[1,2,3,2,2]
<strong>输出：</strong>4
<strong>解释：</strong>我们可以收集 [2,3,2,2]
如果我们从第一棵树开始，我们将只能收集到 [1, 2]。
</pre>

<p><strong>示例 4：</strong></p>

<pre><strong>输入：</strong>[3,3,3,1,2,1,1,2,3,3,4]
<strong>输出：</strong>5
<strong>解释：</strong>我们可以收集 [1,2,1,1,2]
如果我们从第一棵树或第八棵树开始，我们将只能收集到 4 棵水果树。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= tree.length &lt;= 40000</code></li>
	<li><code>0 &lt;= tree[i] &lt; tree.length</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def totalFruit(self, fruits: List[int]) -> int:
        type = set()

        def getLeft(r):
            cur = fruits[r]
            for l in range(r - 1, -1, -1):
                if fruits[l] != cur:
                    type.remove(fruits[l])
                    return l + 1
            return 0
        
        ans, l = 0, 0
        for r in range(len(fruits)):
            if fruits[r] not in type:
                if len(type) == 2:
                    l = getLeft(r - 1)
                type.add(fruits[r])
            ans = max(ans, r - l + 1)
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    Set<Integer> set = new HashSet<>();
    public int totalFruit(int[] fruits) {
        int ans = 0, l = 0;
        for (int r = 0; r < fruits.length; r++) {
            if (!set.contains(fruits[r])) {
                if (set.size() == 2) {
                    l = getLeft(fruits, r - 1);
                } 
                set.add(fruits[r]);  
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }

    public int getLeft(int[] fruits, int right) {
        int cur = fruits[right];
        for (int l = right - 1; l >= 0; l--) {
            if (fruits[l] != cur) {
                set.remove(fruits[l]);
                return l + 1;
            }
        }
        return 0;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
