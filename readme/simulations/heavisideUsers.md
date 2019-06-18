### HeavisideUsers
Documentation from (https://gatling.io/docs/current/general/simulation_setup/#injection)
To launch these simulations 
See example: `TestInjectionHeavisideUsers`

Injects a given number of users following a smooth approximation of the heaviside step function stretched to a given duration

```
heavisideUsers(totalUsers.toInt) over (totalTimeMin minutes)
```

![HeavisideUsers](img/HeavisideUsers.png)
