class Solution:
    def finalValueAfterOperations(self, operations: List[str]) -> int:
        return sum([1 if '+' in v else -1 for v in operations])