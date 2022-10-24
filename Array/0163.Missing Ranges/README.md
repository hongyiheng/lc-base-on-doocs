# [163. 缺失的区间](https://leetcode-cn.com/problems/missing-ranges)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个排序的整数数组 <em><strong>nums&nbsp;</strong></em>，其中元素的范围在&nbsp;<strong>闭区间</strong>&nbsp;<strong>[<em>lower, upper</em>]</strong>&nbsp;当中，返回不包含在数组中的缺失区间。</p>

<p><strong>示例：</strong></p>

<pre><strong>输入: </strong><strong><em>nums</em></strong> = <code>[0, 1, 3, 50, 75]</code>, <strong><em>lower</em></strong> = 0 和 <strong><em>upper</em></strong> = 99,
<strong>输出: </strong><code>[&quot;2&quot;, &quot;4-&gt;49&quot;, &quot;51-&gt;74&quot;, &quot;76-&gt;99&quot;]</code>
</pre>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def findMissingRanges(self, nums: List[int], lower: int, upper: int) -> List[str]:
        def get_str(a, b):
            if b - a <= 1:
                return None
            if b - a == 2:
                return str(a + 1)
            return str(a + 1) + "->" + str(b - 1)

        ans = []
        n, last = len(nums), lower - 1
        if n == 0:
            s = get_str(lower - 1, upper + 1)
            if s:
                ans.append(s)
            return ans
        for i in range(n):
            s = get_str(last, nums[i])
            if s:
                ans.append(s)
            last = nums[i]
        s = get_str(last, upper + 1)
        if s:
            ans.append(get_str(last, upper + 1))
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ans = new ArrayList<>();
        int n = nums.length, last = lower - 1;
        if (n == 0) {
            String s = getStr(lower - 1, upper + 1);
            if (s != null) {
                ans.add(s);
            }
            return ans;
        }
        for (int i = 0; i < n; i++) {
            String s = getStr(last, nums[i]);
            if (s != null) {
                ans.add(s);
            }
            last = nums[i];
        }
        String s = getStr(last, upper + 1);
        if (s != null) {
            ans.add(s);
        } 
        return ans;
    }

    public String getStr(int a, int b) {
        if (b - a <= 1) {
            return null;
        }
        if (b - a == 2) {
            return String.valueOf(a + 1);
        }
        return String.valueOf(a + 1) + "->" + String.valueOf(b - 1); 
    }
}
```

### **...**

```

```

<!-- tabs:end -->
