package xyz.zhangyi.practicejava.advance.java8.defaultmethod;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ResourceParserTest implements ResourceParser {
    @Test
    public void should_parse_external_resource_to_resource() {
        ExternalResource externalResource = new ExternalResource("resource");
        Resource resource = parse(externalResource);

        assertThat(resource.getResourceInfo(), is("name: resource; info: null"));
    }
}