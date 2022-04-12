# [611. 有效三角形的个数](https://leetcode-cn.com/problems/valid-triangle-number)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。</p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入:</strong> [2,2,3,4]
<strong>输出:</strong> 3
<strong>解释:</strong>
有效的组合是: 
2,3,4 (使用第一个 2)
2,3,4 (使用第二个 2)
2,2,3
</pre>

<p><strong>注意:</strong></p>

<ol>
	<li>数组长度不超过1000。</li>
	<li>数组里整数的范围为 [0, 1000]。</li>
</ol>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def triangleNumber(self, nums: List[int]) -> int:
        nums.sort()
        n, ans = len(nums), 0
        for i in range(n):
            for j in range(i + 1, n):
                left, right = j + 1, n - 1
                if left >= n:
                    continue
                while left < right:
                    mid = (left + right + 1) >> 1
                    if nums[i] + nums[j] > nums[mid]:
                        left = mid
                    else:
                        right = mid - 1
                if nums[i] + nums[j] > nums[left]:
                    ans += left - j
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int left = j + 1, right = n - 1;
                if (left >= n) {
                    continue;
                }
                while (left < right) {
                    int mid = (left + right + 1) >> 1;
                    if (nums[i] + nums[j] > nums[mid]) {
                        left = mid;
                    } else {
                        right = mid - 1;
                    }
                }
                if (nums[i] + nums[j] > nums[left]) {
                    ans += left - j;
                }
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
