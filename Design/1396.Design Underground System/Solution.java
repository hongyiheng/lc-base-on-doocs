class UndergroundSystem {
    Map<String, List<Integer>> mp;
    Map<Integer, Pair<String, Integer>> track;
    public UndergroundSystem() {
        mp = new HashMap<>();
        track = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        track.put(id, new Pair(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Pair start = track.get(id);
        String key = start.getKey() + "->" + stationName;
        mp.computeIfAbsent(key, k -> new ArrayList<>()).add(t - (int) start.getValue());
    }

    public double getAverageTime(String startStation, String endStation) {
        List<Integer> times = mp.get(startStation + "->" + endStation);
        double time = (double) times.size();
        int s = 0;
        for (int num : times) {
            s += num;
        }
        return s / time;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */