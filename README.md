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
> isFullSpan == true，这个 item 将会充满所有 span，也就是变成 spanCount == 1 
> 
> isFullSpan == false, 这个 item 就会根据设置的 spanCount 来摆放位置

之后在涉及到View的样式的时候还是可以多多看一下`LayoutParams`这块的内容，说不准有惊喜。 不过教练也提到叻
> 草，视图参数里面android作用域的更新很多都要用layoutParams的
> 
> kotlin有个拓展函数叫updateLayoutParams，需要指定泛型同时传入一个block
> 
> 但是其实不光是width height要用layoutParam来更新，margin也是
> 
> constriantlayout布局里面也是用layoutParam更新
> 
> 不过有个小坑，最顶层的LayoutParam并没有暴露margin参数。有一个单独的LayoutParam MarginLayoutParam
> 
> 其实大部分viewGroup的LayoutParam也是继承自MarginLayoutParam就是（
> 
> 然后它以及它的子类才能动态设置margin
> 
> 不过值得一提的是，padding却又不需要通过LayoutParam来设置
> 
> 我感觉应该是和父布局相关的参数需要用LayoutParam来设置/更新，你可以试试
> 
> view.setPadding()，会有这样的方法
> 
> padding应该是只和这个视图自己有关，所以就没有这样的限定

然后虽然说不鼓励使用`RecyclerView`嵌套，但是好像...还是有时候需要这么写，挺烦的。不过前天终于学会在Rv里面自定义多种样式了，估计搭配一下修改默认`LayoutManager`的一些属性还可以有更多可以调整的地方。

还有第一天为了弄底栏而接触的`Jetpack Navigation`，感觉Google其实提供了很多好东西，可以实现不少现在常用的效果。不过在自己没有学习`compose`之前，估计挺多View控件还是要自己去摸索XML属性去做外观定义。

~~等闲下来了就整理总结一下吧，写个笔记文章之类的。水一篇估计也挺好（如果我没有摸鱼的话）~~

---

剩下的随缘补充...