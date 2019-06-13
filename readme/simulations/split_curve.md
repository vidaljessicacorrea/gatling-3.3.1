Split Simulations
==========================

documentation from (https://gatling.io/docs/2.3/general/simulation_setup/)

To launch this simulation go to ([SplitSimulation](https://bitbucket.adessa.cl/projects/PERF/repos/performance-gatling-examples/browse/src/main/gatling/simulations/SimulationSplitTest.scala))

To test this simulation use: 

```
mvn gatling:execute -Dgatling.simulationClass=simulations.SimulationSplitTest -Dgatling.URL="http://www.sodimac.cl/sodimac-cl/" -Dgatling.totalUser=100 -Dgatling.totalTime=1  -DrunMode=test
```

This is the full code:
~~~
ScenarioTest.scn.inject(splitUsers(totalUsers.toInt).into(rampUsers(10) over (20 seconds)).separatedBy(15 seconds))
~~~


Specify the number of users that will be separated:
```
splitUsers(totalUsers.toInt)
```

Specify how it will be separated: using rampUsers and it will be separated every 15 seconds without sending users:
```
into(rampUsers(10) over (20 seconds)).separatedBy(15 seconds)
```


Result with 50 users:

![Simulation Curve](src/test/resources/img/splitCurve.png)
