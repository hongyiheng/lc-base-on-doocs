                              class Solution:
                                  def canConvertString(self, s: str, t: str, k: int) -> bool:
                                      if len(s) != len(t):
                                          return False
                                      cnt = [0] * 26
                                      mx = 0
                                      for a, b in zip(s, t):
                                          if a == b:
                                              continue
                                          diff = (ord(b) - ord(a) + 26) % 26
                                          cnt[diff] += 1
                                          diff += (cnt[diff] - 1) * 26
                                          mx = max(mx, diff)
                                      return mx <= k