package xyz.zhangyi.practicejava.libraries.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpClientSample {
    public String getContentFrom(String url) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        try {
            HttpGet get = new HttpGet(url);
            String responseBody = client.execute(get, response -> {
                int status = response.getStatusLine().getStatusCode();
                if (status >= 200 && status < 300) {
                    HttpEntity entity = response.getEntity();
                    return entity != null ? EntityUtils.toString(entity): null;
                } else {
                    throw new ClientProtocolException("Unexpected response status: " + status);
                }
            });
            return responseBody;
        } finally {
            client.close();
        }
    }

    public String fluentGet(String url) throws IOException {
        return Request.Get(url)
                .connectTimeout(5000)
                .socketTimeout(5000)
                .execute().returnContent().asString();
    }
}
