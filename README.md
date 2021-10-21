# Currencies And Gifs
## Техническое задание
Создать сервис, который обращается к сервису курсов валют, и отображает gif:       
если курс по отношению к USD за сегодня стал выше вчерашнего, то отдаем рандомную [отсюда](https://giphy.com/search/rich)   
если ниже - [отсюда](https://giphy.com/search/broke)   
**Ссылки**  
[REST API курсов валют](https://docs.openexchangerates.org/)   
[REST API гифок](https://developers.giphy.com/docs/api#quick-start-guide)   
**Must Have**   
Сервис на Spring Boot 2 + Java / Kotlin   
Запросы приходят на HTTP endpoint(должен быть написан в соответствии с rest conventions), туда передается код валюты по отношению с которой сравнивается USD  
Для взаимодействия с внешними сервисами используется Feign   
Все параметры (валюта по отношению к которой смотрится курс, адреса внешних сервисов и т.д.) вынесены в настройки   
На сервис написаны тесты (для мока внешних сервисов можно использовать @mockbean или WireMock)   
Для сборки должен использоваться Gradle   
Результатом выполнения должен быть репо на GitHub с инструкцией по запуску   
**Nice to Have**   
Сборка и запуск Docker контейнера с этим сервисом»
***
## Stack
- Open JDK 11
- Spring Boot (Web, Thymeleaf)
- Spring Cloud (OpenFeign)
- Lombok
- JUnit 5
***
## Запуск
- Склонировать репозиторий, выполнив команду:   
  `git clone https://github.com/V0B0/CurrenciesAndGifs.git`
- Перейдя в корневую папку проекта собрать проект:    
  `gradlew build`
- Собрать докер-образ с произвольным именем, в нашем случае task:    
  `docker image build -t task .`
- Запустить контейнер с нашим образом:   
  `docker run -p 8081:8081 docker.io/library/task`
***
## Endpoint
- `/api/gif`  
  Возвращает гифку в зависимости от выбранной валюты   
  **Parameters**   
  code: string (AED)   
  **_Пример_**   
  `http://localhost:8081/api/gif?code=AED`
