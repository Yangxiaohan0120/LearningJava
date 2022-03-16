package Multithreading;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * @author Chris Yang
 * created 2022-03-08 15:35
 **/
public class Pipe {

    static class ReaderThread implements Runnable {
        private PipedReader reader;

        public ReaderThread(PipedReader reader) {
            this.reader = reader;
        }

        @Override
        public void run() {
            System.out.println("This is Reader");
            int receive = 0;
            try {
                while ((receive = reader.read()) != -1) {
                    System.out.println((char)receive);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    static class WriterThread implements Runnable {
        private PipedWriter writer;

        public WriterThread(PipedWriter writer) {
            this.writer = writer;
        }

        @Override
        public void run() {
            System.out.println("This is Writer");
            int receive = 0;
            try {
                writer.write("Test");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        PipedReader reader = new PipedReader();
        PipedWriter writer = new PipedWriter();
        writer.connect(reader);

        new Thread(new ReaderThread(reader)).start();
        Thread.sleep(1000);
        new Thread(new WriterThread(writer)).start();
    }
}
