INSERT INTO Email_templates (language_id, text) VALUES (1, 'Dear <name> (country: <country>, date of birht: <dateOfBirth>)!

You can read here the description of your uploaded cars:

<carsLoopBegin>

Brand: <brand>
Type: <type>
Plate number: <plateNumber>
Year of manufacture: <yearOfManufacture>
Driven distance (km): <drivenDistance>

Based on the data above our system considers the following market price that suits to your car: <calculatedValue> Euro.

<carsLoopEnd>

Thank you for using our services!

Kindest regards,

Team CarEvaluator
');


INSERT INTO Email_templates (language_id, text) VALUES (2, 'Kedves <name> (ország: <country>, születési idő: <dateOfBirth>)!

Az ön által feltöltött autók jellemzését alább olvashatja:

<carsLoopBegin>

Márka: <brand>
Típus: <type>
Rendszám: <plateNumber>
Gyártási év: <yearOfManufacture>
Megtett kilométer: <drivenDistance>

A fenti adatok alapján rendszerünk a következő piaci értéket tartja reálisnak az Ön autója esetén: <calculatedValue> Euro.

<carsLoopEnd>

Köszönjük, hogy igénybe vette szolgáltatásunkat!

Üdvözlettel,
A CarEvaluator csapata
');

INSERT INTO Person_data (person_id, name, data_of_birht, country, language_id) VALUES (1, 'Jake Greenfield', '1974-08-15', 'United Kingdom', 1);
INSERT INTO Person_data (person_id, name, data_of_birht, country, language_id) VALUES (2, 'Horváth Hedvig', '1982-02-19', 'Hungary', 2);
INSERT INTO Person_data (person_id, name, data_of_birht, country, language_id) VALUES (3, 'Erwin Lefavre', '1969-11-05', 'France', 1);


INSERT INTO Cars (car_id, brand, type, plate_number, year_of_manufacture, calculated_value, driven_distance, is_sent)	
		VALUES (1, 'Opel', 'Vectra', 'UK 123 45678', 2008, 11140, 125000, 0);
		
INSERT INTO Cars (car_id, brand, type, plate_number, year_of_manufacture, calculated_value, driven_distance, is_sent)	
		VALUES (2, 'Mini', 'Cooper', 'UK 456 12345', 2015, 0, 10000, 0);

INSERT INTO Cars (car_id, brand, type, plate_number, year_of_manufacture, calculated_value, driven_distance, is_sent)	
		VALUES (3, 'Suzuki', 'Swift', 'MTK 128', 2014, 12295, 26000, 1);
    
INSERT INTO Cars (car_id, brand, type, plate_number, year_of_manufacture, calculated_value, driven_distance, is_sent)	
		VALUES (4, 'Peugeot', '206', 'FR 4567 TT', 2004, 3900, 195700, 0);

INSERT INTO Cars (car_id, brand, type, plate_number, year_of_manufacture, calculated_value, driven_distance, is_sent)	
		VALUES (5, 'Citroen', 'C4 cactus', 'FR 8912 CC', 2014, 15750, 36500, 0);

INSERT INTO Cars_of_people (person_id, car_id) VALUES (1,1);
INSERT INTO Cars_of_people (person_id, car_id) VALUES (1,2);
INSERT INTO Cars_of_people (person_id, car_id) VALUES (2,3);
INSERT INTO Cars_of_people (person_id, car_id) VALUES (3,4);
INSERT INTO Cars_of_people (person_id, car_id) VALUES (3,5);