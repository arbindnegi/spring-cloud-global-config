# spring-cloud-global-config

1) for the testing purpose, If you want to get the global configuration properties from local git repo then follow the below steps:

* clone this project in your local workspace
* In the spring-config-server service, please change the below property in bootstrap.properties or application.yml instead of git https url
   spring.cloud.config.server.git.uri=D:\\workspace\\spring-cloud-global-config\\config-git-repo
* git init
  git status
  git add .
  git commit -m "initial commit"
  
  * start spring-config-server
  * start spring-config-client
  
  Test the Global properties by using the below REST urls:
  spring-config-client:
  http://localhost:8080/msg
  http://localhost:8080/greeting
  
  pring-config-server
  http://localhost:8888/client-config/production
  http://localhost:8888/client-config/development
  http://localhost:8888/config-server-client/development
  