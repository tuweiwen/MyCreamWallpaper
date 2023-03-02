# MyCreamWallpaper
一个在教练的鼓励下开始的Android应用开发项目，由Tomas独立完成。

## 目标
1. 6-12月内初步达到可用级别
2. 尽可能使用Jetpack
3. 规范开发流程
4. ~~多写笔记（~~
5. ~~每天都要有Commit (目前已失败)~~
6. ~~配合项目完善自己的知识体系~~

## 协议
本项目采用MIT协议(`The MIT License`)

---

## 笔记 ~~(流水账日记)~~ 
### 2月21日
今天主要是使用到了`(newHolder.itemView.layoutParams as StaggeredGridLayoutManager.LayoutParams).isFullSpan = true
`这个比较有意思的地方。
> - isFullSpan == true，这个 item 将会充满所有 span，也就是变成 spanCount == 1
>
> - isFullSpan == false, 这个 item 就会根据设置的 spanCount 来摆放位置

之后在涉及到View的样式的时候还是可以多多看一下`LayoutParams`这块的内容，说不准有惊喜。 不过教练也提到叻
> - 草，视图参数里面android作用域的更新很多都要用`layoutParams`的
>
> - kotlin有个拓展函数叫`updateLayoutParams`，需要指定泛型同时传入一个block
>
> - 但是其实不光是width, height要用`layoutParam`来更新，margin也是
>
> - `constriantlayout`布局里面也是用`layoutParam`更新
>
> - 不过有个小坑，最顶层的`LayoutParam`并没有暴露margin参数。有一个单独的`LayoutParam MarginLayoutParam`
>
> - 其实大部分`viewGroup`的`LayoutParam`也是继承自`MarginLayoutParam`就是（
>
> - 然后它以及它的子类才能动态设置margin
>
> - 不过值得一提的是，padding却又不需要通过`LayoutParam`来设置
>
> - 我感觉应该是和父布局相关的参数需要用`LayoutParam`来设置/更新，你可以试试`view.setPadding()`，会有这样的方法
>
> - padding应该是只和这个视图自己有关，所以就没有这样的限定

然后虽然说不鼓励使用`RecyclerView`嵌套，但是好像...还是有时候需要这么写，挺烦的。不过前天终于学会在Rv里面自定义多种样式了，估计搭配一下修改默认`LayoutManager`的一些属性还可以有更多可以调整的地方。

还有第一天为了弄底栏而接触的`Jetpack Navigation`，感觉Google其实提供了很多好东西，可以实现不少现在常用的效果。不过在自己没有学习`compose`之前，估计挺多View控件还是要自己去摸索XML属性去做外观定义。

~~等闲下来了就整理总结一下吧，写个笔记文章之类的。水一篇估计也挺好（如果我没有摸鱼的话）~~


<br/>

### 2月22日 (然而是23日凌晨写的)
今天考试挺糟糕的，虽然知道不会挂科吧，但还是觉得反应出了自己在一些事情上的态度问题。~~嘛，这个再之后单独写篇文章好了~~

重点还是今天的开发上遇到的问题：`Rv`的`item`本身的宽高不一定是固定的。在瀑布流中，`item`本身可能需要对里面的图片或者文字之类的控件的宽高进行限制(写的是固定数值)，而一旦Rv在不同的设备上进行显示的时候，Rv本身的**宽dpi**是不一定的，而`item`宽高用`数值写死 + StaggeredGridLayout对行/列的限制`，会使得列表本身的显示会不完整，或者是出现大片的空白。

> 今天意识到了一个问题，就是item宽度如果写死的话，不同dpi宽度下的设备显示感觉会有点问题（
>
> --摘录自和教练的聊天记录

比较可怕的是，教练把这个当作一个面试模拟的情况来和自己讨论...虽然理智上知道是好事，但是还是很慌。最后教练也委婉的表示说咱的回答可能不一定能过面试~~(叹气)~~。

重点还是在解决问题上，先给出教练提到的最简单最暴力的方法：

> 比如瀑布流里面，item中的图片有固定的宽高比，正好就可以借助`constraintlayout`提供的`app:constrainDimenRatio`属性来设置，让`imageview`的宽高只match constraint，然后通过`dimension ratio`的设置来确定imageview的size
>
> 文字啥的就相对简单多了，确定好`maxLines`然后`wrapcontent`就完事了（
>
> 这样瀑布流的布局就可以在不同尺寸的设备上保证比例的一致了

关于剩下的一些当时讨论的内容，等我睡醒了再继续补充吧。

在这个问题的讨论当中，教练还提到了今天他在面试别人的时候想问有关Rv复用有关的问题。也等醒来一起归纳一下吧（


### 2月25日
摸鱼了大概两天吧，今天也和同学聊了一会儿天，关于毕业之后未来做什么。emmmm，聊完之后看来还是要好好的学习Android方面的东西，估计是没有回头路了吧。~~等哪天有空整理一下自己的学习路线和需求好了（不是怎么老是挖坑）~~

因为前几次写Rv比较多，现在熟练一些了。感觉目前在`Layout`的自适应和`Constraint`上面有那么一点点的感觉了（虽然总觉得好像面试不一定考这个，貌似很多人对这个并不是那么感兴趣）

今天碰到的问题和之前有点关联吧，大概就是在`MyFragment`里面的一个Rv上面想做到前面四个item可以等距离分隔开，最后一个item宽度自定义。但是就在刚刚写下这段话的时候，突然意识到可以把最后一个item不放在`RecyclerView`里面里（因为实际项目里好像这玩意儿一直都在列表的最右边来着...也许...我没猜错吧）

那等我明天起床好好修改一下。之后周末回家也要开始多写代码，不能老是摸鱼了（

虽然是这么说的，但是还是觉得自己的知识没有成体系，还有很多的知识需要重新补齐。虽然说不一定是要像大厂那样那么在乎所谓的“八股文”，但...还是不能太轻视基础知识的重要性的。包括算法之类的东西，有空还是要摸一摸，看一看啥的。

**不过感觉如果又什么都安排上的话，大概率又是什么都学不到吧（摊手**

### 2月26日
今天也是写很少代码的一天。现在手上碰到了几个问题：
1. “我的”页面上应该是用到了`collapsingToolbarLayout`，但是这个效果需要再自己去定义一下，并不是系统默认的那个简单的东东
2. “发现”页面`RecyclerView`和`TabLayout`的响应。这个是没有接触过的东东，但是估计网上可能还是有这种东西。不过Tab应该是重新写过样式了，还得想想看要自己怎么弄。
3. 自己在电脑上跑的时候已经偶尔会有ANR的情况了，不知道是不是因为我本身8G的内存导致模拟器给不了太大内存导致的...（不过Rv嵌套好像是据说会大量占用内存啥的，但是教练他的成品好像在虚拟机跑的时候并没有ANR过，所以...目前还不知道原因是什么）

目前来看，可能还是第二点比较容易先处理掉一些内容，虽然自定义样式这个没有接触过，但是响应的这块儿还是可以比较简单的处理吧。明天手上还有两个电工的实验报告要写，下个礼拜也要开始考虑和补修的课程老师联系一下了。应该说这学期真正忙碌的时候要开始了，大概要给自己要求一下做事情要落到实处吧，不然又荒废一学期真的不行。这个学期还是很重要的，太多事情等着我处理了。嗯，好好给自己打个气。~~希望不要再焦虑下去，要坚持住（~~

~~上面的问题明天也再问一下教练吧，应该可以再学习到一点（逃~~

### 2月27日
看了消息机制(`Handler`之类的)和一小部分事件分发(`TouchEvent`)的东东，感觉有点脑子不够用。消息处理这块儿感觉还是要再配上一点多线程相关的东西。但是说实话，写代码也有几千行了，还真的没有好好的尝试过写多线程的东东，感觉还是要自己再尝试一下。然后之后学习完的内容还是通过日记来画个提纲吧，以防自己忘记，定期复习起来应该会有不错的效果。~~（天知道能不能做到~~

1. Event-Dispatch(md笔记)
2. message-mechanism(md笔记)
3. ThreadPool(Android进阶之光)
4. tabLayout(setScrollPosition, addOnTabSelectedListener)
5. RecyclerView(setOnScrollChangeListener, findFirstVisibleItemPosition, **smoothScrollToPosition**)
 
最后那个`smoothScrollToPosition`简单的阅读了一下源码，但是还没有完全弄明白。但是这个的看起来已经比下午看的Handler什么的轻松太多了。争取明天再弄懂这个吧。

今天其实总体还是可以的，但是依旧浪费了不少的时间，所以效率还是要继续提高一点。明天想看看网络框架方面(Rx和Retrofit之类的)，然后顺带加强一下多线程还有Kotlin的`coroutine`，挺重要的。（草，突然想起来之前看的扔物线的launchMode的视频还没有做总结，里面`singleTask`和`singleInstance`还是有点错乱...）

晚上早睡早起吧，少玩手机（

### 2月28日
上课也在看昨天没看明白的源码，下课了之后中午和下午也在看，到三点多才读完将近一半。然而最关键的部分还没看懂...真的是太菜了（哭

最后的结果就是今天项目上基本什么都没做，还花了一大半的时间在研究`Anim`和`Transition`到底哪个能用来做一个简单的Activity切换的效果，服了我自己。不过也再次感受到了中文内容和英文内容的差距，还是要锻炼自己英语阅读文档和网页的能力，挺重要的。

大概明天要好好看一下本来想在今天看的内容吧，主要是郭神的书里面的**多线程和Service**的内容。（然而写下这段文字的时候已经是3月1日了，白天还要陪超超去修手机，打算翘个课看看）

缺乏的内容太多了，感觉明天可以再试着给自己列个MindMap，对着书和网上的一些内容再做做总结。啊对了，之前的字节青训营的内容也还没有补完...好多坑，呜呜呜

今天的唯一有效输出，就是在掘金上发了篇翻译StackOverflow的问答吧。相比前几天真的是越来越少了，得好好改进一下。不过睡觉玩手机还是有改善的，夸夸自己w

该睡了，晚安！

### 3月1日
很神奇，这几天的日记都是等到第二天凌晨才来写的。~~不知道算不算是某种意义上的拖延症（逃~~
陪超超去修了下手机，花了大半天的时间。中间腾了一miumiu的零碎时间复习Java的`Collection`这块的内容，虽然也就...大概的范围，并没有很细致。

回南昌之后第一次翘课 ~~（哦好像不对，还有一次睡过头错过上课）~~，也是很奇妙的感觉。路上和超超聊了挺多的事情，再一次认识到自己还是很喜欢情绪输出，发现自己依旧有着把自己的情感托付给别人的习惯。嘛，只能说再继续改了。不过这些都是后话，也不能算是开发日记的重点 ~~（欸，写了这么多才发现吗？~~

Java集合这块挺多的方法和实现类，但是真正常用的也就那么些。目前看到的复习资料上也其实没怎么提线程安全这块的内容，凭着自己的好奇去查了下，意识到`ArrayList`和`LinkedList`等一大票并不是线程安全，基本上就`vector`，`stack`，`hashtable`和`enumeratio`n是安全的。

而线程安全主要是三个点：原子性，可见性和有序性。这个应该是在前两天看进阶之光里面的多线程的时候有提到的。这本书里第四章有提到这块的内容，下次还是要多写点笔记出来，提取精华内容方便记忆。虽然看得多，但是不去写下来的话，光靠脑子还是容易忘记啊...（突然想到去年这个时候网申飞书的日常实习，都是血和泪的教训啊）

说到笔记，今天还是用平板记了一下集合大概的类继承图，还有看第一行代码时候写了一半的内容。不过还好，这部分的内容自己用MD做了笔记，也挺不错的。就是昨天看的源码今天也没有继续处理了，大概真的是因为不愿意去看了吧（毕竟需求解决了）。

自己主动看书和阅读的部分大概就这些吧，接下来回顾一下写代码遇到的坑...

首先最疑惑的地方就是之前花了大半天想要实现的`Activity`切换Slide覆盖动画。莫名奇妙的就有了我想要的效果，之前还花费了好半天才做到了一半想要的样式。（其实今天又差点花一大堆的时间在这个上面...)

再一个，就是想解决`Toolbar`的问题。查了一堆的文章，CSDN和掘金上都看了不少，基本上都是很老的内容。更悲剧的是，我看下来都是没有很大帮助的。只能从垃圾堆里一点点刨出想要的东西：
- Toolbar是替代ActionBar的。如果想在代码中像ActionBar一样对Toolbar进行部分操作，可以使用`supportActionbar(Toolbar)` / `getActionbar()`
- 在`androidx`和`android`包下各有一个toolbar的实现，但是网络上的内容大多都是针对前者的 ~~（甚至还有support v7包...）~~
- Toolbar也可以像Actionbar一样插入菜单，并且设置菜单项的监听
- Toolbar本质是`ViewGroup`，所以可以在中间插入任何自己想要的`View`

其实最后这一点就是困扰了我一个多小时的东西。当时想实现图片详情页的菜单栏，但是发现按下去的时候没有Bottom的阴影动画。所以一开始就一直在想怎么处理这个，甚至想着要不自己重写一下Toolbar类里面的菜单的style属性（因为发现菜单项貌似是`ImageBottom`，而且也查到了用什么style属性可以去除）。

后来突然意识到是不是可以像网上一些自定义居中`TextView`一样，去做类似的处理。但是一开始在写的时候完全忘记了要怎么样去排列view的位置，甚至因为外面的rooe view是`constraintLayout`所以想直接去写`constratRight_ToRightOf`属性...结果发现，好像直接用`layout_gravit`y就可以。

实在是佩服自己傻得可以 ~~（扶额）~~

反正今晚的小问题算是解决了吧，明天针对项目这块的话，打算弄一下点击更多按钮的弹出菜单。目前来看，感觉像是用`CustomDialog`写的。但是目前还不太确定，到时候再试试看吧。

然后是看书的内容，进阶之光就再做一下多线程编程章节的笔记，剩下的要不就试试看网络编程这块吧。尤其是框架这块，感觉也可以再了解一下。今天好好的对着郭神的书和网上的笔记和其他的一些内容看了下，那本书真的就是一个帮助你建立框架的入门书记，高阶的东西还是要自己去寻找一些更好的文章或者书籍再去建立基础。

最后还有一个，把掘金上的内容顺带的也发布到了CSDN上。对比完之后发现...掘金的体验确实要纯粹一些，而且不少内容要好一点点。只能说，确实差距很大。CSDN还是太...本土化了，掘金就相对的互联网一点。

趁着这段时间课少，还是要多努努力。一点一点来，克服焦虑，充实自己的知识库。噶油！

### 3月2日
我靠，属实是没想到居然开始断电了...本来前几天一直没有断电，还以为这学期开始不会再断了。虽然是情理之中，但还是在意料之外。只能说，以后一定要在12点之前处理完所有事情了。

原本今天还打算花点时间**把图片详情页的部分**多写一些的，看来只能等睡醒之后去处理。悲（x

今天主要还是把之前在进阶之光里面的**多线程**的内容再读了一遍，好好的整理了一部分笔记。但是多线程完全弄懂真的还是挺花功夫，今天看了一大半时间还只是读了一半的内容。晚上安慰了焦虑的凯子之后，原本的一些时间也无了。其实本来下午两点多的时候也是可以再学习一会儿的，可惜用去摸鱼了...虽然说还是要劳逸结合吧，但还是有点不甘心。

因为很多事情不可能是在主线程上一口气就全部就做完的，所以一些耗时间的操作都需要我们自己手动去开启线程去操作。
- 继承`Thread`类
- 实现`Runnable`接口
- 实现`Callable`接口

开启线程后，对部分需要在不同线程中进行共享的数据和对象，要做同步和加锁，以保证数据的安全。
- `volatile` -> 将变量的数据进行及时更新，保证数据一致性和可见性
- 同步方法 -> 对方法中的资源进行保护，避免竞争；自动释放
- 同步代码块 -> 对代码块中的资源进行保护，避免竞争；手动配置需要上锁的对象，自动释放
- 重入锁+条件对象 -> 当不满足条件时自动释放锁并阻塞线程；手动上锁和释放

再一个就是collection的`HashMap`，顺带还复习了一下Hash的处理方法 ~~（话说没想到这玩意儿居然是在util包里）~~
- Java 1.8开始使用数组+链表(红黑树)，每次将map放进数组前需要对`k.hashCode`进行hash计算下标（二次hash，减少碰撞），之后保存为Node并放入数组中。当发生碰撞后，就使用链表将数据向后存放；当链表长度大于8后就改为使用红黑树。
- 有两个关键参数：capacity和load factor。默认长度为16，比例是0.75。当使用了12个下标后，就将长度拓展为2n（也就是16），
- get()每次从数组第一个进行查询，如果命中就直接返回；没命中就判断数组后面是否有链表/红黑树，并进去查找；再没找到，就换数组的下一个进行查询

对于Android开发本身相关的内容，今天其实并没有怎么看。和教练在晚上沟通的时候意识到实习方面还是重点在Android开发上，像是算法和Java、计算机网络八股等等并没有那么的重要。虽然算法方面我不意外，但还是担心像其他的基础内容会不会有影响。不过细想一下也是有一定道理的，确实也应该稍微把复习的内容做点微调。明天 ~~（实际上写的时候已经是“明天”了233333）~~ 开始复习一下
**fragment和ContentProvider**的内容 ~~（其实本来是今天想要看的...）~~ 吧，顺带看一看之前复习过的**Handler和Service**的使用（按照郭神书上的内容来看，这也算是Android多线程相关的内容。不过我还是觉得`coroutine`更重要一点，也更加接近kotlin中的多“线程”）。

还是那句话吧，不能太贪心，但是也不能没有要求。上午九点半还约了宝莱他们寝室一起去看来学院春招的企业，也不知道自己到底是个什么情况。嘛，随缘吧。

但行好事，莫问前程

---

剩下的随缘补充...