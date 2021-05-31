## To  Download tomcat 
* https://tomcat.apache.org/index.html
	* downloads -> version 
* for mac/linux -> tar.gz 
* for windows -> 64bitXXX.zip

### for Running 
* unzip the file and go to the  ~/TomcatXXX/bin
* for start $ sh startup.sh 
* for stopping $  sh shutdown.sh


### for deployment 
* create a war file of the application and copy it in below location 
* ~/TomcatXXX/webapps 



### for user creation in tomcat 
* ~/TomcatXXX/conf/tomcat-users.xml



```
  <role rolename="tomcat"/>
  <role rolename="admin"/>
  <role rolename="user"/>
  <user username="tomcat" password="tomcat" roles="tomcat"/>
  <user username="user" password="user" roles="user"/>
  <user username="admin" password="admin" roles="admin"/>

```