To See or Monitor the Live Simulation
=====================================

from  https://gatling.io/docs/2.3/realtime_monitoring/
and
https://www.blazemeter.com/blog/gatling-tests-monitoring-with-grafana-and-influxdb
(see the second url if you want configure your own server Setting Up Grafana and InfluxDB)


to monitoring the simulation you have to go to this url(if you have not your own dashboards):
http://10.145.160.80:10000
the user is admin and the password is admin

after that you have to select Gatling dashboard, then you going to see a button on right up;
in this last button on the right  you can select the date and time that you want to see at live.
probably you have to select the last day or some minutes option

then you have to go to the project's configuration; you can see it on the file :
```
src\test\resources\gatling.conf
```
 when you're at this file, you going to see something like this:

 ```
   data {
     writers = [console, file,graphite]      # The list of DataWriters to which Gatling write simulation data (currently supported : console, file, graphite, jdbc)
     console {
      # light = true                # When set to true, displays a light version without detailed request stats
     }
     file {
       #bufferSize = 8192            # FileDataWriter's internal data buffer size, in bytes
     }
     leak {
       #noActivityTimeout = 30  # Period, in seconds, for which Gatling may have no activity before considering a leak may be happening
     }
     graphite {
       #light = false                # only send the all* stats
       #host = "10.145.160.80"         # The host where the Carbon server is located
       #port = 13000                # The port to which the Carbon server listens to (2003 is default for plaintext, 2004 is default for pickle)
       #protocol = "tcp"           # The protocol used to send data to Carbon (currently supported : "tcp", "udp")
       #rootPathPrefix = "gatling" # The common prefix of all metrics sent to Graphite
       #bufferSize = 8192          # GraphiteDataWriter's internal data buffer size, in bytes
       #writeInterval = 1          # GraphiteDataWriter's write interval, in seconds
     }
   }
 ```

 to monitoring the live simulation, you only have to erase the symbol "#" from   the lines inside "graphite {}"
 to make active the configuration function you must let some like this :
```
 data {
     writers = [console, file,graphite]      # The list of DataWriters to which Gatling write simulation data (currently supported : console, file, graphite, jdbc)
     console {
      # light = true                # When set to true, displays a light version without detailed request stats
     }
     file {
       #bufferSize = 8192            # FileDataWriter's internal data buffer size, in bytes
     }
     leak {
       #noActivityTimeout = 30  # Period, in seconds, for which Gatling may have no activity before considering a leak may be happening
     }
     graphite {
       light = false                # only send the all* stats
       host = "10.145.160.80"         # The host where the Carbon server is located
       port = 13000                # The port to which the Carbon server listens to (2003 is default for plaintext, 2004 is default for pickle)
       protocol = "tcp"           # The protocol used to send data to Carbon (currently supported : "tcp", "udp")
       rootPathPrefix = "gatling" # The common prefix of all metrics sent to Graphite
       bufferSize = 8192          # GraphiteDataWriter's internal data buffer size, in bytes
       writeInterval = 1          # GraphiteDataWriter's write interval, in seconds
     }
   }
```
now we going to explain what you changed:
```
light = false
```
when you put the option light to false: if you do that you make that graphite is on, this make that you can see some logs during the simulation that they will be use to show the graphics on live
```
host = "10.145.160.80"
```
here in this option you must to put the ip address of the site where you can see  the graphic; here we put the ip address that performance team configure, but if you want make you own server
to see you simulations you can go to the site https://grafana.com/ and create your own acount to make you own dashboards

```
 port = 13000
```

in this option you can put the port used in the server to listen the data to  the dashboards
```
 protocol = "tcp"
 ```
 this as you can see is the protocol used to send data to Carbon (currently supported : "tcp", "udp")

 ```
 rootPathPrefix = "gatling"
 ```

 as you can see this is only the prefix that we put to send in the simulation

 ```
 bufferSize = 8192
 ```
 here you can define the graphiteDataWriter's internal data buffer size, in bytes

 ```
 writeInterval = 1
 ```

 here you can define the time interval in the graphic, must be in seconds