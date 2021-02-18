package com.tistory.f5074.spring_boot_jsp.controller.service;

import com.tistory.f5074.spring_boot_jsp.common.utils.CommonUils;
import com.tistory.f5074.spring_boot_jsp.domain.DrawingVO;
import com.tistory.f5074.spring_boot_jsp.domain.EquipmentVO;
import com.tistory.f5074.spring_boot_jsp.domain.IconVO;
import com.tistory.f5074.spring_boot_jsp.mapper.DrawingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;


@Controller
public class DrawingController {

    @Value("/resources/upload/drawing/")
    private String propSavePath;
    @Value("/resources/upload/icon/")
    private String propSavePathIcon;
    @Value("/resources/upload/downloads/")
    private String propSavePathUpload;
    @Value("f5074")
    private String propUserId;

    @Autowired
    private DrawingMapper drawingMapper;

    @RequestMapping(value = { "selectDrawingList", "drawing/user/selectDrawingList" }, method = RequestMethod.POST)
    @ResponseBody
    public List<DrawingVO> selectDrawingList(DrawingVO vo) {
        return drawingMapper.selectDrawingList(vo);
    }

    @RequestMapping(value = { "selectIconList", "drawing/user/selectIconList" }, method = RequestMethod.POST)
    @ResponseBody
    public List<IconVO> selectIconList(IconVO vo) {
        return drawingMapper.selectIconList(vo);
    }

    @RequestMapping(value = { "selectEquipmentList", "drawing/user/selectEquipmentList" }, method = RequestMethod.POST)
    @ResponseBody
    public List<EquipmentVO> selectEquipmentList(EquipmentVO vo) {
        return drawingMapper.selectEquipmentList(vo);
    }


    @RequestMapping(value = { "insertDrawing", "drawing/user/insertDrawing" }, method = RequestMethod.POST, consumes = { "multipart/form-data" })
    @ResponseBody
    public int insertDrawing(HttpServletRequest request, DrawingVO vo , @RequestParam(value = "uploadFile") MultipartFile uploadFile) throws IOException {
//        String fileFullNm = uploadFile.getOriginalFilename();
        vo.setFileFullNm("test");
        vo.setCrtId(propUserId);
        vo.setChgId(propUserId);
        // 파일 경로에 파일 업로드
        String dir = request.getServletContext().getRealPath(propSavePath);
        CommonUils.fileUpload(dir, uploadFile);

        int res = drawingMapper.insertDrawing(vo);
        return res;
    }

    @RequestMapping(value = { "insertIcon", "drawing/user/insertIcon" }, method = RequestMethod.POST, consumes = { "multipart/form-data" })
    @ResponseBody
    public int insertIcon(HttpServletRequest request, IconVO vo , @RequestParam(value = "uploadFile") MultipartFile uploadFile) throws IOException{
        String iconFullNm = uploadFile.getOriginalFilename();
        vo.setIconFullNm(iconFullNm);
        vo.setCrtId(propUserId);
        vo.setChgId(propUserId);

        // 파일 경로에 파일 업로드
        String dir = request.getServletContext().getRealPath(propSavePathIcon);
        CommonUils.fileUpload(dir, uploadFile);

        int res = drawingMapper.insertIcon(vo);
        return res;
    }

    @RequestMapping(value = { "insertEquipment", "drawing/user/insertEquipment" }, method = RequestMethod.POST, consumes = { "multipart/form-data" })
    @ResponseBody
    public int insertEquipment(HttpServletRequest request, EquipmentVO vo) throws IOException{
        vo.setCrtId(propUserId);
        vo.setChgId(propUserId);
        int res = drawingMapper.insertEquipment(vo);
        return res;
    }

    @RequestMapping(value = { "updateEquipment", "drawing/user/updateEquipment" }, method = RequestMethod.POST )
    @ResponseBody
    public int updateEquipment(EquipmentVO vo) throws IOException{
        vo.setChgId(propUserId);
        int res = drawingMapper.updateEquipment(vo);
        return res;
    }

}
