# [LCR 148. 验证图书取出顺序](https://leetcode.cn/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof)



## 题目描述

<!-- 这里写题目描述 -->

<p>现在图书馆有一堆图书需要放入书架，并且图书馆的书架是一种特殊的数据结构，只能按照 <strong>一定</strong> 的顺序 <strong>放入</strong> 和 <strong>拿取</strong> 书籍。</p>

<p>给定一个表示图书放入顺序的整数序列 <code>putIn</code>，请判断序列 <code>takeOut</code> 是否为按照正确的顺序拿取书籍的操作序列。你可以假设放入书架的所有书籍编号都不相同。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>putIn = [6,7,8,9,10,11], takeOut = [9,11,10,8,7,6]
<strong>输出：</strong>true
<strong>解释：</strong>我们可以按以下操作放入并拿取书籍：
push(6), push(7), push(8), push(9), pop() -&gt; 9,
push(10), push(11),pop() -&gt; 11,pop() -&gt; 10, pop() -&gt; 8, pop() -&gt; 7, pop() -&gt; 6
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>putIn = [6,7,8,9,10,11], takeOut = [11,9,8,10,6,7]
<strong>输出：</strong>false
<strong>解释：</strong>6 不能在 7 之前取出。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>0 &lt;= putIn.length == takeOut.length &lt;= 1000</code></li>
	<li><code>0 &lt;= putIn[i], takeOut &lt; 1000</code></li>
	<li><code>putIn</code> 是 <code>takeOut</code> 的排列。</li>
</ul>

<p>注意：本题与主站 946 题相同：<a href="https://leetcode-cn.com/problems/validate-stack-sequences/">https://leetcode-cn.com/problems/validate-stack-sequences/</a></p>

<p>&nbsp;</p>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python

```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java

```

### **...**

```

```

<!-- tabs:end -->
