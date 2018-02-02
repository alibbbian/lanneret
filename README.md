* 标准maven工程
* linux下，目录结构。运行gofly.sh，会解压weijiaoyi-1.0-SNAPSHOT.jar到classes文件夹，更新jar包时，需要手动删除classes文件夹
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
    - weijiaoyi-1.0-SNAPSHOT.jar
</pre>
* window启动关闭脚本需二次编写
<pre>
    指定 HOME_PATH 和 lib目录的位置
</pre>
