class Solution:
    def minOperations(self, logs: List[str]) -> int:
        depth = 0
        for s in logs:
            if s == "../":
                depth = max(0, depth - 1)
            elif s != "./":
                depth += 1
        return depth