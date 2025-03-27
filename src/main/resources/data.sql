-- ---------------------- day05 ---------------------------------- --
-- 학생 테이블 샘플 데이터 삽입
INSERT INTO student (name, kor, math) VALUES ('김철수', 90, 85);
INSERT INTO student (name, kor, math) VALUES ('이영희', 78, 92);
INSERT INTO student (name, kor, math) VALUES ('박민수', 88, 76);

-- 성적 테이블 샘플 데이터 삽입 (트랜잭션 실습을 위해 일부 데이터만 추가)
INSERT INTO student_score (sno, subject, score) VALUES (1, '국어', 90);
INSERT INTO student_score (sno, subject, score) VALUES (1, '수학', 85);
INSERT INTO student_score (sno, subject, score) VALUES (2, '국어', 78);
INSERT INTO student_score (sno, subject, score) VALUES (2, '수학', 92);

-- ---------------------- ------ ---------------------------------- --

INSERT INTO member (mid, mpwd, mname) VALUES
('user1', 'password123', '김철수'),
('user2', 'qwerty456', '이영희'),
('user3', 'abcde789', '박민준'),
('user4', 'helloWorld', '정다은'),
('user5', 'son1234', '손흥민');

-------------------------day 13-------------------------------------------------
INSERT INTO day13users (name, money) VALUES
('서장훈', 500000),
('신동엽', 300000);
