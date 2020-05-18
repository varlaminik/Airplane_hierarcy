package airplane_hierarcy;

import airplane_hierarcy.db.DBworker;

import java.sql.*;

//import static airplane_hierarcy.db.DBworker.GET_ALL;

public class Program {


    public static void main(String[] args) {
        String DB_URL = "jdbc:mysql://10.0.0.10:3306/aircraftdb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String USER = "jojo";
        String PASS = "jojo";
        String TABLE = "aircraft";
        //String GET_ALL = "SELECT * FROM aircraft";

        //String INSERT_NEW = "INSERT INTO aircraft VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = null;
//        DBworker worker = new DBworker();
        DBworker worker = new DBworker(DB_URL,USER, PASS);

        //String query1 = "select * from aircraft";
        String query2 = "insert into aircraft (weight, width, height, horizontalSpeed, modelName, baloonVolume) values(120, 4, 5, 50, 'Hobby', 300);" +
                "insert into aircraft (weight, width, height, horizontalSpeed, modelName, baloonVolume) values(170, 1, 2, 60, 'Molla', 500);";

        try {
            Statement statement = worker.getConnection().createStatement();
            Connection con = worker.getConnection();

/*            statement.executeUpdate(query2);
            preparedStatement = con.prepareStatement(query2);
            preparedStatement = con.prepareStatement(DBworker.INSERT_NEW);
            preparedStatement.setInt(1,14);
            preparedStatement.setDouble(2, 300);
            preparedStatement.setDouble(3, 4);
            preparedStatement.setDouble(4, 5);
            preparedStatement.setInt(5, 150);
            preparedStatement.setInt(6,400);
            preparedStatement.setInt(7, 500);
            preparedStatement.setString(8, "SuperFly");
            preparedStatement.setInt(9,101);
            preparedStatement.setInt(10, 1);
            preparedStatement.setInt(11, 1);
            preparedStatement.execute();*/

            /*worker.Add(con, TABLE, 4, 300,4,5,150,400,500,"Dobby", 10, 200,1);
            worker.Add(con, TABLE, 5, 300,4,5,150,400,500,"Robby", 10, 200,2);
            worker.Add(con, TABLE, 6, 300,4,5,150,400,500,"SuperFly", 10, 200,3);
*/
            //preparedStatement = con.prepareStatement(GET_ALL);
            //preparedStatement.setString(1, "aircraft");

            //preparedStatement.executeQuery();
           // preparedStatement = worker.connection.prepareStatement(GET_ALL);
            worker.Delete(con,TABLE, 6);
            worker.Delete(con,TABLE, 5);
            ResultSet aircrafts = worker.Seek(con, "aircraft");
            worker.ShowOut(aircrafts);
            ResultSet airports = worker.Seek(con, "airport");
            worker.ShowOut(airports);
            ResultSet companies = worker.Seek(con, "company");
            worker.ShowOut(companies);
            ResultSet flights = worker.Seek(con, "flight");
            worker.ShowOut(flights);
            ResultSet parts = worker.Seek(con, "part");
            worker.ShowOut(parts);
            ResultSet persons = worker.Seek(con, "person");
            worker.ShowOut(persons);
            ResultSet shed_flights = worker.Seek(con, "shedueled_flight");
            worker.ShowOut(shed_flights);


            ResultSet res1 = worker.Seek(con, TABLE, "Uobby");
            worker.ShowOut(res1);

            worker.Update(con, TABLE, 1,"title","Oobby");
            ResultSet res2 = worker.Seek(con, TABLE, "Oobby");
            worker.ShowOut(res2);

            ResultSet res3 = worker.Seek(con, TABLE, 3);
            worker.ShowOut(res3);

            ResultSet res4 = worker.Seek(con, "aircraft");
            worker.ShowOut(res4);




            //ResultSet resultSet = preparedStatement.executeQuery();
            ResultSet resultSet = worker.Seek(con, TABLE);


            while (resultSet.next()) {
                Blimp blimp = new Blimp();
                blimp.setBaloonVolume(resultSet.getInt(10));
                blimp.setWeight(resultSet.getDouble(2));
                blimp.setWidth(resultSet.getDouble(3));
                blimp.setModelName(resultSet.getString("title"));
                int anInt = resultSet.getInt(1);
                //System.out.println(anInt);
                System.out.println(blimp);

            }


            /*System.out.println();
            System.out.println("______");

            while(resultSet.next()) {
                int id = resultSet.getInt("aircraft_id");
                String name = resultSet.getString("title");
                System.out.println("id: "+id+" Name "+name);
            }*/

            statement.close();
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


		/*
		static void Homework2 (){
			Planer planer = new Planer("airbus", 5.555555, 5.5555, 10.00000, 80.000, 12.4000);
	        System.out.println(planer.getHorizontalSpeed());
	        
	        planer.fly();
	        System.out.println();
	        System.out.println(planer.toString());
	        Planer [] planers = new Planer[2];
	        planers [0] = new Planer ("cat", 122.999);
	        planers [1] = new Planer ("dog", 123.999);
	        TreeSet<Planer> planerList = new TreeSet<Planer>();
	        planerList.add(planers [0]);
	        planerList.add(planers [1]);
	        
	        System.out.println();
	        
	        //Array.sort(planers);
	        for(Planer p: planerList) {
	        	System.out.println(p);
	        }
	        System.out.println();
	        
	        ArrayList<Blimp> blimpList = new ArrayList <Blimp>();
	        Blimp zilla = new Blimp ("zilla", 350.50);
	        Blimp golla = new Blimp ("golla", 280.00);
	        
	        blimpList.add(zilla);
	        blimpList.add(golla);
	        for( Blimp b: blimpList) {
	        	System.out.println(b);
	        }
	        
	        System.out.println();
	        
	        BaloonVolumeComparator myVolumeComp = new BaloonVolumeComparator();
	        blimpList.sort(myVolumeComp);
	        for( Blimp b: blimpList) {
	        	System.out.println(b);
	        }
		}
		static void Homework3(){ //
			// DoublyLinkedList<Blimp> BlimpList = new DoublyLinkedList<Blimp>();

			Blimp zilla = new Blimp ("zilla", 350.50);
			Blimp golla = new Blimp ("golla", 280.00);
			Blimp jimmy = new Blimp ("jimmy", 240.00);
			Blimp debrie = new Blimp ("debrie", 280.00);

			BlimpList.addFront(golla);
			BlimpList.addEnd(zilla);
			BlimpList.addAfter(zilla, jimmy);
			BlimpList.addBefore(jimmy, debrie);
			//BlimpList.remove(golla);

			if(BlimpList.contains(golla))
				System.out.println("true");
			//if(BlimpList.contains(zilla))
			//System.out.println("true");
			Object[] arr = new Object[BlimpList.size()];
			arr = BlimpList.toArrayy();


			String [] BlimpString = BlimpList.toStringg();
			for(int i = 0; i< BlimpList.size(); i++) {
				System.out.println(BlimpString[i]);
			}


			BlimpList.clear();

			//String [] BlimpStringg = BlimpList.toStringg();



			//forech(DoublyLinkedList Node: BlimpList)




		}
		*/
}

