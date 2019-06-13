Nothing For
===========

Documentation from (https://gatling.io/docs/2.3/general/simulation_setup/)

To see this simulation go to ([NothingFor](https://bitbucket.adessa.cl/projects/PERF/repos/performance-gatling-examples/browse/src/main/gatling/simulations/NothingFor.scala))

To launch this simulation you must to execute the follow command:


```
mvn gatling:execute -Dgatling.simulationClass=simulations.NothingFor -Dgatling.URL="http://www.sodimac.cl" -Dgatling.totalUser=1 -Dgatling.totalTime=1
```

In this simulation we going to apply some native functions inside the function setUp(), in this case the rule was "Create a simulation that allows:
To inject 100 users at same time, after 10 sec inject 50 users more"

```
ScenarioTest.scn.inject(atOnceUsers(100), nothingFor(10 seconds), atOnceUsers(50))
```

here we called any scenario, then we apply the native functions inside the setUp; in this case we used
```
atOneceUsers
```
with this function we can inject any user number at the same time, after that we apply the function
```
nothingFor
```
With this function we can make a pause during the simulation or if we want see that in another way, with this function we can tell to the simulation that don't do nothing for the time that we stipulate during the simulation,
then we used again the same function  that we used in the beginning to inject many users at the same time

![Simulation Curve](../src/test/resources/img/nothingForCurve.png)