package com.hmahn.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

// 인터페이스 생성 후, JpaRepository<Entity 클래스, PK 타입>을 상속하면, 기본적인 CRUD 메소드가 자동 생성됨
// Repository 인터페이스는 Entity 클래스와 같은 경로에 같이 있어야한다.
public interface PostsRepository extends JpaRepository<Posts, Long>{}
