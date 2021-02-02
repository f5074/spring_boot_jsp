package com.tistory.f5074.spring_boot_jsp.mapper;
import java.util.List;

import com.tistory.f5074.spring_boot_jsp.domain.DrawingVO;
import com.tistory.f5074.spring_boot_jsp.domain.EquipmentVO;
import com.tistory.f5074.spring_boot_jsp.domain.IconVO;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface DrawingMapper {
    List<DrawingVO> selectDrawingList(DrawingVO vo);
    int insertDrawing(DrawingVO vo);

    List<IconVO> selectIconList(IconVO vo);
    int insertIcon(IconVO vo);

    List<EquipmentVO> selectEquipmentList(EquipmentVO vo);
    int insertEquipment(EquipmentVO vo);
    int updateEquipment(EquipmentVO vo);
}
