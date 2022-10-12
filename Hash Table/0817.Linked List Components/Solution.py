# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def numComponents(self, head: Optional[ListNode], nums: List[int]) -> int:
        s = set()
        for v in nums:
            s.add(v)
        ans = 0
        while head:
            if head.val not in s:
                head = head.next
                continue
            tmp = head
            while tmp and tmp.val in s:
                tmp = tmp.next
            ans += 1
            head = tmp
        return ans
