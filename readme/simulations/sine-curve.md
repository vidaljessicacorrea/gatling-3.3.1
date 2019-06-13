Sine Curve
==========================

documentation from (https://gatling.io/docs/current/general/simulation_setup/#injection)

To launch this simulation go to ([SineCurve](https://bitbucket.adessa.cl/projects/PERF/repos/performance-gatling-examples/browse/src/main/gatling/simulations/SineCurveSimulationTest.scala))

Use the next command to execute the test:

```
mvn gatling:execute -Dgatling.simulationClass=simulations.SineCurveSimulationTest -Dgatling.URL="http://www.sodimac.com/sodimac-cl/" -Dgatling.totalUser=1 -Dgatling.totalTime=1 -DrunMode=test
```

to simulate the curves I use heavisideUsers in the simulation:

```
    ScenarioTest.scn.inject(
      heavisideUsers(200) over (1 minutes),
      heavisideUsers(200) over (1 minutes),
      heavisideUsers(200) over (1 minutes)
```
heavisideUsers(nbUsers) over(duration): Injects a given number of users following a smooth approximation of the heaviside step function stretched to a given duration.

![SineCurve](src/test/resources/img/sine-curve-A.png)
