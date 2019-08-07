package zqx.rj.com.playandroid.account.data.bean

/**
 * author：  HyZhan
 * created： 2018/10/11 18:11
 * desc：    登录返回类
 */
data class LoginRsp(
        val icon: String,
        val type: String,
        val collectIds: List<Int>,
        val username: String
)
