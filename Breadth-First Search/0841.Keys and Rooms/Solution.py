class Solution:
    def canVisitAllRooms(self, rooms: List[List[int]]) -> bool:
        n = len(rooms)
        vis = [False] * n
        q = deque()
        for v in rooms[0]:
            q.append(v)
        vis[0] = True
        while q:
            cur = q.popleft()
            if vis[cur]:
                continue
            for v in rooms[cur]:
                q.append(v)
            vis[cur] = True
        for v in vis:
            if not v:
                return False
        return True