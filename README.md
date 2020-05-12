# EMart Backend

Springboot microservice repository for FSD that includes eureka server, Zuul gatway with JWT and role based access, Hystrix (Circuit Breaker) 

## Frontend Application Written In Angular 9:  

Frontend repo can be found from here: [eMart Angular](https://github.com/Fribyter/eMart-angular)

## How To Start

Get the mysql schema file from [schema.sql](https://github.com/Fribyter/eMart-backend/blob/master/schema.sql) and then get testing data from [data.sql](https://github.com/Fribyter/eMart-backend/blob/master/data.sql), in order to run this entire backend repo you will need to start each application by the order: `Eureka Server > Gateway Server Zuul > Hystrix Dashboard > Buyer service > Seller service` 

## Eureka Server

Hosts eureka server

Port: 8761  

## Gateway Server Zuul (Authentication service)

Gateway for microservies that includes spring security and JWT with role based access, token needed to access buyer, seller apis, please refer to README.MD in [gateway-server-zuul](https://github.com/Fribyter/eMart-backend/blob/master/gateway-server-zuul)

Port: 8093  

## Hystrix Dashboard

Provides alternate methods in case of circuit break

Port: 8092


## Buyer Service

Custom service provides buyer related data

Port: 8097


## Seller Service

Custom service provides seller related data

Port: 8098
