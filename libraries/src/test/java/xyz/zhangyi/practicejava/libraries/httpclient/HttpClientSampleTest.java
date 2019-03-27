package xyz.zhangyi.practicejava.libraries.httpclient;

import org.junit.Ignore;
import org.junit.Test;
import xyz.zhangyi.practicejava.libraries.httpclient.HttpClientSample;

import java.io.IOException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class HttpClientSampleTest {

    @Test
    @Ignore
    public void should_get_content_from_url() throws IOException {
        HttpClientSample clientSample = new HttpClientSample();
        String response = clientSample.getContentFrom("http://www.zhangyi.xyz");
        assertThat(response).startsWith("<!DOCTYPE html>")
                .endsWith("</html>")
                .contains("post");
    }

    @Test
    @Ignore
    public void should_get_content_from_url_via_fluent_api() throws IOException {
        HttpClientSample clientSample = new HttpClientSample();
        String response = clientSample.fluentGet("http://www.zhangyi.xyz");
        assertThat(response).startsWith("<!DOCTYPE html>")
                .endsWith("</html>")
                .contains("post");
    }

}