# [3612. 用特殊操作处理字符串 I](https://leetcode.cn/problems/process-string-with-special-operations-i)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个字符串 <code>s</code>，它由小写英文字母和特殊字符：<code>*</code>、<code>#</code> 和 <code>%</code> 组成。</p>

<p>请根据以下规则从左到右处理 <code>s</code>&nbsp;中的字符，构造一个新的字符串 <code>result</code>：</p>

<ul>
	<li>如果字符是 <strong>小写</strong> 英文字母，则将其添加到 <code>result</code> 中。</li>
	<li>字符 <code>'*'</code> 会&nbsp;<strong>删除</strong> <code>result</code> 中的最后一个字符（如果存在）。</li>
	<li>字符 <code>'#'</code> 会&nbsp;<strong>复制&nbsp;</strong>当前的 <code>result</code> 并&nbsp;<strong>追加&nbsp;</strong>到其自身后面。</li>
	<li>字符 <code>'%'</code> 会&nbsp;<strong>反转&nbsp;</strong>当前的 <code>result</code>。</li>
</ul>

<p>在处理完 <code>s</code> 中的所有字符后，返回最终的字符串 <code>result</code>。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<div class="example-block">
<p><strong>输入：</strong> <span class="example-io">s = "a#b%*"</span></p>

<p><strong>输出：</strong> <span class="example-io">"ba"</span></p>

<p><strong>解释：</strong></p>

<table style="border: 1px solid black;">
	<thead>
		<tr>
			<th style="border: 1px solid black;"><code>i</code></th>
			<th style="border: 1px solid black;"><code>s[i]</code></th>
			<th style="border: 1px solid black;">操作</th>
			<th style="border: 1px solid black;">当前 <code>result</code></th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td style="border: 1px solid black;">0</td>
			<td style="border: 1px solid black;"><code>'a'</code></td>
			<td style="border: 1px solid black;">添加 <code>'a'</code></td>
			<td style="border: 1px solid black;"><code>"a"</code></td>
		</tr>
		<tr>
			<td style="border: 1px solid black;">1</td>
			<td style="border: 1px solid black;"><code>'#'</code></td>
			<td style="border: 1px solid black;">复制 <code>result</code></td>
			<td style="border: 1px solid black;"><code>"aa"</code></td>
		</tr>
		<tr>
			<td style="border: 1px solid black;">2</td>
			<td style="border: 1px solid black;"><code>'b'</code></td>
			<td style="border: 1px solid black;">添加 <code>'b'</code></td>
			<td style="border: 1px solid black;"><code>"aab"</code></td>
		</tr>
		<tr>
			<td style="border: 1px solid black;">3</td>
			<td style="border: 1px solid black;"><code>'%'</code></td>
			<td style="border: 1px solid black;">反转 <code>result</code></td>
			<td style="border: 1px solid black;"><code>"baa"</code></td>
		</tr>
		<tr>
			<td style="border: 1px solid black;">4</td>
			<td style="border: 1px solid black;"><code>'*'</code></td>
			<td style="border: 1px solid black;">删除最后一个字符</td>
			<td style="border: 1px solid black;"><code>"ba"</code></td>
		</tr>
	</tbody>
</table>

<p>因此，最终的 <code>result</code> 是 <code>"ba"</code>。</p>
</div>

<p><strong class="example">示例 2：</strong></p>

<div class="example-block">
<p><strong>输入：</strong> <span class="example-io">s = "z*#"</span></p>

<p><strong>输出：</strong> <span class="example-io">""</span></p>

<p><strong>解释：</strong></p>

<table style="border: 1px solid black;">
	<thead>
		<tr>
			<th style="border: 1px solid black;"><code>i</code></th>
			<th style="border: 1px solid black;"><code>s[i]</code></th>
			<th style="border: 1px solid black;">操作</th>
			<th style="border: 1px solid black;">当前 <code>result</code></th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td style="border: 1px solid black;">0</td>
			<td style="border: 1px solid black;"><code>'z'</code></td>
			<td style="border: 1px solid black;">添加 <code>'z'</code></td>
			<td style="border: 1px solid black;"><code>"z"</code></td>
		</tr>
		<tr>
			<td style="border: 1px solid black;">1</td>
			<td style="border: 1px solid black;"><code>'*'</code></td>
			<td style="border: 1px solid black;">删除最后一个字符</td>
			<td style="border: 1px solid black;"><code>""</code></td>
		</tr>
		<tr>
			<td style="border: 1px solid black;">2</td>
			<td style="border: 1px solid black;"><code>'#'</code></td>
			<td style="border: 1px solid black;">复制字符串</td>
			<td style="border: 1px solid black;"><code>""</code></td>
		</tr>
	</tbody>
</table>

<p>因此，最终的 <code>result</code> 是 <code>""</code>。</p>
</div>

<p>&nbsp;</p>

<p><strong>提示:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 20</code></li>
	<li><code>s</code> 只包含小写英文字母和特殊字符 <code>*</code>、<code>#</code> 和 <code>%</code>。</li>
</ul>


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
