# [LCP 32. 批量处理任务](https://leetcode.cn/problems/t3fKg1)



## 题目描述

<!-- 这里写题目描述 -->

某实验室计算机待处理任务以 `[start,end,period]` 格式记于二维数组 `tasks`，表示完成该任务的时间范围为起始时间 `start` 至结束时间 `end` 之间，需要计算机投入 `period` 的时长，注意：
1. `period` 可为不连续时间
2. 首尾时间均包含在内

处于开机状态的计算机可同时处理任意多个任务，请返回电脑最少开机多久，可处理完所有任务。

**示例 1：**
>输入：`tasks = [[1,3,2],[2,5,3],[5,6,2]]`
>
>输出：`4`
>
>解释：
>tasks[0] 选择时间点 2、3；
>tasks[1] 选择时间点 2、3、5；
>tasks[2] 选择时间点 5、6；
>因此计算机仅需在时间点 2、3、5、6 四个时刻保持开机即可完成任务。

**示例 2：**
>输入：`tasks = [[2,3,1],[5,5,1],[5,6,2]]`
>
>输出：`3`
>
>解释：
>tasks[0] 选择时间点 2 或 3；
>tasks[1] 选择时间点 5；
>tasks[2] 选择时间点 5、6；
>因此计算机仅需在时间点 2、5、6 或 3、5、6 三个时刻保持开机即可完成任务。

**提示：**
- `2 <= tasks.length <= 10^5`
- `tasks[i].length == 3`
- `0 <= tasks[i][0] <= tasks[i][1] <= 10^9`
- `1 <= tasks[i][2] <= tasks[i][1]-tasks[i][0] + 1`

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
