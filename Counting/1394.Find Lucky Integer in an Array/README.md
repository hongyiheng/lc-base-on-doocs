# [1394. 找出数组中的幸运数](https://leetcode-cn.com/problems/find-lucky-integer-in-an-array)



## 题目描述

<!-- 这里写题目描述 -->

<p>在整数数组中，如果一个整数的出现频次和它的数值大小相等，我们就称这个整数为「幸运数」。</p>

<p>给你一个整数数组 <code>arr</code>，请你从中找出并返回一个幸运数。</p>

<ul>
	<li>如果数组中存在多个幸运数，只需返回 <strong>最大</strong> 的那个。</li>
	<li>如果数组中不含幸运数，则返回 <strong>-1 </strong>。</li>
</ul>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>arr = [2,2,3,4]
<strong>输出：</strong>2
<strong>解释：</strong>数组中唯一的幸运数是 2 ，因为数值 2 的出现频次也是 2 。
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>arr = [1,2,2,3,3,3]
<strong>输出：</strong>3
<strong>解释：</strong>1、2 以及 3 都是幸运数，只需要返回其中最大的 3 。
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>arr = [2,2,2,3,3]
<strong>输出：</strong>-1
<strong>解释：</strong>数组中不存在幸运数。
</pre>

<p><strong>示例 4：</strong></p>

<pre><strong>输入：</strong>arr = [5]
<strong>输出：</strong>-1
</pre>

<p><strong>示例 5：</strong></p>

<pre><strong>输入：</strong>arr = [7,7,7,7,7,7,7]
<strong>输出：</strong>7
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= arr.length &lt;= 500</code></li>
	<li><code>1 &lt;= arr[i] &lt;= 500</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def findLucky(self, arr: List[int]) -> int:
        cnt = Counter(arr)
        ans = max([k if cnt[k] == k else 0 for k in cnt.keys()])
        return -1 if not ans else ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int v : arr) {
            cnt.put(v, cnt.getOrDefault(v, 0) + 1);
        }
        int ans = -1;
        for (int k : cnt.keySet()) {
            if (cnt.get(k) == k) {
                ans = Math.max(ans, k);
            }
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
