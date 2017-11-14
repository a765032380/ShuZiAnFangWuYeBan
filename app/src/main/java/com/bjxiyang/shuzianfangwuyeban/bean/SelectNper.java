package com.bjxiyang.shuzianfangwuyeban.bean;

import java.util.List;

/**
 * Created by gll on 2017/11/14.
 */

public class SelectNper {
    /**
     * code : 0
     * msg : 成功
     * obj : {"pageNum":1,"pageSize":10,"size":1,"startRow":1,"endRow":1,"total":1,"pages":1,"list":[{"nperid":31,"npername":"十期","communityid":19,"communitycount":null,"foundtime":null,"creater":null,"propertyid":8,"community":{"communityid":19,"communityname":"测试小区","city":null,"foundtime":null,"creater":null,"nperid":null,"floorid":null,"unitid":null,"doorid":null,"propertyid":null,"province":null,"area":null,"lng":null,"lat":null,"poarea":null,"property":null}}],"firstPage":1,"prePage":0,"nextPage":0,"lastPage":1,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1]}
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
         * list : [{"nperid":31,"npername":"十期","communityid":19,"communitycount":null,"foundtime":null,"creater":null,"propertyid":8,"community":{"communityid":19,"communityname":"测试小区","city":null,"foundtime":null,"creater":null,"nperid":null,"floorid":null,"unitid":null,"doorid":null,"propertyid":null,"province":null,"area":null,"lng":null,"lat":null,"poarea":null,"property":null}}]
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
             * nperid : 31
             * npername : 十期
             * communityid : 19
             * communitycount : null
             * foundtime : null
             * creater : null
             * propertyid : 8
             * community : {"communityid":19,"communityname":"测试小区","city":null,"foundtime":null,"creater":null,"nperid":null,"floorid":null,"unitid":null,"doorid":null,"propertyid":null,"province":null,"area":null,"lng":null,"lat":null,"poarea":null,"property":null}
             */

            private int nperid;
            private String npername;
            private int communityid;
            private Object communitycount;
            private Object foundtime;
            private Object creater;
            private int propertyid;
            private CommunityBean community;

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
}
