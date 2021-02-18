package com.tistory.f5074.spring_boot_jsp.controller.service;

import com.tistory.f5074.spring_boot_jsp.common.utils.CommonUils;
import com.tistory.f5074.spring_boot_jsp.domain.FileVO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class FileTransferController {

    /**
     * selectFileList
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping(value = { "selectFileList", "drawing/user/selectFileList" }, method = RequestMethod.POST)
    @ResponseBody
    public List<FileVO> selectFileList(HttpServletRequest request
            , HttpServletResponse response) throws IOException {
        String fileDir = "C:\\DEV\\Downloads\\";

        if (request.getParameter("fileDownloadDir") != null){
            fileDir = request.getParameter("fileDownloadDir");
        }
        else{
            if(fileDir.substring(fileDir.length()-1, fileDir.length()) == "/" || fileDir.substring(fileDir.length()-1, fileDir.length()) == "\\") {

            }else {
                fileDir += "\\";
            }
        }

        return CommonUils.subDirList(fileDir, new ArrayList<FileVO>());
    }

    /**
     * uploadFile
     * @param mtfRequest
     * @return
     * @throws IOException
     */
    @RequestMapping(value = { "uploadFile", "drawing/user/uploadFile" }, method = RequestMethod.POST)
    @ResponseBody
    public int uploadFile(MultipartHttpServletRequest mtfRequest) throws IOException{
        List<MultipartFile> fileList = mtfRequest.getFiles("file");

        String fileDir = "C:\\DEV\\Downloads\\";
//        String fileDir =  mtfRequest.getServletContext().getRealPath(propSavePathUpload);

        for (MultipartFile mf : fileList) {
            CommonUils.fileUpload(fileDir, mf);
        }
        return 1;
    }

    /**
     * beforeDownloadFiles
     * @param request
     * @param response
     * @param fullDir
     * @throws IOException
     */
    @RequestMapping(value = { "beforeDownloadFiles", "drawing/user/beforeDownloadFiles" }, method = RequestMethod.POST)
    @ResponseBody
    public void beforeDownloadFiles( HttpServletRequest request
            , HttpServletResponse response
            , @RequestParam("fileNm") String fullDir) throws IOException {
        System.out.println("beforeDownloadFiles");
//		String fileNm = request.getParameter("fileNm");
//        String fileDir = "C:\\DEV\\Downloads\\";
//        String FullDir = fileDir + fileNm;
        String[] fileNms = fullDir.split("\\\\");
        String fileNm = fileNms[fileNms.length-1];
        System.out.println(fullDir);
        String contentType = "image/png";
        long fileLength = 0;
        FileInputStream fis = new FileInputStream(fullDir);
        fileLength =  fis.getChannel().size();
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileNm + "\";");
        response.setHeader("Content-Transfer-Encoding", "binary");
        response.setHeader("Content-Type", contentType);
        response.setHeader("Content-Length", "" + fileLength);
        response.setHeader("Pragma", "no-cache;");
        response.setHeader("Expires", "-1;");
        OutputStream out = response.getOutputStream();
        try {
            int readCount = 0;
            byte[] buffer = new byte[1024];
            while ((readCount = fis.read(buffer)) != -1) {
                out.write(buffer, 0, readCount);
            }
        } catch (Exception ex) {
            throw new RuntimeException("[File Download]" + ex.getMessage());
        } finally {
            fis.close();
            out.close();
        }
    }

    /**
     * downloadFiles
     * @param request
     * @param response
     * @param fullDir
     * @throws IOException
     */
    @RequestMapping(value = { "downloadFiles", "drawing/user/downloadFiles" }, method = RequestMethod.GET)
    @ResponseBody
    public void downloadFiles( HttpServletRequest request
            , HttpServletResponse response
            , @RequestParam("fileNm") String fullDir) throws IOException {
        System.out.println("downloadFiles");
//        String fileDir = "C:\\DEV\\Downloads\\";
//
//        if(fileDir.substring(fileDir.length()-1, fileDir.length()) == "/" || fileDir.substring(fileDir.length()-1, fileDir.length()) == "\\") {
//
//        }else {
//            fileDir += "\\";
//        }

        String encodingFileNm = new String(fullDir.getBytes("UTF-8"), "8859_1");
        String[] fileNms = encodingFileNm.split("\\\\");
        String fileNm = fileNms[fileNms.length-1];
//        String FullDir = fileDir + fileNm;
        String contentType = "application/octet-stream";
        long fileLength = 0;
        FileInputStream fis = new FileInputStream(fullDir);
        fileLength =  fis.getChannel().size();
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileNm + "\";");
        response.setHeader("Content-Transfer-Encoding", "binary");
        response.setHeader("Content-Type", contentType);
        response.setHeader("Content-Length", "" + fileLength);
        response.setHeader("Pragma", "no-cache;");
        response.setHeader("Expires", "-1;");
        OutputStream out = response.getOutputStream();
        try {
            int readCount = 0;
            byte[] buffer = new byte[1024];
            while ((readCount = fis.read(buffer)) != -1) {
                out.write(buffer, 0, readCount);
            }
        } catch (Exception ex) {
            throw new RuntimeException("[File Download]" + ex.getMessage());
        } finally {
            fis.close();
            out.close();
        }
    }

    /**
     * downloadFile
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping(value = { "downloadFile", "drawing/user/downloadFile" }, method = RequestMethod.POST)
    @ResponseBody
    public List<HashMap<String,String>> downloadFile(HttpServletRequest request
            , HttpServletResponse response) throws IOException {
        List<HashMap<String, String>> resultList = new ArrayList<HashMap<String,String>>();

        String fileNm = request.getParameter("fileNm");
        String fileDir = "/spring/upload/downloads/";

        HashMap<String, String> map = new HashMap<String, String>();
        map.put("fileNm", fileNm);
        map.put("fullDir", fileDir + fileNm);
        resultList.add(map);
        System.out.println(resultList.size());
        return resultList;
    }
}
