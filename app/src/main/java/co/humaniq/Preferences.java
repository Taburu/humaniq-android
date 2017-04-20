package co.humaniq;

import proxypref.annotation.DefaultBoolean;
import proxypref.annotation.DefaultInteger;
import proxypref.annotation.DefaultString;


public interface Preferences {
    @DefaultBoolean(true)
    Boolean getFirstRun();
    void setFirstRun(Boolean value);

    @DefaultBoolean(true)
    Boolean getShowDetection();
    void setShowDetection(Boolean value);

    @DefaultBoolean(true)
    Boolean getNeedPortrait();
    void setNeedPortrait(Boolean needPortrait);

    @DefaultBoolean(true)
    Boolean getUseFrontCamera();
    void setUseFrontCamera(Boolean value);

    @DefaultBoolean(true)
    Boolean getLivenessAuth();
    void setLivenessAuth(Boolean value);

    @DefaultString("")
    String getStartTime();
    void setStartTime(String time);

    @DefaultInteger(0)
    Integer getLoginCount();
    void setLoginCount(Integer count);

    // Account
    @DefaultInteger(0)
    Integer getAccountId();
    void setAccountId(Integer id);

    @DefaultString("")
    String getAccountAddress();
    void setAccountAddress(String account);

    @DefaultString("")
    String getAccountKeyFile();
    void setAccountKeyFile(String accountFile);

    @DefaultString("")
    String getAccountSalt();
    void setAccountSalt(String accountSalt);
}
