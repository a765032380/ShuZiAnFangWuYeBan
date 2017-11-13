package com.bjxiyang.shuzianfangwuyeban.api;

/**
 * Created by gll on 2017/11/13.
 */

public class URL {


    private final static String URL="http://192.168.1.123:8080/appproperty/";




    public final static String FINDCOMMUNITY_BYPROPERID=URL+"baseMessage/communities/findCommunityByProperId?";

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

}
