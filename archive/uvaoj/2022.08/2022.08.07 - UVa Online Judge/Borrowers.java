package roy.coder;

import roy.coder.utils.io.InputReader;
import roy.coder.utils.io.OutputWriter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Borrowers {

    static class Book {
        String name;
        String author;

        public Book(String name, String author) {
            this.name = name;
            this.author = author;
        }
    }

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        List<Book> books = new ArrayList<>();
        while (true) {
            String book = in.readLine();
            if (book.equals("END")) break;
            String[] parts = book.split(" by ");
            books.add(new Book(parts[0], parts[1]));
        }

        books.sort((o1, o2) -> {
            int c = o1.author.compareTo(o2.author);
            if (c == 0) return o1.name.compareTo(o2.name);
            return c;
        });

        Map<String, Integer> trace = new HashMap<>();
        for (int i = 0; i < books.size(); i++) {
            trace.put(books.get(i).name, i);
        }
        boolean[] borrowed = new boolean[books.size()];
        boolean[] returned = new boolean[books.size()];
        while (true) {
            String command = in.readLine();
            if (command.equals("END")) break;

            String book = "";
            int index = -1;
            if (command.startsWith("BORROW ")) {
                book = command.split("BORROW ")[1];
                index = trace.get(book);
                command = "BORROW";
            } else if (command.startsWith("RETURN ")) {
                book = command.split("RETURN ")[1];
                index = trace.get(book);
                command = "RETURN";
            } else command = "SHELVE";

            switch (command) {
                case "BORROW":
                    borrowed[index] = true;
                    break;
                case "RETURN":
                    returned[index] = true;
                    break;
                case "SHELVE":
                    String last = "";
                    for (int i = 0; i < books.size(); i++) {
                        Book curr = books.get(i);
                        if (!borrowed[i]) last = curr.name;
                        else if (returned[i]) {
                            if (last.length() == 0) out.printLine("Put " + curr.name + " first");
                            else out.printLine("Put " + curr.name + " after " + last);
                            last = curr.name;
                            borrowed[i] = returned[i] = false;
                        }
                    }
                    out.printLine("END");
                    break;
                default:
                    //ignore
            }
        }
    }
}
