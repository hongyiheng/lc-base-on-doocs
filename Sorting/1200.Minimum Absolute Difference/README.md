# [1200. 最小绝对差](https://leetcode-cn.com/problems/minimum-absolute-difference)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你个整数数组&nbsp;<code>arr</code>，其中每个元素都 <strong>不相同</strong>。</p>

<p>请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>arr = [4,2,1,3]
<strong>输出：</strong>[[1,2],[2,3],[3,4]]
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>arr = [1,3,6,10,15]
<strong>输出：</strong>[[1,3]]
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>arr = [3,8,-10,23,19,-4,-14,27]
<strong>输出：</strong>[[-14,-10],[19,23],[23,27]]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>2 &lt;= arr.length &lt;= 10^5</code></li>
	<li><code>-10^6 &lt;= arr[i] &lt;= 10^6</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def minimumAbsDifference(self, arr: List[int]) -> List[List[int]]:
        ans = []
        arr.sort()
        min_val = float('inf')
        for i in range(1, len(arr)):
            cur = abs(arr[i - 1] - arr[i])
            if min_val >= cur:
                if min_val > cur:
                    min_val = cur
                    ans.clear()
                ans.append([arr[i - 1], arr[i]])
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        int n = arr.length, min = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            int cur = Math.abs(arr[i] - arr[i - 1]);
            if (min >= cur) {
                if (min > cur) {
                    min = cur;
                    ans.clear();
                }
                List<Integer> item = new ArrayList<>();
                item.add(arr[i - 1]);
                item.add(arr[i]);
                ans.add(item);
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
