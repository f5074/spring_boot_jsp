package com.tistory.f5074.spring_boot_jsp.domain;

public class FileVO {
    private Integer fileId;
    private String fileNm;

    public Integer getFileId() {
        return fileId;
    }
    public String getFileNm() {
        return fileNm;
    }
    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }
    public void setFileNm(String fileNm) {
        this.fileNm = fileNm;
    }
}
