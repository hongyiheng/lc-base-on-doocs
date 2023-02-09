class AuthenticationManager {

    Map<String, Long> mp;
    int t;

    public AuthenticationManager(int timeToLive) {
        mp = new HashMap<>();
        t = timeToLive;
    }

    public void generate(String tokenId, int currentTime) {
        mp.put(tokenId, (long)currentTime + t);
    }

    public void renew(String tokenId, int currentTime) {
        if (mp.getOrDefault(tokenId, -1L) > currentTime) {
            mp.put(tokenId, (long)currentTime + t);
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        int ans = 0;
        for (long v : mp.values()) {
            if (v > currentTime) {
                ans++;
            }
        }
        return ans;
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */