# [1122. 数组的相对排序](https://leetcode-cn.com/problems/relative-sort-array)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你两个数组，<code>arr1</code> 和 <code>arr2</code>，</p>

<ul>
	<li><code>arr2</code> 中的元素各不相同</li>
	<li><code>arr2</code> 中的每个元素都出现在 <code>arr1</code> 中</li>
</ul>

<p>对 <code>arr1</code> 中的元素进行排序，使 <code>arr1</code> 中项的相对顺序和 <code>arr2</code> 中的相对顺序相同。未在 <code>arr2</code> 中出现过的元素需要按照升序放在 <code>arr1</code> 的末尾。</p>

<p> </p>

<p><strong>示例：</strong></p>

<pre>
<strong>输入：</strong>arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
<strong>输出：</strong>[2,2,2,1,4,3,3,9,6,7,19]
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= arr1.length, arr2.length <= 1000</code></li>
	<li><code>0 <= arr1[i], arr2[i] <= 1000</code></li>
	<li><code>arr2</code> 中的元素 <code>arr2[i]</code> 各不相同</li>
	<li><code>arr2</code> 中的每个元素 <code>arr2[i]</code> 都出现在 <code>arr1</code> 中</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def relativeSortArray(self, arr1: List[int], arr2: List[int]) -> List[int]:
        cnt = [0] * 1010
        for v in arr1:
            cnt[v] += 1
        ans = []
        for v in arr2:
            ans += cnt[v] * [v]
            cnt[v] = 0
        for i, v in enumerate(cnt):
            if v:
                ans += [i] * v
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int[] cnt = new int[1010];
        for (int v : arr1) {
            cnt[v]++;
        }
        int[] ans = new int[n];
        int idx = 0;
        for (int v : arr2) {
            while (cnt[v]-- > 0) {
                ans[idx++] = v;
            }
        }
        for (int i = 0; i < 1010; i++) {
            while (cnt[i]-- > 0) {
                ans[idx++] = i;
            }
        }
        return ans;
    }
}java

```

### **...**

```

```

<!-- tabs:end -->
