# [167. 两数之和 II - 输入有序数组](https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个已按照<strong><em> </em>升序排列  </strong>的整数数组 <code>numbers</code> ，请你从数组中找出两个数满足相加之和等于目标数 <code>target</code> 。</p>

<p>函数应该以长度为 <code>2</code> 的整数数组的形式返回这两个数的下标值<em>。</em><code>numbers</code> 的下标 <strong>从 1 开始计数</strong> ，所以答案数组应当满足 <code>1 <= answer[0] < answer[1] <= numbers.length</code> 。</p>

<p>你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。</p>
 

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>numbers = [2,7,11,15], target = 9
<strong>输出：</strong>[1,2]
<strong>解释：</strong>2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>numbers = [2,3,4], target = 6
<strong>输出：</strong>[1,3]
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>numbers = [-1,0], target = -1
<strong>输出：</strong>[1,2]
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>2 <= numbers.length <= 3 * 10<sup>4</sup></code></li>
	<li><code>-1000 <= numbers[i] <= 1000</code></li>
	<li><code>numbers</code> 按 <strong>递增顺序</strong> 排列</li>
	<li><code>-1000 <= target <= 1000</code></li>
	<li>仅存在一个有效答案</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        n = len(numbers)
        for i, v in enumerate(numbers):
            t = target - v
            l, r = i + 1, n - 1
            while l < r:
                mid = (l + r) >> 1
                if numbers[mid] < t:
                    l = mid + 1
                else:
                    r = mid
            if numbers[r] == t:
                return [i + 1, r + 1]
        return []
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        for (int i = 0; i < n; i++) {
            int t = target - numbers[i];
            int l = i + 1, r = n - 1;
            while (l < r) {
                int mid = (l + r) >> 1;
                if (numbers[mid] < t) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            if (numbers[r] == t) {
                return new int[]{i + 1, r + 1};
            }
        }
        return new int[2];
    }
}
```

### **...**

```

```

<!-- tabs:end -->
