# [281. 锯齿迭代器](https://leetcode-cn.com/problems/zigzag-iterator)



## 题目描述

<!-- 这里写题目描述 -->

<p>给出两个一维的向量，请你实现一个迭代器，交替返回它们中间的元素。</p>

<p><strong>示例:</strong></p>

<pre><strong>输入:</strong>
v1 = [1,2]
v2 = [3,4,5,6] 

<strong>输出:</strong> <code>[1,3,2,4,5,6]

<strong>解析:</strong></code>&nbsp;通过连续调用 <em>next</em> 函数直到 <em>hasNext</em> 函数返回 <code>false，</code>
&nbsp;    <em>next</em> 函数返回值的次序应依次为: <code>[1,3,2,4,5,6]。</code></pre>

<p><strong>拓展：</strong>假如给你&nbsp;<code>k</code>&nbsp;个一维向量呢？你的代码在这种情况下的扩展性又会如何呢?</p>

<p><strong>拓展声明：</strong><br>
&nbsp;&ldquo;锯齿&rdquo; 顺序对于&nbsp;<code>k &gt; 2</code>&nbsp;的情况定义可能会有些歧义。所以，假如你觉得 &ldquo;锯齿&rdquo; 这个表述不妥，也可以认为这是一种&nbsp;&ldquo;循环&rdquo;。例如：</p>

<pre><strong>输入:</strong>
[1,2,3]
[4,5,6,7]
[8,9]

<strong>输出: </strong><code>[1,4,8,2,5,9,3,6,7]</code>.
</pre>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class ZigzagIterator:
    def __init__(self, v1: List[int], v2: List[int]):
        self.q1 = v1
        self.q2 = v2
        self.change = False
        
    def next(self) -> int:
        self.change = not self.change
        if self.q1:
            if self.q2:
                return self.q1.pop(0) if self.change else self.q2.pop(0)
            return self.q1.pop(0)
        return self.q2.pop(0)
        

    def hasNext(self) -> bool:
        return self.q1 or self.q2

# Your ZigzagIterator object will be instantiated and called as such:
# i, v = ZigzagIterator(v1, v2), []
# while i.hasNext(): v.append(i.next())
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
public class ZigzagIterator {
    Deque<Integer> q1;
    Deque<Integer> q2;
    boolean change = false;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        q1 = new ArrayDeque<>();
        q2 = new ArrayDeque<>();
        q1.addAll(v1);
        q2.addAll(v2);
    }

    public int next() {
        change = !change;
        if (!q1.isEmpty()) {
            if (!q2.isEmpty()) {
                return change ? q1.pollFirst() : q2.pollFirst();
            } else {
                return q1.pollFirst();
            }
        }
        return q2.pollFirst();
    }

    public boolean hasNext() {
        return !q1.isEmpty() || !q2.isEmpty();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
```

### **...**

```

```

<!-- tabs:end -->
