package com.bjxiyang.shuzianfangwuyeban.api;

/**
 * Created by gll on 2017/11/13.
 */

public class URL {


    private final static String URL="http://192.168.1.123:8080/appproperty/";




    //查询公告列表
    public final static String PROPERTYFUNCTIONS_NOTICE_SELECT=URL+"propertyFunctions/notice/select?";
    //登陆的请求地址
    public final static String LOGIN=URL+"appLogin/admin/login?";
    //物业保修列表
    public final static String REPAIRLIST=URL+"propertyFunctions/repair/repairlist?";
    //投诉建议列表
    public final static String COMPLAINT_SELECT=URL+"propertyFunctions/complaint/select?";
    //未支付物业费订单列表
    public final static String ORDER_NEW_SELECR=URL+"propertyFunctions/order/newselect?";
    //已支付物业费订单列表
    public final static String ORDER_OLD_SELECR=URL+"propertyFunctions/order/oldselect?";
    //图片上传
    public final static String FILEUPLOAD=URL+"propertyMessage/property/fileUpload?";
    //修改个人资料
    public final static String PERSONEDIT=URL+"propertyMessage/property/personEdit?";
    //住户信息列表
    public final static String OWNER_SELECT=URL+"baseMessage/permissions/select?";
    //编辑维修状态
    public final static String REPAIRUPDATE=URL+"propertyFunctions/repair/repairupdate?";
    //添加小区公告
    public final static String ADDNOTICE=URL+"propertyFunctions/notice/addNotice?";
    //根据物业ID查询小区
    public final static String FINDCOMMUNTITY=URL+"baseMessage/communities/findCommunityByProperId?";
    //根据物业ID查询期数
    public final static String SELEVCT_NPER=URL+"baseMessage/nper/selectByCommunityId?";
    //根据物业ID查询楼号
    public final static String SELEVCT_FOOLR=URL+"baseMessage/floor/selectByNperId?";
    //根据物业ID查询单元
    public final static String SELEVCT_UNIT=URL+"baseMessage/unit/selectByFloorId?";
    //根据物业ID查询门号
    public final static String SELEVCT_DOOR=URL+"baseMessage/door/selectByUnitId?";
    //待办事项查询
    public final static String SELEVCT_BACKLOG=URL+"propertyFunctions/backlog/select?";
    //根据房间添加物业费
    public final static String ADDORDER_ORDER=URL+"propertyFunctions/order/addOrder?";

}
