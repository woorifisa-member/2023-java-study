# 우리FISA JPA 관계 설정 실습

## TODO

1. CarLocation 클래스 활용
   * Car - Location N:M (다대다) 관계를 CarLocation 테이블을 활용해서
   * Car - CarLocation N:1, CarLocation - Location 1:M 으로 만들기

2. 모든 테이블 적절한 PK 설정

3. 모든 클래스를 `@OneToMany`, `@ManyToOne` 활용해서 양방향 관계 설정하기

4. `Lombok` 활용

> 기준 ERD https://gitmind.com/app/docs/fw8j8nst
> 참고: https://tecoble.techcourse.co.kr/post/2021-07-30-jpa-mapping/
