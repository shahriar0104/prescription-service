CREATE TABLE T_DOCTOR(
	  id_doc_key			bigint	Identity	NOT NULL	PRIMARY KEY -- Identity of a Doctor
	, tx_doc_name			varchar(256)		NOT NULL	DEFAULT '?'	-- Name of a Doctor
	, tx_doc_speciality		varchar(256)						DEFAULT '?'	-- Age of a Doctor
	, tx_doc_mobile			varchar(30)							DEFAULT '?'	-- contact number of a Doctor
	, tx_doc_phone			varchar(30)							DEFAULT '?'	-- contact number of a Doctor

	, dtt_mod				datetime			NOT NULL		DEFAULT '2019-20-01 00:00:00'
	, id_user_mod_key		int					NOT NULL	DEFAULT -2147483648
	, tx_comment			varchar(256)		NOT NULL	DEFAULT '?'
	, id_env_key			int					NOT NULL	DEFAULT -2147483648
	, id_event_key			int					NOT NULL	DEFAULT -2147483648
	, id_state_key			int					NOT NULL	DEFAULT -2147483648
	, id_action_key			int					NOT NULL	DEFAULT -2147483648
);


CREATE TABLE T_PATIENT(
	  id_pat_key			bigint	Identity	NOT NULL	PRIMARY KEY -- Identity of a Patient
	, tx_pat_name			varchar(256)		NOT NULL	DEFAULT '?'	-- Name of a Patient
	, id_pat_age			int 							DEFAULT 1 	-- Age of a a Patient
	, id_pat_weight			varchar(20) 					DEFAULT '?' -- Weight of a a Patient
	, tx_pat_bloodgroup		varchar(100)					DEFAULT '?'	-- Blood Group of a Patient
	, tx_pat_mobile			varchar(30)						DEFAULT '?'	-- contact number of a patient
	, tx_pat_phone			varchar(30)						DEFAULT '?'	-- contact number of a patient
	, id_doc_key			bigint				NOT NULL				    -- References the doctor of the Patient

	, dtt_mod				datetime			NOT NULL	DEFAULT '2019-20-01 00:00:00'
	, id_user_mod_key		int					NOT NULL	DEFAULT -2147483648
	, tx_comment			varchar(256)		NOT NULL	DEFAULT '?'
	, id_env_key			int					NOT NULL	DEFAULT -2147483648
	, id_event_key			int					NOT NULL	DEFAULT -2147483648
	, id_state_key			int					NOT NULL	DEFAULT -2147483648
	, id_action_key			int					NOT NULL	DEFAULT -2147483648
);

CREATE TABLE T_PRESCRIPTION(
	  id_pres_key				bigint	Identity	NOT NULL	PRIMARY KEY 					-- Identity of a Presription
	, id_doc_key				bigint				NOT NULL						-- References the doctor of the Patient
	, id_pat_key				bigint				NOT NULL	                                -- Identity of the Patient
	, tx_pat_disease			varchar(256)				 	DEFAULT '?'						-- Disease name
	, dtt_prescription 			datetime			NOT NULL 	DEFAULT '0000-00-00 00:00:00'	-- Visit date
	, dt_next_visit 			date				 			DEFAULT '0000-00-00'			-- Next visit date
	, tx_prescription			varchar(4096)				    DEFAULT  '?'					-- Prescribe field

	, dtt_mod				datetime			NOT NULL			DEFAULT '2019-20-01 00:00:00'
	, id_user_mod_key		int					NOT NULL	DEFAULT -2147483648
	, tx_comment			varchar(256)		NOT NULL	DEFAULT '?'
	, id_env_key			int					NOT NULL	DEFAULT -2147483648
	, id_event_key			int					NOT NULL	DEFAULT -2147483648
	, id_state_key			int					NOT NULL	DEFAULT -2147483648
	, id_action_key			int					NOT NULL	DEFAULT -2147483648
);
