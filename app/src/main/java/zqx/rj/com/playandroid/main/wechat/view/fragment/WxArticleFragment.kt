package zqx.rj.com.playandroid.main.wechat.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import zqx.rj.com.playandroid.common.article.view.ArticleListFragment
import zqx.rj.com.playandroid.main.wechat.vm.WeChatViewModel

/**
 * author：  HyZhan
 * created： 2018/11/2 16:54
 * desc：    微信公众号 文章
 */
class WxArticleFragment : ArticleListFragment<WeChatViewModel>() {

    private var page: Int = 1
    private val uid: Int by lazy { arguments?.getInt("id") ?: -1 }

    companion object {
        fun getNewInstance(id: Int): Fragment {
            val bundle = Bundle()
            bundle.putInt("id", id)

            val fragment = WxArticleFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun initData() {
        super.initData()
        page = 1
        viewModel.getWxArticle(uid, page)
    }

    override fun onRefreshData() {
        page = 1
        viewModel.getWxArticle(uid, page)
    }

    override fun onLoadMoreData() {
        viewModel.getWxArticle(uid, ++page)
    }

    override fun dataObserver() {
        super.dataObserver()

        viewModel.wxArticleData.observe(this, Observer {
            addData(it.datas)
        })
    }
}