* maven工程
* 在your.jar中，编写实现接口com.bird.lanneret.core.Server的类，写入启动需要执行的代码
* linux下，目录结构。运行./bin/gofly.sh your.jar，会解压your.jar到classes文件夹，更新jar包时，需要手动删除classes文件夹
<pre>
    + bin
        - build.bat
        - fly.sh
        - gofly.sh linux启动脚本
        - land.sh linux关闭脚本
        - gofly.bat win启动脚本
        - land.bat win关闭脚本
    + lib
        - lanneret.jar
    + logs
        - battleplane.log
    + classes
    - your.jar
</pre>
* window启动关闭脚本需二次编写
<pre>
    指定 HOME_PATH 和 lib目录的位置
</pre>
