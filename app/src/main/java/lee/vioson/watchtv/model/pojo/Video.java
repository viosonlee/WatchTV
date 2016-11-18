package lee.vioson.watchtv.model.pojo;

import java.util.List;

/**
 * Author:李烽
 * Date:2016-11-18
 * FIXME
 * Todo
 */

public class Video extends BaseResult {

    /**
     * body : {"videos":[{"vid":24291,"playerUrl":"http://43.241.224.161/btmovie/MoviePlay.m3u8?movieid=24291&index=1","videoName":"三星营养午餐/三星校餐第1集","aid":24291},{"vid":24292,"playerUrl":"http://43.241.224.161/btmovie/MoviePlay.m3u8?movieid=24291&index=2","videoName":"三星营养午餐/三星校餐第2集","aid":24291},{"vid":24293,"playerUrl":"http://43.241.224.161/btmovie/MoviePlay.m3u8?movieid=24291&index=3","videoName":"三星营养午餐/三星校餐第3集","aid":24291},{"vid":24294,"playerUrl":"http://43.241.224.161/btmovie/MoviePlay.m3u8?movieid=24291&index=4","videoName":"三星营养午餐/三星校餐第4集","aid":24291},{"vid":24295,"playerUrl":"http://43.241.224.161/btmovie/MoviePlay.m3u8?movieid=24291&index=5","videoName":"三星营养午餐/三星校餐第5集","aid":24291},{"vid":24296,"playerUrl":"http://43.241.224.161/btmovie/MoviePlay.m3u8?movieid=24291&index=6","videoName":"三星营养午餐/三星校餐第6集","aid":24291}],"desc":"<div class=\"module movie-info\">\n    <div class=\"info\">\n        <span>上映：<\/span>2,016\n        <\/br>\n        <span class=\"zt\">状态：<\/span>共10集 已更新至6集\n        <\/br>\n        <span>类型：<\/span>\n            剧情\n        <\/br>\n        <span>主演：<\/span>\n            天海祐希 小泉孝太郎 川口春奈 荒川良良 \n        <\/br>\n        <span>地区：<\/span>日本\n        <\/br>\n        <span>影片评分：<\/span>\n        <span>7.6分<\/span>\n        <\/br>\n        <span>更新日期：<\/span>\n        <span>2016-11-18 11:31:17<\/span>\n        <\/br>\n    <\/div>\n    <div class=\"des\">\n        <span>简介：<\/span>\n        <span class=\"des-all\">烹饪天才星野光子（天海佑希饰）在银座著名三星法国餐厅担任主厨，但因她过于追求料理水准，完全不考虑成本，惨遭解雇。暂时无法在其他餐厅工作的星野，参加了一档制作营养午餐的电视节目。成本和营养的要求更加严苛，屡屡碰壁的星野却越挫越勇，决心把营养午餐也做成米其林三星水准。<\/span>\n\n    <\/div>\n<\/div>"}
     */

    public Body body;
    public static class Body {
        /**
         * videos : [{"vid":24291,"playerUrl":"http://43.241.224.161/btmovie/MoviePlay.m3u8?movieid=24291&index=1","videoName":"三星营养午餐/三星校餐第1集","aid":24291},{"vid":24292,"playerUrl":"http://43.241.224.161/btmovie/MoviePlay.m3u8?movieid=24291&index=2","videoName":"三星营养午餐/三星校餐第2集","aid":24291},{"vid":24293,"playerUrl":"http://43.241.224.161/btmovie/MoviePlay.m3u8?movieid=24291&index=3","videoName":"三星营养午餐/三星校餐第3集","aid":24291},{"vid":24294,"playerUrl":"http://43.241.224.161/btmovie/MoviePlay.m3u8?movieid=24291&index=4","videoName":"三星营养午餐/三星校餐第4集","aid":24291},{"vid":24295,"playerUrl":"http://43.241.224.161/btmovie/MoviePlay.m3u8?movieid=24291&index=5","videoName":"三星营养午餐/三星校餐第5集","aid":24291},{"vid":24296,"playerUrl":"http://43.241.224.161/btmovie/MoviePlay.m3u8?movieid=24291&index=6","videoName":"三星营养午餐/三星校餐第6集","aid":24291}]
         * desc : <div class="module movie-info">
         <div class="info">
         <span>上映：</span>2,016
         </br>
         <span class="zt">状态：</span>共10集 已更新至6集
         </br>
         <span>类型：</span>
         剧情
         </br>
         <span>主演：</span>
         天海祐希 小泉孝太郎 川口春奈 荒川良良
         </br>
         <span>地区：</span>日本
         </br>
         <span>影片评分：</span>
         <span>7.6分</span>
         </br>
         <span>更新日期：</span>
         <span>2016-11-18 11:31:17</span>
         </br>
         </div>
         <div class="des">
         <span>简介：</span>
         <span class="des-all">烹饪天才星野光子（天海佑希饰）在银座著名三星法国餐厅担任主厨，但因她过于追求料理水准，完全不考虑成本，惨遭解雇。暂时无法在其他餐厅工作的星野，参加了一档制作营养午餐的电视节目。成本和营养的要求更加严苛，屡屡碰壁的星野却越挫越勇，决心把营养午餐也做成米其林三星水准。</span>

         </div>
         </div>
         */

        public String desc;
        public List<VideoInfo> videos;

    }
}
