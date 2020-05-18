insert into aircraft (weight, width, height, serialNumber, horizontalSpeed, title, baloonVolume)values(150, 2, 3, 12, 50, 'Jobby', 400);
#update aircraft set horizontalSpeed=60, aircraft_id=2 WHERE modelName="Golla";
select * from aircraft;
#delete from aircraft where aircraft_id=2;
#insert into aircraft (weight, width, height, serialNumber, horizontalSpeed, modelName, baloonVolume) values(150, 2, 3, 10, 50, 'Golla', 400);
update aircraft set horizontalSpeed=60, aircraft_id=2 WHERE title ="Golla";
select * from aircraft;
#delete from aircraft where aircraft_id=2;
SET time_zone = 'Europe/Kiev';

//statement.execute("insert into aircraft (weight, width, height, serialNumber, horizontalSpeed, modelName, baloonVolume) values(150, 2, 3, 12, 50, 'Jobby', 400);");
//statement.execute("insert into aircraft (weight, width, height, serialNumber, horizontalSpeed, modelName, baloonVolume) values(160, 3, 3, 13, 50, 'Golla', 400);");


int res = statement.executeUpdate("update aircraft set horizontalSpeed=60, aircraft_id=2 WHERE modelName='Golla';");
//statement.addBatch();
System.out.println(res);
statement.getConnection();
statement.close();