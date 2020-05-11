# EMart backend

Springboot microservice repository for FSD that includes Eureka Server, Zuul Gatway with JWT and Role Based Access, Spring Cloud Config Server, Hystrix (Circuit Breaker) 

## Frontend application written in Angular 9:  

Frontend repo can be found from here: [eMart Angular](https://github.com/Fribyter/eMart-angular)

## How to start

In order to run this entire backend repo you will need to start each application by the order: `Eureka Server > Gateway Server Zuul > Hystrix Dashboard > Buyer service > Seller service` 

## Eureka Server

Hosts eureka server

Port: 8761  

## Gateway Server Zuul  

Gateway for microservies, includes JWT and Role based Access 

Port: 8093  

## Hystrix Dashboard

Provide alternate methods in case of circuit break

Port: 8092


## Buyer service

Custom service provides buyer related data

Port: 8097


## Seller service

Custom service provides seller related data

Port: 8098
