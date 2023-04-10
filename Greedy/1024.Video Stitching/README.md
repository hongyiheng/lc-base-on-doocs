# [1024. 视频拼接](https://leetcode-cn.com/problems/video-stitching)



## 题目描述

<!-- 这里写题目描述 -->

<p>你将会获得一系列视频片段，这些片段来自于一项持续时长为 <code>T</code> 秒的体育赛事。这些片段可能有所重叠，也可能长度不一。</p>

<p>视频片段 <code>clips[i]</code> 都用区间进行表示：开始于 <code>clips[i][0]</code> 并于 <code>clips[i][1]</code> 结束。我们甚至可以对这些片段自由地再剪辑，例如片段 <code>[0, 7]</code> 可以剪切成 <code>[0, 1] + [1, 3] + [3, 7]</code> 三部分。</p>

<p>我们需要将这些片段进行再剪辑，并将剪辑后的内容拼接成覆盖整个运动过程的片段（<code>[0, T]</code>）。返回所需片段的最小数目，如果无法完成该任务，则返回 <code>-1</code> 。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>clips = [[0,2],[4,6],[8,10],[1,9],[1,5],[5,9]], T = 10
<strong>输出：</strong>3
<strong>解释：</strong>
我们选中 [0,2], [8,10], [1,9] 这三个片段。
然后，按下面的方案重制比赛片段：
将 [1,9] 再剪辑为 [1,2] + [2,8] + [8,9] 。
现在我们手上有 [0,2] + [2,8] + [8,10]，而这些涵盖了整场比赛 [0, 10]。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>clips = [[0,1],[1,2]], T = 5
<strong>输出：</strong>-1
<strong>解释：</strong>
我们无法只用 [0,1] 和 [1,2] 覆盖 [0,5] 的整个过程。
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>clips = [[0,1],[6,8],[0,2],[5,6],[0,4],[0,3],[6,7],[1,3],[4,7],[1,4],[2,5],[2,6],[3,4],[4,5],[5,7],[6,9]], T = 9
<strong>输出：</strong>3
<strong>解释： </strong>
我们选取片段 [0,4], [4,7] 和 [6,9] 。
</pre>

<p><strong>示例 4：</strong></p>

<pre>
<strong>输入：</strong>clips = [[0,4],[2,8]], T = 5
<strong>输出：</strong>2
<strong>解释：</strong>
注意，你可能录制超过比赛结束时间的视频。
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= clips.length <= 100</code></li>
	<li><code>0 <= clips[i][0] <= clips[i][1] <= 100</code></li>
	<li><code>0 <= T <= 100</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def videoStitching(self, clips: List[List[int]], time: int) -> int:
        t = [i for i in range(110)]
        for u, v in clips:
            if v > t[u]:
                t[u] = v
        ans, cur = 1, t[0]
        while cur < time:
            mx = max(t[:cur + 1])
            if mx == cur:
                return -1
            cur = mx
            ans += 1
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int videoStitching(int[][] clips, int time) {
        int[] t = new int[110];
        for (int[] c : clips) {
            t[c[0]] = Math.max(t[c[0]], c[1]);
        }
        int ans = 1, cur = t[0];
        while (cur < time) {
            int mx = 0;
            for (int i = cur; i > -1; i--) {
                mx = Math.max(mx, t[i]);
            }
            if (mx == cur) {
                return -1;
            }
            cur = mx;
            ans++;
        }
        return cur >= time ? ans : -1;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
