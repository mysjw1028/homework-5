# 연습문제 MyBatis

### 1. View 생성
- 상품등록 페이지
- 상품목록 페이지 (html table 사용)
- 상품상세보기 페이지 (삭제, 수정)
- 상품수정 페이지

### 2. 기능 (ajax 필요 없음) (서비스 만들 필요 없음)
- 상품 등록(post - form태그)  주소 : /product/add
- 상품 목록보기(get) 주소 : /product
- 상품 상세보기(get) 주소 : /product/{id}
- 상품 삭제하기(post - form태그) : /product/{id}/delete
- 상품 수정하기(post - form태그) : /product/{id}/edit

## 3. 고급 기능
- 상품 등록시 동일한 상품명 못들어가게 하기

###
admin
-> 회원가입시 user와 같은 페이지를 공유하기 때문에 user_name을 넣어 준 후 자바스크립트에
 onclick="javascript: form.action='/admin/login'; 를 걸어줬다.
 mainadmin
 -> admin/ user 관리를 위해서 테이블 생성 (로그인 / 회원가입도 별도로 만들예정)
 ->  중앙관리자용 패스워드 미 입력시 가입 및 로그인 불가
 
### 4. 테이블 생성
```sql
create table product(
    product_id int primary KEY auto_increment,
    product_name varchar(20) NOT null,
    product_price INT NOT null,
    product_qty INT NOT null,
    created_at TIMESTAMP NOT null
);

create table users(
    users_id int KEY auto_increment,
    user_name varchar(20) NOT null,
    password varchar(20) NOT null,
    email varchar(20) NOT null,
    created_at TIMESTAMP NOT null
);
create table buy(
    id int primary KEY auto_increment,
    users_id INT,
    product_id INT,
    buy_qty INT,
    buy_price INT,
    buy_name VARCHAR(50),
    created_at  TIMESTAMP
);
create table admin(
 	id int KEY auto_increment,
   admin_name varchar(20) NOT null,
   user_name varchar(20),
   password varchar(20) NOT null,
   email varchar(20) NOT null,
   created_at TIMESTAMP NOT null
);

create table mainadmin(
 	id int KEY auto_increment,
   mainadmin_name varchar(20) NOT null,
   password varchar(20) NOT null,
   password_mainadmin varchar(20) NOT NULL,
   email varchar(20) NOT null,
   created_at TIMESTAMP NOT null
);
```

### 5. 더미데이터
```sql
INSERT INTO product(product_name, product_price, product_qty, created_at) VALUES('바나나', 3000, 98, NOW());
INSERT INTO product(product_name, product_price, product_qty, created_at) VALUES('딸기', 2000, 100, NOW());

INSERT INTO users(users_id, user_name,PASSWORD, email,created_at) VALUES('1', 'ssar','1234','ssar@nate.com', NOW());
INSERT INTO users(users_id, user_name,PASSWORD, email,created_at) VALUES('2', 'cos','1234','cos@nate.com', NOW());
INSERT INTO users(users_id, user_name,PASSWORD, email,created_at) VALUES('3', 'apple','1234','apple@nate.com', NOW());

insert into admin(admin_name, password, email, created_at) values('mango', '1234', 'mango@nate.com', NOW());

```
