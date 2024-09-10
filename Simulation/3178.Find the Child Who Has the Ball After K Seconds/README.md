# [3178. 找出 K 秒后拿着球的孩子](https://leetcode.cn/problems/find-the-child-who-has-the-ball-after-k-seconds)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你两个 <strong>正整数 </strong><code>n</code> 和 <code>k</code>。有 <code>n</code> 个编号从 <code>0</code> 到 <code>n - 1</code> 的孩子按顺序从左到右站成一队。</p>

<p>最初，编号为 0 的孩子拿着一个球，并且向右传球。每过一秒，拿着球的孩子就会将球传给他旁边的孩子。一旦球到达队列的 <strong>任一端 </strong>，即编号为 0 的孩子或编号为 <code>n - 1</code> 的孩子处，传球方向就会<strong> 反转 </strong>。</p>

<p>返回 <code>k</code> 秒后接到球的孩子的编号。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<div class="example-block">
<p><strong>输入：</strong><span class="example-io">n = 3, k = 5</span></p>

<p><strong>输出：</strong><span class="example-io">1</span></p>

<p><strong>解释：</strong></p>

<table>
	<tbody>
		<tr>
			<th>经过的时间</th>
			<th>孩子队列</th>
		</tr>
		<tr>
			<td><code>0</code></td>
			<td><code>[<u>0</u>, 1, 2]</code></td>
		</tr>
		<tr>
			<td><code>1</code></td>
			<td><code>[0, <u>1</u>, 2]</code></td>
		</tr>
		<tr>
			<td><code>2</code></td>
			<td><code>[0, 1, <u>2</u>]</code></td>
		</tr>
		<tr>
			<td><code>3</code></td>
			<td><code>[0, <u>1</u>, 2]</code></td>
		</tr>
		<tr>
			<td><code>4</code></td>
			<td><code>[<u>0</u>, 1, 2]</code></td>
		</tr>
		<tr>
			<td><code>5</code></td>
			<td><code>[0, <u>1</u>, 2]</code></td>
		</tr>
	</tbody>
</table>
</div>

<p><strong class="example">示例 2：</strong></p>

<div class="example-block">
<p><strong>输入：</strong><span class="example-io">n = 5, k = 6</span></p>

<p><strong>输出：</strong><span class="example-io">2</span></p>

<p><strong>解释：</strong></p>

<table>
	<tbody>
		<tr>
			<th>经过的时间</th>
			<th>孩子队列</th>
		</tr>
		<tr>
			<td><code>0</code></td>
			<td><code>[<u>0</u>, 1, 2, 3, 4]</code></td>
		</tr>
		<tr>
			<td><code>1</code></td>
			<td><code>[0, <u>1</u>, 2, 3, 4]</code></td>
		</tr>
		<tr>
			<td><code>2</code></td>
			<td><code>[0, 1, <u>2</u>, 3, 4]</code></td>
		</tr>
		<tr>
			<td><code>3</code></td>
			<td><code>[0, 1, 2, <u>3</u>, 4]</code></td>
		</tr>
		<tr>
			<td><code>4</code></td>
			<td><code>[0, 1, 2, 3, <u>4</u>]</code></td>
		</tr>
		<tr>
			<td><code>5</code></td>
			<td><code>[0, 1, 2, <u>3</u>, 4]</code></td>
		</tr>
		<tr>
			<td><code>6</code></td>
			<td><code>[0, 1, <u>2</u>, 3, 4]</code></td>
		</tr>
	</tbody>
</table>
</div>

<p><strong class="example">示例 3：</strong></p>

<div class="example-block">
<p><strong>输入：</strong><span class="example-io">n = 4, k = 2</span></p>

<p><strong>输出：</strong><span class="example-io">2</span></p>

<p><strong>解释：</strong></p>

<table>
	<tbody>
		<tr>
			<th>经过的时间</th>
			<th>孩子队列</th>
		</tr>
		<tr>
			<td><code>0</code></td>
			<td><code>[<u>0</u>, 1, 2, 3]</code></td>
		</tr>
		<tr>
			<td><code>1</code></td>
			<td><code>[0, <u>1</u>, 2, 3]</code></td>
		</tr>
		<tr>
			<td><code>2</code></td>
			<td><code>[0, 1, <u>2</u>, 3]</code></td>
		</tr>
	</tbody>
</table>
</div>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>2 &lt;= n &lt;= 50</code></li>
	<li><code>1 &lt;= k &lt;= 50</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def numberOfChild(self, n: int, k: int) -> int:
        d = True
        ans = 0
        while k:
            if ans == 0:
                d = True
            elif ans == n - 1:
                d = False
            v = min(k, n - 1)
            if d:
                ans += v
            else:
                ans -= v
            k -= v
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int numberOfChild(int n, int k) {
        boolean d = true;
        int ans = 0;
        while (k > 0) {
            if (ans == 0) {
                d = true;
            } else if (ans == n - 1) {
                d = false;
            }
            int v = Math.min(k, n - 1);
            ans = d ? ans + v : ans - v;
            k -= v;
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
