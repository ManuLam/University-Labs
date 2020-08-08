UPDATE CS130_2017_Lab7_Property 
	SET 
		listingdate = '2017-10-15'	
	WHERE listingdate = '2017-10-13' or listingdate = '2017-10-14';

UPDATE CS130_2017_Lab7_Property 
	SET 
		askingprice = 100000
	WHERE askingprice BETWEEN 95000 AND 100000;


DELETE FROM CS130_2017_Lab7_Property WHERE (energyrating = 'C' OR energyrating = 'D') AND (housetype = 'Semi-detached') AND (agent = 'Property Kings');

DELETE FROM CS130_2017_Lab7_Property WHERE agent IS NULL or numbeds IS NULL;

UPDATE CS130_2017_Lab7_Property 
	SET 
		askingprice = askingprice*.92
	WHERE agent = 'CS130 Estates';

DELETE FROM CS130_2017_Lab7_Property WHERE (char_length(address) > 20) and (address ~ '.*[0-9]{4}.*') and (address ~* '.*road');

