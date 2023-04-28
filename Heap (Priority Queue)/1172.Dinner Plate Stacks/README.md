# [1172. 餐盘栈](https://leetcode-cn.com/problems/dinner-plate-stacks)



## 题目描述

<!-- 这里写题目描述 -->

<p>我们把无限数量 &infin; 的栈排成一行，按从左到右的次序从 0 开始编号。每个栈的的最大容量&nbsp;<code>capacity</code> 都相同。</p>

<p>实现一个叫「餐盘」的类&nbsp;<code>DinnerPlates</code>：</p>

<ul>
	<li><code>DinnerPlates(int capacity)</code>&nbsp;- 给出栈的最大容量&nbsp;<code>capacity</code>。</li>
	<li><code>void push(int val)</code>&nbsp;- 将给出的正整数&nbsp;<code>val</code>&nbsp;推入&nbsp;<strong>从左往右第一个&nbsp;</strong>没有满的栈。</li>
	<li><code>int pop()</code>&nbsp;- 返回&nbsp;<strong>从右往左第一个&nbsp;</strong>非空栈顶部的值，并将其从栈中删除；如果所有的栈都是空的，请返回&nbsp;<code>-1</code>。</li>
	<li><code>int popAtStack(int index)</code>&nbsp;- 返回编号&nbsp;<code>index</code>&nbsp;的栈顶部的值，并将其从栈中删除；如果编号&nbsp;<code>index</code>&nbsp;的栈是空的，请返回 <code>-1</code>。</li>
</ul>

<p>&nbsp;</p>

<p><strong>示例：</strong></p>

<pre><strong>输入： </strong>
[&quot;DinnerPlates&quot;,&quot;push&quot;,&quot;push&quot;,&quot;push&quot;,&quot;push&quot;,&quot;push&quot;,&quot;popAtStack&quot;,&quot;push&quot;,&quot;push&quot;,&quot;popAtStack&quot;,&quot;popAtStack&quot;,&quot;pop&quot;,&quot;pop&quot;,&quot;pop&quot;,&quot;pop&quot;,&quot;pop&quot;]
[[2],[1],[2],[3],[4],[5],[0],[20],[21],[0],[2],[],[],[],[],[]]
<strong>输出：</strong>
[null,null,null,null,null,null,2,null,null,20,21,5,4,3,1,-1]

<strong>解释：</strong>
DinnerPlates D = DinnerPlates(2);  // 初始化，栈最大容量 capacity = 2
D.push(1);
D.push(2);
D.push(3);
D.push(4);
D.push(5);         // 栈的现状为：    2 &nbsp;4
&nbsp;                                   1 &nbsp;3 &nbsp;5
                                    ﹈ ﹈ ﹈
D.popAtStack(0);   // 返回 2。栈的现状为：     &nbsp;4
            &nbsp;                             1 &nbsp;3 &nbsp;5
                                          ﹈ ﹈ ﹈
D.push(20);        // 栈的现状为：  20  4
&nbsp;                                  1 &nbsp;3 &nbsp;5
                                   ﹈ ﹈ ﹈
D.push(21);        // 栈的现状为：  20  4 21
&nbsp;                                  1 &nbsp;3 &nbsp;5
                                   ﹈ ﹈ ﹈
D.popAtStack(0);   // 返回 20。栈的现状为：       4 21
             &nbsp;                              1 &nbsp;3 &nbsp;5
                                            ﹈ ﹈ ﹈
D.popAtStack(2);   // 返回 21。栈的现状为：       4
             &nbsp;                              1 &nbsp;3 &nbsp;5
                                            ﹈ ﹈ ﹈ 
D.pop()            // 返回 5。栈的现状为：        4
             &nbsp;                              1 &nbsp;3 
                                            ﹈ ﹈  
D.pop()            // 返回 4。栈的现状为：    1  3 
                                           ﹈ ﹈   
D.pop()            // 返回 3。栈的现状为：    1 
                                           ﹈   
D.pop()            // 返回 1。现在没有栈。
D.pop()            // 返回 -1。仍然没有栈。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= capacity&nbsp;&lt;= 20000</code></li>
	<li><code>1 &lt;= val&nbsp;&lt;= 20000</code></li>
	<li><code>0 &lt;= index&nbsp;&lt;= 100000</code></li>
	<li>最多会对&nbsp;<code>push</code>，<code>pop</code>，和&nbsp;<code>popAtStack</code>&nbsp;进行 <code>200000</code> 次调用。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class DinnerPlates:

    def __init__(self, capacity: int):
        self.cap = capacity
        self.q = []
        self.add_ids = []

    def push(self, val: int) -> None:
        index = len(self.q)
        if self.add_ids:
            index = heapq.heappop(self.add_ids)
        if index < len(self.q):
            self.q[index].append(val)
        else:
            self.q.append([val])
        if len(self.q[index]) < self.cap:
            heapq.heappush(self.add_ids, index)

    def pop(self) -> int:
        return self.popAtStack(len(self.q) - 1)

    def popAtStack(self, index: int) -> int:
        if index < 0 or index >= len(self.q) or not self.q[index]:
            return -1
        if len(self.q[index]) == self.cap:
            heapq.heappush(self.add_ids, index)
        ans = self.q[index].pop()
        while self.q and not self.q[-1]:
            self.add_ids.remove(len(self.q) - 1)
            self.q.pop()
        return ans

# Your DinnerPlates object will be instantiated and called as such:
# obj = DinnerPlates(capacity)
# obj.push(val)
# param_2 = obj.pop()
# param_3 = obj.popAtStack(index)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class DinnerPlates {

    PriorityQueue<Integer> addIds = new PriorityQueue<>((a, b) -> a - b);
    List<Deque<Integer>> q = new ArrayList<>();
    int cap;

    public DinnerPlates(int capacity) {
        cap = capacity;
    }

    public void push(int val) {
        int index = q.size();
        if (!addIds.isEmpty()) {
            index = addIds.poll();
        }
        if (index < q.size()) {
            q.get(index).addLast(val);
        } else {
            Deque<Integer> tmp = new ArrayDeque<>();
            tmp.addLast(val);
            q.add(tmp);
        }
        if (q.get(index).size() < cap) {
            addIds.add(index);
        }
    }

    public int pop() {
        return popAtStack(q.size() - 1);
    }

    public int popAtStack(int index) {
        if (index < 0 || index >= q.size() || q.get(index).isEmpty()) {
            return -1;
        }
        if (q.get(index).size() == cap) {
            addIds.add(index);
        }
        int ans = q.get(index).pollLast();
        while (!q.isEmpty() && q.get(q.size() - 1).isEmpty()) {
            q.remove(q.size() - 1);
        }
        return ans;
    }
}

/**
 * Your DinnerPlates object will be instantiated and called as such:
 * DinnerPlates obj = new DinnerPlates(capacity);
 * obj.push(val);
 * int param_2 = obj.pop();
 * int param_3 = obj.popAtStack(index);
 */
```

### **...**

```

```

<!-- tabs:end -->
