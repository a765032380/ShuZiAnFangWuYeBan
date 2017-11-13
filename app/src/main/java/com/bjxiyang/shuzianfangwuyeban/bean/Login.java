package com.bjxiyang.shuzianfangwuyeban.bean;

import java.util.List;

/**
 * Created by gll on 2017/11/13.
 */

public class Login {

    /**
     * code : 0
     * msg : SUCCESS
     * obj : [{"birthday":"20160101","leader":"lllllllllllllllllllllllllll","headPhoneUrl":"20160101.jpg","propertyName":"北京大唐物业管理有限公司","sex":"男","private_token":"2_63eeb64344064cefb0f01de3a744f70b","tel":"13655419967","propertyId":"2"}]
     */

    private int code;
    private String msg;
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

    public List<ObjBean> getObj() {
        return obj;
    }

    public void setObj(List<ObjBean> obj) {
        this.obj = obj;
    }

    public static class ObjBean {
        /**
         * birthday : 20160101
         * leader : lllllllllllllllllllllllllll
         * headPhoneUrl : 20160101.jpg
         * propertyName : 北京大唐物业管理有限公司
         * sex : 男
         * private_token : 2_63eeb64344064cefb0f01de3a744f70b
         * tel : 13655419967
         * propertyId : 2
         */

        private String birthday;
        private String leader;
        private String headPhoneUrl;
        private String propertyName;
        private String sex;
        private String private_token;
        private String tel;
        private String propertyId;

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getLeader() {
            return leader;
        }

        public void setLeader(String leader) {
            this.leader = leader;
        }

        public String getHeadPhoneUrl() {
            return headPhoneUrl;
        }

        public void setHeadPhoneUrl(String headPhoneUrl) {
            this.headPhoneUrl = headPhoneUrl;
        }

        public String getPropertyName() {
            return propertyName;
        }

        public void setPropertyName(String propertyName) {
            this.propertyName = propertyName;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getPrivate_token() {
            return private_token;
        }

        public void setPrivate_token(String private_token) {
            this.private_token = private_token;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public String getPropertyId() {
            return propertyId;
        }

        public void setPropertyId(String propertyId) {
            this.propertyId = propertyId;
        }
    }
}
