<h1 align="center"><a href="https://github.com/mrdjun" target="_blank">Fun-Generator</a></h1>
<p align="center">
<a href="https://github.com/mrdjun/fun-boot"><img alt="JDK" src="https://img.shields.io/badge/JDK-1.8-orange.svg"/></a>
<a href="http://mrdjun.github.io"><img alt="Author" src="https://img.shields.io/badge/Author-DJun-blue"/></a>
<a href="https://jq.qq.com/?_wv=1027&k=57LIuZr"><img alt="QQ群" src="https://img.shields.io/badge/chat-Coder%E5%A4%A7%E5%AE%B6%E5%BA%AD-yellow"/></a>
<a href="https://github.com/mrdjun/fun-generator/blob/master/LICENSE"><img alt="license" src="https://img.shields.io/github/license/java-aodeng/hope.svg?style=flat-square"/></a>
</p>
# 简介

> Powered By [xxl-code-generator](http://www.xuxueli.com/xxl-code-generator/#/).

> 🍋个人博客：mrdjun.github.io

> 🍊地址：https://github.com/mrdjun/fun-generator 主语言[java] 欢迎star
------------------------------
### 项目说明
- 还在为不会写代码生成工具而发愁吗？此项目既供学习又供使用。

- 目的：极大的增强代码生成工具的可移植性，走到哪儿用到哪儿🍻

- 这是从 [xxl-code-generator](http://www.xuxueli.com/xxl-code-generator/#/) 分离出来的项目.

### 使用说明

- 可根据项目的需要，量身定制一套代码生成工具，虽然不能生成list.html、add.html、edit.html。因为俺也不清楚大家是用的啥模板引擎，啥UI。所以你可以根据示例，自行安排一套属于您自己的。

- 启动项目之后访问：localhost:8888/ 即可进入代码生成界面，将sql放入输入框即可生成。

- 为什么不一次自动生成全部表的代码？
  <pre>
  原因待我细细道来：
     ① 我们在开发的过程中，大家都知道数据库都是难免会更改字段的，一般小公司是没有dba的，
  所以这个情况免不了🙃。一次生成一张表的代码，可以极大的降低耦合性与修改的不便性。就算
  修改单张表的字段后，即可针对这个马上重新生成代码来覆盖之前的代码。
     ② 不用连接数据库。
     ③ 使用sql生成的原因是为了方便结合Flyway，使之更为便捷。
  </pre>

