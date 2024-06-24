# [659. 分割数组为连续子序列](https://leetcode-cn.com/problems/split-array-into-consecutive-subsequences)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个按升序排序的整数数组 <code>num</code>（可能包含重复数字），请你将它们分割成一个或多个长度至少为 3 的子序列，其中每个子序列都由连续整数组成。</p>

<p>如果可以完成上述分割，则返回 <code>true</code> ；否则，返回 <code>false</code> 。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入:</strong> [1,2,3,3,4,5]
<strong>输出:</strong> True
<strong>解释:</strong>
你可以分割出这样两个连续子序列 : 
1, 2, 3
3, 4, 5
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入:</strong> [1,2,3,3,4,4,5,5]
<strong>输出:</strong> True
<strong>解释:</strong>
你可以分割出这样两个连续子序列 : 
1, 2, 3, 4, 5
3, 4, 5
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入:</strong> [1,2,3,4,4,5]
<strong>输出:</strong> False
</pre>

<p> </p>

<p><b>提示：</b></p>

<ul>
	<li><code>1 <= nums.length <= 10000</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def isPossible(self, nums: List[int]) -> bool:
        cnt, tail = defaultdict(int), defaultdict(int)
        for v in nums:
            cnt[v] += 1
        for i in range(-1000, 1000):
            while cnt[i]:
                if tail[i - 1]:
                    tail[i - 1] -= 1
                    tail[i] += 1
                    cnt[i] -= 1
                elif cnt[i + 1] and cnt[i + 2]:
                    cnt[i] -= 1
                    cnt[i + 1] -= 1
                    cnt[i + 2] -= 1
                    tail[i + 2] += 1
                else:
                    return False
        return True
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>(), tail = new HashMap<>();
        for (int v : nums) {
            cnt.put(v, cnt.getOrDefault(v, 0) + 1);
        }
        for (int i = -1000; i < 1001; i++) {
            while (cnt.getOrDefault(i, 0) > 0) {
                if (tail.getOrDefault(i - 1, 0) > 0) {
                    tail.put(i - 1, tail.get(i - 1) - 1);
                    tail.put(i, tail.getOrDefault(i, 0) + 1);
                    cnt.put(i, cnt.get(i) - 1);
                } else if (cnt.getOrDefault(i + 1, 0) > 0 && cnt.getOrDefault(i + 2, 0) > 0) {
                    cnt.put(i, cnt.get(i) - 1);
                    cnt.put(i + 1, cnt.get(i + 1) - 1);
                    cnt.put(i + 2, cnt.get(i + 2) - 1);
                    tail.put(i + 2, tail.getOrDefault(i + 2, 0) + 1);
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
