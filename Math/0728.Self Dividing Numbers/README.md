# [728. 自除数](https://leetcode-cn.com/problems/self-dividing-numbers)



## 题目描述

<!-- 这里写题目描述 -->

<p><em>自除数&nbsp;</em>是指可以被它包含的每一位数除尽的数。</p>

<p>例如，128 是一个自除数，因为&nbsp;<code>128 % 1 == 0</code>，<code>128 % 2 == 0</code>，<code>128 % 8 == 0</code>。</p>

<p>还有，自除数不允许包含 0 。</p>

<p>给定上边界和下边界数字，输出一个列表，列表的元素是边界（含边界）内所有的自除数。</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong> 
上边界left = 1, 下边界right = 22
<strong>输出：</strong> [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
</pre>

<p><strong>注意：</strong></p>

<ul>
	<li>每个输入参数的边界满足&nbsp;<code>1 &lt;= left &lt;= right &lt;= 10000</code>。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def selfDividingNumbers(self, left: int, right: int) -> List[int]:
        def check(num):
            tmp = num
            while tmp:
                v = tmp % 10
                if v == 0:
                    return False
                if num % v == 0:
                    tmp //= 10
                else:
                    return False
            return True
        
        ans = []
        for i in range(left, right + 1):
            if check(i):
                ans.append(i)
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (check(i)) {
                ans.add(i);
            }
        }
        return ans;
    }

    public boolean check(int num) {
        int tmp = num;
        while (tmp > 0) {
            int v = tmp % 10;
            if (v == 0) {
                return false;
            }
            if (num % v == 0) {
                tmp /= 10;
            } else {
                return false;
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
