### Random pause between two durations

Documentation from (https://gatling.io/docs/2.3/general/simulation_setup/)

To launch these simulations 
See example: `TestInjectionRandomPause`

To run the simulation you can use
`mvn gatling:execute -Dgatling.simulationClass=simulations.TestInjectionRandomPause`

The values for pauseTimeMin and pauseTimeMax are by default defined on the pom file. 
```
 <pauseTimeMin>1</pauseTimeMin>
 <pauseTimeMax>5</pauseTimeMax>
```

Ìf you want to change them , you need to modify the command adding them
`mvn gatling:execute -Dgatling.simulationClass=simulations.TestInjectionRandomPause -DpauseTimeMin=2 -DpauseTimeMax=10`


Here we define a method to add a random pause. You must insert time max and min. 
```
def randomPause(min:Int,max:Int) = scenario("Pause Scenario")
    .pause(min, max)
    .exec(scn)
```
