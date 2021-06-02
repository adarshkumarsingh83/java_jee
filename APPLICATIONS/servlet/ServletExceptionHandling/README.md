# BasicApplication

---

### To Build Code 
* mvn clean package 


---

## Mysql Docker Image Operation  

### To list the local docker images
* $ docker images

### To pull the mysql image to the local
* $ docker pull mysql

### To run the mysql docker image
* $ docker run --name [mysql-instance-name] -e MYSQL_ROOT_PASSWORD=[root-user-ped] -e MYSQL_DATABASE=[mysql-db-name] -d mysql:[5.6]]
* $ docker run --name espark-mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root  -e MYSQL_DATABASE=espark  -d mysql:latest

### Docker container listing
* $ docker container ls

### Docker process list 
* $ docker ps -a

# to delete docker 
$ docker rm -f espark-mysql