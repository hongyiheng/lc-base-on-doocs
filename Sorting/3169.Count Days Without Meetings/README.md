# [3169. 无需开会的工作日](https://leetcode.cn/problems/count-days-without-meetings)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个正整数 <code>days</code>，表示员工可工作的总天数（从第 1 天开始）。另给你一个二维数组 <code>meetings</code>，长度为 <code>n</code>，其中 <code>meetings[i] = [start_i, end_i]</code> 表示第 <code>i</code> 次会议的开始和结束天数（包含首尾）。</p>

<p>返回员工可工作且没有安排会议的天数。</p>

<p><strong>注意：</strong>会议时间可能会有重叠。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<div class="example-block">
<p><strong>输入：</strong><span class="example-io">days = 10, meetings = [[5,7],[1,3],[9,10]]</span></p>

<p><strong>输出：</strong><span class="example-io">2</span></p>

<p><strong>解释：</strong></p>

<p>第 4 天和第 8 天没有安排会议。</p>
</div>

<p><strong class="example">示例 2：</strong></p>

<div class="example-block">
<p><strong>输入：</strong><span class="example-io">days = 5, meetings = [[2,4],[1,3]]</span></p>

<p><strong>输出：</strong><span class="example-io">1</span></p>

<p><strong>解释：</strong></p>

<p>第 5 天没有安排会议。</p>
</div>

<p><strong class="example">示例 3：</strong></p>

<div class="example-block">
<p><strong>输入：</strong><span class="example-io">days = 6, meetings = [[1,6]]</span></p>

<p><strong>输出：</strong>0</p>

<p><strong>解释：</strong></p>

<p>所有工作日都安排了会议。</p>
</div>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= days &lt;= 10<sup>9</sup></code></li>
	<li><code>1 &lt;= meetings.length &lt;= 10<sup>5</sup></code></li>
	<li><code>meetings[i].length == 2</code></li>
	<li><code>1 &lt;= meetings[i][0] &lt;= meetings[i][1] &lt;= days</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def countDays(self, days: int, meetings: List[List[int]]) -> int:
        meetings.sort(key=lambda x:(x[0], -x[1]))
        ans = mx = 0
        for u, v in meetings:
            if u > mx + 1:
                ans += u - mx - 1
            mx = max(mx, v)
        return ans if mx >= days else ans + days - mx
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);
        int ans = 0, mx = 0;
        for (int[] e : meetings) {
            int u = e[0], v = e[1];
            if (u > mx + 1) {
                ans += u - mx - 1;
            }
            mx = Math.max(mx, v);
        }
        return mx >= days ? ans : ans + days - mx;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
