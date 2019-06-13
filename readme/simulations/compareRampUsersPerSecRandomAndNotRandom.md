Compare rampUsersPerSec using randomized and not random
==========================

documentation from (https://gatling.io/docs/2.3/general/simulation_setup/#injection)

To launch this simulation go to ([RandomSimulation](https://bitbucket.adessa.cl/projects/PERF/repos/performance-gatling-examples/browse/src/main/gatling/simulations/SimulationRampNotRandom.scala))
and ([NotRandomSimulation](https://bitbucket.adessa.cl/projects/PERF/repos/performance-gatling-examples/browse/src/main/gatling/simulations/SimulationRampRandom.scala))

Random:
rampUsersPerSec(rate1) to(rate2) during(duration) randomized: Injects users from starting rate to target rate, defined in users per second, during a given duration. *Users will be injected at randomized intervals*.
```
ScenarioTest.scn.inject(rampUsersPerSec(2) to (10) during(3 minutes) randomized)
```
![random](src/test/resources/img/random.png)


Not Random:
rampUsersPerSec(rate1) to (rate2) during(duration): Injects users from starting rate to target rate, defined in users per second, during a given duration. *Users will be injected at regular intervals*.
```
ScenarioTest.scn.inject(rampUsersPerSec(2) to (10) during(3 minutes))
```
![not random](src/test/resources/img/notrandom.png)
