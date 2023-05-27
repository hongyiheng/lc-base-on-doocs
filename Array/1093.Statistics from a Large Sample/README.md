# [1093. 大样本统计](https://leetcode-cn.com/problems/statistics-from-a-large-sample)

## 题目描述

<!-- 这里写题目描述 -->

<p>我们对&nbsp;<code>0</code>&nbsp;到&nbsp;<code>255</code>&nbsp;之间的整数进行采样，并将结果存储在数组&nbsp;<code>count</code>&nbsp;中：<code>count[k]</code>&nbsp;就是整数&nbsp;<code>k</code> 在样本中出现的次数。</p>

<p>计算以下统计数据:</p>

<ul>
	<li><code>minimum</code>&nbsp;：样本中的最小元素。</li>
	<li><code>maximum</code>&nbsp;：样品中的最大元素。</li>
	<li><code>mean</code>&nbsp;：样本的平均值，计算为所有元素的总和除以元素总数。</li>
	<li><code>median</code>&nbsp;：
	<ul>
		<li>如果样本的元素个数是奇数，那么一旦样本排序后，中位数 <code>median</code> 就是中间的元素。</li>
		<li>如果样本中有偶数个元素，那么中位数<code>median</code> 就是样本排序后中间两个元素的平均值。</li>
	</ul>
	</li>
	<li><code>mode</code>&nbsp;：样本中出现次数最多的数字。保众数是 <strong>唯一</strong> 的。</li>
</ul>

<p>以浮点数数组的形式返回样本的统计信息<em>&nbsp;</em><code>[minimum, maximum, mean, median, mode]</code>&nbsp;。与真实答案误差在<em>&nbsp;</em><code>10<sup>-5</sup></code><em>&nbsp;</em>内的答案都可以通过。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>count = [0,1,3,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
<strong>输出：</strong>[1.00000,3.00000,2.37500,2.50000,3.00000]
<strong>解释：</strong>用count表示的样本为[1,2,2,2,3,3,3,3,3]。
最小值和最大值分别为1和3。
均值是(1+2+2+2+3+3+3+3) / 8 = 19 / 8 = 2.375。
因为样本的大小是偶数，所以中位数是中间两个元素2和3的平均值，也就是2.5。
众数为3，因为它在样本中出现的次数最多。</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>count = [0,4,3,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
<strong>输出：</strong>[1.00000,4.00000,2.18182,2.00000,1.00000]
<strong>解释：</strong>用count表示的样本为[1,1,1,1,2,2,3,3,3,4,4]。
最小值为1，最大值为4。
平均数是(1+1+1+1+2+2+2+3+3+4+4)/ 11 = 24 / 11 = 2.18181818…(为了显示，输出显示了整数2.18182)。
因为样本的大小是奇数，所以中值是中间元素2。
众数为1，因为它在样本中出现的次数最多。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>count.length == 256</code></li>
	<li><code>0 &lt;= count[i] &lt;= 10<sup>9</sup></code></li>
	<li><code>1 &lt;= sum(count) &lt;= 10<sup>9</sup></code></li>
	<li>&nbsp;<code>count</code>&nbsp;的众数是 <strong>唯一</strong> 的</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def sampleStats(self, count: List[int]) -> List[float]:
        mod_mx = mod = 0
        mi, mx = 255, 0
        cnt = val = 0
        for i, v in enumerate(count):
            if v:
                cnt += v
                val += i * v
                mi = min(mi, i)
                mx = max(mx, i)
                if v > mod_mx:
                    mod = i
                    mod_mx = v
        mean = val / cnt
        cur = median = 0
        for i, v in enumerate(count):
            cur += v
            if cnt % 2:
                if cur > cnt // 2:
                    median = i
                    break
            else:
                if median == 0 and cur >= cnt // 2:
                    median = i
                if cur >= cnt // 2 + 1:
                    median += i
                    median /= 2
                    break
        return [mi, mx, mean, median, mod]
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public double[] sampleStats(int[] count) {
        double mi = 255, mx = 0, mean = 0, median = 0, mod = 0;
        long cnt = 0, val = 0, modMx = 0, n = count.length;
        for (int i = 0; i < n; i++) {
            if (count[i] > 0) {
                cnt += count[i];
                val += 1L * count[i] * i;
                if (count[i] > modMx) {
                    modMx = count[i];
                    mod = i;
                }
                mi = Math.min(mi, i);
                mx = Math.max(mx, i);
            }
        }
        mean = (double) val / cnt;
        int cur = 0;
        for (int i = 0; i < n; i++) {
            cur += count[i];
            if (cnt % 2 == 0) {
                if (median == 0 && cur >= cnt / 2) {
                    median = i;
                }
                if (cur >= cnt / 2 + 1) {
                    median += i;
                    median /= 2;
                    break;
                }
            } else {
                if (cur > cnt / 2) {
                    median = i;
                    break;
                }
            }
        }
        return new double[]{mi, mx, mean, median, mod};
    }
}
```

### **...**

```

```

<!-- tabs:end -->
