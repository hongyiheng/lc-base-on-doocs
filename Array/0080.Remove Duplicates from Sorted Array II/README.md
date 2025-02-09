# [80. 删除有序数组中的重复项 II](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个有序数组 <code>nums</code> ，请你<strong><a href="http://baike.baidu.com/item/%E5%8E%9F%E5%9C%B0%E7%AE%97%E6%B3%95" target="_blank"> 原地</a></strong> 删除重复出现的元素，使每个元素 <strong>最多出现两次</strong> ，返回删除后数组的新长度。</p>

<p>不要使用额外的数组空间，你必须在 <strong><a href="https://baike.baidu.com/item/%E5%8E%9F%E5%9C%B0%E7%AE%97%E6%B3%95" target="_blank">原地 </a>修改输入数组 </strong>并在使用 O(1) 额外空间的条件下完成。</p>

<p> </p>

<p><strong>说明：</strong></p>

<p>为什么返回数值是整数，但输出的答案是数组呢？</p>

<p>请注意，输入数组是以<strong>「引用」</strong>方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。</p>

<p>你可以想象内部操作如下:</p>

<pre>
// <strong>nums</strong> 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
int len = removeDuplicates(nums);

// 在函数里修改输入数组对于调用者是可见的。
// 根据你的函数返回的长度, 它会打印出数组中<strong> 该长度范围内</strong> 的所有元素。
for (int i = 0; i < len; i++) {
    print(nums[i]);
}
</pre>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,1,1,2,2,3]
<strong>输出：</strong>5, nums = [1,1,2,2,3]
<strong>解释：</strong>函数应返回新长度 length = <strong><code>5</code></strong>, 并且原数组的前五个元素被修改为 <strong><code>1, 1, 2, 2,</code></strong> <strong>3 </strong>。 不需要考虑数组中超出新长度后面的元素。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [0,0,1,1,1,1,2,3,3]
<strong>输出：</strong>7, nums = [0,0,1,1,2,3,3]
<strong>解释：</strong>函数应返回新长度 length = <strong><code>7</code></strong>, 并且原数组的前五个元素被修改为 <strong><code>0</code></strong>, <strong>0</strong>, <strong>1</strong>, <strong>1</strong>, <strong>2</strong>, <strong>3</strong>, <strong>3 。</strong> 不需要考虑数组中超出新长度后面的元素。
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= nums.length <= 3 * 10<sup>4</sup></code></li>
	<li><code>-10<sup>4</sup> <= nums[i] <= 10<sup>4</sup></code></li>
	<li><code>nums</code> 已按升序排列</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        n = len(nums)
        j = ans = 0
        for i in range(n):
            if j >= 2 and nums[j - 2] == nums[i]:
                continue
            nums[j] = nums[i]
            ans += 1
            j += 1
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int j = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            if (j >= 2 && nums[j - 2] == nums[i]) {
                continue;
            }
            nums[j++] = nums[i];
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
