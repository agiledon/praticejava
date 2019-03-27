package xyz.zhangyi.practicejava.design.cleancode.exception.entities;

import java.util.List;

public class ActiveManifest {
    private List<ActivePackageInfo> pkgInfos;
    private int packageNum;

    public List<ActivePackageInfo> getPkgInfos() {
        return pkgInfos;
    }

    public int getPackageNum() {
        return packageNum;
    }
}
