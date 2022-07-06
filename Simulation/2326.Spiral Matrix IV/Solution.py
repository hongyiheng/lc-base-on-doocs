# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def spiralMatrix(self, m: int, n: int, head: Optional[ListNode]) -> List[List[int]]:
        ans = [[-1] * n for _ in range(m)]
        dirs = [[0, 1], [1, 0], [0, -1], [-1, 0]]
        x = y = cur = 0
        while head:
            if x < 0 or x >= m or y < 0 or y >= n or ans[x][y] != -1:
                x -= dirs[cur][0]
                y -= dirs[cur][1]
                cur = 0 if cur + 1 == 4 else cur + 1
                x += dirs[cur][0]
                y += dirs[cur][1]
            else:
                ans[x][y] = head.val
                x += dirs[cur][0]
                y += dirs[cur][1]
                head = head.next
        return ans