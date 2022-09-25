# [788. 旋转数字](https://leetcode-cn.com/problems/rotated-digits)



## 题目描述

<!-- 这里写题目描述 -->

<p>我们称一个数 X 为好数, 如果它的每位数字逐个地被旋转 180 度后，我们仍可以得到一个有效的，且和 X 不同的数。要求每位数字都要被旋转。</p>

<p>如果一个数的每位数字被旋转以后仍然还是一个数字，&nbsp;则这个数是有效的。0, 1, 和 8 被旋转后仍然是它们自己；2 和 5 可以互相旋转成对方（在这种情况下，它们以不同的方向旋转，换句话说，2 和 5 互为镜像）；6 和 9 同理，除了这些以外其他的数字旋转以后都不再是有效的数字。</p>

<p>现在我们有一个正整数&nbsp;<code>N</code>, 计算从&nbsp;<code>1</code> 到&nbsp;<code>N</code> 中有多少个数&nbsp;X 是好数？</p>

<p>&nbsp;</p>

<p><strong>示例：</strong></p>

<pre><strong>输入:</strong> 10
<strong>输出:</strong> 4
<strong>解释:</strong> 
在[1, 10]中有四个好数： 2, 5, 6, 9。
注意 1 和 10 不是好数, 因为他们在旋转之后不变。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li>N&nbsp;的取值范围是&nbsp;<code>[1, 10000]</code>。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def rotatedDigits(self, n: int) -> int:
        nums = [0, 1, 2, 5, 6, 8, 9]
        valid = [2, 5, 6, 9]
        ans = 0
        for i in range(n + 1):
            cur = i
            flag = False
            while cur > 0:
                if cur % 10 not in nums:
                    break
                if cur % 10 in valid:
                    flag = True
                cur //= 10
            if cur <= 0 and flag:
                ans += 1
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int rotatedDigits(int n) {
        Set<Integer> nums = new HashSet<>(), valid = new HashSet<>();
        for (int v : new int[]{0, 1, 2, 5, 6, 8, 9}) {
            nums.add(v);
        }
        for (int v : new int[]{2, 5, 6, 9}) {
            valid.add(v);
        }
        int ans = 0;
        for (int i = 0; i < n + 1; i++) {
            int cur = i;
            boolean flag = false;
            while (cur > 0) {
                if (!nums.contains(cur % 10)) {
                    break;
                }
                if (valid.contains(cur % 10)) {
                    flag = true;
                }
                cur /= 10;
            }
            if (cur <= 0 && flag) {
                ans++;
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
