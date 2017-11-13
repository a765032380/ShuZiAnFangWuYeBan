package com.bjxiyang.shuzianfangwuyeban.bean;

import java.util.List;

/**
 * Created by gll on 2017/11/13.
 */

public class Repairlist {

    /**
     * code : 0
     * msg : 成功
     * obj : {"pageNum":1,"pageSize":5,"size":5,"startRow":1,"endRow":5,"total":6,"pages":2,"list":[{"repair_id":17,"repair_no":"1508996091189","user_id":149,"property_id":3,"community_id":4,"nper_id":0,"floor_id":0,"unit_id":0,"door_id":0,"add_time":"2017-10-26 13:34:51","repair_status":51,"repair_time":"2017-11-03 12:46:22","repair_name":"","contact_way":"魏旺旺","repair_content":"试试","repair_result":"","mobilePhone":"13366164637","propertyName":"深圳卓越物业管理公司","communityName":"融科望京B座","nperName":null,"floorName":null,"unitName":null,"doorName":null,"pic_url":[{"pic_id":null,"repair_id":17,"pic_url":"1508996091127.png"}]},{"repair_id":10,"repair_no":"1508918425338","user_id":267,"property_id":3,"community_id":4,"nper_id":14,"floor_id":21,"unit_id":45,"door_id":56,"add_time":"2017-10-25 16:00:25","repair_status":1,"repair_time":"2017-11-13 16:09:43","repair_name":"","contact_way":"还没","repair_content":"各地","repair_result":"","mobilePhone":null,"propertyName":"深圳卓越物业管理公司","communityName":"融科望京B座","nperName":"一期","floorName":"B座","unitName":"一单元","doorName":"1003-1","pic_url":[{"pic_id":null,"repair_id":10,"pic_url":"1508918425323.jpg"}]},{"repair_id":9,"repair_no":"1508916894611","user_id":267,"property_id":3,"community_id":4,"nper_id":14,"floor_id":21,"unit_id":45,"door_id":56,"add_time":"2017-10-25 15:34:54","repair_status":0,"repair_time":"2017-11-03 13:08:05","repair_name":"","contact_way":"1646米","repair_content":"呵呵","repair_result":"","mobilePhone":null,"propertyName":"深圳卓越物业管理公司","communityName":"融科望京B座","nperName":"一期","floorName":"B座","unitName":"一单元","doorName":"1003-1","pic_url":[{"pic_id":null,"repair_id":9,"pic_url":"1508916889898.jpg"}]},{"repair_id":21,"repair_no":"1506589625909","user_id":268,"property_id":3,"community_id":4,"nper_id":14,"floor_id":21,"unit_id":45,"door_id":56,"add_time":"2017-09-28 17:07:06","repair_status":41,"repair_time":"2017-11-10 13:58:09","repair_name":"","contact_way":"18813045215","repair_content":"aaa","repair_result":"","mobilePhone":"18813045215","propertyName":"深圳卓越物业管理公司","communityName":"融科望京B座","nperName":"一期","floorName":"B座","unitName":"一单元","doorName":"1003-1","pic_url":[{"pic_id":null,"repair_id":21,"pic_url":null}]},{"repair_id":18,"repair_no":"1506589625909","user_id":268,"property_id":3,"community_id":4,"nper_id":14,"floor_id":21,"unit_id":45,"door_id":56,"add_time":"2017-09-28 17:07:06","repair_status":0,"repair_time":"2017-11-10 13:57:57","repair_name":"","contact_way":"18813045215","repair_content":"aaa","repair_result":"","mobilePhone":"18813045215","propertyName":"深圳卓越物业管理公司","communityName":"融科望京B座","nperName":"一期","floorName":"B座","unitName":"一单元","doorName":"1003-1","pic_url":[{"pic_id":null,"repair_id":18,"pic_url":null}]}],"firstPage":1,"prePage":0,"nextPage":2,"lastPage":2,"isFirstPage":true,"isLastPage":false,"hasPreviousPage":false,"hasNextPage":true,"navigatePages":8,"navigatepageNums":[1,2]}
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
         * pageSize : 5
         * size : 5
         * startRow : 1
         * endRow : 5
         * total : 6
         * pages : 2
         * list : [{"repair_id":17,"repair_no":"1508996091189","user_id":149,"property_id":3,"community_id":4,"nper_id":0,"floor_id":0,"unit_id":0,"door_id":0,"add_time":"2017-10-26 13:34:51","repair_status":51,"repair_time":"2017-11-03 12:46:22","repair_name":"","contact_way":"魏旺旺","repair_content":"试试","repair_result":"","mobilePhone":"13366164637","propertyName":"深圳卓越物业管理公司","communityName":"融科望京B座","nperName":null,"floorName":null,"unitName":null,"doorName":null,"pic_url":[{"pic_id":null,"repair_id":17,"pic_url":"1508996091127.png"}]},{"repair_id":10,"repair_no":"1508918425338","user_id":267,"property_id":3,"community_id":4,"nper_id":14,"floor_id":21,"unit_id":45,"door_id":56,"add_time":"2017-10-25 16:00:25","repair_status":1,"repair_time":"2017-11-13 16:09:43","repair_name":"","contact_way":"还没","repair_content":"各地","repair_result":"","mobilePhone":null,"propertyName":"深圳卓越物业管理公司","communityName":"融科望京B座","nperName":"一期","floorName":"B座","unitName":"一单元","doorName":"1003-1","pic_url":[{"pic_id":null,"repair_id":10,"pic_url":"1508918425323.jpg"}]},{"repair_id":9,"repair_no":"1508916894611","user_id":267,"property_id":3,"community_id":4,"nper_id":14,"floor_id":21,"unit_id":45,"door_id":56,"add_time":"2017-10-25 15:34:54","repair_status":0,"repair_time":"2017-11-03 13:08:05","repair_name":"","contact_way":"1646米","repair_content":"呵呵","repair_result":"","mobilePhone":null,"propertyName":"深圳卓越物业管理公司","communityName":"融科望京B座","nperName":"一期","floorName":"B座","unitName":"一单元","doorName":"1003-1","pic_url":[{"pic_id":null,"repair_id":9,"pic_url":"1508916889898.jpg"}]},{"repair_id":21,"repair_no":"1506589625909","user_id":268,"property_id":3,"community_id":4,"nper_id":14,"floor_id":21,"unit_id":45,"door_id":56,"add_time":"2017-09-28 17:07:06","repair_status":41,"repair_time":"2017-11-10 13:58:09","repair_name":"","contact_way":"18813045215","repair_content":"aaa","repair_result":"","mobilePhone":"18813045215","propertyName":"深圳卓越物业管理公司","communityName":"融科望京B座","nperName":"一期","floorName":"B座","unitName":"一单元","doorName":"1003-1","pic_url":[{"pic_id":null,"repair_id":21,"pic_url":null}]},{"repair_id":18,"repair_no":"1506589625909","user_id":268,"property_id":3,"community_id":4,"nper_id":14,"floor_id":21,"unit_id":45,"door_id":56,"add_time":"2017-09-28 17:07:06","repair_status":0,"repair_time":"2017-11-10 13:57:57","repair_name":"","contact_way":"18813045215","repair_content":"aaa","repair_result":"","mobilePhone":"18813045215","propertyName":"深圳卓越物业管理公司","communityName":"融科望京B座","nperName":"一期","floorName":"B座","unitName":"一单元","doorName":"1003-1","pic_url":[{"pic_id":null,"repair_id":18,"pic_url":null}]}]
         * firstPage : 1
         * prePage : 0
         * nextPage : 2
         * lastPage : 2
         * isFirstPage : true
         * isLastPage : false
         * hasPreviousPage : false
         * hasNextPage : true
         * navigatePages : 8
         * navigatepageNums : [1,2]
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
             * repair_id : 17
             * repair_no : 1508996091189
             * user_id : 149
             * property_id : 3
             * community_id : 4
             * nper_id : 0
             * floor_id : 0
             * unit_id : 0
             * door_id : 0
             * add_time : 2017-10-26 13:34:51
             * repair_status : 51
             * repair_time : 2017-11-03 12:46:22
             * repair_name :
             * contact_way : 魏旺旺
             * repair_content : 试试
             * repair_result :
             * mobilePhone : 13366164637
             * propertyName : 深圳卓越物业管理公司
             * communityName : 融科望京B座
             * nperName : null
             * floorName : null
             * unitName : null
             * doorName : null
             * pic_url : [{"pic_id":null,"repair_id":17,"pic_url":"1508996091127.png"}]
             */

            private int repair_id;
            private String repair_no;
            private int user_id;
            private int property_id;
            private int community_id;
            private int nper_id;
            private int floor_id;
            private int unit_id;
            private int door_id;
            private String add_time;
            private int repair_status;
            private String repair_time;
            private String repair_name;
            private String contact_way;
            private String repair_content;
            private String repair_result;
            private String mobilePhone;
            private String propertyName;
            private String communityName;
            private Object nperName;
            private Object floorName;
            private Object unitName;
            private Object doorName;
            private List<PicUrlBean> pic_url;

            public int getRepair_id() {
                return repair_id;
            }

            public void setRepair_id(int repair_id) {
                this.repair_id = repair_id;
            }

            public String getRepair_no() {
                return repair_no;
            }

            public void setRepair_no(String repair_no) {
                this.repair_no = repair_no;
            }

            public int getUser_id() {
                return user_id;
            }

            public void setUser_id(int user_id) {
                this.user_id = user_id;
            }

            public int getProperty_id() {
                return property_id;
            }

            public void setProperty_id(int property_id) {
                this.property_id = property_id;
            }

            public int getCommunity_id() {
                return community_id;
            }

            public void setCommunity_id(int community_id) {
                this.community_id = community_id;
            }

            public int getNper_id() {
                return nper_id;
            }

            public void setNper_id(int nper_id) {
                this.nper_id = nper_id;
            }

            public int getFloor_id() {
                return floor_id;
            }

            public void setFloor_id(int floor_id) {
                this.floor_id = floor_id;
            }

            public int getUnit_id() {
                return unit_id;
            }

            public void setUnit_id(int unit_id) {
                this.unit_id = unit_id;
            }

            public int getDoor_id() {
                return door_id;
            }

            public void setDoor_id(int door_id) {
                this.door_id = door_id;
            }

            public String getAdd_time() {
                return add_time;
            }

            public void setAdd_time(String add_time) {
                this.add_time = add_time;
            }

            public int getRepair_status() {
                return repair_status;
            }

            public void setRepair_status(int repair_status) {
                this.repair_status = repair_status;
            }

            public String getRepair_time() {
                return repair_time;
            }

            public void setRepair_time(String repair_time) {
                this.repair_time = repair_time;
            }

            public String getRepair_name() {
                return repair_name;
            }

            public void setRepair_name(String repair_name) {
                this.repair_name = repair_name;
            }

            public String getContact_way() {
                return contact_way;
            }

            public void setContact_way(String contact_way) {
                this.contact_way = contact_way;
            }

            public String getRepair_content() {
                return repair_content;
            }

            public void setRepair_content(String repair_content) {
                this.repair_content = repair_content;
            }

            public String getRepair_result() {
                return repair_result;
            }

            public void setRepair_result(String repair_result) {
                this.repair_result = repair_result;
            }

            public String getMobilePhone() {
                return mobilePhone;
            }

            public void setMobilePhone(String mobilePhone) {
                this.mobilePhone = mobilePhone;
            }

            public String getPropertyName() {
                return propertyName;
            }

            public void setPropertyName(String propertyName) {
                this.propertyName = propertyName;
            }

            public String getCommunityName() {
                return communityName;
            }

            public void setCommunityName(String communityName) {
                this.communityName = communityName;
            }

            public Object getNperName() {
                return nperName;
            }

            public void setNperName(Object nperName) {
                this.nperName = nperName;
            }

            public Object getFloorName() {
                return floorName;
            }

            public void setFloorName(Object floorName) {
                this.floorName = floorName;
            }

            public Object getUnitName() {
                return unitName;
            }

            public void setUnitName(Object unitName) {
                this.unitName = unitName;
            }

            public Object getDoorName() {
                return doorName;
            }

            public void setDoorName(Object doorName) {
                this.doorName = doorName;
            }

            public List<PicUrlBean> getPic_url() {
                return pic_url;
            }

            public void setPic_url(List<PicUrlBean> pic_url) {
                this.pic_url = pic_url;
            }

            public static class PicUrlBean {
                /**
                 * pic_id : null
                 * repair_id : 17
                 * pic_url : 1508996091127.png
                 */

                private Object pic_id;
                private int repair_id;
                private String pic_url;

                public Object getPic_id() {
                    return pic_id;
                }

                public void setPic_id(Object pic_id) {
                    this.pic_id = pic_id;
                }

                public int getRepair_id() {
                    return repair_id;
                }

                public void setRepair_id(int repair_id) {
                    this.repair_id = repair_id;
                }

                public String getPic_url() {
                    return pic_url;
                }

                public void setPic_url(String pic_url) {
                    this.pic_url = pic_url;
                }
            }
        }
    }
}
