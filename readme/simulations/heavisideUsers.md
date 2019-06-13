Falabella Cyber Curve Draw
==========================

documentation from (https://gatling.io/docs/current/general/simulation_setup/#injection)

To launch this simulation go to ([HeavisideUsers](https://bitbucket.adessa.cl/projects/PERF/repos/performance-gatling-examples/browse/src/main/gatling/simulations/SimulationHeavisideUsers.scala))



Use this command to execute the test:

```
mvn gatling:execute -Dgatling.simulationClass=simulations.SimulationHeavisideUsers -Dgatling.URL="http://www.sodimac.cl/sodimac-cl/" -Dgatling.totalUser=50 -Dgatling.totalTime=2  -DrunMode=test
```

heavisideUsers(nbUsers) over(duration): Injects a given number of users following a smooth approximation of the heaviside step function stretched to a given duration

```
heavisideUsers(totalUsers.toInt) over (totalTimeMin minutes)
```

Insert `totalUsers` in command line
Insert `totalTimeMin` in command line

Example:

```
mvn gatling:execute -Dgatling.simulationClass=simulations.SimulationHeavisideUsers -Dgatling.URL="http://www.sodimac.cl/sodimac-cl/" -Dgatling.totalUser=50 -Dgatling.totalTime=2  -DrunMode=test
```

![HeavisideUsers](src/test/resources/img/HeavisideUsers.png)
