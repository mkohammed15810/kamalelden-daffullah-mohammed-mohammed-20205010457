import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ArrayList<String> tasks = new ArrayList<>();

        // Enter 3 tasks
        System.out.println("===== ENTER 3 TASKS =====");

        for (int i = 0; i < 3; i++) {
            System.out.print("Enter Task " + (i + 1) + ": ");
            String task = input.nextLine();
            tasks.add(task);
        }

        // Display tasks
        System.out.println("\n===== TASK LIST =====");

        for (String task : tasks) {
            System.out.println(task);
        }

        // Save tasks into task.txt
        try {
            FileWriter writer = new FileWriter("task.txt");

            for (String task : tasks) {
                writer.write(task + "\n");
            }

            writer.close();
            System.out.println("\nTasks saved successfully.");

        } catch (IOException e) {
            System.out.println("Error saving file.");
        }

        // Read tasks from task.txt
        System.out.println("\n===== TASKS LOADED FROM FILE =====");

        try {

            File file = new File("task.txt");
            Scanner reader = new Scanner(file);

            while (reader.hasNextLine()) {
                String task = reader.nextLine();
                System.out.println(task);
            }

            reader.close();

        } catch (IOException e) {
            System.out.println("Error reading file.");
        }

        input.close();
    }
}