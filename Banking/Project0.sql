CREATE TABLE UserLogin
(
	UserID serial not null,
    UserName VARCHAR(120) unique,
    PassWordo VARCHAR(120),
    CONSTRAINT "PK_UserID" PRIMARY KEY  (UserID)
);



create table  AccountInfo
(
	AccountID serial not null,
	AccountBalance numeric,
	UserID int unique references UserLogin(userID),
	CONSTRAINT "PK_AccountID" PRIMARY KEY  (AccountID)
);



alter table accountinfo drop constraint accountinfo_userid_fkey





INSERT INTO UserLogin(username,passwordo) values('Billybob123','password');
INSERT INTO UserLogin(username,passwordo) values('EricSmith1','admin');

INSERT INTO AccountInfo(AccountBalance,userid) values(10000,1);
INSERT INTO AccountInfo(AccountBalance,userid) values(100000,3);



--deposit function
create or replace function deposit(amount float, account_id integer)
returns setof AccountInfo
language plpgsql
As $function$
begin
	update accountinfo set accountbalance = accountbalance+amount where accountid = account_id;
	return QUERY select * from accountinfo a;
End;
$function$

select deposit(20,1);



--withdrawal function
create or replace function withdraw(amount float, account_id integer)
returns setof AccountInfo
language plpgsql
As $function$
begin
	update accountinfo set accountbalance = accountbalance-amount where accountid = account_id;
	return QUERY select * from accountinfo a;
End;
$function$

select withdraw(15,1);



--join
select * from UserLogin u join AccountInfo a on a.userid=u.userid;



