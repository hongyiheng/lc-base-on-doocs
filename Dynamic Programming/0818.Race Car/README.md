# [818. 赛车](https://leetcode-cn.com/problems/race-car)



## 题目描述

<!-- 这里写题目描述 -->

<p>你的赛车起始停留在位置 0，速度为 +1，正行驶在一个无限长的数轴上。（车也可以向负数方向行驶。）</p>

<p>你的车会根据一系列由 A（加速）和 R（倒车）组成的指令进行自动驾驶 。</p>

<p>当车得到指令 "A" 时, 将会做出以下操作： <code>position += speed, speed *= 2</code>。</p>

<p>当车得到指令 "R" 时, 将会做出以下操作：如果当前速度是正数，则将车速调整为 <code>speed = -1</code> ；否则将车速调整为 <code>speed = 1</code>。  (当前所处位置不变。)</p>

<p>例如，当得到一系列指令 "AAR" 后, 你的车将会走过位置 0->1->3->3，并且速度变化为 1->2->4->-1。</p>

<p>现在给定一个目标位置，请给出能够到达目标位置的最短指令列表的<strong>长度</strong>。</p>

<p> </p>

<pre>
<strong>示例 1:</strong>
<strong>输入:</strong> 
target = 3
<strong>输出:</strong> 2
<strong>解释:</strong> 
最短指令列表为 "AA"
位置变化为 0->1->3
</pre>

<pre>
<strong>示例 2:</strong>
<strong>输入:</strong> 
target = 6
<strong>输出:</strong> 5
<strong>解释:</strong> 
最短指令列表为 "AAARA"
位置变化为 0->1->3->7->7->6
</pre>

<p><strong>说明: </strong></p>

<ul>
	<li><code>1 <= target（目标位置） <= 10000</code>。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def racecar(self, target: int) -> int:
        f = [inf] * (target + 1)
        for i in range(1, target + 1):
            d = 1
            while (1 << d) - 1 < 2 * i:
                forward = (1 << d) - 1
                if forward == i:
                    f[i] = d
                elif forward > i:
                    f[i] = min(f[i], d + 1 + f[forward - i])
                else:
                    f[i] = min(f[i], d + 2 + f[i - forward])
                    b = 1
                    while (1 << b) - 1 < forward:
                        backward = (1 << b) - 1
                        f[i] = min(f[i], d + 1 + b + 1 + f[i - forward + backward])
                        b += 1
                d += 1
        return f[target]
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int racecar(int target) {
        int[] f = new int[target + 1];
        Arrays.fill(f, 0x3f3f3f3f);
        for (int i = 1; i < target + 1; i++) {
            int d = 1;
            while ((1 << d) - 1 < 2 * i) {
                int forward = (1 << d) - 1;
                if (forward == i) {
                    f[i] = d;
                } else if (forward > i) {
                    f[i] = Math.min(f[i], d + 1 + f[forward - i]);
                } else {
                    f[i] = Math.min(f[i], d + 2 + f[i - forward]);
                    int b = 1;
                    while ((1 << b) - 1 < forward) {
                        int backward = (1 << b) - 1;
                        f[i] = Math.min(f[i], d + 1 + b + 1 + f[i - forward + backward]);
                        b++;
                    }
                }
                d++;
            }
        }
        return f[target];
    }
}
```

### **...**

```

```

<!-- tabs:end -->
