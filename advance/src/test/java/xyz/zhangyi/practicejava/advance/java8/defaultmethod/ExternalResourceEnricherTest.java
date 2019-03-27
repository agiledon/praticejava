package xyz.zhangyi.practicejava.advance.java8.defaultmethod;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class ExternalResourceEnricherTest implements ExternalResourceEnricher {
    @Test
    public void should_enrich_external_resource() {
        ExternalResource resource = new ExternalResource("resource");
        assertThat(resource.getInfo(), is(nullValue()));

        ExternalResource result = enrich(resource, "info");
        assertThat(result.getInfo(), is("info"));
    }

}