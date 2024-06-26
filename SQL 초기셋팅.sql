USE testus;

CREATE TABLE PA_LOG(
    MDEXM_BNO 	INT PRIMARY KEY AUTO_INCREMENT,    ## PK (자동증가값)
    MDEXM_YMD 	TIMESTAMP DEFAULT NOW(),    ## 잔료일자 (기본값 시간형)
    MDEXM_CN 	VARCHAR(4000) NOT NULL,      ## 진료내용
    MDEXM_CN2 	VARCHAR(4000),      ## 처방내용
    MDEXM_QTY 	INT NOT NULL default 0, 				 ## 처방나간 수량
    USER_NO		VARCHAR(20),		## FK임 사용자번호 // USER 테이블의 주키
    DSS_CODE 	VARCHAR(300), 		## FK임 질병코드 // 질병코드 테이블의 주키
    FOREIGN KEY (USER_NO) REFERENCES USER(USER_NO) ON UPDATE CASCADE,
    FOREIGN KEY (DSS_CODE) REFERENCES DSS_INFO(DSS_CODE) ON UPDATE CASCADE
); 

CREATE TABLE DSS_INFO ( -- PA_LOG 테이블 생성시 필요한 FK 제약 때문에 임시로 만든 테이블 -> 일단 해당 테이블로 생성 후 나중에 수정 후 다시 sql문 드림. 
    DSS_CODE 	VARCHAR(300) PRIMARY KEY,    ## PK 질병코드 
    DSS_NM 		VARCHAR(300) NOT NULL ## 질병명
); 

CREATE TABLE USER (
	USER_NO			VARCHAR(20)	PRIMARY KEY,
	USER_NM			VARCHAR(100),
	USER_EML_ADDR 	VARCHAR(320),
	USER_TELNO	 	VARCHAR(11),
	JBTTL_NM 		VARCHAR(100),
	SMK_YN			CHAR(1),
	SCSBJT_NM 		VARCHAR(100)
);

CREATE TABLE MED_INFO (
	ENTRYEXIT_BNO 	VARCHAR(10) PRIMARY KEY,
	SHPGOT_YMD 		TIMESTAMP DEFAULT NOW(),
	SHPGOT_RSM 		VARCHAR(4000),
	WRHS_TMD		TIMESTAMP DEFAULT NOW(),
	ENTRYEXIT_YMD	TIMESTAMP DEFAULT NOW(),
	RTL_TERM_YMD	TIMESTAMP DEFAULT NOW(),
	WRHS_RSM		TIMESTAMP DEFAULT NOW(),
	MDCM_CODE		VARCHAR(300),
	MDEXM_BNO 		INT,
    FOREIGN KEY (MDEXM_BNO) REFERENCES PA_LOG(MDEXM_BNO) ON UPDATE CASCADE,
    FOREIGN KEY (MDCM_CODE) REFERENCES Med_info_mgmt(MDCM_CODE) ON UPDATE CASCADE
);

CREATE TABLE MED_INFO_MGMT(
	MDCM_CODE		VARCHAR(300) primary key,
	MDCM_NM			VARCHAR(300) NOT NULL,
	INVT_QTY		INT
);

CREATE TABLE DSCSN_LIST (
	DSCSN_SN		INT	primary key,
	DSCSN_REG_YMD	TIMESTAMP DEFAULT NOW(),
	DSCSN_CN		VARCHAR(4000),
	DSCSN_TTL		VARCHAR(256),
	DSCSN_END_YMD	TIMESTAMP DEFAULT NOW(),
	DSCSN_BGNG_YMD	TIMESTAMP DEFAULT NOW(),
	USER_NO			VARCHAR(20),
	FOREIGN KEY (USER_NO) REFERENCES USER(USER_NO) ON UPDATE CASCADE
);

CREATE TABLE MEDVC_INFO_MGMT (
	ISTR_CODE	VARCHAR(300) primary key,
	ISTR_NM		VARCHAR(300),
	ISTR_QTY	INT,
	ISTR_NO		INT
);

CREATE TABLE MEDVC_RENT_MGMT (
	USER_NO		VARCHAR(20),
	ISTR_CODE	VARCHAR(300),
	RNTL_YN		CHAR(1),
	RNTL_QTY	INT,
	RNTL_YMD	TIMESTAMP DEFAULT NOW(),
    PRIMARY KEY (USER_NO, ISTR_CODE),
	CONSTRAINT FK_MEDVC_RENT_MGMT_USER_NO
        FOREIGN KEY (USER_NO) 
        REFERENCES USER(USER_NO)
        ON DELETE CASCADE,
    CONSTRAINT FK_MEDVC_RENT_MGMT_ISTR_CODE
        FOREIGN KEY (ISTR_CODE) 
        REFERENCES MEDVC_INFO_MGMT(ISTR_CODE)
        ON DELETE CASCADE
);