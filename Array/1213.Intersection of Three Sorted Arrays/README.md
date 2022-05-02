# [1213. 三个有序数组的交集](https://leetcode-cn.com/problems/intersection-of-three-sorted-arrays)



## 题目描述

<!-- 这里写题目描述 -->

<p>给出三个均为 <strong>严格递增排列 </strong>的整数数组&nbsp;<code>arr1</code>，<code>arr2</code> 和&nbsp;<code>arr3</code>。</p>

<p>返回一个由&nbsp;<strong>仅 </strong>在这三个数组中&nbsp;<strong>同时出现&nbsp;</strong>的整数所构成的有序数组。</p>

<p>&nbsp;</p>

<p><strong>示例：</strong></p>

<pre><strong>输入: </strong>arr1 = [1,2,3,4,5], arr2 = [1,2,5,7,9], arr3 = [1,3,4,5,8]
<strong>输出: </strong>[1,5]
<strong>解释: </strong>只有 1 和 5 同时在这三个数组中出现.
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ol>
	<li><code>1 &lt;= arr1.length, arr2.length, arr3.length &lt;= 1000</code></li>
	<li><code>1 &lt;= arr1[i], arr2[i], arr3[i] &lt;= 2000</code></li>
</ol>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def arraysIntersection(self, arr1: List[int], arr2: List[int], arr3: List[int]) -> List[int]:
        n1, n2, n3 = len(arr1), len(arr2), len(arr3)
        idx1, idx2, idx3 = 0, 0, 0
        ans = []
        while idx1 < n1 and idx2 < n2 and idx3 < n3:
            val1, val2, val3 = arr1[idx1], arr2[idx2], arr3[idx3]
            if val1 == val2 == val3:
                ans.append(val1)
                idx1 += 1
                idx2 += 1
                idx3 += 1
            if val1 < val2 or val1 < val3:
                idx1 += 1
            if val2 < val1 or val2 < val3:
                idx2 += 1
            if val3 < val1 or val3 < val2:
                idx3 += 1
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> ans = new ArrayList<>();
        int idx1 = 0, idx2 = 0, idx3 = 0;
        int n1 = arr1.length, n2 = arr2.length, n3 = arr3.length;
        while (idx1 < n1 && idx2 < n2 && idx3 < n3) {
            int val1 = arr1[idx1], val2 = arr2[idx2], val3 = arr3[idx3];
            if (val1 == val2 && val2 == val3) {
                ans.add(val1);
                idx1++;
                idx2++;
                idx3++;
            }
            if (val1 < val2 || val1 < val3) {
                idx1++;
            }
            if (val2 < val1 || val2 < val3) {
                idx2++;
            }
            if (val3 < val1 || val3 < val2) {
                idx3++;
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
