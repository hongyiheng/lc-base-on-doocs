class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (start > destination) {
            return distanceBetweenBusStops(distance, destination, start);
        }
        int s = 0, d = 0;
        for (int i = 0; i < distance.length; i++) {
            s += distance[i];
            if (start <= i && i < destination) {
                d += distance[i];
            }
        }
        return Math.min(d, s - d);
    }   
}