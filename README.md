# likelion-backend-8-project
익명 의견 교환 웹 페이지
### 프로젝트 개요

---

사용자들이 자기 자신의 정보를 직접 드러낼 필요 없이 의견을 교환할 수 있는 웹 페이지를 만들어보아요!
단, 자신이 누군지를 드러낼 필요는 없지만 작성한 사람이 원한다면 수정 ∙ 삭제는 가능해야합니다.
# Entity

---
## 미션 수행
### [게시판](#1.-게시판-기능)
### [게시글](#2.-게시글-기능)
### [댓글](#3.-댓글-기능)

---

## Board - Article
![boardArticle](image/Article%20-%20Comment.png)
## Article - Comment
![ArticleBoard](image/Board%20-%20Article.png)

---

# Function

---

## 1. 게시판 기능

- 게시판은 같은 주제의 게시글을 모아둔 단위를 의미한다.

## 게시판의 목록과, 선택된 게시판의 게시글 목록을 볼 수 있는 화면

### 엔드포인트

- 게시판 보기: `/boards/{:boardId}`
### 실행 결과
![image](image/Untitled.png)
- 게시판 목록의 링크를 선택하면, 해당 게시판에 작성된 게시글 제목만 목록으로 출력되는 화면으로 이동
    - 게시판 내에 게시글이 없는 경우와 게시글이 있는 경우로 구분
- 게시판 내에 게시글이 없는 경우
![image](image/Untitled%20(1).png)
- 게시판 내에 게시글이 있는 경우
![image](image/Untitled%20(2).png)
---

## 2. 게시글 기능

## 게시글을 작성할 수 있다

### 엔드포인트

- 게시글 작성하기: `/boards/{:boardId}/article`
### 실행 결과
![image](image/Untitled%20(3).png)
- 게시글이 정상적으로 저장되면 게시판 내에 추가
![image](image/Untitled%20(4).png)
  ![image](image/Untitled%20(5).png)

---

## 게시글 단일 조회 화면

### 엔드포인트

- 게시글 보기: `/article/{:articleId}`

### 실행 결과
- 게시글이 상세 보기됨
![image](image/Untitled%20(6).png)
![image](image/Untitled%20(7).png)

--- 

## 게시글을 수정하는 페이지

### 엔드포인트

- 게시글 수정하기: `/article/{:articleId}/update`
### 실행 결과
![image](image/Untitled%20(8).png)
- 틀린 비밀번호를 입력할 경우 수정되지 않고 에러 메세지 출력
![image](image/Untitled%20(9).png)

---

## 게시글 삭제

### 엔드포인트

- 게시글 삭제하기: `/article/{:articleId}/delete/`

### 실행 결과
![image](image/Untitled%20(10).png)
- 틀린 비밀번호를 입력할 경우 삭제되지 않고 에러 메시지 출력
![image](image/Untitled%20(11).png)

---

## 3. 댓글 기능

## 댓글 작성

### 엔드포인트

- 댓글 작성하기: `/article/{:articleId}/comment`

### 실행 결과
![image](image/Untitled%20(12).png)
- 댓글이 성공적으로 입력되면 게시글에서 확인 가능
  ![image](image/Untitled%20(13).png)
- ![image](image/Untitled%20(14).png)

---

## 댓글 삭제

### 엔드포인트

- 댓글 삭제하기: `/article/{:articleId}/comment/{:commentId}/delete`

### 실행 결과
![image](image/Untitled%20(15).png)
- 잘못된 비밀번호를 입력할 경우 에러메세지 출력
  ![image](image/Untitled%20(16).png)

---
### 추가 구현 (댓글 수정 기능 추가)
### 실행 결과
![image](image/Untitled%20(17).png)
- 잘못된 비밀번호 입력된 경우 에러 메시지 출력
![image](image/Untitled%20(18).png)

---

# 도전 과제

---

## 2. 검색 기능

- 조건
    - 게시글 목록을 확인할 수 있는 페이지에, 검색을 위한 UI가 추가된다.
        - 사용자가 검색어를 입력해서 검색을 할 수 있다.
    - 검색을 하면서 검색 기준을 선택할 수 있다.
        - 제목
        - 내용
    - 개별 게시판이 선택된 상태론 해당 게시판 내에서, 전체 게시판이 선택된 상태론 전체 게시글 중 검색한다.

### 게시판 목록에서 전체 게시글을 검색
![image](image/Untitled%20(19).png)

### 실행 결과

- 제목으로 검색한 경우
  ![image](image/Untitled%20(20).png)
- ![image](image/Untitled%20(21).png)
- 내용으로 검색한 경우
- ![image](image/Untitled%20(22).png)
- ![image](image/Untitled%20(23).png)