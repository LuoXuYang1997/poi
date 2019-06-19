package com.scce.service;

import com.github.pagehelper.PageInfo;
import com.scce.pojo.Room;

import java.util.List;

//客房管理
public interface RoomService {
    //查询房间信息并分页
    public PageInfo<Room> getRoom(int pageNum, int pageSize) throws Exception;

    //查询所有房间
    public List<Room> getAllRoom();
}
