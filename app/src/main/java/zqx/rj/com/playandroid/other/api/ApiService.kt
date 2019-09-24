package zqx.rj.com.playandroid.other.api

import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query
import zqx.rj.com.playandroid.other.bean.BaseResponse
import zqx.rj.com.playandroid.other.bean.EmptyRsp
import zqx.rj.com.playandroid.account.data.bean.LoginRsp
import zqx.rj.com.playandroid.account.data.bean.ScoreInfoRsp
import zqx.rj.com.playandroid.common.search.data.bean.HotKeyRsp
import zqx.rj.com.playandroid.common.search.data.bean.SearchResultRsp
import zqx.rj.com.playandroid.main.home.data.bean.BannerRsp
import zqx.rj.com.playandroid.main.home.data.bean.CommonWebRsp
import zqx.rj.com.playandroid.main.home.data.bean.HomeArticleRsp
import zqx.rj.com.playandroid.mine.collect.data.bean.CollectRsp
import zqx.rj.com.playandroid.main.navigation.data.bean.NavigationCategoryRsp
import zqx.rj.com.playandroid.main.project.data.bean.ProjectRsp
import zqx.rj.com.playandroid.main.project.data.bean.ProjectTreeRsp
import zqx.rj.com.playandroid.main.system.data.bean.TopTreeRsp
import zqx.rj.com.playandroid.main.system.data.bean.TreeArticleRsp
import zqx.rj.com.playandroid.mine.todo.data.bean.PageRsp
import zqx.rj.com.playandroid.mine.todo.data.bean.TodoRsp
import zqx.rj.com.playandroid.main.wechat.data.bean.WeChatNameRsp
import zqx.rj.com.playandroid.main.wechat.data.bean.WxArticleRsp

/**
 * author：  HyZhan
 * created： 2018/10/10 16:43
 * desc：    Api  (来自 hongyang大神的玩Android Api -> http://www.wanandroid.com/blog/show/2 )
 */
interface ApiService {

    @POST(API.LOGIN)
    suspend fun loginAsync(
        @Query("username") username: String,
        @Query("password") password: String
    ): BaseResponse<LoginRsp>

    @POST(API.REGISTER)
    suspend fun registerAsync(
        @Query("username") username: String,
        @Query("password") password: String,
        @Query("repassword") repassword: String
    ): BaseResponse<LoginRsp>

    @GET("banner/json")
    suspend fun getBannerAsync(): BaseResponse<List<BannerRsp>>

    @GET("article/list/{page}/json")
    suspend fun getHomeArticleAsync(@Path("page") page: Int): BaseResponse<HomeArticleRsp>

    @GET("hotkey/json")
    suspend fun getHotKeyAsync(): BaseResponse<List<HotKeyRsp>>

    @POST("article/query/{page}/json")
    suspend fun searchAsync(
        @Path("page") page: Int,
        @Query("k") key: String
    ): BaseResponse<SearchResultRsp>

    @GET("friend/json")
    suspend fun getCommonWebAsync(): BaseResponse<List<CommonWebRsp>>

    @GET("navi/json")
    suspend fun getCategoryAsync(): BaseResponse<List<NavigationCategoryRsp>>

    @GET("tree/json")
    suspend fun getTreeAsync(): BaseResponse<List<TopTreeRsp>>

    @GET("article/list/{page}/json")
    suspend fun getArticleTreeAsync(
        @Path("page") page: Int,
        @Query("cid") id: Int
    ): BaseResponse<TreeArticleRsp>

    @GET("lg/collect/list/{page}/json")
    suspend fun getCollectArticleAsync(@Path("page") page: Int): BaseResponse<CollectRsp>

    @POST("lg/collect/{id}/json")
    suspend fun collectAsync(@Path("id") id: Int): BaseResponse<EmptyRsp>

    @POST("lg/uncollect_originId/{id}/json")
    suspend fun unCollectAsync(@Path("id") id: Int): BaseResponse<EmptyRsp>

    @POST("lg/uncollect/{id}/json")
    suspend fun unMyCollectAsync(
        @Path("id") id: Int,
        @Query("originId") originId: Int
    ): BaseResponse<EmptyRsp>

    @GET("project/tree/json")
    suspend fun getProjectTreeAsync(): BaseResponse<List<ProjectTreeRsp>>

    @GET("project/list/{page}/json")
    suspend fun getProjectsAsync(
        @Path("page") page: Int,
        @Query("cid") cid: Int
    ): BaseResponse<ProjectRsp>

    @GET("wxarticle/chapters/json")
    suspend fun getWeChatNameAsync(): BaseResponse<List<WeChatNameRsp>>

    @GET("wxarticle/list/{id}/{page}/json")
    suspend fun getWxArticleAsync(
        @Path("id") id: Int,
        @Path("page") page: Int
    ): BaseResponse<WxArticleRsp>

    @GET("lg/todo/v2/list/{page}/json")
    suspend fun getTodoListAsync(
        @Path("page") page: Int,
        @Query("status") status: Int,
        @Query("type") type: Int,
        @Query("priority") priority: Int,
        @Query("orderby") orderby: Int
    ): BaseResponse<PageRsp<TodoRsp>>

    @POST("lg/todo/done/{id}/json")
    suspend fun finishTodoAsync(
        @Path("id") id: Int,
        @Query("status") status: Int
    ): BaseResponse<EmptyRsp>

    @POST("lg/todo/delete/{id}/json")
    suspend fun deleteTodoAsync(@Path("id") id: Int): BaseResponse<EmptyRsp>

    @POST("lg/todo/add/json")
    suspend fun saveTodoAsync(
        @Query("title") title: String,
        @Query("date") time: String,
        @Query("type") type: Int,
        @Query("content") content: String
    ): BaseResponse<EmptyRsp>

    @POST("lg/todo/update/{id}/json")
    suspend fun updateTodoAsync(
        @Path("id") id: Int,
        @Query("title") title: String,
        @Query("date") time: String,
        @Query("status") status: Int,
        @Query("type") type: Int,
        @Query("content") content: String,
        @Query("priority") priority: Int
    ): BaseResponse<EmptyRsp>

    @GET("lg/coin/userinfo/json")
    suspend fun getScoreInfoAsync(): BaseResponse<ScoreInfoRsp>
}