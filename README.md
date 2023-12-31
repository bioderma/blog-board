**프로젝트 소개: [Blog-Board]**

[**Blog-Board**]은 사용자들이 커뮤니케이션하고 정보를 공유하는데 사용되는 온라인 게시판 프로젝트입니다. 이 프로젝트는 다양한 사용자들이 글을 작성하고 댓글을 남기며 의견을 나눌 수 있는 공간을 제공합니다.

**주요 기능:**

- 게시물 작성 및 편집: 사용자들은 다양한 주제에 대한 게시물을 작성하고 편집할 수 있습니다.
- 댓글 기능: 게시물에 댓글을 남길 수 있으며, 사용자 간의 대화를 가능하게 합니다.
- 검색 기능: 사용자들은 제목이나 내용을 기반으로 게시물을 검색하여 원하는 정보를 빠르게 찾을 수 있습니다.
- 회원 가입 및 로그인: 회원가입을 통해 사용자 인증을 관리하며, 로그인한 사용자만 게시물 작성과 댓글 등의 활동이 가능합니다.

- ### 과정

---

- 1일차:
프로젝트 생성 및 Spring Boot 설정
MySQL 데이터베이스 설정

- 2일차~3일차:
회원가입 기능 구현
회원가입 폼 생성 및 회원 정보 저장 기능 구현

- 4일차:
로그인 기능 구현
로그인 폼 생성 및 로그인 처리 로직 구현
카카오 로그인 처리 추가
Bootstrap을 이용하여 로그인 폼 디자인 개선, Spring Security를 활용하여 로그인 처리 로직 구현
https://getbootstrap.com/

- 5일차~6일차:
카카오 로그인 기능 구현
OAuth 인증 프로토콜을 하드코딩하여 구현 시도
OAuth 인증 프로토콜을 처음 다뤄보는 것이 어려웠습니다. 카카오 로그인의 복잡한 흐름을 이해하고 코드로 구현하는 것이 어려웠습니다.
ChatGPT를 활용하여 OAuth 인증 프로토콜의 개념과 흐름을 이해하고, 온라인 자료를 참고하여 구현했습니다.
예제 코드와 가이드를 따라가며 단계별로 구현하는 것이 도움이 되었습니다.
[https://velog.io/@hwan2da/Spring-카카오-로그인-구현하기](https://velog.io/@hwan2da/Spring-%EC%B9%B4%EC%B9%B4%EC%98%A4-%EB%A1%9C%EA%B7%B8%EC%9D%B8-%EA%B5%AC%ED%98%84%ED%95%98%EA%B8%B0)

- 7일차:
회원 정보 수정 페이지 구현
회원 정보 수정 폼 생성 및 현재 회원 정보 불러오는 기능 구현
회원 정보를 수정하는 페이지를 처음 구현하면서, 기존 회원 정보를 폼에 불러오는 부분과 폼 데이터를 처리하는 부분에서 어려움이 있었습니다.
JSP 사용하여 회원 정보를 폼에 불러오는 방법을 익혔고, Spring MVC를 활용하여 폼 데이터를 처리하도록 구현했습니다.

- 8일차:
회원 정보 수정 처리 기능 구현
회원 정보 수정 처리 로직 구현

- 9일차:
게시판 제목 검색 기능 구현
제목을 검색하여 결과가 나오도록 기능 추가
게시판에서 제목 검색 기능을 처음 구현하는 것이 어려웠습니다. 데이터베이스에서 특정 조건에 맞는 데이터를 검색하는 방법을 찾아야 했습니다.
Spring Data JPA의 findByTitleContaining과 같은 메서드를 사용하여 제목을 포함한 게시물을 검색하는 기능을 구현했습니다.

- 10일차~14일차:
게시판 CRUD 기능 구현
게시글 생성, 조회, 수정, 삭제 기능 추가
댓글 기능 구현
- 게시글의 생성, 조회, 수정, 삭제 기능을 구현하는 것과 댓글 기능을 추가하는 것이 복잡하게 느껴졌습니다.
각 기능별로 컨트롤러와 서비스 계층을 적절히 분리하여 기능을 구현했습니다. 또한, 댓글의 경우 별도의 테이블로 구현하고 게시글과의 관계를 맺어서 구현했습니다.
