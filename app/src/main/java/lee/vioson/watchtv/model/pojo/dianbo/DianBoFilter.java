package lee.vioson.watchtv.model.pojo.dianbo;

import java.util.List;

import lee.vioson.watchtv.model.pojo.BaseResult;

/**
 * Author:李烽
 * Date:2016-11-18
 * FIXME
 * Todo
 */

public class DianBoFilter extends BaseResult {

    /**
     * code : 0
     * message : return video filter.
     * body : {"types":["全部","都市","近代","感情","讽刺","竞技","萌宠","怪谈","网剧","惊悚","歌舞","改编","恐怖","热血","武术","悬疑","同性","时尚","史诗","复仇","破案","斗争","法务","网络剧","冒险","真人","探案","法律","僵尸","足球","友情","宫斗","其它"],"areas":["全部","大陆","香港","台湾","欧美","日本","韩国","其它"],"years":["全部","2016","2015","2014","2013","2012","2011","2010","2009","2008","2007","2006","2005","更早"]}
     */
    public Filter body;

    public static class Filter {
        public List<String> types;
        public List<String> areas;
        public List<String> years;
    }
}
