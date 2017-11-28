package br.udesc.modulo2.log;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Log {

    public class LogWriter {

        private String path;

        public LogWriter() throws IOException {
            this.path = "log.txt";
            startLog();
        }

        public void logMessage(String message) throws IOException {
            FileWriter filewriter = new FileWriter(path, true);
            BufferedWriter out = new BufferedWriter(filewriter);
            out.write(new Date().toString() + " - " + message);
            out.newLine();
            out.close();

        }

        public void startLog() throws IOException {
            FileWriter filewriter = new FileWriter(path, true);
            BufferedWriter out = new BufferedWriter(filewriter);
            out.write(new Date().toString() + " - Log started");
            out.newLine();
            out.close();

        }

        public void endLog() throws IOException {
            FileWriter filewriter = new FileWriter(path, true);
            BufferedWriter out = new BufferedWriter(filewriter);
            out.write(new Date().toString() + " - Log ended");
            out.newLine();
            out.close();
        }
    }
}
