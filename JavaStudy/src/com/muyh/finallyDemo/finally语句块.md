#Finally 语句块

## 1.Finally语句块不一定会执行
#### 语句错误 进程中断 
只有与finally相对应的try语句块得到执行的情况下，finally语句块才会执行。
System.exit(0) 方法
当一个线程在执行try语句块或者catch语句块时被打断（interrupted）或者被终止（killed），
与其相对应的finally语句块可能不会执行。
## 2.Finally语句块的执行顺序
#### 在try或者catch中的控制转移语句之前执行
Return／throw／break／continue
Return和throw把控制权交给调用者
Break和continue把控制权在当前的方法内转
移