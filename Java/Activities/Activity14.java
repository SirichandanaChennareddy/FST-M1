package JavaActivities;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;

public class Activity14 {

	public static void main(String[] args) throws IOException {
		try {
			File file = new File("src/TestFiles/newfile.txt");
			boolean Fstatus = file.createNewFile();
			List<String> list = null;
			if (Fstatus) {
				System.out.println("File Created Successfully");
				Scanner scan = new Scanner(System.in);
				list = new ArrayList<>();
				System.out.println("Please enter data :");
				// while (scan.hasNextInt()) {
				// list.add(scan.next());

				while (scan.hasNextLine()) {
					String S = scan.nextLine();
					if (((String) S).isEmpty() || (S == null)) {
						break;
					} else {
						list.add(S);
					}
					FileWriter writer = new FileWriter("src/TestFiles/newfile.txt");
					for (String str : list) {
						writer.write(str + System.lineSeparator());
						// writer.write(str);
					}
					writer.close();

				}
			} else {
				System.out.println("File Already exists in the Specified Path");
				boolean itsDeleted = file.delete();
				System.out.println("Its Deleted: " + itsDeleted);
			}
			File FU = FileUtils.getFile("src/TestFiles/newfile.txt");
			String data = FileUtils.readFileToString(FU, "UTF8");
			System.out.println("data in file: " + data);
			File newDir = new File("resources");
			FileUtils.copyFileToDirectory(file, newDir);
			File NewFile = FileUtils.getFile(newDir, "newfile.txt");
			String data1 = FileUtils.readFileToString(NewFile, "UTF8");
			System.out.println("Data in moved File : " + data1);
		} catch (IOException Errormessage) {
			System.out.println(Errormessage);
			System.out.println(
					"As File Already Exists Hence Existing file Deleted ,A new File will be Created in Next Run to Process");
		}
	}
}
