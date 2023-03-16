class Solution:
    def validateBinaryTreeNodes(self, n: int, leftChild: List[int], rightChild: List[int]) -> bool:
        vis = [False] * n
        for i in range(n):
            if leftChild[i] != -1:
                if vis[leftChild[i]]:
                    return False
                vis[leftChild[i]] = True
            if rightChild[i] != -1:
                if vis[rightChild[i]]:
                    return False
                vis[rightChild[i]] = True
        q = deque()
        for i, b in enumerate(vis):
            if not b:
                q.append(i)
        if len(q) != 1:
            return False
        cnt = 0
        while q:
            for _ in range(len(q)):
                cur = q.popleft()
                cnt += 1
                if leftChild[cur] != -1:
                    q.append(leftChild[cur])
                if rightChild[cur] != -1:
                    q.append(rightChild[cur])
        return cnt == n
