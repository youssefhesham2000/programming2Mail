package eg.edu.alexu.csd.datastructure.mailServer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;






public class FolderManagerBIN {

	public FolderManagerBIN() {
	    
	}
		
	public static void initProgramDirectories()
	{
		new File("./Users").mkdirs();
	}
	
	
	public static User getUser(String email)
	{
		//TODO Load users one time only
		DoubleLinkedList users = getUsers();
		for(int i = 0; i < users.size();i++)
		{
			User user = (User)users.get(i);
			for(int j = 0; j < 10;j++)
			{
				String userEmail = user.emails[j];
				if(email.equals(userEmail))
					return user;
			}
		}
		return null;
	}
	
	public static void WriteObjectToFile(Object serObj, String path) {
		
		//System.out.println(serObj.getClass().toString());
		
        try {
            FileOutputStream fileOut = new FileOutputStream(path);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(serObj);
            objectOut.close();
            System.out.println("The Object  was succesfully written to a file");
 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
	
	
	public static Object ReadObjectFromFile(String path)
	{
		Object s = null;
		try
		{
			FileInputStream fstream = new FileInputStream(path);
			ObjectInputStream objectIn = new ObjectInputStream(fstream);
			
			s = (Object)objectIn.readObject();
			fstream.close();
			objectIn.close();
		}catch(Exception e)
		{
			try {
				new File(path).createNewFile();
			} catch (IOException e1) {
				System.out.println(e1.toString());
			}
		}
		return s;
	}
	
		
	
	public static void saveUsersLinkedList(DoubleLinkedList users)
	{
		WriteObjectToFile(users, "./Users/usersIndex.json");
	}
	
	/**  
	 * @return a DoublyLinkedList of all the users' JSONobjects
	 */
	public static DoubleLinkedList getUsers() 
	{
		DoubleLinkedList d = (DoubleLinkedList)ReadObjectFromFile("./Users/usersIndex.json");
		if(d == null)
			return new DoubleLinkedList();
		return d;
	}
	
	public static void addUser(User newUser) {
		DoubleLinkedList users = getUsers();
		
		users.add(newUser);
		saveUsersLinkedList(users);
	}
	
	public static void printUsers() {
		DoubleLinkedList arr = getUsers();
		for (int i = 0;i < arr.size();i++) {
			User user = (User) arr.get(i);
			System.out.println("---------------------------------------");
			System.out.println("Id = " + user.id);
			
			String[] emails = user.emails;
			String password = user.password;

			for (int j = 0;j < 10 && emails[j] != null;j++)
				System.out.println("Email : " + emails[j] + ", pass : " + password);
		}
		System.out.println("........................................");
	}
	
	
	
	/*public static void main(String[] args) {
		FolderManagerBIN f = new FolderManagerBIN();
		f.initProgramDirectories();
		DoublyLinkedList users = getUsers();
		users.add(new User("ahmed", "Bahgat", "ahmedelsherif@gmal.com", "fsfsdfds"));
		saveUsersLinkedList(users);
		
		System.out.println(((User)users.get(0)).emails[0]);
	}*/
}
