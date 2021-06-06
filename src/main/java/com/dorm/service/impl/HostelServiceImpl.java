package com.dorm.service.impl;

import com.dorm.entity.Hostel;
import com.dorm.mapper.BedroomMapper;
import com.dorm.mapper.HostelMapper;
import com.dorm.mapper.StaffHostelMapper;
import com.dorm.service.HostelService;
import com.dorm.until.Result;
import com.dorm.until.TableUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HostelServiceImpl implements HostelService {
    @Autowired
    private HostelMapper hostelMapper;
    @Autowired
    private StaffHostelMapper staffHostelMapper;
    @Autowired
    private BedroomMapper bedroomMapper;
    /**
     * 展示数据
     */
    @Override
    public TableUtil list() {
         return new TableUtil(hostelMapper.count(),hostelMapper.list());
    }

    /**
     * 增加
     */
    @Override
    public Result add(Hostel hostel) {
        hostelMapper.add(hostel);
        int key = hostelMapper.getKey();
        //楼号 楼层 每层寝室数量 每间宿舍可住人数
        for(int i=1;i<=hostel.getFloor();i++){
            for(int j=1;j<=hostel.getNumber();j++){
                bedroomMapper.add(key,i*100+j,hostel.getPeople());
            }
        }
        return Result.ok();
    }

    /**
     * 删除数据
     *
     * @param ids
     */
    @Override
    public Result remove(String[] ids) {
        //删除宿舍楼信息
        hostelMapper.remove(ids);
        //删除宿舍楼与管理员的关系
        staffHostelMapper.removeByHostel(ids);
        //删除宿舍楼与寝室的关系
        bedroomMapper.removeByhostelIds(ids);
        return Result.ok();
    }

    /**
     * 根据staffId查找指定的数据
     *
     * @param hostelId
     */
    @Override
    public Hostel findByHostelId(int hostelId) {
        return hostelMapper.findByHostelId(hostelId);
    }

    /**
     * 修改信息
     *
     */
    @Override
    public Result edit(Hostel hostel) {
        Hostel byHostelId = hostelMapper.findByHostelId(hostel.getHostelId());
        //判断是否修改了宿舍的信息
        if((byHostelId.getPeople()!=hostel.getPeople())||//修改了每间宿舍可住人数
                (byHostelId.getFloor()!=hostel.getFloor())||//修改了楼层数
                (byHostelId.getNumber()!=hostel.getNumber())//修改了每层的房间数
        ){
            //删除
            bedroomMapper.removeByhostelId(hostel.getHostelId());
            //重新添加
            for(int i=1;i<=hostel.getFloor();i++){
                for(int j=1;j<=hostel.getNumber();j++){
                    bedroomMapper.add(hostel.getHostelId(),i*100+j,hostel.getPeople());
                }
            }
        }
        hostelMapper.edit(hostel);
        return Result.ok();
    }

    /**
     * 查询所含有的宿舍信息
     *
     */
    @Override
    public List<Hostel> info() {
        List<Hostel> info = hostelMapper.info();
        info.add(new Hostel(0,"全部",null,null,null,null,null,null));
        return info;
    }

    /**
     * 根据学院和性别查询宿舍信息
     *
     * @param collegeId 学院id
     * @param sex       性别
     * @param subjectId
     * @return
     */
    @Override
    public List<Hostel> infoHostel(Integer collegeId, Integer sex, Integer subjectId) {
        return hostelMapper.infoHostel(collegeId,sex,subjectId);
    }
}
