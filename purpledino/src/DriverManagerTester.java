import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
public class DriverManagerTester
{

	public static void main(String[] argv) {

		System.out.println("-------- MySQL JDBC Connection Testing ------------");
		System.out.println("MySQL JDBC Driver Registered!");


		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/SCHOOLDB?serverTimezone=UTC","root","Ardan13045545");
				Statement stmt = connection.createStatement();
				) 

		{
			if (connection != null) {
				System.out.println("You made it, take control your database now!");
			} else {
				System.out.println("Failed to make connection!");
			}
			String sql = "CREATE DATABASE IF NOT EXISTS SCHOOLDB";
			stmt.executeUpdate(sql);
			System.out.println("Database created successfully...");  


			String use = "USE SCHOOLDB";
			stmt.executeUpdate(use);
			System.out.println("Database is being used...");


			connection.setAutoCommit(false);



			//ADDRESS TABLE
			String address = "CREATE TABLE IF NOT EXISTS Address " +
					"(zipCode VARCHAR(100) NOT NULL, " +
					" city VARCHAR(100), " +
					" PRIMARY KEY(zipCode))";
			stmt.executeUpdate(address);
			System.out.println("address table created...");

			String a1 = "INSERT INTO Address VALUES('94536', 'Fremont')";
			String a2 = "INSERT INTO Address VALUES('94588', 'San Jose')";
			String a3 = "INSERT INTO Address VALUES('94512', 'Milpitas')";
			String a4 = "INSERT INTO Address VALUES('94509', 'San Jose')";
			String a5 = "INSERT INTO Address VALUES('94567', 'Livermore')";
			String a6 = "INSERT INTO Address VALUES('94553', 'San Ramon')";
			String a7 = "INSERT INTO Address VALUES('94511', 'Santa Clara')";
			stmt.addBatch(a1);
			stmt.addBatch(a2);       
			stmt.addBatch(a3);
			stmt.addBatch(a4);
			stmt.addBatch(a5);
			stmt.addBatch(a6);
			stmt.addBatch(a7);
			stmt.executeBatch();
			connection.commit();




			//TEACHER TABLE		
			String teacher = "CREATE TABLE IF NOT EXISTS Teacher " +
					"(teacherID VARCHAR(100), " +
					" teacherName VARCHAR(100), " + 
					" zipCode VARCHAR(100), " +
					" PRIMARY KEY(teacherID)," +
					" FOREIGN KEY (zipCode) REFERENCES address(zipCode))";         
			stmt.executeUpdate(teacher);
			System.out.println("teacher table created...");

			String t1 = "INSERT INTO Teacher VALUES('002', 'Lee', '94536')";
			String t2 = "INSERT INTO Teacher VALUES('007', 'Jones', '94536')";
			String t3 = "INSERT INTO Teacher VALUES('032', 'Nguyen', '94536')";
			String t4 = "INSERT INTO Teacher VALUES('034', 'Wong', '94588')";
			String t5 = "INSERT INTO Teacher VALUES('064', 'Miller', '94588')";
			String t6 = "INSERT INTO Teacher VALUES('079', 'Flores', '94512')";
			String t7 = "INSERT INTO Teacher VALUES('082', 'Philips', '94509')";
			String t8 = "INSERT INTO Teacher VALUES('088', 'Gadd', '94567')";
			String t9 = "INSERT INTO Teacher VALUES('089', 'Corona', '94553')";
			String t10 = "INSERT INTO Teacher VALUES('093', 'Henderson', '94511')";
			stmt.addBatch(t1);
			stmt.addBatch(t2);
			stmt.addBatch(t3);
			stmt.addBatch(t4);
			stmt.addBatch(t5);
			stmt.addBatch(t6);
			stmt.addBatch(t7);
			stmt.addBatch(t8);
			stmt.addBatch(t9);
			stmt.addBatch(t10);
			stmt.executeBatch();
			connection.commit();



			//COURSE TABLE
			String course = "CREATE TABLE IF NOT EXISTS Course " +
					"(courseID VARCHAR(100) not NULL, " +
					" teacherID VARCHAR(100), " + 
					" courseName VARCHAR(100), " +
					" PRIMARY KEY (courseID), " +
					" FOREIGN KEY (teacherID) REFERENCES teacher(teacherID))";
			stmt.executeUpdate(course);
			System.out.println("course table created...");

			String c1 = "INSERT INTO Course VALUES('1001', '002', 'CS47')";
			String c2 = "INSERT INTO Course VALUES('1002', '002', 'CS151')";
			String c3 = "INSERT INTO Course VALUES('1003', '002', 'CS149')";
			String c4 = "INSERT INTO Course VALUES('1004', '007', 'GEO12')";
			String c5 = "INSERT INTO Course VALUES('1005', '007', 'GEO1A')";
			String c6 = "INSERT INTO Course VALUES('1006', '032', 'EVNS15')";
			String c7 = "INSERT INTO Course VALUES('1007', '032', 'ENVS49')";
			String c8 = "INSERT INTO Course VALUES('1008', '034', 'NUFS139')";
			String c9 = "INSERT INTO Course VALUES('1009', '034', 'NUFS151')";
			String c10 = "INSERT INTO Course VALUES('1010', '064', 'KIN123')";
			String c11 = "INSERT INTO Course VALUES('1011', '079', 'ENGR10')";
			String c12 = "INSERT INTO Course VALUES('1012', '082', 'PHYS50')";
			String c13 = "INSERT INTO Course VALUES('1013', '082', 'PHYS51')";
			String c14 = "INSERT INTO Course VALUES('1014', '088', 'CHEM1A')";
			String c15 = "INSERT INTO Course VALUES('1015', '093', 'PHIL134')";
			String c16 = "INSERT INTO Course VALUES('1016', '093', 'PHIL178')";


			stmt.addBatch(c1);
			stmt.addBatch(c2);
			stmt.addBatch(c3);
			stmt.addBatch(c4);
			stmt.addBatch(c5);
			stmt.addBatch(c6);
			stmt.addBatch(c7);
			stmt.addBatch(c8);
			stmt.addBatch(c9);
			stmt.addBatch(c10);
			stmt.addBatch(c11);
			stmt.addBatch(c12);
			stmt.addBatch(c13);
			stmt.addBatch(c14);
			stmt.addBatch(c15);
			stmt.addBatch(c16);
			stmt.executeBatch();
			connection.commit();




			//STUDENT TABLE
			String student = "CREATE TABLE IF NOT EXISTS Student " +
					"(studentID VARCHAR(100) not NULL, " +
					"studentName VARCHAR(100),"+
					" zipCode VARCHAR(100), " +
					" PRIMARY KEY (studentID), " +
                    " FOREIGN KEY (zipCode) REFERENCES address(zipCode))";
			stmt.executeUpdate(student);
			System.out.println("student table created...");


			connection.setAutoCommit(false);
			String s1 = "INSERT INTO Student VALUES('012', 'Josh', '94536')";
			String s2 = "INSERT INTO Student VALUES('123', 'Sai', '94588')";
			String s3 = "INSERT INTO Student VALUES('345', 'Michael', '94512')";
			String s4 = "INSERT INTO Student VALUES('567', 'Johnathan', '94509')";
			String s5 = "INSERT INTO Student VALUES('789', 'Brianna', '94567')";
			String s6 = "INSERT INTO Student VALUES('910','Xander', '94553')";
			String s7 = "INSERT INTO Student VALUES('101', 'Brian', '94536')";
			String s8 = "INSERT INTO Student VALUES('112', 'Kim', '94588'  )";
			String s9 = "INSERT INTO Student VALUES('134', 'Kourtney','94588' )";
			String s10 = "INSERT INTO Student VALUES('983', 'Khloe', '94511' )";
			String s11 = "INSERT INTO Student VALUES('984', 'Kylie', '94588' )";
			String s12 = "INSERT INTO Student VALUES('985', 'Kendall', '94553' )";
			stmt.addBatch(s1);
			stmt.addBatch(s2);
			stmt.addBatch(s3);
			stmt.addBatch(s4);
			stmt.addBatch(s5);
			stmt.addBatch(s6);
			stmt.addBatch(s7);
			stmt.addBatch(s8);
			stmt.addBatch(s9);
			stmt.addBatch(s10);
			stmt.addBatch(s11);
			stmt.addBatch(s12);
			stmt.executeBatch();
			connection.commit();



			//SUBJECT TABLE
			String subject = "CREATE TABLE IF NOT EXISTS Subject " +
					"(subjectID VARCHAR(100) not NULL, " +
					" subjectName VARCHAR(100), " + 
					" PRIMARY KEY (subjectID))"; 
			stmt.executeUpdate(subject);
			System.out.println("subject table created...");

			String sub1 = "INSERT INTO Subject VALUES('981', 'Computer Science')";
			String sub2 = "INSERT INTO Subject VALUES('982', 'Nutritional Science')";
			String sub3 = "INSERT INTO Subject VALUES('983', 'Philosophy')";
			String sub4 = "INSERT INTO Subject VALUES('984', 'Environmental Science')";
			String sub5 = "INSERT INTO Subject VALUES('985', 'Computer Science')";
			String sub6 = "INSERT INTO Subject VALUES('986', 'Geology')";
			String sub7 = "INSERT INTO Subject VALUES('987', 'Chemistry')";
			String sub8 = "INSERT INTO Subject VALUES('988', 'English')";
			String sub9 = "INSERT INTO Subject VALUES('989', 'Software Engineering')";
			String sub10 = "INSERT INTO Subject VALUES('990', 'Physics')";
			String sub11 = "INSERT INTO Subject VALUES('991', 'Kinesiology')";
			stmt.addBatch(sub1);
			stmt.addBatch(sub2);
			stmt.addBatch(sub3);
			stmt.addBatch(sub4);
			stmt.addBatch(sub5);
			stmt.addBatch(sub6);
			stmt.addBatch(sub7);
			stmt.addBatch(sub8);
			stmt.addBatch(sub9);
			stmt.addBatch(sub10);
			stmt.addBatch(sub11);
			stmt.executeBatch();
			connection.commit();




			//ENROLLMENT TABLE
			String enrollment = "CREATE TABLE IF NOT EXISTS Enrollment " +
					"(courseID VARCHAR(100)," +
					" subjectID VARCHAR(100) not NULL, " +
					" studentID VARCHAR(100))";
			stmt.executeUpdate(enrollment);
			System.out.println("Enrollment table created...");

			String se1 = "INSERT INTO Enrollment VALUES('1001', '980', '012')";
			String se2 = "INSERT INTO Enrollment VALUES('1002', '980', '123')";
			String se3 = "INSERT INTO Enrollment VALUES('1003', '980', '345')";
			String se4 = "INSERT INTO Enrollment VALUES('1004', '986', '567')";
			String se5 = "INSERT INTO Enrollment VALUES('1005', '986', '789')";
			String se6 = "INSERT INTO Enrollment VALUES('1006','984', '910')";
			String se7 = "INSERT INTO Enrollment VALUES('1007', '984', '101')";
			String se8 = "INSERT INTO Enrollment VALUES('1008', '982', '112')";
			String se9 = "INSERT INTO Enrollment VALUES('1009', '982', '134')";
			String se10 = "INSERT INTO Enrollment VALUES('1010','991', '983')";
			String se11 = "INSERT INTO Enrollment VALUES('1011', '989', '984')";
			String se12 = "INSERT INTO Enrollment VALUES('1012', '990', '985')";
			String se13 = "INSERT INTO Enrollment VALUES('1013',  '990', '985')";
			String se14 = "INSERT INTO Enrollment VALUES('1014', '987', '984')";
			String se15 = "INSERT INTO Enrollment VALUES('1015', '983', '983')";
			String se16 = "INSERT INTO Enrollment VALUES('1016', '983', '134')";
			String se17 = "INSERT INTO Enrollment VALUES('1001', '980', '012')";
			String se18 = "INSERT INTO Enrollment VALUES('1002', '980', '101')";
			String se19 = "INSERT INTO Enrollment VALUES('1003', '980', '910')";
			String se20 = "INSERT INTO Enrollment VALUES('1004', '986', '789')";
			String se21 = "INSERT INTO Enrollment VALUES('1005', '986', '567')";
			String se22 = "INSERT INTO Enrollment VALUES('1006','984', '345')";
			String se23 = "INSERT INTO Enrollment VALUES('1007', '984', '345')";
			String se24 = "INSERT INTO Enrollment VALUES('1008', '982', '123')";
			String se25 = "INSERT INTO Enrollment VALUES('1009', '982', '012')";
			stmt.addBatch(se1);
			stmt.addBatch(se2);
			stmt.addBatch(se3);
			stmt.addBatch(se4);
			stmt.addBatch(se5);
			stmt.addBatch(se6);
			stmt.addBatch(se7);
			stmt.addBatch(se8);
			stmt.addBatch(se9);
			stmt.addBatch(se10);
			stmt.addBatch(se11);
			stmt.addBatch(se12);
			stmt.addBatch(se13);
			stmt.addBatch(se14);
			stmt.addBatch(se15);
			stmt.addBatch(se16);
			stmt.addBatch(se17);
			stmt.addBatch(se18);
			stmt.addBatch(se19);
			stmt.addBatch(se20);
			stmt.addBatch(se21);
			stmt.addBatch(se22);
			stmt.addBatch(se23);
			stmt.addBatch(se24);
			stmt.addBatch(se25);
			stmt.executeBatch();
			connection.commit();


			System.out.println("all tables created...");
			
			
			
			  ResultSet rs = stmt.executeQuery("SELECT distinct teacherName, studentName FROM Teacher \n"
			  		+ "NATURAL JOIN Student NATURAL JOIN Address \n"
			  		+ "WHERE Teacher.zipCode = Student.zipCode;");
	            while (rs.next()) {
	            	  String x = rs.getString("teacherName");
	            	  String y = rs.getString("studentName");
	            	  System.out.println(x + ", " + y);
	            }
		

		} catch (SQLException e) {
			e.printStackTrace();
		} 
		

	}
}
//test

