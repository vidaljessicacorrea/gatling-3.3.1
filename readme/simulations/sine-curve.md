### Sine Curve
Documentation from (https://gatling.io/docs/2.3/general/simulation_setup/)

To launch these simulations 
See example: `TestInjectionSineCurve`

to simulate the curves I use heavisideUsers in the simulation:

```
    ScenarioTest.scn.inject(
      heavisideUsers(200) over (1 minutes),
      heavisideUsers(200) over (1 minutes),
      heavisideUsers(200) over (1 minutes)
```
heavisideUsers(nbUsers) over(duration): Injects a given number of users following a smooth approximation of the heaviside step function stretched to a given duration.

![SineCurve](img/sine-curve-A.png)
