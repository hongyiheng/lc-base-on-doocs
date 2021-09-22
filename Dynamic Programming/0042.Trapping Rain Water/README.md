# [42. 接雨水](https://leetcode-cn.com/problems/trapping-rain-water)

[English Version](/solution/0000-0099/0042.Trapping%20Rain%20Water/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->

<p>给定 <em>n</em> 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<p><img src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/22/rainwatertrap.png" style="height: 161px; width: 412px;" /></p>

<pre>
<strong>输入：</strong>height = [0,1,0,2,1,0,1,3,2,1,2,1]
<strong>输出：</strong>6
<strong>解释：</strong>上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>height = [4,2,0,3,2,5]
<strong>输出：</strong>9
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>n == height.length</code></li>
	<li><code>0 <= n <= 3 * 10<sup>4</sup></code></li>
	<li><code>0 <= height[i] <= 10<sup>5</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def trap(self, height: List[int]) -> int:
        n = len(height)
        lmx, rmx = [height[0]] * n, [height[n - 1]] * n
        for i in range(1, n):
            lmx[i] = max(lmx[i - 1], height[i])
            rmx[n - 1 - i] = max(rmx[n - i], height[n - 1 - i])

        ans = 0
        for i in range(n):
            ans += min(lmx[i], rmx[i]) - height[i]
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int trap(int[] height) {
        int area = 0;
        int leftMax = height[0];
        int[] leftMaxArray = new int[height.length];
        for (int i = 1; i < height.length; i++) {
            leftMax = Math.max(height[i], leftMax);
            leftMaxArray[i] = leftMax;
        }
        int rightMax = height[height.length - 1];
        int[] rightMaxArray = new int[height.length];
        for (int i = height.length - 2; i >= 0; i--) {
            rightMax = Math.max(height[i], rightMax);
            rightMaxArray[i] = rightMax;
        }

        for (int i = 1; i < height.length - 1; i++) {
            if (leftMaxArray[i] > height[i] && rightMaxArray[i] > height[i]) {
                area += Math.min(leftMaxArray[i], rightMaxArray[i]) - height[i];
            }
        }
        return area;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
