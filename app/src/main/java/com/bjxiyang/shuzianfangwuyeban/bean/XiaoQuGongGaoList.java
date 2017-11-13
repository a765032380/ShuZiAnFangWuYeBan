package com.bjxiyang.shuzianfangwuyeban.bean;

import java.util.List;

/**
 * Created by gll on 2017/11/13.
 */

public class XiaoQuGongGaoList {

    /**
     * code : 0
     * msg : 成功
     * obj : {"pageNum":1,"pageSize":5,"size":5,"startRow":1,"endRow":5,"total":29,"pages":6,"list":[{"noticeId":10,"noticer":"焦经理","notice_type":0,"title":"临时停电通知","content":"尊敬的宏源公寓业主：\r\n        今接到供电局通知，酒仙桥地区线路故障，今晚20：00将停电3-5分钟，请各位业主做好准备。","add_time":"2017-08-30 17:51:33","type":1,"community_id":6,"communityName":"宏源公寓","property_id":1},{"noticeId":11,"noticer":"物业门禁卡管理处","notice_type":0,"title":"门禁卡办理时间","content":"尊敬的各位业主、住户：新门禁系统启用时间：下周一（2017年9月4日）正式使用。请大家及时办理升级门禁卡，以免对您的出入造成不便。","add_time":"2017-09-01 15:27:57","type":0,"community_id":6,"communityName":"宏源公寓","property_id":1},{"noticeId":12,"noticer":"宏源物业管理部","notice_type":0,"title":"通知","content":"由于本小区垃圾房设在楼层内滋生蟑螂鼠疫，为改善居民生活环境，近期将封闭楼道内垃圾房，并在A.B两栋楼下集中设立垃圾箱","add_time":"2017-09-11 14:50:38","type":1,"community_id":6,"communityName":"宏源公寓","property_id":1},{"noticeId":14,"noticer":"物业门禁卡管理处","notice_type":0,"title":"门禁卡办理时间","content":"尊敬的各位业主、住户：新门禁系统启用时间：下周一（2017年9月4日）正式使用。请大家及时办理升级门禁卡，以免对您的出入造成不便。","add_time":"2017-09-01 15:27:57","type":0,"community_id":6,"communityName":"宏源公寓","property_id":1},{"noticeId":15,"noticer":"宏源物业管理部","notice_type":0,"title":"通知","content":"由于本小区垃圾房设在楼层内滋生蟑螂鼠疫，为改善居民生活环境，近期将封闭楼道内垃圾房，并在A.B两栋楼下集中设立垃圾箱","add_time":"2017-09-11 14:50:38","type":1,"community_id":6,"communityName":"宏源公寓","property_id":1}],"firstPage":1,"prePage":0,"nextPage":2,"lastPage":6,"isFirstPage":true,"isLastPage":false,"hasPreviousPage":false,"hasNextPage":true,"navigatePages":8,"navigatepageNums":[1,2,3,4,5,6]}
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
         * total : 29
         * pages : 6
         * list : [{"noticeId":10,"noticer":"焦经理","notice_type":0,"title":"临时停电通知","content":"尊敬的宏源公寓业主：\r\n        今接到供电局通知，酒仙桥地区线路故障，今晚20：00将停电3-5分钟，请各位业主做好准备。","add_time":"2017-08-30 17:51:33","type":1,"community_id":6,"communityName":"宏源公寓","property_id":1},{"noticeId":11,"noticer":"物业门禁卡管理处","notice_type":0,"title":"门禁卡办理时间","content":"尊敬的各位业主、住户：新门禁系统启用时间：下周一（2017年9月4日）正式使用。请大家及时办理升级门禁卡，以免对您的出入造成不便。","add_time":"2017-09-01 15:27:57","type":0,"community_id":6,"communityName":"宏源公寓","property_id":1},{"noticeId":12,"noticer":"宏源物业管理部","notice_type":0,"title":"通知","content":"由于本小区垃圾房设在楼层内滋生蟑螂鼠疫，为改善居民生活环境，近期将封闭楼道内垃圾房，并在A.B两栋楼下集中设立垃圾箱","add_time":"2017-09-11 14:50:38","type":1,"community_id":6,"communityName":"宏源公寓","property_id":1},{"noticeId":14,"noticer":"物业门禁卡管理处","notice_type":0,"title":"门禁卡办理时间","content":"尊敬的各位业主、住户：新门禁系统启用时间：下周一（2017年9月4日）正式使用。请大家及时办理升级门禁卡，以免对您的出入造成不便。","add_time":"2017-09-01 15:27:57","type":0,"community_id":6,"communityName":"宏源公寓","property_id":1},{"noticeId":15,"noticer":"宏源物业管理部","notice_type":0,"title":"通知","content":"由于本小区垃圾房设在楼层内滋生蟑螂鼠疫，为改善居民生活环境，近期将封闭楼道内垃圾房，并在A.B两栋楼下集中设立垃圾箱","add_time":"2017-09-11 14:50:38","type":1,"community_id":6,"communityName":"宏源公寓","property_id":1}]
         * firstPage : 1
         * prePage : 0
         * nextPage : 2
         * lastPage : 6
         * isFirstPage : true
         * isLastPage : false
         * hasPreviousPage : false
         * hasNextPage : true
         * navigatePages : 8
         * navigatepageNums : [1,2,3,4,5,6]
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
             * noticeId : 10
             * noticer : 焦经理
             * notice_type : 0
             * title : 临时停电通知
             * content : 尊敬的宏源公寓业主：
             今接到供电局通知，酒仙桥地区线路故障，今晚20：00将停电3-5分钟，请各位业主做好准备。
             * add_time : 2017-08-30 17:51:33
             * type : 1
             * community_id : 6
             * communityName : 宏源公寓
             * property_id : 1
             */

            private int noticeId;
            private String noticer;
            private int notice_type;
            private String title;
            private String content;
            private String add_time;
            private int type;
            private int community_id;
            private String communityName;
            private int property_id;

            public int getNoticeId() {
                return noticeId;
            }

            public void setNoticeId(int noticeId) {
                this.noticeId = noticeId;
            }

            public String getNoticer() {
                return noticer;
            }

            public void setNoticer(String noticer) {
                this.noticer = noticer;
            }

            public int getNotice_type() {
                return notice_type;
            }

            public void setNotice_type(int notice_type) {
                this.notice_type = notice_type;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getAdd_time() {
                return add_time;
            }

            public void setAdd_time(String add_time) {
                this.add_time = add_time;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public int getCommunity_id() {
                return community_id;
            }

            public void setCommunity_id(int community_id) {
                this.community_id = community_id;
            }

            public String getCommunityName() {
                return communityName;
            }

            public void setCommunityName(String communityName) {
                this.communityName = communityName;
            }

            public int getProperty_id() {
                return property_id;
            }

            public void setProperty_id(int property_id) {
                this.property_id = property_id;
            }
        }
    }
}
