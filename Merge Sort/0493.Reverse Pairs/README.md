# [493. 翻转对](https://leetcode-cn.com/problems/reverse-pairs)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个数组&nbsp;<code>nums</code>&nbsp;，如果&nbsp;<code>i &lt; j</code>&nbsp;且&nbsp;<code>nums[i] &gt; 2*nums[j]</code>&nbsp;我们就将&nbsp;<code>(i, j)</code>&nbsp;称作一个<strong><em>重要翻转对</em></strong>。</p>

<p>你需要返回给定数组中的重要翻转对的数量。</p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入</strong>: [1,3,2,3,1]
<strong>输出</strong>: 2
</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入</strong>: [2,4,3,5,1]
<strong>输出</strong>: 3
</pre>

<p><strong>注意:</strong></p>

<ol>
	<li>给定数组的长度不会超过<code>50000</code>。</li>
	<li>输入数组中的所有数字都在32位整数的表示范围内。</li>
</ol>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def reversePairs(self, nums: List[int]) -> int:
        def sort(nums, tmp, left, right):
            if left >= right:
                return
            mid = (left + right) >> 1
            sort(nums, tmp, left, mid)
            sort(nums, tmp, mid + 1, right)
            merge(nums, tmp, left, right, mid)
        
        def merge(nums, tmp, left, right, mid):
            nonlocal ans
            l, r, t = left, mid + 1, left
            while l <= mid and r <= right:
                if nums[l] <= 2 * nums[r]:
                    l += 1
                else:
                    ans += mid - l + 1
                    r += 1
            l, r, t = left, mid + 1, left
            while l <= mid or r <= right:
                if r > right or (l <= mid and nums[l] <= nums[r]):
                    tmp[t] = nums[l]
                    l += 1
                else:
                    tmp[t] = nums[r]
                    r += 1
                t += 1
            for i in range(left, right + 1):
                nums[i] = tmp[i]
        
        n = len(nums)
        tmp = [0] * n
        ans = 0
        sort(nums, tmp, 0, n - 1)
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    int ans = 0;

    public int reversePairs(int[] nums) {
        int n = nums.length;
        int[] tmp = new int[n];
        sort(nums, tmp, 0, n - 1);
        return ans;
    }

    public void sort(int[] nums, int[] tmp, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) >> 1;
        sort(nums, tmp, left, mid);
        sort(nums, tmp, mid + 1, right);
        merge(nums, tmp, left, right, mid);
    }

    public void merge(int[] nums, int[] tmp, int left, int right, int mid) {
        int l = left, r = mid + 1;
        while (l <= mid && r <= right) {
            if (nums[l] <= 2L * nums[r]) {
                l++;
            } else {
                ans += mid - l + 1;
                r++;
            }  
        }
        l = left;
        r = mid + 1;
        int t = left;
        while (l <= mid || r <= right) {
            if (r > right || (l <= mid && nums[l] <= nums[r])) {
                tmp[t++] = nums[l++];
            } else {
                tmp[t++] = nums[r++];
            }
        }
        for (int i = left; i <= right; i++) {
            nums[i] = tmp[i];
        }
    }
}
```

### **...**

```

```

<!-- tabs:end -->
