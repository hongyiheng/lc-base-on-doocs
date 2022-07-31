# [2224. 转化时间需要的最少操作数](https://leetcode-cn.com/problems/minimum-number-of-operations-to-convert-time)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你两个字符串 <code>current</code> 和 <code>correct</code> ，表示两个 <strong>24 小时制时间</strong> 。</p>

<p><strong>24 小时制时间</strong> 按 <code>"HH:MM"</code> 进行格式化，其中 <code>HH</code> 在 <code>00</code> 和 <code>23</code> 之间，而 <code>MM</code> 在 <code>00</code> 和 <code>59</code> 之间。最早的 24 小时制时间为 <code>00:00</code> ，最晚的是 <code>23:59</code> 。</p>

<p>在一步操作中，你可以将 <code>current</code> 这个时间增加 <code>1</code>、<code>5</code>、<code>15</code> 或 <code>60</code> 分钟。你可以执行这一操作 <strong>任意</strong> 次数。</p>

<p>返回将&nbsp;<code>current</code><em> </em>转化为<em> </em><code>correct</code> 需要的 <strong>最少操作数</strong> 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>current = "02:30", correct = "04:35"
<strong>输出：</strong>3
<strong>解释：
</strong>可以按下述 3 步操作将 current 转换为 correct ：
- 为 current 加 60 分钟，current 变为 "03:30" 。
- 为 current 加 60 分钟，current 变为 "04:30" 。 
- 为 current 加 5 分钟，current 变为 "04:35" 。
可以证明，无法用少于 3 步操作将 current 转化为 correct 。</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>current = "11:00", correct = "11:01"
<strong>输出：</strong>1
<strong>解释：</strong>只需要为 current 加一分钟，所以最小操作数是 1 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>current</code> 和 <code>correct</code> 都符合 <code>"HH:MM"</code> 格式</li>
	<li><code>current &lt;= correct</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def convertTime(self, current: str, correct: str) -> int:
        cur = int(current.split(":")[0]) * 60 + int(current.split(":")[1])
        target = int(correct.split(":")[0]) * 60 + int(correct.split(":")[1])
        ans = 0
        while cur < target:
            diff = target - cur
            if diff >= 60:
                cur += 60
            elif diff >= 15:
                cur += 15
            elif diff >= 5:
                cur += 5
            else:
                cur += 1
            ans += 1
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int convertTime(String current, String correct) {
        int cur = Integer.parseInt(current.split(":")[0]) * 60 + Integer.parseInt(current.split(":")[1]);
        int target = Integer.parseInt(correct.split(":")[0]) * 60 + Integer.parseInt(correct.split(":")[1]);
        int ans = 0;
        while (cur < target) {
            int diff = target - cur;
            if (diff >= 60) {
                cur += 60;
            } else if (diff >= 15) {
                cur += 15;
            } else if (diff >= 5) {
                cur += 5;
            } else {
                cur++;
            }
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
