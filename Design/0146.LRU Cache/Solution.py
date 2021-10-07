class ListNode:
    def __init__(self, key = None, value = None):
        self.key = key
        self.value = value
        self.prev = None
        self.next = None

class LRUCache:
    def __init__(self, capacity: int):
        self.capacity = capacity
        self.mp = {}
        self.head = ListNode()
        self.tail = ListNode()
        self.head.next = self.tail
        self.tail.prev = self.head


    def get(self, key: int) -> int:
        if key in self.mp:
            self.move_node_to_head(key)
        res = self.mp.get(key, -1)
        if res == -1:
            return res
        else:
            return res.value

    def put(self, key: int, value: int) -> None:
        if key not in self.mp and len(self.mp) == self.capacity:
            self.mp.pop(self.tail.prev.key)
            self.tail.prev.prev.next = self.tail.prev.next
            self.tail.prev.next.prev = self.tail.prev.prev

        if key in self.mp:
            node = self.mp[key]
            node.prev.next = node.next
            node.next.prev = node.prev

        new = ListNode(key, value)
        self.mp[key] = new
        new.next = self.head.next
        new.prev = self.head
        self.head.next.prev = new
        self.head.next = new


    def move_node_to_head(self, key):
        node = self.mp[key]
        node.prev.next = node.next
        node.next.prev = node.prev

        self.head.next.prev = node
        node.next = self.head.next
        node.prev = self.head
        self.head.next = node

# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)