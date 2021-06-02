# SslServletBasicApplication

---

### To Build Code 
* mvn clean package 



### Application Url 			
* https://localhost:8443/applicationContext
---


# To Enable SSL 

## ON Mac 


## ON Windows 
```
c:\adarsh>keytool -genkeypair -alias <MyCert> -keyalg <RSA> -keystore <"c:\MyCert.cert">


 <Connector port="8443" 
            protocol="org.apache.coyote.http11.Http11NioProtocol" 
            SSLEnabled="true"
            maxThreads="150" 
			scheme="https" 
			secure="true"
            clientAuth="false" 
			sslProtocol="TLS" 
			keystoreFile="C://MyCert.cert"
			keystorePass="adarsh" />

		
web.xml insede web app tag
--------------
<web-app>
		.................

		<security-constraint>			 
			 <web-resource-collection>
				   <web-resource-name>applicationName</web-resource-name>
				   <url-pattern>/*</url-pattern>   
			 </web-resource-collection>
			 
			 <user-data-constraint>
				  <transport-guarantee>CONFIDENTIAL</transport-guarantee>
			 </user-data-constraint>			 
		</security-constraint>	
		
		.................
</web-app>
```
![img](help/1-image.png)
![img](help/2-image.png)
![img](help/3-image.png)
![img](help/4-image.png)
![img](help/5-image.png)
![img](help/6-image.png)
![img](help/7-a-image.png)
![img](help/7-b-image.png)
![img](help/8-image.png)
![img](help/9-image.png)
![img](help/10-image.png)
![img](help/11-image.png)
![img](help/12-image.png)
![img](help/13-image.png)
![img](help/14-image.png)
![img](help/15-image.png)
![img](help/16-image.png)
![img](help/17-image.png)
![img](help/18-image.png)
![img](help/19-image.png)