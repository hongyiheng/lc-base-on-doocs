# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def nextLargerNodes(self, head: Optional[ListNode]) -> List[int]:
        q, ans = [], []
        idx = 0
        while head:
            while q and q[-1][1] < head.val:
                i, _ = q.pop()
                ans[i] = head.val
            q.append([idx, head.val])
            ans.append(0)
            idx += 1
            head = head.next
        return ans
