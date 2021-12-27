# [825. 适龄的朋友](https://leetcode-cn.com/problems/friends-of-appropriate-ages)



## 题目描述

<!-- 这里写题目描述 -->

<p>人们会互相发送好友请求，现在给定一个包含有他们年龄的数组，<code>ages[i]</code> 表示第 i 个人的年龄。</p>

<p>当满足以下任一条件时，A 不能给 B（A、B不为同一人）发送好友请求：</p>

<ul>
	<li><code>age[B] <= 0.5 * age[A] + 7</code></li>
	<li><code>age[B] > age[A]</code></li>
	<li><code>age[B] > 100 && age[A] < 100</code></li>
</ul>

<p>否则，A 可以给 B 发送好友请求。</p>

<p>注意如果 A 向 B 发出了请求，不等于 B 也一定会向 A 发出请求。而且，人们不会给自己发送好友请求。 </p>

<p>求总共会发出多少份好友请求?</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>[16,16]
<strong>输出：</strong>2
<strong>解释：</strong>二人可以互发好友申请。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>[16,17,18]
<strong>输出：</strong>2
<strong>解释：</strong>好友请求可产生于 17 -> 16, 18 -> 17.</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>[20,30,100,110,120]
<strong>输出：</strong>3
<strong>解释：</strong>好友请求可产生于 110 -> 100, 120 -> 110, 120 -> 100.
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= ages.length <= 20000</code></li>
	<li><code>1 <= ages[i] <= 120</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def numFriendRequests(self, ages: List[int]) -> int:
        ans, n = 0, len(ages)
        ages.sort()
        
        def check(x, y):
            if y <= 0.5 * x + 7:
                return False
            if y > x:
                return False
            if y > 100 and x < 100:
                return False
            return True
        
        l, r = 0, 0
        for k in range(n):
            r = max(k, r)
            while l < k and not check(ages[l], ages[k]):
                l += 1
            while r < n and check(ages[r], ages[k]):
                r += 1
            if r > l:
                ans += r - l - 1
        return ans
            
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int ans = 0, n = ages.length;

        for (int k = 0, l = 0, r = 0; k < n; k++) {
            r = Math.max(r, k);
            while (l < k && !check(ages[l], ages[k])) {
                l++;
            }
            while (r < n && check(ages[r], ages[k])) {
                r++;
            }
            if (r > l) {
                ans += r - l - 1;
            }
        }
        return ans;
    }

    public boolean check(int x, int y) {
        if (y <= 0.5 * x + 7) {
            return false;
        }
        if (y > x) {
            return false;
        }
        if (y > 100 && x < 100) {
            return false;
        }
        return true;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
