# [1574. 删除最短的子数组使剩余数组有序](https://leetcode-cn.com/problems/shortest-subarray-to-be-removed-to-make-array-sorted)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个整数数组 <code>arr</code>&nbsp;，请你删除一个子数组（可以为空），使得 <code>arr</code>&nbsp;中剩下的元素是 <strong>非递减</strong> 的。</p>

<p>一个子数组指的是原数组中连续的一个子序列。</p>

<p>请你返回满足题目要求的最短子数组的长度。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>arr = [1,2,3,10,4,2,3,5]
<strong>输出：</strong>3
<strong>解释：</strong>我们需要删除的最短子数组是 [10,4,2] ，长度为 3 。剩余元素形成非递减数组 [1,2,3,3,5] 。
另一个正确的解为删除子数组 [3,10,4] 。</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>arr = [5,4,3,2,1]
<strong>输出：</strong>4
<strong>解释：</strong>由于数组是严格递减的，我们只能保留一个元素。所以我们需要删除长度为 4 的子数组，要么删除 [5,4,3,2]，要么删除 [4,3,2,1]。
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>arr = [1,2,3]
<strong>输出：</strong>0
<strong>解释：</strong>数组已经是非递减的了，我们不需要删除任何元素。
</pre>

<p><strong>示例 4：</strong></p>

<pre>
<strong>输入：</strong>arr = [1]
<strong>输出：</strong>0
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= arr.length &lt;= 10^5</code></li>
	<li><code>0 &lt;= arr[i] &lt;= 10^9</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def findLengthOfShortestSubarray(self, arr: List[int]) -> int:
        n = len(arr)
        left_end, right_start = 0, n - 1
        while left_end < n - 1 and arr[left_end] <= arr[left_end + 1]:
            left_end += 1
        if left_end == n - 1:
            return 0
        while right_start > 1 and arr[right_start] >= arr[right_start - 1]:
            right_start -= 1
        if arr[right_start] >= arr[left_end]:
            return right_start - left_end - 1
        ans = min(right_start, n - left_end - 1)
        for i in range(left_end + 1):
            left, right = right_start, n - 1
            while left < right:
                mid = (left + right) >> 1
                if arr[mid] >= arr[i]:
                    right = mid
                else:
                    left = mid + 1
            if arr[left] < arr[i]:
                break
            ans = min(ans, left - i - 1)     
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int leftEnd = 0, rightStart = n - 1;
        while (leftEnd < n - 1 && arr[leftEnd] <= arr[leftEnd + 1]) {
            leftEnd++;
        }
        if (leftEnd == n - 1) {
            return 0;
        }
        while (rightStart > 1 && arr[rightStart] >= arr[rightStart - 1]) {
            rightStart--;
        }
        if (arr[leftEnd] < arr[rightStart]) {
            return rightStart - leftEnd - 1;
        }
        int ans = Math.min(rightStart, n - leftEnd - 1);
        for (int i = 0; i <= leftEnd; i++) {
            int left = rightStart, right = n - 1;
            while (left < right) {
                int mid = (left + right) >> 1;
                if (arr[mid] >= arr[i]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            if (arr[left] < arr[i]) {
                break;
            }
            ans = Math.min(ans, left - i - 1);
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
