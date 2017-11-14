package com.bjxiyang.shuzianfangwuyeban.bean;

import java.util.List;

/**
 * Created by gll on 2017/11/14.
 */

public class FindCommunity {
    /**
     * code : 0
     * msg : 成功
     * obj : [{"communityid":19,"communityname":"测试小区","city":null,"foundtime":null,"creater":null,"nperid":null,"floorid":null,"unitid":null,"doorid":null,"propertyid":8,"province":null,"area":null,"lng":0,"lat":0,"poarea":null,"property":null},{"communityid":18,"communityname":"测试小区","city":null,"foundtime":null,"creater":null,"nperid":null,"floorid":null,"unitid":null,"doorid":null,"propertyid":2,"province":null,"area":null,"lng":0,"lat":0,"poarea":null,"property":null},{"communityid":17,"communityname":"测试","city":null,"foundtime":null,"creater":null,"nperid":null,"floorid":null,"unitid":null,"doorid":null,"propertyid":0,"province":null,"area":"110105","lng":1,"lat":1,"poarea":null,"property":null},{"communityid":8,"communityname":"精英家园","city":null,"foundtime":1505267564000,"creater":"litao","nperid":null,"floorid":null,"unitid":null,"doorid":null,"propertyid":7,"province":null,"area":null,"lng":0,"lat":0,"poarea":null,"property":null},{"communityid":6,"communityname":"宏源公寓","city":"北京市","foundtime":1502959268000,"creater":"lishangsheng","nperid":null,"floorid":null,"unitid":null,"doorid":null,"propertyid":6,"province":"北京","area":"朝阳区","lng":0,"lat":0,"poarea":null,"property":null},{"communityid":4,"communityname":"融科望京B座","city":"北京市","foundtime":1501117574000,"creater":"admin","nperid":null,"floorid":null,"unitid":null,"doorid":null,"propertyid":4,"province":"北京","area":"朝阳区","lng":0,"lat":0,"poarea":null,"property":null},{"communityid":2,"communityname":"国风美唐","city":null,"foundtime":1501048501000,"creater":"admin","nperid":null,"floorid":null,"unitid":null,"doorid":null,"propertyid":1,"province":null,"area":null,"lng":0,"lat":0,"poarea":null,"property":null}]
     * type : null
     */

    private int code;
    private String msg;
    private Object type;
    private List<ObjBean> obj;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getType() {
        return type;
    }

    public void setType(Object type) {
        this.type = type;
    }

    public List<ObjBean> getObj() {
        return obj;
    }

    public void setObj(List<ObjBean> obj) {
        this.obj = obj;
    }

    public static class ObjBean {
        /**
         * communityid : 19
         * communityname : 测试小区
         * city : null
         * foundtime : null
         * creater : null
         * nperid : null
         * floorid : null
         * unitid : null
         * doorid : null
         * propertyid : 8
         * province : null
         * area : null
         * lng : 0.0
         * lat : 0.0
         * poarea : null
         * property : null
         */

        private int communityid;
        private String communityname;
        private Object city;
        private Object foundtime;
        private Object creater;
        private Object nperid;
        private Object floorid;
        private Object unitid;
        private Object doorid;
        private int propertyid;
        private Object province;
        private Object area;
        private double lng;
        private double lat;
        private Object poarea;
        private Object property;

        public int getCommunityid() {
            return communityid;
        }

        public void setCommunityid(int communityid) {
            this.communityid = communityid;
        }

        public String getCommunityname() {
            return communityname;
        }

        public void setCommunityname(String communityname) {
            this.communityname = communityname;
        }

        public Object getCity() {
            return city;
        }

        public void setCity(Object city) {
            this.city = city;
        }

        public Object getFoundtime() {
            return foundtime;
        }

        public void setFoundtime(Object foundtime) {
            this.foundtime = foundtime;
        }

        public Object getCreater() {
            return creater;
        }

        public void setCreater(Object creater) {
            this.creater = creater;
        }

        public Object getNperid() {
            return nperid;
        }

        public void setNperid(Object nperid) {
            this.nperid = nperid;
        }

        public Object getFloorid() {
            return floorid;
        }

        public void setFloorid(Object floorid) {
            this.floorid = floorid;
        }

        public Object getUnitid() {
            return unitid;
        }

        public void setUnitid(Object unitid) {
            this.unitid = unitid;
        }

        public Object getDoorid() {
            return doorid;
        }

        public void setDoorid(Object doorid) {
            this.doorid = doorid;
        }

        public int getPropertyid() {
            return propertyid;
        }

        public void setPropertyid(int propertyid) {
            this.propertyid = propertyid;
        }

        public Object getProvince() {
            return province;
        }

        public void setProvince(Object province) {
            this.province = province;
        }

        public Object getArea() {
            return area;
        }

        public void setArea(Object area) {
            this.area = area;
        }

        public double getLng() {
            return lng;
        }

        public void setLng(double lng) {
            this.lng = lng;
        }

        public double getLat() {
            return lat;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }

        public Object getPoarea() {
            return poarea;
        }

        public void setPoarea(Object poarea) {
            this.poarea = poarea;
        }

        public Object getProperty() {
            return property;
        }

        public void setProperty(Object property) {
            this.property = property;
        }
    }


}
