import java.io.*;

public class FileIOExample {

    public static void main(String[] args) {
        // Define file paths
        String inputFilePath = "input.txt";
        String outputFilePath = "output.txt";

        // Read from the input file and write to the output file
        try {
            // Create BufferedReader for reading the input file
            BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
            // Create BufferedWriter for writing to the output file
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath));

            String line;
            while ((line = reader.readLine()) != null) {
                // Write the line to the output file
                writer.write(line);
                writer.newLine(); // Add a new line after each line written
            }

            // Close the resources
            reader.close();
            writer.close();

            System.out.println("File reading and writing completed successfully.");

            // Display the content of the output file
            System.out.println("\nContent of the output file:");
            displayFileContent(outputFilePath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to display the content of a file
    private static void displayFileContent(String filePath) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


/*Hello, this is a sample text file.
It contains several lines of text.
Each line will be read by the Java program.
The content will be written to the output file.
This demonstrates basic file I/O in Java.
End of the sample text.*/
