# [1803. 统计异或值在范围内的数对有多少](https://leetcode-cn.com/problems/count-pairs-with-xor-in-a-range)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个整数数组 <code>nums</code> （下标 <strong>从 0 开始</strong> 计数）以及两个整数：<code>low</code> 和 <code>high</code> ，请返回 <strong>漂亮数对</strong> 的数目。</p>

<p><strong>漂亮数对</strong> 是一个形如 <code>(i, j)</code> 的数对，其中 <code>0 &lt;= i &lt; j &lt; nums.length</code> 且 <code>low &lt;= (nums[i] XOR nums[j]) &lt;= high</code> 。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>nums = [1,4,2,7], low = 2, high = 6
<strong>输出：</strong>6
<strong>解释：</strong>所有漂亮数对 (i, j) 列出如下：
    - (0, 1): nums[0] XOR nums[1] = 5 
    - (0, 2): nums[0] XOR nums[2] = 3
    - (0, 3): nums[0] XOR nums[3] = 6
    - (1, 2): nums[1] XOR nums[2] = 6
    - (1, 3): nums[1] XOR nums[3] = 3
    - (2, 3): nums[2] XOR nums[3] = 5
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>nums = [9,8,4,2,1], low = 5, high = 14
<strong>输出：</strong>8
<strong>解释：</strong>所有漂亮数对 (i, j) 列出如下：
​​​​​    - (0, 2): nums[0] XOR nums[2] = 13
    - (0, 3): nums[0] XOR nums[3] = 11
    - (0, 4): nums[0] XOR nums[4] = 8
    - (1, 2): nums[1] XOR nums[2] = 12
    - (1, 3): nums[1] XOR nums[3] = 10
    - (1, 4): nums[1] XOR nums[4] = 9
    - (2, 3): nums[2] XOR nums[3] = 6
    - (2, 4): nums[2] XOR nums[4] = 5</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 2 * 10<sup>4</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= 2 * 10<sup>4</sup></code></li>
	<li><code>1 &lt;= low &lt;= high &lt;= 2 * 10<sup>4</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Trie:
    def __init__(self):
        self.children = [None, None]
        self.cnt = 0

    def insert(self, x):
        node = self
        for i in range(15, -1, -1):
            v = x >> i & 1
            if not node.children[v]:
                node.children[v] = Trie()
            node = node.children[v]
            node.cnt += 1

    def search(self, x, mx):
        node = self
        ans = 0
        for i in range(15, -1, -1):
            if not node:
                return ans
            v = x >> i & 1
            if mx >> i & 1:
                if node.children[v]:
                    ans += node.children[v].cnt
                node = node.children[v ^ 1]
            else:
                node = node.children[v]
        return ans

class Solution:
    def countPairs(self, nums: List[int], low: int, high: int) -> int:
        ans = 0
        tree = Trie()
        for v in nums:
            ans += tree.search(v, high + 1) - tree.search(v, low)
            tree.insert(v)
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Trie {
    Trie[] children = new Trie[2];
    int cnt = 0;

    public void insert(int x) {
        Trie node = this;
        for (int i = 15; i >= 0; i--) {
            int v = x >> i & 1;
            if (node.children[v] == null) {
                node.children[v] = new Trie();
            }
            node = node.children[v];
            node.cnt++;
        }
    }

    public int search(int x, int mx) {
        Trie node = this;
        int ans = 0;
        for (int i = 15; i >= 0; i--) {
            if (node == null) {
                return ans;
            }
            int v = x >> i & 1;
            if ((mx >> i & 1) == 1) {
                if (node.children[v] != null) {
                    ans += node.children[v].cnt;
                }
                node = node.children[v ^ 1];
            } else {
                node = node.children[v];
            }
        }
        return ans;
    }
}

class Solution {
    public int countPairs(int[] nums, int low, int high) {
        Trie tree = new Trie();
        int n = nums.length, ans = 0;
        for (int v : nums) {
            ans += tree.search(v, high + 1) - tree.search(v, low);
            tree.insert(v);
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
