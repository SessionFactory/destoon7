{php $CSS = array('index');}
{template 'header'}
<!--热门行业1-->
<div class="m-sibnav1">
    <div class="g-row1">
        <p>
            <strong>热门行业：</strong>
            <!--{php $tags=tag("table=category&condition=moduleid=22 and parentid=0&pagesize=10&order=listorder,catid&template=null");}-->
            {loop $tags $i $t}{if $i}  |  {/if}<a href="{$MODULE[22][linkurl]}{$t[linkurl]}">{$t[catname]}</a>{/loop}
        </p>
    </div>
</div>
<!--热门行业end-->
<!--主体开始-->
<div class="g-row1">
    <!--焦点图-->
    <div class="wrapper">
        <div id="focus">
            <ul>
                <!--{php $ad=tag("table=destoon_ad m,destoon_ad_place c&prefix=&condition=m.pid=c.pid and m.pid='14'&template=null");}-->
                {loop $ad $i $t}
                <li><a href="{$t[image_url]}" rel="nofollow" target="_blank">
                    <img src="{$t[image_src]}" width="695" height="280" alt="{$i+1}"></a></li>
                {/loop}
            </ul>
        </div>
    </div>
    <!--焦点图end-->
    {template 'sou'}
</div>
<!--广告-->
<div class="g-row1">
    <ul class="m-adsix">
        <li>{ad(20)}</li>
        <li>{ad(21)}</li>
        <li>{ad(22)}</li>
        <li>{ad(23)}</li>
        <li>{ad(24)}</li>
        <li>{ad(25)}</li>
    </ul>
</div>
<!--广告end-->
<!--最新建材意向代理商-->
<div class="g-row1">
    <div class="g-30 g-r">
        <div class="m-w1190">
            <div class="m-tit">
                <h2 class="u-tt">最新建材意向代理商</h2>
                <p class="fl"><a href="{$MODULE[2][linkurl]}my.php?mid=22&action=add" rel="nofollow" class="u-more bold">我要招商</a> <a href="{$MODULE[2][linkurl]}my.php?mid=6&action=add" rel="nofollow" class="u-more bold">我要代理</a></p>
                <p class="fr"><a href="{$MODULE[6][linkurl]}" class="u-more more">更多</a><i class="icon iconfont"></i><span>客服帮助：<b>{$DT[telephone]}</b></span></p>
            </div>
            <div class="m-cent fl">
                <dl class="u-tr bold">
                    <dt>代理信息</dt>
                    <dd>开店地址</dd>
                    <dd>核实状态</dd>
                    <dd>发布时间</dd>
                </dl>
                <!--{tag("moduleid=6&areaid=$cityid&catid=&length=30&condition=status=3&pagesize=7&order=addtime desc&template=list-dl")}-->
            </div>
            <div class="m-cent fl">
                <dl class="u-tr bold">
                    <dt>代理信息</dt>
                    <dd>开店地址</dd>
                    <dd>核实状态</dd>
                    <dd>发布时间</dd>
                </dl>
                <!--{tag("moduleid=6&areaid=$cityid&catid=&length=30&condition=status=3&pagesize=7&offset=8&order=addtime desc&template=list-dl")}-->
            </div>
        </div>
    </div>
</div>
<!--最新建材意向代理商end-->
<!--广告-->
<div class="g-row1">
    <ul class="m-adfive">
        <li>{ad(27)}</li>
        <li>{ad(28)}</li>
        <li>{ad(29)}</li>
        <li>{ad(30)}</li>
        <li>{ad(31)}</li>
        <li>{ad(32)}</li>
        <li>{ad(33)}</li>
        <li>{ad(34)}</li>
        <li>{ad(35)}</li>
        <li>{ad(36)}</li>
    </ul>
</div>
<!--广告end-->
<!--加盟推荐专区-->
<div class="g-row1">
    <div class="m-tit f-dtit">
        <h2 class="u-tt">加盟推荐专区</h2>
        <a href="/member/my.php?mid=22&action=add" rel="nofollow" class="u-more bold fr">我也要展示</a> <a href="/member/my.php?mid=6&action=add" rel="nofollow" class="u-more bold fr">我要代理</a>
    </div>
    <ul class="m-ilist m-ilist-w190 clearfix">
        <!--{tag("moduleid=22&condition=status=3&areaid=$cityid&pagesize=28&datetype=2&target=_blank&order=addtime desc&template=jmtjzq")}-->
    </ul>
</div>
<!--加盟推荐专区end-->
<!--品牌推荐专区-->
<div class="g-row1">
    <div class="m-tit f-dtit">
        <h2 class="u-tt">品牌推荐专区</h2>
        <a href="/brand" class="u-more bold fr">更多</a>
    </div>
    <ul class="m-ilist m-w150h80 clearfix">
        <!--{tag("moduleid=13&condition=status=3 and level>0&areaid=$cityid&pagesize=14&order=addtime desc&target=_blank&lazy=$lazy&template=list-pp")}-->
    </ul>
</div>
<!--品牌推荐专区end-->

<!--加盟留言-->
<div class="g-row1">
    <div class="m-tit f-dtit">
        <h2 class="u-tt">加盟留言</h2>
        <a href="/member/my.php?mid=6&action=add" rel="nofollow" class="u-more bold fr">我要代理</a> <a href="/member/my.php?mid=22&action=add" rel="nofollow" class="u-more bold fr">我要招商</a>
    </div>
    <div id="message">
        <div class="message">
            <ul class="m-list" id="slider">
                <!--{php $tags=tag("table=message&condition=status=3 and typeid<>'' &template=null");}-->
                {loop $tags $i $t}
                {php preg_match('|href\="(.*)"|iSU',$t[content],$url);}

                <li><span class="m-list-r">{date('m-d', $t[addtime])}</span>
                    <a href="{$url[1]}" target="_blank">来自<b>{commentr($t[fromuser])}</b>对招商企业<b>{dsubstr(commentr($t[touser],1), 20)}</b>的产品感兴趣：{$t[title]}</a>
                </li>
                {/loop}


            </ul>
        </div>
    </div>
</div>
<!--加盟留言end-->
<!--加盟门店展示-->
<div class="g-row1">
    <div class="m-tit f-dtit">
        <h2 class="u-tt">加盟门店展示</h2> <a href="/news/list.php?catid=501" class="u-more bold fr">更多</a>
    </div>
    <div class="carousel" data-event="scroll" data-mum="5">
        <a href="javascript:" class="prev"><em class="arr"></em></a>

        <div class="m-ilist m-wimg">
            <ul>
                {loop $tags $k $t}
                <li><a href="{$t[linkurl]}" class="u-img" target="_blank">
                    <img src="{imgurl($t[thumb], 1)}"
                         width="210" height="210" alt="{$t[title]}"></a><strong>
                    <a href="{$t[linkurl]}" target="_blank">{$t[title]}</a></strong></li>
                {/loop}
            </ul>
        </div>

        <a href="javascript:" class="next"><em class="ard"></em></a>
    </div>
</div>

<!--加盟门店展示end-->
<!--热门产品 优秀经销商推荐-->
<div class="g-row1">
    <div class="product fl">
        <div class="m-tit f-dtit">
            <h2 class="u-tt">热门产品</h2>
            <a href="/sell/" class="u-more bold fr">更多</a>

        </div>
        <ul class="m-ilist">
            <!--{php $tags=tag("moduleid=21&length=34&&condition=status=3 and level=1 and thumb<>''&order=addtime desc&pagesize=2&template=null");}-->
            {loop $tags $k $t}
            <li><a href="{$t[linkurl]}" class="u-img" target="_blank"><img src="{imgurl($t[thumb], 1)}" width="200" height="172" alt="{$t[title]}">
                <p>{$t[title]}</p></a></li>
            {/loop}
        </ul>
        <ul class="m-list">
            <!--{php $tags=tag("moduleid=5&length=52&showcat=1&condition=status=3 and level>0&order=addtime desc&pagesize=7&template=null");}-->
            {loop $tags $k $t}
            <li><a href="{$t[caturl]}" target="_blank" class="red">[{$t[catname]}]</a> <a href="{$t[linkurl]}" target="_blank">{$t[title]}</a></li>
            {/loop}
        </ul>
    </div>
    <div class="g-7 g-r jxs fr">
        <div class="m-tit f-dtit">
            <h2 class="u-tt" style="padding-left:15px;">优秀经销商推荐</h2>
        </div>
        <div id="jxslist">
            <div class="jxslist lst2">
                <ul class="m-list">
                    <!--{php $tags=tag("moduleid=4&condition=level>0 and catids<>''&areaid=$cityid&pagesize=8&order=vip desc&template=null");}-->
                    {loop $tags $k $t}
                    <li><a href="{$t[linkurl]}" target="_blank">{$t[company]}</a></li>
                    {/loop}
                </ul>
            </div>
        </div>
    </div>
</div>
<!--热门产品 优秀经销商推荐end-->
<!--招商加盟资讯-->
<div class="g-row1">
    <div class="m-tit f-dtit">
        <h2 class="u-tt">招商加盟资讯</h2>
        <a href="/news/" class="u-more bold fr">更多</a>
    </div>
    <div class="hotproduct fl" data-event="carousel">
        <ul>
            <!--{php $ad=tag("table=destoon_ad m,destoon_ad_place c&prefix=&condition=m.pid=c.pid and m.pid='26'&template=null");}-->
            {loop $ad $i $t}
            <li><a href="{$t[image_url]}" target="_blank" rel="nofollow"><img src="{$t[image_src]}" width="510" height="350" alt="{$i+1}">
                <p>{$t[title]}</p></a></li>
            {/loop}
        </ul>
    </div>
    <div class="g-10 zsnews fl">
        <div class="main-news">
            <!--{php $tags=tag("moduleid=21&length=34&showcat=1&catid=379&condition=status=3 and level=5&order=addtime desc&pagesize=1&template=null");}-->
            {loop $tags $k $t}
            <h3>
                <a href="{$t[linkurl]}" rel="nofollow" class="t red" title="{$t[title]}">{$t[title]}</a>
            </h3>
            <p>
                {dsubstr($t[introduce], 178)}...
                <a href="{$t[linkurl]}" class="ckey">【详情】</a>
            </p>
            {/loop}
        </div>
        <ul class="m-list">
            <!--{php $tags=tag("moduleid=21&length=34&showcat=1&catid=379&condition=status=3&order=addtime desc&pagesize=7&template=null");}-->
            {loop $tags $k $t}
            <li><a href="{$t[linkurl]}" target="_blank">{$t[title]}</a></li>
            {/loop}
        </ul>
    </div>
    <div class="g-7 m-w270 fr">
        <div class="m-tit">
            <strong class="u-tt">企业新闻</strong>
        </div>
        <ul class="m-list">
            <!--{php $tags=tag("moduleid=21&length=34&showcat=1&catid=384&condition=status=3&order=addtime desc&pagesize=10&template=null");}-->
            {loop $tags $k $t}
            <li><a href="{$t[linkurl]}" target="_blank">{$t[title]}</a></li>
            {/loop}
        </ul>
    </div>
    <div class="g-30 tab-news">
        <dl class="tab">
            <dt><a href="/news/list.php?catid=380" class="tabIn" rel="nofollow">招商动态</a> <a href="/news/list.php?catid=381" rel="nofollow">加盟宝典</a> <a href="/news/list.php?catid=382" rel="nofollow">终端营销</a></dt>
            <dd>
                <ul class="m-list">
                    <!--{php $tags=tag("moduleid=21&length=34&showcat=1&catid=380&condition=status=3&order=addtime desc&pagesize=9&template=null");}-->
                    {loop $tags $k $t}
                    <li><span class="m-list-r">{date('m-d',$t[addtime])}</span><a href="{$t[linkurl]}" target="_blank">{$t[title]}</a></li>
                    {/loop}
                </ul>
            </dd>
            <dd class="hide">
                <ul class="m-list">
                    <!--{php $tags=tag("moduleid=21&length=34&showcat=1&catid=381&condition=status=3&order=addtime desc&pagesize=9&template=null");}-->
                    {loop $tags $k $t}
                    <li><span class="m-list-r">{date('m-d',$t[addtime])}</span><a href="{$t[linkurl]}" target="_blank">{$t[title]}</a></li>
                    {/loop}
                </ul>
            </dd>
            <dd class="hide">
                <ul class="m-list">
                    <!--{php $tags=tag("moduleid=21&length=34&showcat=1&catid=382&condition=status=3&order=addtime desc&pagesize=9&template=null");}-->
                    {loop $tags $k $t}
                    <li><span class="m-list-r">{date('m-d',$t[addtime])}</span><a href="{$t[linkurl]}" target="_blank">{$t[title]}</a></li>
                    {/loop}
                </ul>
            </dd>
        </dl>
    </div>
</div>
<!--招商加盟资讯end-->
<!--招商易优势-->
<div class="g-row1">
    <dl class="ours g-30">
        <dt>招商易优势</dt>
        <dd class="ico-pb">
            <i class="icon iconfont"></i>
            <strong>品牌展示</strong>
            <p>招商推荐品牌广告</p>
            <p>产品大图，门店风采</p>
            <p>全方位品牌形象展示</p>
        </dd>
        <dd class="ico-cf">
            <i class="icon iconfont"></i>
            <strong>财富信息</strong>
            <p>每周新增<b>200-300条</b></p>
            <p>最新意向代理商信息</p>
            <p>财富信息实时放送</p>
        </dd>
        <dd class="ico-zs">
            <i class="icon iconfont"></i>
            <strong>招商服务</strong>
            <p>精美会员商铺网页</p>
            <p>专属招商专题</p>
            <p>招商信息全方位展示</p>
        </dd>
        <dd class="ico-xw">
            <i class="icon iconfont"></i>
            <strong>新闻服务</strong>
            <p>软文刊登、活动报道</p>
            <p>展会、人物采访</p>
            <p>图文、视频立体展示</p>
        </dd>
        <dd class="ico-pt">
            <i class="icon iconfont"></i>
            <strong>平台资质</strong>
            <p>专注建材<b>十五年</b></p>
            <p>中国TOP100互联网企业</p>
            <p>可信网站认证</p>
        </dd>
    </dl>
</div>
<!--招商易优势end-->
<!--友情链接-->
<div class="g-row1">
    <div class="friendlinks">
        <strong>友情链接：</strong>
        {if $DT[page_text]}
        <!--{tag("table=link&condition=status=3 and level>0 and thumb='' and username=''&areaid=$cityid&pagesize=".$DT['page_text']."&order=listorder desc,itemid desc&template=list-link&cols=9")}-->
        {/if}
    </div>
</div>
{template 'footer'}
