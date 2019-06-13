RampUsersPerSec
===============

documentation from (https://gatling.io/docs/2.3/general/simulation_setup/)

To see this simulation go to ([RampUsersPerSec](https://bitbucket.adessa.cl/projects/PERF/repos/performance-gatling-examples/browse/src/main/gatling/simulations/RampUsersPerSec.scala))
to launch this simulation you must to execute:
```
mvn gatling:execute -Dgatling.simulationClass=simulations.RampUsersPerSec -Dgatling.URL="http://www.falabella.cl" -Dgatling.totalUser=1 -Dgatling.totalTime=1
```

in this simulation we try to show how to split users; the rule was: "inject 2 users per sec to 10 users per sec during 5 minutes".

as you can see, we use the native function "splitUsers" this function can work with others native function:

```
  setUp(
    ScenarioTest.scn.inject(rampUsersPerSec(2) to (10) during(5 minutes))
  ).protocols(httpConf)
```
we gonna show how to use this function:
```
rampUsersPerSec(rate1) to (rate2) during(duration)
```
this function injects users from starting rate to target rate, defined in users per second, during a given duration. Users will be injected at regular intervals.


 ![SimulationCurve RampUsers](../src/test/resources/img/rampUsers.png)