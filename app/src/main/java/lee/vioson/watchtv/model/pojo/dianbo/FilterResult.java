package lee.vioson.watchtv.model.pojo.dianbo;

import java.util.List;

import lee.vioson.watchtv.model.pojo.BaseResult;
import lee.vioson.watchtv.model.pojo.homeData.Movie;

/**
 * Author:李烽
 * Date:2016-11-18
 * FIXME
 * Todo
 */

public class FilterResult extends BaseResult {

    public List<Result> body;

    public static class Result extends Movie{
        /**
         * album : false
         * commentPageNum : 0
         * doubanId : 26597953
         * hot : 0
         * img : https://qnmob.doubanio.com/view/movie_poster_cover/lpst/public/p2268754172.jpg
         * lastUpdateTime : 2015-10-29T00:43:32
         * movieId : 21959
         * movieTypeName : 动画片
         * name : 长江7号：超萌特攻队1280超清
         * publishTime : 2015
         * score : 6.6
         * scoreNum : 0
         * status : 全集
         * updateTime :
         */

//        public boolean album;
        public int commentPageNum;
        public String doubanId;
        public int hot;
//        public String img;
        public String lastUpdateTime;
//        public int movieId;
        public String movieTypeName;
//        public String name;
        public int publishTime;
//        public double score;
        public int scoreNum;
        public String status;
        public String updateTime;
    }
}
