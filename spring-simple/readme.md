1. 项目01 最简单的一个IOC容器，只包含一个map，里边名称作为key，实例作为value
2. 项目02 在1的基础上扩展，接口包括工厂接口、注册接口、单例接口，抽象类包括抽象工厂类、抽象自动导入工厂类，实体类包括bean定义类、默认单例类、以及最重要的默认工厂类。至此已经可以看出一些设计模式的雏形了，通过抽象类、接口、继承、实现等方式。
3. 项目03 在2的基础上实现了 根据指定参数构造类。添加了构建策略类。