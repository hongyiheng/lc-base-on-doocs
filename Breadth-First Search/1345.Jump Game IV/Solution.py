class Solution:
    def minJumps(self, arr: List[int]) -> int:
        n = len(arr)
        mp = defaultdict(list)
        for i, v in enumerate(arr):
            mp[v].append(i)
        steps = [float('inf')] * n
        q = deque([0])
        steps[0] = 0
        while q:
            cur = q.popleft()
            step = steps[cur]
            if cur == n - 1:
                return step
            for index in mp[arr[cur]]:
                if steps[index] == float('inf'):
                    q.append(index)
                    steps[index] = step + 1
            mp.pop(arr[cur])
            if cur and steps[cur - 1] == float('inf'):
                q.append(cur - 1)
                steps[cur - 1] = step + 1
            if steps[cur + 1] == float('inf'):
                q.append(cur + 1)
                steps[cur + 1] = step + 1
        return -1