import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectStreamTest {

	public static void main(String[] args) {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream("person.ser");
			ois = new ObjectInputStream(fis);
			Person p = (Person)ois.readObject();
			System.out.println(p);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ois != null) ois.close();
			} catch(IOException E) {}
		}
		
//		FileOutputStream fos = null;
//		ObjectOutputStream oos = null;
//		try {
//			fos = new FileOutputStream("person.ser");
//			oos = new ObjectOutputStream(fos);
//			oos.writeObject(new Person(10, "hONG"));
//		} catch(Exception e) {
//			
//		} finally {
//			try {
//				if(oos != null) oos.close();
//			} catch(IOException E) {}
//		}
	}

}
