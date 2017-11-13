package com.bjxiyang.shuzianfangwuyeban.bean;

import java.util.List;

/**
 * Created by gll on 2017/11/13.
 */

public class ComplaintSelect {

    /**
     * code : 0
     * msg : 成功
     * obj : {"pageNum":1,"pageSize":5,"size":5,"startRow":1,"endRow":5,"total":33,"pages":7,"list":[{"complaint_id":9,"property_id":3,"community_id":4,"cmember_id":267,"complaint_type":0,"content":"感觉","contact_way":null,"create_time":"2017-10-26 09:57:00","reply_content":null,"reply_userId":null,"reply_time":null,"propertyName":null,"communityName":null,"pic_url":[{"pic_id":null,"complaint_id":9,"pic_url":"1508983013783.jpg"}]},{"complaint_id":39,"property_id":3,"community_id":4,"cmember_id":267,"complaint_type":0,"content":"感觉","contact_way":"","create_time":"2017-10-26 09:57:00","reply_content":null,"reply_userId":null,"reply_time":null,"propertyName":null,"communityName":null,"pic_url":[{"pic_id":null,"complaint_id":39,"pic_url":null}]},{"complaint_id":25,"property_id":3,"community_id":4,"cmember_id":267,"complaint_type":0,"content":"感觉","contact_way":"","create_time":"2017-10-26 09:57:00","reply_content":null,"reply_userId":null,"reply_time":null,"propertyName":null,"communityName":null,"pic_url":[{"pic_id":null,"complaint_id":25,"pic_url":null}]},{"complaint_id":18,"property_id":3,"community_id":4,"cmember_id":267,"complaint_type":0,"content":"感觉","contact_way":"","create_time":"2017-10-26 09:57:00","reply_content":null,"reply_userId":null,"reply_time":null,"propertyName":null,"communityName":null,"pic_url":[{"pic_id":null,"complaint_id":18,"pic_url":null}]},{"complaint_id":31,"property_id":7,"community_id":8,"cmember_id":267,"complaint_type":0,"content":"呵呵","contact_way":"","create_time":"2017-10-26 09:55:08","reply_content":null,"reply_userId":null,"reply_time":null,"propertyName":null,"communityName":null,"pic_url":[{"pic_id":null,"complaint_id":31,"pic_url":null}]}],"firstPage":1,"prePage":0,"nextPage":2,"lastPage":7,"isFirstPage":true,"isLastPage":false,"hasPreviousPage":false,"hasNextPage":true,"navigatePages":8,"navigatepageNums":[1,2,3,4,5,6,7]}
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
         * total : 33
         * pages : 7
         * list : [{"complaint_id":9,"property_id":3,"community_id":4,"cmember_id":267,"complaint_type":0,"content":"感觉","contact_way":null,"create_time":"2017-10-26 09:57:00","reply_content":null,"reply_userId":null,"reply_time":null,"propertyName":null,"communityName":null,"pic_url":[{"pic_id":null,"complaint_id":9,"pic_url":"1508983013783.jpg"}]},{"complaint_id":39,"property_id":3,"community_id":4,"cmember_id":267,"complaint_type":0,"content":"感觉","contact_way":"","create_time":"2017-10-26 09:57:00","reply_content":null,"reply_userId":null,"reply_time":null,"propertyName":null,"communityName":null,"pic_url":[{"pic_id":null,"complaint_id":39,"pic_url":null}]},{"complaint_id":25,"property_id":3,"community_id":4,"cmember_id":267,"complaint_type":0,"content":"感觉","contact_way":"","create_time":"2017-10-26 09:57:00","reply_content":null,"reply_userId":null,"reply_time":null,"propertyName":null,"communityName":null,"pic_url":[{"pic_id":null,"complaint_id":25,"pic_url":null}]},{"complaint_id":18,"property_id":3,"community_id":4,"cmember_id":267,"complaint_type":0,"content":"感觉","contact_way":"","create_time":"2017-10-26 09:57:00","reply_content":null,"reply_userId":null,"reply_time":null,"propertyName":null,"communityName":null,"pic_url":[{"pic_id":null,"complaint_id":18,"pic_url":null}]},{"complaint_id":31,"property_id":7,"community_id":8,"cmember_id":267,"complaint_type":0,"content":"呵呵","contact_way":"","create_time":"2017-10-26 09:55:08","reply_content":null,"reply_userId":null,"reply_time":null,"propertyName":null,"communityName":null,"pic_url":[{"pic_id":null,"complaint_id":31,"pic_url":null}]}]
         * firstPage : 1
         * prePage : 0
         * nextPage : 2
         * lastPage : 7
         * isFirstPage : true
         * isLastPage : false
         * hasPreviousPage : false
         * hasNextPage : true
         * navigatePages : 8
         * navigatepageNums : [1,2,3,4,5,6,7]
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
             * complaint_id : 9
             * property_id : 3
             * community_id : 4
             * cmember_id : 267
             * complaint_type : 0
             * content : 感觉
             * contact_way : null
             * create_time : 2017-10-26 09:57:00
             * reply_content : null
             * reply_userId : null
             * reply_time : null
             * propertyName : null
             * communityName : null
             * pic_url : [{"pic_id":null,"complaint_id":9,"pic_url":"1508983013783.jpg"}]
             */

            private int complaint_id;
            private int property_id;
            private int community_id;
            private int cmember_id;
            private int complaint_type;
            private String content;
            private Object contact_way;
            private String create_time;
            private Object reply_content;
            private Object reply_userId;
            private Object reply_time;
            private Object propertyName;
            private Object communityName;
            private List<PicUrlBean> pic_url;

            public int getComplaint_id() {
                return complaint_id;
            }

            public void setComplaint_id(int complaint_id) {
                this.complaint_id = complaint_id;
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

            public int getCmember_id() {
                return cmember_id;
            }

            public void setCmember_id(int cmember_id) {
                this.cmember_id = cmember_id;
            }

            public int getComplaint_type() {
                return complaint_type;
            }

            public void setComplaint_type(int complaint_type) {
                this.complaint_type = complaint_type;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public Object getContact_way() {
                return contact_way;
            }

            public void setContact_way(Object contact_way) {
                this.contact_way = contact_way;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public Object getReply_content() {
                return reply_content;
            }

            public void setReply_content(Object reply_content) {
                this.reply_content = reply_content;
            }

            public Object getReply_userId() {
                return reply_userId;
            }

            public void setReply_userId(Object reply_userId) {
                this.reply_userId = reply_userId;
            }

            public Object getReply_time() {
                return reply_time;
            }

            public void setReply_time(Object reply_time) {
                this.reply_time = reply_time;
            }

            public Object getPropertyName() {
                return propertyName;
            }

            public void setPropertyName(Object propertyName) {
                this.propertyName = propertyName;
            }

            public Object getCommunityName() {
                return communityName;
            }

            public void setCommunityName(Object communityName) {
                this.communityName = communityName;
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
                 * complaint_id : 9
                 * pic_url : 1508983013783.jpg
                 */

                private Object pic_id;
                private int complaint_id;
                private String pic_url;

                public Object getPic_id() {
                    return pic_id;
                }

                public void setPic_id(Object pic_id) {
                    this.pic_id = pic_id;
                }

                public int getComplaint_id() {
                    return complaint_id;
                }

                public void setComplaint_id(int complaint_id) {
                    this.complaint_id = complaint_id;
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
