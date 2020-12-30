package kr.dogfoot.hwplib.object.fileheader;

/**
 * 파일 인식 정보를 나타내는 객체. HWP 파일내의 "FileHeader" stream에 저장된다.
 *
 * @author neolord
 */
public class FileHeader {
    /**
     * 파일 버전
     */
    private FileVersion version;
    /**
     * 압축 여부
     */
    private boolean compressed;
    /**
     * 암호 설정 여부
     */
    private boolean hasPassword;
    /**
     * 배포용 문서 여부
     */
    private boolean isDeploymentDocument;
    /**
     * 스크립트 저장 여부
     */
    private boolean saveScript;
    /**
     * DRM 보안 문서 여부
     */
    private boolean isDRMDocument;
    /**
     * XMLTemplate 스토리지 존재 여부
     */
    private boolean hasXMLTemplate;
    /**
     * 문서 이력 관리 존재 여부
     */
    private boolean hasDocumentHistory;
    /**
     * 전자 서명 정보 존재 여부
     */
    private boolean hasSignature;
    /**
     * 공인 인증서 암호화 여부
     */
    private boolean encryptPublicCertification;
    /**
     * 전자 서명 예비 저장 여부
     */
    private boolean savePrepareSignature;
    /**
     * 공인 인증서 DRM 보안 문서 여부
     */
    private boolean isPublicCertificationDRMDocument;
    /**
     * CCL 문서 여부
     */
    private boolean isCCLDocument;

    /**
     * 생성자
     */
    public FileHeader() {
        version = new FileVersion();
    }

    /**
     * HWP 파일의 signature를 반환한다. signature은 파일이 HWP파일인지 여부를 체크하는데 사용됨.
     *
     * @return HWP 파일의 signature
     */
    public static byte[] getFileSignature() {
        byte[] array = {0x48, 0x57, 0x50, 0x20, 0x44, 0x6f, 0x63, 0x75, 0x6d,
                0x65, 0x6e, 0x74, 0x20, 0x46, 0x69, 0x6c, 0x65, 0x00, 0x00,
                0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
                0x00, 0x00, 0x00};
        return array;
    }

    /**
     * 버전 정보 객체를 반환한다.
     *
     * @return 버전 정보 객체
     */
    public FileVersion getVersion() {
        return version;
    }

    /**
     * 압축 여부를 반환한다.
     *
     * @return 압축 여부
     */
    public boolean isCompressed() {
        return compressed;
    }

    /**
     * 압축 여부를 설정한다.
     *
     * @param compressed 압축 여부
     */
    public void setCompressed(boolean compressed) {
        this.compressed = compressed;
    }

    /**
     * 암호 설정 여부를 반환한다.
     *
     * @return 암호 설정 여부
     */
    public boolean hasPassword() {
        return hasPassword;
    }

    /**
     * 암호 설정 여부를 설정한다.
     *
     * @param hasPassword 암호 설정 여부
     */
    public void setHasPassword(boolean hasPassword) {
        this.hasPassword = hasPassword;
    }

    /**
     * 배포용 문서 여부를 반환한다.
     *
     * @return 배포용 문서 여부
     */
    public boolean isDeploymentDocument() {
        return isDeploymentDocument;
    }

    /**
     * 배포용 문서 여부를 설정한다.
     *
     * @param isDeploymentDocument 배포용 문서 여부
     */
    public void setDeploymentDocument(boolean isDeploymentDocument) {
        this.isDeploymentDocument = isDeploymentDocument;
    }

    /**
     * 스크립트 저장 여부를 반환한다.
     *
     * @return 스크립트 저장 여부
     */
    public boolean isSaveScript() {
        return saveScript;
    }

    /**
     * 스크립트 저장 여부를 설정한다.
     *
     * @param saveScript 스크립트 저장 여부
     */
    public void setSaveScript(boolean saveScript) {
        this.saveScript = saveScript;
    }

    /**
     * DRM 보안 문서 여부를 반환한다.
     *
     * @return DRM 보안 문서 여부
     */
    public boolean isDRMDocument() {
        return isDRMDocument;
    }

    /**
     * DRM 보안 문서 여부를 설정한다.
     *
     * @param isDRMDocument DRM 보안 문서 여부
     */
    public void setDRMDocument(boolean isDRMDocument) {
        this.isDRMDocument = isDRMDocument;
    }

    /**
     * XMLTemplate 스토리지 존재 여부를 반환한다.
     *
     * @return XMLTemplate 스토리지 존재 여부
     */
    public boolean hasXMLTemplate() {
        return hasXMLTemplate;
    }

    /**
     * XMLTemplate 스토리지 존재 여부를 설정한다.
     *
     * @param hasXMLTemplate XMLTemplate 스토리지 존재 여부
     */
    public void setHasXMLTemplate(boolean hasXMLTemplate) {
        this.hasXMLTemplate = hasXMLTemplate;
    }

    /**
     * 문서 이력 관리 존재 여부를 반환한다.
     *
     * @return 문서 이력 관리 존재 여부
     */
    public boolean hasDocumentHistory() {
        return hasDocumentHistory;
    }

    /**
     * 문서 이력 관리 존재 여부를 설정한다.
     *
     * @param hasDocumentHistory 문서 이력 관리 존재 여부
     */
    public void setHasDocumentHistory(boolean hasDocumentHistory) {
        this.hasDocumentHistory = hasDocumentHistory;
    }

    /**
     * 전자 서명 정보 존재 여부를 반환한다.
     *
     * @return 전자 서명 정보 존재 여부
     */
    public boolean hasSignature() {
        return hasSignature;
    }

    /**
     * 전자 서명 정보 존재 여부를 설정한다.
     *
     * @param hasSignature 전자 서명 정보 존재 여부
     */
    public void setHasSignature(boolean hasSignature) {
        this.hasSignature = hasSignature;
    }

    /**
     * 공인 인증서 암호화 여부를 반환한다.
     *
     * @return 공인 인증서 암호화 여부
     */
    public boolean isEncryptPublicCertification() {
        return encryptPublicCertification;
    }

    /**
     * 공인 인증서 암호화 여부를 설정한다.
     *
     * @param encryptPublicCertification 공인 인증서 암호화 여부
     */
    public void setEncryptPublicCertification(boolean encryptPublicCertification) {
        this.encryptPublicCertification = encryptPublicCertification;
    }

    /**
     * 전자 서명 예비 저장 여부를 반환한다.
     *
     * @return 전자 서명 예비 저장 여부
     */
    public boolean isSavePrepareSignature() {
        return savePrepareSignature;
    }

    /**
     * 전자 서명 예비 저장 여부를 설정한다.
     *
     * @param savePrepareSignature 전자 서명 예비 저장 여부
     */
    public void setSavePrepareSignature(boolean savePrepareSignature) {
        this.savePrepareSignature = savePrepareSignature;
    }

    /**
     * 공인 인증서 DRM 보안 문서 여부를 반환한다.
     *
     * @return 공인 인증서 DRM 보안 문서 여부
     */
    public boolean isPublicCertificationDRMDocument() {
        return isPublicCertificationDRMDocument;
    }

    /**
     * 공인 인증서 DRM 보안 문서 여부를 설정한다.
     *
     * @param isPublicCertificationDRMDocument 공인 인증서 DRM 보안 문서 여부
     */
    public void setPublicCertificationDRMDocument(
            boolean isPublicCertificationDRMDocument) {
        this.isPublicCertificationDRMDocument = isPublicCertificationDRMDocument;
    }

    /**
     * CCL 문서 여부를 반환한다.
     *
     * @return CCL 문서 여부
     */
    public boolean isCCLDocument() {
        return isCCLDocument;
    }

    /**
     * CCL 문서 여부를 설정한다.
     *
     * @param isCCLDocument CCL 문서 여부
     */
    public void setCCLDocument(boolean isCCLDocument) {
        this.isCCLDocument = isCCLDocument;
    }

    public void copy(FileHeader from) {
        version.copy(from.version);
        compressed = from.compressed;
        hasPassword = from.hasPassword;
        isDeploymentDocument = from.isDeploymentDocument;
        saveScript = from.saveScript;
        isDRMDocument = from.isDRMDocument;
        hasXMLTemplate = from.hasXMLTemplate;
        hasDocumentHistory = from.hasDocumentHistory;
        hasSignature = from.hasSignature;
        encryptPublicCertification = from.encryptPublicCertification;
        savePrepareSignature = from.savePrepareSignature;
        isPublicCertificationDRMDocument = from.isPublicCertificationDRMDocument;
        isCCLDocument = from.isCCLDocument;
    }
}
