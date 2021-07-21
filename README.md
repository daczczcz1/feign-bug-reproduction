# feign-bug-reproduction

Run com.example.FeignBug.test

Observe logs for regular string value of header (correct): 
```
14:32:07.995 [Test worker] DEBUG com.example.TestClient - [TestClient#get] ---> GET https://www.google.com/ HTTP/1.1
14:32:07.998 [Test worker] DEBUG com.example.TestClient - [TestClient#get] Custom: val
```

And for json value (truncated):

```
14:42:34.815 [Test worker] DEBUG com.example.TestClient - [TestClient#get] ---> GET https://www.google.com/ HTTP/1.1
14:42:34.815 [Test worker] DEBUG com.example.TestClient - [TestClient#get] Custom: {"string": "val", "string2"}
```