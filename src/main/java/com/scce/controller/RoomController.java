package com.scce.controller;

import com.github.pagehelper.PageInfo;
import com.scce.pojo.Room;
import com.scce.service.RoomService;
import com.scce.utils.ExcelUtil;
import com.scce.utils.ResponseUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {
    @Autowired
    private RoomService roomService;

    //查询房间信息并分页
    @RequestMapping("/getRoom")
    public HashMap getRoom(int pageNum, int pageSize, HttpServletResponse response) throws Exception {
        System.out.println("执行查询房间信息的方法");
        PageInfo<Room> pageInfo = roomService.getRoom(pageNum, pageSize);
        System.out.println(pageInfo.getList());
        HashMap<String, Object> o = new HashMap<String, Object>();
        o.put("rows", pageInfo.getList());
        o.put("total", pageInfo.getTotal());
        return o;
    }
    @RequestMapping("/TestExcel")
    public String TestExcel(HttpServletResponse response) throws Exception {
        System.out.println("进入TestExcel");
        try {
            Workbook wb = new HSSFWorkbook();  //创建工作簿
            String headers[] = {"房间号", "价格", "房间类型", "押金", "客房状态"};
            List<Room> list = roomService.getAllRoom();
            ExcelUtil.fillExcelData(list, wb, headers);
            ResponseUtil.export(response, wb, "导出excel.xls");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}



