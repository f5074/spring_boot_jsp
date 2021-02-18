package com.tistory.f5074.spring_boot_jsp.common.utils;

import com.tistory.f5074.spring_boot_jsp.domain.FileVO;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class CommonUils {

    /**
     * 파일업로드용 Method
     * @param dir
     * @param uploadFile
     * @throws IOException
     */
    public static void fileUpload(String dir, MultipartFile uploadFile ) throws IOException {
        // 폴더가 없을경우 폴더 생성
        File file = new File(dir);
        if(!file.exists()) {
            file.mkdirs();
        }
        System.out.println("Start");
        // 파일 해당 경로에 업로드
        FileOutputStream fos = new FileOutputStream(dir + uploadFile.getOriginalFilename());
        InputStream is = uploadFile.getInputStream();
        try {
            int readCount = 0;
            byte[] buffer = new byte[1024];
            while ((readCount = is.read(buffer)) != -1) {
                fos.write(buffer, 0, readCount);
            }
        } catch (Exception ex) {
            throw new RuntimeException("[File Upload]" + ex.getMessage());
        } finally {
            System.out.println("End");
            fos.close();
            is.close();
        }
    }

    /**
     * 파일 탐색기 subDirList
     * @param fileDir
     * @return
     * @throws IOException
     */
    public static List<FileVO> subDirList(String fileDir, List<FileVO> result) throws IOException {
//        // https://ra2kstar.tistory.com/133
//        File dir = new File(fileDir);
//        File files[] = dir.listFiles();
//        for (int fileIdx = 0; fileIdx < files.length; fileIdx++){
//            FileVO vo = new FileVO();
//            vo.setFileId(fileIdx);
//            vo.setFileNm(files[fileIdx].toString().replace("\\", "\\\\"));
//            result.add(vo);
//        }

        // https://ra2kstar.tistory.com/133
        File dir = new File(fileDir);
        File[] fileList = dir.listFiles();
        for (int rowIdx = 0; rowIdx < fileList.length; rowIdx++) {
            File file = fileList[rowIdx];
            if (file.isFile()) {
                FileVO vo = new FileVO();
                vo.setFileId(rowIdx);
                vo.setFileNm(file.toString().replace("\\", "\\\\"));
                result.add(vo);
            } else if (file.isDirectory()) {
				subDirList(file.getCanonicalPath().toString(), result);
            }
        }
        return result;
    }

    public String getFileName(){

        return "";
    }

}
