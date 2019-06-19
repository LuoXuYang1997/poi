package com.scce.dao;
import com.scce.pojo.Room;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//客房管理
public interface RoomDao {
    //查询所有房间信息
    @Select("select * from room ")
    public List<Room> getRoom();
}
