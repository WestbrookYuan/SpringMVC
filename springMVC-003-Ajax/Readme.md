# SpringMVC Ajax

### action方法的返回值

1. String：客户端资源的地址，自动拼接前缀和后缀。还可以屏蔽自动拼接字符串，可以指定返回的路径
2. Object：返回json格式的对象，自动将对象或集合转为json，使用的Jackson工具进行转换，必须添加依赖。一般用于Ajax请求
3. void：无返回值，一般用于Ajax请求
4. 基本数据类型：用于Ajax请求
5. model和view：返回数据和视图



### 实例：完成Ajax请求访问服务器，返回学生集合

1. 添加Jackson依赖
2. 新建js目录，添加JQuery函数库
3. 在index.jsp页面上导入函数库
4. 在action添加@ResponseBody，用来处理Ajax请求
5. 添加注解驱动\<mvc:annotationdriven/\>，用来解析ResponseBody注解