![Generic badge](https://img.shields.io/badge/Java-11-yellowgreen.svg)
![Generic badge](https://img.shields.io/badge/SpringBoot-2.7.8-green.svg)
![Generic badge](https://img.shields.io/badge/H2-blue.svg)
![Generic badge](https://img.shields.io/badge/JPA-white.svg)
![Generic badge](https://img.shields.io/badge/Gradle-black.svg)

### ๐ ๊ธฐ์ 
- Java, Spring Boot
- H2, JPA, Gradle, Swagger2

> * ๋ชจ๋  API๋ Swagger์์ ํ์ธ ๊ฐ๋ฅํฉ๋๋ค. (http://localhost:8080/swagger-ui.html)
> * DB๋ http://localhost:8080/h2-console/ ํ์ธ ๊ฐ๋ฅํฉ๋๋ค.

<br>

### ๐ ๊ตฌํ๋ฐฉ๋ฒ (๋ฆฌ๋์ค)
> * sudo apt install java-11-amazon-corretto-headless > ์ค์น
> * ./gradlew build > ๋น๋ > ์ฑ๊ณต์ ์ผ๋ก ๋์์ผ๋ฉด build ํด๋ ์ด๋ > jar ํ์ผ ์์ฑ ํ์ธ
> * java -jar ....jar > ์คํ๋ง๋ถํธ ์คํ


### ๐ ๊ฒ์ฆ๊ฒฐ๊ณผ
> swagger๋ฅผ ํ์ฉํ์ฌ ๊ฒ์ฆ๊ฒฐ๊ณผ ํ์ธํ์์ต๋๋ค.

### ๐ ๊ตฌํ์ฌ๋ถ
> * Menu - ๋ฉ๋ด ํ์ด๋ธ
> * Banner - ์์ ๋ฉ๋ด์ ๋ฐฐ๋ ๋ฑ๋ก ์ด๋ฏธ์ง
    <br>

## API ๋ช์ธ์

1. ๋ฉ๋ด ๋ฑ๋ก(POST:/menu)

* ParentsId -> ๋ฉ๋ด์์ ๋ถ๋ชจ๊ฐ ์ฆ, ํ์ ๋ฉ๋ด์ผ ๊ฒฝ์ฐ 0 ๋ณด๋ค ํฐ ๊ฐ์ ๊ฐ์ง๊ฒ ๋จ.
- ParentsId๊ฐ null์ผ ๊ฒฝ์ฐ ์์ ๋ฉ๋ด๋ก ๋ฑ๋ก ๋จ / ์ด๋ฏธ์ง ๋ฑ๋ก ์ฒ๋ฆฌ 
- ์์ ๋ฉ๋ด์ ๊ฒฝ์ฐ ์ด๋ฏธ์ง๊ฐ ํ์๋ก ํ์ํจ
- ์ด๋ฏธ์ง๋ ๋ก์ปฌ์ ์ ์ฅ ๋จ (dir/ํ์ผ๋ช์ banner ํ์ด๋ธ์ ์ ์ฅ)

```
response Code - 200
```
<br>
2. ๋ฉ๋ด ์์  (PATCH:/menu/{menuId})

  <br>

```
response Code - 200
```

<br>
3. ๋ฉ๋ด ์ญ์  (DELETE:/menu/{menuId})

  <br>

```
response Code - 200
```
<br>
4. ์ ์ฒด ์กฐํ (GET:/menu)

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
    "title": "ํ์1-1",
    "createDate": "2023-02-23 09:56:12",
    "updateDate": "2023-02-23 09:56:12"
  },
  {
    "seqNo": 3,
    "parentsId": 1,
    "bannerId": null,
    "title": "ํ์1-2",
    "createDate": "2023-02-23 09:56:12",
    "updateDate": "2023-02-23 09:56:12"
  }
]
```
<br>
5. ๋จ์ผ ์กฐํ (GET:/menu/{menuId})

- ์์๋ฉ๋ด ์กฐํ์ ํ์๊น์ง ๋ธ์ถ
  <br>

```
response:
[
  {
    "seqNo": 1,
    "parentsId": 0,
    "bannerId": null,
    "title": "์์1",
    "createDate": "2023-02-23 10:46:02",
    "updateDate": "2023-02-23 10:46:02"
  },
  {
    "seqNo": 2,
    "parentsId": 1,
    "bannerId": null,
    "title": "ํ์1-1",
    "createDate": "2023-02-23 10:46:02",
    "updateDate": "2023-02-23 10:46:02"
  },
  {
    "seqNo": 3,
    "parentsId": 1,
    "bannerId": null,
    "title": "ํ์1-2",
    "createDate": "2023-02-23 10:46:02",
    "updateDate": "2023-02-23 10:46:02"
  }
]
```


![header](https://capsule-render.vercel.app/api?type=egg&color=auto&height=300&section=header&text=Thank+You&fontSize=70)
Copyright ยฉ pyk. All rights reserved