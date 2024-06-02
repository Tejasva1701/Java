import java.io.*;

public class BufferedIOStreamExample {

    public static void main(String[] args) {
        // Define file paths
        String inputFilePath = "input.txt";
        String outputFilePath = "output.txt";

        // Use Buffered I/O stream classes to read from input file and write to output file
        try (
            FileInputStream fileInputStream = new FileInputStream(inputFilePath);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            FileOutputStream fileOutputStream = new FileOutputStream(outputFilePath);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        ) {
            int byteRead;
            while ((byteRead = bufferedInputStream.read()) != -1) {
                bufferedOutputStream.write(byteRead);
            }

            System.out.println("File reading and writing completed successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Display the content of the output file
        System.out.println("\nContent of the output file:");
        displayFileContent(outputFilePath);
    }

    // Method to display the content of a file
    private static void displayFileContent(String filePath) {
        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream)) {
            int byteRead;
            while ((byteRead = bufferedInputStream.read()) != -1) {
                System.out.print((char) byteRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


/*Hello, this is a sample text file.
It contains several lines of text.
Each line will be read by the Java program.
The content will be written to the output file.
This demonstrates Buffered I/O stream classes in Java.
End of the sample text.*/