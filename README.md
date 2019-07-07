# msa-example
사내 교육 MSA


1.     Intellij 개발툴 설치 (https://www.jetbrains.com/idea/download/#section=mac)

2.     RabbitMQ 설치 (https://www.rabbitmq.com/download.html)

A.     사용자 추가

  i.         rabbitmqctl add_user config config
  
  ii.        rabbitmqctl set_user_tags config administrator
  
  iii.       rabbitmqctl set_permissions -p / config ".*" ".*" ".*"

B.      GUI Console사용하기

  i.         rabbitmq-plugins enable rabbitmq_management

3.     JDK 1.8 설치

4.     개발툴 세팅

A.     Preferences->Build->Compiler->Annotation Processors -> Enable annotation processing 체크

B.      Preferences->Plugins Lombok Plugin 설치

5.     빌드 및 실행 순서

A.     Cloudconfig

B.      Service-discovery

C.      Api-gateway

D.     Hystrix-dashboard

E.      Api-user,api-product,api-order,api-delivery

6.     WebGUI

A.     Eureka : http://localhost:9000

B.      Hystrix : http://localhost:8998/hystrix/monitor?stream=http://localhost:8998/turbine.stream

C.      RabbitMQ : http://localhost:15672

7.     API TEST

A.     User API : http://localhost:8081/v1/user/{id}

B.      Product API : http://localhost:8082/v1/product/{id}

C.      Order API : http://localhost:8083/v1/order/{id}

D.     Delivery API : http://localhost:8084/v1/delivery/{id}

E.      API Gateway : http://localhost:8000/{서비스도메인}/{API Endpoint}

                         i.         http://localhost:8000/user/v1/user/u001

                        ii.         http://localhost:8000/product/v1/product/0001

                       iii.         http://localhost:8000/order/v1/order?userId=u0002
