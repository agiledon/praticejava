package xyz.zhangyi.practicejava.io;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class FileIOSampleTest {
    private String filePath = FileIOSampleTest.class.getResource("/FileIOSample.java").getPath();

    @Test
    public void should_read_file_successfully() {
        FileIOSample stream = new FileIOSample();
        List<String> lines = stream.readFromDisk(filePath);
        assertThat(lines.get(0)).startsWith("package xyz.zhangyi.practicejava.io;");
    }

    @Test
    public void should_read_file_with_buffered_successfully() {
        FileIOSample stream = new FileIOSample();
        List<String> lines = stream.readFromDiskBuffered(filePath);
        assertThat(lines.get(0)).startsWith("package xyz.zhangyi.practicejava.io;");
    }
}