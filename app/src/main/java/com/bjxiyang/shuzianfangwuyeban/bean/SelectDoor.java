package com.bjxiyang.shuzianfangwuyeban.bean;

import java.util.List;

/**
 * Created by gll on 2017/11/14.
 */

public class SelectDoor {
    /**
     * code : 0
     * msg : 成功
     * obj : {"pageNum":1,"pageSize":10,"size":1,"startRow":1,"endRow":1,"total":1,"pages":1,"list":[{"doorid":953,"doorname":"18","unitid":122,"floorid":56,"nperid":31,"communityid":19,"communitycount":null,"foundtime":null,"creater":null,"doorspace":null,"propertyid":8,"community":{"communityid":null,"communityname":"测试小区","city":null,"foundtime":null,"creater":null,"nperid":null,"floorid":null,"unitid":null,"doorid":null,"propertyid":null,"province":null,"area":null,"lng":null,"lat":null,"poarea":null,"property":null},"nper":{"nperid":null,"npername":"十期","communityid":null,"communitycount":null,"foundtime":null,"creater":null,"propertyid":null,"community":null},"floor":{"floorid":null,"floorname":"六栋","nperid":null,"communityid":null,"foundtime":null,"creater":null,"propertyid":null,"nper":null,"community":null},"unit":{"unitid":122,"unitname":"六单元","floorid":null,"nperid":null,"communityid":null,"status":null,"foundtime":null,"creater":null,"propertyid":null,"community":null,"nper":null,"floor":null}}],"firstPage":1,"prePage":0,"nextPage":0,"lastPage":1,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1]}
     * type : null
     */

    private int code;
    private String msg;
    private ObjBean obj;
    private Object type;

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

    public ObjBean getObj() {
        return obj;
    }

    public void setObj(ObjBean obj) {
        this.obj = obj;
    }

    public Object getType() {
        return type;
    }

    public void setType(Object type) {
        this.type = type;
    }

    public static class ObjBean {
        /**
         * pageNum : 1
         * pageSize : 10
         * size : 1
         * startRow : 1
         * endRow : 1
         * total : 1
         * pages : 1
         * list : [{"doorid":953,"doorname":"18","unitid":122,"floorid":56,"nperid":31,"communityid":19,"communitycount":null,"foundtime":null,"creater":null,"doorspace":null,"propertyid":8,"community":{"communityid":null,"communityname":"测试小区","city":null,"foundtime":null,"creater":null,"nperid":null,"floorid":null,"unitid":null,"doorid":null,"propertyid":null,"province":null,"area":null,"lng":null,"lat":null,"poarea":null,"property":null},"nper":{"nperid":null,"npername":"十期","communityid":null,"communitycount":null,"foundtime":null,"creater":null,"propertyid":null,"community":null},"floor":{"floorid":null,"floorname":"六栋","nperid":null,"communityid":null,"foundtime":null,"creater":null,"propertyid":null,"nper":null,"community":null},"unit":{"unitid":122,"unitname":"六单元","floorid":null,"nperid":null,"communityid":null,"status":null,"foundtime":null,"creater":null,"propertyid":null,"community":null,"nper":null,"floor":null}}]
         * firstPage : 1
         * prePage : 0
         * nextPage : 0
         * lastPage : 1
         * isFirstPage : true
         * isLastPage : true
         * hasPreviousPage : false
         * hasNextPage : false
         * navigatePages : 8
         * navigatepageNums : [1]
         */

        private int pageNum;
        private int pageSize;
        private int size;
        private int startRow;
        private int endRow;
        private int total;
        private int pages;
        private int firstPage;
        private int prePage;
        private int nextPage;
        private int lastPage;
        private boolean isFirstPage;
        private boolean isLastPage;
        private boolean hasPreviousPage;
        private boolean hasNextPage;
        private int navigatePages;
        private List<ListBean> list;
        private List<Integer> navigatepageNums;

        public int getPageNum() {
            return pageNum;
        }

        public void setPageNum(int pageNum) {
            this.pageNum = pageNum;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getStartRow() {
            return startRow;
        }

        public void setStartRow(int startRow) {
            this.startRow = startRow;
        }

        public int getEndRow() {
            return endRow;
        }

        public void setEndRow(int endRow) {
            this.endRow = endRow;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getPages() {
            return pages;
        }

        public void setPages(int pages) {
            this.pages = pages;
        }

        public int getFirstPage() {
            return firstPage;
        }

        public void setFirstPage(int firstPage) {
            this.firstPage = firstPage;
        }

        public int getPrePage() {
            return prePage;
        }

        public void setPrePage(int prePage) {
            this.prePage = prePage;
        }

        public int getNextPage() {
            return nextPage;
        }

        public void setNextPage(int nextPage) {
            this.nextPage = nextPage;
        }

        public int getLastPage() {
            return lastPage;
        }

        public void setLastPage(int lastPage) {
            this.lastPage = lastPage;
        }

        public boolean isIsFirstPage() {
            return isFirstPage;
        }

        public void setIsFirstPage(boolean isFirstPage) {
            this.isFirstPage = isFirstPage;
        }

        public boolean isIsLastPage() {
            return isLastPage;
        }

        public void setIsLastPage(boolean isLastPage) {
            this.isLastPage = isLastPage;
        }

        public boolean isHasPreviousPage() {
            return hasPreviousPage;
        }

        public void setHasPreviousPage(boolean hasPreviousPage) {
            this.hasPreviousPage = hasPreviousPage;
        }

        public boolean isHasNextPage() {
            return hasNextPage;
        }

        public void setHasNextPage(boolean hasNextPage) {
            this.hasNextPage = hasNextPage;
        }

        public int getNavigatePages() {
            return navigatePages;
        }

        public void setNavigatePages(int navigatePages) {
            this.navigatePages = navigatePages;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public List<Integer> getNavigatepageNums() {
            return navigatepageNums;
        }

        public void setNavigatepageNums(List<Integer> navigatepageNums) {
            this.navigatepageNums = navigatepageNums;
        }

        public static class ListBean {
            /**
             * doorid : 953
             * doorname : 18
             * unitid : 122
             * floorid : 56
             * nperid : 31
             * communityid : 19
             * communitycount : null
             * foundtime : null
             * creater : null
             * doorspace : null
             * propertyid : 8
             * community : {"communityid":null,"communityname":"测试小区","city":null,"foundtime":null,"creater":null,"nperid":null,"floorid":null,"unitid":null,"doorid":null,"propertyid":null,"province":null,"area":null,"lng":null,"lat":null,"poarea":null,"property":null}
             * nper : {"nperid":null,"npername":"十期","communityid":null,"communitycount":null,"foundtime":null,"creater":null,"propertyid":null,"community":null}
             * floor : {"floorid":null,"floorname":"六栋","nperid":null,"communityid":null,"foundtime":null,"creater":null,"propertyid":null,"nper":null,"community":null}
             * unit : {"unitid":122,"unitname":"六单元","floorid":null,"nperid":null,"communityid":null,"status":null,"foundtime":null,"creater":null,"propertyid":null,"community":null,"nper":null,"floor":null}
             */

            private int doorid;
            private String doorname;
            private int unitid;
            private int floorid;
            private int nperid;
            private int communityid;
            private Object communitycount;
            private Object foundtime;
            private Object creater;
            private Object doorspace;
            private int propertyid;
            private CommunityBean community;
            private NperBean nper;
            private FloorBean floor;
            private UnitBean unit;

            public int getDoorid() {
                return doorid;
            }

            public void setDoorid(int doorid) {
                this.doorid = doorid;
            }

            public String getDoorname() {
                return doorname;
            }

            public void setDoorname(String doorname) {
                this.doorname = doorname;
            }

            public int getUnitid() {
                return unitid;
            }

            public void setUnitid(int unitid) {
                this.unitid = unitid;
            }

            public int getFloorid() {
                return floorid;
            }

            public void setFloorid(int floorid) {
                this.floorid = floorid;
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

            public Object getDoorspace() {
                return doorspace;
            }

            public void setDoorspace(Object doorspace) {
                this.doorspace = doorspace;
            }

            public int getPropertyid() {
                return propertyid;
            }

            public void setPropertyid(int propertyid) {
                this.propertyid = propertyid;
            }

            public CommunityBean getCommunity() {
                return community;
            }

            public void setCommunity(CommunityBean community) {
                this.community = community;
            }

            public NperBean getNper() {
                return nper;
            }

            public void setNper(NperBean nper) {
                this.nper = nper;
            }

            public FloorBean getFloor() {
                return floor;
            }

            public void setFloor(FloorBean floor) {
                this.floor = floor;
            }

            public UnitBean getUnit() {
                return unit;
            }

            public void setUnit(UnitBean unit) {
                this.unit = unit;
            }

            public static class CommunityBean {
                /**
                 * communityid : null
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

                private Object communityid;
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

                public Object getCommunityid() {
                    return communityid;
                }

                public void setCommunityid(Object communityid) {
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

            public static class NperBean {
                /**
                 * nperid : null
                 * npername : 十期
                 * communityid : null
                 * communitycount : null
                 * foundtime : null
                 * creater : null
                 * propertyid : null
                 * community : null
                 */

                private Object nperid;
                private String npername;
                private Object communityid;
                private Object communitycount;
                private Object foundtime;
                private Object creater;
                private Object propertyid;
                private Object community;

                public Object getNperid() {
                    return nperid;
                }

                public void setNperid(Object nperid) {
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

            public static class FloorBean {
                /**
                 * floorid : null
                 * floorname : 六栋
                 * nperid : null
                 * communityid : null
                 * foundtime : null
                 * creater : null
                 * propertyid : null
                 * nper : null
                 * community : null
                 */

                private Object floorid;
                private String floorname;
                private Object nperid;
                private Object communityid;
                private Object foundtime;
                private Object creater;
                private Object propertyid;
                private Object nper;
                private Object community;

                public Object getFloorid() {
                    return floorid;
                }

                public void setFloorid(Object floorid) {
                    this.floorid = floorid;
                }

                public String getFloorname() {
                    return floorname;
                }

                public void setFloorname(String floorname) {
                    this.floorname = floorname;
                }

                public Object getNperid() {
                    return nperid;
                }

                public void setNperid(Object nperid) {
                    this.nperid = nperid;
                }

                public Object getCommunityid() {
                    return communityid;
                }

                public void setCommunityid(Object communityid) {
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

                public Object getPropertyid() {
                    return propertyid;
                }

                public void setPropertyid(Object propertyid) {
                    this.propertyid = propertyid;
                }

                public Object getNper() {
                    return nper;
                }

                public void setNper(Object nper) {
                    this.nper = nper;
                }

                public Object getCommunity() {
                    return community;
                }

                public void setCommunity(Object community) {
                    this.community = community;
                }
            }

            public static class UnitBean {
                /**
                 * unitid : 122
                 * unitname : 六单元
                 * floorid : null
                 * nperid : null
                 * communityid : null
                 * status : null
                 * foundtime : null
                 * creater : null
                 * propertyid : null
                 * community : null
                 * nper : null
                 * floor : null
                 */

                private int unitid;
                private String unitname;
                private Object floorid;
                private Object nperid;
                private Object communityid;
                private Object status;
                private Object foundtime;
                private Object creater;
                private Object propertyid;
                private Object community;
                private Object nper;
                private Object floor;

                public int getUnitid() {
                    return unitid;
                }

                public void setUnitid(int unitid) {
                    this.unitid = unitid;
                }

                public String getUnitname() {
                    return unitname;
                }

                public void setUnitname(String unitname) {
                    this.unitname = unitname;
                }

                public Object getFloorid() {
                    return floorid;
                }

                public void setFloorid(Object floorid) {
                    this.floorid = floorid;
                }

                public Object getNperid() {
                    return nperid;
                }

                public void setNperid(Object nperid) {
                    this.nperid = nperid;
                }

                public Object getCommunityid() {
                    return communityid;
                }

                public void setCommunityid(Object communityid) {
                    this.communityid = communityid;
                }

                public Object getStatus() {
                    return status;
                }

                public void setStatus(Object status) {
                    this.status = status;
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

                public Object getNper() {
                    return nper;
                }

                public void setNper(Object nper) {
                    this.nper = nper;
                }

                public Object getFloor() {
                    return floor;
                }

                public void setFloor(Object floor) {
                    this.floor = floor;
                }
            }
        }
    }
}
