#mysql
CREATE TABLE `safaricomtest`.`c2b_validation` (
  `id` INT NULL,
  `TransactionType` VARCHAR(45) NULL,
  `TransID` VARCHAR(45) NULL,
  `TransAmount` DECIMAL(10,2) NULL,
  `BusinessShortCode` VARCHAR(45) NULL,
  `BillRefNumber` VARCHAR(45) NULL,
  `InvoiceNumber` VARCHAR(45) NULL,
  `OrgAccountBalance` DECIMAL(10,2) NULL,
  `ThirdPartyTransID` VARCHAR(45) NULL,
  `MSISDN` VARCHAR(45) NULL,
  `FirstName` VARCHAR(45) NULL,
  `MiddleName` VARCHAR(45) NULL,
  `LastName` VARCHAR(45) NULL,
  `TransTime` DATETIME NULL,
  `uid` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`uid`));

  CREATE TABLE `safaricomtest`.`c2b_confirmation` (
  `id` INT NULL,
  `TransactionType` VARCHAR(45) NULL,
  `TransID` VARCHAR(45) NULL,
  `TransAmount` DECIMAL(10,2) NULL,
  `BusinessShortCode` VARCHAR(45) NULL,
  `BillRefNumber` VARCHAR(45) NULL,
  `InvoiceNumber` VARCHAR(45) NULL,
  `OrgAccountBalance` DECIMAL(10,2) NULL,
  `ThirdPartyTransID` VARCHAR(45) NULL,
  `MSISDN` VARCHAR(45) NULL,
  `FirstName` VARCHAR(45) NULL,
  `MiddleName` VARCHAR(45) NULL,
  `LastName` VARCHAR(45) NULL,
  `TransTime` DATETIME NULL,
  `uid` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`uid`));

  CREATE TABLE `safaricomtest`.`webusers` (
  `uid` VARCHAR(50) NOT NULL,
  `fname` VARCHAR(45) NULL,
  `mname` VARCHAR(45) NULL,
  `lname` VARCHAR(45) NULL,
  `username` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  PRIMARY KEY (`uid`));

#postgres
CREATE TABLE c2b_confirmation(
	id serial,
	TransactionType char(50),
	TransID char(50),
	TransAmount int,
	BusinessShortCode char(10),
	BillRefNumber char(50),
	InvoiceNumber char(50),
	OrgAccountBalance int,
	ThirdPartyTransID char(50),
	MSISDN char(50),
	FirstName char(50),
	MiddleName char(50),
	LastName char(50),
	TransTime char(50),
	uid char(50));
	
	CREATE TABLE c2b_validation(
	id serial,
	TransactionType char(50),
	TransID char(50),
	TransAmount int,
	BusinessShortCode char(10),
	BillRefNumber char(50),
	InvoiceNumber char(50),
	OrgAccountBalance int,
	ThirdPartyTransID char(50),
	MSISDN char(50),
	FirstName char(50),
	MiddleName char(50),
	LastName char(50),
	TransTime char(50),
	uid char(50));
	
 
CREATE TABLE stkcallback(
	uid char(50),
	MerchantRequestID char(50),
	CheckoutRequestID char(50),
	ResultCode char(50),
	ResultDesc char(50),
	Amount char(10),
	MpesaReceiptNumber char(50),
	Balance char(10),	
	TransactionDate char(50),
	PhoneNumber char(50));

	CREATE TABLE b2c (
	 uid char(50),
	 Txdate timestamp,
	 ResultType numeric(1),
	 ResultCode numeric(1),
	 OriginatorConversationID char(50),
	 ConversationID char(50),
	 TransactionID char(20),
	 TransactionAmount numeric(10),
	 TransactionReceipt char(10),
	 B2CRecipientIsRegisteredCustomer char(10),
	 B2CChargesPaidAccountAvailableFunds numeric(10),
	 BeneficiaryName char(50),
	 TxCompletedDateTime timestamp,
	 B2CUtilityAccountAvailableFunds numeric(10),
	 B2CWorkingAccountAvailableFunds numeric(10),
	 QueueTimeoutURL char(256) 
	);

        String insertB2c = "INSERT INTO b2c(uid,Txdate,ResultType,ResultCode,OriginatorConversationID,ConversationID,TransactionID,TransactionAmount,TransactionReceipt,B2CRecipientIsRegisteredCustomer,B2CChargesPaidAccountAvailableFunds,BeneficiaryName,TxCompletedDateTime,B2CUtilityAccountAvailableFunds,B2CWorkingAccountAvailableFunds,QueueTimeoutURL) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	
CREATE TABLE users(uid char(50),fname char(50),mname char(50),lname char(50),username char(50),password char(50),email char(50));


INSERT INTO users(fname,mname,lname,username,password,email) VALUES ('Brian','','Ademba','bademba','test123','brian.ademba@gmail.com');

INSERT INTO stkcallback(uid,MerchantRequestID,CheckoutRequestID,ResultCode,ResultDesc,Amount,MpesaReceiptNumber,Balance,TransactionDate,PhoneNumber) VALUES (?,?,?,?,?,?,?,?,?,?);
	
ALTER TABLE c2b_confirmation
ADD COLUMN uid char(50);	
