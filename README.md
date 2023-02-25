# MyCreamWallpaper
一个在教练的鼓励下开始的Android应用开发项目，由Tomas独立完成。

## 目标
1. 6-12月内初步达到可用级别
2. 尽可能使用Jetpack
3. 规范开发流程
4. ~~多写笔记（~~
5. ~~每天都要有Commit~~

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

---

剩下的随缘补充...