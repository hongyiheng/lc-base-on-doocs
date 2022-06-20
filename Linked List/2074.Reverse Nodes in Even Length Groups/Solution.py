# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseEvenLengthGroups(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head or not head.next:
            return head
        nums = list()
        n = 0
        while head:
            n += 1
            nums.append(head.val)
            head = head.next
        new_nums = list()
        idx, cur = 0, 1
        while idx < n:
            r = min(idx + cur, n)
            if (r - idx) % 2 == 0:
                for i in range(r - 1, idx - 1, -1):
                    new_nums.append(nums[i])
            else:
                for i in range(idx, r):
                    new_nums.append(nums[i])
            cur += 1
            idx = r
        dummy = ListNode()
        tmp = dummy
        for v in new_nums:
            tmp.next = ListNode(v)
            tmp = tmp.next
        return dummy.next