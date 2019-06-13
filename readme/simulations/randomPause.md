Random pause between two durations
==========================

documentation from (https://gatling.io/docs/2.3/general/scenario/?highlight=pause#pause)

To launch this simulation go to ([RandomPause](https://bitbucket.adessa.cl/projects/PERF/repos/performance-gatling-examples/browse/src/main/gatling/simulations/SimulationRandomPause.scala))

To run the simulation use:

```
mvn gatling:execute -Dgatling.simulationClass=simulations.SimulationRandomPause -Dgatling.URL="http://www.sodimac.cl/sodimac-cl/" -Dgatling.totalUser=60 -Dgatling.totalTime=1  -DrunMode=test -Dgatling.pauseTimeMin=1` `-Dgatling.pauseTimeMax=10
```
add `-Dgatling.pauseTimeMin=1` `-Dgatling.pauseTimeMax=10`


Here we define a method to add a random pause. You must insert time max and min. 
```
def randomPause(min:Int,max:Int) = scenario("Pause Scenario")
    .pause(min, max)
    .exec(scn)
```
