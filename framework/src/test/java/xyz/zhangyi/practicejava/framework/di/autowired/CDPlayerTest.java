package xyz.zhangyi.practicejava.framework.di.autowired;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xyz.zhangyi.practicejava.framework.di.CDPlayerConfig;
import xyz.zhangyi.practicejava.framework.di.CompactDisc;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerConfig.class)
public class CDPlayerTest {
    @Autowired
    private CompactDisc cd;

    @Autowired
    private MediaPlayer player;

    @Test
    public void cd_should_be_not_null() {
        assertThat(cd).isNotNull();
        assertThat(cd.play()).isEqualTo("Playing Sgt. Pepper's Lonely Hearts Club Band by The Beatles");
    }

    @Test
    public void should_play() {
        assertThat(player.play()).isEqualTo("Playing Sgt. Pepper's Lonely Hearts Club Band by The Beatles");
    }

}