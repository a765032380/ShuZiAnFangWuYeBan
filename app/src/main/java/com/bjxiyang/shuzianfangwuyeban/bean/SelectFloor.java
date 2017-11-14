package com.bjxiyang.shuzianfangwuyeban.bean;

import java.util.List;

/**
 * Created by gll on 2017/11/14.
 */

public class SelectFloor {
    /**
     * code : 0
     * msg : 成功
     * obj : [{"floorid":56,"floorname":"六栋","nperid":31,"communityid":19,"foundtime":null,"creater":null,"propertyid":8,"nper":{"nperid":31,"npername":"十期","communityid":null,"communitycount":null,"foundtime":null,"creater":null,"propertyid":null,"community":null},"community":{"communityid":19,"communityname":"测试小区","city":null,"foundtime":null,"creater":null,"nperid":null,"floorid":null,"unitid":null,"doorid":null,"propertyid":null,"province":null,"area":null,"lng":null,"lat":null,"poarea":null,"property":null}},{"floorid":55,"floorname":"二栋","nperid":31,"communityid":19,"foundtime":null,"creater":null,"propertyid":8,"nper":{"nperid":31,"npername":"十期","communityid":null,"communitycount":null,"foundtime":null,"creater":null,"propertyid":null,"community":null},"community":{"communityid":19,"communityname":"测试小区","city":null,"foundtime":null,"creater":null,"nperid":null,"floorid":null,"unitid":null,"doorid":null,"propertyid":null,"province":null,"area":null,"lng":null,"lat":null,"poarea":null,"property":null}},{"floorid":54,"floorname":"一栋","nperid":31,"communityid":19,"foundtime":null,"creater":null,"propertyid":8,"nper":{"nperid":31,"npername":"十期","communityid":null,"communitycount":null,"foundtime":null,"creater":null,"propertyid":null,"community":null},"community":{"communityid":19,"communityname":"测试小区","city":null,"foundtime":null,"creater":null,"nperid":null,"floorid":null,"unitid":null,"doorid":null,"propertyid":null,"province":null,"area":null,"lng":null,"lat":null,"poarea":null,"property":null}}]
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
         * floorid : 56
         * floorname : 六栋
         * nperid : 31
         * communityid : 19
         * foundtime : null
         * creater : null
         * propertyid : 8
         * nper : {"nperid":31,"npername":"十期","communityid":null,"communitycount":null,"foundtime":null,"creater":null,"propertyid":null,"community":null}
         * community : {"communityid":19,"communityname":"测试小区","city":null,"foundtime":null,"creater":null,"nperid":null,"floorid":null,"unitid":null,"doorid":null,"propertyid":null,"province":null,"area":null,"lng":null,"lat":null,"poarea":null,"property":null}
         */

        private int floorid;
        private String floorname;
        private int nperid;
        private int communityid;
        private Object foundtime;
        private Object creater;
        private int propertyid;
        private NperBean nper;
        private CommunityBean community;

        public int getFloorid() {
            return floorid;
        }

        public void setFloorid(int floorid) {
            this.floorid = floorid;
        }

        public String getFloorname() {
            return floorname;
        }

        public void setFloorname(String floorname) {
            this.floorname = floorname;
        }

        public int getNperid() {
            return nperid;
        }

        public void setNperid(int nperid) {
            this.nperid = nperid;
        }

        public int getCommunityid() {
            return communityid;
        }

        public void setCommunityid(int communityid) {
            this.communityid = communityid;
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

        public int getPropertyid() {
            return propertyid;
        }

        public void setPropertyid(int propertyid) {
            this.propertyid = propertyid;
        }

        public NperBean getNper() {
            return nper;
        }

        public void setNper(NperBean nper) {
            this.nper = nper;
        }

        public CommunityBean getCommunity() {
            return community;
        }

        public void setCommunity(CommunityBean community) {
            this.community = community;
        }

        public static class NperBean {
            /**
             * nperid : 31
             * npername : 十期
             * communityid : null
             * communitycount : null
             * foundtime : null
             * creater : null
             * propertyid : null
             * community : null
             */

            private int nperid;
            private String npername;
            private Object communityid;
            private Object communitycount;
            private Object foundtime;
            private Object creater;
            private Object propertyid;
            private Object community;

            public int getNperid() {
                return nperid;
            }

            public void setNperid(int nperid) {
                this.nperid = nperid;
            }

            public String getNpername() {
                return npername;
            }

            public void setNpername(String npername) {
                this.npername = npername;
            }

            public Object getCommunityid() {
                return communityid;
            }

            public void setCommunityid(Object communityid) {
                this.communityid = communityid;
            }

            public Object getCommunitycount() {
                return communitycount;
            }

            public void setCommunitycount(Object communitycount) {
                this.communitycount = communitycount;
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

            public Object getPropertyid() {
                return propertyid;
            }

            public void setPropertyid(Object propertyid) {
                this.propertyid = propertyid;
            }

            public Object getCommunity() {
                return community;
            }

            public void setCommunity(Object community) {
                this.community = community;
            }
        }

        public static class CommunityBean {
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
             * propertyid : null
             * province : null
             * area : null
             * lng : null
             * lat : null
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
            private Object propertyid;
            private Object province;
            private Object area;
            private Object lng;
            private Object lat;
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

            public Object getPropertyid() {
                return propertyid;
            }

            public void setPropertyid(Object propertyid) {
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

            public Object getLng() {
                return lng;
            }

            public void setLng(Object lng) {
                this.lng = lng;
            }

            public Object getLat() {
                return lat;
            }

            public void setLat(Object lat) {
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
}
