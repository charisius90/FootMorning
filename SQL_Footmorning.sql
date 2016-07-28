CREATE TABLE MEMBER
(
   mem_no                INTEGER NOT NULL auto_increment PRIMARY KEY,
   mem_email             VARCHAR(50) NULL,
   mem_pw                VARCHAR(300) NULL,
   mem_name              VARCHAR(20) NULL,
   mem_gender            VARCHAR(10) NULL,
    mem_birth            VARCHAR(20) NULL,
   mem_phone             VARCHAR(20) NULL,
   mem_addr              VARCHAR(50) NULL,
   mem_grade             INTEGER NULL,
   mem_image             VARCHAR(50) NULL,
   mem_regdate           TIMESTAMP NULL default now(),
   mem_logdate           TIMESTAMP NULL,
   mem_backno            INTEGER NULL,
   club_no               INTEGER NULL,
   mem_club_regdate			 timestamp null
)
;


CREATE TABLE CHALLENGE
(
   challenge_no          INTEGER NOT NULL auto_increment PRIMARY KEY,
   sender_club_no        INTEGER NULL,
   receiver_club_no      INTEGER NULL,
   challenge_content     VARCHAR(500) NULL,
   game_no               INTEGER NULL,
   game_flag             VARCHAR(10) NULL
)
;





CREATE TABLE CLUB
(
   club_no               INTEGER NOT NULL auto_increment PRIMARY KEY,
   club_name             VARCHAR(50) NULL,
    club_master         INTEGER NOT NULL,
    club_master_name     VARCHAR(50) NULL,           
   club_image            VARCHAR(100) NULL,
   club_content          VARCHAR(500) NULL,
   club_loc              VARCHAR(50) NULL,
   club_type             INTEGER NULL,
   club_regdate          TIMESTAMP NULL default now(),
    club_mem_count        INTEGER NULL
)
;





CREATE TABLE FORMATION
(
   fomation_no           INTEGER NOT NULL auto_increment PRIMARY KEY,
   loc0                  VARCHAR(20) NULL,
   loc1                  VARCHAR(20) NULL,
   loc2                  VARCHAR(20) NULL,
   loc3                  VARCHAR(20) NULL,
   loc4                  VARCHAR(20) NULL,
   loc5                  VARCHAR(20) NULL,
   loc6                  VARCHAR(20) NULL,
   loc7                  VARCHAR(20) NULL,
   loc8                  VARCHAR(20) NULL,
   loc9                  VARCHAR(20) NULL,
   loc10                 VARCHAR(20) NULL,
   lineup_no             INTEGER NOT NULL
)
;




CREATE TABLE GAME
(
   game_no               INTEGER NOT NULL auto_increment,
   game_date             TIMESTAMP NULL,
   game_time             VARCHAR(30) NULL,
   game_addr             VARCHAR(50) NULL,
   game_flag             VARCHAR(10) NOT NULL,
   club_no               INTEGER NOT NULL,
   game_score            INTEGER NULL,
    primary key(game_no, game_flag)
)
;


CREATE TABLE LINEUP
(
   lineup_no             INTEGER NOT NULL auto_increment PRIMARY KEY,
   player0               INTEGER NULL,
   player1               INTEGER NULL,
   player2               INTEGER NULL,
   player3               INTEGER NULL,
   player4               INTEGER NULL,
   player5               INTEGER NULL,
   player6               INTEGER NULL,
   player7               INTEGER NULL,
   player8               INTEGER NULL,
   player9               INTEGER NULL,
   player10              INTEGER NULL,
   game_no               INTEGER NOT NULL,
   game_flag             VARCHAR(10) NOT NULL
)
;




CREATE TABLE LINEUP_SUB
(
   lineup_no             INTEGER NOT NULL PRIMARY KEY,
   player11              INTEGER NULL,
   player12              INTEGER NULL,
   player13              INTEGER NULL,
   player14              INTEGER NULL,
   player15              INTEGER NULL,
   player16              INTEGER NULL
)
;



CREATE TABLE RECORD
(
   record_no             INTEGER NOT NULL auto_increment PRIMARY KEY,
   record_time           VARCHAR(10) NULL,
   record_goal_mem       INTEGER NULL,
   record_assist_mem     INTEGER NULL,
   game_no               INTEGER NOT NULL,
   game_flag             VARCHAR(10) NOT NULL
)
;





ALTER TABLE CHALLENGE
   ADD FOREIGN KEY R_1 (game_no,game_flag) REFERENCES GAME(game_no,game_flag)
;



ALTER TABLE FORMATION
   ADD FOREIGN KEY R_2 (lineup_no) REFERENCES LINEUP(lineup_no)
;



ALTER TABLE GAME
   ADD FOREIGN KEY R_3 (club_no) REFERENCES CLUB(club_no)
;



ALTER TABLE LINEUP
   ADD FOREIGN KEY R_4 (game_no,game_flag) REFERENCES GAME(game_no,game_flag)
;



ALTER TABLE LINEUP_SUB
   ADD FOREIGN KEY R_5 (lineup_no) REFERENCES LINEUP(lineup_no)
;



ALTER TABLE MEMBER
   ADD FOREIGN KEY R_6 (club_no) REFERENCES CLUB(club_no)
;



ALTER TABLE RECORD
   ADD FOREIGN KEY R_7 (game_no,game_flag) REFERENCES GAME(game_no,game_flag)
;









CREATE TABLE com_boast
(
   com_boast_no          INTEGER NOT NULL auto_increment PRIMARY KEY,
   mem_no                INTEGER NOT NULL,
   com_boast_writer     VARCHAR(20) NULL,
   com_boast_subject     VARCHAR(500) NULL,
   com_boast_content     VARCHAR(3000) NULL,
   com_boast_regdate     TIMESTAMP NULL default now(),
   com_boast_count       INTEGER NULL default 0
)
;




CREATE TABLE com_boast_reply
(
   com_boast_re_no       INTEGER NOT NULL auto_increment PRIMARY KEY,
   mem_no                INTEGER NOT NULL,
   com_boast_reply_writer   VARCHAR(20) NULL,
   com_boast_re_content  VARCHAR(200) NULL,
   com_boast_re_regdate  TIMESTAMP NULL default now(),
   com_boast_re_pos      INTEGER NULL,
   com_boast_re_depth    INTEGER NULL,
   com_boast_no          INTEGER NOT NULL,
   com_boast_re_group    INTEGER NOT NULL 
)
;



CREATE TABLE com_discussion_kor
(
   com_discussion_kor_no  INTEGER NOT NULL auto_increment PRIMARY KEY,
   com_discussion_kor_subject  VARCHAR(500) NULL,
   com_discussion_kor_content  VARCHAR(3000) NULL,
   com_discussion_kor_regdate  TIMESTAMP NULL default now(),
   com_discussion_kor_count  INTEGER NULL default 0,
   mem_no                INTEGER NOT NULL,
   com_discussion_kor_writer   VARCHAR(20) NULL
)
;





CREATE TABLE com_discussion_kor_reply
(
   com_discussion_kor_re_no  INTEGER NOT NULL auto_increment PRIMARY KEY,
   com_discussion_kor_re_content  VARCHAR(200) NULL,
   com_discussion_kor_re_regdate  TIMESTAMP NULL default now(),
   com_discussion_kor_re_pos  INTEGER NULL,
   com_discussion_kor_re_depth  INTEGER NULL,
   com_discussion_kor_no  INTEGER NOT NULL,
   com_discussion_kor_re_group  INTEGER NULL,
   mem_no                INTEGER NOT NULL,
   com_discussion_kor_re_writer   VARCHAR(20) NULL
)
;





CREATE TABLE com_discussion_world
(
   com_discussion_world_no  INTEGER NOT NULL auto_increment PRIMARY KEY,
   com_discussion_world_subject  VARCHAR(500) NULL,
   com_discussion_world_content  VARCHAR(3000) NULL,
   com_discussion_world_regdate  TIMESTAMP NULL default now(),
   com_discussion_world_count  INTEGER NULL default 0,
   mem_no                INTEGER NOT NULL,
   com_discussion_world_writer   VARCHAR(20) NULL
)
;






CREATE TABLE com_discussion_world_reply
(
   com_discussion_world_re_no  INTEGER NOT NULL auto_increment PRIMARY KEY,
   com_discussion_world_re_content  VARCHAR(200) NULL,
   com_discussion_world_re_regdate  TIMESTAMP NULL default now(),
   com_discussion_world_re_pos  INTEGER NULL,
   com_discussion_world_re_depth  INTEGER NULL,
   com_discussion_world_no  INTEGER NOT NULL,
   com_discussion_world_re_group  INTEGER NULL,
   mem_no                INTEGER NOT NULL,
   com_discussion_world_re_writer   VARCHAR(20) NULL
)
;





CREATE TABLE com_free
(
   com_free_no           INTEGER NOT NULL auto_increment PRIMARY KEY,
   com_free_subject      VARCHAR(500) NULL,
   com_free_content      VARCHAR(3000) NULL,
   com_free_regdate      TIMESTAMP NULL default now(),
   com_free_count        INTEGER NULL default 0,
   mem_no                INTEGER NOT NULL,
   com_free_writer       VARCHAR(20) NULL
)
;





CREATE TABLE com_free_reply
(
   com_free_re_no        INTEGER NOT NULL auto_increment PRIMARY KEY,
   com_free_re_content   VARCHAR(200) NULL,
   com_free_re_regdate   TIMESTAMP NULL default now(),
   com_free_re_pos       INTEGER NULL,
   com_free_re_depth     INTEGER NULL,
   com_free_no           INTEGER NOT NULL,
   com_free_re_group     INTEGER NULL,
   mem_no                INTEGER NOT NULL,
   com_free_re_writer    VARCHAR(20) NULL
)
;





CREATE TABLE com_gallery
(
   com_gallery_no        INTEGER NOT NULL auto_increment PRIMARY KEY,
   com_gallery_subject   VARCHAR(500) NULL,
   com_gallery_content   VARCHAR(3000) NULL,
   com_gallery_regdate   TIMESTAMP NULL default now(),
   com_gallery_count     INTEGER NULL default 0,
   mem_no                INTEGER NOT NULL,
   com_gallery_writer    VARCHAR(20) NULL
)
;




CREATE TABLE com_gallery_reply
(
   com_gallery_re_no     INTEGER NOT NULL auto_increment PRIMARY KEY,
   com_gallery_re_content  VARCHAR(200) NULL,
   com_gallery_re_regdate  TIMESTAMP NULL default now(),
   com_gallery_re_pos    FLOAT NULL,
   com_gallery_re_depth  INTEGER NULL,
   com_gallery_no        INTEGER NOT NULL,
   com_gallery_re_group  INTEGER NULL,
   mem_no                INTEGER NOT NULL,
   com_gallery_re_writer    VARCHAR(20) NULL
)
;





CREATE TABLE com_qna
(
   com_qna_no            INTEGER NOT NULL auto_increment PRIMARY KEY,
   mem_no                INTEGER NOT NULL,
   com_qna_subject       VARCHAR(500) NULL,
   com_qna_content       VARCHAR(3000) NULL,
   com_qna_regdate       TIMESTAMP NULL default now(),
   com_qna_count         INTEGER NULL default 0,
   com_qna_writer       VARCHAR(20) NULL
)
;






CREATE TABLE com_qna_reply
(
   com_qna_re_no         INTEGER NOT NULL auto_increment PRIMARY KEY,
   mem_no                INTEGER NOT NULL,
   com_qna_re_content    VARCHAR(200) NULL,
   com_qna_re_regdate    TIMESTAMP NULL default now(),
   com_qna_re_pos        INTEGER NULL,
   com_qna_re_depth      INTEGER NULL,
   com_qna_no            INTEGER NOT NULL,
   com_qna_re_group      INTEGER NULL,
   com_qna_re_writer    VARCHAR(20) NULL
)
;




CREATE TABLE com_video
(
   com_video_no          INTEGER NOT NULL auto_increment PRIMARY KEY,
   com_video_subject     VARCHAR(500) NULL,
   com_video_content     VARCHAR(3000) NULL,
   com_video_regdate     TIMESTAMP NULL default now(),
   com_video_count       CHAR(18) NULL default 0,
   mem_no                INTEGER NOT NULL,
   com_video_writer    VARCHAR(20) NULL
)
;




CREATE TABLE com_video_reply
(
   com_video_re_no       INTEGER NOT NULL auto_increment PRIMARY KEY,
   com_video_re_content  VARCHAR(200) NULL,
   com_video_re_regdate  TIMESTAMP NULL default now(),
   com_video_re_pos      INTEGER NULL,
   com_video_re_depth    INTEGER NULL,
   com_video_no          INTEGER NOT NULL,
   com_video_re_group    INTEGER NULL,
   mem_no                INTEGER NOT NULL,
   com_video_re_writer    VARCHAR(20) NULL
)
;




ALTER TABLE com_boast
   ADD FOREIGN KEY R_8 (mem_no) REFERENCES member(mem_no)
;



ALTER TABLE com_boast_reply
   ADD FOREIGN KEY R_9 (mem_no) REFERENCES member(mem_no)
;


ALTER TABLE com_boast_reply
   ADD FOREIGN KEY R_10 (com_boast_no) REFERENCES com_boast(com_boast_no)
;



ALTER TABLE com_discussion_kor
   ADD FOREIGN KEY R_11 (mem_no) REFERENCES member(mem_no)
;



ALTER TABLE com_discussion_kor_reply
   ADD FOREIGN KEY R_12 (com_discussion_kor_no) REFERENCES com_discussion_kor(com_discussion_kor_no)
;


ALTER TABLE com_discussion_kor_reply
   ADD FOREIGN KEY R_13 (mem_no) REFERENCES member(mem_no)
;



ALTER TABLE com_discussion_world
   ADD FOREIGN KEY R_14 (mem_no) REFERENCES member(mem_no)
;



ALTER TABLE com_discussion_world_reply
   ADD FOREIGN KEY R_15 (com_discussion_world_no) REFERENCES com_discussion_world(com_discussion_world_no)
;


ALTER TABLE com_discussion_world_reply
   ADD FOREIGN KEY R_16 (mem_no) REFERENCES member(mem_no)
;



ALTER TABLE com_free
   ADD FOREIGN KEY R_17 (mem_no) REFERENCES member(mem_no)
;



ALTER TABLE com_free_reply
   ADD FOREIGN KEY R_18 (com_free_no) REFERENCES com_free(com_free_no)
;


ALTER TABLE com_free_reply
   ADD FOREIGN KEY R_19 (mem_no) REFERENCES member(mem_no)
;



ALTER TABLE com_gallery
   ADD FOREIGN KEY R_20 (mem_no) REFERENCES member(mem_no)
;



ALTER TABLE com_gallery_reply
   ADD FOREIGN KEY R_21 (com_gallery_no) REFERENCES com_gallery(com_gallery_no)
;


ALTER TABLE com_gallery_reply
   ADD FOREIGN KEY R_22 (mem_no) REFERENCES member(mem_no)
;



ALTER TABLE com_qna
   ADD FOREIGN KEY R_23 (mem_no) REFERENCES member(mem_no)
;



ALTER TABLE com_qna_reply
   ADD FOREIGN KEY R_24 (com_qna_no) REFERENCES com_qna(com_qna_no)
;


ALTER TABLE com_qna_reply
   ADD FOREIGN KEY R_25 (mem_no) REFERENCES member(mem_no)
;



ALTER TABLE com_video
   ADD FOREIGN KEY R_26 (mem_no) REFERENCES member(mem_no)
;



ALTER TABLE com_video_reply
   ADD FOREIGN KEY R_27 (mem_no) REFERENCES member(mem_no)
;


ALTER TABLE com_video_reply
   ADD FOREIGN KEY R_28 (com_video_no) REFERENCES com_video(com_video_no)
;











CREATE TABLE main_notice
(
   main_notice_no        INTEGER NOT NULL auto_increment PRIMARY KEY,
   mem_no                INTEGER NOT NULL,
   main_notice_subject   VARCHAR(500) NULL,
   main_notice_content   VARCHAR(3000) NULL,
   main_notice_regdate   TIMESTAMP NULL default now(),
   main_notice_count     INTEGER NULL default 0,
   main_notice_writer    VARCHAR(20) NULL
)
;





CREATE TABLE main_notice_reply
(
   main_notice_no        INTEGER NOT NULL,
   mem_no                INTEGER NOT NULL,
   main_notice_re_content  VARCHAR(200) NULL,
   main_notice_re_regdate  TIMESTAMP NULL default now(),
   main_notice_re_pos    INTEGER NULL,
   main_notice_re_depth  INTEGER NULL,
   main_notice_re_group  INTEGER NULL,
   main_norice_re_no     INTEGER NOT NULL auto_increment PRIMARY KEY,
   main_notice_re_writer VARCHAR(20) NULL
)
;





CREATE TABLE myclub_album
(
   myclub_album_no       INTEGER NOT NULL auto_increment PRIMARY KEY,
   club_no             INTEGER NULL,
   mem_no                INTEGER NOT NULL,
   myclub_album_subject  VARCHAR(500) NULL,
   myclub_album_content  VARCHAR(3000) NULL,
   myclub_album_regdate  TIMESTAMP NULL default now(),
   myclub_album_count    INTEGER NULL default 0,
   myclub_album_writer   VARCHAR(20) NULL
)
;




CREATE TABLE myclub_album_reply
(
   myclub_album_no       INTEGER NOT NULL,
   mem_no                INTEGER NOT NULL,
   myclub_album_re_content  VARCHAR(200) NULL,
   myclub_album_re_regdate  TIMESTAMP NULL default now(),
   myclub_album_re_pos   INTEGER NULL,
   myclub_album_re_depth  INTEGER NULL,
   myclub_album_re_group  INTEGER NULL,
   myclub_album_re_no    INTEGER NOT NULL auto_increment PRIMARY KEY,
   myclub_album_re_writer   VARCHAR(20) NULL
)
;



CREATE TABLE myclub_free
(
   myclub_free_no        INTEGER NOT NULL auto_increment PRIMARY KEY,
   club_no             INTEGER NULL,
   mem_no                INTEGER NOT NULL,
   myclub_free_subject   VARCHAR(500) NULL,
   myclub_free_content   VARCHAR(3000) NULL,
   myclub_free_regdate   TIMESTAMP NULL default now(),
   myclub_free_count     INTEGER NULL default 0,
   myclub_free_writer   VARCHAR(20) NULL
)
;





CREATE TABLE myclub_free_reply
(
   myclub_free_no        INTEGER NOT NULL,
   mem_no                INTEGER NOT NULL,
   myclub_free_re_content  VARCHAR(200) NULL,
   myclub_free_re_regdate  TIMESTAMP NULL default now(),
   myclub_free_re_pos    INTEGER NULL,
   myclub_free_re_depth  INTEGER NULL,
   myclub_free_re_group  INTEGER NULL,
   myclub_free_re_no     INTEGER NOT NULL auto_increment PRIMARY KEY,
   myclub_free_re_writer   VARCHAR(20) NULL
)
;




CREATE TABLE myclub_notice
(
   myclub_notice_no      INTEGER NOT NULL auto_increment PRIMARY KEY,
   club_no             INTEGER NULL,
   mem_no                INTEGER NOT NULL,
   myclub_notice_subject  VARCHAR(500) NULL,
   myclub_notice_content  VARCHAR(3000) NULL,
   myclub_notice_regdate  TIMESTAMP NULL default now(),
   myclub_notice_count   INTEGER NULL default 0,
   myclub_notice_writer   VARCHAR(20) NULL
)
;




CREATE TABLE myclub_notice_reply
(
   myclub_notice_no      INTEGER NOT NULL,
   mem_no                INTEGER NOT NULL,
   myclub_notice_re_content  VARCHAR(200) NULL,
   myclub_notice_re_regdate  TIMESTAMP NULL default now(),
   myclub_notice_re_pos  INTEGER NULL,
   myclub_notice_re_depth  INTEGER NULL,
   myclub_notice_re_group  INTEGER NULL,
   myclub_notice_re_no   INTEGER NOT NULL auto_increment PRIMARY KEY,
   myclub_notice_re_writer   VARCHAR(20) NULL
)
;





CREATE TABLE myclub_team
(
   myclub_team_no        INTEGER NOT NULL auto_increment PRIMARY KEY,
   club_no             INTEGER NULL,
   mem_no                INTEGER NOT NULL,
   myclub_team_subject   VARCHAR(500) NULL,
   myclub_team_content   VARCHAR(3000) NULL,
   myclub_team_regdate   TIMESTAMP NULL default now(),
   myclub_team_count     INTEGER NULL default 0,
   myclub_team_writer   VARCHAR(20) NULL
)
;




CREATE TABLE myclub_team_reply
(
   myclub_team_no        INTEGER NOT NULL,
   mem_no                INTEGER NOT NULL,
   myclub_team_re_content  VARCHAR(200) NULL,
   myclub_team_re_regdate  TIMESTAMP NULL default now(),
   myclub_team_re_pos      INTEGER NULL,
   myclub_team_re_depth    INTEGER NULL,
   myclub_team_re_group    INTEGER NULL,
   myclub_team_re_no       INTEGER NOT NULL auto_increment PRIMARY KEY,
   myclub_team_writer   VARCHAR(20) NULL
)
;




CREATE TABLE myclub_video
(
   myclub_video_no       INTEGER NOT NULL auto_increment PRIMARY KEY,
   club_no             INTEGER NULL,
   mem_no                INTEGER NOT NULL,
   myclub_video_subject  VARCHAR(500) NULL,
   myclub_video_content  VARCHAR(3000) NULL,
   myclub_video_regdate  TIMESTAMP NULL default now(),
   myclub_video_count    INTEGER NULL default 0,
   myclub_video_writer   VARCHAR(20) NULL
)
;





CREATE TABLE myclub_video_reply
(
   myclub_video_no       INTEGER NOT NULL,
   mem_no                INTEGER NOT NULL,
   myclub_video_re_content  VARCHAR(200) NULL,
   myclub_video_re_regdate  TIMESTAMP NULL default now(),
   myclub_video_re_pos   INTEGER NULL, 
   myclub_video_re_depth  INTEGER NULL,
   myclub_video_re_group  INTEGER NULL,
   myclub_video_re_no    INTEGER NOT NULL auto_increment PRIMARY KEY,
   myclub_video_re_writer   VARCHAR(20) NULL
)
;






CREATE TABLE myclub_visitor
(
   myclub_visitor_no     INTEGER NOT NULL auto_increment PRIMARY KEY,
   club_no             INTEGER NULL,
   mem_no                INTEGER NOT NULL,
   myclub_visitor_subject  VARCHAR(500) NULL,
   myclub_visitor_content  VARCHAR(3000) NULL,
   myclub_visitor_regdate  TIMESTAMP NULL default now(),
   myclub_visitor_count  INTEGER NULL default 0,
   myclub_visitor_writer   VARCHAR(20) NULL
)
;



CREATE TABLE myclub_visitor_reply
(
   myclub_visitor_no     INTEGER NOT NULL,
   mem_no                INTEGER NOT NULL,
   myclub_visitor_re_content  VARCHAR(200) NULL,
   myclub_visitor_re_regdate  TIMESTAMP NULL default now(),
   myclub_visitor_re_pos   INTEGER NULL,
   myclub_visitor_re_depth  INTEGER NULL,
   myclub_visitor_re_group  INTEGER NULL,
   myclub_visitor_re_no    INTEGER NOT NULL auto_increment PRIMARY KEY,
   myclub_visitor_writer   VARCHAR(20) NULL
)
;




ALTER TABLE main_notice
   ADD FOREIGN KEY R_29 (mem_no) REFERENCES member(mem_no)
;



ALTER TABLE main_notice_reply
   ADD FOREIGN KEY R_30 (mem_no) REFERENCES member(mem_no)
;


ALTER TABLE main_notice_reply
   ADD FOREIGN KEY R_31 (main_notice_no) REFERENCES main_notice(main_notice_no)
;



ALTER TABLE myclub_album
   ADD FOREIGN KEY R_32 (mem_no) REFERENCES member(mem_no)
;



ALTER TABLE myclub_album_reply
   ADD FOREIGN KEY R_33 (mem_no) REFERENCES member(mem_no)
;


ALTER TABLE myclub_album_reply
   ADD FOREIGN KEY R_34 (myclub_album_no) REFERENCES myclub_album(myclub_album_no)
;



ALTER TABLE myclub_free
   ADD FOREIGN KEY R_35 (mem_no) REFERENCES member(mem_no)
;



ALTER TABLE myclub_free_reply
   ADD FOREIGN KEY R_36 (mem_no) REFERENCES member(mem_no)
;


ALTER TABLE myclub_free_reply
   ADD FOREIGN KEY R_37 (myclub_free_no) REFERENCES myclub_free(myclub_free_no)
;



ALTER TABLE myclub_notice
   ADD FOREIGN KEY R_38 (mem_no) REFERENCES member(mem_no)
;



ALTER TABLE myclub_notice_reply
   ADD FOREIGN KEY R_39 (mem_no) REFERENCES member(mem_no)
;


ALTER TABLE myclub_notice_reply
   ADD FOREIGN KEY R_40 (myclub_notice_no) REFERENCES myclub_notice(myclub_notice_no)
;



ALTER TABLE myclub_team
   ADD FOREIGN KEY R_41 (mem_no) REFERENCES member(mem_no)
;



ALTER TABLE myclub_team_reply
   ADD FOREIGN KEY R_42 (mem_no) REFERENCES member(mem_no)
;


ALTER TABLE myclub_team_reply
   ADD FOREIGN KEY R_43 (myclub_team_no) REFERENCES myclub_team(myclub_team_no)
;



ALTER TABLE myclub_video
   ADD FOREIGN KEY R_44 (mem_no) REFERENCES member(mem_no)
;



ALTER TABLE myclub_video_reply
   ADD FOREIGN KEY R_45 (mem_no) REFERENCES member(mem_no)
;


ALTER TABLE myclub_video_reply
   ADD FOREIGN KEY R_46 (myclub_video_no) REFERENCES myclub_video(myclub_video_no)
;



ALTER TABLE myclub_visitor
   ADD FOREIGN KEY R_47 (mem_no) REFERENCES member(mem_no)
;



ALTER TABLE myclub_visitor_reply
   ADD FOREIGN KEY R_48 (mem_no) REFERENCES member(mem_no)
;


ALTER TABLE myclub_visitor_reply
   ADD FOREIGN KEY R_49 (myclub_visitor_no) REFERENCES myclub_visitor(myclub_visitor_no)
;


ALTER TABLE challenge
   ADD challenge_flag varchar(10) default "FALSE"
;


DELIMITER $$

DROP TRIGGER IF EXISTS finaltest.club_AFTER_INSERT$$
USE `finaltest`$$
CREATE DEFINER = CURRENT_USER TRIGGER `finaltest`.`club_AFTER_INSERT` AFTER INSERT ON `club` FOR EACH ROW
BEGIN
   update member set club_no=new.club_no where mem_no=new.club_master;
END$$
DELIMITER ;



CREATE TABLE CLUB_MEMBER
(
	club_mem_no				 int auto_increment primary key,
	club_no					 int not null,
    mem_no					 int not null,
    mem_gender				 varchar(10) null,
    mem_email				 varchar(50) null,
    mem_phone				 varchar(20) null,
    mem_name				 varchar(20) null,
    mem_birth				 varchar(20) null,
    club_mem_regdate		 timestamp default now(),
    club_mem_flag			 varchar(10) default 'FALSE',
    constraint foreign key (mem_no) references member(mem_no),
    constraint foreign key (club_no) references club(club_no)
);