# [面试题 08.10. 颜色填充](https://leetcode.cn/problems/color-fill-lcci)



## 题目描述

<!-- 这里写题目描述 -->

<p>编写函数，实现许多图片编辑软件都支持的「颜色填充」功能。</p>

<p>待填充的图像用二维数组 <code>image</code> 表示，元素为初始颜色值。初始坐标点的行坐标为 <code>sr</code> 列坐标为 <code>sc</code>。需要填充的新颜色为 <code>newColor</code> 。</p>

<p>「周围区域」是指颜色相同且在上、下、左、右四个方向上存在相连情况的若干元素。</p>

<p>请用新颜色填充初始坐标点的周围区域，并返回填充后的图像。</p>

<p> </p>

<p><strong>示例：</strong></p>

<pre>
<strong>输入</strong>：
image = [[1,1,1],[1,1,0],[1,0,1]] 
sr = 1, sc = 1, newColor = 2
<strong>输出</strong>：[[2,2,2],[2,2,0],[2,0,1]]
<strong>解释</strong>: 
初始坐标点位于图像的正中间，坐标 (sr,sc)=(1,1) 。
初始坐标点周围区域上所有符合条件的像素点的颜色都被更改成 2 。
注意，右下角的像素没有更改为 2 ，因为它不属于初始坐标点的周围区域。
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>image</code> 和 <code>image[0]</code> 的长度均在范围 [1, 50] 内。</li>
	<li>初始坐标点 <code>(sr,sc)</code> 满足 <code>0 <= sr < image.length</code> 和 <code>0 <= sc < image[0].length</code> 。</li>
	<li><code>image[i][j]</code> 和 <code>newColor</code> 表示的颜色值在范围 <code>[0, 65535]</code> 内。</li>
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
