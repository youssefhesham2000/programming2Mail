package eg.edu.alexu.csd.datastructure.mailServer.gui;

import eg.edu.alexu.csd.datastructure.linkedList.cs.Classes.DoublyLinkedList;
import eg.edu.alexu.csd.datastructure.mailServer.FolderManagerBIN;

public class MainGUI {
	public static void main(String[] args) {
		
		
		/*FolderManagerBIN.saveUsersLinkedList(new DoublyLinkedList());
		User test = new User("haha", "popo", "koskos@zobzob.com", "passssap");
		
		FolderManagerBIN.addUser(test);
		EmailViewGUI.Run("koskos@zobzob.com", new DoublyLinkedList());*/
		FolderManagerBIN.saveUsersLinkedList(new DoublyLinkedList());
		MainPageGUI.Run();
	}
}
 