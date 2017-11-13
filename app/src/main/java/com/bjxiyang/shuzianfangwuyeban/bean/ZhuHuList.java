package com.bjxiyang.shuzianfangwuyeban.bean;

import java.util.List;

/**
 * Created by gll on 2017/11/13.
 */

public class ZhuHuList {


    /**
     * code : 0
     * msg : 成功
     * obj : {"pageNum":1,"pageSize":5,"size":5,"startRow":1,"endRow":5,"total":1514,"pages":303,"list":[{"permissionId":139,"mobilePhone":null,"doorId":1,"unitId":1,"floorId":1,"nperId":1,"communityId":1,"customerName":"李尚生","customerTel":"13655419967","roleType":0,"idNumber":null,"ownerId":null,"owner_status":1,"property_status":null,"add_time":"2017-07-26 14:08:07.0","review_time":null,"review_name":null,"del_flag":null,"add_status":null,"doorName":null,"unitName":"一单元","floorName":null,"nperName":"","communityName":"","propertyId":6,"propertyName":"北京宏源物业有限公司","yzt_userid":null},{"permissionId":140,"mobilePhone":null,"doorId":26,"unitId":23,"floorId":7,"nperId":3,"communityId":2,"customerName":"李尚生","customerTel":"13655419967","roleType":0,"idNumber":null,"ownerId":null,"owner_status":1,"property_status":null,"add_time":"2017-07-26 14:12:52.0","review_time":null,"review_name":null,"del_flag":null,"add_status":null,"doorName":"101","unitName":"一单元","floorName":"一栋","nperName":"一期","communityName":"国风美唐","propertyId":6,"propertyName":"北京宏源物业有限公司","yzt_userid":null},{"permissionId":144,"mobilePhone":null,"doorId":26,"unitId":23,"floorId":7,"nperId":3,"communityId":2,"customerName":"王娇","customerTel":"18706451620","roleType":2,"idNumber":null,"ownerId":null,"owner_status":1,"property_status":null,"add_time":"2017-07-26 15:43:53.0","review_time":null,"review_name":null,"del_flag":null,"add_status":null,"doorName":"101","unitName":"一单元","floorName":"一栋","nperName":"一期","communityName":"国风美唐","propertyId":6,"propertyName":"北京宏源物业有限公司","yzt_userid":null},{"permissionId":145,"mobilePhone":null,"doorId":1,"unitId":1,"floorId":1,"nperId":1,"communityId":1,"customerName":"孟盈盈","customerTel":"17862874016","roleType":1,"idNumber":null,"ownerId":null,"owner_status":1,"property_status":null,"add_time":"2017-07-26 15:45:40.0","review_time":null,"review_name":null,"del_flag":null,"add_status":null,"doorName":null,"unitName":"一单元","floorName":null,"nperName":"","communityName":"","propertyId":6,"propertyName":"北京宏源物业有限公司","yzt_userid":null},{"permissionId":149,"mobilePhone":null,"doorId":2,"unitId":1,"floorId":1,"nperId":1,"communityId":1,"customerName":"磊磊","customerTel":"18813045215","roleType":2,"idNumber":null,"ownerId":null,"owner_status":1,"property_status":null,"add_time":"2017-07-26 19:23:19.0","review_time":null,"review_name":null,"del_flag":null,"add_status":null,"doorName":null,"unitName":"一单元","floorName":null,"nperName":"","communityName":"","propertyId":6,"propertyName":"北京宏源物业有限公司","yzt_userid":null}],"firstPage":1,"prePage":0,"nextPage":2,"lastPage":8,"isFirstPage":true,"isLastPage":false,"hasPreviousPage":false,"hasNextPage":true,"navigatePages":8,"navigatepageNums":[1,2,3,4,5,6,7,8]}
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
         * total : 1514
         * pages : 303
         * list : [{"permissionId":139,"mobilePhone":null,"doorId":1,"unitId":1,"floorId":1,"nperId":1,"communityId":1,"customerName":"李尚生","customerTel":"13655419967","roleType":0,"idNumber":null,"ownerId":null,"owner_status":1,"property_status":null,"add_time":"2017-07-26 14:08:07.0","review_time":null,"review_name":null,"del_flag":null,"add_status":null,"doorName":null,"unitName":"一单元","floorName":null,"nperName":"","communityName":"","propertyId":6,"propertyName":"北京宏源物业有限公司","yzt_userid":null},{"permissionId":140,"mobilePhone":null,"doorId":26,"unitId":23,"floorId":7,"nperId":3,"communityId":2,"customerName":"李尚生","customerTel":"13655419967","roleType":0,"idNumber":null,"ownerId":null,"owner_status":1,"property_status":null,"add_time":"2017-07-26 14:12:52.0","review_time":null,"review_name":null,"del_flag":null,"add_status":null,"doorName":"101","unitName":"一单元","floorName":"一栋","nperName":"一期","communityName":"国风美唐","propertyId":6,"propertyName":"北京宏源物业有限公司","yzt_userid":null},{"permissionId":144,"mobilePhone":null,"doorId":26,"unitId":23,"floorId":7,"nperId":3,"communityId":2,"customerName":"王娇","customerTel":"18706451620","roleType":2,"idNumber":null,"ownerId":null,"owner_status":1,"property_status":null,"add_time":"2017-07-26 15:43:53.0","review_time":null,"review_name":null,"del_flag":null,"add_status":null,"doorName":"101","unitName":"一单元","floorName":"一栋","nperName":"一期","communityName":"国风美唐","propertyId":6,"propertyName":"北京宏源物业有限公司","yzt_userid":null},{"permissionId":145,"mobilePhone":null,"doorId":1,"unitId":1,"floorId":1,"nperId":1,"communityId":1,"customerName":"孟盈盈","customerTel":"17862874016","roleType":1,"idNumber":null,"ownerId":null,"owner_status":1,"property_status":null,"add_time":"2017-07-26 15:45:40.0","review_time":null,"review_name":null,"del_flag":null,"add_status":null,"doorName":null,"unitName":"一单元","floorName":null,"nperName":"","communityName":"","propertyId":6,"propertyName":"北京宏源物业有限公司","yzt_userid":null},{"permissionId":149,"mobilePhone":null,"doorId":2,"unitId":1,"floorId":1,"nperId":1,"communityId":1,"customerName":"磊磊","customerTel":"18813045215","roleType":2,"idNumber":null,"ownerId":null,"owner_status":1,"property_status":null,"add_time":"2017-07-26 19:23:19.0","review_time":null,"review_name":null,"del_flag":null,"add_status":null,"doorName":null,"unitName":"一单元","floorName":null,"nperName":"","communityName":"","propertyId":6,"propertyName":"北京宏源物业有限公司","yzt_userid":null}]
         * firstPage : 1
         * prePage : 0
         * nextPage : 2
         * lastPage : 8
         * isFirstPage : true
         * isLastPage : false
         * hasPreviousPage : false
         * hasNextPage : true
         * navigatePages : 8
         * navigatepageNums : [1,2,3,4,5,6,7,8]
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
             * permissionId : 139
             * mobilePhone : null
             * doorId : 1
             * unitId : 1
             * floorId : 1
             * nperId : 1
             * communityId : 1
             * customerName : 李尚生
             * customerTel : 13655419967
             * roleType : 0
             * idNumber : null
             * ownerId : null
             * owner_status : 1
             * property_status : null
             * add_time : 2017-07-26 14:08:07.0
             * review_time : null
             * review_name : null
             * del_flag : null
             * add_status : null
             * doorName : null
             * unitName : 一单元
             * floorName : null
             * nperName :
             * communityName :
             * propertyId : 6
             * propertyName : 北京宏源物业有限公司
             * yzt_userid : null
             */

            private int permissionId;
            private Object mobilePhone;
            private int doorId;
            private int unitId;
            private int floorId;
            private int nperId;
            private int communityId;
            private String customerName;
            private String customerTel;
            private int roleType;
            private Object idNumber;
            private Object ownerId;
            private int owner_status;
            private Object property_status;
            private String add_time;
            private Object review_time;
            private Object review_name;
            private Object del_flag;
            private Object add_status;
            private Object doorName;
            private String unitName;
            private Object floorName;
            private String nperName;
            private String communityName;
            private int propertyId;
            private String propertyName;
            private Object yzt_userid;

            public int getPermissionId() {
                return permissionId;
            }

            public void setPermissionId(int permissionId) {
                this.permissionId = permissionId;
            }

            public Object getMobilePhone() {
                return mobilePhone;
            }

            public void setMobilePhone(Object mobilePhone) {
                this.mobilePhone = mobilePhone;
            }

            public int getDoorId() {
                return doorId;
            }

            public void setDoorId(int doorId) {
                this.doorId = doorId;
            }

            public int getUnitId() {
                return unitId;
            }

            public void setUnitId(int unitId) {
                this.unitId = unitId;
            }

            public int getFloorId() {
                return floorId;
            }

            public void setFloorId(int floorId) {
                this.floorId = floorId;
            }

            public int getNperId() {
                return nperId;
            }

            public void setNperId(int nperId) {
                this.nperId = nperId;
            }

            public int getCommunityId() {
                return communityId;
            }

            public void setCommunityId(int communityId) {
                this.communityId = communityId;
            }

            public String getCustomerName() {
                return customerName;
            }

            public void setCustomerName(String customerName) {
                this.customerName = customerName;
            }

            public String getCustomerTel() {
                return customerTel;
            }

            public void setCustomerTel(String customerTel) {
                this.customerTel = customerTel;
            }

            public int getRoleType() {
                return roleType;
            }

            public void setRoleType(int roleType) {
                this.roleType = roleType;
            }

            public Object getIdNumber() {
                return idNumber;
            }

            public void setIdNumber(Object idNumber) {
                this.idNumber = idNumber;
            }

            public Object getOwnerId() {
                return ownerId;
            }

            public void setOwnerId(Object ownerId) {
                this.ownerId = ownerId;
            }

            public int getOwner_status() {
                return owner_status;
            }

            public void setOwner_status(int owner_status) {
                this.owner_status = owner_status;
            }

            public Object getProperty_status() {
                return property_status;
            }

            public void setProperty_status(Object property_status) {
                this.property_status = property_status;
            }

            public String getAdd_time() {
                return add_time;
            }

            public void setAdd_time(String add_time) {
                this.add_time = add_time;
            }

            public Object getReview_time() {
                return review_time;
            }

            public void setReview_time(Object review_time) {
                this.review_time = review_time;
            }

            public Object getReview_name() {
                return review_name;
            }

            public void setReview_name(Object review_name) {
                this.review_name = review_name;
            }

            public Object getDel_flag() {
                return del_flag;
            }

            public void setDel_flag(Object del_flag) {
                this.del_flag = del_flag;
            }

            public Object getAdd_status() {
                return add_status;
            }

            public void setAdd_status(Object add_status) {
                this.add_status = add_status;
            }

            public Object getDoorName() {
                return doorName;
            }

            public void setDoorName(Object doorName) {
                this.doorName = doorName;
            }

            public String getUnitName() {
                return unitName;
            }

            public void setUnitName(String unitName) {
                this.unitName = unitName;
            }

            public Object getFloorName() {
                return floorName;
            }

            public void setFloorName(Object floorName) {
                this.floorName = floorName;
            }

            public String getNperName() {
                return nperName;
            }

            public void setNperName(String nperName) {
                this.nperName = nperName;
            }

            public String getCommunityName() {
                return communityName;
            }

            public void setCommunityName(String communityName) {
                this.communityName = communityName;
            }

            public int getPropertyId() {
                return propertyId;
            }

            public void setPropertyId(int propertyId) {
                this.propertyId = propertyId;
            }

            public String getPropertyName() {
                return propertyName;
            }

            public void setPropertyName(String propertyName) {
                this.propertyName = propertyName;
            }

            public Object getYzt_userid() {
                return yzt_userid;
            }

            public void setYzt_userid(Object yzt_userid) {
                this.yzt_userid = yzt_userid;
            }
        }
    }
}
