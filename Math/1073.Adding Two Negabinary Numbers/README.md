# [1073. 负二进制数相加](https://leetcode-cn.com/problems/adding-two-negabinary-numbers)



## 题目描述

<!-- 这里写题目描述 -->

<p>给出基数为 <strong>-2</strong>&nbsp;的两个数&nbsp;<code>arr1</code> 和&nbsp;<code>arr2</code>，返回两数相加的结果。</p>

<p>数字以&nbsp;<strong>数组形式&nbsp;</strong>给出：数组由若干 0 和 1 组成，按最高有效位到最低有效位的顺序排列。例如，<code>arr&nbsp;= [1,1,0,1]</code>&nbsp;表示数字&nbsp;<code>(-2)^3&nbsp;+ (-2)^2 + (-2)^0 = -3</code>。<strong>数组形式&nbsp;</strong>的数字也同样不含前导零：以 <code>arr</code> 为例，这意味着要么&nbsp;<code>arr == [0]</code>，要么&nbsp;<code>arr[0] == 1</code>。</p>

<p>返回相同表示形式的 <code>arr1</code> 和 <code>arr2</code> 相加的结果。两数的表示形式为：不含前导零、由若干 0 和 1 组成的数组。</p>

<p>&nbsp;</p>

<p><strong>示例：</strong></p>

<pre><strong>输入：</strong>arr1 = [1,1,1,1,1], arr2 = [1,0,1]
<strong>输出：</strong>[1,0,0,0,0]
<strong>解释：</strong>arr1 表示 11，arr2 表示 5，输出表示 16 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ol>
	<li><code>1 &lt;= arr1.length &lt;= 1000</code></li>
	<li><code>1 &lt;= arr2.length &lt;= 1000</code></li>
	<li><code>arr1</code> 和&nbsp;<code>arr2</code>&nbsp;都不含前导零</li>
	<li><code>arr1[i]</code> 为&nbsp;<code>0</code>&nbsp;或&nbsp;<code>1</code></li>
	<li><code>arr2[i]</code>&nbsp;为&nbsp;<code>0</code> 或&nbsp;<code>1</code></li>
</ol>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def addNegabinary(self, arr1: List[int], arr2: List[int]) -> List[int]:
        if len(arr1) < len(arr2):
            return self.addNegabinary(arr2, arr1)
        arr1 = [0, 0, 0] + arr1
        m, n = len(arr1), len(arr2)
        i = 0
        ans = []
        carry = 0
        while i < m or i < n:
            v = carry
            carry = 0
            v += arr1[m - i - 1] if i < m else 0
            v += arr2[n - i - 1] if i < n else 0
            if v >= 2:
                v -= 2
                carry = -1
            if v == -1:
                v = 1
                arr1[m - i - 2] += 1
            ans.append(v)
            i += 1
        while len(ans) > 1 and ans[-1] == 0:
            ans.pop()
        return ans[::-1]
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        if (arr1.length < arr2.length) {
            return addNegabinary(arr2, arr1);
        }
        int[] arr = new int[arr1.length + 3];
        int m = arr.length, n = arr2.length;
        for (int i = 3; i < m; i++) {
            arr[i] = arr1[i - 3];
        }
        Deque<Integer> ans = new ArrayDeque<>();
        int carry = 0;
        for (int i = 0; i < m; i++) {
            int v = arr[m - i - 1] + carry;
            carry = 0;
            v += i < n ? arr2[n - 1 - i] : 0;
            if (v >= 2) {
                v -= 2;
                carry = -1;
            }
            if (v == -1) {
                arr[m - i - 2]++;
                v = 1;
            }
            ans.addFirst(v);
        }
        while (ans.size() > 1 && ans.peekFirst() == 0) {
            ans.removeFirst();
        }
        int[] res = new int[ans.size()];
        int i = 0;
        while (!ans.isEmpty()) {
            res[i++] = ans.pollFirst();
        }
        return res;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
