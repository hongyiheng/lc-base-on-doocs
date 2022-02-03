# [1414. 和为 K 的最少斐波那契数字数目](https://leetcode-cn.com/problems/find-the-minimum-number-of-fibonacci-numbers-whose-sum-is-k)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你数字 <code>k</code>&nbsp;，请你返回和为&nbsp;<code>k</code>&nbsp;的斐波那契数字的最少数目，其中，每个斐波那契数字都可以被使用多次。</p>

<p>斐波那契数字定义为：</p>

<ul>
	<li>F<sub>1</sub> = 1</li>
	<li>F<sub>2</sub> = 1</li>
	<li>F<sub>n</sub> = F<sub>n-1</sub> + F<sub>n-2</sub>&nbsp;， 其中 n &gt; 2 。</li>
</ul>

<p>数据保证对于给定的 <code>k</code>&nbsp;，一定能找到可行解。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>k = 7
<strong>输出：</strong>2 
<strong>解释：</strong>斐波那契数字为：1，1，2，3，5，8，13，&hellip;&hellip;
对于 k = 7 ，我们可以得到 2 + 5 = 7 。</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>k = 10
<strong>输出：</strong>2 
<strong>解释：</strong>对于 k = 10 ，我们可以得到 2 + 8 = 10 。
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>k = 19
<strong>输出：</strong>3 
<strong>解释：</strong>对于 k = 19 ，我们可以得到 1 + 5 + 13 = 19 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= k &lt;= 10^9</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def findMinFibonacciNumbers(self, k: int) -> int:
        nums = [1]
        a, b = 1, 1
        while b < k:
            c = a + b
            nums.append(c)
            a = b
            b = c
        
        def find_smaller():
            left, right = 0, len(nums) - 1
            while left < right:
                mid = (left + right + 1) >> 1
                if nums[mid] <= k:
                    left = mid
                else:
                    right = mid - 1
            return nums[left]
        
        ans = 0
        while k > 0:
            k -= find_smaller()
            ans += 1
        return ans

```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int findMinFibonacciNumbers(int k) {
        List<Integer> nums = new ArrayList<>();
        int a = 1, b = 1;
        nums.add(1);
        while (b <= k) {
            int c = a + b;
            nums.add(c);
            a = b;
            b = c;
        }
        int ans = 0;
        while (k > 0) {
            k -= findSmaller(nums, k);
            ans++;
        }
        return ans;
    }

    public int findSmaller(List<Integer> nums, int k) {
        int left = 0, right = nums.size() - 1;
        while (left < right) {
            int mid = (left + right + 1) >> 1;
            if (nums.get(mid) <= k) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return nums.get(left);
    }
}
```

### **...**

```

```

<!-- tabs:end -->
