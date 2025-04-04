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
        cnt = [0] * 121
        for v in ages:
            cnt[v] += 1
        ans = 0
        for i in range(121):
            if not cnt[i]:
                continue
            for j in range(121):
                if not cnt[j]:
                    continue
                if j <= 0.5 * i + 7 or j > i:
                    continue
                ans += cnt[i] * (cnt[j] - int(i == j))
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int numFriendRequests(int[] ages) {
        int[] cnt = new int[121];
        for (int v : ages) {
            cnt[v]++;
        }
        int ans = 0;
        for (int i = 0; i < 121; i++) {
            if (cnt[i] == 0) {
                continue;
            }
            for (int j = 0; j < 121; j++) {
                if (cnt[j] == 0) {
                    continue;
                }
                if (j <= 0.5 * i + 7 || j > i) {
                    continue;
                }
                ans += cnt[i] * (cnt[j] - (i == j ? 1 : 0));
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
