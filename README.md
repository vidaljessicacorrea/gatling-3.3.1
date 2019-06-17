Gatling Examples
============================

Here you will find some examples of how to use gatling. If you have any question we are following the documentation of [Gatling](https://gatling.io/docs/current/)

## How to run test

     gatling:execute -Dgatling.simulationClass=[Simulation path] -Dgatling.URL="[URL BASE]" -Dgatling.totalUser=[users per second] -Dgatling.totalTime=[time in minutes]  -DrunMode=[trace,debug,info,test]

## Examples
### [Scenario](readme/scenarios.md)
### [Feeders](readme/feeders.md)
### [Checks](readme/checks.md)
### [Simulation Injections](readme/simulations.md)
### [Configuration](readme/configurations.md)
