

/**
 * ClassName: jianqie <br/>
 * Description: <br/>
 * date: 2019/6/21 16:34<br/>
 *
 * @author PlatinaBoy<br />
 */
public class jianqie {
    public static void main(String[] args) {

        String str = "{\"code\":200,\"data\":\"SHET201808286;;;xx;;xxxx;1;10000;3000-5000;0;0;0;;;;0;0;0;1;400000.00;1;aaa;1;12;700.00;1;bbb\",\"json\":[{\"carType\":\"bbbb\",\"commercialInsur\":\"1\",\"cultivateIncome\":0,\"debtIsOrNot\":\"1\",\"familyIncome\":\"10000\",\"feedIncome\":0,\"hasCar\":\"1\",\"house\":\"1\",\"houseType\":\"nnnn\",\"loan\":400000.00,\"medicare\":\"eeee\",\"ncms\":0,\"oddJobIncome\":0,\"otherincomePension\":\"无\",\"otherincomeRent\":\"无\",\"otherincomeSubsistenceAllowances\":\"无\",\"patientCode\":\"SHET201808286\",\"permanentJobIncome\":\"3000-5000\",\"platformDonate\":0,\"relation\":\"gggg\",\"rentPerMonth\":700.00,\"renting\":\"1\",\"rentingMonths\":\"12\",\"state\":\"\",\"totalCost\":0}],\"message\":\"请求成功,查到此数据\"}";
        String[] split = str.split(",");
        System.out.println(split[1]);
      
        //去掉首尾字符串'
        String s = trimFirstAndLastChar(split[1].substring(8), "\"");
        String s1 = GetRightData(split[1].substring(8), "\"");
        System.out.println(s);
        System.out.println(s1);
        String[] data = s.split(";");
        System.out.println(data[27]);


    }
    /**
     * 去除首尾指定字符
     * @param str 字符串
     * @param element 指定字符
     * @return
     */
    public static String trimFirstAndLastChar(String str, String element){
        boolean beginIndexFlag = true;
        boolean endIndexFlag = true;
        do{
            int beginIndex = str.indexOf(element) == 0 ? 1 : 0;
            int endIndex = str.lastIndexOf(element) + 1 == str.length() ? str.lastIndexOf(element) : str.length();
            str = str.substring(beginIndex, endIndex);
            beginIndexFlag = (str.indexOf(element) == 0);
            endIndexFlag = (str.lastIndexOf(element) + 1 == str.length());
        } while (beginIndexFlag || endIndexFlag);
        return str;
    }
    /**
     * 去除首尾指定字符
     * @param srcStr 字符串
     * @param splitter 指定字符
     * @return
     */
    public static String GetRightData(String srcStr, String splitter) {
        String regex = "^" + splitter + "*|" + splitter + "*$";
        return srcStr.replaceAll(regex, "");
    }

}
