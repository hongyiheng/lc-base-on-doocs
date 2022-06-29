# [535. TinyURL 的加密与解密](https://leetcode-cn.com/problems/encode-and-decode-tinyurl)



## 题目描述

<!-- 这里写题目描述 -->

<p>TinyURL是一种URL简化服务， 比如：当你输入一个URL&nbsp;<code>https://leetcode.com/problems/design-tinyurl</code>&nbsp;时，它将返回一个简化的URL&nbsp;<code>http://tinyurl.com/4e9iAk</code>.</p>

<p>要求：设计一个 TinyURL 的加密&nbsp;<code>encode</code>&nbsp;和解密&nbsp;<code>decode</code>&nbsp;的方法。你的加密和解密算法如何设计和运作是没有限制的，你只需要保证一个URL可以被加密成一个TinyURL，并且这个TinyURL可以用解密方法恢复成原本的URL。</p>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Codec:
    def __init__(self):
        self.idx = 0
        self.mp = {}
        
    def encode(self, longUrl: str) -> str:
        """Encodes a URL to a shortened URL.
        """
        self.idx += 1
        self.mp[self.idx] = longUrl
        return self.idx
        

    def decode(self, shortUrl: str) -> str:
        """Decodes a shortened URL to its original URL.
        """
        return self.mp[shortUrl]
        

# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.decode(codec.encode(url))
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
public class Codec {
    Map<String, String> mp = new HashMap<>();;
    int idx;

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String shortUrl = String.valueOf(idx++);
        mp.put(shortUrl, longUrl);
        return shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return mp.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
```

### **...**

```

```

<!-- tabs:end -->
