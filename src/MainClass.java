
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {

        try {
            Scanner file = new Scanner(new File("C:\\Users\\LENOVO\\eclipse-workspace1\\Compiler Design\\src\\Program.txt"));
            file.useDelimiter("\\Z"); // end of file

            LexAnalyzer lex = new LexAnalyzer();

            String source = file.next();
            boolean error =lex.tokenize(source);

            System.out.println("lexical Analyser: ");
            for (Token token : lex.tokens) {
                System.out.println(token);
            }
            
            System.out.println("Tokens/lexeme are: ");
            for (Token token : lex.tokens) {
                System.out.println(token.lexeme);
            }
            
            System.out.println("TokenType are: ");
            for (Token token : lex.tokens) {
                System.out.println(token.type);
            }

            if (!error) {
                Parser p = new Parser(lex.tokens);
//                System.out.println(p.isValid());
                if (p.isValid())
                    System.out.println("Parsed successfully!");
                else {
                  
                    System.out.println("The passed string is not valid");
                }

            }
            
            file.close();
        } catch (FileNotFoundException f) {
            System.err.println(args[0] + " couldn't be opened.");
            System.exit(0);
        }

    }

}