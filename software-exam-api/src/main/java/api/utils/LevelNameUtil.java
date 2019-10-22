package api.utils;

public class LevelNameUtil {
    public static int level(String levelname){
        if (levelname.equals("初级")){
            return 1;
        }else if (levelname.equals("中级")){
            return 2;
        }else{
            return 3;
        }
    }
}
