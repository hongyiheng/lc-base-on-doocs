class Solution:
    def findAllPeople(self, n: int, meetings: List[List[int]], firstPerson: int) -> List[int]:
        knows_secret = [False] * n
        knows_secret[0] = True
        knows_secret[firstPerson] = True
        meetings_by_time = defaultdict(list)
        for x, y, t in meetings:
            meetings_by_time[t].append((x, y))
        for t in sorted(meetings_by_time.keys()):
            graph = defaultdict(list)
            people_in_meetings = set()
            for x, y in meetings_by_time[t]:
                graph[x].append(y)
                graph[y].append(x)
                people_in_meetings.add(x)
                people_in_meetings.add(y)
            sources = [p for p in people_in_meetings if knows_secret[p]]
            if not sources:
                continue
            queue = deque(sources)
            visited = set(sources)
            while queue:
                u = queue.popleft()
                for v in graph[u]:
                    if v not in visited:
                        visited.add(v)
                        queue.append(v)
            for p in visited:
                knows_secret[p] = True
        result = [i for i in range(n) if knows_secret[i]]
        return result