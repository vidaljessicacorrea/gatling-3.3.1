Extract JSESSIONID & DYN_USER_ID from cookies
============================

From [Http Protocol] (https://gatling.io/docs/2.3/http/http_protocol/)

##Log extra data from request

With ExtraInfoExtractor is possible get info of the request like cookies, headers, body.

extraInfo.request.getCookies = collect all cookies in the request and return it as a List[Cookies]

After than you can manipulate the list with for statement and extract the data.

```
 val cookieVar = extraInfo.request.getCookies
    var result = ""
    for(i <- 0 to cookieVar.size() -1) {
      if (cookieVar.get(i).getName.equals("JSESSIONID")) result = cookieVar.get(i).getName + ": " + cookieVar.get(i).getValue
      if (cookieVar.get(i).getName.equals("DYN_USER_ID")) result = result + ", "+ cookieVar.get(i).getName + ": " + cookieVar.get(i).getValue
    }
    logger.info(result)
```

```
14:00:55.599 [INFO ] b.BaseLogger$ - JSESSIONID: AlnjdDb5sW5qNHOAN5HsuadL.nodecsr2, DYN_USER_ID: 2246039483

```
