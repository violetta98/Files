import java.io.*;

class FileWorker {

    public static void write(String fileName, String text) throws IOException {
        File file = new File(fileName); // определяем файл
        try {
//            if (!file.exists()) // проверяем существует ли файл
//                file.createNewFile(); // если нет, то создаем его
            PrintWriter out = new PrintWriter(file.getAbsoluteFile()); // обеспечивает возможность записи в файл
            try {
                out.print(text); // запись текста в файл
            } finally {
                out.close(); // закрываем файлозаписыватель, т.к. если мы его не закроем, то ничего в файл не запишется
            }
        } catch (IOException e) {
            throw new IOException(e);
        }
    }

    public static String read(String fileName) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        File file = new File(fileName); // определяем файл
        if (!file.exists()) { // проверяем сущестует ли файл
            throw new FileNotFoundException(file.getName());
        }
        try {
            BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile())); // объект для чтения файла в буфер
            try {
                // в цикле построчно считываем файл
                String s = in.readLine();
                while (s != null) {
                    stringBuilder.append(s);
                    stringBuilder.append("\n");
                    s = in.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                in.close(); // закрываем считыватель файла
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
        return stringBuilder.toString();
    }

}

public class Main {

    public static void main(String[] args) throws IOException {
        FileWorker.write("ololosh", "шоа\n478jfb fhb fjvhb\njgrtfhnv");
     //   String data = FileWorker.read("ololosh");
       // System.out.println(data);
    }

}



