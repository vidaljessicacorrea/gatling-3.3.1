Constant User Per Sec Normal and Random
=======================================


documentation from (https://gatling.io/docs/2.3/general/simulation_setup/)

To see this simulation go to ([ConstantUsersPerSecNormalInjection](https://bitbucket.adessa.cl/projects/PERF/repos/performance-gatling-examples/browse/src/main/gatling/simulations/ConstantUsersPerSecNormalInjection.scala))
([ConstantUsersPerSecRandomInjection](https://bitbucket.adessa.cl/projects/PERF/repos/performance-gatling-examples/browse/src/main/gatling/simulations/ConstantUsersPerSecRandomInjection.scala))

to launch this simulation you must to execute the follow command:

```
mvn gatling:execute -Dgatling.simulationClass=simulations.ConstantUsersPerSecNormalInjection -Dgatling.URL="http://www.sodimac.cl" -Dgatling.totalUser=1 -Dgatling.totalTime=1
```
or
```
mvn gatling:execute -Dgatling.simulationClass=simulations.ConstantUsersPerSecRandomInjection -Dgatling.URL="http://www.sodimac.cl" -Dgatling.totalUser=1 -Dgatling.totalTime=1
```


in those two simulation we use the native function constantUserPerSec() inside the setUp.

when we used the normal type of the simulation we can injects users at a constant rate, defined in users per second, during a given duration. Users will be injected at regular intervals.
```
 setUp(
    ScenarioTest.scn.inject(constantUsersPerSec(users) during(totalTimeMin minutes))
  ).protocols(httpConf)
```

![Simulation ConstantUserPerSecNormal](../src/test/resources/img/CurveConstantUserPerSecNormal.png)

in the other simulation you can see that Injects users at a constant rate, defined in users per second, during a given duration. Users will be injected at randomized intervals.
```
setUp(
    ScenarioTest.scn.inject(constantUsersPerSec(users) during(totalTimeMin minutes) randomized)
  ).protocols(httpConf)
```
![Simulation CurveConstantUserPerSecRandom](../src/test/resources/img/CurveConstantUserPerSecRandom.png)

