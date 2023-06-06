package file;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsertingFile {
	public static void main(String[] args) throws IOException {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver"); 		

			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/one","root","root");		


//			PreparedStatement p=connection.prepareStatement("insert into files values(?,?)");
//			
//			FileReader fr=new FileReader("D:\\jdbc1\\jdbcnotes.txt");
//			
//			p.setInt(1, 30);
//			p.setClob(2, fr);
			PreparedStatement p=connection.prepareStatement("select * from files");
			ResultSet r=p.executeQuery();
			
			while(r.next()) {
				System.out.print(r.getInt(1)+"\t");
				Reader re=r.getCharacterStream(2);
				int ch=re.read();
				while(ch!=-1) {
					System.out.print((char)ch);
					ch=re.read();
				}
			}
//			p.execute();
			connection.close();		

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
