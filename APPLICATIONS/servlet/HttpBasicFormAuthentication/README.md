# HttpBasicFormAuthentication

---

### To Build Code 
* mvn clean package 
* war will in side the ~/HttpBasicFormAuthentication/target/HttpBasicFormAuthentication.war


### Url 
* http://localhost:8080/
---


## To  Download tomcat 
* https://tomcat.apache.org/index.html
	* downloads -> version 
* for mac/linux -> tar.gz 
* for windows -> 64bitXXX.zip


### for user creation in tomcat 
* ~/TomcatXXX/conf/tomcat-users.xml


```

 <role rolename="manager-gui"/>
  <role rolename="tomcat"/>
  <role rolename="admin"/>
  <role rolename="user"/>
  <user username="tomcat" password="tomcat" roles="tomcat,manager-gui"/>
  <user username="user" password="user" roles="tomcat,admin"/>
  <user username="admin" password="admin" roles="admin"/>

```


### for deployment 
* create a war file of the application and copy it in below location 
* ~/TomcatXXX/webapps 

### for starting and stopping  
* unzip the file and go to the  ~/TomcatXXX/bin
* for start $ sh startup.sh 
* for stopping $  sh shutdown.sh


### to view the application on tomacat 
* http://localhost:8080/manager/html
* provide tomcat/tomcat 