# [1053. 交换一次的先前排列](https://leetcode-cn.com/problems/previous-permutation-with-one-swap)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个正整数的数组 <code>A</code>（其中的元素不一定完全不同），请你返回可在 <strong>一次交换</strong>（交换两数字 <code>A[i]</code> 和 <code>A[j]</code> 的位置）后得到的、按字典序排列小于 <code>A</code> 的最大可能排列。</p>

<p>如果无法这么操作，就请返回原数组。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>arr = [3,2,1]
<strong>输出：</strong>[3,1,2]
<strong>解释：</strong>交换 2 和 1
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>arr = [1,1,5]
<strong>输出：</strong>[1,1,5]
<strong>解释：</strong>已经是最小排列
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>arr = [1,9,4,6,7]
<strong>输出：</strong>[1,7,4,6,9]
<strong>解释：</strong>交换 9 和 7
</pre>

<p><strong>示例 4：</strong></p>

<pre>
<strong>输入：</strong>arr = [3,1,1,3]
<strong>输出：</strong>[1,3,1,3]
<strong>解释：</strong>交换 1 和 3
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= arr.length <= 10<sup>4</sup></code></li>
	<li><code>1 <= arr[i] <= 10<sup>4</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def prevPermOpt1(self, arr: List[int]) -> List[int]:
        mp = dict()
        n = len(arr)
        for i in range(n - 1, -1, -1):
            for j in range(arr[i] - 1, -1, -1):
                if j in mp:
                    arr[i], arr[mp[j]] = arr[mp[j]], arr[i]
                    return arr
            mp[arr[i]] = i
        return arr
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int[] prevPermOpt1(int[] arr) {
        Map<Integer, Integer> mp = new HashMap<>();
        int n = arr.length;
        for (int i = n - 1; i > -1; i--) {
            for (int j = arr[i] - 1; j > -1; j--) {
                if (mp.containsKey(j)) {
                    int tmp = arr[i];
                    arr[i] = arr[mp.get(j)];
                    arr[mp.get(j)] = tmp;
                    return arr;
                }
            }
            mp.put(arr[i], i);
        }
        return arr;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
