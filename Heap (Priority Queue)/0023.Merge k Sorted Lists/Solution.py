# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
from sortedcontainers import SortedList
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        dummy = ListNode()
        tail = dummy
        q = SortedList(key=lambda x: x[0])
        for v in lists:
            if v:
                q.add([v.val, v])
        while True:
            min_root = None
            if q:
                min_root = q.pop(0)[1]
            if not min_root:
                break
            tail.next = ListNode(min_root.val)
            tail = tail.next
            min_root = min_root.next
            if min_root:
                q.add([min_root.val, min_root])
        return dummy.next