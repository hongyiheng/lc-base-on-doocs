# [1187. 使数组严格递增](https://leetcode-cn.com/problems/make-array-strictly-increasing)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你两个整数数组&nbsp;<code>arr1</code> 和 <code>arr2</code>，返回使&nbsp;<code>arr1</code>&nbsp;严格递增所需要的最小「操作」数（可能为 0）。</p>

<p>每一步「操作」中，你可以分别从 <code>arr1</code> 和 <code>arr2</code> 中各选出一个索引，分别为&nbsp;<code>i</code> 和&nbsp;<code>j</code>，<code>0 &lt;=&nbsp;i &lt; arr1.length</code>&nbsp;和&nbsp;<code>0 &lt;= j &lt; arr2.length</code>，然后进行赋值运算&nbsp;<code>arr1[i] = arr2[j]</code>。</p>

<p>如果无法让&nbsp;<code>arr1</code>&nbsp;严格递增，请返回&nbsp;<code>-1</code>。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>arr1 = [1,5,3,6,7], arr2 = [1,3,2,4]
<strong>输出：</strong>1
<strong>解释：</strong>用 2 来替换 <code>5，之后</code> <code>arr1 = [1, 2, 3, 6, 7]</code>。
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>arr1 = [1,5,3,6,7], arr2 = [4,3,1]
<strong>输出：</strong>2
<strong>解释：</strong>用 3 来替换 <code>5，然后</code>用 4 来替换 3<code>，得到</code> <code>arr1 = [1, 3, 4, 6, 7]</code>。
</pre>

<p><strong>示例&nbsp;3：</strong></p>

<pre><strong>输入：</strong>arr1 = [1,5,3,6,7], arr2 = [1,6,3,3]
<strong>输出：</strong>-1
<strong>解释：</strong>无法使 <code>arr1 严格递增</code>。</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= arr1.length, arr2.length &lt;= 2000</code></li>
	<li><code>0 &lt;= arr1[i], arr2[i] &lt;= 10^9</code></li>
</ul>

<p>&nbsp;</p>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def makeArrayIncreasing(self, arr1: List[int], arr2: List[int]) -> int:
        @cache
        def dfs(i, pre):
            if i == n:
                return 0
            res = dfs(i + 1, arr1[i]) if arr1[i] > pre else inf
            l, r = 0, m - 1
            while l < r:
                mid = (l + r) >> 1
                if arr2[mid] <= pre:
                    l = mid + 1
                else:
                    r = mid
            if l < m and arr2[l] > pre:
                res = min(res, dfs(i + 1, arr2[l]) + 1)
            return res

        n, m = len(arr1), len(arr2)
        arr2.sort()
        res = dfs(0, -1)
        return -1 if res == inf else res
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {

    int n, m;
    int[] arr1, arr2;
    Map<String, Integer> f;
    
    public int dfs(int i, int pre) {
        if (i == n) {
            return 0;
        }
        String key = i + "_" + pre;
        if (f.containsKey(key)) {
            return f.get(key);
        }
        int res = arr1[i] > pre ? dfs(i + 1, arr1[i]) : 0x3f3f3f3f;
        int l = 0, r = m - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (arr2[mid] <= pre) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        if (arr2[l] > pre) {
            res = Math.min(res, dfs(i + 1, arr2[l]) + 1);
        }
        f.put(key, res);
        return res;
    }
    
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        n = arr1.length;
        m = arr2.length;
        this.arr1 = arr1;
        this.arr2 = arr2;
        f = new HashMap<>();
        Arrays.sort(arr2);
        int res = dfs(0, -1);
        return res == 0x3f3f3f3f ? -1 : res;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
