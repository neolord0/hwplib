package kr.dogfoot.hwplib.object;

public class Scripts {
    private byte[] defaultJScript;
    private byte[] jScriptVersion;

    public Scripts() {
        defaultJScript = null;
        jScriptVersion = null;
    }

    public byte[] getDefaultJScript() {
        return defaultJScript;
    }

    public void setDefaultJScript(byte[] defaultJScript) {
        this.defaultJScript = defaultJScript;
    }

    public byte[] getJScriptVersion() {
        return jScriptVersion;
    }

    public void setJScriptVersion(byte[] jScriptVersion) {
        this.jScriptVersion = jScriptVersion;
    }

    public void copy(Scripts from) {
        this.defaultJScript = from.defaultJScript;
        this.jScriptVersion = from.jScriptVersion;
    }
}





