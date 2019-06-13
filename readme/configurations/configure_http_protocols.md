Configure Http protocols
========================
From [Gatling Doc](https://gatling.io/docs/2.3/http/http_protocol/#)

There is a local variable on BaseSimulation where we specified the functions that we wanted to use:

```
  val httpConf = http
    .baseURL([BASE_URL])
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .acceptEncodingHeader("gzip, deflate")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0")

```


* baseURL: url of the site that we want use in the simulation. Also you can use more than one url if you use the function `.baseURLs

* acceptHeader: define the type of headers that you want accept on the simulation

* acceptLanguageHeader: define which languages the headers should accept

* acceptEncodingHeader: set the Accept-Encoding header for all requests

* userAgentHeader: define which "browser" you are going to launch the simulation, you must add the configuration.


If you need more details on you protocol you can add more functions according to your requirements.  For example;

```
val httpConfWithInferHtmlResources = http
    .baseURL(baseUrl)
    .warmUp(baseUrl)
    .inferHtmlResources()
```

* inferHtmlResources: on this way Gatling will automatically parse HTML to find embedded resources and load them asynchronously. To emulate the behavior of real web browser you can add filters, for example you can add a white o black list.
We configure the http protocols with InferHtmlResources adding the white list and the black list

```
val httpConf = http
    .baseURL(urlSite)
    .inferHtmlResources(WhiteList(".*\\.css.*"),BlackList(".*\\.js.*") )
    .disableWarmUp
```

The supported resources are:


```
<script>
<base>
<link>
<bgsound>
<frame>
<iframe>
<img>
<input>
<body>
<applet>
<embed>
<object>
```

import directives in HTML and @import CSS rule.
Other resources are not supported: css images, javascript triggered resources, conditional comments, etc.

As you can see, you can also specify black/white list or custom filters to have a more fine grain control on resource fetching. WhiteList and BlackList take a sequence of pattern, eg Seq("http://www.google.com/.*", "http://www.github.com/.*"), to include and exclude respectively.
```
 inferHtmlResources(white: WhiteList): fetch all resources matching a pattern in the white list.
 inferHtmlResources(white: WhiteList, black: BlackList): fetch all resources matching a pattern in the white list excepting those in the black list.
 inferHtmlResources(black: BlackList, white: WhiteList = WhiteList(Nil)): fetch all resources excepting those matching a pattern in the black list and not in the white list.
 inferHtmlResources(filters: Option[Filters])
```

* disableWarmUp: when using this configuration you can disable the automatic condition that gatling uses to go first against its own server before using the url defined for the simulation. Another way to disable is to use the `.warmUp ()` function and set up the url that we want to use.


* maxConnectionsPerHostLike: set the maximum concurrent connections per host per virtual user. Predefined parameters are available through methods such as maxConnectionsPerHostLikeBrowser
example : `.maxConnectionsPerHostLikeChrome`  or `.maxConnectionsPerHostLikeFirefox`


* silentResources: is used but not logged, nor reported. All the resources are going to be silenced. Another way to use: `.silentURI(testURLPrimary + "/resources/.*")` to specify which url want to silent

* disableFollowRedirect: this function is used to Force the HTTP engine not to follow the redirects. You can also disable it globally on the HttpProtocol

* maxRedirects(1):if you use this function avoids infinite redirection loops by specifying a number max of redirects

* disableCaching: when you use this function Disable caching features for some http headers and ETag