# [45. 跳跃游戏 II](https://leetcode-cn.com/problems/jump-game-ii)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个非负整数数组 <code>nums</code> ，你最初位于数组的第一个位置。</p>

<p>数组中的每个元素代表你在该位置可以跳跃的最大长度。</p>

<p>你的目标是使用最少的跳跃次数到达数组的最后一个位置。</p>

<p>假设你总是可以到达数组的最后一个位置。</p>

<p> </p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入:</strong> nums = [2,3,1,1,4]
<strong>输出:</strong> 2
<strong>解释:</strong> 跳到最后一个位置的最小跳跃数是 <code>2</code>。
     从下标为 0 跳到下标为 1 的位置，跳 <code>1</code> 步，然后跳 <code>3</code> 步到达数组的最后一个位置。
</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入:</strong> nums = [2,3,0,1,4]
<strong>输出:</strong> 2
</pre>

<p> </p>

<p><strong>提示:</strong></p>

<ul>
	<li><code>1 <= nums.length <= 10<sup>4</sup></code></li>
	<li><code>0 <= nums[i] <= 1000</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python

```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int jump(int[] nums) {
        int len = nums.length;
        int ans = 0, start = 0, end = 1;
        while (end < len) {
            int temp = 0;
            for (int i = start; i < end; i++) {
                temp = Math.max(temp, i + nums[i]);
            }
            start = end;
            end = temp + 1;
            ans++;
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
