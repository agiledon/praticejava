package xyz.zhangyi.practicejava.design.cleancode.exception.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.zhangyi.practicejava.design.cleancode.exception.entities.ActiveManifest;
import xyz.zhangyi.practicejava.design.cleancode.exception.entities.ActivePackageInfo;
import xyz.zhangyi.practicejava.design.cleancode.exception.entities.PackageStatusPackageSoft;
import xyz.zhangyi.practicejava.design.cleancode.exception.entities.PkgType;

import java.util.List;


public class PreActivePackageValidator {
    private static final long OAM_VMP_FORBID_OPERATE_VARIOUS_PKG = 0;
    private static final long OAM_VMP_SW_TEMP_PKG = 1;
    private static final long OAM_VMP_ACTIVE_PKG_BEING_RUN = 2;
    private static final long OAM_VMP_ACTIVE_PKG_PATCH_ERROR = 3;
    private static final long OAM_VMP_SW_NO_RECORD = 4;
    private static final long OAM_VMP_EXIST_ACTIVE_BBUPKG = 5;
    private static final long NO_ERROR = -1;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private ActiveManifest activeManifest;
    private List<PackageStatusPackageSoft> pkgStatusInfos;

    private void validateSamePackage(int packageType, ActivePackageInfo pkg) {
        if (isDiffpackageType(packageType, pkg)) {
            throw new RuntimeException("pre active exist different type package");
        }
    }

    private void validateTempPakcage(ActivePackageInfo pkg)  {
        if (isTempPackage(pkg)) {
            throw new InvalidPackageException(String.format("pre active version %s is temp package", pkg.getVersion()));
        }
    }

    public long validatePreActivePkgStatus() {
        int existPkgNum = 0;
        int packageType = initialPkgType();

        for (ActivePackageInfo pkg : activeManifest.getPkgInfos()) {

                validateSamePackage(packageType, pkg);
                validateTempPakcage(pkg);


        }
        return NO_ERROR;
    }

    private int activeSameTypePkgNum(int packageType, List<PackageStatusPackageSoft> pkgStatusInfos) {
        return 0;
    }

    private boolean isFatherPkgIllegal(ActivePackageInfo pkg, PkgType fatherPkgType) {
        return false;
    }

    private PkgType getFatherPackageType(ActivePackageInfo pkg) {
        return null;
    }

    private boolean samePackage(ActivePackageInfo pkg, PackageStatusPackageSoft pkgStatus) {
        return false;
    }

    private int initialPkgType() {
        return 0;
    }

    private boolean isTempPackage(ActivePackageInfo pkg) {
        return false;
    }

    private boolean isDiffpackageType(int packageType, ActivePackageInfo pkg) {
        return false;
    }
}
