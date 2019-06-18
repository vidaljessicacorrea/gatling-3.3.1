### rampUsersPerSec using randomized
Documentation from (https://gatling.io/docs/2.3/general/simulation_setup/#injection)
To launch these simulations 
See example: `TestInjectionRampRandom`

Random:
rampUsersPerSec(rate1) to(rate2) during(duration) randomized`

Injects users from starting rate to target rate, defined in users per second, during a given duration. `
*Users will be injected at randomized intervals*.

```
ScenarioTest.scn.inject(rampUsersPerSec(2) to (10) during(3 minutes) randomized)
````

![random](img/random.png)


### rampUsersPerSec not using random
Documentation from (https://gatling.io/docs/2.3/general/simulation_setup/#injection)

To launch these simulations 
See example: `TestInjectionRampNotRandom`

Not Random:
`rampUsersPerSec(rate1) to (rate2) during(duration)`

Injects users from starting rate to target rate, defined in users per second, during a given duration. 
*Users will be injected at regular intervals*.

```
ScenarioTest.scn.inject(rampUsersPerSec(2) to (10) during(3 minutes))
```
![not random](img/notrandom.png)
