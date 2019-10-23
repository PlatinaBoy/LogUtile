

import com.sun.xml.internal.ws.util.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import static java.net.Proxy.Type.HTTP;


/**
 * ClassName: UrlGetData <br/>
 * Description: platinaboy <br/>
 * date: 2019/6/21 10:36<br/>
 *
 * @author PlatinaBoy<br />
 */
public class UrlGetData {
    public static void main(String[] args) {
 //       String childid = args[0];
        String str = getData2("SHET2018112211");
//     String string=getURLContent("url提取数据");
//     System.out.println(string);
        String[] split = str.split(",");
        System.out.println(split[1]);
       
        //去掉首尾字符串'
        String s = jianqie.trimFirstAndLastChar(split[1].substring(8), "\"");
        String s1 = jianqie.GetRightData(split[1].substring(8), "\"");
        System.out.println(s);
        System.out.println(s1);
        String[] data = s.split(";");
        System.out.println(data[27]);
    }

    public static String getData2(String args) {

        HttpURLConnection conn = null;
        BufferedReader reader = null;
        String rs = null;
        String urldd = "url提取数据";
        try {
            //拼接参数，转义参数
            String connUrl = urldd + args;

            //创建连接
            URL url1 = new URL(connUrl);
            conn = (HttpURLConnection) url1.openConnection();
            conn.setUseCaches(false);
            conn.setConnectTimeout(30000);
            conn.setReadTimeout(30000);
            conn.setInstanceFollowRedirects(false);
            conn.connect();

            //获取并解析数据
            InputStream is = conn.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            StringBuffer sb = new StringBuffer();
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sb.append(strRead);
            }
            rs = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rs;
    }

//    private static String getURLContent(String urlStr) {
//        //请求的url
//        URL url = null;
//        //请求的输入流
//        BufferedReader in = null;
//        //输入流的缓冲
//        StringBuffer sb = new StringBuffer();
//        try{
//            url = new URL(urlStr);
//            in = new BufferedReader(new InputStreamReader(url.openStream(),"UTF-8") );
//            String str = null;
//            //一行一行进行读入
//            while((str = in.readLine()) != null) {
//                sb.append( str );
//            }
//        } catch (Exception ex) {
//
//        } finally{
//            try{
//                if(in!=null) {
//                    in.close(); //关闭流
//                }
//            }catch(IOException ex) {
//
//            }
//        }
//        String result =sb.toString();
//        return result;
//    }


}


