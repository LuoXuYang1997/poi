package com.scce.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scce.dao.RoomDao;
import com.scce.pojo.Room;
import com.scce.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomDao roomDao;

    //查询房间信息并分页
    public PageInfo<Room> getRoom(int pageNum, int pageSize) throws Exception {
        PageInfo<Room> pageInfo = null;
        try {
            PageHelper.startPage(pageNum, pageSize);
            List<Room> list = roomDao.getRoom();
            pageInfo = new PageInfo<>(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pageInfo;
    }

    @Override
    public List<Room> getAllRoom() {
        List<Room> roomList = roomDao.getRoom();
        return roomList;
    }

}
