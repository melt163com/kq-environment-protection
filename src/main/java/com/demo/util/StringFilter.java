package com.demo.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * todo:字符过滤
 * @author tdy
 * @Auther: TongDeYi
 * @Date: 2022/05/11/14:28
 * @Description:
 */

public class StringFilter {
    /**
     *  todo:特殊字符过滤
     * @param str
     * @return
     */
    public static String updateString(String str){
        String regEx = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*()——+|{}【】‘；：”“’。，、？\\\\]";
//        String regEx="[^0-9a-zA-Z\\u4E00-\\u9FA5]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.replaceAll("").trim();
    }
    /**
     *  todo:只允许中文、英文
     * @param str
     * @return
     */
    public static Boolean inspectString(String str){
        String regEx="[\\u4e00-\\u9fa5]|[\\ufe30-\\uffa0]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
         return  m.find();
    }
    /**
     *  todo:必须10位以上，需要包含大小写字母、特殊字符
     * @param str
     * @return
     */
    public static Boolean inspectString1(String str){
////      String regEx="[^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[~!@#$%^&*]).{10,}$]";
////      String regEx="(?![A-Za-z0-9]+$)(?![a-z0-9\\W]+$)(?![A-Za-z\\W]+$)(?![A-Z0-9\\W]+$)[a-zA-Z0-9\\W]{10,}$";
////      Pattern p = Pattern.compile(regEx);
////      Matcher m = p.matcher(str);
////      System.out.println("这是m->"+m.find());
////      return  m.find();

        return  str.matches("^(?![A-Za-z0-9]+$)(?![a-z0-9\\W]+$)(?![A-Za-z\\W]+$)(?![A-Z0-9\\W]+$)[a-zA-Z0-9\\W]{8,}$");

//      Pattern pattern = Pattern.compile(".*\\d.*");
//      return pattern.matcher(str).matches();
    }
    /**
     *  todo:必须6位以上，需要包含数字、小写英文
     * @param str
     * @return
     */
    public static Boolean inspectString2(String str){
        String regEx="[^(?=.*[a-z])(?=.*[0-9]).{6,}$]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
         return  m.find();
    }
    /**
     *  todo:只允许数字
     * @param str
     * @return
     */
    public static Boolean inspectString3(String str){
        String regEx="[^[0-9]*$]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        if(!m.find()&&str.length()!=11){
            return false;
        }
        return  m.find();
    }
    /**
     *  todo:只允许yyyy-mm-dd
     * @param str
     * @return
     */
    public static Boolean inspectStringDate(String str){
        String regEx="^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return  m.find();
    }
}
