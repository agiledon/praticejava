package xyz.zhangyi.practicejava.framework.spring.di.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xyz.zhangyi.practicejava.framework.spring.di.CompactDisc;

@Component
public class CDPlayer implements MediaPlayer {
    private CompactDisc cd;

    @Autowired
    public CDPlayer(CompactDisc cd) {
        this.cd = cd;
    }

    @Override
    public String play() {
        return cd.play();
    }
}
