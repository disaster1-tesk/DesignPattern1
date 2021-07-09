package hongchengstudy.abstracclass.v6;
/*
"这些年一个人，风也过，雨也走，有过泪，有过错, 还记得坚持甚么，真爱过才会懂，会寂寞会回首，终有梦终有你在心中。朋友一生一起走，那些日子不再有，一句话，一辈子，一生情，一杯酒。朋友不曾孤单过，一声朋友你会懂，还有伤，还有痛，还要走，还有我。“
 */
public class Client {
    public static void main(String[] args) {
        String str = "这些年一个人，风也过，雨也走，有过泪，有过错, 还记得坚持甚么，真爱过才会懂，会寂寞会回首，终有梦终有你在心中。朋友一生一起走，那些日子不再有，一句话，一辈子，一生情，一杯酒。朋友不曾孤单过，一声朋友你会懂，还有伤，还有痛，还要走，还有我。";
//        StringBuilder sb = new StringBuilder("这些年一个人，风也过，雨也走，有过泪，有过错, 还记得坚持甚么，真爱过才会懂，会寂寞会回首，终有梦终有你在心中。朋友一生一起走，那些日子不再有，一句话，一辈子，一生情，一杯酒。朋友不曾孤单过，一声朋友你会懂，还有伤，还有痛，还要走，还有我。");
        String str1 = "ABC";
        System.out.println(str1.hashCode());
        System.out.println(str1.toUpperCase().hashCode());
        System.out.println(funV1(str));
        System.out.println(funV2(str));
        for (String string: str.split("朋友")) {
            System.out.println(string);
        }
    }
    public static int funV1(String str){
        int num=0;
        if (str.contains("朋友")){
            char[] chars = str.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i]=='朋'&&chars[i+1]=='友'){
                    num++;
                }
            }
            return num;
        }else{
            return 0;
        }
    }
    public static int funV2(String str){
        int num =0;
        while (str.contains("朋友")){
            int index = str.indexOf("朋友");
            String substring = str.substring(index+2);
            str = substring;
            num++;
        }
        return num;
    }
}
