package xyz.zhangyi.practicejava.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileIOSample {
    private static final String SOURCE_CLASS = "INPUT_STREAM_WRAPPER";
    Logger log = Logger.getLogger(FileIOSample.class.getName());

    public List<String> readFromDisk(String filename) {
        final String METHOD_NAME = "readFromDisk(String filename)";
        List<String> employees = new ArrayList<>();
        File file = new File(filename);
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(file))) {
            StringBuilder sb = new StringBuilder();
            int character = reader.read();
            while (character != -1) {
                sb.append((char)character);
                character = reader.read();
            }
            int index = 0;
            while (index < sb.length()-1) {
                StringBuilder line = new StringBuilder();
                while (sb.charAt(index) != '\n') {
                    line.append(sb.charAt(index++));
                }
                employees.add(line.toString());
                index++;
            }
        } catch (FileNotFoundException e) {
            log.logp(Level.SEVERE, SOURCE_CLASS, METHOD_NAME, "Cannot find file " +
                    file.getName() + ", message = " + e.getLocalizedMessage(), e);
        } catch (IOException e) {
            log.logp(Level.SEVERE, SOURCE_CLASS, METHOD_NAME, "IOException occurred, message = " + e.getLocalizedMessage(), e);
        }
        return employees;
    }

    public boolean saveToDisk(String filename, List<String> lines) {
        final String METHOD_NAME = "saveToDisk(String filename, List<String> lines)";

        boolean ret = false;
        File file = new File(filename);
        try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(file))) {
            log.info("Writing " + lines.size() + " lines to disk (as String)...");
            for (String line : lines) {
                writer.write(line +"\n");
            }
            ret = true;
            log.info("Done.");
        } catch (FileNotFoundException e) {
            log.logp(Level.SEVERE, SOURCE_CLASS, METHOD_NAME, "Cannot find file " +
                    file.getName() + ", message = " + e.getLocalizedMessage(), e);
        } catch (IOException e) {
            log.logp(Level.SEVERE, SOURCE_CLASS, METHOD_NAME, "IOException occurred, message = " + e.getLocalizedMessage(), e);
        }
        return ret;
    }

    public List<String> readFromDiskBuffered(String filename) {
        final String METHOD_NAME = "readFromDisk(String filename)";
        List<String> employees = new ArrayList<>();
        File file = new File(filename);
        try (Reader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            StringBuilder sb = new StringBuilder();
            int character = reader.read();
            while (character != -1) {
                sb.append((char)character);
                character = reader.read();
            }
            int index = 0;
            while (index < sb.length()-1) {
                StringBuilder line = new StringBuilder();
                while (sb.charAt(index) != '\n') {
                    line.append(sb.charAt(index++));
                }
                employees.add(line.toString());
                index++;
            }
        } catch (FileNotFoundException e) {
            log.logp(Level.SEVERE, SOURCE_CLASS, METHOD_NAME, "Cannot find file " +
                    file.getName() + ", message = " + e.getLocalizedMessage(), e);
        } catch (IOException e) {
            log.logp(Level.SEVERE, SOURCE_CLASS, METHOD_NAME, "IOException occurred, message = " + e.getLocalizedMessage(), e);
        }
        return employees;
    }
}
