
create or replace function deposit (amount double precision, account "User"."AccountNumber"%type)
returns numeric
language plpgsql
as $function$
declare
	currentBalance "User"."AccountBalance"%type;
	balanceAfterDeposit "User"."AccountBalance"%type;
begin
	select "AccountBalance" into currentBalance
	from "User"
	where "AccountNumber" = account;

	update "User"
	set "AccountBalance" = currentBalance + amount
	where "AccountNumber" = account;

	select "AccountBalance" into balanceAfterDeposit
	from "User"
	where "AccountNumber" = account;
	
	insert into "Transaction" ("AccountNumber", "TransactionAmount", "TransactionDate", "BalanceAfterTransaction", "TransactionType")
	values (account, amount, current_timestamp, balanceAfterDeposit, 'Deposit');

	return balanceAfterDeposit;
end
$function$

create or replace function withdraw (amount double precision, account "User"."AccountNumber"%type)
returns numeric
language plpgsql
as $function$
declare
	currentBalance "User"."AccountBalance"%type;
	balanceAfterWithdraw "User"."AccountBalance"%type;
begin
	select "AccountBalance" into currentBalance
	from "User"
	where "AccountNumber" = account;

	if (currentBalance - amount) < 0 then
		return currentBalance;
	else
		update "User"
		set "AccountBalance" = currentBalance - amount
		where "AccountNumber" = account;
	
		select "AccountBalance" into balanceAfterWithdraw
		from "User"
		where "AccountNumber" = account;
		
		insert into "Transaction" ("AccountNumber", "TransactionAmount", "TransactionDate", "BalanceAfterTransaction", "TransactionType")
		values (account, amount, current_timestamp, balanceAfterWithdraw, 'Withdraw');
	
		return balanceAfterWithdraw;
	
	end if;
end
$function$

create or replace function transferTo (amount double precision, account "User"."AccountNumber"%type, transferAcc "User"."AccountNumber"%type, transferToStr character varying, transferFromStr character varying)
returns numeric
language plpgsql
as $function$
declare
	currentBalance "User"."AccountBalance"%type;
	balanceAfterTransfer "User"."AccountBalance"%type;
	transAccBalance "User"."AccountBalance"%type;
	transAccBalanceAfterTransfer "User"."AccountBalance"%type;
begin
	select "AccountBalance" into currentBalance
	from "User"
	where "AccountNumber" = account;

	-- decrease amount from account
	if (currentBalance - amount) < 0 then
		return currentBalance;
	else
		update "User"
		set "AccountBalance" = currentBalance - amount
		where "AccountNumber" = account;
	
		select "AccountBalance" into balanceAfterTransfer
		from "User"
		where "AccountNumber" = account;
		
		insert into "Transaction" ("AccountNumber", "TransactionAmount", "TransactionDate", "BalanceAfterTransaction", "TransactionType")
		values (account, amount, current_timestamp, balanceAfterTransfer, transferToStr);
	end if;

	-- increase amount to transfer account
	select "AccountBalance" into transAccBalance
	from "User"
	where "AccountNumber" = transferAcc;

	update "User"
	set "AccountBalance" = transAccBalance + amount
	where "AccountNumber" = transferAcc;

	select "AccountBalance" into transAccBalanceAfterTransfer
	from "User"
	where "AccountNumber" = transferAcc;
	
	insert into "Transaction" ("AccountNumber", "TransactionAmount", "TransactionDate", "BalanceAfterTransaction", "TransactionType")
	values (transferAcc, amount, current_timestamp, transAccBalanceAfterTransfer, transferFromStr);

	return balanceAfterTransfer;
end
$function$


