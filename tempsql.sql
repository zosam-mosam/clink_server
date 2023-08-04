SELECT * FROM Comment_DetailC;
SELECT * FROM User_Master;
SELECT * FROM Board_Detail;
SELECT * FROM Common_Code;
SELECT * FROM User_Update_History;
SELECT * FROM Account_Detail;
SELECT * FROM Challenge_Detail;
SELECT * FROM Account_History;
SELECT * FROM Like_Detail;
SELECT * FROM Callenge_Success_Detail;
SELECT * FROM Hashtag_Detail;
SELECT * FROM Quote_Base;
SELECT * FROM User_Badge_Description;
SELECT *
		FROM Board_Detail
		WHERE board_like_count >= 10
		AND board_delete_yn ='n'
		ORDER BY register_datetime DESC;



SELECT MAX(comment_id)
FROM Comment_Detail;


INSERT INTO Board_Detail
(board_no, user_no, category_no, board_views, board_title, board_content, board_like_count, hashtag_content, register_datetime, register_id, update_datetime, updater_id) 
VALUES ("5", "0", "1", 0, "자유1 테스트", "자유1 테스트입니다. 자유1 테스트입니다", 0, "#자유#테스트", now(), "test", null, null);

INSERT INTO Board_Detail
(board_no, user_no, category_no, board_views, board_title, board_content, board_like_count, hashtag_content, register_datetime, register_id, update_datetime, updater_id) 
VALUES ("00003", "00001", "0", 0, "테스트", "공지사항2 테스트입니다. 공지사항2 테스트입니다", 0, "#테스트#공지사항", now(), null, null, null);

INSERT INTO Comment_Detail
(comment_id, board_no, comment_content, register_datetime, register_id, update_datetime, update_id, parent_id)
VALUES ("00001", "00001", "자유1 댓글 테스트입니다", now(), "gpt", null, null, "00001");

SELECT *
		FROM Board_Detail
		WHERE board_like_count >= 10
		ORDER BY register_datetime DESC;

UPDATE `clink1`.`Board_Detail` 
SET `board_like_count` =10
WHERE (`board_no` = '00001') and (`user_no` = '00000');



# 게시글 댓글 삭제 수정

DELETE FROM Board_Detail 
WHERE board_no = 1;

UPDATE Board_Detail 
SET 
	board_title = "자유 수정 테스트입니다.",
	board_content="자유 수정 테스트입니다.",
    update_datetime = now(),
    hashtag_content="#자유#수정#테스트"
WHERE board_no = "00001";

DELETE FROM Comment_Detail 
WHERE comment_id = "00001";


UPDATE Comment_Detail 
SET 
	comment_content = "댓글 수정 테스트입니다.",
	update_datetime = now()
WHERE comment_id = "00001";



# yn 컬럼 추가 - 230727 생성 
ALTER TABLE Board_Detail ADD board_delete_yn char(1) DEFAULT "n" NOT NULL;

ALTER TABLE Comment_Detail ADD comment_delete_yn char(1) DEFAULT "n" NOT NULL;


# 좋아요 추가 삭제 230728 생성
INSERT INTO Like_Detail
	(register_datetime, user_id, board_no)
VALUES (now(), "gpt", 3);
    
UPDATE Board_Detail
SET
	board_like_count = board_like_count +1
WHERE board_no = 3;

DELETE FROM Like_Detail
WHERE user_id = "gpt"
AND board_no = 4;

UPDATE Board_Detail
SET
	board_like_count = board_like_count - 1
WHERE board_no = 4;

SELECT board_no
FROM Like_Detail
WHERE user_id = "test";



SELECT exists(
SELECT board_no
FROM Like_Detail
WHERE user_id = "test"
AND board_no = 10) as "1";



# 댓글 개수 확인 230802
SELECT COUNT(*)
FROM Comment_Detail
WHERE board_no = 2;


# 페이지네이션 230803
SELECT *
FROM Board_Detail
WHERE Board_no >=10
AND board_delete_yn = "n"
ORDER BY board_no
LIMIT 5;
# AND hashtag_content like CONCAT('%', #{hashtag}, '%')

SELECT MAX(board_no) 
FROM Board_Detail;

SELECT MAX(board_no)+1
FROM Comment_Detail;

SELECT *
FROM Board_Detail
WHERE category_no=1
AND board_delete_yn ='n'
AND board_no <= 314
AND hashtag_content like CONCAT('%', "테스트", '%')
ORDER BY board_no DESC
LIMIT 5;