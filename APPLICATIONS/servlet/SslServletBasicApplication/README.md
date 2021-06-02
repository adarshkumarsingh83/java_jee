# SslServletBasicApplication

---

### To Build Code 
* mvn clean package 



### Application Url 			
* https://localhost:8443/SslServletBasicApplication
---


# To Enable SSL 
[Click to view step by step help for ssl configuration ](DOCUMENTS/TOMCAT_README.md)

```
$ keytool -genkeypair -alias <MyCert> -keyalg <RSA> -keystore <"Usrs\MyCert.cert">


 <Connector port="8443" 
            protocol="org.apache.coyote.http11.Http11NioProtocol" 
            SSLEnabled="true"
            maxThreads="150" 
			scheme="https" 
			secure="true"
            clientAuth="false" 
			sslProtocol="TLS" 

		
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