import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MyLanguageMain {
    public static void main(String[] args) {
        String code = "IF (+ 2 3) THEN (PRINT 'Hello') END";
        MyLanguageLexer lexer = new MyLanguageLexer(CharStreams.fromString(code));
        MyLanguageParser parser = new MyLanguageParser(new CommonTokenStream(lexer));

        MyLanguageParser.ProgramContext programContext = parser.program();

        MyLanguageVisitor visitor = new MyLanguageVisitor();
        visitor.visitProgram(programContext);
        visitor.test();

        executeLLVMCodeWithLLI("test.ll");
    }

    private static void executeLLVMCodeWithLLI(String llvmFileName) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("lli", llvmFileName);
            Process process = processBuilder.start();

            try (java.util.Scanner scanner = new java.util.Scanner(process.getInputStream())) {
                while (scanner.hasNextLine()) {
                    System.out.println(scanner.nextLine());
                }
            }

            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
