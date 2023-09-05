# [2605. 从两个数字数组里生成最小数字](https://leetcode-cn.com/problems/form-smallest-number-from-two-digit-arrays)



## 题目描述

<!-- 这里写题目描述 -->

给你两个只包含 1 到 9 之间数字的数组&nbsp;<code>nums1</code> 和&nbsp;<code>nums2</code>&nbsp;，每个数组中的元素 <strong>互不相同</strong>&nbsp;，请你返回 <strong>最小</strong> 的数字，两个数组都 <strong>至少</strong> 包含这个数字的某个数位。
<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><b>输入：</b>nums1 = [4,1,3], nums2 = [5,7]
<b>输出：</b>15
<b>解释：</b>数字 15 的数位 1 在 nums1 中出现，数位 5 在 nums2 中出现。15 是我们能得到的最小数字。
</pre>

<p><strong>示例 2：</strong></p>

<pre><b>输入：</b>nums1 = [3,5,2,6], nums2 = [3,1,7]
<b>输出：</b>3
<b>解释：</b>数字 3 的数位 3 在两个数组中都出现了。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= nums1.length, nums2.length &lt;= 9</code></li>
	<li><code>1 &lt;= nums1[i], nums2[i] &lt;= 9</code></li>
	<li>每个数组中，元素 <strong>互不相同</strong>&nbsp;。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def minNumber(self, nums1: List[int], nums2: List[int]) -> int:
        cnt = [0] * 10
        for v in nums1:
            cnt[v] = 1
        for v in nums2:
            cnt[v] = 3 if cnt[v] else 2
        a = b = 0
        for i, v in enumerate(cnt):
            if v == 3:
                return i
            if v == 1 and not a:
                a = i
            if v == 2 and not b:
                b = i
        return min(a, b) * 10 + max(a, b)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int minNumber(int[] nums1, int[] nums2) {
        int[] cnt = new int[10];
        for (int v : nums1) {
            cnt[v] = 1;
        }
        for (int v : nums2) {
            cnt[v] = cnt[v] == 1 ? 3 : 2;
        }
        int a = 0, b = 0;
        for (int i = 0; i < 10; i++) {
            if (cnt[i] == 3) {
                return i;
            }
            if (cnt[i] == 1 && a == 0) {
                a = i;
            }
            if (cnt[i] == 2 && b == 0) {
                b = i;
            }
        }
        return Math.min(a, b) * 10 + Math.max(a, b);
    }
}
```

### **...**

```

```

<!-- tabs:end -->
