package com.bjxiyang.shuzianfangwuyeban.bean;

import java.util.List;

/**
 * Created by gll on 2017/11/13.
 */

public class OrderSelect {

    /**
     * code : 0
     * msg : 成功
     * obj : {"pageNum":1,"pageSize":5,"size":5,"startRow":1,"endRow":5,"total":13,"pages":3,"list":[{"orderId":1,"orderNum":"52255555674565","orderTime":"2017-06-30 16:26:25","rentMoney":1,"note":"大随风倒","payState":1,"payWay":0,"payTime":1509353795000,"transaction_id":null,"owner_id":null,"mobilePhone":"18813045215","propertyId":1,"communityId":2,"nperId":2,"floorId":7,"unitId":17,"doorId":56,"propertyName":"的萨发","communityName":"国风美唐","nperName":null,"floorName":"一栋","unitName":"三单元","doorName":"1003-1"},{"orderId":5,"orderNum":"5225670212787","orderTime":"2017-07-04 15:26:23","rentMoney":101,"note":"重复测试","payState":1,"payWay":0,"payTime":1499171871000,"transaction_id":null,"owner_id":null,"mobilePhone":"18813045215","propertyId":1,"communityId":2,"nperId":2,"floorId":5,"unitId":15,"doorId":56,"propertyName":"物业公司","communityName":"国风美唐","nperName":null,"floorName":null,"unitName":"四单元","doorName":"1003-1"},{"orderId":8,"orderNum":"17082314153742316","orderTime":"2017-06-23 14:15:37","rentMoney":0.01,"note":"测试","payState":1,"payWay":1,"payTime":1498205455000,"transaction_id":null,"owner_id":null,"mobilePhone":"17310847181","propertyId":2,"communityId":4,"nperId":14,"floorId":21,"unitId":45,"doorId":56,"propertyName":"士大夫","communityName":"融科望京B座","nperName":"一期","floorName":"B座","unitName":"一单元","doorName":"1003-1"},{"orderId":9,"orderNum":"17082314155217316","orderTime":"2017-07-23 14:15:52","rentMoney":0.02,"note":"测试2","payState":1,"payWay":0,"payTime":1500566400000,"transaction_id":null,"owner_id":null,"mobilePhone":"17310847181","propertyId":2,"communityId":4,"nperId":14,"floorId":21,"unitId":45,"doorId":56,"propertyName":"士大夫撒旦","communityName":"融科望京B座","nperName":"一期","floorName":"B座","unitName":"一单元","doorName":"1003-1"},{"orderId":10,"orderNum":"17082511351216334","orderTime":"2017-08-25 11:35:12","rentMoney":10,"note":"物业费","payState":1,"payWay":0,"payTime":1503417600000,"transaction_id":null,"owner_id":null,"mobilePhone":"17310847181","propertyId":1,"communityId":4,"nperId":14,"floorId":21,"unitId":45,"doorId":56,"propertyName":"士大夫撒旦 3","communityName":"融科望京B座","nperName":"一期","floorName":"B座","unitName":"一单元","doorName":"1003-1"}],"firstPage":1,"prePage":0,"nextPage":2,"lastPage":3,"isFirstPage":true,"isLastPage":false,"hasPreviousPage":false,"hasNextPage":true,"navigatePages":8,"navigatepageNums":[1,2,3]}
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
         * total : 13
         * pages : 3
         * list : [{"orderId":1,"orderNum":"52255555674565","orderTime":"2017-06-30 16:26:25","rentMoney":1,"note":"大随风倒","payState":1,"payWay":0,"payTime":1509353795000,"transaction_id":null,"owner_id":null,"mobilePhone":"18813045215","propertyId":1,"communityId":2,"nperId":2,"floorId":7,"unitId":17,"doorId":56,"propertyName":"的萨发","communityName":"国风美唐","nperName":null,"floorName":"一栋","unitName":"三单元","doorName":"1003-1"},{"orderId":5,"orderNum":"5225670212787","orderTime":"2017-07-04 15:26:23","rentMoney":101,"note":"重复测试","payState":1,"payWay":0,"payTime":1499171871000,"transaction_id":null,"owner_id":null,"mobilePhone":"18813045215","propertyId":1,"communityId":2,"nperId":2,"floorId":5,"unitId":15,"doorId":56,"propertyName":"物业公司","communityName":"国风美唐","nperName":null,"floorName":null,"unitName":"四单元","doorName":"1003-1"},{"orderId":8,"orderNum":"17082314153742316","orderTime":"2017-06-23 14:15:37","rentMoney":0.01,"note":"测试","payState":1,"payWay":1,"payTime":1498205455000,"transaction_id":null,"owner_id":null,"mobilePhone":"17310847181","propertyId":2,"communityId":4,"nperId":14,"floorId":21,"unitId":45,"doorId":56,"propertyName":"士大夫","communityName":"融科望京B座","nperName":"一期","floorName":"B座","unitName":"一单元","doorName":"1003-1"},{"orderId":9,"orderNum":"17082314155217316","orderTime":"2017-07-23 14:15:52","rentMoney":0.02,"note":"测试2","payState":1,"payWay":0,"payTime":1500566400000,"transaction_id":null,"owner_id":null,"mobilePhone":"17310847181","propertyId":2,"communityId":4,"nperId":14,"floorId":21,"unitId":45,"doorId":56,"propertyName":"士大夫撒旦","communityName":"融科望京B座","nperName":"一期","floorName":"B座","unitName":"一单元","doorName":"1003-1"},{"orderId":10,"orderNum":"17082511351216334","orderTime":"2017-08-25 11:35:12","rentMoney":10,"note":"物业费","payState":1,"payWay":0,"payTime":1503417600000,"transaction_id":null,"owner_id":null,"mobilePhone":"17310847181","propertyId":1,"communityId":4,"nperId":14,"floorId":21,"unitId":45,"doorId":56,"propertyName":"士大夫撒旦 3","communityName":"融科望京B座","nperName":"一期","floorName":"B座","unitName":"一单元","doorName":"1003-1"}]
         * firstPage : 1
         * prePage : 0
         * nextPage : 2
         * lastPage : 3
         * isFirstPage : true
         * isLastPage : false
         * hasPreviousPage : false
         * hasNextPage : true
         * navigatePages : 8
         * navigatepageNums : [1,2,3]
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
             * orderId : 1
             * orderNum : 52255555674565
             * orderTime : 2017-06-30 16:26:25
             * rentMoney : 1.0
             * note : 大随风倒
             * payState : 1
             * payWay : 0
             * payTime : 1509353795000
             * transaction_id : null
             * owner_id : null
             * mobilePhone : 18813045215
             * propertyId : 1
             * communityId : 2
             * nperId : 2
             * floorId : 7
             * unitId : 17
             * doorId : 56
             * propertyName : 的萨发
             * communityName : 国风美唐
             * nperName : null
             * floorName : 一栋
             * unitName : 三单元
             * doorName : 1003-1
             */

            private int orderId;
            private String orderNum;
            private String orderTime;
            private double rentMoney;
            private String note;
            private int payState;
            private int payWay;
            private long payTime;
            private Object transaction_id;
            private Object owner_id;
            private String mobilePhone;
            private int propertyId;
            private int communityId;
            private int nperId;
            private int floorId;
            private int unitId;
            private int doorId;
            private String propertyName;
            private String communityName;
            private Object nperName;
            private String floorName;
            private String unitName;
            private String doorName;

            public int getOrderId() {
                return orderId;
            }

            public void setOrderId(int orderId) {
                this.orderId = orderId;
            }

            public String getOrderNum() {
                return orderNum;
            }

            public void setOrderNum(String orderNum) {
                this.orderNum = orderNum;
            }

            public String getOrderTime() {
                return orderTime;
            }

            public void setOrderTime(String orderTime) {
                this.orderTime = orderTime;
            }

            public double getRentMoney() {
                return rentMoney;
            }

            public void setRentMoney(double rentMoney) {
                this.rentMoney = rentMoney;
            }

            public String getNote() {
                return note;
            }

            public void setNote(String note) {
                this.note = note;
            }

            public int getPayState() {
                return payState;
            }

            public void setPayState(int payState) {
                this.payState = payState;
            }

            public int getPayWay() {
                return payWay;
            }

            public void setPayWay(int payWay) {
                this.payWay = payWay;
            }

            public long getPayTime() {
                return payTime;
            }

            public void setPayTime(long payTime) {
                this.payTime = payTime;
            }

            public Object getTransaction_id() {
                return transaction_id;
            }

            public void setTransaction_id(Object transaction_id) {
                this.transaction_id = transaction_id;
            }

            public Object getOwner_id() {
                return owner_id;
            }

            public void setOwner_id(Object owner_id) {
                this.owner_id = owner_id;
            }

            public String getMobilePhone() {
                return mobilePhone;
            }

            public void setMobilePhone(String mobilePhone) {
                this.mobilePhone = mobilePhone;
            }

            public int getPropertyId() {
                return propertyId;
            }

            public void setPropertyId(int propertyId) {
                this.propertyId = propertyId;
            }

            public int getCommunityId() {
                return communityId;
            }

            public void setCommunityId(int communityId) {
                this.communityId = communityId;
            }

            public int getNperId() {
                return nperId;
            }

            public void setNperId(int nperId) {
                this.nperId = nperId;
            }

            public int getFloorId() {
                return floorId;
            }

            public void setFloorId(int floorId) {
                this.floorId = floorId;
            }

            public int getUnitId() {
                return unitId;
            }

            public void setUnitId(int unitId) {
                this.unitId = unitId;
            }

            public int getDoorId() {
                return doorId;
            }

            public void setDoorId(int doorId) {
                this.doorId = doorId;
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

            public String getFloorName() {
                return floorName;
            }

            public void setFloorName(String floorName) {
                this.floorName = floorName;
            }

            public String getUnitName() {
                return unitName;
            }

            public void setUnitName(String unitName) {
                this.unitName = unitName;
            }

            public String getDoorName() {
                return doorName;
            }

            public void setDoorName(String doorName) {
                this.doorName = doorName;
            }
        }
    }
}
