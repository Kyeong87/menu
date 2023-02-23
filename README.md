![Generic badge](https://img.shields.io/badge/Java-11-yellowgreen.svg)
![Generic badge](https://img.shields.io/badge/SpringBoot-2.7.8-green.svg)
![Generic badge](https://img.shields.io/badge/H2-blue.svg)
![Generic badge](https://img.shields.io/badge/JPA-white.svg)
![Generic badge](https://img.shields.io/badge/Gradle-black.svg)

### 📌 기술
- Java, Spring Boot
- H2, JPA, Gradle, Swagger2

> * 모든 API는 Swagger에서 확인 가능합니다. (http://localhost:8080/swagger-ui.html)
> * DB는 http://localhost:8080/h2-console/ 확인 가능합니다.

<br>

### 📌 구현방법 (리눅스)
> * sudo apt install java-11-amazon-corretto-headless > 설치
> * ./gradlew build > 빌드 > 성공적으로 되었으면 build 폴더 이동 > jar 파일 생성 확인
> * java -jar ....jar > 스프링부트 실행


### 📌 검증결과
> swagger를 활용하여 검증결과 확인하였습니다.

### 📌 구현여부
> * Menu - 메뉴 테이블
> * Banner - 상위 메뉴에 배너 등록 이미지
    <br>

## API 명세서

1. 메뉴 등록(POST:/menu)

* ParentsId -> 메뉴에서 부모값 즉, 하위 메뉴일 경우 0 보다 큰 값을 가지게 됨.
- ParentsId가 null일 경우 상위 메뉴로 등록 됨 / 이미지 등록 처리 
- 상위 메뉴의 경우 이미지가 필수로 필요함
- 이미지는 로컬에 저장 됨 (dir/파일명은 banner 테이블에 저장)

```
response Code - 200
```
<br>
2. 메뉴 수정 (PATCH:/menu/{menuId})

  <br>

```
response Code - 200
```

<br>
3. 메뉴 삭제 (DELETE:/menu/{menuId})

  <br>

```
response Code - 200
```
<br>
4. 전체 조회 (GET:/menu)

  <br>

```
response:
[
  {
    "seqNo": 1,
    "parentsId": null,
    "bannerId": null,
    "title": null,
    "createDate": "2023-02-23 09:56:12",
    "updateDate": "2023-02-23 10:34:49"
  },
  {
    "seqNo": 2,
    "parentsId": 1,
    "bannerId": null,
    "title": "하위1-1",
    "createDate": "2023-02-23 09:56:12",
    "updateDate": "2023-02-23 09:56:12"
  },
  {
    "seqNo": 3,
    "parentsId": 1,
    "bannerId": null,
    "title": "하위1-2",
    "createDate": "2023-02-23 09:56:12",
    "updateDate": "2023-02-23 09:56:12"
  }
]
```
<br>
5. 단일 조회 (GET:/menu/{menuId})

- 상위메뉴 조회시 하위까지 노출
  <br>

```
response:
[
  {
    "seqNo": 1,
    "parentsId": 0,
    "bannerId": null,
    "title": "상위1",
    "createDate": "2023-02-23 10:46:02",
    "updateDate": "2023-02-23 10:46:02"
  },
  {
    "seqNo": 2,
    "parentsId": 1,
    "bannerId": null,
    "title": "하위1-1",
    "createDate": "2023-02-23 10:46:02",
    "updateDate": "2023-02-23 10:46:02"
  },
  {
    "seqNo": 3,
    "parentsId": 1,
    "bannerId": null,
    "title": "하위1-2",
    "createDate": "2023-02-23 10:46:02",
    "updateDate": "2023-02-23 10:46:02"
  }
]
```


![header](https://capsule-render.vercel.app/api?type=egg&color=auto&height=300&section=header&text=Thank+You&fontSize=70)
Copyright © pyk. All rights reserved