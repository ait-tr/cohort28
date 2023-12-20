package regExExaple.workWithGroup;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatches {
    public static void main( String args[] ) {
        // Строка для сканирования, чтобы найти шаблон.
        String line = "This order was placed for QT2001! OK?";
        String pattern = "(.*?)(\\d+)(.*)";
        // Создаем объект Pattern
        Pattern r = Pattern.compile(pattern);
        // Теперь создаем объект соответствия.
        Matcher m = r.matcher(line);
        if (m.find()) {
            System.out.println(m.groupCount());
            System.out.println("Found value: " + m.group(0) );
            System.out.println("Found value: " + m.group(1) );
            System.out.println("Found value: " + m.group(2) );
            System.out.println("Found value: " + m.group(3) );
        }else {
            System.out.println("NO MATCH");
        }
    }
}