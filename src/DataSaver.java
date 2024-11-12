import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DataSaver {
    public static void main(String[] args) {
        ArrayList<String> records = new ArrayList<>();
        int idCounter = 1;

        while (true) {
            System.out.println("Enter user data:");

            String firstName = SafeInput.getString("First Name: ");
            String lastName = SafeInput.getString("Last Name: ");
            String idNumber = String.format("%06d", idCounter);
            String email = SafeInput.getString("Email: ");
            int yearOfBirth = SafeInput.getInt("Year of Birth (4-digit): ");

            String record = String.join(", ", firstName, lastName, idNumber, email, String.valueOf(yearOfBirth));
            records.add(record);
            idCounter++;

            String continueInput = SafeInput.getString("Do you want to enter another record? (yes/no): ");
            if (!continueInput.equalsIgnoreCase("yes")) {
                break;
            }
        }

        String fileName = SafeInput.getString("Enter the filename (with .csv extension): ");
        try (FileWriter writer = new FileWriter("src/" + fileName)) {
            for (String record : records) {
                writer.write(record + "\n");
            }
            System.out.println("Data successfully saved to " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
        }
    }
}
