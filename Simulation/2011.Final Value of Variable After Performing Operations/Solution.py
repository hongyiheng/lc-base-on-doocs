class Solution:
    def finalValueAfterOperations(self, operations: List[str]) -> int:
        return sum(v[1] == '+' for v in operations) - sum(v[1] == '-' for v in operations)