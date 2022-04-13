# [658. 找到 K 个最接近的元素](https://leetcode-cn.com/problems/find-k-closest-elements)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个排序好的数组 <code>arr</code> ，两个整数 <code>k</code> 和 <code>x</code> ，从数组中找到最靠近 <code>x</code>（两数之差最小）的 <code>k</code> 个数。返回的结果必须要是按升序排好的。</p>

<p>整数 <code>a</code> 比整数 <code>b</code> 更接近 <code>x</code> 需要满足：</p>

<ul>
	<li><code>|a - x| < |b - x|</code> 或者</li>
	<li><code>|a - x| == |b - x|</code> 且 <code>a < b</code></li>
</ul>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>arr = [1,2,3,4,5], k = 4, x = 3
<strong>输出：</strong>[1,2,3,4]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>arr = [1,2,3,4,5], k = 4, x = -1
<strong>输出：</strong>[1,2,3,4]
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= k <= arr.length</code></li>
	<li><code>1 <= arr.length <= 10<sup>4</sup></code></li>
	<li>数组里的每个元素与 <code>x</code> 的绝对值不超过 <code>10<sup>4</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        def check(a, b):
            nonlocal x
            return abs(a - x) < abs(b - x) or (abs(a - x) == abs(b - x) and a < b)
        
        n = len(arr)
        if k >= n:
            return arr
        left, right = 0, n - 1
        while left < right:
            mid = (left + right) >> 1
            if arr[mid] < x:
                left = mid + 1
            else:
                right = mid
        if left > 0 and check(arr[left - 1], arr[left]):
            left = left - 1
        a, b = left, left
        k -= 1
        while k > 0:
            if a > 0 and b < n - 1:
                if check(arr[a - 1], arr[b + 1]):
                    a -= 1
                else:
                    b += 1
            elif a > 0:
                a -= 1
            else:
                b += 1
            k -= 1
        return arr[a:b + 1]
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    int x;

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        this.x = x;
        List<Integer> ans = new ArrayList<>();
        if (n <= k) {
            for (int num : arr) {
                ans.add(num);
            }
            return ans;
        }
        int left = 0, right = n - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (arr[mid] < x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (left > 0 && check(arr[left - 1], arr[left])) {
            left = left - 1; 
        }
        int a = left, b = left;
        while (--k > 0) {
            if (a > 0 && b < n - 1) {
                if (check(arr[--a], arr[++b])) {
                    --b;
                } else {
                    ++a;
                }
            } else if (a > 0) {
                --a;
            } else {
                ++b;
            }
        }
        for (int i = a; i <= b; i++) {
            ans.add(arr[i]);
        }
        return ans;
    }


    public boolean check(int a, int b) {
        return Math.abs(a - x) < Math.abs(b - x)
        || (Math.abs(a - x) == Math.abs(b - x) && a < b);
    }
}
```

### **...**

```

```

<!-- tabs:end -->
