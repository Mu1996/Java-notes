#!/bin/bash bash
echo "1";

your_name='qinjx'
str="Hello, I know your are \"$your_name\"! \n"
echo ${your_name};

your_name="qinjx"
greeting="hello, "$your_name" !"
greeting_1="hello, ${your_name} !"

echo $greeting $greeting_1

string="abcd"
echo ${#string} #输出：4

string="alibaba is a great company"
echo `expr index "$string" is`#输出：8，这个语句的意思是：找出单词is在这名话中的位置

#一个终端输入密码时候，不让密码显示出来的两个例子
#!/bin/bash
read -p "输入密码：" -s pwd
echo
echo password read, is "$pwd"

#!/bin/bash
stty -echo
read -p "输入密码：" pwd
stty echo
echo
echo 输入完毕