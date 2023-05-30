package com.six.campuseventmanagementsystem.verify;

public class StrNotice {
    /**
    *通知类型判断
     *1、实名验证类（RealName）
     * （1）submit 提交
     * （2）success 成功
     * （3）fail 失败
     * 2、角色替换（Change）
     * （1）admin 管理员
     */
    public String Type(String Type, String action){
        if(Type.equals("RealName")){
            switch (action){
                case "submit":
                    return "发起实名验证";
                case "success":
                    return "实名验证成功";
                case "fail":
                    return "实名验证失败";
            }

        }
        else if(Type.equals("Change")){
            switch (action){
                case "admin":
                    return "管理员角色替换";
            }
        }
        return "失败";
    }

    /**
     *通知内容判断
     *1、实名验证类（RealName）
     * （1）zzs 成为赞助商
     * （2）zbf 成为主办方
     * （3）submit 提交
     * （4）fail 失败
     * 2、角色替换（Change）
     * （1）admin 成为管理员
     */

    public String Message(String Type, String action){
        if(Type.equals("RealName")){
            switch (action){
                case "zzs":
                    return "您现在的身份是赞助商";
                case "zbf":
                    return "您现在的身份是主办方";
                case "submit":
                    return "审核提交成功";
                case "fail":
                    return "审核不通过，实名验证失败";
            }

        }
        else if(Type.equals("Change")){
            switch (action){
                case "admin":
                    return "您已被设定为管理员";
            }
        }
        return "失败";
    }

}
