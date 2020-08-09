SELECT * FROM saturn WHERE char_length(custname) >= 10 and char_length(custname) <= 14
SELECT * FROM saturn WHERE items < 12 and not (items % 2 = 0)
SELECT * FROM saturn WHERE custname not like 'Peter %'
SELECT * FROM saturn WHERE custname not like 'Peter %'