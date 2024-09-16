class Solution:
    def distanceBetweenBusStops(self, distance: List[int], start: int, destination: int) -> int:
        if start > destination:
            return self.distanceBetweenBusStops(distance, destination, start)
        s = sum(distance)
        d = 0
        for i in range(start, destination):
            d += distance[i]
        return min(d, s - d)