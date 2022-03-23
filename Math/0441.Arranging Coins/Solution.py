class Solution:
    def findKthNumber(self, n: int, k: int) -> int:
        def getNodes(cur):
            nonlocal n
            node_count = 0
            next = cur + 1
            while cur <= n:
                node_count += min(n - cur + 1, next - cur)
                next *= 10
                cur *= 10
            return node_count

        cur = 1
        k -= 1
        while k > 0:
            node_count = getNodes(cur)
            if k >= node_count:
                k -= node_count
                cur += 1
            else:
                k -= 1
                cur *= 10
        return cur