# [855. 考场就座](https://leetcode-cn.com/problems/exam-room)



## 题目描述

<!-- 这里写题目描述 -->

<p>在考场里，一排有&nbsp;<code>N</code>&nbsp;个座位，分别编号为&nbsp;<code>0, 1, 2, ..., N-1</code>&nbsp;。</p>

<p>当学生进入考场后，他必须坐在能够使他与离他最近的人之间的距离达到最大化的座位上。如果有多个这样的座位，他会坐在编号最小的座位上。(另外，如果考场里没有人，那么学生就坐在 0 号座位上。)</p>

<p>返回&nbsp;<code>ExamRoom(int N)</code>&nbsp;类，它有两个公开的函数：其中，函数&nbsp;<code>ExamRoom.seat()</code>&nbsp;会返回一个&nbsp;<code>int</code>&nbsp;（整型数据），代表学生坐的位置；函数&nbsp;<code>ExamRoom.leave(int p)</code>&nbsp;代表坐在座位 <code>p</code> 上的学生现在离开了考场。每次调用&nbsp;<code>ExamRoom.leave(p)</code>&nbsp;时都保证有学生坐在座位&nbsp;<code>p</code>&nbsp;上。</p>

<p>&nbsp;</p>

<p><strong>示例：</strong></p>

<pre><strong>输入：</strong>[&quot;ExamRoom&quot;,&quot;seat&quot;,&quot;seat&quot;,&quot;seat&quot;,&quot;seat&quot;,&quot;leave&quot;,&quot;seat&quot;], [[10],[],[],[],[],[4],[]]
<strong>输出：</strong>[null,0,9,4,2,null,5]
<strong>解释：</strong>
ExamRoom(10) -&gt; null
seat() -&gt; 0，没有人在考场里，那么学生坐在 0 号座位上。
seat() -&gt; 9，学生最后坐在 9 号座位上。
seat() -&gt; 4，学生最后坐在 4 号座位上。
seat() -&gt; 2，学生最后坐在 2 号座位上。
leave(4) -&gt; null
seat() -&gt; 5，学生最后坐在 5 号座位上。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ol>
	<li><code>1 &lt;= N &lt;= 10^9</code></li>
	<li>在所有的测试样例中&nbsp;<code>ExamRoom.seat()</code>&nbsp;和&nbsp;<code>ExamRoom.leave()</code>&nbsp;最多被调用&nbsp;<code>10^4</code>&nbsp;次。</li>
	<li>保证在调用&nbsp;<code>ExamRoom.leave(p)</code>&nbsp;时有学生正坐在座位 <code>p</code> 上。</li>
</ol>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
from sortedcontainers import SortedList

class ExamRoom:

    def __init__(self, n: int):
        self.q = SortedList(key=lambda x: x)
        self.n = n


    def seat(self) -> int:
        if len(self.q) == 0:
            self.q.add(0)
            return 0
        elif len(self.q) == 1:
            x = self.q[0]
            ans = 0 if x - 0 > self.n - 1 - x else self.n - 1
            self.q.add(ans)
            return ans
        pre = self.q[0]
        d, ans = pre, 0
        for x in self.q:
            if d < (x - pre) // 2:
                d = (x - pre) // 2
                ans = (x + pre) // 2
            pre = x
        if d < self.n - 1 - pre:
            ans = self.n - 1
        self.q.add(ans)
        return ans


    def leave(self, p: int) -> None:
        self.q.remove(p)



# Your ExamRoom object will be instantiated and called as such:
# obj = ExamRoom(n)
# param_1 = obj.seat()
# obj.leave(p)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class ExamRoom {

    TreeSet<Integer> s;
    int n;

    public ExamRoom(int n) {
        this.n = n;
        s = new TreeSet<>();
    }

    public int seat() {
        if (s.size() == 0) {
            s.add(0);
            return 0;
        } else if (s.size() == 1) {
            int x = s.first();
            int ans = x > n - 1 - x ? 0 : n - 1;
            s.add(ans);
            return ans;
        }
        int pre = s.first();
        int d = pre, ans = 0;
        for (int x : s) {
            if (d < (x - pre) / 2) {
                d = (x - pre) / 2;
                ans = (x + pre) / 2;
            }
            pre = x;
        }
        if (d < n - 1 - pre) {
            ans = n - 1;
        }
        s.add(ans);
        return ans;
    }

    public void leave(int p) {
        s.remove(p);
    }
}


/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(n);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */
```

### **...**

```

```

<!-- tabs:end -->
