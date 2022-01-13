## 소개

`server-info`는 가상환경에서 더미 서버가 필요하여 만든 개인 프로젝트입니다.



## 빌드 및 실행 방법

```sh
$ ./gradlew build -x test
$ java -jar build/libs/server-info-v1.0.jar --spring.profiles.active=default --spring.application.version=v1.91 --server.port=80
```

## 도커 파일 빌드
```shell
$ docker build --no-cache . -t test:v1
$ docker run -d -i -t -p 8080:8080 -e SPRING_PROFILES_ACTIVE='default' -e SPRING_APPLICATION_VERSION='v1.9' --hostname test --name test test:v1
$ docker exec -it test /bin/sh
```



## 사용법

### 헬스체크

```sh
$ curl "http://localhost:8081/health_check" 
{
    "status": "UP"
}
```





### 기본정보 조회

```sh
$ curl "http://localhost:8081"
{
    "applicationName": "server-info",
    "hostname": "DESKTOP-RPEA1P6",
    "ip": "172.19.96.1",
    "osName": "Windows 10",
    "processId": "7728",
    "threadCount": 17,
    "availableProcessors": 4,
    "physicalMemorySize": "31 GB",
    "profiles": [
    	"default"
    ]
}
```



```sh
$ jps -ml
20928 jdk.jcmd/sun.tools.jps.Jps -ml
18876 com.jh.app.Application
```





### 환경변수 모두 조회

```sh
$ curl "http://localhost:8081/env/list"
{
    "awt.toolkit":"sun.awt.windows.WToolkit",
    "java.specification.version":"11",
    "sun.cpu.isalist":"amd64",
    "sun.jnu.encoding":"MS949",
    "SESSIONNAME":"Console",
    "ALLUSERSPROFILE":"C:\\ProgramData",
    "sun.arch.data.model":"64",
    ...
}
```





### 환경변수 조회

```sh
$ curl "http://localhost:8081/env?name=JAVA_HOME"
{
    "JAVA_HOME":"/usr/local/java"
}
```





### 지정시간 대기 

지정된 시간(단위 : 초)만큼 대기(Thread.sleep 함수 사용)하고, 응답을 합니다.

```sh
$ curl -X GET "http://localhost:8081/wait?secs=5"
{
    "elapsedAt": 5055,
    "startAt": "2021-06-06 16:53:10.409",
    "finishAt": "2021-06-06 16:53:15.464"
}
```



### Shutdown

```sh
$ curl -X GET "http://localhost:8081/shutdown"
```





## Reference

* 
* 

