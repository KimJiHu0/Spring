DROP SEQUENCE MYNOSEQ;
DROP TABLE MYBOARD;

CREATE SEQUENCE MYNOSEQ;
CREATE TABLE MYBOARD(
	MYNO NUMBER PRIMARY KEY,
	MYNAME VARCHAR2(500) NOT NULL,
	MYTITLE VARCHAR2(1000) NOT NULL,
	MYCONTENT VARCHAR2(4000) NOT NULL,
	MYDATE DATE NOT NULL
);
ALTER TABLE MYBOARD MODIFY
-- 얘는 왜 안돼ㅡㅡ?
INSERT INTO MYNOSEQ VALUES(MYNOSEQ.NEXTVAL, '김지후', '제목', '내용', SYSDATE);
INSERT INTO MYBOARD VALUES(MYNOSEQ.NEXTVAL, '관리자','테스트 글 입니다.','테스트 내용 1234',SYSDATE);

SELECT MYNO, MYNAME, MYTITLE, MYCONTENT, MYDATE FROM MYBOARD;